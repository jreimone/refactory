/**
 */
package smell_model.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import smell_model.Metric;
import smell_model.Metric_Quality_Mapping;
import smell_model.ModelSmell;
import smell_model.ModelSmellModel;
import smell_model.ModelSmell_Rolemapping_Mapping;
import smell_model.Observer;
import smell_model.Quality;
import smell_model.Quality_ModelSmell_Mapping;
import smell_model.Smell_modelFactory;
import smell_model.Smell_modelPackage;
import smell_model.util.Smell_modelResourceFactoryImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ModelSmellModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getQualities <em>Qualities</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getConfigStrings <em>Config Strings</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getLoadedResourcePath <em>Loaded Resource Path</em>}</li>
 *   <li>{@link smell_model.impl.ModelSmellModelImpl#getQualityScale <em>Quality Scale</em>}</li>
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
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;
	
	private EList<String> configStrings = new BasicEList<String>();
	
	/**
	 * The default value of the '{@link #getLoadedResourcePath() <em>Loaded Resource Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadedResourcePath()
	 * @generated
	 * @ordered
	 */
	protected static final String LOADED_RESOURCE_PATH_EDEFAULT = null;

	private String loadedResourcePath;
	
	private Map<Quality, Float> qualityScale;
	
	private static ModelSmellModel main = Smell_modelFactory.eINSTANCE.createModelSmellModel();
	
	private static final String metric_ID = "org.emftext.refactoring.smell.core.smell_model.metric";
	
	private Map<Metric, Map<EObject, Float>> metricResultMapList = new HashMap<Metric, Map<EObject, Float>>();
	
	private EList<Observer> observer = new BasicEList<Observer>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ModelSmellModelImpl() {
		super();
		init();
	}
	//TODO Modelsmell_Rolemapping_Mapping erzeugen
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void init() {
		modelSmells = new BasicEList<ModelSmell>();
		qualities = new BasicEList<Quality>();
		metrics = new BasicEList<Metric>();
		quality_modelSmell = new BasicEList<Quality_ModelSmell_Mapping>();
		metric_quality = new BasicEList<Metric_Quality_Mapping>();
		modelSmell_roleMapping = new BasicEList<ModelSmell_Rolemapping_Mapping>();
		qualityScale = new HashMap<Quality, Float>();
		readIn();
		createMetrics(Platform.getExtensionRegistry());
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
	
	private void evaluateMetricExtension(IExtensionRegistry registry){
		Smell_modelResourceFactoryImpl factory = new Smell_modelResourceFactoryImpl();
		URI fileURI = URI.createFileURI(loadedResourcePath);
		Resource resource = factory.createResource(fileURI);
		IConfigurationElement[] metricExtensions = registry.getConfigurationElementsFor(metric_ID);
		try {
			for (IConfigurationElement e : metricExtensions) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof Metric) {
					executeMetricExtension(o, resource);
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
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
				metricResultMapList.put(((Metric) o), ((Metric) o).calculate(resource));
			}
		};
		SafeRunner.run(runnable);
	}
	
	private void createMetricQualityMapping(){
		for (int i = 0; i < configStrings.size(); i++){
			for (Quality q : qualities){
				if(configStrings.get(i).equals(q.getName())){
					i++;
					while(configStrings.get(i).startsWith(">")) {
						String[] temp = configStrings.get(i).split("::");
						for (Metric m : metrics){
							if(temp[0].equals(">"+m.getName())){
								Metric_Quality_Mapping tempMapping = Smell_modelFactory.eINSTANCE.createMetric_Quality_Mapping();
								tempMapping.setFactor(Float.parseFloat(temp[1]));
								tempMapping.setQuality(q);
								tempMapping.setMetric(m);
								System.out.println(tempMapping.getQuality()+"::"+tempMapping.getMetric()+"::"+tempMapping.getFactor());
								metric_quality.add(tempMapping);
							}
						}
						i++;
					}
				}
			}
		}
	}
	
	private void calculateSmells(){
		ModelSmellResult result = new ModelSmellResult();
		result.calculate(metric_quality, quality_modelSmell, metricResultMapList, qualityScale);
		inform();
	}

	private void readIn(){
		FileReader fileReader = null;
		//TODO relativen Pfad einfügen
		try {
			fileReader = new FileReader("projects/org.emftext.refactoring.smell.core/src/smell_model/config/config.cfg");
		} catch (FileNotFoundException e) {
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
	    	configStrings.add(row);
	    	try {
				row = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
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
		    					System.out.println(tempMapping.getModelSmell()+"::"+tempMapping.getQuality()+"::"+tempMapping.getFactor());
		    					quality_modelSmell.add(tempMapping);
		    				}
		    			}
		    			i++;
		    		}
		    	}
	    	}
	    }
	    try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createMetrics(IExtensionRegistry registry){
		IConfigurationElement[] metricExtensions = registry.getConfigurationElementsFor(metric_ID);
		try {
			for (IConfigurationElement e : metricExtensions) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof Metric) {
					metrics.add((Metric) o);
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
		createMetricQualityMapping();
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
	public void setConfigStrings(EList<String> newConfigStrings) {
		EList<String> oldConfigStrings = configStrings;
		configStrings = newConfigStrings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_MODEL__CONFIG_STRINGS, oldConfigStrings, configStrings));
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
	}
	
	public static ModelSmellModel getMain(){
		return main;
	}
	
	public void setConfigStrins(EList<String> configStrings){
		this.configStrings = configStrings;
	}
	
	public EList<String> getConfigStrings(){
		return this.configStrings;
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
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<Metric>(Metric.class, this, Smell_modelPackage.MODEL_SMELL_MODEL__METRICS);
		}
		return metrics;
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
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				return getMetrics();
			case Smell_modelPackage.MODEL_SMELL_MODEL__CONFIG_STRINGS:
				return getConfigStrings();
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE_PATH:
				return getLoadedResourcePath();
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				return getQualityScale();
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
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__CONFIG_STRINGS:
				setConfigStrings((EList<String>)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE_PATH:
				setLoadedResourcePath((String)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				setQualityScale((Map<Quality, Float>)newValue);
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
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				getMetrics().clear();
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__CONFIG_STRINGS:
				setConfigStrings((EList<String>)null);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE_PATH:
				setLoadedResourcePath(LOADED_RESOURCE_PATH_EDEFAULT);
				return;
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				setQualityScale((Map<Quality, Float>)null);
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
			case Smell_modelPackage.MODEL_SMELL_MODEL__METRICS:
				return metrics != null && !metrics.isEmpty();
			case Smell_modelPackage.MODEL_SMELL_MODEL__CONFIG_STRINGS:
				return configStrings != null;
			case Smell_modelPackage.MODEL_SMELL_MODEL__LOADED_RESOURCE_PATH:
				return LOADED_RESOURCE_PATH_EDEFAULT == null ? loadedResourcePath != null : !LOADED_RESOURCE_PATH_EDEFAULT.equals(loadedResourcePath);
			case Smell_modelPackage.MODEL_SMELL_MODEL__QUALITY_SCALE:
				return qualityScale != null;
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
		result.append(" (configStrings: ");
		result.append(configStrings);
		result.append(", loadedResourcePath: ");
		result.append(loadedResourcePath);
		result.append(", qualityScale: ");
		result.append(qualityScale);
		result.append(')');
		return result.toString();
	}
	
	public String getLoadedResourcePath() {
		return loadedResourcePath;
	}
	
	public void setLoadedResourcePath(String loadedResourcePath) {
		this.loadedResourcePath = loadedResourcePath;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Quality, Float> getQualityScale() {
		return qualityScale;
	}

} //MainImpl
