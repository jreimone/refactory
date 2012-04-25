/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.HtmlPackage;
import html.PContent;
import html.Tag;
import html.Word;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PContent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.PContentImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link html.impl.PContentImpl#getWord <em>Word</em>}</li>
 *   <li>{@link html.impl.PContentImpl#getPContent <em>PContent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PContentImpl extends EObjectImpl implements PContent {
	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected Tag tag;

	/**
	 * The cached value of the '{@link #getWord() <em>Word</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWord()
	 * @generated
	 * @ordered
	 */
	protected Word word;

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
	protected PContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.PCONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag getTag() {
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTag(Tag newTag, NotificationChain msgs) {
		Tag oldTag = tag;
		tag = newTag;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.PCONTENT__TAG, oldTag, newTag);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(Tag newTag) {
		if (newTag != tag) {
			NotificationChain msgs = null;
			if (tag != null)
				msgs = ((InternalEObject)tag).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PCONTENT__TAG, null, msgs);
			if (newTag != null)
				msgs = ((InternalEObject)newTag).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PCONTENT__TAG, null, msgs);
			msgs = basicSetTag(newTag, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.PCONTENT__TAG, newTag, newTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word getWord() {
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWord(Word newWord, NotificationChain msgs) {
		Word oldWord = word;
		word = newWord;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.PCONTENT__WORD, oldWord, newWord);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWord(Word newWord) {
		if (newWord != word) {
			NotificationChain msgs = null;
			if (word != null)
				msgs = ((InternalEObject)word).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PCONTENT__WORD, null, msgs);
			if (newWord != null)
				msgs = ((InternalEObject)newWord).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PCONTENT__WORD, null, msgs);
			msgs = basicSetWord(newWord, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.PCONTENT__WORD, newWord, newWord));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.PCONTENT__PCONTENT, oldPContent, newPContent);
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
				msgs = ((InternalEObject)pContent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PCONTENT__PCONTENT, null, msgs);
			if (newPContent != null)
				msgs = ((InternalEObject)newPContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.PCONTENT__PCONTENT, null, msgs);
			msgs = basicSetPContent(newPContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.PCONTENT__PCONTENT, newPContent, newPContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.PCONTENT__TAG:
				return basicSetTag(null, msgs);
			case HtmlPackage.PCONTENT__WORD:
				return basicSetWord(null, msgs);
			case HtmlPackage.PCONTENT__PCONTENT:
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
			case HtmlPackage.PCONTENT__TAG:
				return getTag();
			case HtmlPackage.PCONTENT__WORD:
				return getWord();
			case HtmlPackage.PCONTENT__PCONTENT:
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
			case HtmlPackage.PCONTENT__TAG:
				setTag((Tag)newValue);
				return;
			case HtmlPackage.PCONTENT__WORD:
				setWord((Word)newValue);
				return;
			case HtmlPackage.PCONTENT__PCONTENT:
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
			case HtmlPackage.PCONTENT__TAG:
				setTag((Tag)null);
				return;
			case HtmlPackage.PCONTENT__WORD:
				setWord((Word)null);
				return;
			case HtmlPackage.PCONTENT__PCONTENT:
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
			case HtmlPackage.PCONTENT__TAG:
				return tag != null;
			case HtmlPackage.PCONTENT__WORD:
				return word != null;
			case HtmlPackage.PCONTENT__PCONTENT:
				return pContent != null;
		}
		return super.eIsSet(featureID);
	}

} //PContentImpl
