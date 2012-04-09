/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.emftext.refactoring.tests.properties.resource.properties.builder";
	
	private org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBuilder defaultBuilder = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesBuilder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta == null) {
			return null;
		}
		final org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBuilder builder = getBuilder();
					if (builder.isBuildingNeeded(uri)) {
						builder.handleDeletion(uri, monitor);
					}
					new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
					return false;
				}
				if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation().getSyntaxName())) {
					build((org.eclipse.core.resources.IFile) resource, resourceSet, monitor);
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource customResource = (org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource) resourceSet.getResource(uri, true);
			new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMarkerHelper().getMarkerID(org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType.BUILDER_ERROR);
	}
	
}
