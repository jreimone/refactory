/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.Condition#getCoED <em>Co ED</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.coed.CoedPackage#getCondition()
 * @model abstract="true"
 * @generated
 */
public interface Condition extends EObject {

  /**
   * Returns the value of the '<em><b>Co ED</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Co ED</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Co ED</em>' container reference.
   * @see #setCoED(CoEvolutionDefinition)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getCondition_CoED()
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getCondition
   * @model opposite="condition" required="true" transient="false"
   * @generated
   */
  CoEvolutionDefinition getCoED();

  /**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.Condition#getCoED <em>Co ED</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Co ED</em>' container reference.
   * @see #getCoED()
   * @generated
   */
  void setCoED(CoEvolutionDefinition value);
} // Condition
