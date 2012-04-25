/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.Content;
import html.HtmlPackage;
import html.PContent;
import html.Parameter;
import html.Tag;
import html.Word;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.ContentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link html.impl.ContentImpl#getPContent <em>PContent</em>}</li>
 *   <li>{@link html.impl.ContentImpl#getContent <em>Content</em>}</li>
 *   <li>{@link html.impl.ContentImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link html.impl.ContentImpl#getWord <em>Word</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContentImpl extends EObjectImpl implements Content {
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
	 * The cached value of the '{@link #getPContent() <em>PContent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPContent()
	 * @generated
	 * @ordered
	 */
	protected PContent pContent;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.CONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, HtmlPackage.CONTENT__PARAMETERS);
		}
		return parameters;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__PCONTENT, oldPContent, newPContent);
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
				msgs = ((InternalEObject)pContent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__PCONTENT, null, msgs);
			if (newPContent != null)
				msgs = ((InternalEObject)newPContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__PCONTENT, null, msgs);
			msgs = basicSetPContent(newPContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__PCONTENT, newPContent, newPContent));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__CONTENT, oldContent, newContent);
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
				msgs = ((InternalEObject)content).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__CONTENT, null, msgs);
			if (newContent != null)
				msgs = ((InternalEObject)newContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__CONTENT, null, msgs);
			msgs = basicSetContent(newContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__CONTENT, newContent, newContent));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__TAG, oldTag, newTag);
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
				msgs = ((InternalEObject)tag).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__TAG, null, msgs);
			if (newTag != null)
				msgs = ((InternalEObject)newTag).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__TAG, null, msgs);
			msgs = basicSetTag(newTag, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__TAG, newTag, newTag));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__WORD, oldWord, newWord);
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
				msgs = ((InternalEObject)word).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__WORD, null, msgs);
			if (newWord != null)
				msgs = ((InternalEObject)newWord).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.CONTENT__WORD, null, msgs);
			msgs = basicSetWord(newWord, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.CONTENT__WORD, newWord, newWord));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.CONTENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case HtmlPackage.CONTENT__PCONTENT:
				return basicSetPContent(null, msgs);
			case HtmlPackage.CONTENT__CONTENT:
				return basicSetContent(null, msgs);
			case HtmlPackage.CONTENT__TAG:
				return basicSetTag(null, msgs);
			case HtmlPackage.CONTENT__WORD:
				return basicSetWord(null, msgs);
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
			case HtmlPackage.CONTENT__PARAMETERS:
				return getParameters();
			case HtmlPackage.CONTENT__PCONTENT:
				return getPContent();
			case HtmlPackage.CONTENT__CONTENT:
				return getContent();
			case HtmlPackage.CONTENT__TAG:
				return getTag();
			case HtmlPackage.CONTENT__WORD:
				return getWord();
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
			case HtmlPackage.CONTENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case HtmlPackage.CONTENT__PCONTENT:
				setPContent((PContent)newValue);
				return;
			case HtmlPackage.CONTENT__CONTENT:
				setContent((Content)newValue);
				return;
			case HtmlPackage.CONTENT__TAG:
				setTag((Tag)newValue);
				return;
			case HtmlPackage.CONTENT__WORD:
				setWord((Word)newValue);
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
			case HtmlPackage.CONTENT__PARAMETERS:
				getParameters().clear();
				return;
			case HtmlPackage.CONTENT__PCONTENT:
				setPContent((PContent)null);
				return;
			case HtmlPackage.CONTENT__CONTENT:
				setContent((Content)null);
				return;
			case HtmlPackage.CONTENT__TAG:
				setTag((Tag)null);
				return;
			case HtmlPackage.CONTENT__WORD:
				setWord((Word)null);
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
			case HtmlPackage.CONTENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case HtmlPackage.CONTENT__PCONTENT:
				return pContent != null;
			case HtmlPackage.CONTENT__CONTENT:
				return content != null;
			case HtmlPackage.CONTENT__TAG:
				return tag != null;
			case HtmlPackage.CONTENT__WORD:
				return word != null;
		}
		return super.eIsSet(featureID);
	}

} //ContentImpl
