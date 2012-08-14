/**
 */
package org.emftext.refactoring.smell.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.emftext.refactoring.smell.core.Metric;
import org.emftext.refactoring.smell.core.Metric_Quality_Mapping;
import org.emftext.refactoring.smell.core.Quality;
import org.emftext.refactoring.smell.core.Smell_modelPackage;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Quality Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.core.impl.Metric_Quality_MappingImpl#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.core.impl.Metric_Quality_MappingImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Metric_Quality_MappingImpl extends MappingImpl implements Metric_Quality_Mapping {
	/**
	 * The cached value of the '{@link #getQuality() <em>Quality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality()
	 * @generated
	 * @ordered
	 */
	protected Quality quality;

	/**
	 * The cached value of the '{@link #getMetric() <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected Metric metric;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Metric_Quality_MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.METRIC_QUALITY_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality getQuality() {
		if (quality != null && quality.eIsProxy()) {
			InternalEObject oldQuality = (InternalEObject)quality;
			quality = (Quality)eResolveProxy(oldQuality);
			if (quality != oldQuality) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.METRIC_QUALITY_MAPPING__QUALITY, oldQuality, quality));
			}
		}
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality basicGetQuality() {
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuality(Quality newQuality) {
		Quality oldQuality = quality;
		quality = newQuality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.METRIC_QUALITY_MAPPING__QUALITY, oldQuality, quality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric getMetric() {
		if (metric != null && metric.eIsProxy()) {
			InternalEObject oldMetric = (InternalEObject)metric;
			metric = (Metric)eResolveProxy(oldMetric);
			if (metric != oldMetric) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.METRIC_QUALITY_MAPPING__METRIC, oldMetric, metric));
			}
		}
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric basicGetMetric() {
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetric(Metric newMetric) {
		Metric oldMetric = metric;
		metric = newMetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.METRIC_QUALITY_MAPPING__METRIC, oldMetric, metric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__QUALITY:
				if (resolve) return getQuality();
				return basicGetQuality();
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__METRIC:
				if (resolve) return getMetric();
				return basicGetMetric();
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
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__QUALITY:
				setQuality((Quality)newValue);
				return;
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__METRIC:
				setMetric((Metric)newValue);
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
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__QUALITY:
				setQuality((Quality)null);
				return;
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__METRIC:
				setMetric((Metric)null);
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
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__QUALITY:
				return quality != null;
			case Smell_modelPackage.METRIC_QUALITY_MAPPING__METRIC:
				return metric != null;
		}
		return super.eIsSet(featureID);
	}

} //Metric_Quality_MappingImpl
