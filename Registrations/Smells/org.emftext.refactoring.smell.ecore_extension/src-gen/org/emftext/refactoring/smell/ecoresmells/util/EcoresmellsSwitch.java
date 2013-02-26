/**
 */
package org.emftext.refactoring.smell.ecoresmells.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.Metric;

import org.emftext.refactoring.smell.ecoresmells.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.ecoresmells.EcoresmellsPackage
 * @generated
 */
public class EcoresmellsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcoresmellsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoresmellsSwitch() {
		if (modelPackage == null) {
			modelPackage = EcoresmellsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EcoresmellsPackage.CHECK_INTERFACE_SPECIFICATIONS: {
				CheckInterfaceSpecifications checkInterfaceSpecifications = (CheckInterfaceSpecifications)theEObject;
				T result = caseCheckInterfaceSpecifications(checkInterfaceSpecifications);
				if (result == null) result = caseMetric(checkInterfaceSpecifications);
				if (result == null) result = caseCalculation(checkInterfaceSpecifications);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoresmellsPackage.COMPARE_NAMES_OF_CLASSES: {
				CompareNamesOfClasses compareNamesOfClasses = (CompareNamesOfClasses)theEObject;
				T result = caseCompareNamesOfClasses(compareNamesOfClasses);
				if (result == null) result = caseMetric(compareNamesOfClasses);
				if (result == null) result = caseCalculation(compareNamesOfClasses);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoresmellsPackage.COUNT_PARAMETERS_OF_METHODS: {
				CountParametersOfMethods countParametersOfMethods = (CountParametersOfMethods)theEObject;
				T result = caseCountParametersOfMethods(countParametersOfMethods);
				if (result == null) result = caseMetric(countParametersOfMethods);
				if (result == null) result = caseCalculation(countParametersOfMethods);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcoresmellsPackage.SEARCH_EMPTY_CLASSES: {
				SearchEmptyClasses searchEmptyClasses = (SearchEmptyClasses)theEObject;
				T result = caseSearchEmptyClasses(searchEmptyClasses);
				if (result == null) result = caseMetric(searchEmptyClasses);
				if (result == null) result = caseCalculation(searchEmptyClasses);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Interface Specifications</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Interface Specifications</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckInterfaceSpecifications(CheckInterfaceSpecifications object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Names Of Classes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Names Of Classes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareNamesOfClasses(CompareNamesOfClasses object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Count Parameters Of Methods</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Count Parameters Of Methods</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountParametersOfMethods(CountParametersOfMethods object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Empty Classes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Empty Classes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchEmptyClasses(SearchEmptyClasses object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calculation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calculation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalculation(Calculation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metric</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metric</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetric(Metric object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EcoresmellsSwitch
