package org.modelrefactoring.corefactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.integration.PropertyHandlerFactory;

public class CoRefactorerValueProviderFactory implements IValueProviderFactory {

	private String bindingExpression;
	private IRefactorer initialRefactorer;
	private IRefactorer dependentRefactorer;
	private CoRefactoringValueProvider genericValueProvider;

	public CoRefactorerValueProviderFactory(IRefactorer initialRefactorer, IRefactorer dependentRefactorer, String bindingExpression) {
		this.initialRefactorer = initialRefactorer;
		this.dependentRefactorer = dependentRefactorer;
		this.genericValueProvider = new CoRefactoringValueProvider();
		this.bindingExpression = bindingExpression;
		mvelInterpretation();
	}

	@Override
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		return genericValueProvider;
	}

	private void mvelInterpretation() {
		ParserContext parserContext = ParserContext.create();
		GenericBindingResolverFactory resolverFactory = new GenericBindingResolverFactory(initialRefactorer, dependentRefactorer, genericValueProvider);
		PropertyHandlerFactory.registerPropertyHandler(Object.class, resolverFactory.getGenericResolver());
		PropertyHandlerFactory.registerPropertyHandler(EObject.class, resolverFactory.getGenericResolver());
		Object result = MVEL.eval(bindingExpression, resolverFactory);
		System.out.println(result);
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
