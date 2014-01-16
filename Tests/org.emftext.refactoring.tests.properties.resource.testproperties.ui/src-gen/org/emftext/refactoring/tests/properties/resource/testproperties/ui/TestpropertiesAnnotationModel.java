/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class TestpropertiesAnnotationModel extends ResourceMarkerAnnotationModel {
	
	public TestpropertiesAnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesMarkerAnnotation(marker);
	}
	
}
