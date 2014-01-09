/**
 */
package org.qualitune.tracing.vapoditrace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.qualitune.tracing.vapoditrace.ConcernType;
import org.qualitune.tracing.vapoditrace.EEntity;
import org.qualitune.tracing.vapoditrace.vapoditracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEntity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.EEntityImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.EEntityImpl#getConcern <em>Concern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EEntityImpl extends EObjectImpl implements EEntity {
	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getConcern() <em>Concern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcern()
	 * @generated
	 * @ordered
	 */
	protected static final ConcernType CONCERN_EDEFAULT = ConcernType.OMITTED_CONCERN;

	/**
	 * The cached value of the '{@link #getConcern() <em>Concern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcern()
	 * @generated
	 * @ordered
	 */
	protected ConcernType concern = CONCERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return vapoditracePackage.Literals.EENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.EENTITY__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcernType getConcern() {
		return concern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcern(ConcernType newConcern) {
		ConcernType oldConcern = concern;
		concern = newConcern == null ? CONCERN_EDEFAULT : newConcern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.EENTITY__CONCERN, oldConcern, concern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case vapoditracePackage.EENTITY__ATTRIBUTE_NAME:
				return getAttributeName();
			case vapoditracePackage.EENTITY__CONCERN:
				return getConcern();
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
			case vapoditracePackage.EENTITY__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case vapoditracePackage.EENTITY__CONCERN:
				setConcern((ConcernType)newValue);
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
			case vapoditracePackage.EENTITY__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case vapoditracePackage.EENTITY__CONCERN:
				setConcern(CONCERN_EDEFAULT);
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
			case vapoditracePackage.EENTITY__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case vapoditracePackage.EENTITY__CONCERN:
				return concern != CONCERN_EDEFAULT;
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
		result.append(" (attributeName: ");
		result.append(attributeName);
		result.append(", concern: ");
		result.append(concern);
		result.append(')');
		return result.toString();
	}

} //EEntityImpl
