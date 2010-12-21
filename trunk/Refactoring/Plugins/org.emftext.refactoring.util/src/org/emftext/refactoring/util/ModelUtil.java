/**
 * 
 */
package org.emftext.refactoring.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class provides useful functionality to work with, query or filter models.
 * 
 * @author Jan Reimann
 *
 */
public class ModelUtil {

	private static final Map<String, Integer> identifierMap = new HashMap<String, Integer>();

	private ModelUtil(){
		// just do nothing
	}

	/**
	 * Determines all subtypes from a given <i>supertype</i>.
	 * 
	 * @param supertype
	 * @return a list containg all subtypes or the empty list if <i>supertype</i> has no subtypes
	 */
	public static List<EClass> getAllSubTypes(EClass supertype){
		EPackage ePackage = supertype.getEPackage();
		EPackage superPackage = (EPackage) EcoreUtil.getRootContainer(ePackage);
		List<EClass> subTypes = getSubTypesInPackage(supertype, superPackage);
		subTypes.remove(supertype);
		return subTypes;
	}

	private static List<EClass> getSubTypesInPackage(EClass supertype, EPackage ePackage) {
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		List<EClass> subTypes = new ArrayList<EClass>();
		for (EClassifier eClassifier : classifiers) {
			if(eClassifier instanceof EClass && supertype.isSuperTypeOf((EClass)eClassifier)){
				subTypes.add((EClass)eClassifier);
			}
		}
		List<EPackage> subPackages = ePackage.getESubpackages();
		for (EPackage subPackage : subPackages) {
			List<EClass> subTypesInPackage = getSubTypesInPackage(supertype, subPackage);
			subTypes.addAll(subTypesInPackage);
		}
		return subTypes;
	}


	/**
	 * Creates an instance of the given {@link EClass} with {@link EcoreUtil#create(EClass)} and then
	 * creates all obligatory structural features.
	 * 
	 * @param clazz
	 * @return
	 */
	public synchronized static EObject create(EClass clazz){
		hackList = new ArrayList<EClass>();
		EObject createe = createHack(clazz);
		return createe;
	}

	private static List<EClass> hackList;

	private static EObject createHack(EClass clazz){
		if(clazz.isAbstract()){
			return null;
		}
		EObject instance = EcoreUtil.create(clazz);
		if(!hackList.contains(clazz)){
			hackList.add(clazz);
			createObligatories(instance);
			return instance;
		}
		return instance;
	}

	private static int getNextIdentifierSuffix(String key){
		Integer suffix = identifierMap.get(key);
		if(suffix == null){
			identifierMap.put(key, 1);
		} else {
			suffix++;
			identifierMap.put(key, suffix);
		}
		return identifierMap.get(key);
	}

	/**
	 * Creates all obligatory structural features of an {@link EObject}.
	 * 
	 * @param instance
	 */
	private static void createObligatories(EObject instance){
		//////////////////////////////////////////////////////////////////////////////
		// TODO  here is a place were to call the MissingInformationProvider /////////
		//////// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! /////////
		//////// until now I must kind of hack that no endless loops occur   /////////
		//////////////////////////////////////////////////////////////////////////////
		EClass clazz = instance.eClass();
		List<EStructuralFeature> features = clazz.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if(feature.isChangeable()){
				int min = feature.getLowerBound();
				if(min >= 1){
					if(feature.isMany()){
						// TODO add add new feature 
					} else {
						Object defaultValue = feature.getDefaultValue();
						if(defaultValue != null){
							instance.eSet(feature, defaultValue);
						} else {
							EClassifier classifier = feature.getEType();
							if(classifier instanceof EDataType){
								if(classifier.getInstanceClass().equals(String.class)){
									String identifier = firstUppercase(clazz.getName()) + firstUppercase(feature.getName());
									String name = "new" + identifier + getNextIdentifierSuffix(identifier);
									instance.eSet(feature, name);
								}
							} else if(classifier instanceof EClass){
								EObject child = createHack((EClass) classifier);
								instance.eSet(feature, child);
							}
						}
					}
				}
			}
		}
	}

	public static String firstUppercase(String name){
		StringBuilder builder = new StringBuilder(name);
		builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
		return builder.toString();
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
	public static <T> EList<T> getObjectsByType(Iterator<? extends EObject> iterator, Class<T> type){
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
	 * Filters a given list of {@link EObject}s by the given {@link EClass metaClasses}. If an object's {@link EObject#eClass() metaclass}
	 * is contained in <code>metaClasses</code> then it will be added into the result.
	 * 
	 * @param objects the object list to filter by metaclasses
	 * @param metaClasses the metaclasses to check against
	 * @return a filtered list
	 */
	public static List<? extends EObject> filterObjectsByTypes(List<? extends EObject> objects, EClass... metaClasses){
		List<EClass> classes = Arrays.asList(metaClasses);
		List<EObject> filteredList = new LinkedList<EObject>();
		for (EObject object : objects) {
			if(classes.contains(object.eClass())){
				filteredList.add(object);
			}
		}
		return filteredList;
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
