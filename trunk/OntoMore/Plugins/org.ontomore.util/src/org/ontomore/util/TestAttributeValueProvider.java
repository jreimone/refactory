package org.ontomore.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;

/**
 * Value Provider used in tests to programmatically set the input value of a
 * refactoring. It shouldn't be set in the ASSIGNInterpreter if the user should
 * give the input value through a dialogue.
 * 
 * @author Erik Tittel
 */
public class TestAttributeValueProvider extends AbstractValueProvider<EAttribute, Object> implements IAttributeValueProvider {

	private EAttribute attribute;
	private EObject fakeAttributeOwner;
	private EObject realAttributeOwner;
	private EAttribute fakeAttribute;
	private EAttribute realAttribute;

	private Object value;

	public TestAttributeValueProvider(Object value){
		this.value = value;
	}
	
	public EAttribute getAttribute() {
		return attribute;
	}

	public EObject getAttributeOwner() {
		return realAttributeOwner;
	}

	public EObject getFakeAttributeOwner() {
		return fakeAttributeOwner;
	}

	public boolean isValueValid(String text) {
		EAttribute attribute = getAttribute();
		Object validValue = convertValueIntoObject(attribute, text);
		if (validValue != null) {
			return true;
		}
		return false;
	}

	public Object getFakeObject() {
		return fakeAttribute;
	}

	public String getName() {
		return "Simple Attribute Value Provider";
	}

	public int getReturnCode() {
		return 0;
	}

	public void propagateValueToFakeObject() {
		if (getValue() != null) {
			fakeAttributeOwner.eSet(fakeAttribute, getValue());
		}
	}

	public Object provideValue(IRefactoringInterpreter interpreter, EAttribute from, Object... context) {
		if (interpreter instanceof IRefactoringFakeInterpreter) {
			IRefactoringFakeInterpreter fakeInterpreter = (IRefactoringFakeInterpreter) interpreter;
			fakeInterpreter.setValueProviderFactory(new TestValueProviderFactory(this));
			fakeAttribute = attribute;
			fakeAttributeOwner = (EObject) context[0];
		}
		attribute = from;
		setValue(value);
		return getValue();
	}

	private Object convertValueIntoObject(EAttribute attribute, String value) {
		try {
			Object convertedValue = EcoreUtil
					.createFromString(attribute.getEAttributeType(), value);
			return convertedValue;
		} catch (Exception e) {
			return null;
		}
	}

	public void provideValue() {
		realAttributeOwner = getInverseCopier().get(fakeAttributeOwner);
		if (realAttributeOwner != null) {
			realAttribute = (EAttribute) realAttributeOwner.eClass().getEStructuralFeature(
					fakeAttribute.getName());
			attribute = realAttribute;
		}
	}

	@Override
	public void setValue(Object value) {
		Object realValue = convertValueIntoObject(attribute, (String) value);
		super.setValue(realValue);
	}
}
