/**
 */
package org.qualitune.tracing.umt.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.qualitune.tracing.umt.InstanceModel;
import org.qualitune.tracing.umt.IntentionEnum;
import org.qualitune.tracing.umt.MetaModel;
import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.umt.UniverseType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.umt.impl.InstanceModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.InstanceModelImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.InstanceModelImpl#getUrn <em>Urn</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.InstanceModelImpl#getIntention <em>Intention</em>}</li>
 *   <li>{@link org.qualitune.tracing.umt.impl.InstanceModelImpl#getUniverse <em>Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceModelImpl extends EObjectImpl implements InstanceModel {
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
	 * The default value of the '{@link #getIntention() <em>Intention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntention()
	 * @generated
	 * @ordered
	 */
	protected static final IntentionEnum INTENTION_EDEFAULT = IntentionEnum.OMITTED_INTENTION;

	/**
	 * The cached value of the '{@link #getIntention() <em>Intention</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntention()
	 * @generated
	 * @ordered
	 */
	protected IntentionEnum intention = INTENTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUniverse() <em>Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniverse()
	 * @generated
	 * @ordered
	 */
	protected static final UniverseType UNIVERSE_EDEFAULT = UniverseType.LIGHT_UNIVERSE;

	/**
	 * The cached value of the '{@link #getUniverse() <em>Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniverse()
	 * @generated
	 * @ordered
	 */
	protected UniverseType universe = UNIVERSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmtPackage.Literals.INSTANCE_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.INSTANCE_MODEL__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmtPackage.INSTANCE_MODEL__METAMODEL, oldMetamodel, metamodel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.INSTANCE_MODEL__METAMODEL, oldMetamodel, metamodel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.INSTANCE_MODEL__URN, oldUrn, urn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionEnum getIntention() {
		return intention;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntention(IntentionEnum newIntention) {
		IntentionEnum oldIntention = intention;
		intention = newIntention == null ? INTENTION_EDEFAULT : newIntention;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.INSTANCE_MODEL__INTENTION, oldIntention, intention));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniverseType getUniverse() {
		return universe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUniverse(UniverseType newUniverse) {
		UniverseType oldUniverse = universe;
		universe = newUniverse == null ? UNIVERSE_EDEFAULT : newUniverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmtPackage.INSTANCE_MODEL__UNIVERSE, oldUniverse, universe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmtPackage.INSTANCE_MODEL__NAME:
				return getName();
			case UmtPackage.INSTANCE_MODEL__METAMODEL:
				if (resolve) return getMetamodel();
				return basicGetMetamodel();
			case UmtPackage.INSTANCE_MODEL__URN:
				return getUrn();
			case UmtPackage.INSTANCE_MODEL__INTENTION:
				return getIntention();
			case UmtPackage.INSTANCE_MODEL__UNIVERSE:
				return getUniverse();
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
			case UmtPackage.INSTANCE_MODEL__NAME:
				setName((String)newValue);
				return;
			case UmtPackage.INSTANCE_MODEL__METAMODEL:
				setMetamodel((MetaModel)newValue);
				return;
			case UmtPackage.INSTANCE_MODEL__URN:
				setUrn((String)newValue);
				return;
			case UmtPackage.INSTANCE_MODEL__INTENTION:
				setIntention((IntentionEnum)newValue);
				return;
			case UmtPackage.INSTANCE_MODEL__UNIVERSE:
				setUniverse((UniverseType)newValue);
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
			case UmtPackage.INSTANCE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmtPackage.INSTANCE_MODEL__METAMODEL:
				setMetamodel((MetaModel)null);
				return;
			case UmtPackage.INSTANCE_MODEL__URN:
				setUrn(URN_EDEFAULT);
				return;
			case UmtPackage.INSTANCE_MODEL__INTENTION:
				setIntention(INTENTION_EDEFAULT);
				return;
			case UmtPackage.INSTANCE_MODEL__UNIVERSE:
				setUniverse(UNIVERSE_EDEFAULT);
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
			case UmtPackage.INSTANCE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmtPackage.INSTANCE_MODEL__METAMODEL:
				return metamodel != null;
			case UmtPackage.INSTANCE_MODEL__URN:
				return URN_EDEFAULT == null ? urn != null : !URN_EDEFAULT.equals(urn);
			case UmtPackage.INSTANCE_MODEL__INTENTION:
				return intention != INTENTION_EDEFAULT;
			case UmtPackage.INSTANCE_MODEL__UNIVERSE:
				return universe != UNIVERSE_EDEFAULT;
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
		result.append(", intention: ");
		result.append(intention);
		result.append(", universe: ");
		result.append(universe);
		result.append(')');
		return result.toString();
	}

} //InstanceModelImpl
