/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.refactoring_specification.ContainmentCommand;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.ObjectRemoval;
import org.emftext.language.refactoring.refactoring_specification.REMOVE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.ReferenceCommand;
import org.emftext.language.refactoring.refactoring_specification.RemoveModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>REMOVE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl#getRemoval <em>Removal</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.REMOVEImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class REMOVEImpl extends DeleteCommandImpl implements REMOVE {
	/**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
	protected IndexVariable index;

	/**
   * The cached value of the '{@link #getRemoval() <em>Removal</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRemoval()
   * @generated
   * @ordered
   */
	protected ObjectRemoval removal;

	/**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
	protected RemoveModifier modifier;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected REMOVEImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return RefactoringSpecificationPackage.Literals.REMOVE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexVariable getIndex() {
    if (index != null && index.eIsProxy())
    {
      InternalEObject oldIndex = (InternalEObject)index;
      index = (IndexVariable)eResolveProxy(oldIndex);
      if (index != oldIndex)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.REMOVE__INDEX, oldIndex, index));
      }
    }
    return index;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexVariable basicGetIndex() {
    return index;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setIndex(IndexVariable newIndex) {
    IndexVariable oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REMOVE__INDEX, oldIndex, index));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ObjectRemoval getRemoval() {
    return removal;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetRemoval(ObjectRemoval newRemoval, NotificationChain msgs) {
    ObjectRemoval oldRemoval = removal;
    removal = newRemoval;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REMOVE__REMOVAL, oldRemoval, newRemoval);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setRemoval(ObjectRemoval newRemoval) {
    if (newRemoval != removal)
    {
      NotificationChain msgs = null;
      if (removal != null)
        msgs = ((InternalEObject)removal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.REMOVE__REMOVAL, null, msgs);
      if (newRemoval != null)
        msgs = ((InternalEObject)newRemoval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.REMOVE__REMOVAL, null, msgs);
      msgs = basicSetRemoval(newRemoval, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REMOVE__REMOVAL, newRemoval, newRemoval));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RemoveModifier getModifier() {
    return modifier;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetModifier(RemoveModifier newModifier, NotificationChain msgs) {
    RemoveModifier oldModifier = modifier;
    modifier = newModifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REMOVE__MODIFIER, oldModifier, newModifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setModifier(RemoveModifier newModifier) {
    if (newModifier != modifier)
    {
      NotificationChain msgs = null;
      if (modifier != null)
        msgs = ((InternalEObject)modifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.REMOVE__MODIFIER, null, msgs);
      if (newModifier != null)
        msgs = ((InternalEObject)newModifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.REMOVE__MODIFIER, null, msgs);
      msgs = basicSetModifier(newModifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REMOVE__MODIFIER, newModifier, newModifier));
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
      case RefactoringSpecificationPackage.REMOVE__REMOVAL:
        return basicSetRemoval(null, msgs);
      case RefactoringSpecificationPackage.REMOVE__MODIFIER:
        return basicSetModifier(null, msgs);
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
      case RefactoringSpecificationPackage.REMOVE__INDEX:
        if (resolve) return getIndex();
        return basicGetIndex();
      case RefactoringSpecificationPackage.REMOVE__REMOVAL:
        return getRemoval();
      case RefactoringSpecificationPackage.REMOVE__MODIFIER:
        return getModifier();
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
      case RefactoringSpecificationPackage.REMOVE__INDEX:
        setIndex((IndexVariable)newValue);
        return;
      case RefactoringSpecificationPackage.REMOVE__REMOVAL:
        setRemoval((ObjectRemoval)newValue);
        return;
      case RefactoringSpecificationPackage.REMOVE__MODIFIER:
        setModifier((RemoveModifier)newValue);
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
      case RefactoringSpecificationPackage.REMOVE__INDEX:
        setIndex((IndexVariable)null);
        return;
      case RefactoringSpecificationPackage.REMOVE__REMOVAL:
        setRemoval((ObjectRemoval)null);
        return;
      case RefactoringSpecificationPackage.REMOVE__MODIFIER:
        setModifier((RemoveModifier)null);
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
      case RefactoringSpecificationPackage.REMOVE__INDEX:
        return index != null;
      case RefactoringSpecificationPackage.REMOVE__REMOVAL:
        return removal != null;
      case RefactoringSpecificationPackage.REMOVE__MODIFIER:
        return modifier != null;
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == ReferenceCommand.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ContainmentCommand.class)
    {
      switch (derivedFeatureID)
      {
        case RefactoringSpecificationPackage.REMOVE__INDEX: return RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == ReferenceCommand.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ContainmentCommand.class)
    {
      switch (baseFeatureID)
      {
        case RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX: return RefactoringSpecificationPackage.REMOVE__INDEX;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //REMOVEImpl
