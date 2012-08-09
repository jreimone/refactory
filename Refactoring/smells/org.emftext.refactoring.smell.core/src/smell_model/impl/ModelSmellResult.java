package smell_model.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import smell_model.Metric;
import smell_model.Metric_Quality_Mapping;
import smell_model.ModelSmell;
import smell_model.Quality;
import smell_model.Quality_ModelSmell_Mapping;

public class ModelSmellResult {
	
	private EList<Tuple<ModelSmell, Float>> result;
	private Map<Metric, EObject> metricObjectMap;
	private Map<ModelSmell, Metric> smellMetricMap;

	public ModelSmellResult(){
		setResult(new BasicEList<Tuple<ModelSmell, Float>>());
		setMetricObjectMap(new HashMap<Metric, EObject>());
		setSmellMetricMap(new HashMap<ModelSmell, Metric>());
	}
	
	public ModelSmellResult(EList<Tuple<ModelSmell, Float>> result, Map<Metric, EObject> metricObjectMap, Map<ModelSmell, Metric> smellMetricMap){
		setResult(result);
		setMetricObjectMap(metricObjectMap);
		setSmellMetricMap(smellMetricMap);
	}
	
	public void calculate(EList<Metric_Quality_Mapping> metric_quality, EList<Quality_ModelSmell_Mapping> quality_modelSmell, Map<Metric, Map<EObject, Float>> metricResultMapList, Map<Quality, Float> qualityScale){
		for (Metric m : metricResultMapList.keySet()){
			for (EObject o : metricResultMapList.get(m).keySet()){
				metricObjectMap.put(m, o);
			}
		}
		for (Quality_ModelSmell_Mapping qmm : quality_modelSmell){
			for (Metric_Quality_Mapping mqm : metric_quality){
				if (qmm.getQuality().equals(mqm.getQuality())){
					smellMetricMap.put(qmm.getModelSmell(), mqm.getMetric());
					Float tempFloat = 0.0f;
					for (Float f : metricResultMapList.get(mqm.getMetric()).values()){
						tempFloat += f * mqm.getFactor() * qualityScale.get(mqm.getQuality()) * qmm.getFactor();
					}
					Tuple<ModelSmell, Float> tempTuple = new Tuple<ModelSmell, Float>(qmm.getModelSmell(), tempFloat);
					for (Tuple<ModelSmell, Float> t : result){
						if (t.getFirst().equals(tempTuple.getFirst())){
							Float f = tempTuple.getSecond();
							tempTuple.setSecond(f + t.getSecond());
						}
					}
					result.add(tempTuple);
				}
			}
		}
	}

	public EList<Tuple<ModelSmell, Float>> getResult() {
		return result;
	}

	public void setResult(EList<Tuple<ModelSmell, Float>> result) {
		this.result = result;
	}

	public Map<Metric, EObject> getMetricObjectMap() {
		return metricObjectMap;
	}

	public void setMetricObjectMap(Map<Metric, EObject> metricObjectMap) {
		this.metricObjectMap = metricObjectMap;
	}

	public Map<ModelSmell, Metric> getSmellMetricMap() {
		return smellMetricMap;
	}

	public void setSmellMetricMap(Map<ModelSmell, Metric> smellMetricMap) {
		this.smellMetricMap = smellMetricMap;
	}
}
