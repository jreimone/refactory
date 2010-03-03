package org.emftext.refactoring.registry.rolemodel;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.emftext.refactoring.registry.rolemodel";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	public void log(String message, int status){
		getLog().log(new Status(status, PLUGIN_ID, message));
		Level level = null;
		switch (status) {
		case IStatus.ERROR:
			level = Level.SEVERE;
			break;
		case IStatus.INFO:
			level = Level.INFO;
			break;
		case IStatus.WARNING:
			level = Level.WARNING;
			break;
		default:
			break;
		}
		Logger.getLogger(PLUGIN_ID).log(level, message);
	}
}
