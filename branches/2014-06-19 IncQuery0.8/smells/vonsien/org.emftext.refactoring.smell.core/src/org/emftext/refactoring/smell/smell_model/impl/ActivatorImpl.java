package org.emftext.refactoring.smell.smell_model.impl;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class ActivatorImpl extends AbstractUIPlugin {

		public static final String PLUGIN_ID = "org.emftext.refactoring.smell.core";

		private static ActivatorImpl plugin;
		
		/**
		 * The constructor
		 */
		public ActivatorImpl() {
		}

		public void start(BundleContext context) throws Exception {
			super.start(context);
			plugin = this;
		}

		public void stop(BundleContext context) throws Exception {
			plugin = null;
			super.stop(context);
		}

		/**
		 * Returns the shared instance
		 *
		 * @return the shared instance
		 */
		public static ActivatorImpl getDefault() {
			return plugin;
		}

}