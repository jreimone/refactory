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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ReferenceModel> getReferenceModels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	MetaMetaModel getMetaMetaModel();

} // MegaModel
