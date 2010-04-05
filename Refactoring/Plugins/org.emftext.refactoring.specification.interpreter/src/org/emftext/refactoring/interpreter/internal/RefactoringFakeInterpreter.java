package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedList;
import java.util.List;

import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;

public class RefactoringFakeInterpreter extends RefactoringInterpreter implements IRefactoringFakeInterpreter {

	private IRefactoringInterpreter realInterpreter;
	
	private List<IValueProvider<?, ?>> valuesToProvide;
	
//	private Map<EObject, IValueProvider<?, ?>> valueProviderMap;
	
	public RefactoringFakeInterpreter(IRefactoringInterpreter realInterpreter){
		super(realInterpreter.getPostProcessor());
		this.realInterpreter = realInterpreter;
//		valueProviderMap = new LinkedHashMap<EObject, IValueProvider<?,?>>();
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
	public IRefactoringFakeInterpreter getFakeInterpreter() {
		return this;
	}

	public void setProvideableValues(List<IValueProvider<?, ?>> provideableValues) {
		valuesToProvide = provideableValues;
	}

}
