package org.modelrefactoring.evolution.cods.creation;

/**
 * @author jreimann
 *
 */
public interface MegaModelChangeSubject {
	
	public void registerObserver(MegaModelChangeObserver observer, int kind);

}
