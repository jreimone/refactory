/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getBodies <em>Bodies</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Modifiers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifiers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifiers</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern_Modifiers()
   * @model containment="true"
   * @generated
   */
  EList<Modifiers> getModifiers();

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
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getParameters();

  /**
   * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bodies</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern_Bodies()
   * @model containment="true"
   * @generated
   */
  EList<PatternBody> getBodies();

  /**
   * Returns the value of the '<em><b>File Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Stores a filename where the pattern comes from. It is only set in the build pattern store
   * 			 inside the IncQuery generator - it is not available anywhere else.
   * <!-- end-model-doc -->
   * @return the value of the '<em>File Name</em>' attribute.
   * @see #setFileName(String)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPattern_FileName()
   * @model
   * @generated
   */
  String getFileName();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getFileName <em>File Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File Name</em>' attribute.
   * @see #getFileName()
   * @generated
   */
  void setFileName(String value);

} // Pattern
