/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.coral.resource.coral.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * A singleton class for the text resource UI plug-in.
 */
public class CoralUIPlugin extends org.eclipse.ui.plugin.AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "dk.itu.sdg.language.coral.resource.coral.ui";
	public static final String EDITOR_ID = "dk.itu.sdg.language.coral.resource.coral.ui.CoralEditor";
	public static final String EMFTEXT_SDK_VERSION = "1.4.1";
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + ".additional_extension_parser";
	
	private static ImageRegistry sImageRegistry; 
	
	private static CoralUIPlugin plugin;
	
	public CoralUIPlugin() {
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
	
	public static CoralUIPlugin getDefault() {
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
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, CoralUIPlugin.PLUGIN_ID, 0, message, exception);
		} else {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, CoralUIPlugin.PLUGIN_ID, message);
		}
		final CoralUIPlugin pluginInstance = CoralUIPlugin.getDefault();
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
	
	
	//adapted from http://www.eclipsezone.com/eclipse/forums/t28067.html
	
	public static ImageDescriptor getImageDescriptor(String pluginRelativePath) {
		return getImageDescriptor(getPluginRelativeURL(pluginRelativePath));
	}

	public static ImageDescriptor getImageDescriptor(URL descriptorURL) {
		ImageDescriptor descriptor = null;

		if (descriptorURL != null) {
			descriptor = ImageDescriptor.createFromURL(descriptorURL);
		}

		return descriptor;
	}

	private static URL getPluginRelativeURL(String pluginRelativePath) {
		try {
			return new URL(plugin.getBundle().getEntry("/"), pluginRelativePath);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Image getImage(String pluginRelativePath) {
		try {
			URL imageUrl = new URL(plugin.getBundle( ).getEntry("/"), pluginRelativePath);

			return getImage(imageUrl);
		} catch ( MalformedURLException e ) {
			e.printStackTrace();
		}

		return null;
	}

	public static Image getImage(URL imageURL) {
		Image image = null;

		if (imageURL != null) {
			String key = imageURL.toString();

			image = getImageFromRegistry(key);

			if (image == null) {
				ImageDescriptor id = ImageDescriptor.createFromURL(imageURL);

				if (id != null) {
					image = id.createImage();
					putImageInRegistry(key, image);
				}
			}
		}	

		return image;
	}

	private synchronized static void putImageInRegistry(String key, Image image) {
		getPluginImageRegistry().put(key, image);
	}

	private synchronized static Image getImageFromRegistry(String key) {
		return getPluginImageRegistry().get(key);
	}

	private static ImageRegistry getPluginImageRegistry() {
		if (sImageRegistry == null) {
			if (getDefault() != null) {
				Display.getDefault( ).syncExec( new Runnable() {
					public void run() {
						sImageRegistry = getDefault().getImageRegistry();
					}
				});
			} else {
				sImageRegistry = new ImageRegistry();
			}
		}

		return sImageRegistry;
	} 
	
}
