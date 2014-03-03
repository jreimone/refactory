package org.ontomore.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;

public class TestValueProviderFactory implements IValueProviderFactory {

	private TestAttributeValueProvider valueProvider;

	public TestValueProviderFactory(TestAttributeValueProvider valueProvider) {
		this.valueProvider = valueProvider;
	}

	@Override
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		return valueProvider;
	}

	@Override
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		// nothing
	}

	@Override
	public IValueProvider<?, ?> registerValueProviderForCommand(EObject command, Object... context) {
		// nothing
		return null;
	}

	@Override
	public List<IValueProvider<?, ?>> getValuesToProvide() {
		// nothing
		return null;
	}

}
