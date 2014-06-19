package org.corefactoring.modelregistry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.ontomore.util.ModelStorageUtil;

/**
 * Establishes the connections between models that should be refactored
 * together. Models are stored in form of the absolute file path to their
 * Resource.
 * 
 * @author Erik Tittel
 * 
 */
public class ModelRegistryImpl implements ModelRegistry {

	private static ModelRegistry uniqueInstance = null;
	private Set<String[]> modelSet;

	public static ModelRegistry getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ModelRegistryImpl();
		}
		return uniqueInstance;
	}

	private ModelRegistryImpl() {
		modelSet = new HashSet<String[]>();
	}

	public List<EObject> getCorrespondingModels(EObject model) {
		String givenFilePath = getFilePath(model);
		List<String> correspondingFilePaths = getCorrespondingFilePath(givenFilePath);
		List<EObject> correspondingModels = new ArrayList<EObject>();
		for (String filePath : correspondingFilePaths) {
			correspondingModels.add(ModelStorageUtil.loadModelFromFileName(filePath));
		}
		return correspondingModels;
	}

	private String getFilePath(EObject model) {
		String filePath;
		try {
			filePath = model.eResource().getURI().toFileString();
		} catch (Exception e) {
			throw new RuntimeException("Given model is not stored in a file: " + model, e);
		}
		return filePath;
	}

	public void addEntry(EObject leftModel, EObject rightModel) {
		String leftFilePath = getFilePath(leftModel);
		String rightFilePath = getFilePath(rightModel);
		String[] entry = getEntry(leftFilePath, rightFilePath);
		if (entry == null) {
			modelSet.add(new String[]{leftFilePath, rightFilePath});
		}
	}

	public void clearRegistry() {
		modelSet = new HashSet<String[]>();
	}

	public void removeEntry(EObject leftModel, EObject rightModel) {
		String leftFilePath = getFilePath(leftModel);
		String rightFilePath = getFilePath(rightModel);
		String[] entry = getEntry(leftFilePath, rightFilePath);
		if (entry != null) {
			modelSet.remove(entry);
		}
		String[] inverseEntry = getEntry(rightFilePath, leftFilePath);
		if (inverseEntry != null) {
			modelSet.remove(inverseEntry);
		}
	}

	private String[] getEntry(String leftFilePath, String rightFilePath) {
		for (String[] stringEntry : modelSet) {
			if (stringEntry[0].equals(leftFilePath) && stringEntry[1].equals(rightFilePath)) {
				return stringEntry;
			}
		}
		return null;
	}
	
	private List<String> getCorrespondingFilePath(String filePath) {
		List<String> result = new ArrayList<String>();
		for (String[] stringEntry : modelSet) {
			if (stringEntry[0].equals(filePath)) {
				result.add(stringEntry[1]);
			}
			if (stringEntry[1].equals(filePath)) {
				result.add(stringEntry[0]);
			}
		}
		if (result.size() == 0) {
			throw new RuntimeException("Model " + filePath + " is not associated with another model.");
		}
		return result;
	}
}
