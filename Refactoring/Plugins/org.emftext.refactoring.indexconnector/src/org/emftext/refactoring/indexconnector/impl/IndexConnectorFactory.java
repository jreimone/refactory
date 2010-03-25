/**
 * 
 */
package org.emftext.refactoring.indexconnector.impl;

import org.emftext.refactoring.indexconnector.IndexConnector;

/**
 * Factory for {@link IndexConnector}s.
 * 
 * @author Jan Reimann
 *
 */
public interface IndexConnectorFactory {

	public static final IndexConnectorFactory defaultINSTANCE = new DefaultIndexConnectorFactory();
	
	/**
	 * Returns the specific {@link IndexConnector}.
	 * @return
	 */
	public IndexConnector getIndexConnector();
	
	/**
	 * Returns an instance of the given {@link IndexConnector} <code>clazz</code>
	 * @param clazz
	 * @return
	 */
	public IndexConnector getIndexConnector(Class<? extends IndexConnector> clazz);
}
