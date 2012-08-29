package org.emftext.refactoring.smell.smell_model.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class View_Quickfixer implements IMarkerResolutionGenerator {
	
    public IMarkerResolution[] getResolutions(IMarker mk) {
       try {
          Object problem = mk.getAttribute(IMarker.MESSAGE);
          return new IMarkerResolution[] {
             new View_Quickfix("Fix for "+problem)
          };
       }
       catch (CoreException e) {
          return new IMarkerResolution[0];
       }
    }
 }
