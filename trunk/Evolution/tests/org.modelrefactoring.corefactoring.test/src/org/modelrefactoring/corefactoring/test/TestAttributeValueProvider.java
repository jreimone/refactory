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
package org.modelrefactoring.corefactoring.test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IAttributeValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;


public class TestAttributeValueProvider extends AbstractValueProvider<EAttribute, Object> implements IAttributeValueProvider{

	private EAttribute attribute;
	private EObject fakeAttributeOwner;
	private EObject realAttributeOwner;
	private EAttribute fakeAttribute;
	private EAttribute realAttribute;
	private String value;
	
	public TestAttributeValueProvider(String value) {
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
		if(validValue != null){
			return true;
		}
		return false;
	}

	public Object getFakeObject() {
		return fakeAttribute;
	}

	public String getName() {
		return "";
	}

	public void propagateValueToFakeObject() {
		if(getValue() != null){
			fakeAttributeOwner.eSet(fakeAttribute, getValue());
		}
	}

	public Object provideValue(IRefactoringInterpreter interpreter, EAttribute from, Object... context) {
		if(interpreter instanceof IRefactoringFakeInterpreter){
			fakeAttribute = attribute;
			fakeAttributeOwner = (EObject) context[0];
		}
		attribute = from;
		setValue(value);
		return getValue();
	}
	
	private Object convertValueIntoObject(EAttribute attribute, String value){
		try{
			Object convertedValue = EcoreUtil.createFromString(attribute.getEAttributeType(), value);
			return convertedValue;
		} catch (Exception e) {
			return null;
		}
	}

	public void provideValue() {
		realAttributeOwner = getInverseCopier().get(fakeAttributeOwner);
		if(realAttributeOwner != null){
			realAttribute = (EAttribute) realAttributeOwner.eClass().getEStructuralFeature(fakeAttribute.getName());
			attribute = realAttribute;
		}
	}
	
	@Override
	public void setValue(Object value) {
		Object realValue = convertValueIntoObject(attribute, (String) value);
		super.setValue(realValue);
	}

	@Override
	public int getReturnCode() {
		return 0;
	}
}
