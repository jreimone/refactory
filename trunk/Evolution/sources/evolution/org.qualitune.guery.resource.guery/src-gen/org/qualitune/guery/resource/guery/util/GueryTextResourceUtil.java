/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.util;

/**
 * Class GueryTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.qualitune.guery.resource.guery.util.GueryResourceUtil.
 */
public class GueryTextResourceUtil {
	
	/**
	 * Use org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.qualitune.guery.resource.guery.mopp.GueryResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.qualitune.guery.resource.guery.util.GueryEclipseProxy().getResource(file);
	}
	
	/**
	 * Use org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.qualitune.guery.resource.guery.mopp.GueryResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.qualitune.guery.resource.guery.mopp.GueryResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource(uri);
	}
	
	/**
	 * Use org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.qualitune.guery.resource.guery.mopp.GueryResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.qualitune.guery.resource.guery.util.GueryResourceUtil.getResource(uri, options);
	}
	
}
