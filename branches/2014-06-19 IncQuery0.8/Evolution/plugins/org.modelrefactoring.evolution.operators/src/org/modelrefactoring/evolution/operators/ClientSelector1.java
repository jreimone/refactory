package org.modelrefactoring.evolution.operators;

import org.eclipse.emf.validation.model.IClientSelector;
import org.modelrefactoring.evolution.operators.Operator;

public class ClientSelector1 implements IClientSelector{

	@Override
	public boolean selects(Object object) {
		if(object instanceof Operator){
			return true;
		}
		return false;
	}

}
