/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.architecture;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.InstanceModel#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getInstanceModel()
 * @model
 * @generated
 */
public interface InstanceModel extends TerminalModel {
	/**
   * Returns the value of the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' reference.
   * @see #setModel(EObject)
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getInstanceModel_Model()
   * @model required="true"
   * @generated
   */
	EObject getModel();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.megamodel.architecture.InstanceModel#getModel <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' reference.
   * @see #getModel()
   * @generated
   */
	void setModel(EObject value);

} // InstanceModel
