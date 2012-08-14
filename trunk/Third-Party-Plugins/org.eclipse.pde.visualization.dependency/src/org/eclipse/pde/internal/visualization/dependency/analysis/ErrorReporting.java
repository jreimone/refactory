/*******************************************************************************
 * Copyright 2005-2006, CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.eclipse.pde.internal.visualization.dependency.analysis;

import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.pde.internal.visualization.dependency.views.PluginVisualizationView;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.IMessageManager;

public abstract class ErrorReporting {

	protected Object bundle;
	protected PluginVisualizationView view; 
	
	
	public ErrorReporting(PluginVisualizationView view ,Object bundle) {
		this.view = view;
		this.bundle = bundle;
	}

	public Object getBundle() {
		return this.bundle;
	}
	
	public abstract void handleError();
	public abstract String getErrorMessage();
	
	public static void createErrorReports(Object[] elements, PluginVisualizationView view, IMessageManager manager) {
		manager.removeAllMessages();
		
		for (int i = 0; i < elements.length; i++) {
			Object element = elements[i];
			UnresolvedError.containsError(element, view, manager);
		}
	}
	
	public static void showCurrentError(PluginVisualizationView view, ErrorReporting currentError, IMessageManager manager) {
		manager.removeAllMessages();
		CurrentError currentErrorWrapper = new CurrentError(view, currentError.getBundle(), currentError);
		manager.addMessage(currentErrorWrapper, currentErrorWrapper.getErrorMessage(), currentErrorWrapper, IMessage.INFORMATION);
		
	}
	
	protected String getName(Object o) {
		if (o instanceof BundleDescription) {
			return ((BundleDescription) o).getName();
		} else if (o instanceof BundleSpecification) {
			return ((BundleSpecification) o).getName();
		}
		return null;
	}
	
}
