/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.CompleteDocument;
import html.DocType;
import html.HtmlPackage;
import html.Parameter;
import html.WebPageBody;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.CompleteDocumentImpl#getDoctype <em>Doctype</em>}</li>
 *   <li>{@link html.impl.CompleteDocumentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link html.impl.CompleteDocumentImpl#getWebPageBody <em>Web Page Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteDocumentImpl extends DocumentImpl implements CompleteDocument {
	/**
	 * The cached value of the '{@link #getDoctype() <em>Doctype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoctype()
	 * @generated
	 * @ordered
	 */
	protected DocType doctype;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getWebPageBody() <em>Web Page Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebPageBody()
	 * @generated
	 * @ordered
	 */
	protected WebPageBody webPageBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.COMPLETE_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType getDoctype() {
		return doctype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDoctype(DocType newDoctype, NotificationChain msgs) {
		DocType oldDoctype = doctype;
		doctype = newDoctype;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE, oldDoctype, newDoctype);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoctype(DocType newDoctype) {
		if (newDoctype != doctype) {
			NotificationChain msgs = null;
			if (doctype != null)
				msgs = ((InternalEObject)doctype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE, null, msgs);
			if (newDoctype != null)
				msgs = ((InternalEObject)newDoctype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE, null, msgs);
			msgs = basicSetDoctype(newDoctype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE, newDoctype, newDoctype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, HtmlPackage.COMPLETE_DOCUMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebPageBody getWebPageBody() {
		return webPageBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWebPageBody(WebPageBody newWebPageBody, NotificationChain msgs) {
		WebPageBody oldWebPageBody = webPageBody;
		webPageBody = newWebPageBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY, oldWebPageBody, newWebPageBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebPageBody(WebPageBody newWebPageBody) {
		if (newWebPageBody != webPageBody) {
			NotificationChain msgs = null;
			if (webPageBody != null)
				msgs = ((InternalEObject)webPageBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY, null, msgs);
			if (newWebPageBody != null)
				msgs = ((InternalEObject)newWebPageBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY, null, msgs);
			msgs = basicSetWebPageBody(newWebPageBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY, newWebPageBody, newWebPageBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE:
				return basicSetDoctype(null, msgs);
			case HtmlPackage.COMPLETE_DOCUMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY:
				return basicSetWebPageBody(null, msgs);
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
			case HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE:
				return getDoctype();
			case HtmlPackage.COMPLETE_DOCUMENT__PARAMETERS:
				return getParameters();
			case HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY:
				return getWebPageBody();
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
			case HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE:
				setDoctype((DocType)newValue);
				return;
			case HtmlPackage.COMPLETE_DOCUMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY:
				setWebPageBody((WebPageBody)newValue);
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
			case HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE:
				setDoctype((DocType)null);
				return;
			case HtmlPackage.COMPLETE_DOCUMENT__PARAMETERS:
				getParameters().clear();
				return;
			case HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY:
				setWebPageBody((WebPageBody)null);
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
			case HtmlPackage.COMPLETE_DOCUMENT__DOCTYPE:
				return doctype != null;
			case HtmlPackage.COMPLETE_DOCUMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case HtmlPackage.COMPLETE_DOCUMENT__WEB_PAGE_BODY:
				return webPageBody != null;
		}
		return super.eIsSet(featureID);
	}

} //CompleteDocumentImpl
