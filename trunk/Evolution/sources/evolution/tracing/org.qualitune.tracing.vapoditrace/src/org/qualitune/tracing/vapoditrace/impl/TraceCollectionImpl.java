/**
 */
package org.qualitune.tracing.vapoditrace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.tracing.vapoditrace.TraceCollection;
import org.qualitune.tracing.vapoditrace.TraceLink;
import org.qualitune.tracing.vapoditrace.vapoditracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl#getTraceLinks <em>Trace Links</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl#getShadowObjects <em>Shadow Objects</em>}</li>
 *   <li>{@link org.qualitune.tracing.vapoditrace.impl.TraceCollectionImpl#getTrash <em>Trash</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceCollectionImpl extends EObjectImpl implements TraceCollection {
	/**
	 * The cached value of the '{@link #getTraceLinks() <em>Trace Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceLink> traceLinks;

	/**
	 * The cached value of the '{@link #getShadowObjects() <em>Shadow Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShadowObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> shadowObjects;

	/**
	 * The cached value of the '{@link #getTrash() <em>Trash</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrash()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceLink> trash;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return vapoditracePackage.Literals.TRACE_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceLink> getTraceLinks() {
		if (traceLinks == null) {
			traceLinks = new EObjectContainmentEList<TraceLink>(TraceLink.class, this, vapoditracePackage.TRACE_COLLECTION__TRACE_LINKS);
		}
		return traceLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getShadowObjects() {
		if (shadowObjects == null) {
			shadowObjects = new EObjectContainmentEList<EObject>(EObject.class, this, vapoditracePackage.TRACE_COLLECTION__SHADOW_OBJECTS);
		}
		return shadowObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceLink> getTrash() {
		if (trash == null) {
			trash = new EObjectContainmentEList<TraceLink>(TraceLink.class, this, vapoditracePackage.TRACE_COLLECTION__TRASH);
		}
		return trash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case vapoditracePackage.TRACE_COLLECTION__TRACE_LINKS:
				return ((InternalEList<?>)getTraceLinks()).basicRemove(otherEnd, msgs);
			case vapoditracePackage.TRACE_COLLECTION__SHADOW_OBJECTS:
				return ((InternalEList<?>)getShadowObjects()).basicRemove(otherEnd, msgs);
			case vapoditracePackage.TRACE_COLLECTION__TRASH:
				return ((InternalEList<?>)getTrash()).basicRemove(otherEnd, msgs);
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
			case vapoditracePackage.TRACE_COLLECTION__TRACE_LINKS:
				return getTraceLinks();
			case vapoditracePackage.TRACE_COLLECTION__SHADOW_OBJECTS:
				return getShadowObjects();
			case vapoditracePackage.TRACE_COLLECTION__TRASH:
				return getTrash();
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
			case vapoditracePackage.TRACE_COLLECTION__TRACE_LINKS:
				getTraceLinks().clear();
				getTraceLinks().addAll((Collection<? extends TraceLink>)newValue);
				return;
			case vapoditracePackage.TRACE_COLLECTION__SHADOW_OBJECTS:
				getShadowObjects().clear();
				getShadowObjects().addAll((Collection<? extends EObject>)newValue);
				return;
			case vapoditracePackage.TRACE_COLLECTION__TRASH:
				getTrash().clear();
				getTrash().addAll((Collection<? extends TraceLink>)newValue);
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
			case vapoditracePackage.TRACE_COLLECTION__TRACE_LINKS:
				getTraceLinks().clear();
				return;
			case vapoditracePackage.TRACE_COLLECTION__SHADOW_OBJECTS:
				getShadowObjects().clear();
				return;
			case vapoditracePackage.TRACE_COLLECTION__TRASH:
				getTrash().clear();
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
			case vapoditracePackage.TRACE_COLLECTION__TRACE_LINKS:
				return traceLinks != null && !traceLinks.isEmpty();
			case vapoditracePackage.TRACE_COLLECTION__SHADOW_OBJECTS:
				return shadowObjects != null && !shadowObjects.isEmpty();
			case vapoditracePackage.TRACE_COLLECTION__TRASH:
				return trash != null && !trash.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TraceCollectionImpl
