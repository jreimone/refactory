/**
 * 
 */
package org.emftext.refactoring.indexconnector.impl;

import org.emftext.refactoring.indexconnector.IndexConnector;
import org.emftext.refactoring.indexconnector.IndexConnectorFactory;

/**
 * @author Jan Reimann
 *
 */
public class SokanIndexConnectorFactory implements IndexConnectorFactory {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.indexconnector.IndexConnectorFactory#getIndexConnector()
	 */
	public IndexConnector getIndexConnector() {
		return new SokanIndexConnector();
	}

}
