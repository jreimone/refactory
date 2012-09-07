package dk.itu.sdg.language.coral.checker.handlers

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import dk.itu.sdg.language.coral.checker.Activator;
import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.ResourceUtil;
import dk.itu.sdg.language.coral.checker.ui.MarkerStaticChecker;

class Uncheck extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		def Object[]  selections = selection.toArray()

		def Job job = new Job("Unmark Resource...") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Unmarking...", selections.size())				
					
				if (selection.size() == 1) {
					Project containerProject = selections[0].getProject();
					ArrayList<org.eclipse.core.internal.resources.File> files = ResourceUtil.getFilesFromResource(containerProject);
	
					for (file in files) {
											
						def int depth = IResource.DEPTH_INFINITE
						try {
							
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_fixed_key", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_fixed_ref", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_free_key", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_free_ref", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_strtr_key", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_strtr_ref", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_dsr_key", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.directed_dsr_ref", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.undirected_strtr", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.undirected_free", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.undirected_fixed", true, depth)
							file.deleteMarkers("dk.itu.sdg.language.coral.checker.undirected_dsr", true, depth)
						} catch (CoreException e) {
							e.printStackTrace()
						}
						
						monitor.worked(1);
					}
				} 
					
				return Status.OK_STATUS;
				
				
			}
		};
		job.schedule();
	}
}
