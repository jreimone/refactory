/**
 */
package org.emftext.language.refactoring.refactoringcomposition.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory;
import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;

import org.emftext.language.refactoring.rolemapping.RolemappingPackage;

import org.emftext.language.refactoring.roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefactoringcompositionPackageImpl extends EPackageImpl implements RefactoringcompositionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeRoleMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundRoleMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceTargetBindingEClass = null;

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
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RefactoringcompositionPackageImpl() {
		super(eNS_URI, RefactoringcompositionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RefactoringcompositionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RefactoringcompositionPackage init() {
		if (isInited) return (RefactoringcompositionPackage)EPackage.Registry.INSTANCE.getEPackage(RefactoringcompositionPackage.eNS_URI);

		// Obtain or create and register package
		RefactoringcompositionPackageImpl theRefactoringcompositionPackage = (RefactoringcompositionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RefactoringcompositionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RefactoringcompositionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RolemappingPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRefactoringcompositionPackage.createPackageContents();

		// Initialize created meta-data
		theRefactoringcompositionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRefactoringcompositionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RefactoringcompositionPackage.eNS_URI, theRefactoringcompositionPackage);
		return theRefactoringcompositionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeRoleMapping() {
		return compositeRoleMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeRoleMapping_Name() {
		return (EAttribute)compositeRoleMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeRoleMapping_TargetMetamodel() {
		return (EReference)compositeRoleMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeRoleMapping_First() {
		return (EReference)compositeRoleMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeRoleMapping_Sequence() {
		return (EReference)compositeRoleMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundRoleMapping() {
		return boundRoleMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundRoleMapping_NextMapping() {
		return (EReference)boundRoleMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundRoleMapping_PreviousMapping() {
		return (EReference)boundRoleMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundRoleMapping_Bindings() {
		return (EReference)boundRoleMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundRoleMapping_RoleMapping() {
		return (EReference)boundRoleMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceTargetBinding() {
		return sourceTargetBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceTargetBinding_Source() {
		return (EReference)sourceTargetBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceTargetBinding_Target() {
		return (EReference)sourceTargetBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceTargetBinding_SourceRoleModel() {
		return (EReference)sourceTargetBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceTargetBinding_TargetRoleModel() {
		return (EReference)sourceTargetBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringcompositionFactory getRefactoringcompositionFactory() {
		return (RefactoringcompositionFactory)getEFactoryInstance();
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
		compositeRoleMappingEClass = createEClass(COMPOSITE_ROLE_MAPPING);
		createEAttribute(compositeRoleMappingEClass, COMPOSITE_ROLE_MAPPING__NAME);
		createEReference(compositeRoleMappingEClass, COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL);
		createEReference(compositeRoleMappingEClass, COMPOSITE_ROLE_MAPPING__FIRST);
		createEReference(compositeRoleMappingEClass, COMPOSITE_ROLE_MAPPING__SEQUENCE);

		boundRoleMappingEClass = createEClass(BOUND_ROLE_MAPPING);
		createEReference(boundRoleMappingEClass, BOUND_ROLE_MAPPING__NEXT_MAPPING);
		createEReference(boundRoleMappingEClass, BOUND_ROLE_MAPPING__PREVIOUS_MAPPING);
		createEReference(boundRoleMappingEClass, BOUND_ROLE_MAPPING__BINDINGS);
		createEReference(boundRoleMappingEClass, BOUND_ROLE_MAPPING__ROLE_MAPPING);

		sourceTargetBindingEClass = createEClass(SOURCE_TARGET_BINDING);
		createEReference(sourceTargetBindingEClass, SOURCE_TARGET_BINDING__SOURCE);
		createEReference(sourceTargetBindingEClass, SOURCE_TARGET_BINDING__TARGET);
		createEReference(sourceTargetBindingEClass, SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL);
		createEReference(sourceTargetBindingEClass, SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL);
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
		RolesPackage theRolesPackage = (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(compositeRoleMappingEClass, CompositeRoleMapping.class, "CompositeRoleMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeRoleMapping_Name(), ecorePackage.getEString(), "name", "", 1, 1, CompositeRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeRoleMapping_TargetMetamodel(), theEcorePackage.getEPackage(), null, "targetMetamodel", null, 1, 1, CompositeRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeRoleMapping_First(), theRolemappingPackage.getRoleMapping(), null, "first", null, 1, 1, CompositeRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeRoleMapping_Sequence(), this.getBoundRoleMapping(), null, "sequence", null, 1, -1, CompositeRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundRoleMappingEClass, BoundRoleMapping.class, "BoundRoleMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoundRoleMapping_NextMapping(), this.getBoundRoleMapping(), this.getBoundRoleMapping_PreviousMapping(), "nextMapping", null, 0, 1, BoundRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundRoleMapping_PreviousMapping(), this.getBoundRoleMapping(), this.getBoundRoleMapping_NextMapping(), "previousMapping", null, 0, 1, BoundRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundRoleMapping_Bindings(), this.getSourceTargetBinding(), null, "bindings", null, 0, -1, BoundRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundRoleMapping_RoleMapping(), theRolemappingPackage.getRoleMapping(), null, "roleMapping", null, 1, 1, BoundRoleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceTargetBindingEClass, SourceTargetBinding.class, "SourceTargetBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceTargetBinding_Source(), theRolesPackage.getRole(), null, "source", null, 1, 1, SourceTargetBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceTargetBinding_Target(), theRolesPackage.getRole(), null, "target", null, 1, 1, SourceTargetBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceTargetBinding_SourceRoleModel(), theRolesPackage.getRoleModel(), null, "sourceRoleModel", null, 1, 1, SourceTargetBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceTargetBinding_TargetRoleModel(), theRolesPackage.getRoleModel(), null, "targetRoleModel", null, 1, 1, SourceTargetBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RefactoringcompositionPackageImpl
