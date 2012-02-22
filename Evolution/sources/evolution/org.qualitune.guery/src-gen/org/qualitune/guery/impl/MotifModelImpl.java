/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.guery.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.Motif;
import org.qualitune.guery.MotifModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motif Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.guery.impl.MotifModelImpl#getMotifs <em>Motifs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotifModelImpl extends EObjectImpl implements MotifModel {
	/**
	 * The cached value of the '{@link #getMotifs() <em>Motifs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMotifs()
	 * @generated
	 * @ordered
	 */
	protected EList<Motif> motifs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotifModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GueryPackage.Literals.MOTIF_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Motif> getMotifs() {
		if (motifs == null) {
			motifs = new EObjectContainmentEList<Motif>(Motif.class, this, GueryPackage.MOTIF_MODEL__MOTIFS);
		}
		return motifs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GueryPackage.MOTIF_MODEL__MOTIFS:
				return ((InternalEList<?>)getMotifs()).basicRemove(otherEnd, msgs);
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
			case GueryPackage.MOTIF_MODEL__MOTIFS:
				return getMotifs();
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
			case GueryPackage.MOTIF_MODEL__MOTIFS:
				getMotifs().clear();
				getMotifs().addAll((Collection<? extends Motif>)newValue);
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
			case GueryPackage.MOTIF_MODEL__MOTIFS:
				getMotifs().clear();
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
			case GueryPackage.MOTIF_MODEL__MOTIFS:
				return motifs != null && !motifs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MotifModelImpl
