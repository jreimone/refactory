/**
 * <copyright>
 * </copyright>
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.refactoring.refactoring_specification.Instruction;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Refactoring Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationImpl#getUsedRoleModel <em>Used Role Model</em>}</li>
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
			if ( instruction instanceof org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand ) { 
				org.emftext.language.refactoring.refactoring_specification.Variable var = ( ( org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand ) instruction ) .getVariable ( ) ; 
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
	 * @generated NOT
	 */
	public EList<Instruction> getInstructionsReferencingRole(Role referencedRole) {
		Set<Instruction> instructions = new LinkedHashSet<Instruction>();
		List<Instruction> usedInstructions = getInstructions();
		for (Instruction instruction : usedInstructions) {
			boolean isReferencingObject = isRoleReferencedByObject(referencedRole, instruction);
			if (isReferencingObject) {
				instructions.add(instruction);
			}
			TreeIterator<EObject> iterator = EcoreUtil.getAllContents(instruction, true);
			while (iterator.hasNext()) {
				EObject eObject = (EObject) iterator.next();
				isReferencingObject = isRoleReferencedByObject(referencedRole, eObject);
				if (isReferencingObject) {
					instructions.add(instruction);
				}
			}
		}
		return new BasicEList<Instruction>(instructions);
	}

	/**
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @generated NOT
	*/
	public boolean isRoleReferencedByObject(Role referencedRole, EObject eObject) {
		EClass metaclass = eObject.eClass();
		List<EReference> references = metaclass.getEAllReferences();
		for (EReference reference : references) {
			if (!reference.isContainment()) {
				EClassifier classifier = reference.getEType();
				if (classifier.isInstance(referencedRole)) {
					Object value = eObject.eGet(reference);
					if (value instanceof Role) {
						if (((Role) value).equals(referencedRole)) {
							return true;
						}
					} else if (value instanceof List<?>) {
						for (Role listObject : (List<Role>) value) {
							if (listObject.equals(referencedRole)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
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
			case RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS:
				return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RefactoringSpecificationImpl
