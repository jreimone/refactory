/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.DirTag;
import html.HtmlPackage;
import html.ListItem;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dir Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.DirTagImpl#getListItems <em>List Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirTagImpl extends TagImpl implements DirTag {
	/**
	 * The cached value of the '{@link #getListItems() <em>List Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ListItem> listItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.DIR_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ListItem> getListItems() {
		if (listItems == null) {
			listItems = new EObjectContainmentEList<ListItem>(ListItem.class, this, HtmlPackage.DIR_TAG__LIST_ITEMS);
		}
		return listItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.DIR_TAG__LIST_ITEMS:
				return ((InternalEList<?>)getListItems()).basicRemove(otherEnd, msgs);
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
			case HtmlPackage.DIR_TAG__LIST_ITEMS:
				return getListItems();
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
			case HtmlPackage.DIR_TAG__LIST_ITEMS:
				getListItems().clear();
				getListItems().addAll((Collection<? extends ListItem>)newValue);
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
			case HtmlPackage.DIR_TAG__LIST_ITEMS:
				getListItems().clear();
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
			case HtmlPackage.DIR_TAG__LIST_ITEMS:
				return listItems != null && !listItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DirTagImpl
