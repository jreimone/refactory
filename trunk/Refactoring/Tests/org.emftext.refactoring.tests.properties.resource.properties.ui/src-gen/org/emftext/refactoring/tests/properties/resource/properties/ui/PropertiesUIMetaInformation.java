/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesUIMetaInformation extends org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation {
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesHoverTextProvider getHoverTextProvider() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesHoverTextProvider();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesImageProvider getImageProvider() {
		return org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesImageProvider.INSTANCE;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager createColorManager() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.
	 * IPropertiesTextResource,
	 * org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorM
	 * anager) instead.
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager colorManager) {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner(resource, colorManager);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCodeCompletionHelper();
	}
	
}
