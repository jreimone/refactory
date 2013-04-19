package org.emftext.refactoring.smell.registry;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.refactoring.smell.ConcreteQualitySmell;
import org.emftext.refactoring.smell.QualityCalculation;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationModel;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.registry.util.Pair;
import org.emftext.refactoring.smell.registry.util.Triple;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.google.common.collect.Lists;

public class BasicQualitySmellRegistry implements IQualitySmellRegistry {

	private QualitySmellModel smellModel;
	private CalculationModel calculationModel;

	protected BasicQualitySmellRegistry(){ }

	private void initQualitySmellModel() {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<QualitySmellModel,QualitySmellModel> tracker = new ServiceTracker<QualitySmellModel,QualitySmellModel>(bundleContext, QualitySmellModel.class, null);
		tracker.open();
		smellModel = tracker.getService();
	}

	private void initCalculationModel() {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceTracker<CalculationModel,CalculationModel> tracker = new ServiceTracker<CalculationModel,CalculationModel>(bundleContext, CalculationModel.class, null);
		tracker.open();
		calculationModel = tracker.getService();
	}

	@Override
	public QualitySmellModel getQualitySmellModel() {
		if(smellModel == null){
			initQualitySmellModel();
		}
		return smellModel;
	}

	@Override
	public CalculationModel getCalculationModel() {
		if(calculationModel == null){
			initCalculationModel();
		}
		return calculationModel;
	}


	@Override
	public List<Triple<CalculationResult, Calculation, QualityCalculation>> getMatchingSmellCalculationsForResource(Resource resource) {
		List<Triple<CalculationResult, Calculation, QualityCalculation>> matchingCalculations = Lists.newArrayList();
		List<Pair<Calculation,QualityCalculation>> calculations = getSmellCalculationsForResource(resource);
		for (EObject model : resource.getContents()) {
			for (Pair<Calculation, QualityCalculation> pair : calculations) {
				Calculation calculation = pair.getFirst();
				QualityCalculation qualityCalculation = pair.getSecond();
				float threshold = qualityCalculation.getThreshold();
				CalculationResult result = calculation.calculate(model, threshold);
				float resultingValue = result.getResultingValue();
				Monotonicity monotonicity = calculation.getMonotonicity();
				switch (monotonicity) {
				case DECREASING: 
					// je größer der wert desto schlechter die qualität 
					// --> smell trifft zu wenn result >= threshold
					if(resultingValue >= threshold){
						Triple<CalculationResult, Calculation, QualityCalculation> triple = new Triple<CalculationResult, Calculation, QualityCalculation>(result, calculation, qualityCalculation);
						matchingCalculations.add(triple);
					}
					break;
				case INCREASING: 
					// je größer der wert desto besser die qualität
					// --> smell trifft zu wenn result <= threshold
					if(resultingValue <= threshold){
						Triple<CalculationResult, Calculation, QualityCalculation> triple = new Triple<CalculationResult, Calculation, QualityCalculation>(result, calculation, qualityCalculation);
						matchingCalculations.add(triple);
					}
					break;
				}
			}
		}
		return matchingCalculations;
	}

	@Override
	public List<Pair<Calculation, QualityCalculation>> getSmellCalculationsForResource(Resource resource) {
		List<Pair<Calculation, QualityCalculation>> calculations = Lists.newArrayList();
		for (EObject model : resource.getContents()) {
			if(model != null){
				EPackage metamodel = model.eClass().getEPackage();
				List<ConcreteQualitySmell> smells = getQualitySmellModel().getSmellsForMetamodel(metamodel);
				for (ConcreteQualitySmell qualitySmell : smells) {
					List<QualityCalculation> qualityCalculations = qualitySmell.getQualityCalculations();
					for (QualityCalculation qualityCalculation : qualityCalculations) {
						Calculation calculation = qualityCalculation.getCalculation();
						if(calculation != null) {
							if(calculation.eIsProxy()){
								EcoreUtil.resolveAll(calculation);
								EcoreUtil.resolveAll(qualityCalculation);
								ResourceSet resourceSet = getCalculationModel().eResource().getResourceSet();
								calculation = (Calculation) EcoreUtil.resolve(calculation, resourceSet);
								calculation = (Calculation) EcoreUtil.resolve(calculation, getCalculationModel().eResource());
								//							Resource eResource = calculationModel.eResource();
								//							ResourceSet resourceSet2 = eResource.getResourceSet();
								//							Resource eResource2 = smellModel.eResource();
								//							ResourceSet resourceSet3 = eResource2.getResourceSet();
								//							EObject resolve = EcoreUtil.resolve(calculation, eResource2);
								//							EObject resolve2 = EcoreUtil.resolve(calculation, resourceSet3);
								//							System.out.println();
							} else {
								Pair<Calculation, QualityCalculation> pair = new Pair<Calculation, QualityCalculation>(calculation, qualityCalculation);
								calculations.add(pair);
							}
						}
					}
				}
			}
		}
		return calculations;
	}

	@Override
	public void initialize(QualitySmellModel smellModel, CalculationModel calculationModel) {
		if(smellModel != null){
			this.smellModel = smellModel;
		}
		if(calculationModel != null){
			this.calculationModel = calculationModel;
		}

	}

}
