/**
 */
package org.modelrefactoring.evolution.megamodel.cods;

import org.eclipse.emf.ecore.EObject;

import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;

import org.modelrefactoring.evolution.megamodel.architecture.MetaModel;
import org.modelrefactoring.evolution.megamodel.architecture.ReferenceModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Evolution Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getReferenceModel <em>Reference Model</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getED <em>ED</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getCoEvolutionDefinition <em>Co Evolution Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelrefactoring.evolution.megamodel.cods.CodsPackage#getDomainSpecificEvolutionSpecification()
 * @model
 * @generated
 */
public interface DomainSpecificEvolutionSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Model</em>' reference.
	 * @see #setReferenceModel(ReferenceModel)
	 * @see org.modelrefactoring.evolution.megamodel.cods.CodsPackage#getDomainSpecificEvolutionSpecification_ReferenceModel()
	 * @model required="true"
	 * @generated
	 */
	ReferenceModel getReferenceModel();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getReferenceModel <em>Reference Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Model</em>' reference.
	 * @see #getReferenceModel()
	 * @generated
	 */
	void setReferenceModel(ReferenceModel value);

	/**
	 * Returns the value of the '<em><b>ED</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ED</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ED</em>' containment reference.
	 * @see #setED(EvolutionDefinition)
	 * @see org.modelrefactoring.evolution.megamodel.cods.CodsPackage#getDomainSpecificEvolutionSpecification_ED()
	 * @model containment="true"
	 * @generated
	 */
	EvolutionDefinition getED();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getED <em>ED</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ED</em>' containment reference.
	 * @see #getED()
	 * @generated
	 */
	void setED(EvolutionDefinition value);

	/**
	 * Returns the value of the '<em><b>Co Evolution Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Co Evolution Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Co Evolution Definition</em>' containment reference.
	 * @see #setCoEvolutionDefinition(CoEvolutionDefinition)
	 * @see org.modelrefactoring.evolution.megamodel.cods.CodsPackage#getDomainSpecificEvolutionSpecification_CoEvolutionDefinition()
	 * @model containment="true"
	 * @generated
	 */
	CoEvolutionDefinition getCoEvolutionDefinition();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getCoEvolutionDefinition <em>Co Evolution Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Co Evolution Definition</em>' containment reference.
	 * @see #getCoEvolutionDefinition()
	 * @generated
	 */
	void setCoEvolutionDefinition(CoEvolutionDefinition value);

} // DomainSpecificEvolutionSpecification
