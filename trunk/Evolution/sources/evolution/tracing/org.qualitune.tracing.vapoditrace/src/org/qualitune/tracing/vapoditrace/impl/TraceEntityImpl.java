/**
 */
package org.qualitune.tracing.vapoditrace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.qualitune.tracing.vapoditrace.TraceEntity;
import org.qualitune.tracing.vapoditrace.TraceType;
import org.qualitune.tracing.vapoditrace.UniverseType;
import org.qualitune.tracing.vapoditrace.vapoditracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.TraceEntityImpl#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.TraceEntityImpl#getUniverse <em>Universe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TraceEntityImpl extends EEntityImpl implements TraceEntity {
	/**
	 * The default value of the '{@link #getSemantics() <em>Semantics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantics()
	 * @generated
	 * @ordered
	 */
	protected static final TraceType SEMANTICS_EDEFAULT = TraceType.OMITTED_TRACETYPE;

	/**
	 * The cached value of the '{@link #getSemantics() <em>Semantics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantics()
	 * @generated
	 * @ordered
	 */
	protected TraceType semantics = SEMANTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getUniverse() <em>Universe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniverse()
	 * @generated
	 * @ordered
	 */
	protected static final UniverseType UNIVERSE_EDEFAULT = UniverseType.OMITTED_UNIVERSE;

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
	protected TraceEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return vapoditracePackage.Literals.TRACE_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceType getSemantics() {
		return semantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemantics(TraceType newSemantics) {
		TraceType oldSemantics = semantics;
		semantics = newSemantics == null ? SEMANTICS_EDEFAULT : newSemantics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.TRACE_ENTITY__SEMANTICS, oldSemantics, semantics));
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
			eNotify(new ENotificationImpl(this, Notification.SET, vapoditracePackage.TRACE_ENTITY__UNIVERSE, oldUniverse, universe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case vapoditracePackage.TRACE_ENTITY__SEMANTICS:
				return getSemantics();
			case vapoditracePackage.TRACE_ENTITY__UNIVERSE:
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
			case vapoditracePackage.TRACE_ENTITY__SEMANTICS:
				setSemantics((TraceType)newValue);
				return;
			case vapoditracePackage.TRACE_ENTITY__UNIVERSE:
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
			case vapoditracePackage.TRACE_ENTITY__SEMANTICS:
				setSemantics(SEMANTICS_EDEFAULT);
				return;
			case vapoditracePackage.TRACE_ENTITY__UNIVERSE:
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
			case vapoditracePackage.TRACE_ENTITY__SEMANTICS:
				return semantics != SEMANTICS_EDEFAULT;
			case vapoditracePackage.TRACE_ENTITY__UNIVERSE:
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
		result.append(" (semantics: ");
		result.append(semantics);
		result.append(", universe: ");
		result.append(universe);
		result.append(')');
		return result.toString();
	}

} //TraceEntityImpl
