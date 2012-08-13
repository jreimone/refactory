package smell_model.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import smell_model.Metric;
import smell_model.Metric_Quality_Mapping;
import smell_model.ModelSmell;
import smell_model.ModelSmellResult;
import smell_model.Quality;
import smell_model.Quality_ModelSmell_Mapping;

public class ModelSmellResultImpl implements ModelSmellResult{
	
	private final Float threshold = 0.5f;
	private Map<ModelSmell, Map<EObject, Float>> result;
//	private Map<Metric, EObject> metricObjectMap;
//	private Map<ModelSmell, List<Metric>> smellMetricMap;

	public ModelSmellResultImpl(){
		setResult(new HashMap<ModelSmell, Map<EObject, Float>>());
//		setMetricObjectMap(new HashMap<Metric, EObject>());
//		setSmellMetricMap(new HashMap<ModelSmell, List<Metric>>());
	}
	
	public void calculate(EList<Metric_Quality_Mapping> metric_quality, EList<Quality_ModelSmell_Mapping> quality_modelSmell, Map<Metric, Map<EObject, Float>> metricResultMapList, Map<Quality, Float> qualityScale){
//		for (Metric m : metricResultMapList.keySet()){
//			for (EObject o : metricResultMapList.get(m).keySet()){
//				metricObjectMap.put(m, o);
//			}
//		}
		for (Quality_ModelSmell_Mapping qmm : quality_modelSmell){
			for (Metric_Quality_Mapping mqm : metric_quality){
				if (qmm.getQuality().equals(mqm.getQuality())){
//					List<Metric> tempList = smellMetricMap.get(qmm.getModelSmell());
//					tempList.add(mqm.getMetric());
//					smellMetricMap.put(qmm.getModelSmell(), tempList);
					Float tempFloat = 0.0f;
					ModelSmell tempModelSmell = qmm.getModelSmell();
					Map<EObject, Float> tempMap = new HashMap<EObject, Float>();
					for (EObject o : metricResultMapList.get(mqm.getMetric()).keySet()){
						tempFloat = mqm.getFactor() * qualityScale.get(mqm.getQuality()) * qmm.getFactor();
						if (result.get(tempModelSmell).containsKey(o)){
							Float t = result.get(tempModelSmell).get(o) + tempFloat;
							tempMap.put(o, t);
							result.put(tempModelSmell, tempMap);
						} else {
							tempMap.put(o, tempFloat);
							result.put(tempModelSmell, tempMap);
						}
					}
				}
			}
		}
	}

	public Map<ModelSmell, Map<EObject, Float>> getResult() {
		return result;
	}

	public void setResult(Map<ModelSmell, Map<EObject, Float>> result) {
		this.result = result;
	}

//	public Map<Metric, EObject> getMetricObjectMap() {
//		return metricObjectMap;
//	}
//
//	public void setMetricObjectMap(Map<Metric, EObject> metricObjectMap) {
//		this.metricObjectMap = metricObjectMap;
//	}
//
//	public Map<ModelSmell, List<Metric>> getSmellMetricMap() {
//		return smellMetricMap;
//	}
//
//	public void setSmellMetricMap(Map<ModelSmell, List<Metric>> smellMetricMap) {
//		this.smellMetricMap = smellMetricMap;
//	}

	public Float getThreshold() {
		return threshold;
	}
}
