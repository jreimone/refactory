package org.emftext.refactoring.smell.ecore_extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.smell.smell_model.ModelMetric;

public class CheckInterfaces extends EObjectImpl implements ModelMetric {
	
	private String name;
	private List<EPackage> list;

	public CheckInterfaces() {
		setName("CheckInterfaces");
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
		EPackage epackage = null;
		try {
			if (loadedResource.getContents().get(0) instanceof org.eclipse.gmf.runtime.notation.impl.DiagramImpl){
				epackage = (EPackage) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) loadedResource.getContents().get(0)).getElement();
			} else {
				epackage = (EPackage) loadedResource.getContents().get(0);
			}
		} catch (ClassCastException e){

		}
		if (epackage != null){
			getList().add(epackage);
			walkPackages(epackage.getESubpackages());
			for (EPackage ep : list) {
				List<EObject> contents = ep.eContents();
				for (EObject eo : contents) {
					if (eo instanceof EClass) {
						if (((EClass) eo).isInterface()){
							boolean hasNoSpecification = true;
							for (EPackage ep2 : list){
								List<EObject> contents2 = ep2.eContents();
								for (EObject eo2: contents2) {
									if (eo2 instanceof EClass) {
										if (((EClass) eo).isSuperTypeOf((EClass)eo2) && !(eo.equals(eo2))){
											hasNoSpecification = false;
											break;
										}
									}
								}
							}
							if (hasNoSpecification){
								map.put(eo, 1.0f);
							}
						}
						
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
