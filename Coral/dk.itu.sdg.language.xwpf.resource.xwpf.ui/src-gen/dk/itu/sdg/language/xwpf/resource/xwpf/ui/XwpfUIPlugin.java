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
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

/**
 * A singleton class for the text resource UI plug-in.
 */
public class XwpfUIPlugin extends org.eclipse.ui.plugin.AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "dk.itu.sdg.language.xwpf.resource.xwpf.ui";
	public static final String EDITOR_ID = "dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfEditor";
	public static final String EMFTEXT_SDK_VERSION = "1.4.1";
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + ".additional_extension_parser";
	
	private static XwpfUIPlugin plugin;
	
	public XwpfUIPlugin() {
		super();
	}
	
	public void start(org.osgi.framework.BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	public void stop(org.osgi.framework.BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static XwpfUIPlugin getDefault() {
		return plugin;
	}
	
	public static void showErrorDialog(final String title, final String message) {
		org.eclipse.swt.widgets.Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				org.eclipse.swt.widgets.Shell parent = new org.eclipse.swt.widgets.Shell();
				org.eclipse.jface.dialogs.MessageDialog dialog = new org.eclipse.jface.dialogs.MessageDialog(parent, title, null, message, org.eclipse.jface.dialogs.MessageDialog.ERROR, new String[] { org.eclipse.jface.dialogs.IDialogConstants.OK_LABEL }, 0) {
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
	public static org.eclipse.core.runtime.IStatus logError(String message, Throwable exception) {
		org.eclipse.core.runtime.IStatus status;
		if (exception != null) {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, XwpfUIPlugin.PLUGIN_ID, 0, message, exception);
		} else {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, XwpfUIPlugin.PLUGIN_ID, message);
		}
		final XwpfUIPlugin pluginInstance = XwpfUIPlugin.getDefault();
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
