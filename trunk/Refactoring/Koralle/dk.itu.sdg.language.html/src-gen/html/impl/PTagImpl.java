/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.HtmlPackage;
import html.PContent;
import html.PTag;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PTag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.PTagImpl#getPContent <em>PContent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PTagImpl extends TagImpl implements PTag {
	/**
	 * The cached value of the '{@link #getPContent() <em>PContent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPContent()
	 * @generated
	 * @ordered
	 */
	protected PContent pContent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.PTAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PContent getPContent() {
		return pContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPContent(PContent newPContent, NotificationChain msgs) {
		PContent oldPContent = pContent;
		pContent = newPContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.PTAG__PCONTENT, oldPContent, newPContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPContent(PContent newPContent) {
		if (newPContent != pContent) {
			NotificationChain msgs = null;
			if (pContent != null)
				msgs = ((InternalEObject)pContent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PTAG__PCONTENT, null, msgs);
			if (newPContent != null)
				msgs = ((InternalEObject)newPContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PTAG__PCONTENT, null, msgs);
			msgs = basicSetPContent(newPContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.PTAG__PCONTENT, newPContent, newPContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.PTAG__PCONTENT:
				return basicSetPContent(null, msgs);
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
			case HtmlPackage.PTAG__PCONTENT:
				return getPContent();
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
			case HtmlPackage.PTAG__PCONTENT:
				setPContent((PContent)newValue);
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
			case HtmlPackage.PTAG__PCONTENT:
				setPContent((PContent)null);
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
			case HtmlPackage.PTAG__PCONTENT:
				return pContent != null;
		}
		return super.eIsSet(featureID);
	}

} //PTagImpl
