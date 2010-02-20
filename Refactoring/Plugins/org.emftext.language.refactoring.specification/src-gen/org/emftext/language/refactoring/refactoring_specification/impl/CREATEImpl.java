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
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.refactoring_specification.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CREATE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl#getSourceRoleReference <em>Source Role Reference</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.CREATEImpl#getTargetContext <em>Target Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CREATEImpl extends PrimitiveCommandImpl implements CREATE {
	/**
	 * The cached value of the '{@link #getVarDeclaration() <em>Var Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclaration()
	 * @generated
	 * @ordered
	 */
	protected Variable varDeclaration;

	/**
	 * The cached value of the '{@link #getSourceRoleReference() <em>Source Role Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRoleReference()
	 * @generated
	 * @ordered
	 */
	protected RoleReference sourceRoleReference;

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
	protected CREATEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringSpecificationPackage.Literals.CREATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVarDeclaration() {
		return varDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVarDeclaration(Variable newVarDeclaration, NotificationChain msgs) {
		Variable oldVarDeclaration = varDeclaration;
		varDeclaration = newVarDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__VAR_DECLARATION, oldVarDeclaration, newVarDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarDeclaration(Variable newVarDeclaration) {
		if (newVarDeclaration != varDeclaration) {
			NotificationChain msgs = null;
			if (varDeclaration != null)
				msgs = ((InternalEObject)varDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__VAR_DECLARATION, null, msgs);
			if (newVarDeclaration != null)
				msgs = ((InternalEObject)newVarDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__VAR_DECLARATION, null, msgs);
			msgs = basicSetVarDeclaration(newVarDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__VAR_DECLARATION, newVarDeclaration, newVarDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleReference getSourceRoleReference() {
		return sourceRoleReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceRoleReference(RoleReference newSourceRoleReference, NotificationChain msgs) {
		RoleReference oldSourceRoleReference = sourceRoleReference;
		sourceRoleReference = newSourceRoleReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE, oldSourceRoleReference, newSourceRoleReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRoleReference(RoleReference newSourceRoleReference) {
		if (newSourceRoleReference != sourceRoleReference) {
			NotificationChain msgs = null;
			if (sourceRoleReference != null)
				msgs = ((InternalEObject)sourceRoleReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE, null, msgs);
			if (newSourceRoleReference != null)
				msgs = ((InternalEObject)newSourceRoleReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE, null, msgs);
			msgs = basicSetSourceRoleReference(newSourceRoleReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE, newSourceRoleReference, newSourceRoleReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetContext getTargetContext() {
		return targetContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetContext(TargetContext newTargetContext, NotificationChain msgs) {
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
	public void setTargetContext(TargetContext newTargetContext) {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringSpecificationPackage.CREATE__VAR_DECLARATION:
				return basicSetVarDeclaration(null, msgs);
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE:
				return basicSetSourceRoleReference(null, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RefactoringSpecificationPackage.CREATE__VAR_DECLARATION:
				return getVarDeclaration();
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE:
				return getSourceRoleReference();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RefactoringSpecificationPackage.CREATE__VAR_DECLARATION:
				setVarDeclaration((Variable)newValue);
				return;
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE:
				setSourceRoleReference((RoleReference)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case RefactoringSpecificationPackage.CREATE__VAR_DECLARATION:
				setVarDeclaration((Variable)null);
				return;
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE:
				setSourceRoleReference((RoleReference)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RefactoringSpecificationPackage.CREATE__VAR_DECLARATION:
				return varDeclaration != null;
			case RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE:
				return sourceRoleReference != null;
			case RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT:
				return targetContext != null;
		}
		return super.eIsSet(featureID);
	}

} //CREATEImpl
