/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.util;

/**
 * Class TestpropertiesTextResourceUtil can be used to perform common tasks on
 * text resources, such as loading and saving resources, as well as, checking them
 * for errors. This class is deprecated and has been replaced by
 * org.emftext.refactoring.tests.properties.resource.testproperties.util.Testproper
 * tiesResourceUtil.
 */
public class TestpropertiesTextResourceUtil {
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.testproperties.util.Testproper
	 * tiesResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.testproperties.util.Testproper
	 * tiesResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.testproperties.util.Testproper
	 * tiesResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.emftext.refactoring.tests.properties.resource.testproperties.util.Testproper
	 * tiesResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesResourceUtil.getResource(uri, options);
	}
	
}
