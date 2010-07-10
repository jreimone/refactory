package org.emftext.refactoring.util;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class RefactoringUtilPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.emftext.refactoring.util";

	// The shared instance
	private static RefactoringUtilPlugin plugin;

	public RefactoringUtilPlugin() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static RefactoringUtilPlugin getDefault() {
		if (plugin == null) {
			plugin = new RefactoringUtilPlugin();
		}
		return plugin;
	}
}
