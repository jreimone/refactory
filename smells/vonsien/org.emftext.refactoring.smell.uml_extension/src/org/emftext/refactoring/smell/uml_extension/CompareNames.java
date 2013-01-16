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

public class CompareNames extends EObjectImpl implements ModelMetric {
	
	private String name;
	
	public CompareNames(){
		setName("CompareNamesOfClasses");
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
						for (Element e2 : model.allOwnedElements()){
							if (e1 instanceof Class && e2 instanceof Class && !(e1.equals(e2))){
								if (((Class)e1).getName().equals(((Class)e2).getName())){
									if (!map.containsKey(e1) && !map.containsKey(e2)){
										map.put(e2, 1.0f);
									}
								}
							}
							if (e1 instanceof Interface && e2 instanceof Interface && !(e1.equals(e2))){
								if (((Interface)e1).getName().equals(((Interface)e2).getName())){
									if (!map.containsKey(e1) && !map.containsKey(e2)){
										map.put(e2, 1.0f);
									}
								}
							}
						}
					}
				}
			}
		}
		return map;
	}

}
