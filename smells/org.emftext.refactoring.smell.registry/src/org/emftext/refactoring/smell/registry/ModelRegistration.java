package org.emftext.refactoring.smell.registry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;

@SuppressWarnings("restriction")
public class ModelRegistration {

	public static final String SMELL_PLUGIN_ID		= "org.emftext.refactoring.smell.registry";
	private static final String SMELL_MODEL_NAME	= "smellmodel.smell";
	
	private CalculationModel calculationModel;
	private QualitySmellModel smellModel;
	
	private static ModelRegistration instance;
	
	public static ModelRegistration getDefault(){
		if(instance == null){
			instance = new ModelRegistration();
		}
		return instance;
	}
	
	@PostConstruct
	public void register(IEclipseContext context, IWorkspace workspace, IExtensionRegistry registry) {
		instance = this;
		registerCalculationExtensions(context, registry);
		registerQualitySmellModel(context, workspace);
	}

	
	private void registerCalculationExtensions(IEclipseContext context, IExtensionRegistry registry) {
		CalculationModel calculationModel = initCalculationModel(registry);
		context.set(CalculationModel.class, calculationModel);
		this.calculationModel = calculationModel;
	}
	
	private CalculationModel initCalculationModel(IExtensionRegistry registry) {
		CalculationModel model = CalculationFactory.eINSTANCE.createCalculationModel();
		if(registry != null){
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ICalculationExtensionPoint.ID);
			if(elements != null){
				for (IConfigurationElement element : elements) {
					try {
						Calculation calculation = (Calculation) element.createExecutableExtension(ICalculationExtensionPoint.calculationClass);
						if(calculation != null){
							model.getCalculations().add(calculation);
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return model;
	}
	
	private void registerQualitySmellModel(IEclipseContext context, IWorkspace workspace) {
		QualitySmellModel smellModel = initQualitySmellModel(workspace);
		context.set(QualitySmellModel.class, smellModel);
		this.smellModel = smellModel;
		
//		context.declareModifiable(QualitySmellModel.class);
//		context.modify(QualitySmellModel.class, smellModel);
		
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
//		ServiceRegistration<QualitySmellModel> smellModelService = bundleContext.registerService(QualitySmellModel.class, smellModel, null);
		bundleContext.registerService(QualitySmellModel.class, smellModel, null);
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


	public CalculationModel getCalculationmodel() {
		return calculationModel;
	}


	public QualitySmellModel getSmellmodel() {
		return smellModel;
	}
}
