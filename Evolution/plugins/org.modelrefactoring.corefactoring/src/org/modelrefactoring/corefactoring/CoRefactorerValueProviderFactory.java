package org.modelrefactoring.corefactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
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
		Map<Role, List<EObject>> roleBindings = dependentRefactorer.getInterpreter().getFakeInterpreter().getRoleBindings();
		RoleMapping dependentRolemapping = dependentRefactorer.getRoleMapping();
		fixRoleBindings(fakeRefactoredModel, dependentRolemapping, roleBindings);
		GenericBindingResolverFactory resolverFactory = new GenericBindingResolverFactory(initialRefactorer, fakeRefactoredModel, dependentRolemapping, roleBindings);
		PropertyHandlerFactory.disposeAll();
		PropertyHandlerFactory.registerPropertyHandler(Object.class, resolverFactory.getGenericResolver());
		PropertyHandlerFactory.registerPropertyHandler(EObject.class, resolverFactory.getGenericResolver());
		Object result = MVEL.eval(bindingExpression, resolverFactory);
		PropertyHandlerFactory.disposeAll();
		System.out.println(result);
	}

	// TODO: investigate why this hack is needed at all!!!
	// aus irgendeinem Grund enthält das RoleBinding der Rolle 'NewFeature' beim co-refactoren von Ecore 'Replace Data Value with Object'
	// 2 Elemente: zwei EReferences, eine mit null als Namen und die andere korrekt benannt nach fake-Interpretation
	// nach fake run muss aber alles gebunden sein mit default Werten, null darf gar nicht auftreten
	// also schauen, warum überhaupt 2 Elemente in dieser Liste erscheinen
	private void fixRoleBindings(EObject model, RoleMapping rolemapping, Map<Role, List<EObject>> roleBindings) {
		List<ConcreteMapping> mappings = rolemapping.getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : mappings) {
			Role role = concreteMapping.getRole();
			// check the role
			List<EObject> boundElements = null;
			if(roleBindings.containsKey(role)){
				boundElements = roleBindings.get(role);
				if(boundElements == null){
					roleBindings.remove(role);
				}
			}
			// and now the role attribute
			if(boundElements != null){
				List<EObject> elementsToRemove = new ArrayList<EObject>();
				List<AttributeMapping> attributeMappings = concreteMapping.getAttributeMappings();
				for (EObject boundElement : boundElements) {
					for (AttributeMapping attributeMapping : attributeMappings) {
						EAttribute attribute = attributeMapping.getClassAttribute();
						Object attributeValue = boundElement.eGet(attribute);
						if(attributeValue == null){ 
							// something went wrong, after fake interpretation all roles and attributes must be bound
							// so remove the binding and the structural feature
							elementsToRemove.add(boundElement);
							EcoreUtil.remove(boundElement);
						}
					}
				}
				boundElements.removeAll(elementsToRemove);
			}
		}
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
