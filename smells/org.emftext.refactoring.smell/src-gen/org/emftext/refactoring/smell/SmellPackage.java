/**
 */
package org.emftext.refactoring.smell;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.refactoring.smell.SmellFactory
 * @model kind="package"
 * @generated
 */
public interface SmellPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "smell";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelrefactoring.org/smell";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "smell";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmellPackage eINSTANCE = org.emftext.refactoring.smell.impl.SmellPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.impl.QualitySmellModelImpl <em>Quality Smell Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.impl.QualitySmellModelImpl
	 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQualitySmellModel()
	 * @generated
	 */
	int QUALITY_SMELL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Smells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL_MODEL__SMELLS = 0;

	/**
	 * The feature id for the '<em><b>Qualities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL_MODEL__QUALITIES = 1;

	/**
	 * The feature id for the '<em><b>Concrete Smells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL_MODEL__CONCRETE_SMELLS = 2;

	/**
	 * The feature id for the '<em><b>Smelling Metamodels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL_MODEL__SMELLING_METAMODELS = 3;

	/**
	 * The number of structural features of the '<em>Quality Smell Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL_MODEL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.impl.QualityImpl <em>Quality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.impl.QualityImpl
	 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQuality()
	 * @generated
	 */
	int QUALITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Calculations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY__CALCULATIONS = 1;

	/**
	 * The number of structural features of the '<em>Quality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.impl.QualitySmellImpl <em>Quality Smell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.impl.QualitySmellImpl
	 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQualitySmell()
	 * @generated
	 */
	int QUALITY_SMELL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Quality Smell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SMELL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl <em>Concrete Quality Smell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl
	 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getConcreteQualitySmell()
	 * @generated
	 */
	int CONCRETE_QUALITY_SMELL = 3;

	/**
	 * The feature id for the '<em><b>Generic Smell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_QUALITY_SMELL__GENERIC_SMELL = 0;

	/**
	 * The feature id for the '<em><b>Concrete Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_QUALITY_SMELL__CONCRETE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Quality Calculations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS = 2;

	/**
	 * The feature id for the '<em><b>Refactoring</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_QUALITY_SMELL__REFACTORING = 3;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_QUALITY_SMELL__METAMODEL = 4;

	/**
	 * The number of structural features of the '<em>Concrete Quality Smell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_QUALITY_SMELL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.emftext.refactoring.smell.impl.QualityCalculationImpl <em>Quality Calculation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.refactoring.smell.impl.QualityCalculationImpl
	 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQualityCalculation()
	 * @generated
	 */
	int QUALITY_CALCULATION = 4;

	/**
	 * The feature id for the '<em><b>Concrete Smell</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_CALCULATION__CONCRETE_SMELL = 0;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_CALCULATION__QUALITY = 1;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_CALCULATION__INFLUENCE = 2;

	/**
	 * The feature id for the '<em><b>Calculation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_CALCULATION__CALCULATION = 3;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_CALCULATION__THRESHOLD = 4;

	/**
	 * The number of structural features of the '<em>Quality Calculation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_CALCULATION_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.QualitySmellModel <em>Quality Smell Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Smell Model</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmellModel
	 * @generated
	 */
	EClass getQualitySmellModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.QualitySmellModel#getSmells <em>Smells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Smells</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmellModel#getSmells()
	 * @see #getQualitySmellModel()
	 * @generated
	 */
	EReference getQualitySmellModel_Smells();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.QualitySmellModel#getQualities <em>Qualities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Qualities</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmellModel#getQualities()
	 * @see #getQualitySmellModel()
	 * @generated
	 */
	EReference getQualitySmellModel_Qualities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.QualitySmellModel#getConcreteSmells <em>Concrete Smells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concrete Smells</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmellModel#getConcreteSmells()
	 * @see #getQualitySmellModel()
	 * @generated
	 */
	EReference getQualitySmellModel_ConcreteSmells();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.refactoring.smell.QualitySmellModel#getSmellingMetamodels <em>Smelling Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Smelling Metamodels</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmellModel#getSmellingMetamodels()
	 * @see #getQualitySmellModel()
	 * @generated
	 */
	EReference getQualitySmellModel_SmellingMetamodels();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.Quality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality</em>'.
	 * @see org.emftext.refactoring.smell.Quality
	 * @generated
	 */
	EClass getQuality();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.Quality#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.Quality#getName()
	 * @see #getQuality()
	 * @generated
	 */
	EAttribute getQuality_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.refactoring.smell.Quality#getCalculations <em>Calculations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Calculations</em>'.
	 * @see org.emftext.refactoring.smell.Quality#getCalculations()
	 * @see #getQuality()
	 * @generated
	 */
	EReference getQuality_Calculations();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.QualitySmell <em>Quality Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Smell</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmell
	 * @generated
	 */
	EClass getQualitySmell();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.QualitySmell#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.refactoring.smell.QualitySmell#getName()
	 * @see #getQualitySmell()
	 * @generated
	 */
	EAttribute getQualitySmell_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.ConcreteQualitySmell <em>Concrete Quality Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Quality Smell</em>'.
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell
	 * @generated
	 */
	EClass getConcreteQualitySmell();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getGenericSmell <em>Generic Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generic Smell</em>'.
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell#getGenericSmell()
	 * @see #getConcreteQualitySmell()
	 * @generated
	 */
	EReference getConcreteQualitySmell_GenericSmell();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getConcreteName <em>Concrete Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concrete Name</em>'.
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell#getConcreteName()
	 * @see #getConcreteQualitySmell()
	 * @generated
	 */
	EAttribute getConcreteQualitySmell_ConcreteName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getQualityCalculations <em>Quality Calculations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Quality Calculations</em>'.
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell#getQualityCalculations()
	 * @see #getConcreteQualitySmell()
	 * @generated
	 */
	EReference getConcreteQualitySmell_QualityCalculations();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getRefactoring <em>Refactoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refactoring</em>'.
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell#getRefactoring()
	 * @see #getConcreteQualitySmell()
	 * @generated
	 */
	EReference getConcreteQualitySmell_Refactoring();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see org.emftext.refactoring.smell.ConcreteQualitySmell#getMetamodel()
	 * @see #getConcreteQualitySmell()
	 * @generated
	 */
	EReference getConcreteQualitySmell_Metamodel();

	/**
	 * Returns the meta object for class '{@link org.emftext.refactoring.smell.QualityCalculation <em>Quality Calculation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Calculation</em>'.
	 * @see org.emftext.refactoring.smell.QualityCalculation
	 * @generated
	 */
	EClass getQualityCalculation();

	/**
	 * Returns the meta object for the container reference '{@link org.emftext.refactoring.smell.QualityCalculation#getConcreteSmell <em>Concrete Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Concrete Smell</em>'.
	 * @see org.emftext.refactoring.smell.QualityCalculation#getConcreteSmell()
	 * @see #getQualityCalculation()
	 * @generated
	 */
	EReference getQualityCalculation_ConcreteSmell();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.QualityCalculation#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Quality</em>'.
	 * @see org.emftext.refactoring.smell.QualityCalculation#getQuality()
	 * @see #getQualityCalculation()
	 * @generated
	 */
	EReference getQualityCalculation_Quality();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.QualityCalculation#getInfluence <em>Influence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Influence</em>'.
	 * @see org.emftext.refactoring.smell.QualityCalculation#getInfluence()
	 * @see #getQualityCalculation()
	 * @generated
	 */
	EAttribute getQualityCalculation_Influence();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.refactoring.smell.QualityCalculation#getCalculation <em>Calculation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calculation</em>'.
	 * @see org.emftext.refactoring.smell.QualityCalculation#getCalculation()
	 * @see #getQualityCalculation()
	 * @generated
	 */
	EReference getQualityCalculation_Calculation();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.refactoring.smell.QualityCalculation#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see org.emftext.refactoring.smell.QualityCalculation#getThreshold()
	 * @see #getQualityCalculation()
	 * @generated
	 */
	EAttribute getQualityCalculation_Threshold();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SmellFactory getSmellFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.impl.QualitySmellModelImpl <em>Quality Smell Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.impl.QualitySmellModelImpl
		 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQualitySmellModel()
		 * @generated
		 */
		EClass QUALITY_SMELL_MODEL = eINSTANCE.getQualitySmellModel();

		/**
		 * The meta object literal for the '<em><b>Smells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_SMELL_MODEL__SMELLS = eINSTANCE.getQualitySmellModel_Smells();

		/**
		 * The meta object literal for the '<em><b>Qualities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_SMELL_MODEL__QUALITIES = eINSTANCE.getQualitySmellModel_Qualities();

		/**
		 * The meta object literal for the '<em><b>Concrete Smells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_SMELL_MODEL__CONCRETE_SMELLS = eINSTANCE.getQualitySmellModel_ConcreteSmells();

		/**
		 * The meta object literal for the '<em><b>Smelling Metamodels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_SMELL_MODEL__SMELLING_METAMODELS = eINSTANCE.getQualitySmellModel_SmellingMetamodels();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.impl.QualityImpl <em>Quality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.impl.QualityImpl
		 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQuality()
		 * @generated
		 */
		EClass QUALITY = eINSTANCE.getQuality();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY__NAME = eINSTANCE.getQuality_Name();

		/**
		 * The meta object literal for the '<em><b>Calculations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY__CALCULATIONS = eINSTANCE.getQuality_Calculations();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.impl.QualitySmellImpl <em>Quality Smell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.impl.QualitySmellImpl
		 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQualitySmell()
		 * @generated
		 */
		EClass QUALITY_SMELL = eINSTANCE.getQualitySmell();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_SMELL__NAME = eINSTANCE.getQualitySmell_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl <em>Concrete Quality Smell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.impl.ConcreteQualitySmellImpl
		 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getConcreteQualitySmell()
		 * @generated
		 */
		EClass CONCRETE_QUALITY_SMELL = eINSTANCE.getConcreteQualitySmell();

		/**
		 * The meta object literal for the '<em><b>Generic Smell</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_QUALITY_SMELL__GENERIC_SMELL = eINSTANCE.getConcreteQualitySmell_GenericSmell();

		/**
		 * The meta object literal for the '<em><b>Concrete Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_QUALITY_SMELL__CONCRETE_NAME = eINSTANCE.getConcreteQualitySmell_ConcreteName();

		/**
		 * The meta object literal for the '<em><b>Quality Calculations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_QUALITY_SMELL__QUALITY_CALCULATIONS = eINSTANCE.getConcreteQualitySmell_QualityCalculations();

		/**
		 * The meta object literal for the '<em><b>Refactoring</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_QUALITY_SMELL__REFACTORING = eINSTANCE.getConcreteQualitySmell_Refactoring();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_QUALITY_SMELL__METAMODEL = eINSTANCE.getConcreteQualitySmell_Metamodel();

		/**
		 * The meta object literal for the '{@link org.emftext.refactoring.smell.impl.QualityCalculationImpl <em>Quality Calculation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.refactoring.smell.impl.QualityCalculationImpl
		 * @see org.emftext.refactoring.smell.impl.SmellPackageImpl#getQualityCalculation()
		 * @generated
		 */
		EClass QUALITY_CALCULATION = eINSTANCE.getQualityCalculation();

		/**
		 * The meta object literal for the '<em><b>Concrete Smell</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_CALCULATION__CONCRETE_SMELL = eINSTANCE.getQualityCalculation_ConcreteSmell();

		/**
		 * The meta object literal for the '<em><b>Quality</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_CALCULATION__QUALITY = eINSTANCE.getQualityCalculation_Quality();

		/**
		 * The meta object literal for the '<em><b>Influence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_CALCULATION__INFLUENCE = eINSTANCE.getQualityCalculation_Influence();

		/**
		 * The meta object literal for the '<em><b>Calculation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALITY_CALCULATION__CALCULATION = eINSTANCE.getQualityCalculation_Calculation();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_CALCULATION__THRESHOLD = eINSTANCE.getQualityCalculation_Threshold();

	}

} //SmellPackage
