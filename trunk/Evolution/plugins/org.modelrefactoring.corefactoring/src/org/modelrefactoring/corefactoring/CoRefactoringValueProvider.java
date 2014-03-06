package org.modelrefactoring.corefactoring;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.refactoring.interpreter.AbstractValueProvider;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.util.InverseableCopier;

public class CoRefactoringValueProvider extends AbstractValueProvider<EObject, Object> {

	private InverseableCopier inverseableCopier;
	private Map<EObject, EObject> inverse;

	@Override
	public Object provideValue(IRefactoringInterpreter interpreter, EObject from, Object... context) {
		if(inverse == null){
			inverse = inverseableCopier.getInverse();
		}
		EObject element = (EObject) context[0];
		EObject elementCopy = inverseableCopier.get(element);
		if(from instanceof EStructuralFeature){
			Object value = elementCopy.eGet((EStructuralFeature) from);
			return value;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getFakeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void propagateValueToFakeObject() {
		// TODO Auto-generated method stub
		
	}

	public void setInverseableCopier(InverseableCopier copier) {
		this.inverseableCopier = copier;
		setCopier(copier);
	}


}
