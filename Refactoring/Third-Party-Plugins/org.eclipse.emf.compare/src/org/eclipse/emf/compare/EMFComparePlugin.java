/*******************************************************************************
 * Copyright (c) 2006, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.compare.util.EMFComparePreferenceConstants;
import org.osgi.framework.BundleContext;

/**
 * The activator class, controls the plug-in life cycle.
 * 
 * @author <a href="mailto:cedric.brun@obeo.fr">Cedric Brun</a>
 */
public class EMFComparePlugin extends Plugin {
	/** The plugin ID. */
	public static final String PLUGIN_ID = "org.eclipse.emf.compare"; //$NON-NLS-1$

	/** Plug-in's shared instance. */
	private static EMFComparePlugin plugin;

	/**
	 * Default constructor.
	 */
	public EMFComparePlugin() {
		plugin = this;
	}

	/**
	 * Returns the plugin's shared instance.
	 * 
	 * @return The plugin's shared instance.
	 */
	public static EMFComparePlugin getDefault() {
		return plugin;
	}

	/**
	 * Trace an Exception in the error log.
	 * 
	 * @param e
	 *            Exception to log.
	 * @param blocker
	 *            <code>True</code> if the exception must be logged as error, <code>False</code> to log it as
	 *            a warning.
	 */
	public static void log(Exception e, boolean blocker) {
		if (e == null) {
			throw new NullPointerException(EMFCompareMessages.getString("EMFComparePlugin.LogNullException")); //$NON-NLS-1$
		}

		if (plugin == null) {
			// We are out of eclipse. Prints the stack trace on standard error.
			// CHECKSTYLE:OFF
			e.printStackTrace();
			// CHECKSTYLE:ON
		} else if (e instanceof CoreException) {
			log(((CoreException)e).getStatus());
		} else if (e instanceof NullPointerException) {
			int severity = IStatus.WARNING;
			if (blocker) {
				severity = IStatus.ERROR;
			}
			log(new Status(severity, PLUGIN_ID, severity, EMFCompareMessages
					.getString("EMFComparePlugin.ElementNotFound"), e)); //$NON-NLS-1$
		} else {
			int severity = IStatus.WARNING;
			if (blocker) {
				severity = IStatus.ERROR;
			}
			log(new Status(severity, PLUGIN_ID, severity, EMFCompareMessages
					.getString("EMFComparePlugin.JavaException"), e)); //$NON-NLS-1$
		}
	}

	/**
	 * Puts the given status in the error log view.
	 * 
	 * @param status
	 *            Error Status.
	 */
	public static void log(IStatus status) {
		// Eclipse platform displays NullPointer on standard error instead of throwing it.
		// We'll handle this by throwing it ourselves.
		if (status == null) {
			throw new NullPointerException(EMFCompareMessages.getString("EMFComparePlugin.LogNullStatus")); //$NON-NLS-1$
		}

		if (getDefault() != null) {
			getDefault().getLog().log(status);
		} else
			throw new EMFCompareException(status.getException());
	}

	/**
	 * Puts the given message in the error log view, as error or warning.
	 * 
	 * @param message
	 *            The message to put in the error log view.
	 * @param blocker
	 *            <code>True</code> if the message must be logged as error, <code>False</code> to log it as a
	 *            warning.
	 */
	public static void log(String message, boolean blocker) {
		if (plugin == null) {
			// We are out of eclipse. Prints the message on standard error.
			// CHECKSTYLE:OFF
			System.err.println(message);
			// CHECKSTYLE:ON
		} else {
			int severity = IStatus.WARNING;
			if (blocker) {
				severity = IStatus.ERROR;
			}
			String errorMessage = message;
			if (errorMessage == null || "".equals(errorMessage)) { //$NON-NLS-1$
				errorMessage = EMFCompareMessages.getString("EMFComparePlugin.UnexpectedException"); //$NON-NLS-1$
			}
			log(new Status(severity, PLUGIN_ID, errorMessage));
		}
	}

	/**
	 * Returns the current value of the boolean-valued preference with the given key.
	 * 
	 * @param preferenceKey
	 *            Name of the property which value is to be retrieved.
	 * @return Current value of the boolean-valued preference with the given key.
	 */
	public boolean getBoolean(String preferenceKey) {
		return Platform.getPreferencesService().getBoolean(PLUGIN_ID, preferenceKey, false, null);
	}

	/**
	 * Returns the current value of the integer-valued preference with the given key.
	 * 
	 * @param preferenceKey
	 *            Name of the property which value is to be retrieved.
	 * @return Current value of the integer-valued preference with the given key.
	 */
	public int getInt(String preferenceKey) {
		return Platform.getPreferencesService().getInt(PLUGIN_ID, preferenceKey, 0, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Plugin#start(BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		initializeDefaultPreferences();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Plugin#stop(BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * This will initialize the core preferences to their default values.
	 */
	private void initializeDefaultPreferences() {
		final IEclipsePreferences defaultCorePreferences = new DefaultScope().getNode(PLUGIN_ID);
		defaultCorePreferences.putInt(EMFComparePreferenceConstants.PREFERENCES_KEY_SEARCH_WINDOW,
				EMFComparePreferenceConstants.PREFERENCES_DEFAULT_SEARCH_WINDOW);
		/*
		 * "ignore ID", "ignore XMI ID", "distinct metamodel" and "Engine selection" are all initialized to
		 * false and don't need a default
		 */
	}
}
