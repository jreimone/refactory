/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.emftext.refactoring.valueprovider;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
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
	private RoleMapping mapping;
	private EAttribute attribute;
	private Object value;
	private int returnCode;

	private IRefactoringFakeInterpreter fakeInterpreter;
	private EAttribute fakeAttribute;
	private EObject fakeAttributeOwner;
	private EObject realAttributeOwner;
	private EAttribute realAttribute;

	public DialogAttributeValueProvider(RoleMapping mapping){
		super();
		this.mapping = mapping;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.internal.IAttributeValueProvider#provideAttributeValue(org.eclipse.emf.ecore.EAttribute)
	 */
	public Object provideValue(IRefactoringInterpreter interpreter, EAttribute attribute, Object... context) {
		if(interpreter instanceof IRefactoringFakeInterpreter){
			fakeInterpreter = (IRefactoringFakeInterpreter) interpreter;
			//			fakeInterpreter.addValueProvider(this);
			fakeAttribute = attribute;
			this.attribute = attribute;
			fakeAttributeOwner = (EObject) context[0];
//			String defaultLiteral = attribute.getDefaultValueLiteral();
//			Object defaultValue = attribute.getDefaultValue();
//			Object valueObject = convertValueIntoObject(attribute, defaultLiteral);
			//TODO better initial value possible?
			// because '1' is valid for all handled types in the method convertValueIntoObject()
			Object valueObject = convertValueIntoObject(attribute, "1");
			return valueObject;
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
		if(fakeAttributeOwner != null){
			realAttributeOwner = getInverseCopier().get(fakeAttributeOwner);
		}
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

	/**
	 * @return the fakeAttributeOwner
	 */
	public EObject getFakeAttributeOwner() {
		return fakeAttributeOwner;
	}
}
