/**
 * 
 */
package org.emftext.refactoring.specification.interpreter.ui;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.util.StringUtil;

/**
 * @author Jan Reimann
 *
 */
public class DialogAttributeValueProvider implements IValueProvider<EAttribute, Object>, IInputValidator {

	private static final String MESSAGE = "The following attribute has to be provided: \n%1$s:%2$s";
	private Mapping mapping;
	private EAttribute attribute;
	private Object value;
	private int returnCode;
	
	private IRefactoringFakeInterpreter fakeInterpreter;
	private EAttribute fakeAttribute;
	private EObject fakeAttributeOwner;
	private EAttribute realAttribute;

	public DialogAttributeValueProvider(Mapping mapping){
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
			if(value != null){
				return value;
			} else {
				this.attribute = attribute;
				return openDialog();
			}
		}
	}

	private Object openDialog() {
		InputDialog dialog = new InputDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()
				, StringUtil.convertCamelCaseToWords(mapping.getName())
				, String.format(MESSAGE, attribute.getName(), attribute.getEAttributeType().getInstanceClassName())
				, null
				, this);
//		this.attribute = attribute;
		returnCode = dialog.open();
		if(returnCode  == InputDialog.CANCEL){
			return null;
		}
		return convertValueIntoObject(attribute, dialog.getValue());
	}

	private Object convertValueIntoObject(EAttribute attribute, String value){
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

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IValueProvider#getReturnCode()
	 */
	public int getReturnCode() {
		return returnCode;
	}

	public Object getFakeObject() {
		return  fakeAttribute;
	}

	public void provideValue(Map<EObject, EObject> inverseCopier) {		
//		EStructuralFeature feature = fakeAttribute;
//		EObject owner = feature.eContainer();
//		EObject realOwner = copier.get(owner);
//		EAttribute realAttribute1 = (EAttribute) realOwner.eClass().getEStructuralFeature(feature.getName());
//		EAttribute realAttribute2 = (EAttribute) copier.get(fakeAttribute);
//		realAttribute = realAttribute1;
		value = openDialog();
	}
}
