/**
 */
package org.emftext.refactoring.smell.smell_model.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping;
import org.emftext.refactoring.smell.smell_model.ModelMetric;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmellModel;
import org.emftext.refactoring.smell.smell_model.ModelSmellResult;
import org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.Quality;
import org.emftext.refactoring.smell.smell_model.Quality_ModelSmell_Mapping;
import org.emftext.refactoring.smell.smell_model.Smell_modelFactory;
import org.emftext.refactoring.smell.smell_model.Smell_modelPackage;
import org.emftext.refactoring.smell.smell_model.ui.RefactoringQuickfix;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ModelSmellModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getLoadedResource <em>Loaded Resource</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getQualityScale <em>Quality Scale</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getModelSmellDescription <em>Model Smell Description</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getMetricResultMap <em>Metric Result Map</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getLoadedMetaModel <em>Loaded Meta Model</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellModelImpl#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelSmellModelImpl extends EObjectImpl implements ModelSmellModel {
	/**
	 * The cached value of the '{@link #getModelSmell_roleMapping() <em>Model Smell role Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmell_roleMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSmell_Rolemapping_Mapping> modelSmell_roleMapping;

	/**
	 * The cached value of the '{@link #getQuality_modelSmell() <em>Quality model Smell</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality_modelSmell()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality_ModelSmell_Mapping> quality_modelSmell;

	/**
	 * The cached value of the '{@link #getMetric_quality() <em>Metric quality</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric_quality()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric_Quality_Mapping> metric_quality;

	/**
	 * The cached value of the '{@link #getQualities() <em>Qualities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualities()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality> qualities;

	/**
	 * The cached value of the '{@link #getModelSmells() <em>Model Smells</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmells()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSmell> modelSmells;

	/**
	 * The cached value of the '{@link #getLoadedResource() <em>Loaded Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLoadedResource()
	 * @generated
	 * @ordered
	 */
	
	protected Resource loadedResource;
	
	private Map<Quality, Float> qualityScale;
	
	private static ModelSmellModel main = Smell_modelFactory.eINSTANCE.createModelSmellModel();
	
	private static final String metric_ID = "org.emftext.refactoring.smell.smell_model.metric";
	
	private EList<Observer> observer = new BasicEList<Observer>();
	
	private ModelSmellResult result;
	
	private Map<ModelSmell, String> modelSmellDescription;

	private Map<ModelMetric, Map<EObject, Float>> metricResultMap;
	
	private EPackage loadedMetaModel;
	
	private IWorkspace workspace;
	
	private IResourceChangeListener listener;
	
	private Map<IMarker, RefactoringQuickfix> markerRefactoring;

	/**
	 * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final Float THRESHOLD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected Float threshold = THRESHOLD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelMetric> metrics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ModelSmellModelImpl() {
		super();
		init();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public void init() {
		modelSmells = new BasicEList<ModelSmell>();
		qualities = new BasicEList<Quality>();
		metrics = new BasicEList<ModelMetric>();
		quality_modelSmell = new BasicEList<Quality_ModelSmell_Mapping>();
		metric_quality = new BasicEList<Metric_Quality_Mapping>();
		modelSmell_roleMapping = new BasicEList<ModelSmell_Rolemapping_Mapping>();
		qualityScale = new HashMap<Quality, Float>();
		markerRefactoring = new HashMap<IMarker, RefactoringQuickfix>();
		setThreshold();
		createResourceObserver();
		createQualitySmellMap();
		createModelSmellDescription();
		for (int i = 0; i < qualities.size(); i++){
			qualityScale.put(qualities.get(i), 1.0f);
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * * @generated NOT
	 */
	public void calculate() {
		createMetrics(Platform.getExtensionRegistry());
		evaluateMetricExtension(Platform.getExtensionRegistry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * * @generated NOT
	 */
	public void register(Observer o) {
		observer.add(o);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * * @generated NOT
	 */
	public void unregister(Observer o) {
		observer.remove(o);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * * @generated NOT
	 */
	public void inform() {
		for(Observer o : observer){
			o.update();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getNamespace() {
		String nameSpace = "";
		if (loadedResource != null){
			nameSpace = loadedResource.getContents().get(0).eClass().getEPackage().getNsURI();
		}
		return nameSpace;
	}
	
	public RefactoringQuickfix getQuickfixForMarker(IMarker mk){
		if (mk != null) {
			return markerRefactoring.get(mk);
		} else {
			return null;
		}
	}
	
	private void setThreshold(){
		EList<String> configStrings = openConfig("/configs/config.cfg");
		for (int i = 0; i < configStrings.size(); i++){
	    	String[] temp = configStrings.get(i).split("::");
	    	if(temp[0].equals("threshold")){
	    		threshold = Float.parseFloat(temp[1]);
	    	}
		}
	}

	private void evaluateMetricExtension(IExtensionRegistry registry){
		if (loadedResource != null){
			metricResultMap = new HashMap<ModelMetric, Map<EObject, Float>>();
			IConfigurationElement[] metricExtensions = registry.getConfigurationElementsFor(metric_ID);
			try {
				for (IConfigurationElement e : metricExtensions) {
					final Object o = e.createExecutableExtension("class");
					if (o instanceof ModelMetric) {
						executeMetricExtension(o, loadedResource);
					}
				}
			} catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
		}
		calculateSmells();
	}
	
	private void executeMetricExtension(final Object o, final Resource resource){
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				System.out.println("Exception in client");
			}

			@Override
			public void run() throws Exception {
				for (ModelMetric m : metrics){
					if (m.getName().equals(((ModelMetric) o).getName())){
						metricResultMap.put(m, ((ModelMetric) o).calculate(resource));
					}
				}
			}
		};
		SafeRunner.run(runnable);
	}
	
	private void createMetricQualityMapping(){
		EList<String> configStrings = openConfig("/configs/config.cfg");
		metric_quality = new BasicEList<Metric_Quality_Mapping>();
		for (int i = 0; i < configStrings.size(); i++){
			for (Quality q : qualities){
				if(configStrings.get(i).equals(q.getName())){
					i++;
					while(configStrings.get(i).startsWith(">")) {
						String[] temp = configStrings.get(i).split("::");
						for (ModelMetric m : metrics){
							if(temp[0].equals(">"+m.getName())){
								Metric_Quality_Mapping tempMapping = Smell_modelFactory.eINSTANCE.createMetric_Quality_Mapping();
								tempMapping.setFactor(Float.parseFloat(temp[1]));
								tempMapping.setQuality(q);
								tempMapping.setMetric(m);
								metric_quality.add(tempMapping);
							}
						}
						i++;
					}
				}
			}
		}
	}

	private void createQualitySmellMap(){
		quality_modelSmell = new BasicEList<Quality_ModelSmell_Mapping>();
		EList<String> configStrings = openConfig("/configs/config.cfg");
	    for (int i = 0; i < configStrings.size(); i++){
	    	String[] temp = configStrings.get(i).split("::");
	    	if(temp[0].equals("ModelSmell")){
	    		ModelSmell smell = Smell_modelFactory.eINSTANCE.createModelSmell();
	    		smell.setName(temp[1]);
	    		modelSmells.add(smell);
	    	}
	    	if(temp[0].equals("Quality")){
	    		Quality quality = Smell_modelFactory.eINSTANCE.createQuality();
	    		quality.setName(temp[1]);
	    		qualities.add(quality);
	    	}
	    }
	    for (int i = 0; i < configStrings.size(); i++){
	    	for (ModelSmell m : modelSmells){
		    	if(configStrings.get(i).equals(m.getName())){
		    		i++;
		    		while(configStrings.get(i).startsWith(">")) {
		    			String[] temp = configStrings.get(i).split("::");
		    			for (Quality q : qualities){
		    				if(temp[0].equals(">"+q.getName())){
		    					Quality_ModelSmell_Mapping tempMapping = Smell_modelFactory.eINSTANCE.createQuality_ModelSmell_Mapping();
		    					tempMapping.setFactor(Float.parseFloat(temp[1]));
		    					tempMapping.setModelSmell(m);
		    					tempMapping.setQuality(q);
		    					quality_modelSmell.add(tempMapping);
		    				}
		    			}
		    			i++;
		    		}
		    	}
	    	}
	    }
	}
	
	private void createMetrics(IExtensionRegistry registry){
		metrics = new BasicEList<ModelMetric>();
		IConfigurationElement[] metricExtensions = registry.getConfigurationElementsFor(metric_ID);
		try {
			for (IConfigurationElement e : metricExtensions) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof ModelMetric) {
					metrics.add((ModelMetric) o);
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
		createMetricQualityMapping();
	}
	
	private void createModelSmellDescription(){
		modelSmellDescription = new HashMap<ModelSmell, String>();
		EList<String> descriptions = new BasicEList<String>();
		descriptions = openConfig("/configs/descriptions.cfg");
	    for (int i = 0; i < descriptions.size(); i++){
	    	if (descriptions.get(i).startsWith("#")){
	    		for (ModelSmell m : modelSmells){
	    			if (("#"+m.getName()).equals(descriptions.get(i))){
	    				modelSmellDescription.put(m, descriptions.get(i+1));
	    			}
	    		}
	    	}
	    }
	}
	
	private void createModelSmellRolemappingMap(){
		EList<String> rolemappings = new BasicEList<String>();
		rolemappings = openConfig("/configs/rolemappings.cfg");
		modelSmell_roleMapping = new BasicEList<ModelSmell_Rolemapping_Mapping>();
	    for (int i = 0; i < rolemappings.size(); i++){
	    	for (ModelSmell m : modelSmells){
	    		if (("#"+m.getName()).equals(rolemappings.get(i))){
	    			i++;
	    			for (String s : IRoleMappingRegistry.INSTANCE.getRoleMappingsMap().keySet()){
	    				if (loadedMetaModel != null){
	    					if (s.equals(loadedMetaModel.getNsURI())){
		    					while (rolemappings.get(i).startsWith(">")){
		    						for (String n : IRoleMappingRegistry.INSTANCE.getRoleMappingsMap().get(s).keySet()){
		    							if (rolemappings.get(i).equals(">"+n)){
		    								ModelSmell_Rolemapping_Mapping tempMapping = Smell_modelFactory.eINSTANCE.createModelSmell_Rolemapping_Mapping();
			    							tempMapping.setMetaModelSpecification(loadedMetaModel);
			    							tempMapping.setModelSmell(m);
			    							tempMapping.getRoleMappings().add(IRoleMappingRegistry.INSTANCE.getRoleMappingsMap().get(s).get(n));
			    							modelSmell_roleMapping.add(tempMapping);
			    						}
		    						}
		    						i++;
		    					}
		    				}
	    				}
	    			}
	    		}
	    	}
	    }
	}
	
	private EList<String> openConfig(String path){
		FileReader fileReader = null;
		EList<String> stringList= new BasicEList<String>();
		try {
			if(ActivatorImpl.getDefault() != null) {
				URL url = ActivatorImpl.getDefault().getBundle().getEntry(path);
				url = FileLocator.toFileURL(url);
				url = new URL(url.toString().replaceAll(" ", "%20"));
				File file = new File(url.toURI());
				assert file.exists();
				fileReader = new FileReader(file);
			} else {
				URL url = new URL("file:/C:"+path);
				File file = new File(url.toURI());
				assert file.exists();
				fileReader = new FileReader(file);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String row = null;
		try {
			row = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    while(row != null){
	    	stringList.add(row);
	    	try {
				row = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return stringList;
	}
	
	private void createResourceObserver(){
		workspace = ResourcesPlugin.getWorkspace();
		listener = new IResourceChangeListener() {
			
			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				listenerOperation(event);
			}
		};
		workspace.addResourceChangeListener(listener);
	}
	
	private IResourceDelta getChangedResource(IResourceDelta delta){
		while(delta.getAffectedChildren().length > 0){
			delta = getChangedResource(delta.getAffectedChildren()[0]);
		}
		return delta;
	}
	
	private void calculateSmells(){
		ModelSmellResult result = Smell_modelFactory.eINSTANCE.createModelSmellResult();
		result.setThreshold(threshold);
		result.calculate(metric_quality, quality_modelSmell, metricResultMap, qualityScale);
		setResult(result);
		createModelSmellRolemappingMap();
		inform();
	}
	
	private void listenerOperation(IResourceChangeEvent event){
		IResourceDelta delta = event.getDelta();
		if (event.getType() == IResourceChangeEvent.POST_CHANGE && getChangedResource(delta).getMarkerDeltas().length <= 0){
			delta = getChangedResource(delta);
			IResource resource = delta.getResource();
			IPath location = resource.getFullPath();
			URI fileURI = URI.createPlatformResourceURI(location.toString(), true);
			ResourceSet resourceSet = new ResourceSetImpl();
			loadedResource = resourceSet.getResource(fileURI, true);
			calculate();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING:
				return ((InternalEList<?>)getModelSmell_roleMapping()).basicRemove(otherEnd, msgs);
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL:
				return ((InternalEList<?>)getQuality_modelSmell()).basicRemove(otherEnd, msgs);
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_QUALITY:
				return ((InternalEList<?>)getMetric_quality()).basicRemove(otherEnd, msgs);
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITIES:
				return ((InternalEList<?>)getQualities()).basicRemove(otherEnd, msgs);
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELLS:
				return ((InternalEList<?>)getModelSmells()).basicRemove(otherEnd, msgs);
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.MODEL_SMELL_MODEL;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityScale(Map<Quality, Float> newQualityScale) {
		Map<Quality, Float> oldQualityScale = qualityScale;
		qualityScale = newQualityScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE, oldQualityScale, qualityScale));
	}
	
	public void setQualityScale(Quality quality, Float factor){
		this.qualityScale.put(quality, factor);
		calculate();
	}
	
	public static ModelSmellModel getMain(){
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSmell_Rolemapping_Mapping> getModelSmell_roleMapping() {
		if (modelSmell_roleMapping == null) {
			modelSmell_roleMapping = new EObjectContainmentEList<ModelSmell_Rolemapping_Mapping>(ModelSmell_Rolemapping_Mapping.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING);
		}
		return modelSmell_roleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Quality_ModelSmell_Mapping> getQuality_modelSmell() {
		if (quality_modelSmell == null) {
			quality_modelSmell = new EObjectContainmentEList<Quality_ModelSmell_Mapping>(Quality_ModelSmell_Mapping.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL);
		}
		return quality_modelSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric_Quality_Mapping> getMetric_quality() {
		if (metric_quality == null) {
			metric_quality = new EObjectContainmentEList<Metric_Quality_Mapping>(Metric_Quality_Mapping.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_QUALITY);
		}
		return metric_quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Quality> getQualities() {
		if (qualities == null) {
			qualities = new EObjectContainmentEList<Quality>(Quality.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__QUALITIES);
		}
		return qualities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSmell> getModelSmells() {
		if (modelSmells == null) {
			modelSmells = new EObjectContainmentEList<ModelSmell>(ModelSmell.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELLS);
		}
		return modelSmells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelMetric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<ModelMetric>(ModelMetric.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Resource getLoadedResource()
  {
		return loadedResource;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLoadedResource(Resource newLoadedResource)
  {
		Resource oldLoadedResource = loadedResource;
		loadedResource = newLoadedResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE, oldLoadedResource, loadedResource));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING:
				return getModelSmell_roleMapping();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL:
				return getQuality_modelSmell();
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_QUALITY:
				return getMetric_quality();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITIES:
				return getQualities();
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELLS:
				return getModelSmells();
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE:
				return getLoadedResource();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				return getQualityScale();
			case Smell_modelPackage.MODEL_SMELL_MODEL__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION:
				return getModelSmellDescription();
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_RESULT_MAP:
				return getMetricResultMap();
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_META_MODEL:
				if (resolve) return getLoadedMetaModel();
				return basicGetLoadedMetaModel();
			case Smell_modelPackage.MODEL_SMELL_MODEL__THRESHOLD:
				return getThreshold();
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				return getMetrics();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING:
				getModelSmell_roleMapping().clear();
				getModelSmell_roleMapping().addAll((Collection<? extends ModelSmell_Rolemapping_Mapping>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL:
				getQuality_modelSmell().clear();
				getQuality_modelSmell().addAll((Collection<? extends Quality_ModelSmell_Mapping>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_QUALITY:
				getMetric_quality().clear();
				getMetric_quality().addAll((Collection<? extends Metric_Quality_Mapping>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITIES:
				getQualities().clear();
				getQualities().addAll((Collection<? extends Quality>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELLS:
				getModelSmells().clear();
				getModelSmells().addAll((Collection<? extends ModelSmell>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE:
				setLoadedResource((Resource)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				setQualityScale((Map<Quality, Float>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__RESULT:
				setResult((ModelSmellResult)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION:
				setModelSmellDescription((Map<ModelSmell, String>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_RESULT_MAP:
				setMetricResultMap((Map<ModelMetric, Map<EObject, Float>>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_META_MODEL:
				setLoadedMetaModel((EPackage)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__THRESHOLD:
				setThreshold((Float)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends ModelMetric>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING:
				getModelSmell_roleMapping().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL:
				getQuality_modelSmell().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_QUALITY:
				getMetric_quality().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITIES:
				getQualities().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELLS:
				getModelSmells().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				setQualityScale((Map<Quality, Float>)null);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__RESULT:
				setResult((ModelSmellResult)null);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION:
				setModelSmellDescription((Map<ModelSmell, String>)null);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_RESULT_MAP:
				setMetricResultMap((Map<ModelMetric, Map<EObject, Float>>)null);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_META_MODEL:
				setLoadedMetaModel((EPackage)null);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__THRESHOLD:
				setThreshold(THRESHOLD_EDEFAULT);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				getMetrics().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING:
				return modelSmell_roleMapping != null && !modelSmell_roleMapping.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL:
				return quality_modelSmell != null && !quality_modelSmell.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_QUALITY:
				return metric_quality != null && !metric_quality.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITIES:
				return qualities != null && !qualities.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELLS:
				return modelSmells != null && !modelSmells.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				return qualityScale != null;
			case Smell_modelPackage.MODEL_SMELL_MODEL__RESULT:
				return result != null;
			case Smell_modelPackage.MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION:
				return modelSmellDescription != null;
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_RESULT_MAP:
				return metricResultMap != null;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_META_MODEL:
				return loadedMetaModel != null;
			case Smell_modelPackage.MODEL_SMELL_MODEL__THRESHOLD:
				return THRESHOLD_EDEFAULT == null ? threshold != null : !THRESHOLD_EDEFAULT.equals(threshold);
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				return metrics != null && !metrics.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (loadedResource: ");
		result.append(loadedResource);
		result.append(", qualityScale: ");
		result.append(qualityScale);
		result.append(", modelSmellDescription: ");
		result.append(modelSmellDescription);
		result.append(", metricResultMap: ");
		result.append(metricResultMap);
		result.append(", threshold: ");
		result.append(threshold);
		result.append(')');
		return result.toString();
	}

	public Map<Quality, Float> getQualityScale() {
		return qualityScale;
	}
	
	public ModelSmellResult getResult() {
		return result;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSmellResult basicGetResult() {
		return result;
	}

	public void setResult(ModelSmellResult result) {
		this.result = result;
	}
	
	public Map<ModelSmell, String> getModelSmellDescription() {
		return modelSmellDescription;
	}
	
	public void setModelSmellDescription(Map<ModelSmell, String> modelSmellDescription) {
		this.modelSmellDescription = modelSmellDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<ModelMetric, Map<EObject, Float>> getMetricResultMap() {
		return metricResultMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricResultMap(Map<ModelMetric, Map<EObject, Float>> newMetricResultMap) {
		Map<ModelMetric, Map<EObject, Float>> oldMetricResultMap = metricResultMap;
		metricResultMap = newMetricResultMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_MODEL__METRIC_RESULT_MAP, oldMetricResultMap, metricResultMap));
	}

	public EPackage getLoadedMetaModel() {
		return loadedMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetLoadedMetaModel() {
		return loadedMetaModel;
	}

	public void setLoadedMetaModel(EPackage loadedMetaModel) {
		this.loadedMetaModel = loadedMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(Float newThreshold) {
		Float oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_MODEL__THRESHOLD, oldThreshold, threshold));
	}

	public Map<IMarker, RefactoringQuickfix> getMarkerRefactoring() {
		return markerRefactoring;
	}

	public void putMarkerRefactoring(IMarker mk, RefactoringQuickfix r) {
		markerRefactoring.put(mk, r);
	}

	@Override
	public EList<Observer> getObserver() {
		return observer;
	}

} //MainImpl
