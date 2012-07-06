/**
 */
package org.emftext.modelSmells.smell_model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.emftext.modelSmells.smell_model.Main;
import org.emftext.modelSmells.smell_model.Metric;
import org.emftext.modelSmells.smell_model.Metric_Quality_Mapping;
import org.emftext.modelSmells.smell_model.ModelSmell;
import org.emftext.modelSmells.smell_model.ModelSmell_Rolemapping_Mapping;
import org.emftext.modelSmells.smell_model.Quality;
import org.emftext.modelSmells.smell_model.Quality_ModelSmell_Mapping;
import org.emftext.modelSmells.smell_model.Smell_modelPackage;
import org.emftext.modelSmells.smell_model.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getModelSmell_roleMapping <em>Model Smell role Mapping</em>}</li>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getQuality_modelSmell <em>Quality model Smell</em>}</li>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getMetric_quality <em>Metric quality</em>}</li>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getView <em>View</em>}</li>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getQualities <em>Qualities</em>}</li>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getModelSmells <em>Model Smells</em>}</li>
 *   <li>{@link org.emftext.modelSmells.smell_model.impl.MainImpl#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MainImpl extends EObjectImpl implements Main {
	/**
	 * The cached value of the '{@link #getModelSmell_roleMapping() <em>Model Smell role Mapping</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmell_roleMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSmell_Rolemapping_Mapping> modelSmell_roleMapping;

	/**
	 * The cached value of the '{@link #getQuality_modelSmell() <em>Quality model Smell</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality_modelSmell()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality_ModelSmell_Mapping> quality_modelSmell;

	/**
	 * The cached value of the '{@link #getMetric_quality() <em>Metric quality</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric_quality()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric_Quality_Mapping> metric_quality;

	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected View view;

	/**
	 * The cached value of the '{@link #getQualities() <em>Qualities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualities()
	 * @generated
	 * @ordered
	 */
	protected EList<Quality> qualities;

	/**
	 * The cached value of the '{@link #getModelSmells() <em>Model Smells</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelSmells()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSmell> modelSmells;

	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Smell_modelPackage.Literals.MAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSmell_Rolemapping_Mapping> getModelSmell_roleMapping() {
		if (modelSmell_roleMapping == null) {
			modelSmell_roleMapping = new EObjectResolvingEList<ModelSmell_Rolemapping_Mapping>(ModelSmell_Rolemapping_Mapping.class, this, Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING);
		}
		return modelSmell_roleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Quality_ModelSmell_Mapping> getQuality_modelSmell() {
		if (quality_modelSmell == null) {
			quality_modelSmell = new EObjectResolvingEList<Quality_ModelSmell_Mapping>(Quality_ModelSmell_Mapping.class, this, Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL);
		}
		return quality_modelSmell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric_Quality_Mapping> getMetric_quality() {
		if (metric_quality == null) {
			metric_quality = new EObjectResolvingEList<Metric_Quality_Mapping>(Metric_Quality_Mapping.class, this, Smell_modelPackage.MAIN__METRIC_QUALITY);
		}
		return metric_quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View getView() {
		if (view != null && view.eIsProxy()) {
			InternalEObject oldView = (InternalEObject)view;
			view = (View)eResolveProxy(oldView);
			if (view != oldView) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Smell_modelPackage.MAIN__VIEW, oldView, view));
			}
		}
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View basicGetView() {
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setView(View newView) {
		View oldView = view;
		view = newView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Smell_modelPackage.MAIN__VIEW, oldView, view));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Quality> getQualities() {
		if (qualities == null) {
			qualities = new EObjectResolvingEList<Quality>(Quality.class, this, Smell_modelPackage.MAIN__QUALITIES);
		}
		return qualities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSmell> getModelSmells() {
		if (modelSmells == null) {
			modelSmells = new EObjectResolvingEList<ModelSmell>(ModelSmell.class, this, Smell_modelPackage.MAIN__MODEL_SMELLS);
		}
		return modelSmells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectResolvingEList<Metric>(Metric.class, this, Smell_modelPackage.MAIN__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void calculate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void updateGui() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void refactor() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				return getModelSmell_roleMapping();
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				return getQuality_modelSmell();
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				return getMetric_quality();
			case Smell_modelPackage.MAIN__VIEW:
				if (resolve) return getView();
				return basicGetView();
			case Smell_modelPackage.MAIN__QUALITIES:
				return getQualities();
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				return getModelSmells();
			case Smell_modelPackage.MAIN__METRICS:
				return getMetrics();
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				getModelSmell_roleMapping().clear();
				getModelSmell_roleMapping().addAll((Collection<? extends ModelSmell_Rolemapping_Mapping>)newValue);
				return;
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				getQuality_modelSmell().clear();
				getQuality_modelSmell().addAll((Collection<? extends Quality_ModelSmell_Mapping>)newValue);
				return;
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				getMetric_quality().clear();
				getMetric_quality().addAll((Collection<? extends Metric_Quality_Mapping>)newValue);
				return;
			case Smell_modelPackage.MAIN__VIEW:
				setView((View)newValue);
				return;
			case Smell_modelPackage.MAIN__QUALITIES:
				getQualities().clear();
				getQualities().addAll((Collection<? extends Quality>)newValue);
				return;
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				getModelSmells().clear();
				getModelSmells().addAll((Collection<? extends ModelSmell>)newValue);
				return;
			case Smell_modelPackage.MAIN__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				getModelSmell_roleMapping().clear();
				return;
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				getQuality_modelSmell().clear();
				return;
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				getMetric_quality().clear();
				return;
			case Smell_modelPackage.MAIN__VIEW:
				setView((View)null);
				return;
			case Smell_modelPackage.MAIN__QUALITIES:
				getQualities().clear();
				return;
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				getModelSmells().clear();
				return;
			case Smell_modelPackage.MAIN__METRICS:
				getMetrics().clear();
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
			case Smell_modelPackage.MAIN__MODEL_SMELL_ROLE_MAPPING:
				return modelSmell_roleMapping != null && !modelSmell_roleMapping.isEmpty();
			case Smell_modelPackage.MAIN__QUALITY_MODEL_SMELL:
				return quality_modelSmell != null && !quality_modelSmell.isEmpty();
			case Smell_modelPackage.MAIN__METRIC_QUALITY:
				return metric_quality != null && !metric_quality.isEmpty();
			case Smell_modelPackage.MAIN__VIEW:
				return view != null;
			case Smell_modelPackage.MAIN__QUALITIES:
				return qualities != null && !qualities.isEmpty();
			case Smell_modelPackage.MAIN__MODEL_SMELLS:
				return modelSmells != null && !modelSmells.isEmpty();
			case Smell_modelPackage.MAIN__METRICS:
				return metrics != null && !metrics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MainImpl
