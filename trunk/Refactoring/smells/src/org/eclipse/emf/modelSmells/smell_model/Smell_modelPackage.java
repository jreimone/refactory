/**
 */
package org.eclipse.emf.modelSmells.smell_model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.modelSmells.smell_model.Smell_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Smell_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "smell_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://smell_model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "smell_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Smell_modelPackage eINSTANCE = org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.ModelSmellImpl <em>Model Smell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.ModelSmellImpl
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getModelSmell()
	 * @generated
	 */
	int MODEL_SMELL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Model Smell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.ModelSmell_Rolemapping_MappingImpl <em>Model Smell Rolemapping Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.ModelSmell_Rolemapping_MappingImpl
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getModelSmell_Rolemapping_Mapping()
	 * @generated
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Model Smell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL = 0;

	/**
	 * The number of structural features of the '<em>Model Smell Rolemapping Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.QualityImpl <em>Quality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.QualityImpl
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getQuality()
	 * @generated
	 */
	int QUALITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Quality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.Quality_ModelSmell_MappingImpl <em>Quality Model Smell Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Quality_ModelSmell_MappingImpl
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getQuality_ModelSmell_Mapping()
	 * @generated
	 */
	int QUALITY_MODEL_SMELL_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING__FACTOR = 0;

	/**
	 * The feature id for the '<em><b>Model Smell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING__MODEL_SMELL = 1;

	/**
	 * The feature id for the '<em><b>Qualities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING__QUALITIES = 2;

	/**
	 * The number of structural features of the '<em>Quality Model Smell Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.Metric <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 0;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.Metric_Quality_MappingImpl <em>Metric Quality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Metric_Quality_MappingImpl
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getMetric_Quality_Mapping()
	 * @generated
	 */
	int METRIC_QUALITY_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING__FACTOR = 0;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING__QUALITY = 1;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING__METRICS = 2;

	/**
	 * The number of structural features of the '<em>Metric Quality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl <em>Main</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.MainImpl
	 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getMain()
	 * @generated
	 */
	int MAIN = 6;

	/**
	 * The feature id for the '<em><b>Model Smell role Mapping</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__MODEL_SMELL_ROLE_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Quality model Smell</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__QUALITY_MODEL_SMELL = 1;

	/**
	 * The feature id for the '<em><b>Metric quality</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__METRIC_QUALITY = 2;

	/**
	 * The feature id for the '<em><b>Qualities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__QUALITIES = 3;

	/**
	 * The feature id for the '<em><b>Model Smells</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__MODEL_SMELLS = 4;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__METRICS = 5;

	/**
	 * The number of structural features of the '<em>Main</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_FEATURE_COUNT = 6;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.ModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Smell</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.ModelSmell
	 * @generated
	 */
	EClass getModelSmell();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.modelSmells.smell_model.ModelSmell#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.ModelSmell#getName()
	 * @see #getModelSmell()
	 * @generated
	 */
	EAttribute getModelSmell_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping <em>Model Smell Rolemapping Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Smell Rolemapping Mapping</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping
	 * @generated
	 */
	EClass getModelSmell_Rolemapping_Mapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping#getModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Smell</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping#getModelSmell()
	 * @see #getModelSmell_Rolemapping_Mapping()
	 * @generated
	 */
	EReference getModelSmell_Rolemapping_Mapping_ModelSmell();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.Quality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Quality
	 * @generated
	 */
	EClass getQuality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.modelSmells.smell_model.Quality#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Quality#getName()
	 * @see #getQuality()
	 * @generated
	 */
	EAttribute getQuality_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping <em>Quality Model Smell Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Model Smell Mapping</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping
	 * @generated
	 */
	EClass getQuality_ModelSmell_Mapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getFactor()
	 * @see #getQuality_ModelSmell_Mapping()
	 * @generated
	 */
	EAttribute getQuality_ModelSmell_Mapping_Factor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Smell</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getModelSmell()
	 * @see #getQuality_ModelSmell_Mapping()
	 * @generated
	 */
	EReference getQuality_ModelSmell_Mapping_ModelSmell();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getQualities <em>Qualities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Qualities</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Quality_ModelSmell_Mapping#getQualities()
	 * @see #getQuality_ModelSmell_Mapping()
	 * @generated
	 */
	EReference getQuality_ModelSmell_Mapping_Qualities();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.modelSmells.smell_model.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping <em>Metric Quality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Quality Mapping</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping
	 * @generated
	 */
	EClass getMetric_Quality_Mapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getFactor()
	 * @see #getMetric_Quality_Mapping()
	 * @generated
	 */
	EAttribute getMetric_Quality_Mapping_Factor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Quality</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getQuality()
	 * @see #getMetric_Quality_Mapping()
	 * @generated
	 */
	EReference getMetric_Quality_Mapping_Quality();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metrics</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Metric_Quality_Mapping#getMetrics()
	 * @see #getMetric_Quality_Mapping()
	 * @generated
	 */
	EReference getMetric_Quality_Mapping_Metrics();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.modelSmells.smell_model.Main <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Main</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main
	 * @generated
	 */
	EClass getMain();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Main#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Smell role Mapping</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main#getModelSmell_roleMapping()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_ModelSmell_roleMapping();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Main#getQuality_modelSmell <em>Quality model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Quality model Smell</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main#getQuality_modelSmell()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Quality_modelSmell();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Main#getMetric_quality <em>Metric quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metric quality</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main#getMetric_quality()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Metric_quality();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Main#getQualities <em>Qualities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Qualities</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main#getQualities()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Qualities();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Main#getModelSmells <em>Model Smells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Smells</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main#getModelSmells()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_ModelSmells();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.modelSmells.smell_model.Main#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metrics</em>'.
	 * @see org.eclipse.emf.modelSmells.smell_model.Main#getMetrics()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Metrics();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Smell_modelFactory getSmell_modelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.ModelSmellImpl <em>Model Smell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.ModelSmellImpl
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getModelSmell()
		 * @generated
		 */
		EClass MODEL_SMELL = eINSTANCE.getModelSmell();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL__NAME = eINSTANCE.getModelSmell_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.ModelSmell_Rolemapping_MappingImpl <em>Model Smell Rolemapping Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.ModelSmell_Rolemapping_MappingImpl
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getModelSmell_Rolemapping_Mapping()
		 * @generated
		 */
		EClass MODEL_SMELL_ROLEMAPPING_MAPPING = eINSTANCE.getModelSmell_Rolemapping_Mapping();

		/**
		 * The meta object literal for the '<em><b>Model Smell</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL = eINSTANCE.getModelSmell_Rolemapping_Mapping_ModelSmell();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.QualityImpl <em>Quality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.QualityImpl
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getQuality()
		 * @generated
		 */
		EClass QUALITY = eINSTANCE.getQuality();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY__NAME = eINSTANCE.getQuality_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.Quality_ModelSmell_MappingImpl <em>Quality Model Smell Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Quality_ModelSmell_MappingImpl
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getQuality_ModelSmell_Mapping()
		 * @generated
		 */
		EClass QUALITY_MODEL_SMELL_MAPPING = eINSTANCE.getQuality_ModelSmell_Mapping();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_MODEL_SMELL_MAPPING__FACTOR = eINSTANCE.getQuality_ModelSmell_Mapping_Factor();

		/**
		 * The meta object literal for the '<em><b>Model Smell</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_MODEL_SMELL_MAPPING__MODEL_SMELL = eINSTANCE.getQuality_ModelSmell_Mapping_ModelSmell();

		/**
		 * The meta object literal for the '<em><b>Qualities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_MODEL_SMELL_MAPPING__QUALITIES = eINSTANCE.getQuality_ModelSmell_Mapping_Qualities();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.Metric <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.Metric
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.Metric_Quality_MappingImpl <em>Metric Quality Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Metric_Quality_MappingImpl
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getMetric_Quality_Mapping()
		 * @generated
		 */
		EClass METRIC_QUALITY_MAPPING = eINSTANCE.getMetric_Quality_Mapping();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_QUALITY_MAPPING__FACTOR = eINSTANCE.getMetric_Quality_Mapping_Factor();

		/**
		 * The meta object literal for the '<em><b>Quality</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_QUALITY_MAPPING__QUALITY = eINSTANCE.getMetric_Quality_Mapping_Quality();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_QUALITY_MAPPING__METRICS = eINSTANCE.getMetric_Quality_Mapping_Metrics();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.modelSmells.smell_model.impl.MainImpl <em>Main</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.MainImpl
		 * @see org.eclipse.emf.modelSmells.smell_model.impl.Smell_modelPackageImpl#getMain()
		 * @generated
		 */
		EClass MAIN = eINSTANCE.getMain();

		/**
		 * The meta object literal for the '<em><b>Model Smell role Mapping</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__MODEL_SMELL_ROLE_MAPPING = eINSTANCE.getMain_ModelSmell_roleMapping();

		/**
		 * The meta object literal for the '<em><b>Quality model Smell</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__QUALITY_MODEL_SMELL = eINSTANCE.getMain_Quality_modelSmell();

		/**
		 * The meta object literal for the '<em><b>Metric quality</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__METRIC_QUALITY = eINSTANCE.getMain_Metric_quality();

		/**
		 * The meta object literal for the '<em><b>Qualities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__QUALITIES = eINSTANCE.getMain_Qualities();

		/**
		 * The meta object literal for the '<em><b>Model Smells</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__MODEL_SMELLS = eINSTANCE.getMain_ModelSmells();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__METRICS = eINSTANCE.getMain_Metrics();

	}

} //Smell_modelPackage
