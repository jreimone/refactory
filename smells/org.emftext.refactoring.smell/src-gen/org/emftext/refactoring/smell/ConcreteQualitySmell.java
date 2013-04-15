/**
 */
package org.emftext.refactoring.smell;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Quality Smell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getGenericSmell <em>Generic Smell</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getConcreteName <em>Concrete Name</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getQualityCalculations <em>Quality Calculations</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getRefactoring <em>Refactoring</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.refactoring.smell.SmellPackage#getConcreteQualitySmell()
 * @model
 * @generated
 */
public interface ConcreteQualitySmell extends EObject {
	/**
	 * Returns the value of the '<em><b>Generic Smell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generic Smell</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generic Smell</em>' reference.
	 * @see #setGenericSmell(QualitySmell)
	 * @see org.emftext.refactoring.smell.SmellPackage#getConcreteQualitySmell_GenericSmell()
	 * @model required="true"
	 * @generated
	 */
	QualitySmell getGenericSmell();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getGenericSmell <em>Generic Smell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generic Smell</em>' reference.
	 * @see #getGenericSmell()
	 * @generated
	 */
	void setGenericSmell(QualitySmell value);

	/**
	 * Returns the value of the '<em><b>Concrete Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Name</em>' attribute.
	 * @see #setConcreteName(String)
	 * @see org.emftext.refactoring.smell.SmellPackage#getConcreteQualitySmell_ConcreteName()
	 * @model required="true"
	 * @generated
	 */
	String getConcreteName();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getConcreteName <em>Concrete Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concrete Name</em>' attribute.
	 * @see #getConcreteName()
	 * @generated
	 */
	void setConcreteName(String value);

	/**
	 * Returns the value of the '<em><b>Quality Calculations</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.refactoring.smell.QualityCalculation}.
	 * It is bidirectional and its opposite is '{@link org.emftext.refactoring.smell.QualityCalculation#getConcreteSmell <em>Concrete Smell</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Calculations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Calculations</em>' containment reference list.
	 * @see org.emftext.refactoring.smell.SmellPackage#getConcreteQualitySmell_QualityCalculations()
	 * @see org.emftext.refactoring.smell.QualityCalculation#getConcreteSmell
	 * @model opposite="concreteSmell" containment="true" required="true"
	 * @generated
	 */
	EList<QualityCalculation> getQualityCalculations();

	/**
	 * Returns the value of the '<em><b>Refactoring</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.rolemapping.RoleMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refactoring</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refactoring</em>' reference list.
	 * @see org.emftext.refactoring.smell.SmellPackage#getConcreteQualitySmell_Refactoring()
	 * @model
	 * @generated
	 */
	EList<RoleMapping> getRefactoring();

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(EPackage)
	 * @see org.emftext.refactoring.smell.SmellPackage#getConcreteQualitySmell_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetamodel();

	/**
	 * Sets the value of the '{@link org.emftext.refactoring.smell.ConcreteQualitySmell#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(EPackage value);

} // ConcreteQualitySmell
