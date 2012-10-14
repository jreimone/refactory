package org.emftext.refactoring.smell.uml_extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.emftext.refactoring.smell.smell_model.ModelMetric;

public class CheckInterfaceSpecifications extends EObjectImpl implements ModelMetric {
	
private String name;
	
	public CheckInterfaceSpecifications(){
		setName("CheckInterfaceSpecifications");
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
		List<Interface> list = new ArrayList<Interface>();
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
							for (Interface i : ((Class) e1).getAllImplementedInterfaces()){
								list.add(i);
							}
						}
						if (e1 instanceof Interface){
							for (Interface i : ((Interface) e1).getAllUsedInterfaces()){
								list.add(i);
							}
						}
					}
					for (Element e1 : model.allOwnedElements()){
						if (e1 instanceof Interface){
							boolean hasNoSpecification = true;
							for (Interface i : list){
								if (i.equals(e1)){
									hasNoSpecification = false;
									break;
								}
							}
							if (hasNoSpecification){
								map.put(e1, 1.0f);
							}
						}
					}
				}
			}
		}
		return map;
	}

}
