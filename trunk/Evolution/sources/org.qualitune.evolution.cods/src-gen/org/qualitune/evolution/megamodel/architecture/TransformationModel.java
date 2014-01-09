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
 * A representation of the model object '<em><b>Transformation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.TransformationModel#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getTransformationModel()
 * @model
 * @generated
 */
public interface TransformationModel extends TerminalModel {
	/**
   * Returns the value of the '<em><b>Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation</em>' reference.
   * @see #setTransformation(EObject)
   * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getTransformationModel_Transformation()
   * @model required="true"
   * @generated
   */
	EObject getTransformation();

	/**
   * Sets the value of the '{@link org.qualitune.evolution.megamodel.architecture.TransformationModel#getTransformation <em>Transformation</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transformation</em>' reference.
   * @see #getTransformation()
   * @generated
   */
	void setTransformation(EObject value);

} // TransformationModel
