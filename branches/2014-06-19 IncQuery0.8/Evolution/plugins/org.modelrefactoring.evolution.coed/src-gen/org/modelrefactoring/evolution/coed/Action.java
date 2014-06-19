/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.Action#getCoED <em>Co ED</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.coed.CoedPackage#getAction()
 * @model abstract="true"
 * @generated
 */
public interface Action extends EObject {

  /**
   * Returns the value of the '<em><b>Co ED</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Co ED</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Co ED</em>' container reference.
   * @see #setCoED(CoEvolutionDefinition)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getAction_CoED()
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getAction
   * @model opposite="action" required="true" transient="false"
   * @generated
   */
  CoEvolutionDefinition getCoED();

  /**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.Action#getCoED <em>Co ED</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Co ED</em>' container reference.
   * @see #getCoED()
   * @generated
   */
  void setCoED(CoEvolutionDefinition value);
} // Action
