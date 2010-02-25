/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.refactoring.refactoring_specification.AttributeCommand;
import org.emftext.language.refactoring.refactoring_specification.ContainmentCommand;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.ReferenceCommand;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;

import org.emftext.language.refactoring.roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefactoringSpecificationPackageImpl extends EPackageImpl implements RefactoringSpecificationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refactoringSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignEClass = null;

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
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RefactoringSpecificationPackageImpl() {
		super(eNS_URI, RefactoringSpecificationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RefactoringSpecificationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RefactoringSpecificationPackage init() {
		if (isInited) return (RefactoringSpecificationPackage)EPackage.Registry.INSTANCE.getEPackage(RefactoringSpecificationPackage.eNS_URI);

		// Obtain or create and register package
		RefactoringSpecificationPackageImpl theRefactoringSpecificationPackage = (RefactoringSpecificationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RefactoringSpecificationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RefactoringSpecificationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RolesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRefactoringSpecificationPackage.createPackageContents();

		// Initialize created meta-data
		theRefactoringSpecificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRefactoringSpecificationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RefactoringSpecificationPackage.eNS_URI, theRefactoringSpecificationPackage);
		return theRefactoringSpecificationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefactoringSpecification() {
		return refactoringSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefactoringSpecification_UsedRoleModel() {
		return (EReference)refactoringSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRefactoringSpecification_Name() {
		return (EAttribute)refactoringSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefactoringSpecification_Instructions() {
		return (EReference)refactoringSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstruction() {
		return instructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainmentCommand() {
		return containmentCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCREATE() {
		return createEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCREATE_VarDeclaration() {
		return (EReference)createEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCREATE_SourceRoleReference() {
		return (EReference)createEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCREATE_TargetContext() {
		return (EReference)createEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMOVE() {
		return moveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMOVE_Source() {
		return (EReference)moveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMOVE_Target() {
		return (EReference)moveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_CreateCommand() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableReference() {
		return variableReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableReference_Variable() {
		return (EReference)variableReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceContext() {
		return sourceContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleReference() {
		return roleReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleReference_Role() {
		return (EReference)roleReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationReference() {
		return relationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationReference_Relation() {
		return (EReference)relationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetContext() {
		return targetContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceCommand() {
		return referenceCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSET() {
		return setEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSET_Source() {
		return (EReference)setEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSET_Target() {
		return (EReference)setEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCommand() {
		return attributeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getASSIGN() {
		return assignEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getASSIGN_SourceAttribute() {
		return (EReference)assignEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getASSIGN_TargetAttribute() {
		return (EReference)assignEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringSpecificationFactory getRefactoringSpecificationFactory() {
		return (RefactoringSpecificationFactory)getEFactoryInstance();
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
		refactoringSpecificationEClass = createEClass(REFACTORING_SPECIFICATION);
		createEReference(refactoringSpecificationEClass, REFACTORING_SPECIFICATION__USED_ROLE_MODEL);
		createEAttribute(refactoringSpecificationEClass, REFACTORING_SPECIFICATION__NAME);
		createEReference(refactoringSpecificationEClass, REFACTORING_SPECIFICATION__INSTRUCTIONS);

		instructionEClass = createEClass(INSTRUCTION);

		containmentCommandEClass = createEClass(CONTAINMENT_COMMAND);

		createEClass = createEClass(CREATE);
		createEReference(createEClass, CREATE__VAR_DECLARATION);
		createEReference(createEClass, CREATE__SOURCE_ROLE_REFERENCE);
		createEReference(createEClass, CREATE__TARGET_CONTEXT);

		moveEClass = createEClass(MOVE);
		createEReference(moveEClass, MOVE__SOURCE);
		createEReference(moveEClass, MOVE__TARGET);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEReference(variableEClass, VARIABLE__CREATE_COMMAND);

		variableReferenceEClass = createEClass(VARIABLE_REFERENCE);
		createEReference(variableReferenceEClass, VARIABLE_REFERENCE__VARIABLE);

		sourceContextEClass = createEClass(SOURCE_CONTEXT);

		roleReferenceEClass = createEClass(ROLE_REFERENCE);
		createEReference(roleReferenceEClass, ROLE_REFERENCE__ROLE);

		relationReferenceEClass = createEClass(RELATION_REFERENCE);
		createEReference(relationReferenceEClass, RELATION_REFERENCE__RELATION);

		targetContextEClass = createEClass(TARGET_CONTEXT);

		referenceCommandEClass = createEClass(REFERENCE_COMMAND);

		setEClass = createEClass(SET);
		createEReference(setEClass, SET__SOURCE);
		createEReference(setEClass, SET__TARGET);

		attributeCommandEClass = createEClass(ATTRIBUTE_COMMAND);

		assignEClass = createEClass(ASSIGN);
		createEReference(assignEClass, ASSIGN__SOURCE_ATTRIBUTE);
		createEReference(assignEClass, ASSIGN__TARGET_ATTRIBUTE);
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
		RolesPackage theRolesPackage = (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		containmentCommandEClass.getESuperTypes().add(this.getInstruction());
		createEClass.getESuperTypes().add(this.getContainmentCommand());
		moveEClass.getESuperTypes().add(this.getContainmentCommand());
		variableReferenceEClass.getESuperTypes().add(this.getSourceContext());
		variableReferenceEClass.getESuperTypes().add(this.getTargetContext());
		roleReferenceEClass.getESuperTypes().add(this.getSourceContext());
		roleReferenceEClass.getESuperTypes().add(this.getTargetContext());
		relationReferenceEClass.getESuperTypes().add(this.getSourceContext());
		referenceCommandEClass.getESuperTypes().add(this.getInstruction());
		setEClass.getESuperTypes().add(this.getReferenceCommand());
		attributeCommandEClass.getESuperTypes().add(this.getInstruction());
		assignEClass.getESuperTypes().add(this.getAttributeCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(refactoringSpecificationEClass, RefactoringSpecification.class, "RefactoringSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRefactoringSpecification_UsedRoleModel(), theRolesPackage.getRoleModel(), null, "usedRoleModel", null, 1, 1, RefactoringSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRefactoringSpecification_Name(), ecorePackage.getEString(), "name", null, 1, 1, RefactoringSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRefactoringSpecification_Instructions(), this.getInstruction(), null, "instructions", null, 1, -1, RefactoringSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(refactoringSpecificationEClass, this.getVariable(), "getDeclaredVariables", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(refactoringSpecificationEClass, this.getVariable(), "getVariableByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instructionEClass, Instruction.class, "Instruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containmentCommandEClass, ContainmentCommand.class, "ContainmentCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createEClass, org.emftext.language.refactoring.refactoring_specification.CREATE.class, "CREATE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCREATE_VarDeclaration(), this.getVariable(), this.getVariable_CreateCommand(), "varDeclaration", null, 0, 1, org.emftext.language.refactoring.refactoring_specification.CREATE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCREATE_SourceRoleReference(), this.getRoleReference(), null, "sourceRoleReference", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.CREATE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCREATE_TargetContext(), this.getTargetContext(), null, "targetContext", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.CREATE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moveEClass, org.emftext.language.refactoring.refactoring_specification.MOVE.class, "MOVE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMOVE_Source(), this.getSourceContext(), null, "source", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.MOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMOVE_Target(), this.getTargetContext(), null, "target", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.MOVE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_CreateCommand(), this.getCREATE(), this.getCREATE_VarDeclaration(), "createCommand", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableReferenceEClass, VariableReference.class, "VariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableReference_Variable(), this.getVariable(), null, "variable", null, 1, 1, VariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceContextEClass, SourceContext.class, "SourceContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roleReferenceEClass, RoleReference.class, "RoleReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleReference_Role(), theRolesPackage.getRole(), null, "role", null, 1, 1, RoleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationReferenceEClass, RelationReference.class, "RelationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationReference_Relation(), theRolesPackage.getMultiplicityRelation(), null, "relation", null, 1, 1, RelationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetContextEClass, TargetContext.class, "TargetContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceCommandEClass, ReferenceCommand.class, "ReferenceCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setEClass, org.emftext.language.refactoring.refactoring_specification.SET.class, "SET", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSET_Source(), this.getSourceContext(), null, "source", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.SET.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSET_Target(), this.getTargetContext(), null, "target", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.SET.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeCommandEClass, AttributeCommand.class, "AttributeCommand", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignEClass, org.emftext.language.refactoring.refactoring_specification.ASSIGN.class, "ASSIGN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getASSIGN_SourceAttribute(), theRolesPackage.getRoleAttribute(), null, "sourceAttribute", null, 0, 1, org.emftext.language.refactoring.refactoring_specification.ASSIGN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getASSIGN_TargetAttribute(), theRolesPackage.getRoleAttribute(), null, "targetAttribute", null, 1, 1, org.emftext.language.refactoring.refactoring_specification.ASSIGN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RefactoringSpecificationPackageImpl
