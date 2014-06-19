/**
 */
package org.modelrefactoring.evolution.coed.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.CoedFactory;
import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.Condition;
import org.modelrefactoring.evolution.coed.Event;
import org.modelrefactoring.evolution.coed.MetamodelImport;
import org.modelrefactoring.evolution.coed.PlainCondition;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoedPackageImpl extends EPackageImpl implements CoedPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass coEvolutionDefinitionEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass eventEClass = null;
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass conditionEClass = null;
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass actionEClass = null;
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass roleMappingEventEClass = null;
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass plainConditionEClass = null;
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass roleMappingActionEClass = null;

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metamodelImportEClass = null;

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
   * @see org.modelrefactoring.evolution.coed.CoedPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private CoedPackageImpl() {
    super(eNS_URI, CoedFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link CoedPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static CoedPackage init() {
    if (isInited) return (CoedPackage)EPackage.Registry.INSTANCE.getEPackage(CoedPackage.eNS_URI);

    // Obtain or create and register package
    CoedPackageImpl theCoedPackage = (CoedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CoedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CoedPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    RolemappingPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCoedPackage.createPackageContents();

    // Initialize created meta-data
    theCoedPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCoedPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CoedPackage.eNS_URI, theCoedPackage);
    return theCoedPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCoEvolutionDefinition() {
    return coEvolutionDefinitionEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCoEvolutionDefinition_Event() {
    return (EReference)coEvolutionDefinitionEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCoEvolutionDefinition_Condition() {
    return (EReference)coEvolutionDefinitionEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCoEvolutionDefinition_Action() {
    return (EReference)coEvolutionDefinitionEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getCoEvolutionDefinition_Metamodel() {
    return (EReference)coEvolutionDefinitionEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCoEvolutionDefinition_Imports()
  {
    return (EReference)coEvolutionDefinitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getEvent() {
    return eventEClass;
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEvent_CoED()
  {
    return (EReference)eventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCondition() {
    return conditionEClass;
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCondition_CoED()
  {
    return (EReference)conditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAction() {
    return actionEClass;
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAction_CoED()
  {
    return (EReference)actionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getRoleMappingEvent() {
    return roleMappingEventEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getRoleMappingEvent_ConcreteRefactoring() {
    return (EReference)roleMappingEventEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleMappingEvent_MetamodelImport()
  {
    return (EReference)roleMappingEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPlainCondition() {
    return plainConditionEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getPlainCondition_Condition() {
    return (EAttribute)plainConditionEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getRoleMappingAction() {
    return roleMappingActionEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getRoleMappingAction_ConcreteRefactoring() {
    return (EReference)roleMappingActionEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getRoleMappingAction_Binding() {
    return (EAttribute)roleMappingActionEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetamodelImport()
  {
    return metamodelImportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMetamodelImport_Metamodel()
  {
    return (EReference)metamodelImportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetamodelImport_Shortcut()
  {
    return (EAttribute)metamodelImportEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CoedFactory getCoedFactory() {
    return (CoedFactory)getEFactoryInstance();
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
    coEvolutionDefinitionEClass = createEClass(CO_EVOLUTION_DEFINITION);
    createEReference(coEvolutionDefinitionEClass, CO_EVOLUTION_DEFINITION__EVENT);
    createEReference(coEvolutionDefinitionEClass, CO_EVOLUTION_DEFINITION__CONDITION);
    createEReference(coEvolutionDefinitionEClass, CO_EVOLUTION_DEFINITION__ACTION);
    createEReference(coEvolutionDefinitionEClass, CO_EVOLUTION_DEFINITION__METAMODEL);
    createEReference(coEvolutionDefinitionEClass, CO_EVOLUTION_DEFINITION__IMPORTS);

    eventEClass = createEClass(EVENT);
    createEReference(eventEClass, EVENT__CO_ED);

    conditionEClass = createEClass(CONDITION);
    createEReference(conditionEClass, CONDITION__CO_ED);

    actionEClass = createEClass(ACTION);
    createEReference(actionEClass, ACTION__CO_ED);

    roleMappingEventEClass = createEClass(ROLE_MAPPING_EVENT);
    createEReference(roleMappingEventEClass, ROLE_MAPPING_EVENT__CONCRETE_REFACTORING);
    createEReference(roleMappingEventEClass, ROLE_MAPPING_EVENT__METAMODEL_IMPORT);

    plainConditionEClass = createEClass(PLAIN_CONDITION);
    createEAttribute(plainConditionEClass, PLAIN_CONDITION__CONDITION);

    roleMappingActionEClass = createEClass(ROLE_MAPPING_ACTION);
    createEReference(roleMappingActionEClass, ROLE_MAPPING_ACTION__CONCRETE_REFACTORING);
    createEAttribute(roleMappingActionEClass, ROLE_MAPPING_ACTION__BINDING);

    metamodelImportEClass = createEClass(METAMODEL_IMPORT);
    createEReference(metamodelImportEClass, METAMODEL_IMPORT__METAMODEL);
    createEAttribute(metamodelImportEClass, METAMODEL_IMPORT__SHORTCUT);
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
    roleMappingEventEClass.getESuperTypes().add(this.getEvent());
    plainConditionEClass.getESuperTypes().add(this.getCondition());
    roleMappingActionEClass.getESuperTypes().add(this.getAction());

    // Initialize classes, features, and operations; add parameters
    initEClass(coEvolutionDefinitionEClass, CoEvolutionDefinition.class, "CoEvolutionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCoEvolutionDefinition_Event(), this.getEvent(), this.getEvent_CoED(), "event", null, 1, 1, CoEvolutionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoEvolutionDefinition_Condition(), this.getCondition(), this.getCondition_CoED(), "condition", null, 0, 1, CoEvolutionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoEvolutionDefinition_Action(), this.getAction(), this.getAction_CoED(), "action", null, 1, 1, CoEvolutionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoEvolutionDefinition_Metamodel(), theEcorePackage.getEPackage(), null, "metamodel", null, 1, 1, CoEvolutionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoEvolutionDefinition_Imports(), this.getMetamodelImport(), null, "imports", null, 0, -1, CoEvolutionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEvent_CoED(), this.getCoEvolutionDefinition(), this.getCoEvolutionDefinition_Event(), "coED", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionEClass, Condition.class, "Condition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCondition_CoED(), this.getCoEvolutionDefinition(), this.getCoEvolutionDefinition_Condition(), "coED", null, 1, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAction_CoED(), this.getCoEvolutionDefinition(), this.getCoEvolutionDefinition_Action(), "coED", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleMappingEventEClass, RoleMappingEvent.class, "RoleMappingEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleMappingEvent_ConcreteRefactoring(), theRolemappingPackage.getRoleMapping(), null, "concreteRefactoring", null, 1, 1, RoleMappingEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoleMappingEvent_MetamodelImport(), this.getMetamodelImport(), null, "metamodelImport", null, 1, 1, RoleMappingEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(plainConditionEClass, PlainCondition.class, "PlainCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPlainCondition_Condition(), theEcorePackage.getEString(), "condition", null, 1, 1, PlainCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleMappingActionEClass, RoleMappingAction.class, "RoleMappingAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleMappingAction_ConcreteRefactoring(), theRolemappingPackage.getRoleMapping(), null, "concreteRefactoring", null, 1, 1, RoleMappingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRoleMappingAction_Binding(), theEcorePackage.getEString(), "binding", null, 0, 1, RoleMappingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(metamodelImportEClass, MetamodelImport.class, "MetamodelImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMetamodelImport_Metamodel(), theEcorePackage.getEPackage(), null, "metamodel", null, 1, 1, MetamodelImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetamodelImport_Shortcut(), theEcorePackage.getEString(), "shortcut", null, 1, 1, MetamodelImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CoedPackageImpl
