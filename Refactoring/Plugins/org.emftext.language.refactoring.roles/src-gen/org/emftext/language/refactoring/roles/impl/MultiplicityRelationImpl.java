/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.roles.Multiplicity;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl#getSourceMultiplicity <em>Source Multiplicity</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl#getTargetMultiplicity <em>Target Multiplicity</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl#getSourceName <em>Source Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.impl.MultiplicityRelationImpl#getTargetName <em>Target Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MultiplicityRelationImpl extends RelationImpl implements MultiplicityRelation {
	/**
   * The cached value of the '{@link #getSourceMultiplicity() <em>Source Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSourceMultiplicity()
   * @generated
   * @ordered
   */
	protected Multiplicity sourceMultiplicity;

	/**
   * The cached value of the '{@link #getTargetMultiplicity() <em>Target Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTargetMultiplicity()
   * @generated
   * @ordered
   */
	protected Multiplicity targetMultiplicity;

	/**
   * The default value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSourceName()
   * @generated
   * @ordered
   */
	protected static final String SOURCE_NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSourceName()
   * @generated
   * @ordered
   */
	protected String sourceName = SOURCE_NAME_EDEFAULT;

	/**
   * The default value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTargetName()
   * @generated
   * @ordered
   */
	protected static final String TARGET_NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTargetName()
   * @generated
   * @ordered
   */
	protected String targetName = TARGET_NAME_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MultiplicityRelationImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RolesPackage.Literals.MULTIPLICITY_RELATION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Multiplicity getSourceMultiplicity() {
    return sourceMultiplicity;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetSourceMultiplicity(Multiplicity newSourceMultiplicity, NotificationChain msgs) {
    Multiplicity oldSourceMultiplicity = sourceMultiplicity;
    sourceMultiplicity = newSourceMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY, oldSourceMultiplicity, newSourceMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setSourceMultiplicity(Multiplicity newSourceMultiplicity) {
    if (newSourceMultiplicity != sourceMultiplicity)
    {
      NotificationChain msgs = null;
      if (sourceMultiplicity != null)
        msgs = ((InternalEObject)sourceMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY, null, msgs);
      if (newSourceMultiplicity != null)
        msgs = ((InternalEObject)newSourceMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY, null, msgs);
      msgs = basicSetSourceMultiplicity(newSourceMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY, newSourceMultiplicity, newSourceMultiplicity));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Multiplicity getTargetMultiplicity() {
    return targetMultiplicity;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetTargetMultiplicity(Multiplicity newTargetMultiplicity, NotificationChain msgs) {
    Multiplicity oldTargetMultiplicity = targetMultiplicity;
    targetMultiplicity = newTargetMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY, oldTargetMultiplicity, newTargetMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setTargetMultiplicity(Multiplicity newTargetMultiplicity) {
    if (newTargetMultiplicity != targetMultiplicity)
    {
      NotificationChain msgs = null;
      if (targetMultiplicity != null)
        msgs = ((InternalEObject)targetMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY, null, msgs);
      if (newTargetMultiplicity != null)
        msgs = ((InternalEObject)newTargetMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY, null, msgs);
      msgs = basicSetTargetMultiplicity(newTargetMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY, newTargetMultiplicity, newTargetMultiplicity));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getSourceName() {
    return sourceName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setSourceName(String newSourceName) {
    String oldSourceName = sourceName;
    sourceName = newSourceName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY_RELATION__SOURCE_NAME, oldSourceName, sourceName));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getTargetName() {
    return targetName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setTargetName(String newTargetName) {
    String oldTargetName = targetName;
    targetName = newTargetName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.MULTIPLICITY_RELATION__TARGET_NAME, oldTargetName, targetName));
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
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY:
        return basicSetSourceMultiplicity(null, msgs);
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY:
        return basicSetTargetMultiplicity(null, msgs);
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
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY:
        return getSourceMultiplicity();
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY:
        return getTargetMultiplicity();
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_NAME:
        return getSourceName();
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_NAME:
        return getTargetName();
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
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY:
        setSourceMultiplicity((Multiplicity)newValue);
        return;
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY:
        setTargetMultiplicity((Multiplicity)newValue);
        return;
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_NAME:
        setSourceName((String)newValue);
        return;
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_NAME:
        setTargetName((String)newValue);
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
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY:
        setSourceMultiplicity((Multiplicity)null);
        return;
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY:
        setTargetMultiplicity((Multiplicity)null);
        return;
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_NAME:
        setSourceName(SOURCE_NAME_EDEFAULT);
        return;
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_NAME:
        setTargetName(TARGET_NAME_EDEFAULT);
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
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_MULTIPLICITY:
        return sourceMultiplicity != null;
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_MULTIPLICITY:
        return targetMultiplicity != null;
      case RolesPackage.MULTIPLICITY_RELATION__SOURCE_NAME:
        return SOURCE_NAME_EDEFAULT == null ? sourceName != null : !SOURCE_NAME_EDEFAULT.equals(sourceName);
      case RolesPackage.MULTIPLICITY_RELATION__TARGET_NAME:
        return TARGET_NAME_EDEFAULT == null ? targetName != null : !TARGET_NAME_EDEFAULT.equals(targetName);
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (sourceName: ");
    result.append(sourceName);
    result.append(", targetName: ");
    result.append(targetName);
    result.append(')');
    return result.toString();
  }

} //MultiplicityRelationImpl
