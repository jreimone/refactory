package org.emftext.language.ecore.resource.text.postprocessing;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResource;

public class SameAttributesInHierarchyAnalyser extends AbstractPostProcessor {

	private Map<String, Map<EClassifier, List<EClass>>> attributeTypeMap = new LinkedHashMap<String, Map<EClassifier,List<EClass>>>();
	
	@Override
	public void analyse(TextEcoreResource resource, EPackage epackage) {
		fillMap(epackage);
		for (String name : attributeTypeMap.keySet()) {
			Map<EClassifier, List<EClass>> typeClassMap = attributeTypeMap.get(name);
			for (EClassifier type : typeClassMap.keySet()) {
				List<EClass> sameAttributeClasses = typeClassMap.get(type);
				if(sameAttributeClasses.size() > 1){
					for (EClass eClass : sameAttributeClasses) {
						List<EClass> sameAttributeClassesCopy = new LinkedList<EClass>(sameAttributeClasses);
						sameAttributeClassesCopy.remove(eClass);
						String message = "This class and the classes \n";
						for (EClass eClass2 : sameAttributeClassesCopy) {
							message += "'" + eClass2.getName() + "', ";
						}
						message = String.copyValueOf(message.toCharArray(), 0, message.length() - 2);
						message += "\nall have the same attribute '" + name + "' of type '" + type.getName() + "'." +
								"\nYou should consider to invoke a refactoring.";
						addProblem(resource, ETextEcoreProblemType.SAME_ATTRIBUTES_IN_HIERARCHY, message, eClass);
					}
				}
			}
		}
	}

	private void fillMap(EPackage epackage) {
		List<EClassifier> classifiers = epackage.getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if(eClassifier instanceof EClass){
				EClass eclass = (EClass) eClassifier;
				List<EAttribute> attributes = eclass.getEAttributes();
				for (EAttribute attribute : attributes) {
					EClassifier type = attribute.getEType();
					String name = attribute.getName();
					Map<EClassifier, List<EClass>> typeClassMap = attributeTypeMap.get(name);
					if(typeClassMap == null){
						typeClassMap = new LinkedHashMap<EClassifier, List<EClass>>();
						attributeTypeMap.put(name, typeClassMap);
					}
					List<EClass> classes = typeClassMap.get(type);
					if(classes == null){
						classes = new LinkedList<EClass>();
						typeClassMap.put(type, classes);
					}
					classes.add(eclass);
				}
			}
		}
	}

}
