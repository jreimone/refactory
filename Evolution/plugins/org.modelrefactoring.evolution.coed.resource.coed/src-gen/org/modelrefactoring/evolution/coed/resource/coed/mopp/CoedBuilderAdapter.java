/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CoedBuilderAdapter extends IncrementalProjectBuilder implements IResourceDeltaVisitor, IResourceVisitor {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.modelrefactoring.evolution.coed.resource.coed.builder";
	
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedBuilder defaultBuilder = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedBuilder();
	
	/**
	 * This resource set is used during the whole build.
	 */
	private ResourceSet resourceSet;
	
	/**
	 * This monitor is used during the build.
	 */
	private IProgressMonitor monitor;
	
	public IProject[] build(int kind, Map<String, String> args, final IProgressMonitor monitor) throws CoreException {
		// Set context for build
		this.monitor = monitor;
		this.resourceSet = new ResourceSetImpl();
		// Perform build by calling the resource visitors
		IResourceDelta delta = getDelta(getProject());
		if (delta != null) {
			// This is an incremental build
			delta.accept(this);
		} else {
			// This is a full build
			getProject().accept(this);
		}
		// Reset build context
		this.resourceSet = null;
		this.monitor = null;
		return null;
	}
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.modelrefactoring.evolution.coed.resource.coed.ICoedBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource customResource = (org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource) resourceSet.getResource(uri, true);
			new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMarkerHelper().getMarkerID(org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTaskItemBuilder taskItemBuilder = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTaskItemBuilder();
		new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMarkerHelper().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		return doVisit(resource, delta.getKind() == IResourceDelta.REMOVED);
	}
	
	public boolean visit(IResource resource) throws CoreException {
		return doVisit(resource, false);
	}
	
	protected boolean doVisit(IResource resource, boolean removed) throws CoreException {
		if (removed) {
			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			org.modelrefactoring.evolution.coed.resource.coed.ICoedBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		if (resource instanceof IFile && resource.getName().endsWith("." + new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation().getSyntaxName())) {
			// First, call the default generated builder that is usually customized to add
			// compilation-like behavior.
			build((IFile) resource, resourceSet, monitor);
			// Second, call the task item builder that searches for task items in DSL
			// documents and creates task markers.
			runTaskItemBuilder((IFile) resource, resourceSet, monitor);
			return false;
		}
		return true;
	}
	
}
