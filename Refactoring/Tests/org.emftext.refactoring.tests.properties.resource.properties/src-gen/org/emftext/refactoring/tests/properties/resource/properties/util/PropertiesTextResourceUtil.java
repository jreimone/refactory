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
