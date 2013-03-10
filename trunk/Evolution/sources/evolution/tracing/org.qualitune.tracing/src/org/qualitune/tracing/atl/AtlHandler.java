package org.qualitune.tracing.atl;

/***
 * does administrative stuff, all real action happens in Atl2Umt (and Atl2UmtContentAdapter, which is called from
 * there)
 */
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.qualitune.tracing.atl.ATL.ATLPackage;
import org.qualitune.tracing.atl.ATL.Module;
import org.qualitune.tracing.atl.OCL.OclModelElement;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.UmtFactory;
import org.qualitune.tracing.util.VUtil;
import org.qualitune.tracing.vapodi.IConcreteLanguageHandler;

/* general infrastructure */

public class AtlHandler implements IConcreteLanguageHandler {
	
	private enum AtlHandlerInnerState {
		INITIALISED, MODEL_LOADED
	}
	
	private AtlParser atlInjector;
	
	private ModelFactory modelFactory = null;
	private IReferenceModel atlMetamodel;
	EMFModel atlModel = null; 
	
	
	private Program program = null;
	
	private AtlHandlerInnerState innerState; // inner state of the class; used assure correct usage
	
	protected String VAPODI_ATL_BASE_STUB = "atl_lib/vapodi_base_stub.atl";
	
	protected Logger logger = null;
	private boolean keepTmpFile = true;//false;
	
	public AtlHandler() {
		logger = Logger.getLogger(AtlHandler.class);
		
		atlInjector = new AtlParser();
		
		atlMetamodel = atlInjector.getAtlMetamodel();
		modelFactory = atlInjector.getModelFactory();
		
		innerState = AtlHandlerInnerState.INITIALISED;
	}
	
	protected EObject loadAtlModel(String path) {
		Resource atlResource;
		EObject atlModule;
		
		try {
			atlModel = (EMFModel) modelFactory.newModel(atlMetamodel);	
			atlInjector.inject(atlModel, path);
			
		} catch (ATLCoreException e) {
			logger.error("Error while loading ATL model from " + path + ".");
			System.exit(1);
		}

		atlResource = atlModel.getResource();
		atlModule = atlResource.getContents().get(0);
		
		// now let's incite building of the UMT representation
		// TODO ?? listener added as last step in last instruction -> will collide with mergeInBaseStub
		
		return atlModule;
	}
	
	protected List<EObject> getMetaModels(EObject atlModule) {
		LinkedList<EObject> ret = new LinkedList<EObject>();
		
		for (EObject inModel : VUtil.getRefCollection(atlModule, "inModels")) {
			EObject metaModel = VUtil.getRefTarget(inModel, "metamodel");
			ret.add(metaModel);
		}
		
		for (EObject outModel : VUtil.getRefCollection(atlModule, "outModels")) {
			EObject metaModel = VUtil.getRefTarget(outModel, "metamodel");
			ret.add(metaModel);
		}
		
		return ret;
	}
	
	protected List<EObject> getTypeElements(EObject atlModule) {
		List<EObject> ret = new LinkedList<EObject>();
		
		TreeIterator<EObject> it = atlModule.eAllContents();
		
		while (it.hasNext()) {
			EObject element = it.next();
			if (VUtil.typeName(element).equals("OclModelElement")) {
				ret.add(EcoreUtil.copy(element));
			}
		}
		return ret;
	}
	/**
	 * Collects OclModel(Elements) referenced by atlModule 
	 * @param atlModule
	 * @return
	 */
	protected List<EObject> getReferedOclModels(EObject atlModule) {
		List<EObject> ret = new LinkedList<EObject>();
		
		TreeIterator<EObject> it = atlModule.eAllContents();
		
		while (it.hasNext()) {
			EObject element = it.next();
			String typeName = VUtil.typeName(element);
			
			if (typeName.equals("OclModel")) {
				logger.debug("found source or destination model");
				ret.add(VUtil.getRefTarget(element, "metamodel"));
			} else if (typeName.equals("OclModelElement")) {
				logger.debug("found OclModelElement");
				ret.add(VUtil.getRefTarget(element, "model"));
			}
		}

		return ret;
	}
	
	/**
	 * not needed? We once ran into a printer problem
	 * @param atlModule
	 * @return
	 */
	private List<EObject> getReferedVariables(EObject atlModule) {
		final String refVarsRefName = "referredVariable";
		
		List<EObject> ret = new LinkedList<EObject>();

		TreeIterator<EObject> it = atlModule.eAllContents();

		while (it.hasNext()) {
			EObject element = it.next();
			
			if (VUtil.hasReference(element, refVarsRefName)) {
				EObject copy = EcoreUtil.copy(VUtil.getRefTarget(element, refVarsRefName));
				ret.add(copy);
				//VUtil.setReference(element, refVarsRefName, copy);
				
				//VUtil.unSetReference(element, refVarsRefName);
				//EReferenc
				
				logger.debug("found referred variable of " + VUtil.typeName(element) +
						" @ " + VUtil.getStringAttributeValue(element, "location"));
				//VUtil.printEObject(copy);
				//VUtil.printEObject(VUtil.getRefTarget(element, refVarsRefName));
			}
		}

		return ret;
	}
	
	protected void saveAtlXmi(EObject atlModule, String path) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("atl_xmi", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createURI(path));

		resource.getContents().add(atlModule);
		
		// TODO just as a marker; if anything is b0rken in model, here's tea point to add a fix
		// fix ugly (non-)containment in ATL's original metamodel
		resource.getContents().addAll(getReferedOclModels(atlModule));
		resource.getContents().addAll(getTypeElements(atlModule));
		//resource.getContents().addAll(getReferedVariables(atlModule));

		try {
//			doesn't help:
			//Map<Object,Object> options = new HashMap<Object,Object>();
//			options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF,XMLResource.OPTION_PROCESS_DANGLING_HREF_RECORD);
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void showWarnings(Resource res) {
		for (Diagnostic diag : res.getWarnings()) {
			logger.warn("resource warning: " + diag.getMessage());
		}
	}
	protected Module loadAtlXmiModel(String path) {
		ATLPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("atl_xmi", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(path), true);
		
		Module module = (Module) resource.getContents().get(0);
		showWarnings(resource);
		
		return module;
	}
	
	protected String makeTempPath(String base, String extension) {
		File tmp = null;
		try {
			tmp = File.createTempFile(base, extension);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp.getAbsolutePath();
	}
	
	public boolean loadModel(String atlPath) {
		if (innerState != AtlHandlerInnerState.INITIALISED) {
			VUtil.myExit("loadModel has been called on an AtlHandler that is in state " +
					innerState + ", expecting it to be in state INITIALISED. (Did you try " +
					"to load a second model? Create a new AtlHandler instance for this purpose.)");
		}
		
		EObject atlModule = loadAtlModel(atlPath);
		
		
		String atlXmiPath = makeTempPath("vapodi_tmp_",".atl_xmi");
		logger.debug("Saving temporary XMI representation of ATL module to " + atlXmiPath);
		saveAtlXmi(atlModule, atlXmiPath);
		Module module = loadAtlXmiModel(atlXmiPath);
		
		if (! keepTmpFile)
			new File(atlXmiPath).delete();
		
		
		
		Atl2Umt converter = new Atl2Umt(module);
		program = converter.getProgram();
		
		// TODO inb copy in referredVariables etc. as we did when loading original ATL program
		mergeInBaseStub(atlModule);
		
		innerState = AtlHandlerInnerState.MODEL_LOADED;
		
		return true;
	}
	
	
	
	/**
	 * Moves *references* from srcModule to destModule. 
	 * 
	 * Use case here:
	 * As ATL libraries may only consist of helpers (and only state-less helpers, not of attribute helpers which
	 * mimic global variables) all the general VAPODI infrastructure has to be merged into the original program.
	 * 
	 */
	protected void mergeAtl(EObject destModule, EObject srcModule) {
		assert(VUtil.typeName(destModule).equals("Module"));
		assert(VUtil.typeName(srcModule).equals("Module"));
		
		// TODO double names (destModule element has same name as one from srcModule)
		
		for(EReference ref : srcModule.eClass().getEAllReferences()) {
			if (srcModule.eIsSet(ref)) {
				@SuppressWarnings("unchecked")
				List<EObject> copyOfSrcRefs = new LinkedList<EObject> ( (List<EObject>) srcModule.eGet(ref) );
				
				for (EObject e : copyOfSrcRefs) {
					if (! (VUtil.hasAttribute(e, "name") && VUtil.getStringAttributeValue(e, "name").equals("alibi"))) {
						VUtil.unSetAttribute(e, "commentsBefore");
						VUtil.unSetAttribute(e, "commentsAfter");
						// to remove (duplicate) comments within functions as well, one had to traverse e to lowest level

						if (! destModule.eIsSet(ref)) {
							// TODO uninitialised target properties
							VUtil.warning("mergeAtl: uninitialised target property might lead to program shutdown.");
						}
						VUtil.addtoReference(destModule, ref, e);
					}
				}
			}
		}
	}
	
	protected void mergeInBaseStub(EObject atlModule) {
		assert(VUtil.typeName(atlModule).equals("Module"));
		
		// to find out: do I need a separate model factory for this purpose?
		
		String path = VAPODI_ATL_BASE_STUB;
		EMFModel atlModelToMergeIn = null;
		
		try {
			atlModelToMergeIn = (EMFModel) modelFactory.newModel(atlMetamodel);	
			atlInjector.inject(atlModelToMergeIn, path);
		} catch (ATLCoreException e) {
			VUtil.myExit("Error while loading ATL file which holds VAPODI base stub (think: library) from " + path + ".");
		}

		Resource atlResourceToMergeIn = atlModelToMergeIn.getResource();
		EObject atlModuleToMergeIn = atlResourceToMergeIn.getContents().get(0);
		
		mergeAtl(atlModule,atlModuleToMergeIn);
	}
	
	public Program getUmtRepresentation() {
		if (innerState != AtlHandlerInnerState.MODEL_LOADED)
			VUtil.myExit("Can't give UMT representation without having loaded an ATL model before.");
		
		if (program == null)
			logger.error("UMT representation is null. Likely something went wrong earlier while loading the ATL program.");
		
		return program;
	}

	public boolean writeModel(String path) {
		try {
			// accepts map<String,object> as last options parameter - fine-tune tabs?
			atlInjector.extract(atlModel, path);
		} catch (ATLCoreException e) {
			System.err.println("[Vapodi] Error while storing ATL model to " + path + ".");
			e.printStackTrace();
			System.exit(1);
			return false; // in case we alter error behaviour
		}
		return true;
	}
}
