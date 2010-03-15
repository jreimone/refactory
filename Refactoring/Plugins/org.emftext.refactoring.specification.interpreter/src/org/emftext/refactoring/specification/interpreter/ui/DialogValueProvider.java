/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.util.StringUtil;

/**
 * @author Jan Reimann
 *
 */
public class DialogValueProvider implements IAttributeValueProvider, IInputValidator {

	private static final String MESSAGE = "The following attribute has to be provided: \n%1$s:%2$s";
	private Mapping mapping;
	private EAttribute attribute;
	private Object value;

	public DialogValueProvider(Mapping mapping){
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.internal.IAttributeValueProvider#provideAttributeValue(org.eclipse.emf.ecore.EAttribute)
	 */
	public Object provideAttributeValue(EAttribute attribute) {
		InputDialog dialog = new InputDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()
				, StringUtil.convertCamelCaseToWords(mapping.getName())
				, String.format(MESSAGE, attribute.getName(), attribute.getEAttributeType().getInstanceClassName())
				, null
				, this);
		this.attribute = attribute;
		int returnCode = dialog.open();
		while (returnCode == InputDialog.CANCEL) {
			returnCode = dialog.open();
		}
		value = convertValueIntoObject(dialog.getValue());
		return value;
	}

	private Object convertValueIntoObject(String value){
		if(attribute.getEAttributeType().getInstanceClass().equals(Integer.class)){
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				return "the given value must be of type Integer";
			}
		}
		if(attribute.getEAttributeType().getInstanceClass().equals(Boolean.class)){
			try {
				return Boolean.parseBoolean(value);
			} catch (Exception e) {
				return "the given value must be of type Boolean";
			}
		}
		if(attribute.getEAttributeType().getInstanceClass().equals(Double.class)){
			try {
				return Double.parseDouble(value);
			} catch (Exception e) {
				return "the given value must be of type Double";
			}
		}
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	public String isValid(String newText) {
		if(attribute.getEAttributeType().getInstanceClass().equals(Integer.class)){
			try {
				Integer.parseInt(newText);
			} catch (Exception e) {
				return "the given value must be of type Integer";
			}
		}
		if(attribute.getEAttributeType().getInstanceClass().equals(Boolean.class)){
			try {
				Boolean.parseBoolean(newText);
			} catch (Exception e) {
				return "the given value must be of type Boolean";
			}
		}
		if(attribute.getEAttributeType().getInstanceClass().equals(Double.class)){
			try {
				Double.parseDouble(newText);
			} catch (Exception e) {
				return "the given value must be of type Double";
			}
		}
		return null;
	}
}
