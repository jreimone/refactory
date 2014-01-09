/**
 */
package org.qualitune.tracing.umt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.tracing.umt.MetaModel;
import org.qualitune.tracing.umt.ModelType;
import org.qualitune.tracing.umt.UmtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.MetaModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.MetaModelImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.MetaModelImpl#getUrn <em>Urn</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.MetaModelImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.MetaModelImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.MetaModelImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaModelImpl extends EObjectImpl implements MetaModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected MetaModel metamodel;

	/**
	 * The default value of the '{@link #getUrn() <em>Urn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrn()
	 * @generated
	 * @ordered
	 */
	protected static final String URN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrn() <em>Urn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrn()
	 * @generated
	 * @ordered
	 */
	protected String urn = URN_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> types;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.META_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.META_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModel getMetamodel() {
		if (metamodel != null && metamodel.eIsProxy()) {
			InternalEObject oldMetamodel = (InternalEObject)metamodel;
			metamodel = (MetaModel)eResolveProxy(oldMetamodel);
			if (metamodel != oldMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmtPackage.META_MODEL__METAMODEL, oldMetamodel, metamodel));
			}
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModel basicGetMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(MetaModel newMetamodel) {
		MetaModel oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.META_MODEL__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrn() {
		return urn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrn(String newUrn) {
		String oldUrn = urn;
		urn = newUrn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.META_MODEL__URN, oldUrn, urn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.META_MODEL__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.META_MODEL__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getTypes() {
		if (types == null) {
			types = new EObjectContainmentWithInverseEList<ModelType>(ModelType.class, this, UmtPackage.META_MODEL__TYPES, UmtPackage.MODEL_TYPE__MODEL);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmtPackage.META_MODEL__TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypes()).basicAdd(otherEnd, msgs);
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
			case UmtPackage.META_MODEL__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
			case UmtPackage.META_MODEL__NAME:
				return getName();
			case UmtPackage.META_MODEL__METAMODEL:
				if (resolve) return getMetamodel();
				return basicGetMetamodel();
			case UmtPackage.META_MODEL__URN:
				return getUrn();
			case UmtPackage.META_MODEL__NS_URI:
				return getNsURI();
			case UmtPackage.META_MODEL__NS_PREFIX:
				return getNsPrefix();
			case UmtPackage.META_MODEL__TYPES:
				return getTypes();
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
			case UmtPackage.META_MODEL__NAME:
				setName((String)newValue);
				return;
			case UmtPackage.META_MODEL__METAMODEL:
				setMetamodel((MetaModel)newValue);
				return;
			case UmtPackage.META_MODEL__URN:
				setUrn((String)newValue);
				return;
			case UmtPackage.META_MODEL__NS_URI:
				setNsURI((String)newValue);
				return;
			case UmtPackage.META_MODEL__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case UmtPackage.META_MODEL__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends ModelType>)newValue);
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
			case UmtPackage.META_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmtPackage.META_MODEL__METAMODEL:
				setMetamodel((MetaModel)null);
				return;
			case UmtPackage.META_MODEL__URN:
				setUrn(URN_EDEFAULT);
				return;
			case UmtPackage.META_MODEL__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case UmtPackage.META_MODEL__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case UmtPackage.META_MODEL__TYPES:
				getTypes().clear();
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
			case UmtPackage.META_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmtPackage.META_MODEL__METAMODEL:
				return metamodel != null;
			case UmtPackage.META_MODEL__URN:
				return URN_EDEFAULT == null ? urn != null : !URN_EDEFAULT.equals(urn);
			case UmtPackage.META_MODEL__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case UmtPackage.META_MODEL__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case UmtPackage.META_MODEL__TYPES:
				return types != null && !types.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", urn: ");
		result.append(urn);
		result.append(", nsURI: ");
		result.append(nsURI);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(')');
		return result.toString();
	}

} //MetaModelImpl
