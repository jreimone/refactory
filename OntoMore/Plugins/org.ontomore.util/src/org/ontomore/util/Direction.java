package org.ontomore.util;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents the direction of the co-refactoring with the URIs of source and
 * target metamodel.
 * 
 * @author Erik Tittel
 */
public class Direction {

	private String sourceMetamodelURI;
	private String targetMetamodelURI;

	public Direction(EObject sourceModel, EObject targetModel) {
		sourceMetamodelURI = ModelStorageUtil.getMetaModelAsString(sourceModel);
		targetMetamodelURI = ModelStorageUtil.getMetaModelAsString(targetModel);
	}

	public Direction(String sourceModel, String targetModel) {
		sourceMetamodelURI = sourceModel;
		targetMetamodelURI = targetModel;
	}

	public String getSource() {
		return sourceMetamodelURI;
	}

	public String getTarget() {
		return targetMetamodelURI;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Direction) {
			Direction otherDirection = (Direction) obj;
			return sourceMetamodelURI.equals(otherDirection.getSource())
					&& targetMetamodelURI.equals(otherDirection.getTarget());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return sourceMetamodelURI.length() + (targetMetamodelURI.length() * 2);
	}

}
