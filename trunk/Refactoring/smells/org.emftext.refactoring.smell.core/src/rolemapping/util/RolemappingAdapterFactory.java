/**
 */
package rolemapping.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import rolemapping.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see rolemapping.RolemappingPackage
 * @generated
 */
public class RolemappingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RolemappingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolemappingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RolemappingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RolemappingSwitch<Adapter> modelSwitch =
		new RolemappingSwitch<Adapter>() {
			@Override
			public Adapter caseRoleMappingModel(RoleMappingModel object) {
				return createRoleMappingModelAdapter();
			}
			@Override
			public Adapter caseRoleMapping(RoleMapping object) {
				return createRoleMappingAdapter();
			}
			@Override
			public Adapter caseConcreteMapping(ConcreteMapping object) {
				return createConcreteMappingAdapter();
			}
			@Override
			public Adapter caseCollaborationMapping(CollaborationMapping object) {
				return createCollaborationMappingAdapter();
			}
			@Override
			public Adapter caseAttributeMapping(AttributeMapping object) {
				return createAttributeMappingAdapter();
			}
			@Override
			public Adapter caseReferenceMetaClassPair(ReferenceMetaClassPair object) {
				return createReferenceMetaClassPairAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link rolemapping.RoleMappingModel <em>Role Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rolemapping.RoleMappingModel
	 * @generated
	 */
	public Adapter createRoleMappingModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rolemapping.RoleMapping <em>Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rolemapping.RoleMapping
	 * @generated
	 */
	public Adapter createRoleMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rolemapping.ConcreteMapping <em>Concrete Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rolemapping.ConcreteMapping
	 * @generated
	 */
	public Adapter createConcreteMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rolemapping.CollaborationMapping <em>Collaboration Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rolemapping.CollaborationMapping
	 * @generated
	 */
	public Adapter createCollaborationMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rolemapping.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rolemapping.AttributeMapping
	 * @generated
	 */
	public Adapter createAttributeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rolemapping.ReferenceMetaClassPair <em>Reference Meta Class Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rolemapping.ReferenceMetaClassPair
	 * @generated
	 */
	public Adapter createReferenceMetaClassPairAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RolemappingAdapterFactory
