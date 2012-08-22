package org.emftext.refactoring.smell.extension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.smell.smell_model.Metric;



public class CountAttributes extends EObjectImpl implements Metric {
	
	private String name;

	public CountAttributes() {
		setName("CountAttributes");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Map<EObject, Float> calculate(Resource loadedResource) {
		Map<EObject, Float> map = new HashMap<EObject, Float>();
		Float f = 0.0f;
		EPackage epackage = (EPackage) loadedResource.getContents().get(0);
		List<EClassifier> classifiers = epackage.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			if(classifier instanceof EClass){
				f = (float) ((EClass) classifier).getEAllStructuralFeatures().size();
				map.put(classifier, f);
			}
		}
		return map;
	}

}