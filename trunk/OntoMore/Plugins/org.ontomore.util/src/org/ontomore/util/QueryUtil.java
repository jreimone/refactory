package org.ontomore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.ObjectProperty;
import org.emftext.language.owl.OntologyDocument;

/**
 * Retrieves a certain element from a model.
 * 
 * @author Erik Tittel
 */
public class QueryUtil {

	private static final String ROOT_SYMBOL = "#";
	private static final String SEGMENT_SEPERATOR = "/";
	private static final String MULTIPLICITY_CONNECTOR = "\\.\\.";
	private static final String ATTRIBUTE_OPEN = "\\[";
	private static final String ATTRIBUTE_CLOSE = "]";

	public static EClass queryFirstEClass(EPackage model) {
		String inputElementsQuery = "eClassifiers[0]";
		EClass firstInputElement = (EClass) QueryUtil.queryModel(model, inputElementsQuery);
		return firstInputElement;
	}

	public static Class queryFirstOwlClass(OntologyDocument ontologyDocument) {
		String inputElementsQuery = "ontology[0]/frames[0]";
		Class firstInputElement = (Class) QueryUtil
				.queryModel(ontologyDocument, inputElementsQuery);
		return firstInputElement;
	}

	public static ObjectProperty queryFirstOwlObjectProperty(OntologyDocument ontologyDocument) {
		String inputElementsQuery = "ontology[0]/frames[2]";
		ObjectProperty firstInputElement = (ObjectProperty) QueryUtil.queryModel(ontologyDocument,
				inputElementsQuery);
		return firstInputElement;
	}

	/**
	 * Gets the element from the given model which is described by the given
	 * query string. The query string describes the references to the desired
	 * element. "eClassifiers[0]/eStructuralFeatures[2]" for example means: Go
	 * from the root element the eClassifiers reference, choose the first
	 * element, and take from that the third Structural Feature (Reference or
	 * Attribute).
	 */
	public static EObject queryModel(EObject model, String query) {
		String[] querySegments = query.split(SEGMENT_SEPERATOR);
		List<EObject> elements = getInputElements(model, querySegments);
		if (elements == null || elements.isEmpty()) {
			throw new RuntimeException("No input elements found in model\n" + model
					+ "\nfor the query \"" + query + "\"");
		}
		return elements.get(0);
	}

	private static List<EObject> getInputElements(EObject model, String[] querySegments) {
		if (querySegments.length == 0) {
			return getEObjectListOfSingleElement(model);
		}
		String featureName = querySegments[0];
		if (ROOT_SYMBOL.equals(featureName)) {
			return getEObjectListOfSingleElement(model);
		}
		querySegments = removeFirstElementFromArray(querySegments);
		String[] attributes = featureName.split(ATTRIBUTE_OPEN);
		if (attributes == null || attributes.length == 0) {
			return null;
		}
		featureName = attributes[0];
		String attribute = null;
		if (attributes.length > 1) {
			attribute = attributes[1].replace(ATTRIBUTE_CLOSE, "");
		}
		EClass metaclass = model.eClass();
		EStructuralFeature feature = metaclass.getEStructuralFeature(featureName);
		if (feature == null) {
			return null;
		}
		Object value = model.eGet(feature, true);
		if (value instanceof EObject) {
			return getInputElements((EObject) value, querySegments);
		}
		if (value instanceof List<?>) {
			List<?> valueList = (List<?>) value;
			if (attribute == null) {
				List<EObject> temp = new ArrayList<EObject>();
				temp.add((EObject) valueList.get(0));
				return temp;
			}
			try {
				int index = Integer.parseInt(attribute);
				EObject ob = (EObject) valueList.get(index);
				if (querySegments.length == 0) {
					return getEObjectListOfSingleElement(ob);
				} else {
					return getInputElements(ob, querySegments);
				}
			} catch (NumberFormatException e) {
			}
			String[] multiplicity = attribute.split(MULTIPLICITY_CONNECTOR);
			if (multiplicity != null && multiplicity.length > 0) {
				int min = Integer.parseInt(multiplicity[0]);
				int max = Integer.parseInt(multiplicity[1]);
				List<EObject> result = new LinkedList<EObject>();
				for (int i = min; i <= max; i++) {
					result.add((EObject) valueList.get(i));
				}
				if (querySegments.length == 0) {
					return result;
				} else {
					if (result.size() == 1) {
						return getInputElements(result.get(0), querySegments);
					} else {
						return null;
					}
				}
			} else {
				return null;
			}
		}
		return null;
	}

	public static List<EObject> getEObjectListOfSingleElement(EObject model) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(model);
		return result;
	}
	
	public static List<String> getStringListOfSingleElement(String string) {
		List<String> result = new ArrayList<String>();
		result.add(string);
		return result;
	}

	private static String[] removeFirstElementFromArray(String[] path) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i < path.length; i++) {
			result.add(path[i]);
		}
		return result.toArray(new String[0]);
	}

	public static String getLineInFile(File file, int lineNumber) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			for (int i = 0; i < lineNumber; i++) {
				String line = reader.readLine();
				if (line == null) {
					return null;
				}
				if ((i + 1) == lineNumber) {
					return line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
