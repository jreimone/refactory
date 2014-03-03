package org.corefactoring.modelelementmapper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.ontomore.util.Direction;

/**
 * Maps an input element in one model to a corresponding input element in
 * another model.
 * 
 * @author Erik Tittel
 */
public class ModelElementMapperRegistryImpl implements ModelElementMapperRegistry {

	private static ModelElementMapperRegistry uniqueInstance = null;
	private Map<Direction, ModelElementMapper> map;
	
	public static ModelElementMapperRegistry getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ModelElementMapperRegistryImpl();
		}
		return uniqueInstance;
	}
	
	private ModelElementMapperRegistryImpl() {
		map = new HashMap<Direction, ModelElementMapper>();
	}
	
	public EObject getCorrespondingElement(EObject inputElement, EObject targetModel) {
		Direction direction = new Direction(inputElement, targetModel);
		ModelElementMapper modelElementMapper = map.get(direction);
		if (modelElementMapper == null) {
			throw new RuntimeException(
					"No ModelElementMapper has been registered for that direction");
		}
		return modelElementMapper.getCorrespondingModelElement(inputElement, targetModel);
	}

	public ModelElementMapper registerElementMapper(Direction direction,
			ModelElementMapper modelElementMapper) {
		return map.put(direction, modelElementMapper);
	}
	
	

}
