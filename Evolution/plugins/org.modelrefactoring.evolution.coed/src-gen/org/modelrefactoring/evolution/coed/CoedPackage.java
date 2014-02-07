/**
 */
package org.modelrefactoring.evolution.coed;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.modelrefactoring.evolution.coed.CoedFactory
 * @model kind="package"
 * @generated
 */
public interface CoedPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "coed";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.modelrefactoring.org/evolution/coed";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "coed";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	CoedPackage eINSTANCE = org.modelrefactoring.evolution.coed.impl.CoedPackageImpl.init();

	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl <em>Co Evolution Definition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getCoEvolutionDefinition()
   * @generated
   */
	int CO_EVOLUTION_DEFINITION = 0;

	/**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION__EVENT = 0;

	/**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION__CONDITION = 1;

	/**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION__ACTION = 2;

	/**
   * The feature id for the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION__METAMODEL = 3;

	/**
   * The number of structural features of the '<em>Co Evolution Definition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION_FEATURE_COUNT = 4;

	/**
   * The number of operations of the '<em>Co Evolution Definition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CO_EVOLUTION_DEFINITION_OPERATION_COUNT = 0;


	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.EventImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getEvent()
   * @generated
   */
	int EVENT = 1;

	/**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EVENT_FEATURE_COUNT = 0;

	/**
   * The number of operations of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EVENT_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.ConditionImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getCondition()
   * @generated
   */
	int CONDITION = 2;

	/**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONDITION_FEATURE_COUNT = 0;

	/**
   * The number of operations of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONDITION_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.ActionImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getAction()
   * @generated
   */
	int ACTION = 3;

	/**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ACTION_FEATURE_COUNT = 0;

	/**
   * The number of operations of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ACTION_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.RoleMappingEventImpl <em>Role Mapping Event</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.RoleMappingEventImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getRoleMappingEvent()
   * @generated
   */
	int ROLE_MAPPING_EVENT = 4;

	/**
   * The feature id for the '<em><b>Concrete Refactoring</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_EVENT__CONCRETE_REFACTORING = EVENT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Role Mapping Event</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
   * The number of operations of the '<em>Role Mapping Event</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_EVENT_OPERATION_COUNT = EVENT_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.PlainConditionImpl <em>Plain Condition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.PlainConditionImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getPlainCondition()
   * @generated
   */
	int PLAIN_CONDITION = 5;

	/**
   * The feature id for the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PLAIN_CONDITION__CONDITION = CONDITION_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Plain Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PLAIN_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
   * The number of operations of the '<em>Plain Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PLAIN_CONDITION_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link org.modelrefactoring.evolution.coed.impl.RoleMappingActionImpl <em>Role Mapping Action</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.modelrefactoring.evolution.coed.impl.RoleMappingActionImpl
   * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getRoleMappingAction()
   * @generated
   */
	int ROLE_MAPPING_ACTION = 6;

	/**
   * The feature id for the '<em><b>Concrete Refactoring</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_ACTION__CONCRETE_REFACTORING = ACTION_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Binding</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_ACTION__BINDING = ACTION_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Role Mapping Action</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
   * The number of operations of the '<em>Role Mapping Action</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ROLE_MAPPING_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;


	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition <em>Co Evolution Definition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Co Evolution Definition</em>'.
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition
   * @generated
   */
	EClass getCoEvolutionDefinition();

	/**
   * Returns the meta object for the containment reference '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getEvent()
   * @see #getCoEvolutionDefinition()
   * @generated
   */
	EReference getCoEvolutionDefinition_Event();

	/**
   * Returns the meta object for the containment reference '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getCondition()
   * @see #getCoEvolutionDefinition()
   * @generated
   */
	EReference getCoEvolutionDefinition_Condition();

	/**
   * Returns the meta object for the containment reference '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getAction()
   * @see #getCoEvolutionDefinition()
   * @generated
   */
	EReference getCoEvolutionDefinition_Action();

	/**
   * Returns the meta object for the reference '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Metamodel</em>'.
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition#getMetamodel()
   * @see #getCoEvolutionDefinition()
   * @generated
   */
	EReference getCoEvolutionDefinition_Metamodel();

	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see org.modelrefactoring.evolution.coed.Event
   * @generated
   */
	EClass getEvent();

	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see org.modelrefactoring.evolution.coed.Condition
   * @generated
   */
	EClass getCondition();

	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see org.modelrefactoring.evolution.coed.Action
   * @generated
   */
	EClass getAction();

	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.RoleMappingEvent <em>Role Mapping Event</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Mapping Event</em>'.
   * @see org.modelrefactoring.evolution.coed.RoleMappingEvent
   * @generated
   */
	EClass getRoleMappingEvent();

	/**
   * Returns the meta object for the reference '{@link org.modelrefactoring.evolution.coed.RoleMappingEvent#getConcreteRefactoring <em>Concrete Refactoring</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Concrete Refactoring</em>'.
   * @see org.modelrefactoring.evolution.coed.RoleMappingEvent#getConcreteRefactoring()
   * @see #getRoleMappingEvent()
   * @generated
   */
	EReference getRoleMappingEvent_ConcreteRefactoring();

	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.PlainCondition <em>Plain Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plain Condition</em>'.
   * @see org.modelrefactoring.evolution.coed.PlainCondition
   * @generated
   */
	EClass getPlainCondition();

	/**
   * Returns the meta object for the attribute '{@link org.modelrefactoring.evolution.coed.PlainCondition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Condition</em>'.
   * @see org.modelrefactoring.evolution.coed.PlainCondition#getCondition()
   * @see #getPlainCondition()
   * @generated
   */
	EAttribute getPlainCondition_Condition();

	/**
   * Returns the meta object for class '{@link org.modelrefactoring.evolution.coed.RoleMappingAction <em>Role Mapping Action</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Mapping Action</em>'.
   * @see org.modelrefactoring.evolution.coed.RoleMappingAction
   * @generated
   */
	EClass getRoleMappingAction();

	/**
   * Returns the meta object for the reference '{@link org.modelrefactoring.evolution.coed.RoleMappingAction#getConcreteRefactoring <em>Concrete Refactoring</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Concrete Refactoring</em>'.
   * @see org.modelrefactoring.evolution.coed.RoleMappingAction#getConcreteRefactoring()
   * @see #getRoleMappingAction()
   * @generated
   */
	EReference getRoleMappingAction_ConcreteRefactoring();

	/**
   * Returns the meta object for the attribute '{@link org.modelrefactoring.evolution.coed.RoleMappingAction#getBinding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Binding</em>'.
   * @see org.modelrefactoring.evolution.coed.RoleMappingAction#getBinding()
   * @see #getRoleMappingAction()
   * @generated
   */
	EAttribute getRoleMappingAction_Binding();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	CoedFactory getCoedFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl <em>Co Evolution Definition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getCoEvolutionDefinition()
     * @generated
     */
		EClass CO_EVOLUTION_DEFINITION = eINSTANCE.getCoEvolutionDefinition();
		/**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CO_EVOLUTION_DEFINITION__EVENT = eINSTANCE.getCoEvolutionDefinition_Event();
		/**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CO_EVOLUTION_DEFINITION__CONDITION = eINSTANCE.getCoEvolutionDefinition_Condition();
		/**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CO_EVOLUTION_DEFINITION__ACTION = eINSTANCE.getCoEvolutionDefinition_Action();
		/**
     * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CO_EVOLUTION_DEFINITION__METAMODEL = eINSTANCE.getCoEvolutionDefinition_Metamodel();
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.EventImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getEvent()
     * @generated
     */
		EClass EVENT = eINSTANCE.getEvent();
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.ConditionImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getCondition()
     * @generated
     */
		EClass CONDITION = eINSTANCE.getCondition();
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.ActionImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getAction()
     * @generated
     */
		EClass ACTION = eINSTANCE.getAction();
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.RoleMappingEventImpl <em>Role Mapping Event</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.RoleMappingEventImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getRoleMappingEvent()
     * @generated
     */
		EClass ROLE_MAPPING_EVENT = eINSTANCE.getRoleMappingEvent();
		/**
     * The meta object literal for the '<em><b>Concrete Refactoring</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE_MAPPING_EVENT__CONCRETE_REFACTORING = eINSTANCE.getRoleMappingEvent_ConcreteRefactoring();
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.PlainConditionImpl <em>Plain Condition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.PlainConditionImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getPlainCondition()
     * @generated
     */
		EClass PLAIN_CONDITION = eINSTANCE.getPlainCondition();
		/**
     * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute PLAIN_CONDITION__CONDITION = eINSTANCE.getPlainCondition_Condition();
		/**
     * The meta object literal for the '{@link org.modelrefactoring.evolution.coed.impl.RoleMappingActionImpl <em>Role Mapping Action</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.modelrefactoring.evolution.coed.impl.RoleMappingActionImpl
     * @see org.modelrefactoring.evolution.coed.impl.CoedPackageImpl#getRoleMappingAction()
     * @generated
     */
		EClass ROLE_MAPPING_ACTION = eINSTANCE.getRoleMappingAction();
		/**
     * The meta object literal for the '<em><b>Concrete Refactoring</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ROLE_MAPPING_ACTION__CONCRETE_REFACTORING = eINSTANCE.getRoleMappingAction_ConcreteRefactoring();
		/**
     * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ROLE_MAPPING_ACTION__BINDING = eINSTANCE.getRoleMappingAction_Binding();

	}

} //CoedPackage
