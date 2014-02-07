/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class CoedAnnotationModel extends ResourceMarkerAnnotationModel {
	
	public CoedAnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedMarkerAnnotation(marker);
	}
	
}
