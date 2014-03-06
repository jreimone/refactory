package org.modelrefactoring.corefactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.impl.BaseVariableResolverFactory;

public class GenericBindingResolverFactory extends BaseVariableResolverFactory {

	private static final long serialVersionUID = 8406088059690087658L;

	private GenericBindingResolver genericResolver;

	public GenericBindingResolverFactory(IRefactorer initialRefactorer, EObject dependentModel, RoleMapping dependentRoleMapping, List<EObject> dependentInput) {
		this.genericResolver = new GenericBindingResolver(initialRefactorer, dependentModel, dependentRoleMapping, dependentInput);
	}

	@Override
	public VariableResolver createVariable(String varName, Object value) {
		genericResolver.addVariable(varName, value);
		return genericResolver;
	}

	@Override
	public VariableResolver createVariable(String arg0, Object arg1, Class<?> arg2) {
		System.out.println();
		return null;
	}

	@Override
	public boolean isResolveable(String varName) {
		return genericResolver.isResolvable(varName);
	}

	@Override
	public VariableResolver getVariableResolver(String name) {
		if(Util.IN.equals(name) || Util.OUT.equals(name)){
			genericResolver.setVariableNameToResolve(name);
			return genericResolver;
		}
		return isResolveable(name) ? genericResolver : super.getVariableResolver(name); 
	}

	@Override
	public boolean isTarget(String arg0) {
		System.out.println();
		return false;
	}

	public GenericBindingResolver getGenericResolver() {
		return genericResolver;
	}

}
