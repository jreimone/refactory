package org.emftext.refactoring.smell.registry;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;

public class SmellResolutionQuickFix implements IMarkerResolution, IMarkerResolution2 {

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void run(IMarker marker) {

	}

	@Override
	public Image getImage() {
		return null;
	}

}
