/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.Content;
import html.H5Tag;
import html.HtmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>H5 Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.H5TagImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class H5TagImpl extends TagImpl implements H5Tag {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected Content content;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected H5TagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.H5_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Content getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContent(Content newContent, NotificationChain msgs) {
		Content oldContent = content;
		content = newContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.H5_TAG__CONTENT, oldContent, newContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(Content newContent) {
		if (newContent != content) {
			NotificationChain msgs = null;
			if (content != null)
				msgs = ((InternalEObject)content).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.H5_TAG__CONTENT, null, msgs);
			if (newContent != null)
				msgs = ((InternalEObject)newContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.H5_TAG__CONTENT, null, msgs);
			msgs = basicSetContent(newContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.H5_TAG__CONTENT, newContent, newContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.H5_TAG__CONTENT:
				return basicSetContent(null, msgs);
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
			case HtmlPackage.H5_TAG__CONTENT:
				return getContent();
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
			case HtmlPackage.H5_TAG__CONTENT:
				setContent((Content)newValue);
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
			case HtmlPackage.H5_TAG__CONTENT:
				setContent((Content)null);
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
			case HtmlPackage.H5_TAG__CONTENT:
				return content != null;
		}
		return super.eIsSet(featureID);
	}

} //H5TagImpl
