/**
 */
package org.emftext.refactoring.smell.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.Quality;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmell;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.SmellFactory;
import org.emftext.refactoring.smell.SmellPackage;
import org.emftext.refactoring.smell.custom.ConcreteQualitySmellCustom;
import org.emftext.refactoring.smell.custom.QualitySmellModelCustom;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmellFactoryImpl extends EFactoryImpl implements SmellFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SmellFactory init() {
		try {
			SmellFactory theSmellFactory = (SmellFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelrefactoring.org/smell"); 
			if (theSmellFactory != null) {
				return theSmellFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SmellFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmellFactoryImpl() {
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
			case SmellPackage.QUALITY_SMELL_MODEL: return createQualitySmellModel();
			case SmellPackage.QUALITY: return createQuality();
			case SmellPackage.QUALITY_SMELL: return createQualitySmell();
			case SmellPackage.CONCRETE_QUALITY_SMELL: return createConcreteQualitySmell();
			case SmellPackage.QUALITY_CALCULATION: return createQualityCalculation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualitySmellModel createQualitySmellModel() {
		QualitySmellModelImpl qualitySmellModel = new QualitySmellModelCustom();
		return qualitySmellModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality createQuality() {
		QualityImpl quality = new QualityImpl();
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualitySmell createQualitySmell() {
		QualitySmellImpl qualitySmell = new QualitySmellImpl();
		return qualitySmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteQualitySmell createConcreteQualitySmell() {
		ConcreteQualitySmellImpl concreteQualitySmell = new ConcreteQualitySmellCustom();
		return concreteQualitySmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCalculation createQualityCalculation() {
		QualityCalculationImpl qualityCalculation = new QualityCalculationImpl();
		return qualityCalculation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmellPackage getSmellPackage() {
		return (SmellPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SmellPackage getPackage() {
		return SmellPackage.eINSTANCE;
	}

} //SmellFactoryImpl
