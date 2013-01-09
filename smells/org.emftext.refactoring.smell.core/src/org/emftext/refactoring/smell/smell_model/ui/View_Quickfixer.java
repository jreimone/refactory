package org.emftext.refactoring.smell.smell_model.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IMarkerResolutionGenerator2;

public class View_Quickfixer implements IMarkerResolutionGenerator, IMarkerResolutionGenerator2 {
	
    public IMarkerResolution[] getResolutions(IMarker mk) {
       try {
    	   if (mk != null){
    		   Object problem = mk.getAttribute(IMarker.MESSAGE);
    	       return new IMarkerResolution[] {
    	    		   new View_Quickfix("Fix for "+problem)
    	       };
    	   } else {
    		   return new IMarkerResolution[0];
    	   }
       }
       catch (CoreException e) {
          return new IMarkerResolution[0];
       }
    }

	@Override
	public boolean hasResolutions(IMarker marker) {
		// TODO Auto-generated method stub
		return false;
	}
 }
