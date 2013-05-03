/**
 */
package org.emftext.refactoring.smell.umlsmells.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.Metric;

import org.emftext.refactoring.smell.umlsmells.*;

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
 * @see org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage
 * @generated
 */
public class UmlsmellsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmlsmellsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlsmellsSwitch() {
		if (modelPackage == null) {
			modelPackage = UmlsmellsPackage.eINSTANCE;
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
			case UmlsmellsPackage.CHECK_INTERFACE_SPECIFICATIONS: {
				CheckInterfaceSpecifications checkInterfaceSpecifications = (CheckInterfaceSpecifications)theEObject;
				T result = caseCheckInterfaceSpecifications(checkInterfaceSpecifications);
				if (result == null) result = caseMetric(checkInterfaceSpecifications);
				if (result == null) result = caseCalculation(checkInterfaceSpecifications);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlsmellsPackage.COMPARE_NAMES: {
				CompareNames compareNames = (CompareNames)theEObject;
				T result = caseCompareNames(compareNames);
				if (result == null) result = caseMetric(compareNames);
				if (result == null) result = caseCalculation(compareNames);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlsmellsPackage.COUNT_PARAMETERS_OF_METHODS: {
				CountParametersOfMethods countParametersOfMethods = (CountParametersOfMethods)theEObject;
				T result = caseCountParametersOfMethods(countParametersOfMethods);
				if (result == null) result = caseMetric(countParametersOfMethods);
				if (result == null) result = caseCalculation(countParametersOfMethods);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlsmellsPackage.SEARCH_EMPTY_CLASSES_AND_INTERFACES: {
				SearchEmptyClassesAndInterfaces searchEmptyClassesAndInterfaces = (SearchEmptyClassesAndInterfaces)theEObject;
				T result = caseSearchEmptyClassesAndInterfaces(searchEmptyClassesAndInterfaces);
				if (result == null) result = caseMetric(searchEmptyClassesAndInterfaces);
				if (result == null) result = caseCalculation(searchEmptyClassesAndInterfaces);
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
	 * Returns the result of interpreting the object as an instance of '<em>Compare Names</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Names</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareNames(CompareNames object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Search Empty Classes And Interfaces</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Empty Classes And Interfaces</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchEmptyClassesAndInterfaces(SearchEmptyClassesAndInterfaces object) {
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

} //UmlsmellsSwitch
