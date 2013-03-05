package org.qualitune.tracing.atl;

/***
 * does administrative stuff, all real action happens in Atl2Umt (and Atl2UmtContentAdapter, which is called from
 * there)
 */
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.util.VUtil;
import org.qualitune.tracing.vapodi.IConcreteLanguageHandler;

/* general infrastructure */

public class AtlHandler implements IConcreteLanguageHandler {
	private enum AtlHandlerInnerState {
		INITIALISED, MODEL_LOADED, VAPODI_MERGED
	}
	
	private AtlParser atlInjector;
	
	private ModelFactory modelFactory = null;
	private IReferenceModel atlMetamodel;
	private EMFModel atlModel = null;
	private Resource atlResource = null;
	private EObject atlModule = null;
	
	private Program program = null;
	
	private AtlHandlerInnerState innerState; // inner state of the class; used assure correct usage
	
	protected String VAPODI_ATL_BASE_STUB = "atl_lib/vapodi_base_stub.atl";
	
	public AtlHandler() {
		atlInjector = new AtlParser();
		
		atlMetamodel = atlInjector.getAtlMetamodel();
		modelFactory = atlInjector.getModelFactory();
		
		innerState = AtlHandlerInnerState.INITIALISED;
	}
	
	public boolean loadModel(String path) {
		if (innerState != AtlHandlerInnerState.INITIALISED) {
			VUtil.myExit("loadModel has been called on an AtlHandler that is in state " +
					innerState + ", expecting it to be in state INITIALISED. (Did you try " +
					"to load a second model? Create a new AtlHandler instance for this purpose.)");
		}
			
		try {
			atlModel = (EMFModel) modelFactory.newModel(atlMetamodel);	
			atlInjector.inject(atlModel, path);
		} catch (ATLCoreException e) {
			VUtil.myExit("Error while loading ATL model from " + path + ".");
		}

		atlResource = atlModel.getResource();
		atlModule = atlResource.getContents().get(0);

		// now let's incite building of the UMT representation
		Atl2Umt converter = new Atl2Umt(atlMetamodel);
		program = converter.module2program(atlModule);
		// TODO listener added as last step in last instruction -> will collide with mergeInBaseStub
		
		
		innerState = AtlHandlerInnerState.MODEL_LOADED;
		
		mergeInBaseStub(atlModule);
		
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
		if (innerState != AtlHandlerInnerState.MODEL_LOADED) {
			VUtil.myExit("loadModel has been called on an AtlHandler that is in state " +
					innerState + ", expecting it to be in state MODEL_LOADED.");
		}
		
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
		
		innerState = AtlHandlerInnerState.VAPODI_MERGED;
	}
	
	public Program getUmtRepresentation() {
		if (innerState != AtlHandlerInnerState.VAPODI_MERGED)
			VUtil.myExit("Can't give UMT representation without having loaded an ATL model " +
					"before.");
		
		 
		
		if (program == null)
			System.out.println("[Vapodi] Warning: UMT representation is null. Likely something " +
					"has went wrong earlier while loading the ATL program.");
		
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
	
/* Jan's examples */
	
	
//		EClass mcModule = (EClass) atlMetamodel.getMetaElementByName("Module");
//		EStructuralFeature attName = mcModule.getEStructuralFeature("name");
//		mcModule.getEStructuralFeature(featureID)
		


			// laden wenn model existiert
			//			ResourceSet rs = new ResourceSetImpl();
			//			URI uri = URI.createFileURI("..");
			//			Resource resource2 = rs.getResource(uri, true);
			//			EObject model = resource2.getContents().get(0);
			//			
			//			// erzeugen wenn nicht
			//			Resource resource3 = rs.createResource(uri);
			//			EObject module = EcoreUtil.create(mcModule);
			//			resource3.getContents().add(module);
//			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
//			
//			try {
//				resource3.save(null);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
}
