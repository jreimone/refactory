/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods;

import org.eclipse.emf.common.util.EList;

import org.qualitune.evolution.megamodel.architecture.MegaModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CODS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.cods.CODS#getDSES <em>DSES</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.megamodel.cods.CodsPackage#getCODS()
 * @model
 * @generated
 */
public interface CODS extends MegaModel {
	/**
	 * Returns the value of the '<em><b>DSES</b></em>' containment reference list.
	 * The list contents are of type {@link org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSES</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSES</em>' containment reference list.
	 * @see org.qualitune.evolution.megamodel.cods.CodsPackage#getCODS_DSES()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainSpecificEvolutionSpecification> getDSES();

} // CODS
