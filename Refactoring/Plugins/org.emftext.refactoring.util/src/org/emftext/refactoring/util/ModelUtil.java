/**
 * 
 */
package org.emftext.refactoring.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This class provides useful functionality to work with, query or filter models.
 * 
 * @author Jan Reimann
 *
 */
public class ModelUtil {

	private ModelUtil(){
		// just do nothing
	}
	
	/**
	 * Gets an iterator as input and filters the elements by the given type. Then returns a list containing
	 * only elements of type <code>type</code>. 
	 * 
	 * @param <T> the class by which the iterator will be filtered
	 * @param iterator the iterator, normally a TreeIterator for a model
	 * @param type the filter type
	 * @return a list containing only elements of the given type
	 */
	@SuppressWarnings("unchecked")
	public static <T> EList<T> getObjectsByType(Iterator<EObject> iterator, Class<T> type){
		EList<T> filteredModel = new BasicEList<T>();
		while (iterator.hasNext()) {
			EObject eObject = (EObject) iterator.next();
			if(type.isInstance(eObject)){
				filteredModel.add((T) eObject);
			}
		}
		return filteredModel;
	}

	/**
	 * Searchs the <code>contents</code> for elements having an attribute with the name <code>attributeName</code>
	 * and a set value <code>value</code>.
	 * 
	 * @param contents the contents to be filtered
	 * @param attributeName the name of the attribute to check
	 * @param value the value of the attribute
	 * @return a list containing all elements of the contents having an attribute with the given name and value
	 */
	public static EList<EObject> filterObjectsByAttribute(
			Iterator<? extends EObject> contents, String attributeName, Object value) {
		EList<EObject> filteredElements = new BasicEList<EObject>();
		while(contents.hasNext()){
			EObject element = contents.next();
			EClass clazz = element.eClass();
			EList<EAttribute> attributes = clazz.getEAllAttributes();
			for (EAttribute eAttribute : attributes) {
				if(attributeName.equals(eAttribute.getName())){
					Object elementsAttributeValue = element.eGet(eAttribute, true);
					if(elementsAttributeValue.equals(value)){
						filteredElements.add(element);
					}
				}
			}
		}
		return filteredElements;
	}
	
	public static <T extends EObject> boolean bothModelsAreEqual(T first, T second){
		TreeIterator<EObject> itFirst = first.eAllContents();
		TreeIterator<EObject> itSecond = second.eAllContents();
		while (itFirst.hasNext()) {
			if(!itSecond.hasNext()){
				return false;
			}
			EObject obFirst = itFirst.next();
			EObject obSecond = itSecond.next();
			boolean equal = bothEObjectsAreEqual(obFirst, obSecond);
			if(!equal){
				return false;
			}
		}
		return true;
	}

	public static boolean bothEObjectsAreEqual(EObject first, EObject second){
		EClass class1 = first.eClass();
		EClass class2 = second.eClass();
		if(!class1.equals(class2)){
			return false;
		}
		EList<EAttribute> attributes1 = class1.getEAllAttributes();
		EList<EAttribute> attributes2 = class2.getEAllAttributes();
		if(!attributes1.containsAll(attributes2)){
			return false;
		}
		for (EAttribute attribute : attributes2) {
			Object value1 = first.eGet(attribute);
			Object value2 = second.eGet(attribute);
			if(!value1.equals(value2)){
				return false;
			}
		}
		EList<EReference> references1 = class1.getEAllReferences();
		EList<EReference> references2 = class1.getEAllReferences();
		if(references1.size() != references2.size()){
			return false;
		}
		for (int i = 0; i < references1.size(); i++) {
			EReference ref1 = references1.get(i);
			EReference ref2 = references2.get(i);
			if(!ref1.getName().equals(ref2.getName())){
				return false;
			}
			if(!ref1.getEType().equals(ref2.getEType())){
				return false;
			}
//			Object value1 = first.eGet(ref1);
//			Object value2 = second.eGet(ref2);
//			if(!value1.equals(value2)){
//				return false;
//			}
		}
		return true;
	}
}
