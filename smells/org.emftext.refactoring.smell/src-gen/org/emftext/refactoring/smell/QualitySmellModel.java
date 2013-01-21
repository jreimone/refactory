/**
 */
package org.emftext.refactoring.smell;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality Smell Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.QualitySmellModel#getSmells <em>Smells</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.QualitySmellModel#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.QualitySmellModel#getConcreteSmells <em>Concrete Smells</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.SmellPackage#getQualitySmellModel()
 * @model
 * @generated
 */
public interface QualitySmellModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Smells</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.QualitySmell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smells</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smells</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualitySmellModel_Smells()
	 * @model containment="true"
	 * @generated
	 */
	EList<QualitySmell> getSmells();

	/**
	 * Returns the value of the '<em><b>Qualities</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.Quality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualities</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualitySmellModel_Qualities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Quality> getQualities();

	/**
	 * Returns the value of the '<em><b>Concrete Smells</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.ConcreteQualitySmell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Smells</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Smells</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.SmellPackage#getQualitySmellModel_ConcreteSmells()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConcreteQualitySmell> getConcreteSmells();

} // QualitySmellModel
