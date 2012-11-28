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
