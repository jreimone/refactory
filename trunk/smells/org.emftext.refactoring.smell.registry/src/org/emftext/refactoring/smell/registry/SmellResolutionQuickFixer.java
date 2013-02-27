package org.emftext.refactoring.smell.registry;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IMarkerResolutionGenerator2;

public class SmellResolutionQuickFixer implements IMarkerResolutionGenerator, IMarkerResolutionGenerator2 {

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		return new IMarkerResolution[]{};
	}

	@Override
	public boolean hasResolutions(IMarker marker) {
		return true;
	}

}
