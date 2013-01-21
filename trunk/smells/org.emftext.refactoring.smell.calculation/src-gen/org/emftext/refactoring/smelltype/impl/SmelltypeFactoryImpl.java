/**
 */
package org.emftext.refactoring.smelltype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.refactoring.smelltype.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmelltypeFactoryImpl extends EFactoryImpl implements SmelltypeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SmelltypeFactory init() {
		try {
			SmelltypeFactory theSmelltypeFactory = (SmelltypeFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelrefactoring.org/smell/type"); 
			if (theSmelltypeFactory != null) {
				return theSmelltypeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SmelltypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmelltypeFactoryImpl() {
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
			case SmelltypePackage.SMELL_TYPE_MODEL: return createSmellTypeModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmellTypeModel createSmellTypeModel() {
		SmellTypeModelImpl smellTypeModel = new SmellTypeModelImpl();
		return smellTypeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmelltypePackage getSmelltypePackage() {
		return (SmelltypePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SmelltypePackage getPackage() {
		return SmelltypePackage.eINSTANCE;
	}

} //SmelltypeFactoryImpl
