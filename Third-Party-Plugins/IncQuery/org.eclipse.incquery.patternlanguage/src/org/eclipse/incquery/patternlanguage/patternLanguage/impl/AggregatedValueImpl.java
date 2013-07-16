/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatorExpression;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatedValueImpl#getAggregator <em>Aggregator</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatedValueImpl#getCall <em>Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregatedValueImpl extends ComputationValueImpl implements AggregatedValue
{
  /**
	 * The cached value of the '{@link #getAggregator() <em>Aggregator</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAggregator()
	 * @generated
	 * @ordered
	 */
  protected AggregatorExpression aggregator;

  /**
	 * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCall()
	 * @generated
	 * @ordered
	 */
  protected PatternCall call;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AggregatedValueImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return PatternLanguagePackage.Literals.AGGREGATED_VALUE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AggregatorExpression getAggregator()
  {
		return aggregator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAggregator(AggregatorExpression newAggregator, NotificationChain msgs)
  {
		AggregatorExpression oldAggregator = aggregator;
		aggregator = newAggregator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR, oldAggregator, newAggregator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAggregator(AggregatorExpression newAggregator)
  {
		if (newAggregator != aggregator) {
			NotificationChain msgs = null;
			if (aggregator != null)
				msgs = ((InternalEObject)aggregator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR, null, msgs);
			if (newAggregator != null)
				msgs = ((InternalEObject)newAggregator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR, null, msgs);
			msgs = basicSetAggregator(newAggregator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR, newAggregator, newAggregator));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PatternCall getCall()
  {
		return call;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCall(PatternCall newCall, NotificationChain msgs)
  {
		PatternCall oldCall = call;
		call = newCall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.AGGREGATED_VALUE__CALL, oldCall, newCall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCall(PatternCall newCall)
  {
		if (newCall != call) {
			NotificationChain msgs = null;
			if (call != null)
				msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.AGGREGATED_VALUE__CALL, null, msgs);
			if (newCall != null)
				msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.AGGREGATED_VALUE__CALL, null, msgs);
			msgs = basicSetCall(newCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.AGGREGATED_VALUE__CALL, newCall, newCall));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR:
				return basicSetAggregator(null, msgs);
			case PatternLanguagePackage.AGGREGATED_VALUE__CALL:
				return basicSetCall(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR:
				return getAggregator();
			case PatternLanguagePackage.AGGREGATED_VALUE__CALL:
				return getCall();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR:
				setAggregator((AggregatorExpression)newValue);
				return;
			case PatternLanguagePackage.AGGREGATED_VALUE__CALL:
				setCall((PatternCall)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR:
				setAggregator((AggregatorExpression)null);
				return;
			case PatternLanguagePackage.AGGREGATED_VALUE__CALL:
				setCall((PatternCall)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case PatternLanguagePackage.AGGREGATED_VALUE__AGGREGATOR:
				return aggregator != null;
			case PatternLanguagePackage.AGGREGATED_VALUE__CALL:
				return call != null;
		}
		return super.eIsSet(featureID);
	}

} //AggregatedValueImpl
