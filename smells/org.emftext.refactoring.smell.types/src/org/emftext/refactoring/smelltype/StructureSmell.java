package org.emftext.refactoring.smelltype;

import org.emftext.refactoring.smelltype.impl.SmellTypeImpl;

/**
 * @author jreimann
 *
 */
public class StructureSmell extends SmellTypeImpl{

	@Override
	public float getLowerBound() {
		return 0;
	}

	@Override
	public float getUpperBound() {
		return 1;
	}

	@Override
	public float getIncrement() {
		return 1;
	}

	@Override
	public String getName() {
		return "StructureSmell";
	}

}
