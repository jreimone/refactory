/**
 * adapted from:
 * http://stackoverflow.com/questions/4098270/how-do-i-make-an-eclipse-plugin-extension-which-displays-different-context-menu
 */

package dk.itu.sdg.language.coral.checker.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

public class MarkerMenuContribution extends ContributionItem {

	private ITextEditor editor;
	private IVerticalRulerInfo rulerInfo;
	private List<IMarker> markers;

	public MarkerMenuContribution(ITextEditor editor) {
	    this.editor = editor;
	    this.rulerInfo = getRulerInfo();
	    this.markers = getMarkers();
	}

	private IVerticalRulerInfo getRulerInfo() {
	    return (IVerticalRulerInfo) editor.getAdapter(IVerticalRulerInfo.class);
	}

	private List<IMarker> getMarkers() {
	    List<IMarker> clickedOnMarkers = new ArrayList<IMarker>();
	    for (Object marker : getAllMarkers()){
	        if (markerHasBeenClicked((IMarker)marker)){
	            clickedOnMarkers.add((IMarker)marker);
	        }
	    }

	    return clickedOnMarkers;
	}

	//Determine whether the marker has been clicked using the ruler's mouse listener
	private boolean markerHasBeenClicked(IMarker marker) {
	    return (marker.getAttribute(IMarker.LINE_NUMBER, 0)) == (rulerInfo.getLineOfLastMouseButtonActivity() + 1);
	}

	//Get all My Markers for this source file
	private Object[] getAllMarkers() {
	    try {
	    	
	    	IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();

	        IMarker[] markers1 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_fixed_key", true, IResource.DEPTH_ZERO);
	        IMarker[] markers2 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_fixed_ref", true, IResource.DEPTH_ZERO);
	        IMarker[] markers3 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_free_key", true, IResource.DEPTH_ZERO);
	        IMarker[] markers4 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_free_ref", true, IResource.DEPTH_ZERO);
	        IMarker[] markers5 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_strfr_key", true, IResource.DEPTH_ZERO);
	        IMarker[] markers6 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_strfr_ref", true, IResource.DEPTH_ZERO);
	        IMarker[] markers7 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_dsr_key", true, IResource.DEPTH_ZERO);
	        IMarker[] markers8 = file.findMarkers("dk.itu.sdg.language.coral.checker.directed_dsr_ref", true, IResource.DEPTH_ZERO);
	        IMarker[] markers9 = file.findMarkers("dk.itu.sdg.language.coral.checker.undirected_strtr", true, IResource.DEPTH_ZERO);
	        IMarker[] markers10 = file.findMarkers("dk.itu.sdg.language.coral.checker.undirected_free", true, IResource.DEPTH_ZERO);
	        IMarker[] markers11 = file.findMarkers("dk.itu.sdg.language.coral.checker.undirected_fixed", true, IResource.DEPTH_ZERO);
	        IMarker[] markers12 = file.findMarkers("dk.itu.sdg.language.coral.checker.undirected_dsr", true, IResource.DEPTH_ZERO);

	        List<IMarker> markers = new ArrayList<IMarker>(markers1.length + markers2.length + markers3.length + markers4.length + markers5.length + markers6.length
	        		 + markers7.length + markers8.length + markers9.length + markers10.length + markers11.length + markers12.length);
	        
	        Collections.addAll(markers, markers1);
	        Collections.addAll(markers, markers2);
	        Collections.addAll(markers, markers3);
	        Collections.addAll(markers, markers4);
	        Collections.addAll(markers, markers5);
	        Collections.addAll(markers, markers6);
	        Collections.addAll(markers, markers7);
	        Collections.addAll(markers, markers8);
	        Collections.addAll(markers, markers9);
	        Collections.addAll(markers, markers10);
	        Collections.addAll(markers, markers11);
	        Collections.addAll(markers, markers12);
	        
			return markers.toArray(new IMarker[markers.size()]);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	    return null;
	}

	@Override
	//Create a menu item for each marker on the line clicked on
	public void fill(Menu menu, int index) {
	    for (final IMarker marker : markers) {
	        MenuItem menuItem = new MenuItem(menu, SWT.CHECK, index);
	        //TODO: put the location information into a separate attribute
	        String text = "Goto: " + marker.getAttribute(IMarker.MESSAGE, "").substring(marker.getAttribute(IMarker.MESSAGE, "").indexOf("->"), marker.getAttribute(IMarker.MESSAGE, "").length());
	        menuItem.setText(text);
	        menuItem.addSelectionListener(createDynamicSelectionListener(marker));
	    }
	}

	//Action to be performed when clicking on the menu item is defined here
	private SelectionAdapter createDynamicSelectionListener(final IMarker marker) {
	    return new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent e) {	            
	            IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	            try {
					IDE.openEditor(activePage, MarkerMap.getOtherSide(marker), true);
				} catch (PartInitException e1) {
					e1.printStackTrace();
				} 
	        }
	    };
	}
}
