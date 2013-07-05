/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.megamodel.cods.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.qualitune.evolution.megamodel.architecture.MetaModel;

import org.qualitune.evolution.megamodel.cods.CoEvolutionDefinition;
import org.qualitune.evolution.megamodel.cods.CodsPackage;
import org.qualitune.evolution.megamodel.cods.DomainSpecificEvolutionSpecification;
import org.qualitune.evolution.megamodel.cods.EvolutionDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Specific Evolution Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl#getED <em>ED</em>}</li>
 *   <li>{@link org.qualitune.evolution.megamodel.cods.impl.DomainSpecificEvolutionSpecificationImpl#getCoED <em>Co ED</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificEvolutionSpecificationImpl extends EObjectImpl implements DomainSpecificEvolutionSpecification {
	/**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
	protected MetaModel metamodel;

	/**
   * The cached value of the '{@link #getED() <em>ED</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getED()
   * @generated
   * @ordered
   */
	protected EvolutionDefinition ed;

	/**
   * The cached value of the '{@link #getCoED() <em>Co ED</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCoED()
   * @generated
   * @ordered
   */
	protected CoEvolutionDefinition coED;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DomainSpecificEvolutionSpecificationImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return CodsPackage.Literals.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MetaModel getMetamodel() {
    if (metamodel != null && metamodel.eIsProxy())
    {
      InternalEObject oldMetamodel = (InternalEObject)metamodel;
      metamodel = (MetaModel)eResolveProxy(oldMetamodel);
      if (metamodel != oldMetamodel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL, oldMetamodel, metamodel));
      }
    }
    return metamodel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MetaModel basicGetMetamodel() {
    return metamodel;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setMetamodel(MetaModel newMetamodel) {
    MetaModel oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL, oldMetamodel, metamodel));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EvolutionDefinition getED() {
    return ed;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetED(EvolutionDefinition newED, NotificationChain msgs) {
    EvolutionDefinition oldED = ed;
    ed = newED;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, oldED, newED);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setED(EvolutionDefinition newED) {
    if (newED != ed)
    {
      NotificationChain msgs = null;
      if (ed != null)
        msgs = ((InternalEObject)ed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, null, msgs);
      if (newED != null)
        msgs = ((InternalEObject)newED).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, null, msgs);
      msgs = basicSetED(newED, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED, newED, newED));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CoEvolutionDefinition getCoED() {
    return coED;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetCoED(CoEvolutionDefinition newCoED, NotificationChain msgs) {
    CoEvolutionDefinition oldCoED = coED;
    coED = newCoED;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED, oldCoED, newCoED);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setCoED(CoEvolutionDefinition newCoED) {
    if (newCoED != coED)
    {
      NotificationChain msgs = null;
      if (coED != null)
        msgs = ((InternalEObject)coED).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED, null, msgs);
      if (newCoED != null)
        msgs = ((InternalEObject)newCoED).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED, null, msgs);
      msgs = basicSetCoED(newCoED, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED, newCoED, newCoED));
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
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
        return basicSetED(null, msgs);
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED:
        return basicSetCoED(null, msgs);
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
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL:
        if (resolve) return getMetamodel();
        return basicGetMetamodel();
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
        return getED();
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED:
        return getCoED();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL:
        setMetamodel((MetaModel)newValue);
        return;
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
        setED((EvolutionDefinition)newValue);
        return;
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED:
        setCoED((CoEvolutionDefinition)newValue);
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
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL:
        setMetamodel((MetaModel)null);
        return;
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
        setED((EvolutionDefinition)null);
        return;
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED:
        setCoED((CoEvolutionDefinition)null);
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
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__METAMODEL:
        return metamodel != null;
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__ED:
        return ed != null;
      case CodsPackage.DOMAIN_SPECIFIC_EVOLUTION_SPECIFICATION__CO_ED:
        return coED != null;
    }
    return super.eIsSet(featureID);
  }

} //DomainSpecificEvolutionSpecificationImpl
