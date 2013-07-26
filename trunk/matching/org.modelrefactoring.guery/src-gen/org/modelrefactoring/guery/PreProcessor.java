/**
 */
package org.modelrefactoring.guery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pre Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.guery.PreProcessor#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.guery.GueryPackage#getPreProcessor()
 * @model
 * @generated
 */
public interface PreProcessor extends EObject {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(Class)
	 * @see org.modelrefactoring.guery.GueryPackage#getPreProcessor_Class()
	 * @model required="true"
	 * @generated
	 */
	Class getClass_();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.PreProcessor#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(Class value);

} // PreProcessor
