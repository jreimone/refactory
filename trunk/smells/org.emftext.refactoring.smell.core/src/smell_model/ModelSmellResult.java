package smell_model;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ModelSmellResult {
	
	public void calculate(EList<Metric_Quality_Mapping> metric_quality, EList<Quality_ModelSmell_Mapping> quality_modelSmell, Map<Metric, Map<EObject, Float>> metricResultMapList, Map<Quality, Float> qualityScale);

	public Map<ModelSmell, Map<EObject, Float>> getResult();

	public void setResult(Map<ModelSmell, Map<EObject, Float>> result);

//	public Map<Metric, EObject> getMetricObjectMap();
//
//	public void setMetricObjectMap(Map<Metric, EObject> metricObjectMap);
//
//	public Map<ModelSmell, List<Metric>> getSmellMetricMap();
//
//	public void setSmellMetricMap(Map<ModelSmell, List<Metric>> smellMetricMap);

	public Float getThreshold();

}
