/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * A provider class for all images that are required by the generated UI plug-in.
 * The default implementation load images from the bundle and caches them to make
 * sure each image is loaded at most once.
 */
public class CoedImageProvider {
	
	public final static CoedImageProvider INSTANCE = new CoedImageProvider();
	
	private Map<String, Image> imageCache = new LinkedHashMap<String, Image>();
	
	/**
	 * Returns the image associated with the given key. The key can be either a path
	 * to an image file in the resource bundle or a shared image from
	 * org.eclipse.ui.ISharedImages.
	 */
	public Image getImage(String key) {
		if (key == null) {
			return null;
		}
		Image image = null;
		// try shared images
		try {
			java.lang.reflect.Field declaredField = ISharedImages.class.getDeclaredField(key);
			Object valueObject = declaredField.get(null);
			if (valueObject instanceof String) {
				String value = (String) valueObject;
				image = PlatformUI.getWorkbench().getSharedImages().getImage(value);
			}
		} catch (java.lang.SecurityException e) {
		} catch (java.lang.NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (java.lang.IllegalAccessException e) {
		}
		if (image != null) {
			return image;
		}
		
		// try cache
		if (imageCache.containsKey(key)) {
			return imageCache.get(key);
		}
		
		// try loading image from UI bundle
		ImageDescriptor descriptor = getImageDescriptor(key);
		if (descriptor == null) {
			return null;
		}
		image = descriptor.createImage();
		if (image == null) {
			return null;
		}
		imageCache.put(key, image);
		return image;
	}
	
	/**
	 * Returns the image for the given key. Possible keys are:
	 * <ul>
	 * <li>platform:/plugin/your.plugin/icons/yourIcon.png</li>
	 * <li>bundleentry://557.fwk3560063/icons/yourIcon.png</li>
	 * </ul>
	 */
	public ImageDescriptor getImageDescriptor(String key) {
		IPath path = new Path(key);
		org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin plugin = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault();
		if (plugin == null) {
			return null;
		}
		
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(org.eclipse.core.runtime.FileLocator.find(plugin.getBundle(), path, null));
		if (ImageDescriptor.getMissingImageDescriptor().equals(descriptor) || descriptor == null) {
			// try loading image from any bundle
			try {
				java.net.URL pluginUrl = new java.net.URL(key);
				descriptor = ImageDescriptor.createFromURL(pluginUrl);
				if (ImageDescriptor.getMissingImageDescriptor().equals(descriptor) || descriptor == null) {
					return null;
				}
			} catch (java.net.MalformedURLException mue) {
				org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.logError("IconProvider can't load image (URL is malformed).", mue);
			}
		}
		return descriptor;
	}
	
}
