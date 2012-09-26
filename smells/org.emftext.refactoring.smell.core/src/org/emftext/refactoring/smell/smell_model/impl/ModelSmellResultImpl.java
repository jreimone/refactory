/**
 */
package org.emftext.refactoring.smell.smell_model.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.emftext.refactoring.smell.smell_model.ModelMetric;
import org.emftext.refactoring.smell.smell_model.Metric_Quality_Mapping;
import org.emftext.refactoring.smell.smell_model.ModelSmell;
import org.emftext.refactoring.smell.smell_model.ModelSmellResult;
import org.emftext.refactoring.smell.smell_model.Quality;
import org.emftext.refactoring.smell.smell_model.Quality_ModelSmell_Mapping;
import org.emftext.refactoring.smell.smell_model.Smell_modelPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Smell Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellResultImpl#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link org.emftext.refactoring.smell.smell_model.impl.ModelSmellResultImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelSmellResultImpl extends EObjectImpl implements ModelSmellResult {
	/**
	 * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final Float THRESHOLD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected Float threshold = THRESHOLD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Map<ModelSmell, Map<EObject, Float>> result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSmellResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.MODEL_SMELL_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<ModelSmell, Map<EObject, Float>> getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Map<ModelSmell, Map<EObject, Float>> newResult) {
		Map<ModelSmell, Map<EObject, Float>> oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_RESULT__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(Float newThreshold) {
		Float oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MODEL_SMELL_RESULT__THRESHOLD, oldThreshold, threshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void calculate(EList<Metric_Quality_Mapping> metric_quality, EList<Quality_ModelSmell_Mapping> quality_modelSmell, Map<ModelMetric, Map<EObject, Float>> metricResultMap, Map<Quality, Float> qualityScale) {
		ModelSmellModelImpl.getMain().setLoadedMetaModel(null);
		if (result == null){
			setResult(new HashMap<ModelSmell, Map<EObject, Float>>());
		}
		if (metric_quality != null && quality_modelSmell != null && metricResultMap != null && qualityScale != null){
			for (Quality_ModelSmell_Mapping qmm : quality_modelSmell){
				for (Metric_Quality_Mapping mqm : metric_quality){
					if (qmm.getQuality().equals(mqm.getQuality())){
						Float tempFloat = 0.0f;
						ModelSmell tempModelSmell = qmm.getModelSmell();
						Map<EObject, Float> tempMap = new HashMap<EObject, Float>();
						if (metricResultMap.get(mqm.getMetric()) != null){
							for (EObject o : metricResultMap.get(mqm.getMetric()).keySet()){
								if (ModelSmellModelImpl.getMain().getLoadedMetaModel() == null){
									ModelSmellModelImpl.getMain().setLoadedMetaModel(o.eClass().getEPackage());
								}
								tempFloat = mqm.getFactor() * qualityScale.get(mqm.getQuality()) * qmm.getFactor();
								if (tempFloat >= threshold){
									if (result.get(tempModelSmell) != null){
										if (result.get(tempModelSmell).containsKey(o)){
											Float t = result.get(tempModelSmell).get(o) + tempFloat;
											tempMap.put(o, t);
											result.put(tempModelSmell, tempMap);
										} else {
											tempMap.put(o, tempFloat);
											result.put(tempModelSmell, tempMap);
										}
									} else {
										tempMap.put(o, tempFloat);
										result.put(tempModelSmell, tempMap);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Smell_modelPackage.MODEL_SMELL_RESULT__THRESHOLD:
				return getThreshold();
			case Smell_modelPackage.MODEL_SMELL_RESULT__RESULT:
				return getResult();
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
			case Smell_modelPackage.MODEL_SMELL_RESULT__THRESHOLD:
				setThreshold((Float)newValue);
				return;
			case Smell_modelPackage.MODEL_SMELL_RESULT__RESULT:
				setResult((Map<ModelSmell, Map<EObject, Float>>)newValue);
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
			case Smell_modelPackage.MODEL_SMELL_RESULT__THRESHOLD:
				setThreshold(THRESHOLD_EDEFAULT);
				return;
			case Smell_modelPackage.MODEL_SMELL_RESULT__RESULT:
				setResult((Map<ModelSmell, Map<EObject, Float>>)null);
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
			case Smell_modelPackage.MODEL_SMELL_RESULT__THRESHOLD:
				return THRESHOLD_EDEFAULT == null ? threshold != null : !THRESHOLD_EDEFAULT.equals(threshold);
			case Smell_modelPackage.MODEL_SMELL_RESULT__RESULT:
				return result != null;
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
		result.append(" (threshold: ");
		result.append(threshold);
		result.append(", result: ");
		result.append(result);
		result.append(')');
		return result.toString();
	}

} //ModelSmellResultImpl
