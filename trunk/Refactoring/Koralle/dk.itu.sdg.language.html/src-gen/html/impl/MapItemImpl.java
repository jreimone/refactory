/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.Area;
import html.HtmlPackage;
import html.MapItem;

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
 * An implementation of the model object '<em><b>Map Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.MapItemImpl#getArea <em>Area</em>}</li>
 *   <li>{@link html.impl.MapItemImpl#getMapItems <em>Map Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapItemImpl extends EObjectImpl implements MapItem {
	/**
	 * The cached value of the '{@link #getArea() <em>Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected Area area;

	/**
	 * The cached value of the '{@link #getMapItems() <em>Map Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapItems()
	 * @generated
	 * @ordered
	 */
	protected EList<MapItem> mapItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.MAP_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArea(Area newArea, NotificationChain msgs) {
		Area oldArea = area;
		area = newArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HtmlPackage.MAP_ITEM__AREA, oldArea, newArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(Area newArea) {
		if (newArea != area) {
			NotificationChain msgs = null;
			if (area != null)
				msgs = ((InternalEObject)area).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.MAP_ITEM__AREA, null, msgs);
			if (newArea != null)
				msgs = ((InternalEObject)newArea).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HtmlPackage.MAP_ITEM__AREA, null, msgs);
			msgs = basicSetArea(newArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HtmlPackage.MAP_ITEM__AREA, newArea, newArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MapItem> getMapItems() {
		if (mapItems == null) {
			mapItems = new EObjectContainmentEList<MapItem>(MapItem.class, this, HtmlPackage.MAP_ITEM__MAP_ITEMS);
		}
		return mapItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.MAP_ITEM__AREA:
				return basicSetArea(null, msgs);
			case HtmlPackage.MAP_ITEM__MAP_ITEMS:
				return ((InternalEList<?>)getMapItems()).basicRemove(otherEnd, msgs);
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
			case HtmlPackage.MAP_ITEM__AREA:
				return getArea();
			case HtmlPackage.MAP_ITEM__MAP_ITEMS:
				return getMapItems();
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
			case HtmlPackage.MAP_ITEM__AREA:
				setArea((Area)newValue);
				return;
			case HtmlPackage.MAP_ITEM__MAP_ITEMS:
				getMapItems().clear();
				getMapItems().addAll((Collection<? extends MapItem>)newValue);
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
			case HtmlPackage.MAP_ITEM__AREA:
				setArea((Area)null);
				return;
			case HtmlPackage.MAP_ITEM__MAP_ITEMS:
				getMapItems().clear();
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
			case HtmlPackage.MAP_ITEM__AREA:
				return area != null;
			case HtmlPackage.MAP_ITEM__MAP_ITEMS:
				return mapItems != null && !mapItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MapItemImpl
