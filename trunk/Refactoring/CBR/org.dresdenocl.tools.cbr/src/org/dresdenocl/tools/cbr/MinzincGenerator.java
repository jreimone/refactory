package org.dresdenocl.tools.cbr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tudresden.ocl20.pivot.essentialocl.types.CollectionType;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceCollection;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceObject;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceString;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * Model/OCL compiler for Minzinc Constraint Files.
 * 
 * @author Claas Wilke
 */
public class MinzincGenerator {

	public String compileModelInstance(IModelInstance modelInstance,
			Collection<IModelInstanceObject> affectedObjects,
			Set<Type> affectedTypes) {

		StringBuffer result = new StringBuffer();

		/* Sort objects by their type's name. */
		List<IModelInstanceObject> allObjects = new ArrayList<IModelInstanceObject>(
				affectedObjects);
		Collections.sort(allObjects, new Comparator<IModelInstanceObject>() {

			public int compare(IModelInstanceObject o1, IModelInstanceObject o2) {
				return o1.getType().getQualifiedName()
						.compareTo(o2.getType().getQualifiedName());
			}
		});

		result.append("% Declarations (generated from the diagram/metamodel instance)\n");
		result.append("\n");

		/* Generate variables for each element. */
		Map<Type, Integer> currentIdCounterForType = new HashMap<Type, Integer>();
		Map<IModelInstanceObject, String> identifierOfObject = new HashMap<IModelInstanceObject, String>();

		int id = 0;

		/* Iterate on objects. */
		for (IModelInstanceObject imiObject : allObjects) {

			String uniqueName;
			uniqueName = getIdOfObject(identifierOfObject, imiObject,
					currentIdCounterForType);

			result.append("% " + uniqueName + "\n");
			result.append("par int : " + uniqueName + " = " + id + ";\n");

			/* Handling for properties. */
			for (Property property : imiObject.getType().allProperties()) {

				try {
					/* String properties. */
					if (property.getType() instanceof PrimitiveType) {
						PrimitiveType primitiveType = (PrimitiveType) property
								.getType();
						if (primitiveType.getKind() == PrimitiveTypeKind.STRING) {
							IModelInstanceString value = (IModelInstanceString) imiObject
									.getProperty(property);
							if (!value.isUndefined()) {
								result.append("par string : " + uniqueName
										+ "_" + property.getName() + " = "
										+ "\"" + value.getString() + "\";\n");
							}
							// no else.
						}
						// no else.
					}
					// no else.

					/* Collection properties. */
					else if (property.getType() instanceof CollectionType) {
						CollectionType collType = (CollectionType) property
								.getType();

						if (collType.getElementType() != null
								&& affectedTypes.contains(collType
										.getElementType())) {
							IModelInstanceCollection<IModelInstanceElement> value = (IModelInstanceCollection<IModelInstanceElement>) imiObject
									.getProperty(property);
							if (!value.isUndefined()) {
								result.append("par set of { ");

								/*
								 * Add id of each possible value to the domain
								 * of the set (the IDs of all objects of this
								 * type).
								 */
								Set<IModelInstanceObject> elementsOfType = modelInstance
										.getAllInstances(collType
												.getElementType());
								Iterator<IModelInstanceObject> elementsOfTypeIt = elementsOfType
										.iterator();

								while (elementsOfTypeIt.hasNext()) {
									IModelInstanceObject object = elementsOfTypeIt
											.next();
									result.append(this.getIdOfObject(
											identifierOfObject, object,
											currentIdCounterForType));
									if (elementsOfTypeIt.hasNext())
										result.append(", ");
									// no else.
								}
								// end while.

								result.append(" } : " + uniqueName + "_"
										+ property.getName() + " = { ");

								/* Add id of each element within the value. */
								Iterator<IModelInstanceElement> valueIt = value
										.getCollection().iterator();

								while (valueIt.hasNext()) {
									IModelInstanceObject object = (IModelInstanceObject) valueIt
											.next();
									result.append(this.getIdOfObject(
											identifierOfObject, object,
											currentIdCounterForType));
									if (valueIt.hasNext())
										result.append(", ");
									// no else.
								}
								// end while.

								result.append(" }\n");
							}
							// no else.
						}
						// no else.
					}

					/* Other properties. */
					else if (affectedTypes.contains(property.getType())) {
						IModelInstanceElement value = imiObject
								.getProperty(property);
						if (!value.isUndefined()
								&& affectedObjects.contains(value)) {
							result.append("par int : "
									+ uniqueName
									+ "_"
									+ property.getName()
									+ " = "
									+ this.getIdOfObject(identifierOfObject,
											(IModelInstanceObject) value,
											currentIdCounterForType) + ";\n");
						}
						// no else.
					}
					// no else.
				} catch (Exception e) {
					// Do nothing (property is not set correctly).
				}
			}
			// end for.

			result.append("\n");

			id++;
		}
		// end for.

		return result.toString();
	}

	private String getIdOfObject(
			Map<IModelInstanceObject, String> identifierOfObject,
			IModelInstanceObject imiObject,
			Map<Type, Integer> currentIdCounterForType) {
		/* Compute unique name. */
		Integer idCounter = currentIdCounterForType.get(imiObject.getType());
		if (idCounter == null)
			idCounter = 0;
		// no else.
		idCounter++;
		currentIdCounterForType.put(imiObject.getType(), idCounter);

		String uniqueName;
		if (identifierOfObject.containsKey(imiObject)) {
			uniqueName = identifierOfObject.get(imiObject);
		} else {
			uniqueName = "ID_" + imiObject.getType().getQualifiedName()
					+ idCounter;
			identifierOfObject.put(imiObject, uniqueName);
		}
		return uniqueName;
	}
}
