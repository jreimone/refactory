/**
 */
package org.emftext.refactoring.smell;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.Quality#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.Quality#getCalculations <em>Calculations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.SmellPackage#getQuality()
 * @model
 * @generated
 */
public interface Quality extends EObject {
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
	 * @see org.emftext.refactoring.smell.SmellPackage#getQuality_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.Quality#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Calculations</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.QualityCalculation}.
	 * It is bidirectional and its opposite is '{@link org.emftext.refactoring.smell.QualityCalculation#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calculations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calculations</em>' reference list.
	 * @see org.emftext.refactoring.smell.SmellPackage#getQuality_Calculations()
	 * @see org.emftext.refactoring.smell.QualityCalculation#getQuality
	 * @model opposite="quality"
	 * @generated
	 */
	EList<QualityCalculation> getCalculations();

} // Quality
