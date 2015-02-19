/**
 */
package org.emftext.language.refactoring.refactoringcomposition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.refactoring.refactoringcomposition.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefactoringcompositionFactoryImpl extends EFactoryImpl implements RefactoringcompositionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RefactoringcompositionFactory init() {
		try {
			RefactoringcompositionFactory theRefactoringcompositionFactory = (RefactoringcompositionFactory)EPackage.Registry.INSTANCE.getEFactory(RefactoringcompositionPackage.eNS_URI);
			if (theRefactoringcompositionFactory != null) {
				return theRefactoringcompositionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RefactoringcompositionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringcompositionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING: return createCompositeRoleMapping();
			case RefactoringcompositionPackage.BOUND_ROLE_MAPPING: return createBoundRoleMapping();
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING: return createSourceTargetBinding();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeRoleMapping createCompositeRoleMapping() {
		CompositeRoleMappingImpl compositeRoleMapping = new CompositeRoleMappingImpl();
		return compositeRoleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundRoleMapping createBoundRoleMapping() {
		BoundRoleMappingImpl boundRoleMapping = new BoundRoleMappingImpl();
		return boundRoleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceTargetBinding createSourceTargetBinding() {
		SourceTargetBindingImpl sourceTargetBinding = new SourceTargetBindingImpl();
		return sourceTargetBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefactoringcompositionPackage getRefactoringcompositionPackage() {
		return (RefactoringcompositionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RefactoringcompositionPackage getPackage() {
		return RefactoringcompositionPackage.eINSTANCE;
	}

} //RefactoringcompositionFactoryImpl
