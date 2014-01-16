/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * A singleton class for the text resource UI plug-in.
 */
public class TestpropertiesUIPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "org.emftext.refactoring.tests.properties.resource.testproperties.ui";
	public static final String EDITOR_ID = "org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesEditor";
	public static final String EMFTEXT_SDK_VERSION = "1.4.1";
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + ".additional_extension_parser";
	
	private static TestpropertiesUIPlugin plugin;
	
	public TestpropertiesUIPlugin() {
		super();
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static TestpropertiesUIPlugin getDefault() {
		return plugin;
	}
	
	public static void showErrorDialog(final String title, final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Shell parent = new Shell();
				MessageDialog dialog = new MessageDialog(parent, title, null, message, MessageDialog.ERROR, new String[] { IDialogConstants.OK_LABEL }, 0) {
				};
				dialog.open();
			}
		});
	}
	
	/**
	 * Helper method for error logging.
	 * 
	 * @param message the error message to log
	 * @param exception the exception that describes the error in detail
	 * 
	 * @return the status object describing the error
	 */
	public static IStatus logError(String message, Throwable exception) {
		IStatus status;
		if (exception != null) {
			status = new Status(IStatus.ERROR, TestpropertiesUIPlugin.PLUGIN_ID, 0, message, exception);
		} else {
			status = new Status(IStatus.ERROR, TestpropertiesUIPlugin.PLUGIN_ID, message);
		}
		final TestpropertiesUIPlugin pluginInstance = TestpropertiesUIPlugin.getDefault();
		if (pluginInstance == null) {
			System.err.println(message);
			if (exception != null) {
				exception.printStackTrace();
			}
		} else {
			pluginInstance.getLog().log(status);
		}
		return status;
	}
	
}
