/**
 */
package org.emftext.language.refactoring.refactoringcomposition.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Target Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl#getSourceRoleModel <em>Source Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.impl.SourceTargetBindingImpl#getTargetRoleModel <em>Target Role Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceTargetBindingImpl extends MinimalEObjectImpl.Container implements SourceTargetBinding {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Role source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Role target;

	/**
	 * The cached value of the '{@link #getSourceRoleModel() <em>Source Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRoleModel()
	 * @generated
	 * @ordered
	 */
	protected RoleModel sourceRoleModel;

	/**
	 * The cached value of the '{@link #getTargetRoleModel() <em>Target Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRoleModel()
	 * @generated
	 * @ordered
	 */
	protected RoleModel targetRoleModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceTargetBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringcompositionPackage.Literals.SOURCE_TARGET_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Role)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Role newSource) {
		Role oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Role)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Role newTarget) {
		Role oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel getSourceRoleModel() {
		if (sourceRoleModel != null && sourceRoleModel.eIsProxy()) {
			InternalEObject oldSourceRoleModel = (InternalEObject)sourceRoleModel;
			sourceRoleModel = (RoleModel)eResolveProxy(oldSourceRoleModel);
			if (sourceRoleModel != oldSourceRoleModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL, oldSourceRoleModel, sourceRoleModel));
			}
		}
		return sourceRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel basicGetSourceRoleModel() {
		return sourceRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRoleModel(RoleModel newSourceRoleModel) {
		RoleModel oldSourceRoleModel = sourceRoleModel;
		sourceRoleModel = newSourceRoleModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL, oldSourceRoleModel, sourceRoleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel getTargetRoleModel() {
		if (targetRoleModel != null && targetRoleModel.eIsProxy()) {
			InternalEObject oldTargetRoleModel = (InternalEObject)targetRoleModel;
			targetRoleModel = (RoleModel)eResolveProxy(oldTargetRoleModel);
			if (targetRoleModel != oldTargetRoleModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL, oldTargetRoleModel, targetRoleModel));
			}
		}
		return targetRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel basicGetTargetRoleModel() {
		return targetRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRoleModel(RoleModel newTargetRoleModel) {
		RoleModel oldTargetRoleModel = targetRoleModel;
		targetRoleModel = newTargetRoleModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL, oldTargetRoleModel, targetRoleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL:
				if (resolve) return getSourceRoleModel();
				return basicGetSourceRoleModel();
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL:
				if (resolve) return getTargetRoleModel();
				return basicGetTargetRoleModel();
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
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE:
				setSource((Role)newValue);
				return;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET:
				setTarget((Role)newValue);
				return;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL:
				setSourceRoleModel((RoleModel)newValue);
				return;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL:
				setTargetRoleModel((RoleModel)newValue);
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
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE:
				setSource((Role)null);
				return;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET:
				setTarget((Role)null);
				return;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL:
				setSourceRoleModel((RoleModel)null);
				return;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL:
				setTargetRoleModel((RoleModel)null);
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
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE:
				return source != null;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET:
				return target != null;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL:
				return sourceRoleModel != null;
			case RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL:
				return targetRoleModel != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceTargetBindingImpl
