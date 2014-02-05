/**
 */
package org.modelrefactoring.evolution.megamodel.cods;

import org.eclipse.emf.ecore.EObject;

import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;

import org.modelrefactoring.evolution.megamodel.architecture.MetaModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Evolution Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getMetamodel <em>Metamodel</em>}</li>
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
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(MetaModel)
	 * @see org.modelrefactoring.evolution.megamodel.cods.CodsPackage#getDomainSpecificEvolutionSpecification_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	MetaModel getMetamodel();

	/**
	 * Sets the value of the '{@link org.modelrefactoring.evolution.megamodel.cods.DomainSpecificEvolutionSpecification#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(MetaModel value);

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
