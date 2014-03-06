package org.modelrefactoring.corefactoring;

import org.emftext.refactoring.interpreter.IRefactorer;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.impl.BaseVariableResolverFactory;

public class GenericBindingResolverFactory extends BaseVariableResolverFactory {

	private static final long serialVersionUID = 8406088059690087658L;

	private GenericBindingResolver genericResolver;

	private IRefactorer initialRefactorer;
	private IRefactorer dependentRefactorer;

	private CoRefactoringValueProvider genericValueProvider;

	public GenericBindingResolverFactory(IRefactorer initialRefactorer, IRefactorer dependentRefactorer, CoRefactoringValueProvider genericValueProvider) {
		this.genericValueProvider = genericValueProvider;
		this.genericResolver = new GenericBindingResolver(initialRefactorer, dependentRefactorer, genericValueProvider);
		this.initialRefactorer = initialRefactorer;
		this.dependentRefactorer = dependentRefactorer;
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
