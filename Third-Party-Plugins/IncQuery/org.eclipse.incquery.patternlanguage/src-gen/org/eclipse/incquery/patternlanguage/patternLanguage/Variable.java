/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends JvmIdentifiableElement
{
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
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariable_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>References</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>References</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>References</em>' reference list.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariable_References()
   * @model opposite="variable" transient="true" derived="true"
   * @generated
   */
  EList<VariableReference> getReferences();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.name;'"
   * @generated
   */
  String getSimpleName();

} // Variable
