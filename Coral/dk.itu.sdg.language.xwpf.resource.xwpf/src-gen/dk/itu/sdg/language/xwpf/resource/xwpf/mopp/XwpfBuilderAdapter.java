/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder implements org.eclipse.core.resources.IResourceDeltaVisitor, org.eclipse.core.resources.IResourceVisitor {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "dk.itu.sdg.language.xwpf.resource.xwpf.builder";
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBuilder defaultBuilder = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfBuilder();
	
	/**
	 * This resource set is used during the whole build.
	 */
	private org.eclipse.emf.ecore.resource.ResourceSet resourceSet;
	
	/**
	 * This monitor is used during the build.
	 */
	private org.eclipse.core.runtime.IProgressMonitor monitor;
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// Set context for build
		this.monitor = monitor;
		this.resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// Perform build by calling the resource visitors
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
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
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource customResource = (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource) resourceSet.getResource(uri, true);
			new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMarkerHelper().getMarkerID(dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItemBuilder taskItemBuilder = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItemBuilder();
		new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMarkerHelper().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResource resource = delta.getResource();
		return doVisit(resource, delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED);
	}
	
	public boolean visit(org.eclipse.core.resources.IResource resource) throws org.eclipse.core.runtime.CoreException {
		return doVisit(resource, false);
	}
	
	protected boolean doVisit(org.eclipse.core.resources.IResource resource, boolean removed) throws org.eclipse.core.runtime.CoreException {
		if (removed) {
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation().getSyntaxName())) {
			// First, call the default generated builder that is usually customized to add
			// compilation-like behavior.
			build((org.eclipse.core.resources.IFile) resource, resourceSet, monitor);
			// Second, call the task item builder that searches for task items in DSL
			// documents and creates task markers.
			runTaskItemBuilder((org.eclipse.core.resources.IFile) resource, resourceSet, monitor);
			return false;
		}
		return true;
	}
	
}
