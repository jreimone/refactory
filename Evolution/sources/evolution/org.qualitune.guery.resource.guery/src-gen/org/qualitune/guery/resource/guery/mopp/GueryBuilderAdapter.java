/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GueryBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.qualitune.guery.resource.guery.builder";
	
	private org.qualitune.guery.resource.guery.IGueryBuilder defaultBuilder = new org.qualitune.guery.resource.guery.mopp.GueryBuilder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta == null) {
			return null;
		}
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					org.qualitune.guery.resource.guery.IGueryBuilder builder = getBuilder();
					if (builder.isBuildingNeeded(uri)) {
						builder.handleDeletion(uri, monitor);
					}
					new org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
					return false;
				}
				if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.qualitune.guery.resource.guery.mopp.GueryMetaInformation().getSyntaxName())) {
					build((org.eclipse.core.resources.IFile) resource, monitor);
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.qualitune.guery.resource.guery.IGueryBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.qualitune.guery.resource.guery.mopp.GueryResource customResource = (org.qualitune.guery.resource.guery.mopp.GueryResource) new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl().getResource(uri, true);
			new org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.qualitune.guery.resource.guery.IGueryBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper.getMarkerID(org.qualitune.guery.resource.guery.GueryEProblemType.BUILDER_ERROR);
	}
	
}
