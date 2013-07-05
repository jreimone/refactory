/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.evolution.tracing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.evolution.tracing.TraceLink;
import org.qualitune.evolution.tracing.TracingModel;
import org.qualitune.evolution.tracing.TracingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.tracing.impl.TracingModelImpl#getTraceLinks <em>Trace Links</em>}</li>
 *   <li>{@link org.qualitune.evolution.tracing.impl.TracingModelImpl#getSourceURIs <em>Source UR Is</em>}</li>
 *   <li>{@link org.qualitune.evolution.tracing.impl.TracingModelImpl#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TracingModelImpl extends EObjectImpl implements TracingModel {
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
   * The cached value of the '{@link #getSourceURIs() <em>Source UR Is</em>}' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSourceURIs()
   * @generated
   * @ordered
   */
	protected EList<String> sourceURIs;

	/**
   * The default value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTargetURI()
   * @generated
   * @ordered
   */
	protected static final String TARGET_URI_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTargetURI()
   * @generated
   * @ordered
   */
	protected String targetURI = TARGET_URI_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TracingModelImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return TracingPackage.Literals.TRACING_MODEL;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<TraceLink> getTraceLinks() {
    if (traceLinks == null)
    {
      traceLinks = new EObjectContainmentEList<TraceLink>(TraceLink.class, this, TracingPackage.TRACING_MODEL__TRACE_LINKS);
    }
    return traceLinks;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<String> getSourceURIs() {
    if (sourceURIs == null)
    {
      sourceURIs = new EDataTypeUniqueEList<String>(String.class, this, TracingPackage.TRACING_MODEL__SOURCE_UR_IS);
    }
    return sourceURIs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getTargetURI() {
    return targetURI;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setTargetURI(String newTargetURI) {
    String oldTargetURI = targetURI;
    targetURI = newTargetURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TracingPackage.TRACING_MODEL__TARGET_URI, oldTargetURI, targetURI));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case TracingPackage.TRACING_MODEL__TRACE_LINKS:
        return ((InternalEList<?>)getTraceLinks()).basicRemove(otherEnd, msgs);
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
    switch (featureID)
    {
      case TracingPackage.TRACING_MODEL__TRACE_LINKS:
        return getTraceLinks();
      case TracingPackage.TRACING_MODEL__SOURCE_UR_IS:
        return getSourceURIs();
      case TracingPackage.TRACING_MODEL__TARGET_URI:
        return getTargetURI();
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
    switch (featureID)
    {
      case TracingPackage.TRACING_MODEL__TRACE_LINKS:
        getTraceLinks().clear();
        getTraceLinks().addAll((Collection<? extends TraceLink>)newValue);
        return;
      case TracingPackage.TRACING_MODEL__SOURCE_UR_IS:
        getSourceURIs().clear();
        getSourceURIs().addAll((Collection<? extends String>)newValue);
        return;
      case TracingPackage.TRACING_MODEL__TARGET_URI:
        setTargetURI((String)newValue);
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
    switch (featureID)
    {
      case TracingPackage.TRACING_MODEL__TRACE_LINKS:
        getTraceLinks().clear();
        return;
      case TracingPackage.TRACING_MODEL__SOURCE_UR_IS:
        getSourceURIs().clear();
        return;
      case TracingPackage.TRACING_MODEL__TARGET_URI:
        setTargetURI(TARGET_URI_EDEFAULT);
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
    switch (featureID)
    {
      case TracingPackage.TRACING_MODEL__TRACE_LINKS:
        return traceLinks != null && !traceLinks.isEmpty();
      case TracingPackage.TRACING_MODEL__SOURCE_UR_IS:
        return sourceURIs != null && !sourceURIs.isEmpty();
      case TracingPackage.TRACING_MODEL__TARGET_URI:
        return TARGET_URI_EDEFAULT == null ? targetURI != null : !TARGET_URI_EDEFAULT.equals(targetURI);
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
    result.append(" (sourceURIs: ");
    result.append(sourceURIs);
    result.append(", targetURI: ");
    result.append(targetURI);
    result.append(')');
    return result.toString();
  }

} //TracingModelImpl
