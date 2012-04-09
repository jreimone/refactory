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
package org.emftext.refactoring.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class RegistryUtil {

	public static IConfigurationElement[] collectConfigurationElements(String extensionPoint) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry == null) {
			return new IConfigurationElement[0];
		}
		return registry.getConfigurationElementsFor(extensionPoint);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> Map<T, IConfigurationElement> collectRegisteredResources(String extensionPoint, String attribute, Class<T> expectedModel) {
		ResourceSet rs = new ResourceSetImpl();
		Map<T, IConfigurationElement> map = new LinkedHashMap<T, IConfigurationElement>();
		IConfigurationElement[] elements = collectConfigurationElements(extensionPoint);
		if (elements == null) {
			return map;
		}
		for (IConfigurationElement element : elements) {
			String value = element.getAttribute(attribute);
			String plugin = element.getContributor().getName();
			URI uri = URI.createPlatformPluginURI("/" + plugin + "/" + value, true);
			Resource resource = null;
			try {
				resource = rs.getResource(uri, true);
			} catch (Exception e) {
				log(String.format("Resource '%1$s' couldn't be loaded", value), IStatus.ERROR);
				continue;
			}
			if (resource == null) {
				log(String.format("Resource '%1$s' couldn't be loaded", value), IStatus.ERROR);
				continue;
			}
			EObject model = resource.getContents().get(0);
			if (expectedModel.isInstance(model)) {
				map.put((T) model, element);
			} else {
				log(String.format("The resource with URI '%1$s' doesn't contain a %2$s", uri.toString(), expectedModel.getClass().getSimpleName()), IStatus.ERROR);
			}
		}
		return map;
	}

	public static void log(String message, int statusCode, Exception e) {
		if (e.getStackTrace() != null && e.getStackTrace().length > 0) {
			message = e.getMessage() + "\n" + message;
			IStatus status = new Status(statusCode, RefactoringUtilPlugin.PLUGIN_ID, message, e);
			RefactoringUtilPlugin.getDefault().getLog().log(status);
		} else {
			message = e.getMessage() + "\n" + message;
			log(message, statusCode);
		}
	}

	public static void log(String message, int statusCode) {
//		Level level = null;
//		switch (statusCode) {
//			case IStatus.ERROR:
//				level = Level.SEVERE;
//				break;
//			case IStatus.INFO:
//				level = Level.INFO;
//				break;
//			case IStatus.WARNING:
//				level = Level.WARNING;
//				break;
//			default:
//				break;
//		}
		IStatus status = new Status(statusCode, RefactoringUtilPlugin.PLUGIN_ID, message);
		if(Platform.isRunning()){
			RefactoringUtilPlugin.getDefault().getLog().log(status);
		}
	}
}
