package org.emftext.refactoring.continued_testing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;

public class TestValueProviderFactory implements IValueProviderFactory {

	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		return new TestAttributeValueProvider();
	}

	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		// TODO Auto-generated method stub

	}

	public void registerValueProviderForCommand(EObject command) {
		
	}

	public List<IValueProvider<?, ?>> getValuesToProvide() {
		// TODO Auto-generated method stub
		return null;
	}

}
