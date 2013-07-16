/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference#getVar <em>Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariableReference()
 * @model features="variable" 
 *        variableType="org.eclipse.incquery.patternlanguage.patternLanguage.Variable" variableOpposite="references" variableTransient="true" variableDerived="true" variableSuppressedGetVisibility="true"
 * @generated
 */
public interface VariableReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>Warning! This feature contains the original reference text,
   *          not the variable name. For variable name, use the
   *          {@link #variable}/{@link Variable#getName} reference chain.
   * 
   * 		This is significant when using anonymous variables (named '_').</p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariableReference_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Variable value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (variable == null) {\n\tInternalEObject container = this.eContainer;\n\twhile (container != null\n\t&& !(container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody \n\t\t|| container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.Pattern)) {\n\tcontainer = container.eInternalContainer();\n\t}\n\n\tif (container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody) {\n\t\t//The side-effect of this call initializes the variable\n\t\t((org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody) container).getVariables();\n\t} else if (container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.Pattern) {\n\t\torg.eclipse.incquery.patternlanguage.patternLanguage.Pattern pattern = \n\t\t(org.eclipse.incquery.patternlanguage.patternLanguage.Pattern) container;\n\t\tfor (org.eclipse.incquery.patternlanguage.patternLanguage.Variable var : pattern.getParameters()) {\n\t\t\tif (var.getName().equals(getVar())) {\n\t\t\t\tvar.getReferences().add(this);\n\t\t\t}\n\t\t}\n\t}  \n}\nreturn variable;'"
   * @generated
   */
  Variable getVariable();

} // VariableReference
