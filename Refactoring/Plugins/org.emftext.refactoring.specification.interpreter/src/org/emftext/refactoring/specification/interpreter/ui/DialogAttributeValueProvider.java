/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.util.StringUtil;

/**
 * @author Jan Reimann
 *
 */
public class DialogAttributeValueProvider extends AbstractValueProvider<EAttribute, Object> implements IAttributeValueProvider, IInputValidator {

	private static final String MESSAGE = "The following attribute has to be provided: \n%1$s:%2$s";
	private Mapping mapping;
	private EAttribute attribute;
	private Object value;
	private int returnCode;

	private IRefactoringFakeInterpreter fakeInterpreter;
	private EAttribute fakeAttribute;
	private EObject fakeAttributeOwner;
	private EObject realAttributeOwner;
	private EAttribute realAttribute;

	public DialogAttributeValueProvider(Mapping mapping){
		super();
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.internal.IAttributeValueProvider#provideAttributeValue(org.eclipse.emf.ecore.EAttribute)
	 */
	public Object provideValue(IRefactoringInterpreter interpreter, EAttribute attribute, Object... context) {
		if(interpreter instanceof IRefactoringFakeInterpreter){
			fakeInterpreter = (IRefactoringFakeInterpreter) interpreter;
			fakeInterpreter.addValueProvider(this);
			fakeAttribute = attribute;
			this.attribute = attribute;
			fakeAttributeOwner = (EObject) context[0];
			// because '1' is valid for all handled types in the method convertValueIntoObject()
			return convertValueIntoObject(attribute, "1");
		} else {
			Object value = getValue();
			if(value != null){
				return value;
			} else {
				this.attribute = attribute;
				setValue(openDialog());
				return getValue();
			}
		}
	}

	private Object openDialog() {
		InputDialog dialog = new InputDialog(Display.getDefault().getActiveShell()
				, StringUtil.convertCamelCaseToWords(mapping.getName())
				, String.format(MESSAGE, attribute.getName(), attribute.getEAttributeType().getInstanceClassName())
				, null
				, this);
		//		this.attribute = attribute;
		returnCode = dialog.open();
		if(returnCode  == InputDialog.CANCEL){
			return null;
		}
		value = convertValueIntoObject(attribute, dialog.getValue());
		return value;
	}

	private Object convertValueIntoObject(EAttribute attribute, String value){
		try{
			Object convertedValue = EcoreUtil.createFromString(attribute.getEAttributeType(), value);
			return convertedValue;
		} catch (Exception e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	public String isValid(String newText) {
		try {
			EcoreUtil.createFromString(attribute.getEAttributeType(), newText);
			return null;
		} catch (Exception e) {
			return "Value " + newText + " not applicable for attribute " + attribute.getName();
		}
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IValueProvider#getReturnCode()
	 */
	public int getReturnCode() {
		return returnCode;
	}

	public Object getFakeObject() {
		return  fakeAttribute;
	}

	public void provideValue() {		
		realAttributeOwner = getInverseCopier().get(fakeAttributeOwner);
		if(realAttributeOwner != null){
			realAttribute = (EAttribute) realAttributeOwner.eClass().getEStructuralFeature(fakeAttribute.getName());
			attribute = realAttribute;
		}
	}

	public String getName() {
		return "";
	}

	public EAttribute getAttribute() {
		return attribute;
	}

	public EObject getAttributeOwner() {
		return realAttributeOwner;
	}

	public void propagateValueToFakeObject() {
		if(getValue() != null){
			fakeAttributeOwner.eSet(fakeAttribute, getValue());
		}
	}

	public boolean isValueValid(String text) {
		EAttribute attribute = getAttribute();
		Object validValue = convertValueIntoObject(attribute, text);
		if(validValue != null){
			return true;
		}
		return false;
	}

	@Override
	public void setValue(Object value) {
		Object realValue = convertValueIntoObject(attribute, (String) value);
		super.setValue(realValue);
	}
}
