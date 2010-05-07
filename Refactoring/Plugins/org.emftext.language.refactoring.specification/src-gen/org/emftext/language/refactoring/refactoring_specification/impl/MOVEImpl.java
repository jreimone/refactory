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

import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.Modifier;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MOVE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.MOVEImpl#getMoveModifier <em>Move Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MOVEImpl extends ContainmentCommandImpl implements MOVE
{
  /**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
  protected SourceContext source;

  /**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
  protected TargetContext target;

  /**
	 * The cached value of the '{@link #getMoveModifier() <em>Move Modifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMoveModifier()
	 * @generated
	 * @ordered
	 */
  protected Modifier moveModifier;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected MOVEImpl()
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
		return RefactoringSpecificationPackage.Literals.MOVE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SourceContext getSource()
  {
		return source;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSource(SourceContext newSource, NotificationChain msgs)
  {
		SourceContext oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.MOVE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSource(SourceContext newSource)
  {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.MOVE__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.MOVE__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.MOVE__SOURCE, newSource, newSource));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TargetContext getTarget()
  {
		return target;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTarget(TargetContext newTarget, NotificationChain msgs)
  {
		TargetContext oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.MOVE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTarget(TargetContext newTarget)
  {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.MOVE__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.MOVE__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.MOVE__TARGET, newTarget, newTarget));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Modifier getMoveModifier()
  {
		return moveModifier;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetMoveModifier(Modifier newMoveModifier, NotificationChain msgs)
  {
		Modifier oldMoveModifier = moveModifier;
		moveModifier = newMoveModifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER, oldMoveModifier, newMoveModifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMoveModifier(Modifier newMoveModifier)
  {
		if (newMoveModifier != moveModifier) {
			NotificationChain msgs = null;
			if (moveModifier != null)
				msgs = ((InternalEObject)moveModifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER, null, msgs);
			if (newMoveModifier != null)
				msgs = ((InternalEObject)newMoveModifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER, null, msgs);
			msgs = basicSetMoveModifier(newMoveModifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER, newMoveModifier, newMoveModifier));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.MOVE__SOURCE:
				return basicSetSource(null, msgs);
			case RefactoringSpecificationPackage.MOVE__TARGET:
				return basicSetTarget(null, msgs);
			case RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER:
				return basicSetMoveModifier(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case RefactoringSpecificationPackage.MOVE__SOURCE:
				return getSource();
			case RefactoringSpecificationPackage.MOVE__TARGET:
				return getTarget();
			case RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER:
				return getMoveModifier();
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
			case RefactoringSpecificationPackage.MOVE__SOURCE:
				setSource((SourceContext)newValue);
				return;
			case RefactoringSpecificationPackage.MOVE__TARGET:
				setTarget((TargetContext)newValue);
				return;
			case RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER:
				setMoveModifier((Modifier)newValue);
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
			case RefactoringSpecificationPackage.MOVE__SOURCE:
				setSource((SourceContext)null);
				return;
			case RefactoringSpecificationPackage.MOVE__TARGET:
				setTarget((TargetContext)null);
				return;
			case RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER:
				setMoveModifier((Modifier)null);
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
			case RefactoringSpecificationPackage.MOVE__SOURCE:
				return source != null;
			case RefactoringSpecificationPackage.MOVE__TARGET:
				return target != null;
			case RefactoringSpecificationPackage.MOVE__MOVE_MODIFIER:
				return moveModifier != null;
		}
		return super.eIsSet(featureID);
	}

} //MOVEImpl
