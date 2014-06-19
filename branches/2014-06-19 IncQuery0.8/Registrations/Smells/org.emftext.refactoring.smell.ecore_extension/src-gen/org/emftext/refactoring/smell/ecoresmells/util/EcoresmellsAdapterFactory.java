/**
 */
package org.emftext.refactoring.smell.ecoresmells.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.Metric;

import org.emftext.refactoring.smell.ecoresmells.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage
 * @generated
 */
public class EcoresmellsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcoresmellsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoresmellsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EcoresmellsPackage.eINSTANCE;
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
	protected EcoresmellsSwitch<Adapter> modelSwitch =
		new EcoresmellsSwitch<Adapter>() {
			@Override
			public Adapter caseCheckInterfaceSpecifications(CheckInterfaceSpecifications object) {
				return createCheckInterfaceSpecificationsAdapter();
			}
			@Override
			public Adapter caseCompareNamesOfClasses(CompareNamesOfClasses object) {
				return createCompareNamesOfClassesAdapter();
			}
			@Override
			public Adapter caseCountParametersOfMethods(CountParametersOfMethods object) {
				return createCountParametersOfMethodsAdapter();
			}
			@Override
			public Adapter caseSearchEmptyClasses(SearchEmptyClasses object) {
				return createSearchEmptyClassesAdapter();
			}
			@Override
			public Adapter caseCalculation(Calculation object) {
				return createCalculationAdapter();
			}
			@Override
			public Adapter caseMetric(Metric object) {
				return createMetricAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.ecoresmells.CheckInterfaceSpecifications <em>Check Interface Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.ecoresmells.CheckInterfaceSpecifications
	 * @generated
	 */
	public Adapter createCheckInterfaceSpecificationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.ecoresmells.CompareNamesOfClasses <em>Compare Names Of Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.ecoresmells.CompareNamesOfClasses
	 * @generated
	 */
	public Adapter createCompareNamesOfClassesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.ecoresmells.CountParametersOfMethods <em>Count Parameters Of Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.ecoresmells.CountParametersOfMethods
	 * @generated
	 */
	public Adapter createCountParametersOfMethodsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.ecoresmells.SearchEmptyClasses <em>Search Empty Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.ecoresmells.SearchEmptyClasses
	 * @generated
	 */
	public Adapter createSearchEmptyClassesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.calculation.Calculation <em>Calculation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.calculation.Calculation
	 * @generated
	 */
	public Adapter createCalculationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.emftext.refactoring.smell.calculation.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.emftext.refactoring.smell.calculation.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
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

} //EcoresmellsAdapterFactory
