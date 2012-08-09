/**
 */
package rolemapping.impl;

import ecore.EClass;
import ecore.EReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import rolemapping.ReferenceMetaClassPair;
import rolemapping.RolemappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Meta Class Pair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rolemapping.impl.ReferenceMetaClassPairImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link rolemapping.impl.ReferenceMetaClassPairImpl#getMetaClass <em>Meta Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceMetaClassPairImpl extends EObjectImpl implements ReferenceMetaClassPair {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * The cached value of the '{@link #getMetaClass() <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaClass()
	 * @generated
	 * @ordered
	 */
	protected EClass metaClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceMetaClassPairImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected org.eclipse.emf.ecore.EClass eStaticClass() {
		return RolemappingPackage.Literals.REFERENCE_META_CLASS_PAIR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.REFERENCE_META_CLASS_PAIR__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.REFERENCE_META_CLASS_PAIR__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaClass() {
		if (metaClass != null && metaClass.eIsProxy()) {
			InternalEObject oldMetaClass = (InternalEObject)metaClass;
			metaClass = (EClass)eResolveProxy(oldMetaClass);
			if (metaClass != oldMetaClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RolemappingPackage.REFERENCE_META_CLASS_PAIR__META_CLASS, oldMetaClass, metaClass));
			}
		}
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetMetaClass() {
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaClass(EClass newMetaClass) {
		EClass oldMetaClass = metaClass;
		metaClass = newMetaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RolemappingPackage.REFERENCE_META_CLASS_PAIR__META_CLASS, oldMetaClass, metaClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__META_CLASS:
				if (resolve) return getMetaClass();
				return basicGetMetaClass();
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
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__REFERENCE:
				setReference((EReference)newValue);
				return;
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__META_CLASS:
				setMetaClass((EClass)newValue);
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
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__REFERENCE:
				setReference((EReference)null);
				return;
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__META_CLASS:
				setMetaClass((EClass)null);
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
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__REFERENCE:
				return reference != null;
			case RolemappingPackage.REFERENCE_META_CLASS_PAIR__META_CLASS:
				return metaClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceMetaClassPairImpl
