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

import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CREATE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl#getSourceRole <em>Source Role</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl#getTargetContext <em>Target Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CREATEImpl extends ContainmentCommandImpl implements CREATE
{
  /**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
  protected Variable variable;

  /**
	 * The cached value of the '{@link #getSourceRole() <em>Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSourceRole()
	 * @generated
	 * @ordered
	 */
  protected Role sourceRole;

  /**
	 * The cached value of the '{@link #getTargetContext() <em>Target Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTargetContext()
	 * @generated
	 * @ordered
	 */
  protected TargetContext targetContext;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CREATEImpl()
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
		return RefactoringSpecificationPackage.Literals.CREATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Variable getVariable()
  {
		return variable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetVariable(Variable newVariable, NotificationChain msgs)
  {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setVariable(Variable newVariable)
  {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, RefactoringSpecificationPackage.VARIABLE__CONTAINER_COMMAND, Variable.class, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, RefactoringSpecificationPackage.VARIABLE__CONTAINER_COMMAND, Variable.class, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__VARIABLE, newVariable, newVariable));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Role getSourceRole()
  {
		if (sourceRole != null && sourceRole.eIsProxy()) {
			InternalEObject oldSourceRole = (InternalEObject)sourceRole;
			sourceRole = (Role)eResolveProxy(oldSourceRole);
			if (sourceRole != oldSourceRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.CREATE__SOURCE_ROLE, oldSourceRole, sourceRole));
			}
		}
		return sourceRole;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Role basicGetSourceRole()
  {
		return sourceRole;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSourceRole(Role newSourceRole)
  {
		Role oldSourceRole = sourceRole;
		sourceRole = newSourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__SOURCE_ROLE, oldSourceRole, sourceRole));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TargetContext getTargetContext()
  {
		return targetContext;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTargetContext(TargetContext newTargetContext, NotificationChain msgs)
  {
		TargetContext oldTargetContext = targetContext;
		targetContext = newTargetContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT, oldTargetContext, newTargetContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTargetContext(TargetContext newTargetContext)
  {
		if (newTargetContext != targetContext) {
			NotificationChain msgs = null;
			if (targetContext != null)
				msgs = ((InternalEObject)targetContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT, null, msgs);
			if (newTargetContext != null)
				msgs = ((InternalEObject)newTargetContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT, null, msgs);
			msgs = basicSetTargetContext(newTargetContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT, newTargetContext, newTargetContext));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case RefactoringSpecificationPackage.CREATE__VARIABLE:
				if (variable != null)
					msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__VARIABLE, null, msgs);
				return basicSetVariable((Variable)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case RefactoringSpecificationPackage.CREATE__VARIABLE:
				return basicSetVariable(null, msgs);
			case RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT:
				return basicSetTargetContext(null, msgs);
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
			case RefactoringSpecificationPackage.CREATE__VARIABLE:
				return getVariable();
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE:
				if (resolve) return getSourceRole();
				return basicGetSourceRole();
			case RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT:
				return getTargetContext();
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
			case RefactoringSpecificationPackage.CREATE__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE:
				setSourceRole((Role)newValue);
				return;
			case RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT:
				setTargetContext((TargetContext)newValue);
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
			case RefactoringSpecificationPackage.CREATE__VARIABLE:
				setVariable((Variable)null);
				return;
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE:
				setSourceRole((Role)null);
				return;
			case RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT:
				setTargetContext((TargetContext)null);
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
			case RefactoringSpecificationPackage.CREATE__VARIABLE:
				return variable != null;
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE:
				return sourceRole != null;
			case RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT:
				return targetContext != null;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
		if (baseClass == VariableDeclarationCommand.class) {
			switch (derivedFeatureID) {
				case RefactoringSpecificationPackage.CREATE__VARIABLE: return RefactoringSpecificationPackage.VARIABLE_DECLARATION_COMMAND__VARIABLE;
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
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
		if (baseClass == VariableDeclarationCommand.class) {
			switch (baseFeatureID) {
				case RefactoringSpecificationPackage.VARIABLE_DECLARATION_COMMAND__VARIABLE: return RefactoringSpecificationPackage.CREATE__VARIABLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CREATEImpl
