/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelrefactoring.evolution.megamodel.architecture;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.architecture.ReferenceModel#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.megamodel.architecture.ArchitecturePackage#getReferenceModel()
 * @model abstract="true"
 * @generated
 */
public interface ReferenceModel extends Model {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(EPackage)
	 * @see org.modelrefactoring.evolution.megamodel.architecture.ArchitecturePackage#getReferenceModel_Package()
	 * @model required="true"
	 * @generated
	 */
	EPackage getPackage();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.evolution.megamodel.architecture.ReferenceModel#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(EPackage value);

} // ReferenceModel
