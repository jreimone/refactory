/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.Variable;

import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Refactoring Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl#getUsedRoleModel <em>Used Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefactoringSpecificationImpl extends EObjectImpl implements RefactoringSpecification {
	/**
	 * The cached value of the '{@link #getUsedRoleModel() <em>Used Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedRoleModel()
	 * @generated
	 * @ordered
	 */
	protected RoleModel usedRoleModel;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList<Instruction> instructions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefactoringSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RefactoringSpecificationPackage.Literals.REFACTORING_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel getUsedRoleModel() {
		if (usedRoleModel != null && usedRoleModel.eIsProxy()) {
			InternalEObject oldUsedRoleModel = (InternalEObject)usedRoleModel;
			usedRoleModel = (RoleModel)eResolveProxy(oldUsedRoleModel);
			if (usedRoleModel != oldUsedRoleModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL, oldUsedRoleModel, usedRoleModel));
			}
		}
		return usedRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleModel basicGetUsedRoleModel() {
		return usedRoleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedRoleModel(RoleModel newUsedRoleModel) {
		RoleModel oldUsedRoleModel = usedRoleModel;
		usedRoleModel = newUsedRoleModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL, oldUsedRoleModel, usedRoleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this, RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS);
		}
		return instructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getDeclaredVariables() {
		org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.refactoring_specification.Variable > variables = new org.eclipse.emf.common.util.BasicEList < org.emftext.language.refactoring.refactoring_specification.Variable > ( ) ; 
		org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.refactoring_specification.Instruction > instructions = getInstructions ( ) ; 
		for ( org.emftext.language.refactoring.refactoring_specification.Instruction instruction : instructions ) { 
			if ( instruction instanceof org.emftext.language.refactoring.refactoring_specification.CREATE ) { 
				org.emftext.language.refactoring.refactoring_specification.Variable var = ( ( org.emftext.language.refactoring.refactoring_specification.CREATE ) instruction ) .getVarDeclaration ( ) ; 
				if ( var != null ) { 
					variables .add ( var ) ; 
				} 
			} 
		} 
		return variables ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariableByName(String name) {
		org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.refactoring_specification.Variable > variables = getDeclaredVariables ( ) ; 
		for ( org.emftext.language.refactoring.refactoring_specification.Variable variable : variables ) { 
			if ( variable .getName ( ) .equals ( name ) ) { 
				return variable ; 
			} 
		} 
		return null ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS:
				return ((InternalEList<?>)getInstructions()).basicRemove(otherEnd, msgs);
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
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL:
				if (resolve) return getUsedRoleModel();
				return basicGetUsedRoleModel();
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME:
				return getName();
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS:
				return getInstructions();
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
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL:
				setUsedRoleModel((RoleModel)newValue);
				return;
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME:
				setName((String)newValue);
				return;
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS:
				getInstructions().clear();
				getInstructions().addAll((Collection<? extends Instruction>)newValue);
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
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL:
				setUsedRoleModel((RoleModel)null);
				return;
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS:
				getInstructions().clear();
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
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL:
				return usedRoleModel != null;
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS:
				return instructions != null && !instructions.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RefactoringSpecificationImpl
