/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.ejava.test.ejavatest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.emftext.ejava.test.ejavatest.EjavatestPackage;
import org.emftext.ejava.test.ejavatest.ModifierEnum;
import org.emftext.ejava.test.ejavatest.ModifierUser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifier User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.ejava.test.ejavatest.impl.ModifierUserImpl#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModifierUserImpl extends EObjectImpl implements ModifierUser {
	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<ModifierEnum> modifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifierUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EjavatestPackage.Literals.MODIFIER_USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModifierEnum> getModifier() {
		if (modifier == null) {
			modifier = new EDataTypeEList<ModifierEnum>(ModifierEnum.class, this, EjavatestPackage.MODIFIER_USER__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModifierEnum> getTheModifiers() {
		EList<ModifierEnum> result = new BasicEList<ModifierEnum>();
		EList<ModifierEnum> modifiers = getModifier();
		if(modifiers.contains(ModifierEnum.SUPER)){
			result.add(ModifierEnum.SUPER);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EjavatestPackage.MODIFIER_USER__MODIFIER:
				return getModifier();
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
			case EjavatestPackage.MODIFIER_USER__MODIFIER:
				getModifier().clear();
				getModifier().addAll((Collection<? extends ModifierEnum>)newValue);
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
			case EjavatestPackage.MODIFIER_USER__MODIFIER:
				getModifier().clear();
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
			case EjavatestPackage.MODIFIER_USER__MODIFIER:
				return modifier != null && !modifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modifier: ");
		result.append(modifier);
		result.append(')');
		return result.toString();
	}

} //ModifierUserImpl
