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
import org.emftext.refactoring.smell.smell_model.ModelMetric;



public class CountAttributes extends EObjectImpl implements ModelMetric {
	
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
		EPackage epackage = null;
		if (loadedResource.getContents().get(0) instanceof org.eclipse.gmf.runtime.notation.impl.DiagramImpl){
			epackage = (EPackage) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) loadedResource.getContents().get(0)).getElement();
		} else {
			epackage = (EPackage) loadedResource.getContents().get(0);
		}
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