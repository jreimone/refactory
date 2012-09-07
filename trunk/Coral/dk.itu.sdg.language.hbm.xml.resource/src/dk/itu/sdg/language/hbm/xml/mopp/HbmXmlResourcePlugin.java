package dk.itu.sdg.language.hbm.xml.mopp;


public class HbmXmlResourcePlugin extends org.eclipse.ui.plugin.AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "dk.itu.sdg.language.hbm.xml.resource";
	public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + ".additional_extension_parser";
	
	private static HbmXmlResourcePlugin plugin;
	
	public HbmXmlResourcePlugin() {
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
	
	public static HbmXmlResourcePlugin getDefault() {
		return plugin;
	}
	
	// Helper method for error logging.
	//
	// @param message
	//            the error message
	// @param exception
	//            the exception that describes the error in detail
	// @return the status object describing the error
	//
	public static org.eclipse.core.runtime.IStatus logError(String message, Throwable exception) {
		org.eclipse.core.runtime.IStatus status;
		if (exception != null) {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, HbmXmlResourcePlugin.PLUGIN_ID, 0, message, exception);
		} else {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, HbmXmlResourcePlugin.PLUGIN_ID, message);
		}
		final HbmXmlResourcePlugin pluginInstance = HbmXmlResourcePlugin.getDefault();
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
