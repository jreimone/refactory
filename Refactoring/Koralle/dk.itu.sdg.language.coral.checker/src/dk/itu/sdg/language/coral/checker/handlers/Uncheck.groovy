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
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
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

class Uncheck extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 1) {
			def Object[]  selections = selection.toArray()
			def final Object fstSelection = selections[0]

			def Job job = new Job("Unmark Resource...") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask("Unmarking...", 100)
					monitor.worked(50);
					
					def IMarker[] fixedRelationMarkers = null
					def IMarker[] stringTransformRelationMarkers = null
					
					def int depth = IResource.DEPTH_INFINITE
					try {
					   fixedRelationMarkers = Infer.getResource(fstSelection).deleteMarkers("dk.itu.sdg.language.coral.checker.generatedFixedRelation", true, depth)
					   stringTransformRelationMarkers = Infer.getResource(fstSelection).deleteMarkers("dk.itu.sdg.language.coral.checker.generatedStringTransformRelation", true, depth)
					} catch (CoreException e) {
						e.printStackTrace()
					}

					monitor.worked(100);

					return Status.OK_STATUS;
				}
			};
			job.schedule();
		}
	}

}
