package org.emftext.refactoring.indexconnector.impl;

import org.emftext.refactoring.indexconnector.IndexConnector;

public class DefaultIndexConnectorFactory implements IndexConnectorFactory {

	public IndexConnector getIndexConnector() {
		return new CrossReferenceIndexConnector();
	}

	public IndexConnector getIndexConnector(Class<? extends IndexConnector> clazz) {
		IndexConnector connector = null;
		try {
			connector = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return connector;
	}

}
