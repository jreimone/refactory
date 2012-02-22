/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.guery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Motif Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.guery.MotifModel#getMotifs <em>Motifs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.guery.GueryPackage#getMotifModel()
 * @model
 * @generated
 */
public interface MotifModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Motifs</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.guery.Motif}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Motifs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Motifs</em>' containment reference list.
	 * @see org.qualitune.guery.GueryPackage#getMotifModel_Motifs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Motif> getMotifs();

} // MotifModel
