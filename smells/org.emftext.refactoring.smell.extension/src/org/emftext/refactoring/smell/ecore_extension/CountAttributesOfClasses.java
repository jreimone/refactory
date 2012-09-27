package org.emftext.refactoring.smell.ecore_extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.smell.smell_model.ModelMetric;

public class CountAttributesOfClasses extends EObjectImpl implements ModelMetric {
	
	private String name;
	private List<EPackage> list;

	public CountAttributesOfClasses() {
		setName("CountAttributesOfClasses");
		list = new ArrayList<EPackage>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<EObject, Float> calculate(Resource loadedResource) {
		Map<EObject, Float> map = new HashMap<EObject, Float>();
		Float f = 0.0f;
		EPackage epackage = null;
		if (loadedResource.getContents().get(0) instanceof org.eclipse.gmf.runtime.notation.impl.DiagramImpl){
			epackage = (EPackage) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) loadedResource.getContents().get(0)).getElement();
		} else {
			epackage = (EPackage) loadedResource.getContents().get(0);
		}
		if (epackage != null){
			getList().add(epackage);
			walkPackages(epackage.getESubpackages());
			for (EPackage ep : list) {
				List<EObject> contents = ep.eContents();
				for (EObject eo : contents) {
					if (eo instanceof EClassImpl) {
						f = (float) ((EClassImpl) eo).getEAllAttributes().size();
						f = f/10;
						if (f > 1.0f){
							f = 1.0f;
						}
						map.put(eo, f);
					}
				}
			}
		}
		return map;
	}
	
	private void walkPackages(List<EPackage> subPackages){
		for (EPackage epackage : subPackages) {
			if (epackage.getESubpackages() != null){
				walkPackages(epackage.getESubpackages());
			}
			getList().add(epackage);
		}
	}

	public List<EPackage> getList() {
		return list;
	}

}
