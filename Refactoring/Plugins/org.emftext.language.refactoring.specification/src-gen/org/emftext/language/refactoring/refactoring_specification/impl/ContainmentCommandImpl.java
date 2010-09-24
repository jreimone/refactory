/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.refactoring.refactoring_specification.ContainmentCommand;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.ContainmentCommandImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContainmentCommandImpl extends InstructionImpl implements ContainmentCommand
{
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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ContainmentCommandImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return RefactoringSpecificationPackage.Literals.CONTAINMENT_COMMAND;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IndexVariable getIndex()
  {
		if (index != null && index.eIsProxy()) {
			InternalEObject oldIndex = (InternalEObject)index;
			index = (IndexVariable)eResolveProxy(oldIndex);
			if (index != oldIndex) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX, oldIndex, index));
			}
		}
		return index;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IndexVariable basicGetIndex()
  {
		return index;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIndex(IndexVariable newIndex)
  {
		IndexVariable oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX, oldIndex, index));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX:
				if (resolve) return getIndex();
				return basicGetIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX:
				setIndex((IndexVariable)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX:
				setIndex((IndexVariable)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.CONTAINMENT_COMMAND__INDEX:
				return index != null;
		}
		return super.eIsSet(featureID);
	}

} //ContainmentCommandImpl
