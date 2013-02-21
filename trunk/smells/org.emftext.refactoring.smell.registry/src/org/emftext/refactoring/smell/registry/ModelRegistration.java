package org.emftext.refactoring.smell.registry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.viatra2.patternlanguage.eMFPatternLanguage.PatternModel;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

@SuppressWarnings("restriction")
public class ModelRegistration {

	public static final String SMELL_PLUGIN_ID		= "org.emftext.refactoring.smell.registry";
	private static final String SMELL_MODEL_NAME	= "smellmodel.smell";
	private static final String CALC_MODEL_NAME		= "registered.calculation";

	@PostConstruct
	public void register(IEclipseContext context, IWorkspace workspace, IExtensionRegistry registry) {
		registerCalculationExtensions(context, registry, workspace);
		QualitySmellModel smellModel = registerQualitySmellModel(context, workspace);
		workspace.addResourceChangeListener(new SmellChecker(smellModel), IResourceChangeEvent.POST_CHANGE);
	}

	private void registerCalculationExtensions(IEclipseContext context, IExtensionRegistry registry, IWorkspace workspace) {
		CalculationModel calculationModel = initCalculationModel(registry, workspace);
		context.set(CalculationModel.class, calculationModel);
		//		this.calculationModel = calculationModel;

		// OSGi service registration
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		bundleContext.registerService(CalculationModel.class, calculationModel, null);
	}

	private CalculationModel initCalculationModel(IExtensionRegistry registry, IWorkspace workspace) {
		CalculationModel calculationModel = createCalculationModel(workspace);
		if(registry != null){
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ICalculationExtensionPoint.ID);
			if(elements != null){
				for (IConfigurationElement element : elements) {
					if(element.getName().equals(ICalculationExtensionPoint.METRIC_CALCULATION)){
						try {
							Calculation calculation = (Calculation) element.createExecutableExtension(ICalculationExtensionPoint.CALCULATION_CLASS);
							if(calculation != null){
								calculation.setName(calculation.getName());
								calculation.setDescription(calculation.getDescription());
								calculation.setMonotonicity(calculation.getMonotonicity());
								calculation.setSmellMessage(calculation.getSmellMessage());
								calculationModel.getCalculations().add(calculation);
							}
						} catch (CoreException e) {
							System.err.println("No public constructor for class " + element.getAttribute(ICalculationExtensionPoint.CALCULATION_CLASS));
						}
						
						//					IContributor contributor = element.getContributor();
						//					Bundle bundle = Platform.getBundle(contributor.getName());
						//					Enumeration<URL> entries = bundle.findEntries("/", "*.genmodel", true);
						//					while (entries.hasMoreElements()) {
						//						URL url = (URL) entries.nextElement();
						//						try {
						//							InputStream stream = url.openStream();
						//							URI uri = URI.createURI(url.getFile());
						//							ResourceSet rs = new ResourceSetImpl();
						//							Resource resource = rs.createResource(uri);
						//							resource.load(stream, null);
						//							GenModel genmodel = (GenModel) resource.getContents().get(0);
						//							if(genmodel != null){
						//								GenClass genClass = getGenClassForName(genmodel, element.getAttribute(ICalculationExtensionPoint.CALCULATION_CLASS));
						//								if(genClass != null){
						//									EClass eClass = genClass.getEcoreClass();
						//									Calculation calculation = (Calculation) EcoreUtil.create(eClass);
						//									if(calculation != null){
						//										calculation.setName(calculation.getName());
						//										calculation.setDescription(calculation.getDescription());
						//										calculation.setMonotonicity(calculation.getMonotonicity());
						//										calculation.setSmellMessage(calculation.getSmellMessage());
						//										model.getCalculations().add(calculation);
						//									}
						//								}
						//							}
						//						} catch (IOException e) {
						//							e.printStackTrace();
						//						}
						//					}
					} else if(element.getName().equals(ICalculationExtensionPoint.STRUCTURE_CALCULATION)){
						String patternResource = element.getAttribute(ICalculationExtensionPoint.PATTERN_RESOURCE);
						Bundle bundle = Platform.getBundle(element.getContributor().getName());
//						URL resourceUrl = bundle.getResource(patternResource);
						URI uri = URI.createPlatformPluginURI(bundle.getSymbolicName() + "/" + patternResource, true);
						ResourceSet rs = new ResourceSetImpl();
						Resource resource = null;
						try {
							resource = rs.getResource(uri, true);
						} catch (Exception e) {
							// do nothing --> no EMF resource
						}
						if(resource != null){
							EObject model = resource.getContents().get(0);
							if(model instanceof PatternModel){
								PatternModel pattern = (PatternModel) model;
							}
						}
					}
				}
			}
		}
		try {
			Map<String,Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			calculationModel.eResource().save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return calculationModel;
	}

//	private GenClass getGenClassForName(GenModel genmodel, String attribute) {
//		List<GenPackage> genPackages = genmodel.getGenPackages();
//		for (GenPackage genPackage : genPackages) {
//			List<GenClass> genClasses = genPackage.getGenClasses();
//			for (GenClass genClass : genClasses) {
//				String qualifiedClassName = genClass.getQualifiedClassName();
//				String qualifiedInterfaceName = genClass.getQualifiedInterfaceName();
//				if(qualifiedClassName.equals(attribute) || qualifiedInterfaceName.equals(attribute)){
//					return genClass;
//				}
//			}
//		}
//		return null;
//	}

