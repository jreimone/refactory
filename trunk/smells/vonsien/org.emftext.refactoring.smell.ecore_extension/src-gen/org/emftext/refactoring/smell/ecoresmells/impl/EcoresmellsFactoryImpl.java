/**
 */
package org.emftext.refactoring.smell.ecoresmells.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.refactoring.smell.ecoresmells.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoresmellsFactoryImpl extends EFactoryImpl implements EcoresmellsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EcoresmellsFactory init() {
		try {
			EcoresmellsFactory theEcoresmellsFactory = (EcoresmellsFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelrefactoring.org/smell/calculation/ecore"); 
			if (theEcoresmellsFactory != null) {
				return theEcoresmellsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EcoresmellsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoresmellsFactoryImpl() {
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
			case EcoresmellsPackage.CHECK_INTERFACE_SPECIFICATIONS: return createCheckInterfaceSpecifications();
			case EcoresmellsPackage.COMPARE_NAMES_OF_CLASSES: return createCompareNamesOfClasses();
			case EcoresmellsPackage.COUNT_PARAMETERS_OF_METHODS: return createCountParametersOfMethods();
			case EcoresmellsPackage.SEARCH_EMPTY_CLASSES: return createSearchEmptyClasses();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckInterfaceSpecifications createCheckInterfaceSpecifications() {
		CheckInterfaceSpecificationsImpl checkInterfaceSpecifications = new CheckInterfaceSpecificationsImpl();
		return checkInterfaceSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareNamesOfClasses createCompareNamesOfClasses() {
		CompareNamesOfClassesImpl compareNamesOfClasses = new CompareNamesOfClassesImpl();
		return compareNamesOfClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountParametersOfMethods createCountParametersOfMethods() {
		CountParametersOfMethodsImpl countParametersOfMethods = new CountParametersOfMethodsImpl();
		return countParametersOfMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchEmptyClasses createSearchEmptyClasses() {
		SearchEmptyClassesImpl searchEmptyClasses = new SearchEmptyClassesImpl();
		return searchEmptyClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoresmellsPackage getEcoresmellsPackage() {
		return (EcoresmellsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EcoresmellsPackage getPackage() {
		return EcoresmellsPackage.eINSTANCE;
	}

} //EcoresmellsFactoryImpl
