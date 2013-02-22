package org.emftext.refactoring.smell.registry;

/**
 * @author jreimann
 *
 */
public interface ICalculationExtensionPoint {

	public static final String ID						= "org.emftext.refactoring.smell.calculation.calculation";
	public static final String METRIC_CALCULATION		= "metricCalculation";
	public static final String STRUCTURE_CALCULATION	= "structureCalculation";
	public static final String CALCULATION_CLASS		= "class";
	public static final String PATTERN_RESOURCE			= "patternResource";
	public static final String PATTERN_NAME				= "patternName";
	public static final String PATTERN_DESCRIPTION		= "description";
	public static final String PATTERN_SMELL_MESSAGE	= "smellMessage";
}
