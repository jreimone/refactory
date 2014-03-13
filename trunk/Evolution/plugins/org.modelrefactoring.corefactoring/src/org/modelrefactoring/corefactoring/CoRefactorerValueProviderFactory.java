package org.modelrefactoring.corefactoring;

import java.util.Collections;
import java.util.HashMap;
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
	private Map<EObject, CoRefactoringValueProvider> valueProviderMap;
	
	private boolean bindingWasInterpreted = false;

	public CoRefactorerValueProviderFactory(IRefactorer initialRefactorer, IRefactorer dependentRefactorer, String bindingExpression) {
		this.initialRefactorer = initialRefactorer;
		this.dependentRefactorer = dependentRefactorer;
		this.bindingExpression = bindingExpression;
		valueProviderMap = new HashMap<EObject, CoRefactoringValueProvider>();
	}

	@Override
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		if(!bindingWasInterpreted){
			mvelInterpretation();
		}
		IValueProvider<?, ?> valueProvider = valueProviderMap.get(command);
		if(valueProvider == null){
			valueProvider = registerValueProviderForCommand(command, context);
		} 
		return valueProvider;
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
		if(command != null && valueProvider != null && valueProvider instanceof CoRefactoringValueProvider){
			valueProviderMap.put(command, (CoRefactoringValueProvider) valueProvider);
		}
	}

	@Override
	public IValueProvider<?, ?> registerValueProviderForCommand(EObject command, Object... context) {
		CoRefactoringValueProvider valueProvider = valueProviderMap.get(command);
		if(valueProvider == null){
			valueProvider = new CoRefactoringValueProvider();
			registerValueProviderForCommand(command, valueProvider);
		}
		return valueProvider;
	}

	@Override
	public List<IValueProvider<?, ?>> getValuesToProvide() {
		return Collections.emptyList();
	}

}
