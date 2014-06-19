/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.Event#getCoED <em>Co ED</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.coed.CoedPackage#getEvent()
 * @model abstract="true"
 * @generated
 */
public interface Event extends EObject {

  /**
   * Returns the value of the '<em><b>Co ED</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Co ED</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Co ED</em>' container reference.
   * @see #setCoED(CoEvolutionDefinition)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getEvent_CoED()
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getEvent
   * @model opposite="event" required="true" transient="false"
   * @generated
   */
  CoEvolutionDefinition getCoED();

  /**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.Event#getCoED <em>Co ED</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Co ED</em>' container reference.
   * @see #getCoED()
   * @generated
   */
  void setCoED(CoEvolutionDefinition value);
} // Event
