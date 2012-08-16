/**
 */
package org.emftext.refactoring.smell.smell_model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.smell.smell_model.*;



/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage
 * @generated
 */
public class Smell_modelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Smell_modelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Smell_modelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Smell_modelPackage.eINSTANCE;
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
	protected Smell_modelSwitch<Adapter> modelSwitch =
		new Smell_modelSwitch<Adapter>() {
			@Override
			public Adapter caseModelSmell(ModelSmell object) {
				return createModelSmellAdapter();
			}
			@Override
			public Adapter caseModelSmell_Rolemapping_Mapping(ModelSmell_Rolemapping_Mapping object) {
				return createModelSmell_Rolemapping_MappingAdapter();
			}
			@Override
			public Adapter caseQuality(Quality object) {
				return createQualityAdapter();
			}
			@Override
			public Adapter caseQuality_ModelSmell_Mapping(Quality_ModelSmell_Mapping object) {
				return createQuality_ModelSmell_MappingAdapter();
			}
			@Override
			public Adapter caseMetric(Metric object) {
				return createMetricAdapter();
			}
			@Override
			public Adapter caseMetric_Quality_Mapping(Metric_Quality_Mapping object) {
				return createMetric_Quality_MappingAdapter();
			}
			@Override
			public Adapter caseModelSmellModel(ModelSmellModel object) {
				return createModelSmellModelAdapter();
			}
			@Override
			public Adapter caseRoleMapping(RoleMapping object) {
				return createRoleMappingAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseMappingConcretisation(MappingConcretisation object) {
				return createMappingConcretisationAdapter();
			}
			@Override
			public Adapter caseObserver(Observer object) {
				return createObserverAdapter();
			}
			@Override
			public Adapter caseModelSmellResult(ModelSmellResult object) {
				return createModelSmellResultAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.ModelSmell <em>Model Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.ModelSmell
	 * @generated
	 */
	public Adapter createModelSmellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping <em>Model Smell Rolemapping Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.ModelSmell_Rolemapping_Mapping
	 * @generated
	 */
	public Adapter createModelSmell_Rolemapping_MappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.Quality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.Quality
	 * @generated
	 */
	public Adapter createQualityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.Quality_ModelSmell_Mapping <em>Quality Model Smell Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.Quality_ModelSmell_Mapping
	 * @generated
	 */
	public Adapter createQuality_ModelSmell_MappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping <em>Metric Quality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping
	 * @generated
	 */
	public Adapter createMetric_Quality_MappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.ModelSmellModel <em>Model Smell Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.ModelSmellModel
	 * @generated
	 */
	public Adapter createModelSmellModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.RoleMapping <em>Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.RoleMapping
	 * @generated
	 */
	public Adapter createRoleMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.MappingConcretisation <em>Mapping Concretisation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.MappingConcretisation
	 * @generated
	 */
	public Adapter createMappingConcretisationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.Observer <em>Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.Observer
	 * @generated
	 */
	public Adapter createObserverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.smell_model.ModelSmellResult <em>Model Smell Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.smell_model.ModelSmellResult
	 * @generated
	 */
	public Adapter createModelSmellResultAdapter() {
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

} //Smell_modelAdapterFactory
