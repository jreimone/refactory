package org.emftext.refactoring.smell.ecore_extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.smell.smell_model.ModelMetric;

public class CompareNamesOfClasses extends EObjectImpl implements ModelMetric {
	
	private String name;
	private List<EPackage> list;
	
	public CompareNamesOfClasses(){
		setName("CompareNamesOfClasses");
		list = new ArrayList<EPackage>();
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
		EPackage epackage = null;
		if (loadedResource != null){
			if (loadedResource.getContents().size() > 0) {
				try {
					if (loadedResource.getContents().get(0) instanceof org.eclipse.gmf.runtime.notation.impl.DiagramImpl){
						epackage = (EPackage) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) loadedResource.getContents().get(0)).getElement();
					} else {
						epackage = (EPackage) loadedResource.getContents().get(0);
					}
				} catch (ClassCastException e){

				}
				if (epackage != null) {
					getList().add(epackage);
					walkPackages(epackage.getESubpackages());
					for (EPackage p : list) {
						for (EClassifier c : p.getEClassifiers()){
							for (EPackage p2 : list) {
								for (EClassifier c2 : p2.getEClassifiers()){
									if (!p.equals(p2) && !c.equals(c2) && c.getName().equals(c2.getName())){
										if (!map.containsKey(c) && !map.containsKey(c2)){
											map.put(c2, 1.0f);
										}
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
