/**
 */
package org.emftext.refactoring.smell.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.core.Mapping#getFactor <em>Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor</em>' attribute.
	 * @see #setFactor(Float)
	 * @see org.emftext.refactoring.smell.core.Smell_modelPackage#getMapping_Factor()
	 * @model
	 * @generated
	 */
	Float getFactor();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.core.Mapping#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(Float value);

} // Mapping
