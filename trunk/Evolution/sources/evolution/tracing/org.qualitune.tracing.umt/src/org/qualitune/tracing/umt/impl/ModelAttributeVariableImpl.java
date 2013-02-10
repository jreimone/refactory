/**
 */
package org.qualitune.tracing.umt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.qualitune.tracing.umt.ModelAttributeVariable;
import org.qualitune.tracing.umt.ModelTypeAttribute;
import org.qualitune.tracing.umt.ModelVariable;
import org.qualitune.tracing.umt.UmtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Attribute Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.ModelAttributeVariableImpl#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.ModelAttributeVariableImpl#getPartOf <em>Part Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelAttributeVariableImpl extends VariableImpl implements ModelAttributeVariable {
	/**
	 * The cached value of the '{@link #getInstanceOf() <em>Instance Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOf()
	 * @generated
	 * @ordered
	 */
	protected ModelTypeAttribute instanceOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelAttributeVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.MODEL_ATTRIBUTE_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeAttribute getInstanceOf() {
		if (instanceOf != null && instanceOf.eIsProxy()) {
			InternalEObject oldInstanceOf = (InternalEObject)instanceOf;
			instanceOf = (ModelTypeAttribute)eResolveProxy(oldInstanceOf);
			if (instanceOf != oldInstanceOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmtPackage.MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF, oldInstanceOf, instanceOf));
			}
		}
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeAttribute basicGetInstanceOf() {
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceOf(ModelTypeAttribute newInstanceOf) {
		ModelTypeAttribute oldInstanceOf = instanceOf;
		instanceOf = newInstanceOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF, oldInstanceOf, instanceOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelVariable getPartOf() {
		if (eContainerFeatureID() != UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF) return null;
		return (ModelVariable)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPartOf(ModelVariable newPartOf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPartOf, UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartOf(ModelVariable newPartOf) {
		if (newPartOf != eInternalContainer() || (eContainerFeatureID() != UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF && newPartOf != null)) {
			if (EcoreUtil.isAncestor(this, newPartOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPartOf != null)
				msgs = ((InternalEObject)newPartOf).eInverseAdd(this, UmtPackage.MODEL_VARIABLE__ATTRIBUTES, ModelVariable.class, msgs);
			msgs = basicSetPartOf(newPartOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF, newPartOf, newPartOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPartOf((ModelVariable)otherEnd, msgs);
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
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				return basicSetPartOf(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				return eInternalContainer().eInverseRemove(this, UmtPackage.MODEL_VARIABLE__ATTRIBUTES, ModelVariable.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF:
				if (resolve) return getInstanceOf();
				return basicGetInstanceOf();
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				return getPartOf();
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
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF:
				setInstanceOf((ModelTypeAttribute)newValue);
				return;
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				setPartOf((ModelVariable)newValue);
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
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF:
				setInstanceOf((ModelTypeAttribute)null);
				return;
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				setPartOf((ModelVariable)null);
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
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__INSTANCE_OF:
				return instanceOf != null;
			case UmtPackage.MODEL_ATTRIBUTE_VARIABLE__PART_OF:
				return getPartOf() != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelAttributeVariableImpl
