/**
 */
package org.emftext.modelSmells.smell_model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.modelSmells.smell_model.Component;
import org.emftext.modelSmells.smell_model.Main;
import org.emftext.modelSmells.smell_model.Metric;
import org.emftext.modelSmells.smell_model.Metric_Quality_Mapping;
import org.emftext.modelSmells.smell_model.ModelSmell;
import org.emftext.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.modelSmells.smell_model.Observer;
import org.emftext.modelSmells.smell_model.Quality;
import org.emftext.modelSmells.smell_model.Quality_ModelSmell_Mapping;
import org.emftext.modelSmells.smell_model.Smell_modelFactory;
import org.emftext.modelSmells.smell_model.Smell_modelPackage;

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
	private EClass mainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observerEClass = null;

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
	 * @see org.emftext.modelSmells.smell_model.Smell_modelPackage#eNS_URI
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
	public EAttribute getQuality_ModelSmell_Mapping_Factor() {
		return (EAttribute)quality_ModelSmell_MappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuality_ModelSmell_Mapping_ModelSmell() {
		return (EReference)quality_ModelSmell_MappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuality_ModelSmell_Mapping_Qualities() {
		return (EReference)quality_ModelSmell_MappingEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getMetric_Quality_Mapping_Factor() {
		return (EAttribute)metric_Quality_MappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_Quality_Mapping_Quality() {
		return (EReference)metric_Quality_MappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_Quality_Mapping_Metrics() {
		return (EReference)metric_Quality_MappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMain() {
		return mainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_ModelSmell_roleMapping() {
		return (EReference)mainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Quality_modelSmell() {
		return (EReference)mainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Metric_quality() {
		return (EReference)mainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Gui() {
		return (EReference)mainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Qualities() {
		return (EReference)mainEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_ModelSmells() {
		return (EReference)mainEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Metrics() {
		return (EReference)mainEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGUI() {
		return guiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGUI_Components() {
		return (EReference)guiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
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

		qualityEClass = createEClass(QUALITY);
		createEAttribute(qualityEClass, QUALITY__NAME);

		quality_ModelSmell_MappingEClass = createEClass(QUALITY_MODEL_SMELL_MAPPING);
		createEAttribute(quality_ModelSmell_MappingEClass, QUALITY_MODEL_SMELL_MAPPING__FACTOR);
		createEReference(quality_ModelSmell_MappingEClass, QUALITY_MODEL_SMELL_MAPPING__MODEL_SMELL);
		createEReference(quality_ModelSmell_MappingEClass, QUALITY_MODEL_SMELL_MAPPING__QUALITIES);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__NAME);

		metric_Quality_MappingEClass = createEClass(METRIC_QUALITY_MAPPING);
		createEAttribute(metric_Quality_MappingEClass, METRIC_QUALITY_MAPPING__FACTOR);
		createEReference(metric_Quality_MappingEClass, METRIC_QUALITY_MAPPING__QUALITY);
		createEReference(metric_Quality_MappingEClass, METRIC_QUALITY_MAPPING__METRICS);

		mainEClass = createEClass(MAIN);
		createEReference(mainEClass, MAIN__MODEL_SMELL_ROLE_MAPPING);
		createEReference(mainEClass, MAIN__QUALITY_MODEL_SMELL);
		createEReference(mainEClass, MAIN__METRIC_QUALITY);
		createEReference(mainEClass, MAIN__GUI);
		createEReference(mainEClass, MAIN__QUALITIES);
		createEReference(mainEClass, MAIN__MODEL_SMELLS);
		createEReference(mainEClass, MAIN__METRICS);

		guiEClass = createEClass(GUI);
		createEReference(guiEClass, GUI__COMPONENTS);

		componentEClass = createEClass(COMPONENT);

		observerEClass = createEClass(OBSERVER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentEClass.getESuperTypes().add(this.getObserver());

		// Initialize classes and features; add operations and parameters
		initEClass(modelSmellEClass, ModelSmell.class, "ModelSmell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelSmell_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelSmell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelSmell_Rolemapping_MappingEClass, ModelSmell_Rolemapping_Mapping.class, "ModelSmell_Rolemapping_Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSmell_Rolemapping_Mapping_ModelSmell(), this.getModelSmell(), null, "modelSmell", null, 1, 1, ModelSmell_Rolemapping_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualityEClass, Quality.class, "Quality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuality_Name(), ecorePackage.getEString(), "name", null, 0, 1, Quality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quality_ModelSmell_MappingEClass, Quality_ModelSmell_Mapping.class, "Quality_ModelSmell_Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuality_ModelSmell_Mapping_Factor(), ecorePackage.getEFloat(), "factor", null, 0, 1, Quality_ModelSmell_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuality_ModelSmell_Mapping_ModelSmell(), this.getModelSmell(), null, "modelSmell", null, 1, 1, Quality_ModelSmell_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuality_ModelSmell_Mapping_Qualities(), this.getQuality(), null, "qualities", null, 1, -1, Quality_ModelSmell_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Name(), ecorePackage.getEString(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(metricEClass, null, "calculate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(metric_Quality_MappingEClass, Metric_Quality_Mapping.class, "Metric_Quality_Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Quality_Mapping_Factor(), ecorePackage.getEFloat(), "factor", null, 0, 1, Metric_Quality_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_Quality_Mapping_Quality(), this.getQuality(), null, "quality", null, 1, 1, Metric_Quality_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_Quality_Mapping_Metrics(), this.getMetric(), null, "metrics", null, 1, -1, Metric_Quality_Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mainEClass, Main.class, "Main", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMain_ModelSmell_roleMapping(), this.getModelSmell_Rolemapping_Mapping(), null, "modelSmell_roleMapping", null, 1, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Quality_modelSmell(), this.getQuality_ModelSmell_Mapping(), null, "quality_modelSmell", null, 1, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Metric_quality(), this.getMetric_Quality_Mapping(), null, "metric_quality", null, 1, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Gui(), this.getGUI(), null, "gui", null, 1, 1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Qualities(), this.getQuality(), null, "qualities", null, 1, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_ModelSmells(), this.getModelSmell(), null, "modelSmells", null, 1, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Metrics(), this.getMetric(), null, "metrics", null, 1, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mainEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mainEClass, null, "createModelSmell_Rolemapping_Mapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mainEClass, null, "createQuality_ModelSmell_Mapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mainEClass, null, "createMetric_Quality_Mapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mainEClass, null, "calculate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mainEClass, null, "updateGui", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mainEClass, null, "refactor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(guiEClass, org.emftext.modelSmells.smell_model.GUI.class, "GUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGUI_Components(), this.getComponent(), null, "components", null, 1, -1, org.emftext.modelSmells.smell_model.GUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(guiEClass, null, "notifyComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(guiEClass, null, "add", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(guiEClass, null, "remove", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(componentEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(observerEClass, Observer.class, "Observer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(observerEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Smell_modelPackageImpl
