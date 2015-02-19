/**
 */
package org.emftext.language.refactoring.refactoringcomposition;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionFactory
 * @model kind="package"
 * @generated
 */
public interface RefactoringcompositionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "refactoringcomposition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/refactoringcomposition";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "refactoringcomposition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RefactoringcompositionPackage eINSTANCE = org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl <em>Composite Role Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl
	 * @see org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl#getCompositeRoleMapping()
	 * @generated
	 */
	int COMPOSITE_ROLE_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ROLE_MAPPING__NAME = 0;

	/**
	 * The feature id for the '<em><b>Target Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL = 1;

	/**
	 * The feature id for the '<em><b>First</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ROLE_MAPPING__FIRST = 2;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ROLE_MAPPING__SEQUENCE = 3;

	/**
	 * The number of structural features of the '<em>Composite Role Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ROLE_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Composite Role Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ROLE_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl <em>Bound Role Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl
	 * @see org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl#getBoundRoleMapping()
	 * @generated
	 */
	int BOUND_ROLE_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Next Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ROLE_MAPPING__NEXT_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Previous Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ROLE_MAPPING__PREVIOUS_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ROLE_MAPPING__BINDINGS = 2;

	/**
	 * The feature id for the '<em><b>Role Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ROLE_MAPPING__ROLE_MAPPING = 3;

	/**
	 * The number of structural features of the '<em>Bound Role Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ROLE_MAPPING_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Bound Role Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_ROLE_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl <em>Source Target Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl
	 * @see org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl#getSourceTargetBinding()
	 * @generated
	 */
	int SOURCE_TARGET_BINDING = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TARGET_BINDING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TARGET_BINDING__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Source Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Target Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL = 3;

	/**
	 * The number of structural features of the '<em>Source Target Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TARGET_BINDING_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Source Target Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TARGET_BINDING_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping <em>Composite Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Role Mapping</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping
	 * @generated
	 */
	EClass getCompositeRoleMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getName()
	 * @see #getCompositeRoleMapping()
	 * @generated
	 */
	EAttribute getCompositeRoleMapping_Name();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getTargetMetamodel <em>Target Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Metamodel</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getTargetMetamodel()
	 * @see #getCompositeRoleMapping()
	 * @generated
	 */
	EReference getCompositeRoleMapping_TargetMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>First</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getFirst()
	 * @see #getCompositeRoleMapping()
	 * @generated
	 */
	EReference getCompositeRoleMapping_First();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequence</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getSequence()
	 * @see #getCompositeRoleMapping()
	 * @generated
	 */
	EReference getCompositeRoleMapping_Sequence();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping <em>Bound Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Role Mapping</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping
	 * @generated
	 */
	EClass getBoundRoleMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getNextMapping <em>Next Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next Mapping</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getNextMapping()
	 * @see #getBoundRoleMapping()
	 * @generated
	 */
	EReference getBoundRoleMapping_NextMapping();

	/**
	 * Returns the meta object for the container reference '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getPreviousMapping <em>Previous Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Previous Mapping</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getPreviousMapping()
	 * @see #getBoundRoleMapping()
	 * @generated
	 */
	EReference getBoundRoleMapping_PreviousMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getBindings()
	 * @see #getBoundRoleMapping()
	 * @generated
	 */
	EReference getBoundRoleMapping_Bindings();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getRoleMapping <em>Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role Mapping</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getRoleMapping()
	 * @see #getBoundRoleMapping()
	 * @generated
	 */
	EReference getBoundRoleMapping_RoleMapping();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding <em>Source Target Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Target Binding</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding
	 * @generated
	 */
	EClass getSourceTargetBinding();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSource()
	 * @see #getSourceTargetBinding()
	 * @generated
	 */
	EReference getSourceTargetBinding_Source();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTarget()
	 * @see #getSourceTargetBinding()
	 * @generated
	 */
	EReference getSourceTargetBinding_Target();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSourceRoleModel <em>Source Role Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Role Model</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSourceRoleModel()
	 * @see #getSourceTargetBinding()
	 * @generated
	 */
	EReference getSourceTargetBinding_SourceRoleModel();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTargetRoleModel <em>Target Role Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Role Model</em>'.
	 * @see org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTargetRoleModel()
	 * @see #getSourceTargetBinding()
	 * @generated
	 */
	EReference getSourceTargetBinding_TargetRoleModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RefactoringcompositionFactory getRefactoringcompositionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl <em>Composite Role Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoringcomposition.impl.CompositeRoleMappingImpl
		 * @see org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl#getCompositeRoleMapping()
		 * @generated
		 */
		EClass COMPOSITE_ROLE_MAPPING = eINSTANCE.getCompositeRoleMapping();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_ROLE_MAPPING__NAME = eINSTANCE.getCompositeRoleMapping_Name();

		/**
		 * The meta object literal for the '<em><b>Target Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL = eINSTANCE.getCompositeRoleMapping_TargetMetamodel();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ROLE_MAPPING__FIRST = eINSTANCE.getCompositeRoleMapping_First();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ROLE_MAPPING__SEQUENCE = eINSTANCE.getCompositeRoleMapping_Sequence();

		/**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl <em>Bound Role Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoringcomposition.impl.BoundRoleMappingImpl
		 * @see org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl#getBoundRoleMapping()
		 * @generated
		 */
		EClass BOUND_ROLE_MAPPING = eINSTANCE.getBoundRoleMapping();

		/**
		 * The meta object literal for the '<em><b>Next Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_ROLE_MAPPING__NEXT_MAPPING = eINSTANCE.getBoundRoleMapping_NextMapping();

		/**
		 * The meta object literal for the '<em><b>Previous Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_ROLE_MAPPING__PREVIOUS_MAPPING = eINSTANCE.getBoundRoleMapping_PreviousMapping();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_ROLE_MAPPING__BINDINGS = eINSTANCE.getBoundRoleMapping_Bindings();

		/**
		 * The meta object literal for the '<em><b>Role Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_ROLE_MAPPING__ROLE_MAPPING = eINSTANCE.getBoundRoleMapping_RoleMapping();

		/**
		 * The meta object literal for the '{@link org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl <em>Source Target Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl
		 * @see org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionPackageImpl#getSourceTargetBinding()
		 * @generated
		 */
		EClass SOURCE_TARGET_BINDING = eINSTANCE.getSourceTargetBinding();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_TARGET_BINDING__SOURCE = eINSTANCE.getSourceTargetBinding_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_TARGET_BINDING__TARGET = eINSTANCE.getSourceTargetBinding_Target();

		/**
		 * The meta object literal for the '<em><b>Source Role Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL = eINSTANCE.getSourceTargetBinding_SourceRoleModel();

		/**
		 * The meta object literal for the '<em><b>Target Role Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL = eINSTANCE.getSourceTargetBinding_TargetRoleModel();

	}

} //RefactoringcompositionPackage
