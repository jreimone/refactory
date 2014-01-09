/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.qualitune.evolution.megamodel.architecture.ArchitecturePackage;

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
 * @see org.qualitune.evolution.megamodel.cods.CodsFactory
 * @model kind="package"
 * @generated
 */
public interface CodsPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "cods";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.qualitune.org/megamodel/cods";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "cods";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	CodsPackage eINSTANCE = org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl.init();

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.cods.impl.CODSImpl <em>CODS</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.cods.impl.CODSImpl
   * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getCODS()
   * @generated
   */
	int CODS = 0;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__CONFORMS_TO = ArchitecturePackage.MEGA_MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__MODELS = ArchitecturePackage.MEGA_MODEL__MODELS;

	/**
   * The feature id for the '<em><b>Instance Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__INSTANCE_MODELS = ArchitecturePackage.MEGA_MODEL__INSTANCE_MODELS;

	/**
   * The feature id for the '<em><b>Reference Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__REFERENCE_MODELS = ArchitecturePackage.MEGA_MODEL__REFERENCE_MODELS;

	/**
   * The feature id for the '<em><b>Terminal Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__TERMINAL_MODELS = ArchitecturePackage.MEGA_MODEL__TERMINAL_MODELS;

	/**
   * The feature id for the '<em><b>Meta Meta Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__META_META_MODEL = ArchitecturePackage.MEGA_MODEL__META_META_MODEL;

	/**
   * The feature id for the '<em><b>Meta Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__META_MODELS = ArchitecturePackage.MEGA_MODEL__META_MODELS;

	/**
   * The feature id for the '<em><b>Transformation Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__TRANSFORMATION_MODELS = ArchitecturePackage.MEGA_MODEL__TRANSFORMATION_MODELS;

	/**
   * The feature id for the '<em><b>DSES</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS__DSES = ArchitecturePackage.MEGA_MODEL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>CODS</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CODS_FEATURE_COUNT = ArchitecturePackage.MEGA_MODEL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl <em>Domain Specific Evolution Specification</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl
   * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getDomainSpecificEvolutionSpecification()
   * @generated
   */
	int DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION = 1;

	/**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL = 0;

	/**
   * The feature id for the '<em><b>ED</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED = 1;

	/**
   * The feature id for the '<em><b>Co ED</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED = 2;

	/**
   * The number of structural features of the '<em>Domain Specific Evolution Specification</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION_FEATURE_COUNT = 3;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.cods.impl.EvolutionDefinitionImpl <em>Evolution Definition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.cods.impl.EvolutionDefinitionImpl
   * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getEvolutionDefinition()
   * @generated
   */
	int EVOLUTION_DEFINITION = 2;

	/**
   * The number of structural features of the '<em>Evolution Definition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EVOLUTION_DEFINITION_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.cods.impl.CoEvolutionDefinitionImpl <em>Co Evolution Definition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.cods.impl.CoEvolutionDefinitionImpl
   * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getCoEvolutionDefinition()
   * @generated
   */
	int CO_EVOLUTION_DEFINITION = 3;

	/**
   * The number of structural features of the '<em>Co Evolution Definition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION_FEATURE_COUNT = 0;


	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.cods.CODS <em>CODS</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>CODS</em>'.
   * @see org.qualitune.evolution.megamodel.cods.CODS
   * @generated
   */
	EClass getCODS();

	/**
   * Returns the meta object for the containment reference list '{@link org.qualitune.evolution.megamodel.cods.CODS#getDSES <em>DSES</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>DSES</em>'.
   * @see org.qualitune.evolution.megamodel.cods.CODS#getDSES()
   * @see #getCODS()
   * @generated
   */
	EReference getCODS_DSES();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification <em>Domain Specific Evolution Specification</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Specific Evolution Specification</em>'.
   * @see org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification
   * @generated
   */
	EClass getDomainSpecificEvolutionSpecification();

	/**
   * Returns the meta object for the reference '{@link org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel</em>'.
   * @see org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getMetamodel()
   * @see #getDomainSpecificEvolutionSpecification()
   * @generated
   */
	EReference getDomainSpecificEvolutionSpecification_Metamodel();

	/**
   * Returns the meta object for the containment reference '{@link org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getED <em>ED</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>ED</em>'.
   * @see org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getED()
   * @see #getDomainSpecificEvolutionSpecification()
   * @generated
   */
	EReference getDomainSpecificEvolutionSpecification_ED();

	/**
   * Returns the meta object for the containment reference '{@link org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getCoED <em>Co ED</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Co ED</em>'.
   * @see org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getCoED()
   * @see #getDomainSpecificEvolutionSpecification()
   * @generated
   */
	EReference getDomainSpecificEvolutionSpecification_CoED();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.cods.EvolutionDefinition <em>Evolution Definition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Evolution Definition</em>'.
   * @see org.qualitune.evolution.megamodel.cods.EvolutionDefinition
   * @generated
   */
	EClass getEvolutionDefinition();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.cods.CoEvolutionDefinition <em>Co Evolution Definition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Co Evolution Definition</em>'.
   * @see org.qualitune.evolution.megamodel.cods.CoEvolutionDefinition
   * @generated
   */
	EClass getCoEvolutionDefinition();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	CodsFactory getCodsFactory();

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
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.cods.impl.CODSImpl <em>CODS</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.cods.impl.CODSImpl
     * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getCODS()
     * @generated
     */
		EClass CODS = eINSTANCE.getCODS();

		/**
     * The meta object literal for the '<em><b>DSES</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CODS__DSES = eINSTANCE.getCODS_DSES();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl <em>Domain Specific Evolution Specification</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl
     * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getDomainSpecificEvolutionSpecification()
     * @generated
     */
		EClass DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION = eINSTANCE.getDomainSpecificEvolutionSpecification();

		/**
     * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL = eINSTANCE.getDomainSpecificEvolutionSpecification_Metamodel();

		/**
     * The meta object literal for the '<em><b>ED</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED = eINSTANCE.getDomainSpecificEvolutionSpecification_ED();

		/**
     * The meta object literal for the '<em><b>Co ED</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED = eINSTANCE.getDomainSpecificEvolutionSpecification_CoED();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.cods.impl.EvolutionDefinitionImpl <em>Evolution Definition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.cods.impl.EvolutionDefinitionImpl
     * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getEvolutionDefinition()
     * @generated
     */
		EClass EVOLUTION_DEFINITION = eINSTANCE.getEvolutionDefinition();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.cods.impl.CoEvolutionDefinitionImpl <em>Co Evolution Definition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.cods.impl.CoEvolutionDefinitionImpl
     * @see org.qualitune.evolution.megamodel.cods.impl.CodsPackageImpl#getCoEvolutionDefinition()
     * @generated
     */
		EClass CO_EVOLUTION_DEFINITION = eINSTANCE.getCoEvolutionDefinition();

	}

} //CodsPackage
