/**
 */
package org.eclipse.emf.modelSmells.smell_model.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.modelSmells.smell_model.Main;
import org.eclipse.emf.modelSmells.smell_model.Metric;
import org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping;
import org.eclipse.emf.modelSmells.smell_model.ModelSmell;
import org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping;
import org.eclipse.emf.modelSmells.smell_model.Quality;
import org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping;
import org.eclipse.emf.modelSmells.smell_model.Smell_modelPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MainImpl extends EObjectImpl implements Main {
	/**
	 * The cached value of the '{@link #getModelSmell_roleMapping() <em>Model Smell role Mapping</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmell_roleMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSmell_Rolemapping_Mapping> modelSmell_roleMapping;

	/**
	 * The cached value of the '{@link #getQuality_modelSmell() <em>Quality model Smell</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality_modelSmell()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality_ModelSmell_Mapping> quality_modelSmell;

	/**
	 * The cached value of the '{@link #getMetric_quality() <em>Metric quality</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric_quality()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric_Quality_Mapping> metric_quality;

	/**
	 * The cached value of the '{@link #getQualities() <em>Qualities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualities()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality> qualities;

	/**
	 * The cached value of the '{@link #getModelSmells() <em>Model Smells</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmells()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSmell> modelSmells;

	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;
	
	private EList<String> configStrings = new BasicEList<String>();
	
	private static MainImpl main = new MainImpl();
	
	private String loadedResourcePath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainImpl() {
		super();
		init();
	}
	//TODO Modelsmell_Rolemapping_Mapping erzeugen
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void init() {
		modelSmells = new BasicEList<ModelSmell>();
		qualities = new BasicEList<Quality>();
		metrics = new BasicEList<Metric>();
		quality_modelSmell = new BasicEList<Quality_ModelSmell_Mapping>();
		metric_quality = new BasicEList<Metric_Quality_Mapping>();
		modelSmell_roleMapping = new BasicEList<ModelSmell_Rolemapping_Mapping>();
		readIn();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void calculate() {
		// TODO: implement this method
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void registerMetric(Metric metric) {
		metrics.add(metric);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void refactor() {
		// TODO: implement this method
	}
	
	public void setConfigStrins(EList<String> configStrings){
		this.configStrings = configStrings;
	}
	
	public EList<String> getConfigStrings(){
		return this.configStrings;
	}
	
	private void readIn(){
		FileReader fileReader = null;
		//TODO relativen Pfad einfügen
//		System.out.println(MainImpl.class.getClassLoader().getResource("/org/eclipse/emf/modelSmells/smell_model/config/config.cfg").getPath());
		try {
			fileReader = new FileReader("projects/smells/src/org/eclipse/emf/modelSmells/smell_model/config/config.cfg");
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
	    		ModelSmell smell = new ModelSmellImpl();
	    		smell.setName(temp[1]);
	    		modelSmells.add(smell);
	    	}
	    	if(temp[0].equals("Quality")){
	    		Quality quality = new QualityImpl();
	    		quality.setName(temp[1]);
	    		qualities.add(quality);
	    	}
	    }
	    for (int i = 0; i < configStrings.size(); i++){
	    	for (int j = 0; j < modelSmells.size(); j++){
		    	ModelSmell tempSmell = modelSmells.get(j);
		    	if(configStrings.get(i).equals(tempSmell.getName())){
		    		do {
		    			i++;
		    			String[] temp = configStrings.get(i).split("::");
		    			for (int k = 0; k < qualities.size(); k++){
		    				Quality tempQuality = qualities.get(k);
		    				if(temp[0].equals(">"+tempQuality.getName())){
		    					Quality_ModelSmell_Mapping tempMapping = new Quality_ModelSmell_MappingImpl();
		    					tempMapping.setFactor(Integer.parseInt(temp[1]));
		    					tempMapping.setModelSmell(tempSmell);
		    					tempMapping.setQuality(tempQuality);
		    					quality_modelSmell.add(tempMapping);
		    				}
		    			}
		    		}while(!(configStrings.get(i).equals("#")));
		    	}
	    	}
	    }
	    for (int i = 0; i < configStrings.size(); i++){
	    	for (int j = 0; j < qualities.size(); j++){
		    	Quality tempQuality = qualities.get(j);
		    	if(configStrings.get(i).equals(tempQuality.getName())){
		    		do {
		    			i++;
		    			String[] temp = configStrings.get(i).split("::");
		    			for (int k = 0; k < metrics.size(); k++){
		    				Metric tempMetric = metrics.get(k);
		    				if(temp[0].equals(">"+tempMetric.getName())){
		    					Metric_Quality_Mapping tempMapping = new Metric_Quality_MappingImpl();
		    					tempMapping.setFactor(Integer.parseInt(temp[1]));
		    					tempMapping.setQuality(tempQuality);
		    					tempMapping.setMetric(tempMetric);
		    					metric_quality.add(tempMapping);
		    				}
		    			}
		    		}while(!(configStrings.get(i).equals("#")));
		    	}
	    	}
	    }
	    try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Main getMain(){
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.MAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSmell_Rolemapping_Mapping> getModelSmell_roleMapping() {
		if (modelSmell_roleMapping == null) {
			modelSmell_roleMapping = new EObjectResolvingEList<ModelSmell_Rolemapping_Mapping>(ModelSmell_Rolemapping_Mapping.class, this, Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING);
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
			quality_modelSmell = new EObjectResolvingEList<Quality_ModelSmell_Mapping>(Quality_ModelSmell_Mapping.class, this, Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL);
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
			metric_quality = new EObjectResolvingEList<Metric_Quality_Mapping>(Metric_Quality_Mapping.class, this, Smell_modelPackage.MAIN__METRIC_QUALITY);
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
			qualities = new EObjectResolvingEList<Quality>(Quality.class, this, Smell_modelPackage.MAIN__QUALITIES);
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
			modelSmells = new EObjectResolvingEList<ModelSmell>(ModelSmell.class, this, Smell_modelPackage.MAIN__MODEL_SMELLS);
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
			metrics = new EObjectResolvingEList<Metric>(Metric.class, this, Smell_modelPackage.MAIN__METRICS);
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				return getModelSmell_roleMapping();
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				return getQuality_modelSmell();
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				return getMetric_quality();
			case Smell_modelPackage.MAIN__QUALITIES:
				return getQualities();
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				return getModelSmells();
			case Smell_modelPackage.MAIN__METRICS:
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				getModelSmell_roleMapping().clear();
				getModelSmell_roleMapping().addAll((Collection<? extends ModelSmell_Rolemapping_Mapping>)newValue);
				return;
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				getQuality_modelSmell().clear();
				getQuality_modelSmell().addAll((Collection<? extends Quality_ModelSmell_Mapping>)newValue);
				return;
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				getMetric_quality().clear();
				getMetric_quality().addAll((Collection<? extends Metric_Quality_Mapping>)newValue);
				return;
			case Smell_modelPackage.MAIN__QUALITIES:
				getQualities().clear();
				getQualities().addAll((Collection<? extends Quality>)newValue);
				return;
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				getModelSmells().clear();
				getModelSmells().addAll((Collection<? extends ModelSmell>)newValue);
				return;
			case Smell_modelPackage.MAIN__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				getModelSmell_roleMapping().clear();
				return;
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				getQuality_modelSmell().clear();
				return;
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				getMetric_quality().clear();
				return;
			case Smell_modelPackage.MAIN__QUALITIES:
				getQualities().clear();
				return;
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				getModelSmells().clear();
				return;
			case Smell_modelPackage.MAIN__METRICS:
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				return modelSmell_roleMapping != null && !modelSmell_roleMapping.isEmpty();
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				return quality_modelSmell != null && !quality_modelSmell.isEmpty();
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				return metric_quality != null && !metric_quality.isEmpty();
			case Smell_modelPackage.MAIN__QUALITIES:
				return qualities != null && !qualities.isEmpty();
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				return modelSmells != null && !modelSmells.isEmpty();
			case Smell_modelPackage.MAIN__METRICS:
				return metrics != null && !metrics.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	public String getLoadedResourcePath() {
		return loadedResourcePath;
	}
	
	public void setLoadedResourcePath(String loadedResourcePath) {
		this.loadedResourcePath = loadedResourcePath;
	}

} //MainImpl
