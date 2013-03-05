/**
 * 
 */
package org.qualitune.tracing.vapodi;

import org.qualitune.tracing.umt.Program;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public interface IConcreteLanguageHandler {
	/**
	 * Load a native language program from {@link path}.
	 * @param path File to read program from.
	 * @return indicate success (true) / failure (false)
	 */
	public boolean loadModel(String path);
	
	
	/**
	 * Return UMT representation of earlier loaded program. Note that this program
	 * may be altered through calls to its getters and setters and may have additional
	 * instructions added. The implementor of the interface should subscribe to be 
	 * notified of these changes and mirror them in the original program.
	 * 
	 * @return UMT representation of earlier loaded program.
	 */
	public Program getUmtRepresentation();
	
	/**
	 * Write native language program represented by earlier returned and possibly
	 * altered UMT representation to {@link path}.
	 * @param path File to write program to.
	 * @return indicate success (true) / failure (false)
	 */
	public boolean writeModel(String path);
}
