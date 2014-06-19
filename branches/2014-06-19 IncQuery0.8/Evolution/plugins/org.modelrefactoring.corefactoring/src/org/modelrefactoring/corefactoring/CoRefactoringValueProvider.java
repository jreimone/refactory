package org.modelrefactoring.corefactoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.util.StringUtil;

public class CoRefactoringValueProvider extends AbstractValueProvider<EObject, Object> {

//	private InverseableCopier inverseableCopier;
//	private Map<EObject, EObject> inverse;

	private EStructuralFeature structuralFeature;

	private EStructuralFeature fakeFeature;
	private EObject fakeFeatureOwner;
	private EObject realFeatureOwner;
	private EStructuralFeature realFeature;

	@Override
	public Object provideValue(IRefactoringInterpreter interpreter, EObject from, Object... context) {
		if(interpreter instanceof IRefactoringFakeInterpreter){
			if(from instanceof EStructuralFeature){
				EStructuralFeature structuralFeature = (EStructuralFeature) from;
				fakeFeature = structuralFeature;
				this.structuralFeature = structuralFeature;
				fakeFeatureOwner = (EObject) context[0];
				Object valueObject = fakeFeature.getDefaultValue();
				if(valueObject == null){
					valueObject = "new" + StringUtil.firstLetterUpperCase(fakeFeature.getName()) + "For" + StringUtil.firstLetterUpperCase(fakeFeatureOwner.eClass().getName());
				}
				return valueObject;
			}
		} else {
			if(from instanceof EStructuralFeature){
				Object object = fakeFeatureOwner.eGet(fakeFeature);
				return object;
			}
			Object value = getValue();
			if(value != null){
				return value;
			} 
		}
		return null;
	}

	@Override
	public int getReturnCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void provideValue() {
		if(fakeFeatureOwner != null){
			realFeatureOwner = getInverseCopier().get(fakeFeatureOwner);
		}
		if(realFeatureOwner != null){
			realFeature = realFeatureOwner.eClass().getEStructuralFeature(fakeFeature.getName());
			structuralFeature = realFeature;
		}
	}

	@Override
	public Object getFakeObject() {
		return fakeFeature;
	}

	@Override
	public void propagateValueToFakeObject() {
		if(getValue() != null){
			fakeFeatureOwner.eSet(fakeFeature, getValue());
		}
	}

	@Override
	public void setValue(Object value) {
		if(structuralFeature instanceof EAttribute){
			EAttribute attribute = (EAttribute) structuralFeature;
			Object convertedValue = EcoreUtil.createFromString(attribute.getEAttributeType(), (String) value);
			super.setValue(convertedValue);
		} else {
			super.setValue(value);
		}
	}

//	public void setInverseableCopier(InverseableCopier copier) {
//		this.inverseableCopier = copier;
//		setCopier(copier);
//	}


}
