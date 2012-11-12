package org.qualitune.evolution.cods.creation;

/**
 * @author jreimann
 *
 */
public interface MegaModelChangeSubject {
	
	public void registerObserver(MegaModelChangeObserver observer, int kind);

}
