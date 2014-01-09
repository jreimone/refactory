/**
 */
package org.qualitune.tracing.vapoditrace.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.qualitune.tracing.vapoditrace.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.qualitune.tracing.vapoditrace.vapoditracePackage
 * @generated
 */
public class vapoditraceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static vapoditracePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public vapoditraceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = vapoditracePackage.eINSTANCE;
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
	protected vapoditraceSwitch<Adapter> modelSwitch =
		new vapoditraceSwitch<Adapter>() {
			@Override
			public Adapter caseTraceLink(TraceLink object) {
				return createTraceLinkAdapter();
			}
			@Override
			public Adapter caseTraceCollection(TraceCollection object) {
				return createTraceCollectionAdapter();
			}
			@Override
			public Adapter caseEEntity(EEntity object) {
				return createEEntityAdapter();
			}
			@Override
			public Adapter caseTraceEntity(TraceEntity object) {
				return createTraceEntityAdapter();
			}
			@Override
			public Adapter caseDynamicEntity(DynamicEntity object) {
				return createDynamicEntityAdapter();
			}
			@Override
			public Adapter caseStaticEntity(StaticEntity object) {
				return createStaticEntityAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.vapoditrace.TraceLink <em>Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.vapoditrace.TraceLink
	 * @generated
	 */
	public Adapter createTraceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.vapoditrace.TraceCollection <em>Trace Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.vapoditrace.TraceCollection
	 * @generated
	 */
	public Adapter createTraceCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.vapoditrace.EEntity <em>EEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.vapoditrace.EEntity
	 * @generated
	 */
	public Adapter createEEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.vapoditrace.TraceEntity <em>Trace Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.vapoditrace.TraceEntity
	 * @generated
	 */
	public Adapter createTraceEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.vapoditrace.DynamicEntity <em>Dynamic Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.vapoditrace.DynamicEntity
	 * @generated
	 */
	public Adapter createDynamicEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.qualitune.tracing.vapoditrace.StaticEntity <em>Static Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.qualitune.tracing.vapoditrace.StaticEntity
	 * @generated
	 */
	public Adapter createStaticEntityAdapter() {
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

} //vapoditraceAdapterFactory
