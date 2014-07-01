package org.emftext.refactoring.smell.registry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.emftext.refactoring.smell.calculation.Structure;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ExtensionRegistryQualitySmellModelInitializer implements IQualitySmellModelInitializer{

	private static final String SMELL_MODEL_NAME	= "smellmodel.smell";
	private static final String CALC_MODEL_NAME		= "registered.calculation";
	
	private IEclipseContext context;
	private IWorkspace workspace;
	private IExtensionRegistry registry;
	
	private CalculationModel calculationModel;
	private QualitySmellModel smellModel;
//	private boolean alreadyRegistered;
	
	protected ExtensionRegistryQualitySmellModelInitializer(IEclipseContext context, IWorkspace workspace, IExtensionRegistry registry) {
		this.context = context;
		this.workspace = workspace;
		this.registry = registry;
	}

	private CalculationModel registerCalculationExtensions(IEclipseContext context, IExtensionRegistry registry, IWorkspace workspace) {
		CalculationModel calculationModel = initCalculationModel(registry, workspace);
		if(context != null){
			context.set(CalculationModel.class, calculationModel);
		}

		// OSGi service registration
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		bundleContext.registerService(CalculationModel.class, calculationModel, null);
		return calculationModel;
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
					} else if(element.getName().equals(ICalculationExtensionPoint.STRUCTURE_CALCULATION)){
//						registerIncQuery();
						String patternResource = element.getAttribute(ICalculationExtensionPoint.PATTERN_RESOURCE);
						Bundle bundle = Platform.getBundle(element.getContributor().getName());
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
								PatternModel patternModel = (PatternModel) model;
								String patternName = element.getAttribute(ICalculationExtensionPoint.PATTERN_NAME);
								Pattern patternToRegister = null;
								for (Pattern pattern : patternModel.getPatterns()) {
									if(pattern.getName().equals(patternName)){
										patternToRegister = pattern;
										break;
									}
								}
								if(patternToRegister != null){
									String description = element.getAttribute(ICalculationExtensionPoint.PATTERN_DESCRIPTION);
									String smellMessage = element.getAttribute(ICalculationExtensionPoint.PATTERN_SMELL_MESSAGE);
									Structure structureSmell = CalculationFactory.eINSTANCE.createStructure();
									structureSmell.setName(patternName);
									structureSmell.setDescription(description);
									structureSmell.setSmellMessage(smellMessage);
									structureSmell.setPattern(patternToRegister);
									calculationModel.getCalculations().add(structureSmell);
								}
							}
						}
					}
				}
			}
		}
		try {
			Map<String,Object> options = new HashMap<String,Object>();
			options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			calculationModel.eResource().save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return calculationModel;
	}


//	private void registerIncQuery() {
//		if(!alreadyRegistered){
//			new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
//			alreadyRegistered = true;
//		}
//	}

	private QualitySmellModel registerQualitySmellModel(IEclipseContext context, IWorkspace workspace) {
		QualitySmellModel smellModel = initQualitySmellModel(workspace);
		if(context != null){
			context.set(QualitySmellModel.class, smellModel);
		}
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
		Bundle bundle = FrameworkUtil.getBundle(getClass());
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
					Map<String,Object> options = new HashMap<String,Object>();
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
		Bundle bundle = FrameworkUtil.getBundle(getClass());
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

	@Override
	public QualitySmellModel getQualitySmellModel() {
		return smellModel;
	}

	@Override
	public CalculationModel getCalculationModel() {
		return calculationModel;
	}

	@Override
	public void initialize() {
		calculationModel = registerCalculationExtensions(context, registry, workspace);
		smellModel = registerQualitySmellModel(context, workspace);
	}
}
