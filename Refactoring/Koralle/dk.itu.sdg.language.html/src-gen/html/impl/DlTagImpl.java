/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.DefItem;
import html.DlTag;
import html.HtmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dl Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.DlTagImpl#getDefItems <em>Def Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DlTagImpl extends TagImpl implements DlTag {
	/**
	 * The cached value of the '{@link #getDefItems() <em>Def Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefItems()
	 * @generated
	 * @ordered
	 */
	protected EList<DefItem> defItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DlTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.DL_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefItem> getDefItems() {
		if (defItems == null) {
			defItems = new EObjectContainmentEList<DefItem>(DefItem.class, this, HtmlPackage.DL_TAG__DEF_ITEMS);
		}
		return defItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.DL_TAG__DEF_ITEMS:
				return ((InternalEList<?>)getDefItems()).basicRemove(otherEnd, msgs);
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
			case HtmlPackage.DL_TAG__DEF_ITEMS:
				return getDefItems();
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
			case HtmlPackage.DL_TAG__DEF_ITEMS:
				getDefItems().clear();
				getDefItems().addAll((Collection<? extends DefItem>)newValue);
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
			case HtmlPackage.DL_TAG__DEF_ITEMS:
				getDefItems().clear();
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
			case HtmlPackage.DL_TAG__DEF_ITEMS:
				return defItems != null && !defItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DlTagImpl
