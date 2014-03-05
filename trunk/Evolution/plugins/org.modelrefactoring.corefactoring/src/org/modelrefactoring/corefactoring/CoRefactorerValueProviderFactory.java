package org.modelrefactoring.corefactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;

public class CoRefactorerValueProviderFactory implements IValueProviderFactory {

	private String binding;
	private Map<Role, List<EObject>> roleBindings;
	private RoleMapping initialRoleMapping;
	private RoleMapping dependentRoleMapping;
	private EObject dependentModel;

	public CoRefactorerValueProviderFactory(Map<Role, List<EObject>> roleBindings, RoleMapping initialRoleMapping, RoleMapping dependentRoleMapping, EObject dependentModel, String binding){
		this.roleBindings = roleBindings;
		this.initialRoleMapping = initialRoleMapping;
		this.dependentRoleMapping = dependentRoleMapping;
		this.dependentModel = dependentModel;
		this.binding = binding;
	}
	
	@Override
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		mvelInterpretation();
		return null;
	}

	private void mvelInterpretation() {
		
	}

	@Override
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		// TODO Auto-generated method stub

	}

	@Override
	public IValueProvider<?, ?> registerValueProviderForCommand(EObject command, Object... context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IValueProvider<?, ?>> getValuesToProvide() {
		// TODO Auto-generated method stub
		return null;
	}

}
