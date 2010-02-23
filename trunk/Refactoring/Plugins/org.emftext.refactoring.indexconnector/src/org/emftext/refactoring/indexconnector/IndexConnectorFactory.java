/**
 * 
 */
package org.emftext.refactoring.indexconnector;

import org.emftext.refactoring.indexconnector.impl.SokanIndexConnectorFactory;

/**
 * Factory for {@link IndexConnector}s.
 * 
 * @author Jan Reimann
 *
 */
public interface IndexConnectorFactory {

	public static final IndexConnectorFactory defaultINSTANCE = new SokanIndexConnectorFactory();
	
	/**
	 * Returns the specific {@link IndexConnector}.
	 * @return
	 */
	public IndexConnector getIndexConnector();
}
