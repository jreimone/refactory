/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.util;

/**
 * Class PropertiesTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesReso
 * urceUtil.
 */
public class PropertiesTextResourceUtil {
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesReso
	 * urceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesReso
	 * urceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesReso
	 * urceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesReso
	 * urceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesResourceUtil.getResource(uri, options);
	}
	
}
