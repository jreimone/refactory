/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mega Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getModels <em>Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getInstanceModels <em>Instance Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getReferenceModels <em>Reference Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getTerminalModels <em>Terminal Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaMetaModel <em>Meta Meta Model</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaModels <em>Meta Models</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getTransformationModels <em>Transformation Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel()
 * @model abstract="true"
 * @generated
 */
public interface MegaModel extends TerminalModel {
	/**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link org.qualitune.evolution.megamodel.architecture.Model}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_Models()
   * @model containment="true"
   * @generated
   */
	EList<Model> getModels();

	/**
   * Returns the value of the '<em><b>Instance Models</b></em>' reference list.
   * The list contents are of type {@link org.qualitune.evolution.megamodel.architecture.InstanceModel}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Instance Models</em>' reference list.
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_InstanceModels()
   * @model transient="true" derived="true"
   * @generated
   */
	EList<InstanceModel> getInstanceModels();

	/**
   * Returns the value of the '<em><b>Reference Models</b></em>' reference list.
   * The list contents are of type {@link org.qualitune.evolution.megamodel.architecture.ReferenceModel}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Models</em>' reference list.
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_ReferenceModels()
   * @model transient="true" derived="true"
   * @generated
   */
	EList<ReferenceModel> getReferenceModels();

	/**
   * Returns the value of the '<em><b>Terminal Models</b></em>' reference list.
   * The list contents are of type {@link org.qualitune.evolution.megamodel.architecture.TerminalModel}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Terminal Models</em>' reference list.
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_TerminalModels()
   * @model transient="true" derived="true"
   * @generated
   */
	EList<TerminalModel> getTerminalModels();

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model
   * @generated
   */
	ReferenceModel getReferenceModelByEPackage(EPackage epackage);

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model
   * @generated
   */
	TerminalModel getTerminalModelByEObject(EObject model);

	/**
   * Returns the value of the '<em><b>Meta Meta Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Meta Meta Model</em>' reference.
   * @see #setMetaMetaModel(MetaMetaModel)
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_MetaMetaModel()
   * @model transient="true" derived="true"
   * @generated
   */
	MetaMetaModel getMetaMetaModel();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.megamodel.architecture.MegaModel#getMetaMetaModel <em>Meta Meta Model</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Meta Meta Model</em>' reference.
   * @see #getMetaMetaModel()
   * @generated
   */
	void setMetaMetaModel(MetaMetaModel value);

	/**
   * Returns the value of the '<em><b>Meta Models</b></em>' reference list.
   * The list contents are of type {@link org.qualitune.evolution.megamodel.architecture.MetaModel}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Meta Models</em>' reference list.
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_MetaModels()
   * @model transient="true" derived="true"
   * @generated
   */
	EList<MetaModel> getMetaModels();

	/**
   * Returns the value of the '<em><b>Transformation Models</b></em>' reference list.
   * The list contents are of type {@link org.qualitune.evolution.megamodel.architecture.TransformationModel}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation Models</em>' reference list.
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getMegaModel_TransformationModels()
   * @model transient="true" derived="true"
   * @generated
   */
	EList<TransformationModel> getTransformationModels();

} // MegaModel
