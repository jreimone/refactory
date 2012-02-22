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
 * A representation of the model object '<em><b>Grouping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.guery.Grouping#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.guery.GueryPackage#getGrouping()
 * @model
 * @generated
 */
public interface Grouping extends EObject {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' attribute list.
	 * @see org.qualitune.guery.GueryPackage#getGrouping_Expressions()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getExpressions();

} // Grouping
