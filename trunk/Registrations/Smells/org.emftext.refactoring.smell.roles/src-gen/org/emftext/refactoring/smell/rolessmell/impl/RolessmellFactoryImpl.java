/**
 */
package org.emftext.refactoring.smell.rolessmell.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.refactoring.smell.rolessmell.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RolessmellFactoryImpl extends EFactoryImpl implements RolessmellFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RolessmellFactory init() {
		try {
			RolessmellFactory theRolessmellFactory = (RolessmellFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelrefactoring.org/smell/calculation/roles"); 
			if (theRolessmellFactory != null) {
				return theRolessmellFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RolessmellFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolessmellFactoryImpl() {
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
			case RolessmellPackage.DISTINCT_ROLE_NAMES: return createDistinctRoleNames();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctRoleNames createDistinctRoleNames() {
		DistinctRoleNamesImpl distinctRoleNames = new DistinctRoleNamesImpl();
		return distinctRoleNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolessmellPackage getRolessmellPackage() {
		return (RolessmellPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RolessmellPackage getPackage() {
		return RolessmellPackage.eINSTANCE;
	}

} //RolessmellFactoryImpl
