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
 *   <li>{@link org.modelrefactoring.guery.PreProcessor#getProcessorClassName <em>Processor Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.guery.GueryPackage#getPreProcessor()
 * @model
 * @generated
 */
public interface PreProcessor extends EObject {
	/**
	 * Returns the value of the '<em><b>Processor Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor Class Name</em>' attribute.
	 * @see #setProcessorClassName(String)
	 * @see org.modelrefactoring.guery.GueryPackage#getPreProcessor_ProcessorClassName()
	 * @model required="true"
	 * @generated
	 */
	String getProcessorClassName();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.guery.PreProcessor#getProcessorClassName <em>Processor Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor Class Name</em>' attribute.
	 * @see #getProcessorClassName()
	 * @generated
	 */
	void setProcessorClassName(String value);

} // PreProcessor
