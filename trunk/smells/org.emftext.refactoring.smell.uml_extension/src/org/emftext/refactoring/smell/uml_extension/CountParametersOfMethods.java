package org.emftext.refactoring.smell.uml_extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.emftext.refactoring.smell.smell_model.ModelMetric;

public class CountParametersOfMethods extends EObjectImpl implements ModelMetric {
	
	private String name;
	private Float highNumberOfParameters = 10.0f;
	
	public CountParametersOfMethods(){
		setName("CountParametersOfMethods");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public Map<EObject, Float> calculate(Resource loadedResource) {
		Map<EObject, Float> map = new HashMap<EObject, Float>();
		Model model = null;
		Float f = 0.0f;
		if (loadedResource != null){
			if (loadedResource.getContents().size() > 0) {
				try {
					model = (Model) loadedResource.getContents().get(0);
				} catch (ClassCastException e){

				}
				if (model != null){
					for (Element e1 : model.allOwnedElements()){
						if (e1 instanceof Operation){
							f = (float) ((Operation) e1).getOwnedParameters().size();
							f = f/highNumberOfParameters;
							if (f > 1.0f){
								f = 1.0f;
							}
							map.put(e1, f);
						}
					}
				}
			}
		}
		return map;
	}

}
