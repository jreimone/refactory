/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.Head;
import html.HeadItem;
import html.HtmlPackage;
import html.Parameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Head</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.HeadImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link html.impl.HeadImpl#getHeadItems <em>Head Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HeadImpl extends EObjectImpl implements Head {
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
	 * The cached value of the '{@link #getHeadItems() <em>Head Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadItems()
	 * @generated
	 * @ordered
	 */
	protected EList<HeadItem> headItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.HEAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, HtmlPackage.HEAD__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HeadItem> getHeadItems() {
		if (headItems == null) {
			headItems = new EObjectContainmentEList<HeadItem>(HeadItem.class, this, HtmlPackage.HEAD__HEAD_ITEMS);
		}
		return headItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.HEAD__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case HtmlPackage.HEAD__HEAD_ITEMS:
				return ((InternalEList<?>)getHeadItems()).basicRemove(otherEnd, msgs);
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
			case HtmlPackage.HEAD__PARAMETERS:
				return getParameters();
			case HtmlPackage.HEAD__HEAD_ITEMS:
				return getHeadItems();
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
			case HtmlPackage.HEAD__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case HtmlPackage.HEAD__HEAD_ITEMS:
				getHeadItems().clear();
				getHeadItems().addAll((Collection<? extends HeadItem>)newValue);
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
			case HtmlPackage.HEAD__PARAMETERS:
				getParameters().clear();
				return;
			case HtmlPackage.HEAD__HEAD_ITEMS:
				getHeadItems().clear();
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
			case HtmlPackage.HEAD__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case HtmlPackage.HEAD__HEAD_ITEMS:
				return headItems != null && !headItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HeadImpl
