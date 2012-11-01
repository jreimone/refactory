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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.architecture.Model#getConformsTo <em>Conforms To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getModel()
 * @model abstract="true"
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Conforms To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conforms To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conforms To</em>' reference.
	 * @see #setConformsTo(ReferenceModel)
	 * @see org.qualitune.evolution.megamodel.architecture.ArchitecturePackage#getModel_ConformsTo()
	 * @model required="true"
	 * @generated
	 */
	ReferenceModel getConformsTo();

	/**
	 * Sets the value of the '{@link org.qualitune.evolution.megamodel.architecture.Model#getConformsTo <em>Conforms To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conforms To</em>' reference.
	 * @see #getConformsTo()
	 * @generated
	 */
	void setConformsTo(ReferenceModel value);

} // Model
