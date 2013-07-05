/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture;

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
 * @see org.qualitune.evolution.megamodel.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "architecture";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.qualitune.org/megamodel/architecture";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "architecture";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	ArchitecturePackage eINSTANCE = org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl.init();

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.ModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getModel()
   * @generated
   */
	int MODEL = 0;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MODEL__CONFORMS_TO = 0;

	/**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MODEL_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.ReferenceModelImpl <em>Reference Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.ReferenceModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getReferenceModel()
   * @generated
   */
	int REFERENCE_MODEL = 1;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int REFERENCE_MODEL__CONFORMS_TO = MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Package</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int REFERENCE_MODEL__PACKAGE = MODEL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Reference Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int REFERENCE_MODEL_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.TerminalModelImpl <em>Terminal Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.TerminalModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getTerminalModel()
   * @generated
   */
	int TERMINAL_MODEL = 2;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERMINAL_MODEL__CONFORMS_TO = MODEL__CONFORMS_TO;

	/**
   * The number of structural features of the '<em>Terminal Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERMINAL_MODEL_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.TransformationModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getTransformationModel()
   * @generated
   */
	int TRANSFORMATION_MODEL = 3;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION_MODEL__CONFORMS_TO = TERMINAL_MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION_MODEL__TRANSFORMATION = TERMINAL_MODEL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Transformation Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION_MODEL_FEATURE_COUNT = TERMINAL_MODEL_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl <em>Mega Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getMegaModel()
   * @generated
   */
	int MEGA_MODEL = 4;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__CONFORMS_TO = TERMINAL_MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__MODELS = TERMINAL_MODEL_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Instance Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__INSTANCE_MODELS = TERMINAL_MODEL_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Reference Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__REFERENCE_MODELS = TERMINAL_MODEL_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Terminal Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__TERMINAL_MODELS = TERMINAL_MODEL_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Meta Meta Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__META_META_MODEL = TERMINAL_MODEL_FEATURE_COUNT + 4;

	/**
   * The feature id for the '<em><b>Meta Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__META_MODELS = TERMINAL_MODEL_FEATURE_COUNT + 5;

	/**
   * The feature id for the '<em><b>Transformation Models</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL__TRANSFORMATION_MODELS = TERMINAL_MODEL_FEATURE_COUNT + 6;

	/**
   * The number of structural features of the '<em>Mega Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MEGA_MODEL_FEATURE_COUNT = TERMINAL_MODEL_FEATURE_COUNT + 7;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.MetaMetaModelImpl <em>Meta Meta Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.MetaMetaModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getMetaMetaModel()
   * @generated
   */
	int META_META_MODEL = 5;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int META_META_MODEL__CONFORMS_TO = REFERENCE_MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Package</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int META_META_MODEL__PACKAGE = REFERENCE_MODEL__PACKAGE;

	/**
   * The number of structural features of the '<em>Meta Meta Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int META_META_MODEL_FEATURE_COUNT = REFERENCE_MODEL_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.MetaModelImpl <em>Meta Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.MetaModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getMetaModel()
   * @generated
   */
	int META_MODEL = 6;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int META_MODEL__CONFORMS_TO = REFERENCE_MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Package</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int META_MODEL__PACKAGE = REFERENCE_MODEL__PACKAGE;

	/**
   * The number of structural features of the '<em>Meta Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int META_MODEL_FEATURE_COUNT = REFERENCE_MODEL_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.qualitune.evolution.megamodel.architecture.impl.InstanceModelImpl <em>Instance Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.qualitune.evolution.megamodel.architecture.impl.InstanceModelImpl
   * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getInstanceModel()
   * @generated
   */
	int INSTANCE_MODEL = 7;

	/**
   * The feature id for the '<em><b>Conforms To</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCE_MODEL__CONFORMS_TO = TERMINAL_MODEL__CONFORMS_TO;

	/**
   * The feature id for the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCE_MODEL__MODEL = TERMINAL_MODEL_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Instance Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INSTANCE_MODEL_FEATURE_COUNT = TERMINAL_MODEL_FEATURE_COUNT + 1;


	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.Model
   * @generated
   */
	EClass getModel();

	/**
   * Returns the meta object for the reference '{@link org.qualitune.evolution.megamodel.architecture.Model#getConformsTo <em>Conforms To</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Conforms To</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.Model#getConformsTo()
   * @see #getModel()
   * @generated
   */
	EReference getModel_ConformsTo();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.ReferenceModel <em>Reference Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.ReferenceModel
   * @generated
   */
	EClass getReferenceModel();

	/**
   * Returns the meta object for the reference '{@link org.qualitune.evolution.megamodel.architecture.ReferenceModel#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Package</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.ReferenceModel#getPackage()
   * @see #getReferenceModel()
   * @generated
   */
	EReference getReferenceModel_Package();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.TerminalModel <em>Terminal Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.TerminalModel
   * @generated
   */
	EClass getTerminalModel();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.TransformationModel <em>Transformation Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.TransformationModel
   * @generated
   */
	EClass getTransformationModel();

	/**
   * Returns the meta object for the reference '{@link org.qualitune.evolution.megamodel.architecture.TransformationModel#getTransformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Transformation</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.TransformationModel#getTransformation()
   * @see #getTransformationModel()
   * @generated
   */
	EReference getTransformationModel_Transformation();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.MegaModel <em>Mega Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mega Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel
   * @generated
   */
	EClass getMegaModel();

	/**
   * Returns the meta object for the containment reference list '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Models</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getModels()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_Models();

	/**
   * Returns the meta object for the reference list '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getInstanceModels <em>Instance Models</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Instance Models</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getInstanceModels()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_InstanceModels();

	/**
   * Returns the meta object for the reference list '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getReferenceModels <em>Reference Models</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Reference Models</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getReferenceModels()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_ReferenceModels();

	/**
   * Returns the meta object for the reference list '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getTerminalModels <em>Terminal Models</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Terminal Models</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getTerminalModels()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_TerminalModels();

	/**
   * Returns the meta object for the reference '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaMetaModel <em>Meta Meta Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Meta Meta Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaMetaModel()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_MetaMetaModel();

	/**
   * Returns the meta object for the reference list '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaModels <em>Meta Models</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Meta Models</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaModels()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_MetaModels();

	/**
   * Returns the meta object for the reference list '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getTransformationModels <em>Transformation Models</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Transformation Models</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MegaModel#getTransformationModels()
   * @see #getMegaModel()
   * @generated
   */
	EReference getMegaModel_TransformationModels();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.MetaMetaModel <em>Meta Meta Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meta Meta Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MetaMetaModel
   * @generated
   */
	EClass getMetaMetaModel();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.MetaModel <em>Meta Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meta Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.MetaModel
   * @generated
   */
	EClass getMetaModel();

	/**
   * Returns the meta object for class '{@link org.qualitune.evolution.megamodel.architecture.InstanceModel <em>Instance Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.InstanceModel
   * @generated
   */
	EClass getInstanceModel();

	/**
   * Returns the meta object for the reference '{@link org.qualitune.evolution.megamodel.architecture.InstanceModel#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Model</em>'.
   * @see org.qualitune.evolution.megamodel.architecture.InstanceModel#getModel()
   * @see #getInstanceModel()
   * @generated
   */
	EReference getInstanceModel_Model();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	ArchitectureFactory getArchitectureFactory();

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
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.ModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getModel()
     * @generated
     */
		EClass MODEL = eINSTANCE.getModel();

		/**
     * The meta object literal for the '<em><b>Conforms To</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MODEL__CONFORMS_TO = eINSTANCE.getModel_ConformsTo();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.ReferenceModelImpl <em>Reference Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.ReferenceModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getReferenceModel()
     * @generated
     */
		EClass REFERENCE_MODEL = eINSTANCE.getReferenceModel();

		/**
     * The meta object literal for the '<em><b>Package</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference REFERENCE_MODEL__PACKAGE = eINSTANCE.getReferenceModel_Package();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.TerminalModelImpl <em>Terminal Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.TerminalModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getTerminalModel()
     * @generated
     */
		EClass TERMINAL_MODEL = eINSTANCE.getTerminalModel();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.TransformationModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getTransformationModel()
     * @generated
     */
		EClass TRANSFORMATION_MODEL = eINSTANCE.getTransformationModel();

		/**
     * The meta object literal for the '<em><b>Transformation</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TRANSFORMATION_MODEL__TRANSFORMATION = eINSTANCE.getTransformationModel_Transformation();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl <em>Mega Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.MegaModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getMegaModel()
     * @generated
     */
		EClass MEGA_MODEL = eINSTANCE.getMegaModel();

		/**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__MODELS = eINSTANCE.getMegaModel_Models();

		/**
     * The meta object literal for the '<em><b>Instance Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__INSTANCE_MODELS = eINSTANCE.getMegaModel_InstanceModels();

		/**
     * The meta object literal for the '<em><b>Reference Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__REFERENCE_MODELS = eINSTANCE.getMegaModel_ReferenceModels();

		/**
     * The meta object literal for the '<em><b>Terminal Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__TERMINAL_MODELS = eINSTANCE.getMegaModel_TerminalModels();

		/**
     * The meta object literal for the '<em><b>Meta Meta Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__META_META_MODEL = eINSTANCE.getMegaModel_MetaMetaModel();

		/**
     * The meta object literal for the '<em><b>Meta Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__META_MODELS = eINSTANCE.getMegaModel_MetaModels();

		/**
     * The meta object literal for the '<em><b>Transformation Models</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference MEGA_MODEL__TRANSFORMATION_MODELS = eINSTANCE.getMegaModel_TransformationModels();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.MetaMetaModelImpl <em>Meta Meta Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.MetaMetaModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getMetaMetaModel()
     * @generated
     */
		EClass META_META_MODEL = eINSTANCE.getMetaMetaModel();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.MetaModelImpl <em>Meta Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.MetaModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getMetaModel()
     * @generated
     */
		EClass META_MODEL = eINSTANCE.getMetaModel();

		/**
     * The meta object literal for the '{@link org.qualitune.evolution.megamodel.architecture.impl.InstanceModelImpl <em>Instance Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.qualitune.evolution.megamodel.architecture.impl.InstanceModelImpl
     * @see org.qualitune.evolution.megamodel.architecture.impl.ArchitecturePackageImpl#getInstanceModel()
     * @generated
     */
		EClass INSTANCE_MODEL = eINSTANCE.getInstanceModel();

		/**
     * The meta object literal for the '<em><b>Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INSTANCE_MODEL__MODEL = eINSTANCE.getInstanceModel_Model();

	}

} //ArchitecturePackage
