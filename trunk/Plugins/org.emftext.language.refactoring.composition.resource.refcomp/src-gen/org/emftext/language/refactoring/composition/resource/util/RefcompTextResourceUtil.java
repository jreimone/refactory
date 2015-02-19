/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class RefcompTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.
 */
public class RefcompTextResourceUtil {
	
	/**
	 * Use
	 * org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated
	public static org.emftext.language.refactoring.composition.resource.mopp.RefcompResource getResource(IFile file) {
		return new org.emftext.language.refactoring.composition.resource.util.RefcompEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated
	public static org.emftext.language.refactoring.composition.resource.mopp.RefcompResource getResource(File file, Map<?,?> options) {
		return org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated
	public static org.emftext.language.refactoring.composition.resource.mopp.RefcompResource getResource(URI uri) {
		return org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.g
	 * etResource() instead.
	 */
	@Deprecated
	public static org.emftext.language.refactoring.composition.resource.mopp.RefcompResource getResource(URI uri, Map<?,?> options) {
		return org.emftext.language.refactoring.composition.resource.util.RefcompResourceUtil.getResource(uri, options);
	}
	
}
