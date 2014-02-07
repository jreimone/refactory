/**
 */
package org.modelrefactoring.evolution.coed.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.CoedPackage;
import org.modelrefactoring.evolution.coed.Condition;
import org.modelrefactoring.evolution.coed.Event;
import org.modelrefactoring.evolution.coed.MetamodelImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Co Evolution Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.modelrefactoring.evolution.coed.impl.CoEvolutionDefinitionImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoEvolutionDefinitionImpl extends MinimalEObjectImpl.Container implements CoEvolutionDefinition {
	/**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
	protected Event event;
	/**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
	protected Condition condition;
	/**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
	protected Action action;
	/**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
	protected EPackage metamodel;

	/**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<MetamodelImport> imports;

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected CoEvolutionDefinitionImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return CoedPackage.Literals.CO_EVOLUTION_DEFINITION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Event getEvent() {
    return event;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetEvent(Event newEvent, NotificationChain msgs) {
    Event oldEvent = event;
    event = newEvent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__EVENT, oldEvent, newEvent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setEvent(Event newEvent) {
    if (newEvent != event)
    {
      NotificationChain msgs = null;
      if (event != null)
        msgs = ((InternalEObject)event).eInverseRemove(this, CoedPackage.EVENT__CO_ED, Event.class, msgs);
      if (newEvent != null)
        msgs = ((InternalEObject)newEvent).eInverseAdd(this, CoedPackage.EVENT__CO_ED, Event.class, msgs);
      msgs = basicSetEvent(newEvent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__EVENT, newEvent, newEvent));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Condition getCondition() {
    return condition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetCondition(Condition newCondition, NotificationChain msgs) {
    Condition oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setCondition(Condition newCondition) {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, CoedPackage.CONDITION__CO_ED, Condition.class, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, CoedPackage.CONDITION__CO_ED, Condition.class, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION, newCondition, newCondition));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Action getAction() {
    return action;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetAction(Action newAction, NotificationChain msgs) {
    Action oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAction(Action newAction) {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, CoedPackage.ACTION__CO_ED, Action.class, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, CoedPackage.ACTION__CO_ED, Action.class, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__ACTION, newAction, newAction));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EPackage getMetamodel() {
    if (metamodel != null && metamodel.eIsProxy())
    {
      InternalEObject oldMetamodel = (InternalEObject)metamodel;
      metamodel = (EPackage)eResolveProxy(oldMetamodel);
      if (metamodel != oldMetamodel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL, oldMetamodel, metamodel));
      }
    }
    return metamodel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EPackage basicGetMetamodel() {
    return metamodel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setMetamodel(EPackage newMetamodel) {
    EPackage oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL, oldMetamodel, metamodel));
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MetamodelImport> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<MetamodelImport>(MetamodelImport.class, this, CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CoedPackage.CO_EVOLUTION_DEFINITION__EVENT:
        if (event != null)
          msgs = ((InternalEObject)event).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoedPackage.CO_EVOLUTION_DEFINITION__EVENT, null, msgs);
        return basicSetEvent((Event)otherEnd, msgs);
      case CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION:
        if (condition != null)
          msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION, null, msgs);
        return basicSetCondition((Condition)otherEnd, msgs);
      case CoedPackage.CO_EVOLUTION_DEFINITION__ACTION:
        if (action != null)
          msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoedPackage.CO_EVOLUTION_DEFINITION__ACTION, null, msgs);
        return basicSetAction((Action)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case CoedPackage.CO_EVOLUTION_DEFINITION__EVENT:
        return basicSetEvent(null, msgs);
      case CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION:
        return basicSetCondition(null, msgs);
      case CoedPackage.CO_EVOLUTION_DEFINITION__ACTION:
        return basicSetAction(null, msgs);
      case CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case CoedPackage.CO_EVOLUTION_DEFINITION__EVENT:
        return getEvent();
      case CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION:
        return getCondition();
      case CoedPackage.CO_EVOLUTION_DEFINITION__ACTION:
        return getAction();
      case CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL:
        if (resolve) return getMetamodel();
        return basicGetMetamodel();
      case CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS:
        return getImports();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
  @Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case CoedPackage.CO_EVOLUTION_DEFINITION__EVENT:
        setEvent((Event)newValue);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION:
        setCondition((Condition)newValue);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__ACTION:
        setAction((Action)newValue);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL:
        setMetamodel((EPackage)newValue);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends MetamodelImport>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case CoedPackage.CO_EVOLUTION_DEFINITION__EVENT:
        setEvent((Event)null);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION:
        setCondition((Condition)null);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__ACTION:
        setAction((Action)null);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL:
        setMetamodel((EPackage)null);
        return;
      case CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS:
        getImports().clear();
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case CoedPackage.CO_EVOLUTION_DEFINITION__EVENT:
        return event != null;
      case CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION:
        return condition != null;
      case CoedPackage.CO_EVOLUTION_DEFINITION__ACTION:
        return action != null;
      case CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL:
        return metamodel != null;
      case CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS:
        return imports != null && !imports.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CoEvolutionDefinitionImpl
