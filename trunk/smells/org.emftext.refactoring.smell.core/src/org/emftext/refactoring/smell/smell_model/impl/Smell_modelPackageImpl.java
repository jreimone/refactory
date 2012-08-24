/**
 */
package org.emftext.refactoring.smell.smell_model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.refactoring.smell.smell_model.Mapping;
import org.emftext.refactoring.smell.smell_model.MappingConcretisation;
import org.emftext.refactoring.smell.smell_model.Metric;
import org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmellModel;
import org.emftext.refactoring.smell.smell_model.ModelSmellResult;
import org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.refactoring.smell.smell_model.Observer;
import org.emftext.refactoring.smell.smell_model.Quality;
import org.emftext.refactoring.smell.smell_model.Quality_ModelSmell_Mapping;
import org.emftext.refactoring.smell.smell_model.RoleMapping;
import org.emftext.refactoring.smell.smell_model.Smell_modelFactory;
import org.emftext.refactoring.smell.smell_model.Smell_modelPackage;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Smell_modelPackageImpl extends EPackageImpl implements Smell_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelSmellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelSmell_Rolemapping_MappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quality_ModelSmell_MappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metric_Quality_MappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelSmellModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingConcretisationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelSmellResultEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Smell_modelPackageImpl() {
		super(eNS_URI, Smell_modelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Smell_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Smell_modelPackage init() {
		if (isInited) return (Smell_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Smell_modelPackage.eNS_URI);

		// Obtain or create and register package
		Smell_modelPackageImpl theSmell_modelPackage = (Smell_modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Smell_modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Smell_modelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RolemappingPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSmell_modelPackage.createPackageContents();

		// Initialize created meta-data
		theSmell_modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSmell_modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Smell_modelPackage.eNS_URI, theSmell_modelPackage);
		return theSmell_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSmell() {
		return modelSmellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmell_Name() {
		return (EAttribute)modelSmellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSmell_Rolemapping_Mapping() {
		return modelSmell_Rolemapping_MappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmell_Rolemapping_Mapping_ModelSmell() {
		return (EReference)modelSmell_Rolemapping_MappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmell_Rolemapping_Mapping_MappingConcretisation() {
		return (EReference)modelSmell_Rolemapping_MappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmell_Rolemapping_Mapping_RoleMappings() {
		return (EReference)modelSmell_Rolemapping_MappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmell_Rolemapping_Mapping_MetaModelSpecification() {
		return (EReference)modelSmell_Rolemapping_MappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuality() {
		return qualityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuality_Name() {
		return (EAttribute)qualityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuality_ModelSmell_Mapping() {
		return quality_ModelSmell_MappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuality_ModelSmell_Mapping_ModelSmell() {
		return (EReference)quality_ModelSmell_MappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuality_ModelSmell_Mapping_Quality() {
		return (EReference)quality_ModelSmell_MappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Name() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric_Quality_Mapping() {
		return metric_Quality_MappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_Quality_Mapping_Quality() {
		return (EReference)metric_Quality_MappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_Quality_Mapping_Metric() {
		return (EReference)metric_Quality_MappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSmellModel() {
		return modelSmellModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_ModelSmell_roleMapping() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_Quality_modelSmell() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_Metric_quality() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_Qualities() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_ModelSmells() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_Metrics() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getModelSmellModel_LoadedResource()
  {
		return (EAttribute)modelSmellModelEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellModel_QualityScale() {
		return (EAttribute)modelSmellModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellModel_Observer() {
		return (EAttribute)modelSmellModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_Result() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellModel_ModelSmellDescription() {
		return (EAttribute)modelSmellModelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellModel_MetricResultMap() {
		return (EAttribute)modelSmellModelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSmellModel_LoadedMetaModel() {
		return (EReference)modelSmellModelEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellModel_Threshold() {
		return (EAttribute)modelSmellModelEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleMapping() {
		return roleMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Factor() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingConcretisation() {
		return mappingConcretisationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingConcretisation_NewFactor() {
		return (EAttribute)mappingConcretisationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingConcretisation_Mapping() {
		return (EReference)mappingConcretisationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObserver() {
		return observerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSmellResult() {
		return modelSmellResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellResult_Result() {
		return (EAttribute)modelSmellResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSmellResult_Threshold() {
		return (EAttribute)modelSmellResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Smell_modelFactory getSmell_modelFactory() {
		return (Smell_modelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelSmellEClass = createEClass(MODEL_SMELL);
		createEAttribute(modelSmellEClass, MODEL_SMELL__NAME);

		modelSmell_Rolemapping_MappingEClass = createEClass(MODEL_SMELL_ROLEMAPPING_MAPPING);
		createEReference(modelSmell_Rolemapping_MappingEClass, MODEL_SMELL_ROLEMAPPING_MAPPING__MODEL_SMELL);
		createEReference(modelSmell_Rolemapping_MappingEClass, MODEL_SMELL_ROLEMAPPING_MAPPING__MAPPING_CONCRETISATION);
		createEReference(modelSmell_Rolemapping_MappingEClass, MODEL_SMELL_ROLEMAPPING_MAPPING__ROLE_MAPPINGS);
		createEReference(modelSmell_Rolemapping_MappingEClass, MODEL_SMELL_ROLEMAPPING_MAPPING__META_MODEL_SPECIFICATION);

		qualityEClass = createEClass(QUALITY);
		createEAttribute(qualityEClass, QUALITY__NAME);

		quality_ModelSmell_MappingEClass = createEClass(QUALITY_MODEL_SMELL_MAPPING);
		createEReference(quality_ModelSmell_MappingEClass, QUALITY_MODEL_SMELL_MAPPING__MODEL_SMELL);
		createEReference(quality_ModelSmell_MappingEClass, QUALITY_MODEL_SMELL_MAPPING__QUALITY);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__NAME);

		metric_Quality_MappingEClass = createEClass(METRIC_QUALITY_MAPPING);
		createEReference(metric_Quality_MappingEClass, METRIC_QUALITY_MAPPING__QUALITY);
		createEReference(metric_Quality_MappingEClass, METRIC_QUALITY_MAPPING__METRIC);

		modelSmellModelEClass = createEClass(MODEL_SMELL_MODEL);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__MODEL_SMELL_ROLE_MAPPING);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__QUALITY_MODEL_SMELL);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__METRIC_QUALITY);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__QUALITIES);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__MODEL_SMELLS);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__METRICS);
		createEAttribute(modelSmellModelEClass, MODEL_SMELL_MODEL__LOADED_RESOURCE);
		createEAttribute(modelSmellModelEClass, MODEL_SMELL_MODEL__QUALITY_SCALE);
		createEAttribute(modelSmellModelEClass, MODEL_SMELL_MODEL__OBSERVER);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__RESULT);
		createEAttribute(modelSmellModelEClass, MODEL_SMELL_MODEL__MODEL_SMELL_DESCRIPTION);
		createEAttribute(modelSmellModelEClass, MODEL_SMELL_MODEL__METRIC_RESULT_MAP);
		createEReference(modelSmellModelEClass, MODEL_SMELL_MODEL__LOADED_META_MODEL);
		createEAttribute(modelSmellModelEClass, MODEL_SMELL_MODEL__THRESHOLD);

		roleMappingEClass = createEClass(ROLE_MAPPING);

		mappingEClass = createEClass(MAPPING);
		createEAttribute(mappingEClass, MAPPING__FACTOR);

		mappingConcretisationEClass = createEClass(MAPPING_CONCRETISATION);
		createEAttribute(mappingConcretisationEClass, MAPPING_CONCRETISATION__NEW_FACTOR);
		createEReference(mappingConcretisationEClass, MAPPING_CONCRETISATION__MAPPING);

		observerEClass = createEClass(OBSERVER);

		modelSmellResultEClass = createEClass(MODEL_SMELL_RESULT);
		createEAttribute(modelSmellResultEClass, MODEL_SMELL_RESULT__RESULT);
		createEAttribute(modelSmellResultEClass, MODEL_SMELL_RESULT__THRESHOLD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		RolemappingPackage theRolemappingPackage = (RolemappingPackage)EPackage.Registry.INSTANCE.getEPackage(RolemappingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		quality_ModelSmell_MappingEClass.getESuperTypes().add(this.getMapping());
		metric_Quality_MappingEClass.getESuperTypes().add(this.getMapping());

		// Initialize classes and features; add operations and parameters
		initEClass(modelSmellEClass, ModelSmell.class, "ModelSmell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelSmell_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ModelSmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelSmell_Rolemapping_MappingEClass, ModelSmell_Rolemapping_Mapping.class, "ModelSmell_Rolemapping_Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSmell_Rolemapping_Mapping_ModelSmell(), this.getModelSmell(), null, "modelSmell", null, 1, 1, ModelSmell_Rolemapping_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmell_Rolemapping_Mapping_MappingConcretisation(), this.getMappingConcretisation(), null, "mappingConcretisation", null, 0, -1, ModelSmell_Rolemapping_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmell_Rolemapping_Mapping_RoleMappings(), theRolemappingPackage.getRoleMapping(), null, "roleMappings", null, 1, -1, ModelSmell_Rolemapping_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmell_Rolemapping_Mapping_MetaModelSpecification(), theEcorePackage.getEPackage(), null, "metaModelSpecification", null, 1, 1, ModelSmell_Rolemapping_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualityEClass, Quality.class, "Quality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuality_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Quality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quality_ModelSmell_MappingEClass, Quality_ModelSmell_Mapping.class, "Quality_ModelSmell_Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuality_ModelSmell_Mapping_ModelSmell(), this.getModelSmell(), null, "modelSmell", null, 1, 1, Quality_ModelSmell_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuality_ModelSmell_Mapping_Quality(), this.getQuality(), null, "quality", null, 1, 1, Quality_ModelSmell_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(metricEClass, null, "calculate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEResource(), "loadedResource", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEMap());
		EGenericType g2 = createEGenericType(theEcorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEFloatObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(metric_Quality_MappingEClass, Metric_Quality_Mapping.class, "Metric_Quality_Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetric_Quality_Mapping_Quality(), this.getQuality(), null, "quality", null, 1, 1, Metric_Quality_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_Quality_Mapping_Metric(), this.getMetric(), null, "metric", null, 1, 1, Metric_Quality_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelSmellModelEClass, ModelSmellModel.class, "ModelSmellModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSmellModel_ModelSmell_roleMapping(), this.getModelSmell_Rolemapping_Mapping(), null, "modelSmell_roleMapping", null, 1, -1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_Quality_modelSmell(), this.getQuality_ModelSmell_Mapping(), null, "quality_modelSmell", null, 1, -1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_Metric_quality(), this.getMetric_Quality_Mapping(), null, "metric_quality", null, 1, -1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_Qualities(), this.getQuality(), null, "qualities", null, 1, -1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_ModelSmells(), this.getModelSmell(), null, "modelSmells", null, 1, -1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_Metrics(), this.getMetric(), null, "metrics", null, 1, -1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelSmellModel_LoadedResource(), theEcorePackage.getEResource(), "loadedResource", "", 0, 1, ModelSmellModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(this.getQuality());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEFloatObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getModelSmellModel_QualityScale(), g1, "qualityScale", "", 0, 1, ModelSmellModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEEList());
		g2 = createEGenericType(this.getObserver());
		g1.getETypeArguments().add(g2);
		initEAttribute(getModelSmellModel_Observer(), g1, "observer", null, 0, 1, ModelSmellModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_Result(), this.getModelSmellResult(), null, "result", null, 1, 1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(this.getModelSmell());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getModelSmellModel_ModelSmellDescription(), g1, "modelSmellDescription", null, 0, 1, ModelSmellModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(this.getMetric());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEMap());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theEcorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(theEcorePackage.getEFloatObject());
		g2.getETypeArguments().add(g3);
		initEAttribute(getModelSmellModel_MetricResultMap(), g1, "metricResultMap", null, 0, 1, ModelSmellModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSmellModel_LoadedMetaModel(), theEcorePackage.getEPackage(), null, "loadedMetaModel", null, 1, 1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelSmellModel_Threshold(), theEcorePackage.getEFloatObject(), "threshold", null, 0, 1, ModelSmellModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(modelSmellModelEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(modelSmellModelEClass, null, "calculate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(modelSmellModelEClass, null, "register", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObserver(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(modelSmellModelEClass, null, "unregister", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObserver(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(modelSmellModelEClass, null, "inform", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(modelSmellModelEClass, theEcorePackage.getEString(), "getNamespace", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(roleMappingEClass, RoleMapping.class, "RoleMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapping_Factor(), theEcorePackage.getEFloatObject(), "factor", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingConcretisationEClass, MappingConcretisation.class, "MappingConcretisation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingConcretisation_NewFactor(), theEcorePackage.getEFloatObject(), "newFactor", null, 0, 1, MappingConcretisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingConcretisation_Mapping(), this.getMapping(), null, "mapping", null, 1, 1, MappingConcretisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observerEClass, Observer.class, "Observer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(observerEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelSmellResultEClass, ModelSmellResult.class, "ModelSmellResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(this.getModelSmell());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEMap());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(theEcorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(theEcorePackage.getEFloatObject());
		g2.getETypeArguments().add(g3);
		initEAttribute(getModelSmellResult_Result(), g1, "result", null, 0, 1, ModelSmellResult.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelSmellResult_Threshold(), theEcorePackage.getEFloatObject(), "threshold", null, 0, 1, ModelSmellResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(modelSmellResultEClass, null, "calculate", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEEList());
		g2 = createEGenericType(this.getMetric_Quality_Mapping());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "metric_quality", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEEList());
		g2 = createEGenericType(this.getQuality_ModelSmell_Mapping());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "quality_modelSmell", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(this.getMetric());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEMap());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(theEcorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(theEcorePackage.getEFloatObject());
		g2.getETypeArguments().add(g3);
		addEParameter(op, g1, "metricResultMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType(this.getQuality());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEFloatObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "qualityScale", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Smell_modelPackageImpl
