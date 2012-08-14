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
package org.emftext.language.refactoring.specification.resource.ui;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextHoverTextProvider;
import org.emftext.language.refactoring.specification.resource.IRefspecHoverTextProvider;

public class RefspecHoverTextProvider implements IRefspecHoverTextProvider {
	
	private RefspecDefaultHoverTextProvider defaultProvider = new RefspecDefaultHoverTextProvider();
	
	public String getHoverText(EObject container, EObject referencedObject) {
		return getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		if (object.eClass().getEPackage().equals(RolesPackage.eINSTANCE)) {
			RolestextHoverTextProvider rolesHoverProvider = new RolestextHoverTextProvider();
			return rolesHoverProvider.getHoverText(object);
		}
		return defaultProvider.getHoverText(object);
	}
	
}
