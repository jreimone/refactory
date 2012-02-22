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
 * A representation of the model object '<em><b>Motif</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.guery.Motif#getName <em>Name</em>}</li>
 *   <li>{@link org.qualitune.guery.Motif#getVertexSelection <em>Vertex Selection</em>}</li>
 *   <li>{@link org.qualitune.guery.Motif#getGroupBy <em>Group By</em>}</li>
 *   <li>{@link org.qualitune.guery.Motif#getPrepare <em>Prepare</em>}</li>
 *   <li>{@link org.qualitune.guery.Motif#getEdgeSelections <em>Edge Selections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.guery.GueryPackage#getMotif()
 * @model
 * @generated
 */
public interface Motif extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.qualitune.guery.GueryPackage#getMotif_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.qualitune.guery.Motif#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Vertex Selection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex Selection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Selection</em>' containment reference.
	 * @see #setVertexSelection(VertexSelection)
	 * @see org.qualitune.guery.GueryPackage#getMotif_VertexSelection()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VertexSelection getVertexSelection();

	/**
	 * Sets the value of the '{@link org.qualitune.guery.Motif#getVertexSelection <em>Vertex Selection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Selection</em>' containment reference.
	 * @see #getVertexSelection()
	 * @generated
	 */
	void setVertexSelection(VertexSelection value);

	/**
	 * Returns the value of the '<em><b>Group By</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.guery.Grouping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group By</em>' containment reference list.
	 * @see org.qualitune.guery.GueryPackage#getMotif_GroupBy()
	 * @model containment="true"
	 * @generated
	 */
	EList<Grouping> getGroupBy();

	/**
	 * Returns the value of the '<em><b>Prepare</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.guery.PreProcessor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prepare</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prepare</em>' containment reference list.
	 * @see org.qualitune.guery.GueryPackage#getMotif_Prepare()
	 * @model containment="true"
	 * @generated
	 */
	EList<PreProcessor> getPrepare();

	/**
	 * Returns the value of the '<em><b>Edge Selections</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.guery.EdgeSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Selections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Selections</em>' containment reference list.
	 * @see org.qualitune.guery.GueryPackage#getMotif_EdgeSelections()
	 * @model containment="true"
	 * @generated
	 */
	EList<EdgeSelection> getEdgeSelections();

} // Motif
