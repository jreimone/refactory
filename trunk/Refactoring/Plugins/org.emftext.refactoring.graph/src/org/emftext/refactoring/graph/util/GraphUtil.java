/**
 * 
 */
package org.emftext.refactoring.graph.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Provides some utility functions to work with graphs (models).
 * 
 * @author Jan Reimann
 *
 */
public class GraphUtil {

	/**
	 * Flattens a given resource by returning a list instead of a tree
	 * @param resource the resource to flatten
	 * @return a list representing the flattened resource
	 */
	public static List<EObject> flattenResource(Resource resource){
		TreeIterator<EObject> it = resource.getAllContents();
		List<EObject> list = new ArrayList<EObject>();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			list.add(eObject);
		}
		return list;
	}
	
	/**
	 * Finds the first node of type <i>clazz</i> in a <i>resource</i>, having an attribute called <i>attributeName</i> with string value <i>attributeValue</i>.
	 * @param resource the resource where to find the desired element 
	 * @param clazz the type of the element to search for
	 * @param attributeName the name of the attribute to search for
	 * @param attributeValue the name of the element
	 * @return the desired element or null if no node was found
	 */
	public static EObject findFirstNodeByNameAndType(Resource resource, Class<? extends EObject> clazz, String attributeName, String attributeValue){
		List<EObject> contents = flattenResource(resource);
		for (EObject eObject : contents) {
			if(clazz.isInstance(eObject)){
				EClass eClass = eObject.eClass();
				for(Iterator<EAttribute> iter = eClass.getEAllAttributes().iterator(); iter.hasNext();){
					EAttribute attribute = iter.next();
					if(attribute.getName().toUpperCase().equals(attributeName.toUpperCase())){
						Object value = eObject.eGet(attribute);
						if(value.equals(attributeValue)){
							return eObject;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Determines all subtypes from a given <i>supertype</i>.
	 * @param supertype
	 * @return a list containg all subtypes or the empty list if <i>supertype</i> has no subtypes
	 */
	public static EList<EClass> getAllSubTypes(EClass supertype){
		EList<EClass> subTypes = new BasicEList<EClass>();
		EPackage ePackage = supertype.getEPackage();
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if(eClassifier instanceof EClass && supertype.isSuperTypeOf((EClass)eClassifier)){
				subTypes.add((EClass)eClassifier);
			}
		}
		subTypes.remove(supertype);
		return subTypes;
	}
}
