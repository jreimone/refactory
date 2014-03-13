package org.modelrefactoring.corefactoring;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.mvel2.MVEL;
import org.mvel2.integration.PropertyHandlerFactory;

public class CoRefactorerValueProviderFactory implements IValueProviderFactory {

	private String bindingExpression;
	private IRefactorer initialRefactorer;
	private IRefactorer dependentRefactorer;
	private CoRefactoringValueProvider genericValueProvider;
	
	private boolean bindingWasInterpreted = false;

	public CoRefactorerValueProviderFactory(IRefactorer initialRefactorer, IRefactorer dependentRefactorer, String bindingExpression) {
		this.initialRefactorer = initialRefactorer;
		this.dependentRefactorer = dependentRefactorer;
		this.genericValueProvider = new CoRefactoringValueProvider();
		this.bindingExpression = bindingExpression;
	}

	@Override
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		if(!bindingWasInterpreted){
			mvelInterpretation();
		}
		return genericValueProvider;
	}

	private void mvelInterpretation() {
		bindingWasInterpreted = true;
		dependentRefactorer.setValueProviderFactory(this);
		dependentRefactorer.fakeRefactor();
		EObject fakeRefactoredModel = dependentRefactorer.getFakeRefactoredModel();
		Map<Role, List<EObject>> roleRuntimeInstances = dependentRefactorer.getInterpreter().getFakeInterpreter().getRoleRuntimeInstances();
		RoleMapping dependentRolemapping = dependentRefactorer.getRoleMapping();
		GenericBindingResolverFactory resolverFactory = new GenericBindingResolverFactory(initialRefactorer, fakeRefactoredModel, dependentRolemapping, roleRuntimeInstances);
		PropertyHandlerFactory.disposeAll();
		PropertyHandlerFactory.registerPropertyHandler(Object.class, resolverFactory.getGenericResolver());
		PropertyHandlerFactory.registerPropertyHandler(EObject.class, resolverFactory.getGenericResolver());
		Object result = MVEL.eval(bindingExpression, resolverFactory);
		PropertyHandlerFactory.disposeAll();
		System.out.println(result);
	}

//	private InverseableCopier copyDependentModel(EObject dependentModel) {
//		InverseableCopier copier = new InverseableCopier(false, true);
//		copier.copy(dependentModel);
//		copier.copyReferences();
//		return copier;
//	}

	@Override
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		// we don't want to register new providers because we only need the generic one
	}

	@Override
	public IValueProvider<?, ?> registerValueProviderForCommand(EObject command, Object... context) {
		// we don't want to register new providers because we only need the generic one
		return null;
	}

	@Override
	public List<IValueProvider<?, ?>> getValuesToProvide() {
		return Collections.emptyList();
	}

}