	private QualitySmellModel registerQualitySmellModel(IEclipseContext context, IWorkspace workspace) {
		QualitySmellModel smellModel = initQualitySmellModel(workspace);
		context.set(QualitySmellModel.class, smellModel);
		//		this.smellModel = smellModel;

		//		context.declareModifiable(QualitySmellModel.class);
		//		context.modify(QualitySmellModel.class, smellModel);

		// OSGi service registration
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		//		ServiceRegistration<QualitySmellModel> smellModelService = bundleContext.registerService(QualitySmellModel.class, smellModel, null);
		bundleContext.registerService(QualitySmellModel.class, smellModel, null);
		return smellModel;
	}


	private QualitySmellModel initQualitySmellModel(IWorkspace workspace) {
		ResourceSet rs = new ResourceSetImpl();
		Bundle bundle = Platform.getBundle(SMELL_PLUGIN_ID);
		QualitySmellModel smellModel = null;
		Resource resource = null;
		if(bundle != null){
			IPath stateLocation = Platform.getStateLocation(bundle);
			IPath smellModelFilePath = stateLocation.append("/" + SMELL_MODEL_NAME);
			if(!smellModelFilePath.toFile().exists()){
				URI uri = URI.createFileURI(smellModelFilePath.toString());
				resource = rs.createResource(uri);
				smellModel = SmellFactory.eINSTANCE.createQualitySmellModel();
				resource.getContents().add(smellModel);
				try {
					Map<String,Object> options = new HashMap<>();
					options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
					options.put(XMLResource.OPTION_ENCODING, "UTF-8");
					resource.save(options);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				URI uri = URI.createFileURI(smellModelFilePath.toString());
				resource = rs.getResource(uri, true);
				smellModel = (QualitySmellModel) resource.getContents().get(0);
			}
		}
		smellModel.eAdapters().add(new ModificationListener(resource));
		return smellModel;
	}

	private CalculationModel createCalculationModel(IWorkspace workspace) {
		ResourceSet rs = new ResourceSetImpl();
		Bundle bundle = Platform.getBundle(SMELL_PLUGIN_ID);
		CalculationModel calculationModel = null;
		Resource resource = null;
		if(bundle != null){
			IPath stateLocation = Platform.getStateLocation(bundle);
			IPath smellModelFilePath = stateLocation.append("/" + CALC_MODEL_NAME);
			if(smellModelFilePath.toFile().exists()){
				smellModelFilePath.toFile().delete();
			}
			URI uri = URI.createFileURI(smellModelFilePath.toString());
			resource = rs.createResource(uri);
			calculationModel = CalculationFactory.eINSTANCE.createCalculationModel();
			resource.getContents().add(calculationModel);
		}
		return calculationModel;
	}
}
