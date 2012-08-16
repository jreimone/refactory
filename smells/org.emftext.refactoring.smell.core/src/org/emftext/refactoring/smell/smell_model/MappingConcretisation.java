/**
 */
package org.emftext.refactoring.smell.smell_model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Concretisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.MappingConcretisation#getNewFactor <em>New Factor</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.MappingConcretisation#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getMappingConcretisation()
 * @model
 * @generated
 */
public interface MappingConcretisation extends EObject {
	/**
	 * Returns the value of the '<em><b>New Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Factor</em>' attribute.
	 * @see #setNewFactor(Float)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getMappingConcretisation_NewFactor()
	 * @model
	 * @generated
	 */
	Float getNewFactor();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.MappingConcretisation#getNewFactor <em>New Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Factor</em>' attribute.
	 * @see #getNewFactor()
	 * @generated
	 */
	void setNewFactor(Float value);

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' reference.
	 * @see #setMapping(Mapping)
	 * @see org.emftext.refactoring.smell.smell_model.Smell_modelPackage#getMappingConcretisation_Mapping()
	 * @model required="true"
	 * @generated
	 */
	Mapping getMapping();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.smell_model.MappingConcretisation#getMapping <em>Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Mapping value);

} // MappingConcretisation
