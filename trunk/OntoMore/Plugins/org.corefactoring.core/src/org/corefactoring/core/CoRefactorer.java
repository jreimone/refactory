package org.corefactoring.core;

import java.util.ArrayList;
import java.util.List;

import org.corefactoring.modelelementmapper.ModelElementMapperRegistry;
import org.corefactoring.modelregistry.ModelRegistry;
import org.corefactoring.modelregistry.ModelRegistryImpl;
import org.corefactoring.rolemappingregistry.RoleMappingRegistry;
import org.eclipse.emf.ecore.EObject;
import org.ontomore.util.Direction;
import org.ontomore.util.InputData;
import org.ontomore.util.QueryUtil;
import org.ontomore.util.RefactoryUtil;

/**
 * Executes a co-refactoring on two corresponding models.
 * 
 * @author Erik Tittel
 */
public class CoRefactorer {

	private RefactoryUtil refactoryUtil;
	private ModelRegistry modelRegistry;
	private ModelElementMapperRegistry modelElementMapper;
	private RoleMappingRegistry roleMappingRegistry;

	public CoRefactorer() {
		refactoryUtil = RefactoryUtil.getInstance();
		modelRegistry = ModelRegistryImpl.getInstance();
		modelElementMapper = ModelElementMapperRegistry.INSTANCE;
		roleMappingRegistry = RoleMappingRegistry.INSTANCE;
	}

	/**
	 * Executes a co-refactoring. E. i. a refactoring is executed for the given
	 * input data; the corresponding input data for all associated models are
	 * looked up; and the co-refactorings are executed with the corresponding
	 * input data.
	 * 
	 * @return A list of all refactored and co-refactored models. The first in
	 *         the list is the refactored original model.
	 */
	public List<EObject> coRefactorModel(InputData originalInput) {
		List<InputData> inputs = new ArrayList<InputData>();
		inputs.add(originalInput);
		inputs.addAll(getCorrespondingInput(originalInput));
		List<EObject> refactoredModels = new ArrayList<EObject>();
		for (InputData input : inputs) {
			refactoredModels.add(refactoryUtil.refactorModel(input));
		}
		return refactoredModels;
	}

	private List<InputData> getCorrespondingInput(InputData input) {
		List<EObject> correspondingModels = modelRegistry.getCorrespondingModels(input.model);
		List<InputData> inputs = new ArrayList<InputData>();
		for (EObject model : correspondingModels) {
			InputData coInput = new InputData();
			coInput.model = model;
			Direction direction = new Direction(input.model, coInput.model);
			EObject singleInputElement = input.inputElements.get(0);
			EObject singleCorrespondingInputElement = modelElementMapper.getCorrespondingElement(
					singleInputElement, coInput.model);
			coInput.inputElements = QueryUtil
					.getEObjectListOfSingleElement(singleCorrespondingInputElement);
			coInput.mapping = roleMappingRegistry.getCorrespondingRoleMappingByDirection(
					input.mapping, singleInputElement, direction);
			coInput.inputValues = input.inputValues;
			inputs.add(coInput);
		}
		return inputs;
	}
}
