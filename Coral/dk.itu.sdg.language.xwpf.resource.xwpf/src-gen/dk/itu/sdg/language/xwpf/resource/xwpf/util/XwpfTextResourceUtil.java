/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.util;

/**
 * Class XwpfTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.
 */
public class XwpfTextResourceUtil {
	
	/**
	 * Use dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(org.eclipse.core.resources.IFile file) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfEclipseProxy().getResource(file);
	}
	
	/**
	 * Use dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(org.eclipse.emf.common.util.URI uri) {
		return dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource(uri);
	}
	
	/**
	 * Use dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfResourceUtil.getResource(uri, options);
	}
	
}
