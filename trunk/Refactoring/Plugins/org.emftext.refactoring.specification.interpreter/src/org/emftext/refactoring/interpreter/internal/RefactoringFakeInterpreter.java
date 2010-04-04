package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;

public class RefactoringFakeInterpreter extends RefactoringInterpreter implements IRefactoringFakeInterpreter {

	private IRefactoringInterpreter realInterpreter;
	
	private List<IValueProvider<?, ?>> valuesToProvide;
	
	private Map<EObject, IValueProvider<?, ?>> valueProviderMap;
	
	public RefactoringFakeInterpreter(IRefactoringInterpreter realInterpreter){
		super(realInterpreter.getPostProcessor());
		this.realInterpreter = realInterpreter;
		valueProviderMap = new LinkedHashMap<EObject, IValueProvider<?,?>>();
		initialize(realInterpreter.getRefactoringSpecification(), realInterpreter.getMapping());
		valuesToProvide = new LinkedList<IValueProvider<?,?>>();
	}
	
	public void addValueProvider(IValueProvider<?, ?> valueProvider) {
		valuesToProvide.add(valueProvider);
	}

	public List<IValueProvider<?, ?>> getValuesToProvide() {
		return valuesToProvide;
	}

	public IRefactoringInterpreter getRealInterpreter() {
		return realInterpreter;
	}

	@Override
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command) {
		return valueProviderMap.get(command);
	}

	@Override
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		valueProviderMap.put(command, valueProvider);
	}

	
	
//	public boolean didErrorsOccur() {
//		return realInterpreter.didErrorsOccur();
//	}
//
//	public IRefactoringFakeInterpreter getFakeInterpreter() {
//		return this;
//	}
//
//	public IRefactoringPostProcessor getPostProcessor() {
//		return realInterpreter.getPostProcessor();
//	}
//
//	public List<Resource> getResourcesToSave() {
//		return null;
//	}
//
//	public Map<Role, Object> getRoleRuntimeInstances() {
//		return realInterpreter.getRoleRuntimeInstances();
//	}
//
//	public IRefactoringStatus getStatus() {
//		return realInterpreter.getStatus();
//	}
//
//	public void initialize(RefactoringSpecification refSpec, Mapping mapping) {
//		realInterpreter.initialize(refSpec, mapping);
//	}
//
//	public EObject interprete(EObject model) {
//		return realInterpreter.interprete(model);
//	}
//
//	public void setInput(List<? extends EObject> currentSelection) {
//		realInterpreter.setInput(currentSelection);
//	}

}
