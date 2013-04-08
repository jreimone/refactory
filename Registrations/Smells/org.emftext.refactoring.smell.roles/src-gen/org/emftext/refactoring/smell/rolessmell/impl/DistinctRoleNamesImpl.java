/**
 */
package org.emftext.refactoring.smell.rolessmell.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

import org.emftext.refactoring.smell.rolessmell.DistinctRoleNames;
import org.emftext.refactoring.smell.rolessmell.RolessmellPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distinct Role Names</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DistinctRoleNamesImpl extends MetricImpl implements DistinctRoleNames {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctRoleNamesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolessmellPackage.Literals.DISTINCT_ROLE_NAMES;
	}

	@Override
	public CalculationResult calculate(EObject model, float threshold) {
		CalculationResult calculationResult = CalculationFactory.eINSTANCE.createCalculationResult();
		if(model instanceof RoleModel){
			RoleModel roleModel = (RoleModel) model;
			List<Role> roles = roleModel.getRoles();
			Map<String, List<Role>> rolesMap = new HashMap<String, List<Role>>();
			for (Role role : roles) {
				List<Role> list = rolesMap.get(role.getName());
				if(list == null){
					list = new ArrayList<Role>();
					rolesMap.put(role.getName(), list);
				}
				list.add(role);
			}
			for (List<Role> sameNamedRoles : rolesMap.values()) {
				if(sameNamedRoles.size() > 1){
					calculationResult.getCausingObjects().addAll(sameNamedRoles);
				}
			}
			calculationResult.setResultingValue(calculationResult.getCausingObjects().size());
		}
		return calculationResult;
	}
	
	@Override
	public String getName() {
		return "Distinct Role Names";
	}
	
	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines all Roles having the same name.";
	}

	@Override
	public String getSmellMessage() {
		return "This Role name is not unique.";
	}

} //DistinctRoleNamesImpl
