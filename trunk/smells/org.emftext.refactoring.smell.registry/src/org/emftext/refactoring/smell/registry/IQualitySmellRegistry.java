package org.emftext.refactoring.smell.registry;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.registry.util.Pair;
import org.emftext.refactoring.smell.registry.util.Triple;

public interface IQualitySmellRegistry {
	
	public static IQualitySmellRegistry INSTANCE = new BasicQualitySmellRegistry();
	
	/**
	 * Initializes the registry with the given models. If this method is not invoked
	 * the default returned {@value #INSTANCE} {@link #INSTANCE} is initialized by trying
	 * to look if the particular models were registered as OSGi services.
	 * 
	 * @param smellModel
	 * @param calculationModel
	 */
	public void initialize(QualitySmellModel smellModel, CalculationModel calculationModel);
	
	/**
	 * Returns the constructed smell model.
	 * @return
	 */
	public QualitySmellModel getQualitySmellModel();
	
	/**
	 * Returns the calculation model containing registered calculations.
	 * @return
	 */
	public CalculationModel getCalculationModel();

	/**
	 * For the given <code>resource</code> all registered smells are calculated. Those fulfilling
	 * the treshold and monotonicity are returned in the resulting list.
	 * Each element of the list is a {@link Triple} consisting of:<br><br>
	 * <li>{@link CalculationResult}: being the result of {@link Calculation#calculate(org.eclipse.emf.ecore.EObject, float)}</li>
	 * <li>{@link Calculation}: the calculation which produced a matching {@link CalculationResult}</li>
	 * <li>{@link QualityCalculation}: which references the calculation</li>
	 * <br><br>Uses {@link #getSmellCalculationsForResource(Resource)} to get all calculations which then are filtered and 
	 * only the matching calculations are returned. 
	 * 
	 * @param resource
	 * @return
	 * @see #getSmellCalculationsForResource(Resource)
	 */
	public List<Triple<CalculationResult, Calculation, QualityCalculation>> getMatchingSmellCalculationsForResource(Resource resource);
	
	/**
	 * For the given <code>resource</code> all registered smells are returned. Those fulfilling
	 * Each element of the list is a {@link Pair} consisting of:<br><br>
	 * <li>{@link Calculation}: the calculation which produced a matching {@link CalculationResult}</li>
	 * <li>{@link QualityCalculation}: which references the calculation</li>
	 * 
	 * @param resource
	 * @return
	 * @see #getMatchingSmellCalculationsForResource(Resource)
	 */
	public List<Pair<Calculation, QualityCalculation>> getSmellCalculationsForResource(Resource resource);
}
