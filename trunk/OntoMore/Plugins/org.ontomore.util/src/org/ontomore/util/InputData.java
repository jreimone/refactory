package org.ontomore.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * The input data needed for a refactoring. It contains a model, a RoleMapping,
 * an input element, and an input value.
 * 
 * @author Erik Tittel
 */
public class InputData {

	public EObject model;
	public RoleMapping mapping;
	public List<EObject> inputElements;
	public List<String> inputValues;
}
