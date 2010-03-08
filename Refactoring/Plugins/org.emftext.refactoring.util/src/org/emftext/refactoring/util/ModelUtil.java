/**
 * 
 */
package org.emftext.refactoring.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
	 * Sorts the given paths by their size starting with the smallest.
	 * @param paths
	 */
	public static List<List<? extends EObject>> sortPathsBySize(List<? extends EObject>... paths) {
		List<List<? extends EObject>> sortedPaths = new ArrayList<List<? extends EObject>>();
		for (List<? extends EObject> path : paths) {
			if(sortedPaths.size() == 0){
				sortedPaths.add(path);
			} else if(sortedPaths.size() == 1){
				List<? extends EObject> firstPath = sortedPaths.get(0);
				if(firstPath.size() <= path.size()){
					sortedPaths.add(path);
				} else {
					sortedPaths.add(0, path);
				}
			} else {
				List<? extends EObject> firstPath = sortedPaths.get(0);
				List<? extends EObject> secondPath = sortedPaths.get(1);
				int i = 1;
				while (!((firstPath.size() <= path.size()) && (secondPath.size() > path.size()))) {
					if(i + 1 >= sortedPaths.size()){
						break;
					}
					firstPath = sortedPaths.get(i);
					secondPath = sortedPaths.get(i + 1);
					i++;
				}
				sortedPaths.add(i, path);
			}
		}
		return sortedPaths;
	}

	/**
	 * Returns a {@link LinkedList} representing the path of the given {@link EObject child} to its
	 * root. 
	 * 
	 * @param child
	 * @return
	 */
	public static List<EObject> getPathToRoot(EObject child){
		EObject temp = child;
		List<EObject> path = new LinkedList<EObject>();
		path.add(temp);
		EObject root = EcoreUtil.getRootContainer(child, true);
		while (!temp.equals(root)) {
			temp = temp.eContainer();
			path.add(temp);
		}
		return path;
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
