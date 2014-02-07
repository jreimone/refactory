/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Co Evolution Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getEvent <em>Event</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getAction <em>Action</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.coed.CoedPackage#getCoEvolutionDefinition()
 * @model
 * @generated
 */
public interface CoEvolutionDefinition extends EObject {

	/**
   * Returns the value of the '<em><b>Event</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.modelrefactoring.evolution.coed.Event#getCoED <em>Co ED</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference.
   * @see #setEvent(Event)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getCoEvolutionDefinition_Event()
   * @see org.modelrefactoring.evolution.coed.Event#getCoED
   * @model opposite="coED" containment="true" required="true"
   * @generated
   */
	Event getEvent();

	/**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' containment reference.
   * @see #getEvent()
   * @generated
   */
	void setEvent(Event value);

	/**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.modelrefactoring.evolution.coed.Condition#getCoED <em>Co ED</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getCoEvolutionDefinition_Condition()
   * @see org.modelrefactoring.evolution.coed.Condition#getCoED
   * @model opposite="coED" containment="true"
   * @generated
   */
	Condition getCondition();

	/**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
	void setCondition(Condition value);

	/**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.modelrefactoring.evolution.coed.Action#getCoED <em>Co ED</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(Action)
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getCoEvolutionDefinition_Action()
   * @see org.modelrefactoring.evolution.coed.Action#getCoED
   * @model opposite="coED" containment="true" required="true"
   * @generated
   */
	Action getAction();

	/**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
	void setAction(Action value);

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
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getCoEvolutionDefinition_Metamodel()
   * @model required="true"
   * @generated
   */
	EPackage getMetamodel();

	/**
   * Sets the value of the '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getMetamodel <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' reference.
   * @see #getMetamodel()
   * @generated
   */
	void setMetamodel(EPackage value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.modelrefactoring.evolution.coed.MetamodelImport}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.modelrefactoring.evolution.coed.CoedPackage#getCoEvolutionDefinition_Imports()
   * @model containment="true"
   * @generated
   */
  EList<MetamodelImport> getImports();
} // CoEvolutionDefinition
