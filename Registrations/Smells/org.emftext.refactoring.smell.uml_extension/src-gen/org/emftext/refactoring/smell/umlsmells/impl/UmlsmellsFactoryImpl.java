/**
 */
package org.emftext.refactoring.smell.umlsmells.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.refactoring.smell.umlsmells.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlsmellsFactoryImpl extends EFactoryImpl implements UmlsmellsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UmlsmellsFactory init() {
		try {
			UmlsmellsFactory theUmlsmellsFactory = (UmlsmellsFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelrefactoring.org/smell/calculation/uml"); 
			if (theUmlsmellsFactory != null) {
				return theUmlsmellsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlsmellsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlsmellsFactoryImpl() {
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
			case UmlsmellsPackage.CHECK_INTERFACE_SPECIFICATIONS: return createCheckInterfaceSpecifications();
			case UmlsmellsPackage.COMPARE_NAMES: return createCompareNames();
			case UmlsmellsPackage.COUNT_PARAMETERS_OF_METHODS: return createCountParametersOfMethods();
			case UmlsmellsPackage.SEARCH_EMPTY_CLASSES_AND_INTERFACES: return createSearchEmptyClassesAndInterfaces();
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
	public CompareNames createCompareNames() {
		CompareNamesImpl compareNames = new CompareNamesImpl();
		return compareNames;
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
	public SearchEmptyClassesAndInterfaces createSearchEmptyClassesAndInterfaces() {
		SearchEmptyClassesAndInterfacesImpl searchEmptyClassesAndInterfaces = new SearchEmptyClassesAndInterfacesImpl();
		return searchEmptyClassesAndInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlsmellsPackage getUmlsmellsPackage() {
		return (UmlsmellsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlsmellsPackage getPackage() {
		return UmlsmellsPackage.eINSTANCE;
	}

} //UmlsmellsFactoryImpl
