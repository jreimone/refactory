/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.util;

import org.eclipse.core.runtime.Platform;

/**
 * This utility class provides methods to obtain information about the current
 * runtime, for example whether Eclipse is available or not.
 */
public class CoedRuntimeUtil {
	
	/**
	 * Checks whether the class <code>EMFModelValidationPlugin</code> is available on
	 * the classpath. This can be used to determine if Eclipse is available in the
	 * current runtime environment.
	 */
	public boolean isEMFValidationAvailable() {
		try {
			Class.forName("org.eclipse.emf.validation.internal.EMFModelValidationPlugin");
			return true;
		} catch (ClassNotFoundException cnfe) {
		}
		return false;
	}
	
	/**
	 * Checks whether the class <code>org.eclipse.core.runtime.Platform</code> is
	 * available on the classpath. This can be used to determine if EMF Validation is
	 * available in the current runtime environment.
	 */
	public boolean isEclipsePlatformAvailable() {
		try {
			Class.forName("org.eclipse.core.runtime.Platform");
			return true;
		} catch (ClassNotFoundException cnfe) {
		}
		return false;
	}
	
	/**
	 * Logs the given error. If Eclipse is running, the error is added to the error
	 * log otherwise the message is printed to System.err.
	 */
	public void logError(String message, Throwable exception) {
		if (isEclipsePlatformAvailable()) {
			org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedPlugin.logError(message, exception);
			return;
		}
		System.err.println(message);
		if (exception != null) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Logs the given warning. If Eclipse is running, the warning is added to the
	 * error log otherwise the message is printed to System.err.
	 */
	public void logWarning(String message, Throwable exception) {
		if (isEclipsePlatformAvailable()) {
			org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedPlugin.logWarning(message, exception);
			return;
		}
		System.err.println(message);
		if (exception != null) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Checks whether the Eclipse platform is running.
	 */
	public boolean isEclipsePlatformRunning() {
		if (!isEclipsePlatformAvailable()) {
			return false;
		}
		return Platform.isRunning();
	}
	
}
