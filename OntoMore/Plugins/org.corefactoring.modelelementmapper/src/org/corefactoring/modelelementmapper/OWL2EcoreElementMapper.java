package org.corefactoring.modelelementmapper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.DataProperty;
import org.emftext.language.owl.ObjectProperty;

/**
 * Place holder implementation for a mapping of OWL elements to corresponding
 * elements in an Ecore model.
 * 
 * @author Erik Tittel
 */
public class OWL2EcoreElementMapper implements ModelElementMapper {

	public EObject getCorrespondingModelElement(EObject inputElement, EObject targetModel) {
		EPackage ePackage = null;
		if (targetModel instanceof EPackage) {
			ePackage = (EPackage) targetModel;
		} else {
			throw new RuntimeException(
			"The target model in the OWL-to-Ecore-Mapper should be an EPackage.");
		}
		if (inputElement instanceof Class) {
			String className = ((Class) inputElement).getIri();
			return ModelElementSearcher.getEClassFromEPackage(className, ePackage);
		} else if (inputElement instanceof ObjectProperty) {
			String objectPropertyName = ((ObjectProperty) inputElement).getIri();
			return ModelElementSearcher.getEReferenceFromEPackage(objectPropertyName, ePackage);
		} else if (inputElement instanceof DataProperty) {
			String dataPropertyName = ((DataProperty) inputElement).getIri();
			return ModelElementSearcher.getEAttributeFromEPackage(dataPropertyName, ePackage);
		} else {
			throw new RuntimeException(
					"There's no correspondence defined for this kind of input element");
		}
	}

}
