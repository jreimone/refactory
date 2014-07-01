package org.emftext.refactoring.smell.registry;

import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.calculation.CalculationModel;

/**
 * Interface which is used to initialize the quality smell model.
 * 
 * @author jreimann
 *
 */
public interface IQualitySmellModelInitializer {

	public QualitySmellModel getQualitySmellModel();
	
	public CalculationModel getCalculationModel();
	
	/**
	 * Initializes quality smell model and calculation model.
	 * 
	 */
	public void initialize();
}
