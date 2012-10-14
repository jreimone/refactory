package org.emftext.refactoring.smell.uml_extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.emftext.refactoring.smell.smell_model.ModelMetric;

public class SearchEmptyClassesAndInterfaces extends EObjectImpl implements ModelMetric {
	
private String name;
	
	public SearchEmptyClassesAndInterfaces(){
		setName("SearchEmptyClassesAndInterfaces");
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
		if (loadedResource != null){
			if (loadedResource.getContents().size() > 0) {
				try {
					model = (Model) loadedResource.getContents().get(0);
				} catch (ClassCastException e){

				}
				if (model != null){
					for (Element e1 : model.allOwnedElements()){
						if (e1 instanceof Class){
							if (((Class) e1).getAllAttributes().isEmpty() && ((Class) e1).getAllOperations().isEmpty())
							map.put(e1, 1.0f);
						}
						if (e1 instanceof Interface){
							if (((Interface) e1).getAllAttributes().isEmpty() && ((Interface) e1).getAllOperations().isEmpty())
							map.put(e1, 1.0f);
						}
					}
				}
			}
		}
		return map;
	}

}
