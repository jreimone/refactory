/**
 */
package org.qualitune.tracing.vapoditrace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.qualitune.tracing.vapoditrace.DynamicEntity;
import org.qualitune.tracing.vapoditrace.vapoditracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl#getEsf <em>Esf</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.DynamicEntityImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicEntityImpl extends TraceEntityImpl implements DynamicEntity {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;

	/**
	 * The cached value of the '{@link #getEsf() <em>Esf</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEsf()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature esf;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return vapoditracePackage.Literals.DYNAMIC_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, vapoditracePackage.DYNAMIC_ENTITY__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.DYNAMIC_ENTITY__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getEsf() {
		if (esf != null && esf.eIsProxy()) {
			InternalEObject oldEsf = (InternalEObject)esf;
			esf = (EStructuralFeature)eResolveProxy(oldEsf);
			if (esf != oldEsf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, vapoditracePackage.DYNAMIC_ENTITY__ESF, oldEsf, esf));
			}
		}
		return esf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetEsf() {
		return esf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEsf(EStructuralFeature newEsf) {
		EStructuralFeature oldEsf = esf;
		esf = newEsf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.DYNAMIC_ENTITY__ESF, oldEsf, esf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, vapoditracePackage.DYNAMIC_ENTITY__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(EObject newObject) {
		EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.DYNAMIC_ENTITY__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case vapoditracePackage.DYNAMIC_ENTITY__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case vapoditracePackage.DYNAMIC_ENTITY__ESF:
				if (resolve) return getEsf();
				return basicGetEsf();
			case vapoditracePackage.DYNAMIC_ENTITY__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
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
			case vapoditracePackage.DYNAMIC_ENTITY__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
				return;
			case vapoditracePackage.DYNAMIC_ENTITY__ESF:
				setEsf((EStructuralFeature)newValue);
				return;
			case vapoditracePackage.DYNAMIC_ENTITY__OBJECT:
				setObject((EObject)newValue);
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
			case vapoditracePackage.DYNAMIC_ENTITY__ATTRIBUTE:
				setAttribute((EAttribute)null);
				return;
			case vapoditracePackage.DYNAMIC_ENTITY__ESF:
				setEsf((EStructuralFeature)null);
				return;
			case vapoditracePackage.DYNAMIC_ENTITY__OBJECT:
				setObject((EObject)null);
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
			case vapoditracePackage.DYNAMIC_ENTITY__ATTRIBUTE:
				return attribute != null;
			case vapoditracePackage.DYNAMIC_ENTITY__ESF:
				return esf != null;
			case vapoditracePackage.DYNAMIC_ENTITY__OBJECT:
				return object != null;
		}
		return super.eIsSet(featureID);
	}

} //DynamicEntityImpl
