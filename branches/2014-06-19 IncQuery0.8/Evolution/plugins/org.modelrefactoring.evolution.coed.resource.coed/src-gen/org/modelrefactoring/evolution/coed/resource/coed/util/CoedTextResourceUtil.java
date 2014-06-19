/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class CoedTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.
 */
public class CoedTextResourceUtil {
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResou
	 * rce() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource getResource(IFile file) {
		return new org.modelrefactoring.evolution.coed.resource.coed.util.CoedEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResou
	 * rce() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource getResource(File file, Map<?,?> options) {
		return org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResou
	 * rce() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource getResource(URI uri) {
		return org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResou
	 * rce() instead.
	 */
	@Deprecated
	public static org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource getResource(URI uri, Map<?,?> options) {
		return org.modelrefactoring.evolution.coed.resource.coed.util.CoedResourceUtil.getResource(uri, options);
	}
	
}
