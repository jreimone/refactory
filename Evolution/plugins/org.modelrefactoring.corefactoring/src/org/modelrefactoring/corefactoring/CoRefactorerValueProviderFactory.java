package org.modelrefactoring.corefactoring;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.util.InverseableCopier;
import org.mvel2.MVEL;
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
		EObject dependentModel = dependentRefactorer.getOriginalModel();
		InverseableCopier copier = copyDependentModel(dependentModel);
		genericValueProvider.setInverseableCopier(copier);
		EObject dependentModelCopy = copier.get(dependentModel);
		List<EObject> dependentInputCopy = new ArrayList<EObject>();
		List<EObject> dependentInput = dependentRefactorer.getInput();
		for (EObject element : dependentInput) {
			dependentInputCopy.add(copier.get(element));
		}
		RoleMapping dependentRolemapping = dependentRefactorer.getRoleMapping();
		GenericBindingResolverFactory resolverFactory = new GenericBindingResolverFactory(initialRefactorer, dependentModelCopy, dependentRolemapping, dependentInputCopy);
		PropertyHandlerFactory.registerPropertyHandler(Object.class, resolverFactory.getGenericResolver());
		PropertyHandlerFactory.registerPropertyHandler(EObject.class, resolverFactory.getGenericResolver());
		Object result = MVEL.eval(bindingExpression, resolverFactory);
		System.out.println(result);
	}

	private InverseableCopier copyDependentModel(EObject dependentModel) {
		InverseableCopier copier = new InverseableCopier(false, true);
		copier.copy(dependentModel);
		copier.copyReferences();
		return copier;
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
