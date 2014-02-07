/**
 */
package org.modelrefactoring.evolution.coed.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.modelrefactoring.evolution.coed.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelrefactoring.evolution.coed.CoedPackage
 * @generated
 */
public class CoedAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static CoedPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CoedAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = CoedPackage.eINSTANCE;
    }
  }

	/**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object object) {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

	/**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected CoedSwitch<Adapter> modelSwitch =
		new CoedSwitch<Adapter>()
    {
      @Override
      public Adapter caseCoEvolutionDefinition(CoEvolutionDefinition object)
      {
        return createCoEvolutionDefinitionAdapter();
      }
      @Override
      public Adapter caseEvent(Event object)
      {
        return createEventAdapter();
      }
      @Override
      public Adapter caseCondition(Condition object)
      {
        return createConditionAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseRoleMappingEvent(RoleMappingEvent object)
      {
        return createRoleMappingEventAdapter();
      }
      @Override
      public Adapter casePlainCondition(PlainCondition object)
      {
        return createPlainConditionAdapter();
      }
      @Override
      public Adapter caseRoleMappingAction(RoleMappingAction object)
      {
        return createRoleMappingActionAdapter();
      }
      @Override
      public Adapter caseMetamodelImport(MetamodelImport object)
      {
        return createMetamodelImportAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

	/**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
	@Override
	public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.CoEvolutionDefinition <em>Co Evolution Definition</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.CoEvolutionDefinition
   * @generated
   */
	public Adapter createCoEvolutionDefinitionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.Event
   * @generated
   */
	public Adapter createEventAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.Condition
   * @generated
   */
	public Adapter createConditionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.Action
   * @generated
   */
	public Adapter createActionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.RoleMappingEvent <em>Role Mapping Event</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.RoleMappingEvent
   * @generated
   */
	public Adapter createRoleMappingEventAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.PlainCondition <em>Plain Condition</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.PlainCondition
   * @generated
   */
	public Adapter createPlainConditionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.RoleMappingAction <em>Role Mapping Action</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.RoleMappingAction
   * @generated
   */
	public Adapter createRoleMappingActionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.modelrefactoring.evolution.coed.MetamodelImport <em>Metamodel Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelrefactoring.evolution.coed.MetamodelImport
   * @generated
   */
  public Adapter createMetamodelImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
	public Adapter createEObjectAdapter() {
    return null;
  }

} //CoedAdapterFactory
