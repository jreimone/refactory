/**
 */
package roles.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import roles.Collaboration;
import roles.CollaborationModifier;
import roles.Role;
import roles.RolesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link roles.impl.CollaborationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link roles.impl.CollaborationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link roles.impl.CollaborationImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link roles.impl.CollaborationImpl#getInterpretationContext <em>Interpretation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CollaborationImpl extends RoleFeatureImpl implements Collaboration {
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
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<CollaborationModifier> modifier;

	/**
	 * The cached value of the '{@link #getInterpretationContext() <em>Interpretation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretationContext()
	 * @generated
	 * @ordered
	 */
	protected EObject interpretationContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.COLLABORATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolesPackage.COLLABORATION__SOURCE, oldSource, source));
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
	public NotificationChain basicSetSource(Role newSource, NotificationChain msgs) {
		Role oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RolesPackage.COLLABORATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Role newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, RolesPackage.ROLE__OUTGOING, Role.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, RolesPackage.ROLE__OUTGOING, Role.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.COLLABORATION__SOURCE, newSource, newSource));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolesPackage.COLLABORATION__TARGET, oldTarget, target));
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
	public NotificationChain basicSetTarget(Role newTarget, NotificationChain msgs) {
		Role oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RolesPackage.COLLABORATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Role newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, RolesPackage.ROLE__INCOMING, Role.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, RolesPackage.ROLE__INCOMING, Role.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.COLLABORATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollaborationModifier> getModifier() {
		if (modifier == null) {
			modifier = new EDataTypeEList<CollaborationModifier>(CollaborationModifier.class, this, RolesPackage.COLLABORATION__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getInterpretationContext() {
		if (interpretationContext != null && interpretationContext.eIsProxy()) {
			InternalEObject oldInterpretationContext = (InternalEObject)interpretationContext;
			interpretationContext = eResolveProxy(oldInterpretationContext);
			if (interpretationContext != oldInterpretationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolesPackage.COLLABORATION__INTERPRETATION_CONTEXT, oldInterpretationContext, interpretationContext));
			}
		}
		return interpretationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetInterpretationContext() {
		return interpretationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpretationContext(EObject newInterpretationContext) {
		EObject oldInterpretationContext = interpretationContext;
		interpretationContext = newInterpretationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolesPackage.COLLABORATION__INTERPRETATION_CONTEXT, oldInterpretationContext, interpretationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RolesPackage.COLLABORATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, RolesPackage.ROLE__OUTGOING, Role.class, msgs);
				return basicSetSource((Role)otherEnd, msgs);
			case RolesPackage.COLLABORATION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, RolesPackage.ROLE__INCOMING, Role.class, msgs);
				return basicSetTarget((Role)otherEnd, msgs);
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
		switch (featureID) {
			case RolesPackage.COLLABORATION__SOURCE:
				return basicSetSource(null, msgs);
			case RolesPackage.COLLABORATION__TARGET:
				return basicSetTarget(null, msgs);
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
			case RolesPackage.COLLABORATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case RolesPackage.COLLABORATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case RolesPackage.COLLABORATION__MODIFIER:
				return getModifier();
			case RolesPackage.COLLABORATION__INTERPRETATION_CONTEXT:
				if (resolve) return getInterpretationContext();
				return basicGetInterpretationContext();
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
		switch (featureID) {
			case RolesPackage.COLLABORATION__SOURCE:
				setSource((Role)newValue);
				return;
			case RolesPackage.COLLABORATION__TARGET:
				setTarget((Role)newValue);
				return;
			case RolesPackage.COLLABORATION__MODIFIER:
				getModifier().clear();
				getModifier().addAll((Collection<? extends CollaborationModifier>)newValue);
				return;
			case RolesPackage.COLLABORATION__INTERPRETATION_CONTEXT:
				setInterpretationContext((EObject)newValue);
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
			case RolesPackage.COLLABORATION__SOURCE:
				setSource((Role)null);
				return;
			case RolesPackage.COLLABORATION__TARGET:
				setTarget((Role)null);
				return;
			case RolesPackage.COLLABORATION__MODIFIER:
				getModifier().clear();
				return;
			case RolesPackage.COLLABORATION__INTERPRETATION_CONTEXT:
				setInterpretationContext((EObject)null);
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
			case RolesPackage.COLLABORATION__SOURCE:
				return source != null;
			case RolesPackage.COLLABORATION__TARGET:
				return target != null;
			case RolesPackage.COLLABORATION__MODIFIER:
				return modifier != null && !modifier.isEmpty();
			case RolesPackage.COLLABORATION__INTERPRETATION_CONTEXT:
				return interpretationContext != null;
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
		result.append(" (modifier: ");
		result.append(modifier);
		result.append(')');
		return result.toString();
	}

} //CollaborationImpl
