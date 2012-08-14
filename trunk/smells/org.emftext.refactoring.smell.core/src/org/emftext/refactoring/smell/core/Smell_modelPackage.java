/**
 */
package org.emftext.refactoring.smell.core;

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
 * @see org.emftext.refactoring.smell.core.Smell_modelFactory
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
	Smell_modelPackage eINSTANCE = org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmellImpl <em>Model Smell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.ModelSmellImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmell()
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
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmell_Rolemapping_MappingImpl <em>Model Smell Rolemapping Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.ModelSmell_Rolemapping_MappingImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmell_Rolemapping_Mapping()
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
	 * The feature id for the '<em><b>Role Mapping</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Mapping Concretisation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION = 2;

	/**
	 * The feature id for the '<em><b>Metamodel Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION = 3;

	/**
	 * The number of structural features of the '<em>Model Smell Rolemapping Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_ROLEMAPPING_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.QualityImpl <em>Quality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.QualityImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getQuality()
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
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.MappingImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 8;

	/**
	 * The feature id for the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__FACTOR = 0;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.Quality_ModelSmell_MappingImpl <em>Quality Model Smell Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.Quality_ModelSmell_MappingImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getQuality_ModelSmell_Mapping()
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
	int QUALITY_MODEL_SMELL_MAPPING__FACTOR = MAPPING__FACTOR;

	/**
	 * The feature id for the '<em><b>Model Smell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING__MODEL_SMELL = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING__QUALITY = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Quality Model Smell Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_MODEL_SMELL_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.Metric <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.Metric
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMetric()
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
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.Metric_Quality_MappingImpl <em>Metric Quality Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.Metric_Quality_MappingImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMetric_Quality_Mapping()
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
	int METRIC_QUALITY_MAPPING__FACTOR = MAPPING__FACTOR;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING__QUALITY = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING__METRIC = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Metric Quality Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_QUALITY_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl <em>Model Smell Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmellModel()
	 * @generated
	 */
	int MODEL_SMELL_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Model Smell role Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Quality model Smell</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL = 1;

	/**
	 * The feature id for the '<em><b>Metric quality</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__METRIC_QUALITY = 2;

	/**
	 * The feature id for the '<em><b>Qualities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__QUALITIES = 3;

	/**
	 * The feature id for the '<em><b>Model Smells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__MODEL_SMELLS = 4;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__METRICS = 5;

	/**
	 * The feature id for the '<em><b>Loaded Resource Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__LOADED_RESOURCE_PATH = 6;

	/**
	 * The feature id for the '<em><b>Quality Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__QUALITY_SCALE = 7;

	/**
	 * The feature id for the '<em><b>Observer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__OBSERVER = 8;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__RESULT = 9;

	/**
	 * The feature id for the '<em><b>Model Smell Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION = 10;

	/**
	 * The feature id for the '<em><b>Metric Result Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL__METRIC_RESULT_MAP = 11;

	/**
	 * The number of structural features of the '<em>Model Smell Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_MODEL_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.RoleMappingImpl <em>Role Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.RoleMappingImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getRoleMapping()
	 * @generated
	 */
	int ROLE_MAPPING = 7;

	/**
	 * The number of structural features of the '<em>Role Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_MAPPING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.MappingConcretisationImpl <em>Mapping Concretisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.MappingConcretisationImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMappingConcretisation()
	 * @generated
	 */
	int MAPPING_CONCRETISATION = 9;

	/**
	 * The feature id for the '<em><b>New Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONCRETISATION__NEW_FACTOR = 0;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONCRETISATION__MAPPING = 1;

	/**
	 * The number of structural features of the '<em>Mapping Concretisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONCRETISATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.Observer <em>Observer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.Observer
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getObserver()
	 * @generated
	 */
	int OBSERVER = 10;

	/**
	 * The number of structural features of the '<em>Observer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmellResultImpl <em>Model Smell Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.core.impl.ModelSmellResultImpl
	 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmellResult()
	 * @generated
	 */
	int MODEL_SMELL_RESULT = 11;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_RESULT__RESULT = 0;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_RESULT__THRESHOLD = 1;

	/**
	 * The number of structural features of the '<em>Model Smell Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SMELL_RESULT_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.ModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Smell</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell
	 * @generated
	 */
	EClass getModelSmell();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmell#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell#getName()
	 * @see #getModelSmell()
	 * @generated
	 */
	EAttribute getModelSmell_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping <em>Model Smell Rolemapping Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Smell Rolemapping Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping
	 * @generated
	 */
	EClass getModelSmell_Rolemapping_Mapping();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Smell</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getModelSmell()
	 * @see #getModelSmell_Rolemapping_Mapping()
	 * @generated
	 */
	EReference getModelSmell_Rolemapping_Mapping_ModelSmell();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getRoleMapping <em>Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Role Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getRoleMapping()
	 * @see #getModelSmell_Rolemapping_Mapping()
	 * @generated
	 */
	EReference getModelSmell_Rolemapping_Mapping_RoleMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getMappingConcretisation <em>Mapping Concretisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Concretisation</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getMappingConcretisation()
	 * @see #getModelSmell_Rolemapping_Mapping()
	 * @generated
	 */
	EReference getModelSmell_Rolemapping_Mapping_MappingConcretisation();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getMetamodelSpecification <em>Metamodel Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel Specification</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmell_Rolemapping_Mapping#getMetamodelSpecification()
	 * @see #getModelSmell_Rolemapping_Mapping()
	 * @generated
	 */
	EReference getModelSmell_Rolemapping_Mapping_MetamodelSpecification();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.Quality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality</em>'.
	 * @see org.emftext.refactoring.smell.core.Quality
	 * @generated
	 */
	EClass getQuality();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.Quality#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.core.Quality#getName()
	 * @see #getQuality()
	 * @generated
	 */
	EAttribute getQuality_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping <em>Quality Model Smell Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Model Smell Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping
	 * @generated
	 */
	EClass getQuality_ModelSmell_Mapping();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping#getModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Smell</em>'.
	 * @see org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping#getModelSmell()
	 * @see #getQuality_ModelSmell_Mapping()
	 * @generated
	 */
	EReference getQuality_ModelSmell_Mapping_ModelSmell();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Quality</em>'.
	 * @see org.emftext.refactoring.smell.core.Quality_ModelSmell_Mapping#getQuality()
	 * @see #getQuality_ModelSmell_Mapping()
	 * @generated
	 */
	EReference getQuality_ModelSmell_Mapping_Quality();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see org.emftext.refactoring.smell.core.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.core.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.Metric_Quality_Mapping <em>Metric Quality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Quality Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.Metric_Quality_Mapping
	 * @generated
	 */
	EClass getMetric_Quality_Mapping();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.Metric_Quality_Mapping#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Quality</em>'.
	 * @see org.emftext.refactoring.smell.core.Metric_Quality_Mapping#getQuality()
	 * @see #getMetric_Quality_Mapping()
	 * @generated
	 */
	EReference getMetric_Quality_Mapping_Quality();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.Metric_Quality_Mapping#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see org.emftext.refactoring.smell.core.Metric_Quality_Mapping#getMetric()
	 * @see #getMetric_Quality_Mapping()
	 * @generated
	 */
	EReference getMetric_Quality_Mapping_Metric();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.ModelSmellModel <em>Model Smell Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Smell Model</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel
	 * @generated
	 */
	EClass getModelSmellModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Smell role Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmell_roleMapping()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_ModelSmell_roleMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQuality_modelSmell <em>Quality model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Quality model Smell</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getQuality_modelSmell()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_Quality_modelSmell();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetric_quality <em>Metric quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric quality</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getMetric_quality()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_Metric_quality();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQualities <em>Qualities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Qualities</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getQualities()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_Qualities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmells <em>Model Smells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Smells</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmells()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_ModelSmells();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getMetrics()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_Metrics();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getLoadedResourcePath <em>Loaded Resource Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaded Resource Path</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getLoadedResourcePath()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EAttribute getModelSmellModel_LoadedResourcePath();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getQualityScale <em>Quality Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Scale</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getQualityScale()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EAttribute getModelSmellModel_QualityScale();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getObserver <em>Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Observer</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getObserver()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EAttribute getModelSmellModel_Observer();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getResult()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EReference getModelSmellModel_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmellDescription <em>Model Smell Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Smell Description</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getModelSmellDescription()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EAttribute getModelSmellModel_ModelSmellDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellModel#getMetricResultMap <em>Metric Result Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metric Result Map</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellModel#getMetricResultMap()
	 * @see #getModelSmellModel()
	 * @generated
	 */
	EAttribute getModelSmellModel_MetricResultMap();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.RoleMapping <em>Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.RoleMapping
	 * @generated
	 */
	EClass getRoleMapping();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.Mapping#getFactor <em>Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factor</em>'.
	 * @see org.emftext.refactoring.smell.core.Mapping#getFactor()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Factor();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.MappingConcretisation <em>Mapping Concretisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Concretisation</em>'.
	 * @see org.emftext.refactoring.smell.core.MappingConcretisation
	 * @generated
	 */
	EClass getMappingConcretisation();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.MappingConcretisation#getNewFactor <em>New Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Factor</em>'.
	 * @see org.emftext.refactoring.smell.core.MappingConcretisation#getNewFactor()
	 * @see #getMappingConcretisation()
	 * @generated
	 */
	EAttribute getMappingConcretisation_NewFactor();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.core.MappingConcretisation#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.emftext.refactoring.smell.core.MappingConcretisation#getMapping()
	 * @see #getMappingConcretisation()
	 * @generated
	 */
	EReference getMappingConcretisation_Mapping();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.Observer <em>Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observer</em>'.
	 * @see org.emftext.refactoring.smell.core.Observer
	 * @generated
	 */
	EClass getObserver();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.core.ModelSmellResult <em>Model Smell Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Smell Result</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellResult
	 * @generated
	 */
	EClass getModelSmellResult();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellResult#getResult()
	 * @see #getModelSmellResult()
	 * @generated
	 */
	EAttribute getModelSmellResult_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.core.ModelSmellResult#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see org.emftext.refactoring.smell.core.ModelSmellResult#getThreshold()
	 * @see #getModelSmellResult()
	 * @generated
	 */
	EAttribute getModelSmellResult_Threshold();

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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmellImpl <em>Model Smell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.ModelSmellImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmell()
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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmell_Rolemapping_MappingImpl <em>Model Smell Rolemapping Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.ModelSmell_Rolemapping_MappingImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmell_Rolemapping_Mapping()
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
		 * The meta object literal for the '<em><b>Role Mapping</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPING = eINSTANCE.getModelSmell_Rolemapping_Mapping_RoleMapping();

		/**
		 * The meta object literal for the '<em><b>Mapping Concretisation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION = eINSTANCE.getModelSmell_Rolemapping_Mapping_MappingConcretisation();

		/**
		 * The meta object literal for the '<em><b>Metamodel Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_ROLEMAPPING_MAPPING__METAMODEL_SPECIFICATION = eINSTANCE.getModelSmell_Rolemapping_Mapping_MetamodelSpecification();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.QualityImpl <em>Quality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.QualityImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getQuality()
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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.Quality_ModelSmell_MappingImpl <em>Quality Model Smell Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.Quality_ModelSmell_MappingImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getQuality_ModelSmell_Mapping()
		 * @generated
		 */
		EClass QUALITY_MODEL_SMELL_MAPPING = eINSTANCE.getQuality_ModelSmell_Mapping();

		/**
		 * The meta object literal for the '<em><b>Model Smell</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_MODEL_SMELL_MAPPING__MODEL_SMELL = eINSTANCE.getQuality_ModelSmell_Mapping_ModelSmell();

		/**
		 * The meta object literal for the '<em><b>Quality</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_MODEL_SMELL_MAPPING__QUALITY = eINSTANCE.getQuality_ModelSmell_Mapping_Quality();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.Metric <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.Metric
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMetric()
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
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.Metric_Quality_MappingImpl <em>Metric Quality Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.Metric_Quality_MappingImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMetric_Quality_Mapping()
		 * @generated
		 */
		EClass METRIC_QUALITY_MAPPING = eINSTANCE.getMetric_Quality_Mapping();

		/**
		 * The meta object literal for the '<em><b>Quality</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_QUALITY_MAPPING__QUALITY = eINSTANCE.getMetric_Quality_Mapping_Quality();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_QUALITY_MAPPING__METRIC = eINSTANCE.getMetric_Quality_Mapping_Metric();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl <em>Model Smell Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.ModelSmellModelImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmellModel()
		 * @generated
		 */
		EClass MODEL_SMELL_MODEL = eINSTANCE.getModelSmellModel();

		/**
		 * The meta object literal for the '<em><b>Model Smell role Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING = eINSTANCE.getModelSmellModel_ModelSmell_roleMapping();

		/**
		 * The meta object literal for the '<em><b>Quality model Smell</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL = eINSTANCE.getModelSmellModel_Quality_modelSmell();

		/**
		 * The meta object literal for the '<em><b>Metric quality</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__METRIC_QUALITY = eINSTANCE.getModelSmellModel_Metric_quality();

		/**
		 * The meta object literal for the '<em><b>Qualities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__QUALITIES = eINSTANCE.getModelSmellModel_Qualities();

		/**
		 * The meta object literal for the '<em><b>Model Smells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__MODEL_SMELLS = eINSTANCE.getModelSmellModel_ModelSmells();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__METRICS = eINSTANCE.getModelSmellModel_Metrics();

		/**
		 * The meta object literal for the '<em><b>Loaded Resource Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_MODEL__LOADED_RESOURCE_PATH = eINSTANCE.getModelSmellModel_LoadedResourcePath();

		/**
		 * The meta object literal for the '<em><b>Quality Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_MODEL__QUALITY_SCALE = eINSTANCE.getModelSmellModel_QualityScale();

		/**
		 * The meta object literal for the '<em><b>Observer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_MODEL__OBSERVER = eINSTANCE.getModelSmellModel_Observer();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SMELL_MODEL__RESULT = eINSTANCE.getModelSmellModel_Result();

		/**
		 * The meta object literal for the '<em><b>Model Smell Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION = eINSTANCE.getModelSmellModel_ModelSmellDescription();

		/**
		 * The meta object literal for the '<em><b>Metric Result Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_MODEL__METRIC_RESULT_MAP = eINSTANCE.getModelSmellModel_MetricResultMap();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.RoleMappingImpl <em>Role Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.RoleMappingImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getRoleMapping()
		 * @generated
		 */
		EClass ROLE_MAPPING = eINSTANCE.getRoleMapping();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.MappingImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__FACTOR = eINSTANCE.getMapping_Factor();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.MappingConcretisationImpl <em>Mapping Concretisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.MappingConcretisationImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getMappingConcretisation()
		 * @generated
		 */
		EClass MAPPING_CONCRETISATION = eINSTANCE.getMappingConcretisation();

		/**
		 * The meta object literal for the '<em><b>New Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CONCRETISATION__NEW_FACTOR = eINSTANCE.getMappingConcretisation_NewFactor();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CONCRETISATION__MAPPING = eINSTANCE.getMappingConcretisation_Mapping();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.Observer <em>Observer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.Observer
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getObserver()
		 * @generated
		 */
		EClass OBSERVER = eINSTANCE.getObserver();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.core.impl.ModelSmellResultImpl <em>Model Smell Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.core.impl.ModelSmellResultImpl
		 * @see org.emftext.refactoring.smell.core.impl.Smell_modelPackageImpl#getModelSmellResult()
		 * @generated
		 */
		EClass MODEL_SMELL_RESULT = eINSTANCE.getModelSmellResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_RESULT__RESULT = eINSTANCE.getModelSmellResult_Result();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SMELL_RESULT__THRESHOLD = eINSTANCE.getModelSmellResult_Threshold();

	}

} //Smell_modelPackage
