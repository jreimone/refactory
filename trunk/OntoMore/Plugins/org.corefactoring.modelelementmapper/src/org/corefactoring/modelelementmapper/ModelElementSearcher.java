package org.corefactoring.modelelementmapper;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.DataProperty;
import org.emftext.language.owl.Frame;
import org.emftext.language.owl.ObjectProperty;
import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.OntologyDocument;

/**
 * Searches through the given target model to find an element that corresponds
 * to the given. This class should be replaced by a proper mapping between the
 * elements in the model.
 * 
 * @author Erik Tittel
 */
public class ModelElementSearcher {

	public static EClass getEClassFromEPackage(String className, EPackage targetModel) {
		EClass result = (EClass) targetModel.getEClassifier(className);
		if (result == null) {
			throw new RuntimeException("EClass \"" + className + "\" could not be retrieved from "
					+ targetModel.getName());
		}
		return result;
	}

	public static EReference getEReferenceFromEPackage(String objectPropertyName,
			EPackage targetModel) {
		EReference result = null;
		for (EClassifier eClassifier : targetModel.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EReference eReference : eClass.getEReferences()) {
					if (objectPropertyName.equals(eReference.getName())) {
						result = eReference;
					}
				}
			}
		}
		if (result == null) {
			throw new RuntimeException("EReference \"" + objectPropertyName
					+ "\" could not be retrieved from " + targetModel.getName());
		}
		return result;
	}

	public static EAttribute getEAttributeFromEPackage(String dataPropertyName, EPackage targetModel) {
		EAttribute result = null;
		for (EClassifier eClassifier : targetModel.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EAttribute eAttribute : eClass.getEAttributes()) {
					if (dataPropertyName.equals(eAttribute.getName())) {
						result = eAttribute;
					}
				}
			}
		}
		if (result == null) {
			throw new RuntimeException("EAttribute \"" + dataPropertyName
					+ "\" could not be retrieved from " + targetModel.getName());
		}
		return result;
	}

	public static Class getClassFromOntologyDocument(String className, OntologyDocument targetModel) {
		Ontology ontology = targetModel.getOntology();
		Class result = null;
		for (Frame frame : ontology.getFrames()) {
			if (frame instanceof Class) {
				Class owlClass = (Class) frame;
				if (className.equals(owlClass.getIri())) {
					result = owlClass;
					break;
				}
			}
		}
		if (result == null) {
			throw new RuntimeException("OWL class \"" + className
					+ "\" could not be retrieved from " + targetModel.getOntology().getUri());
		}
		return result;
	}

	public static ObjectProperty getObjectPropertyFromOntologyDocument(String objectPropertyName,
			OntologyDocument targetModel) {
		Ontology ontology = targetModel.getOntology();
		ObjectProperty result = null;
		for (Frame frame : ontology.getFrames()) {
			if (frame instanceof ObjectProperty) {
				ObjectProperty objectProperty = (ObjectProperty) frame;
				if (objectPropertyName.equals(objectProperty.getIri())) {
					result = objectProperty;
					break;
				}
			}
		}
		if (result == null) {
			throw new RuntimeException("ObjectProperty \"" + objectPropertyName
					+ "\" could not be retrieved from " + targetModel.getOntology().getUri());
		}
		return result;
	}

	public static DataProperty getDataPropertyFromOntologyDocument(String dataPropertyName,
			OntologyDocument targetModel) {
		Ontology ontology = targetModel.getOntology();
		DataProperty result = null;
		for (Frame frame : ontology.getFrames()) {
			if (frame instanceof DataProperty) {
				DataProperty dataProperty = (DataProperty) frame;
				if (dataPropertyName.equals(dataProperty.getIri())) {
					result = dataProperty;
					break;
				}
			}
		}
		if (result == null) {
			throw new RuntimeException("DataProperty \"" + dataPropertyName
					+ "\" could not be retrieved from " + targetModel.getOntology().getUri());
		}
		return result;
	}

}
