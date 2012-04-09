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
 * 
 */
package org.emftext.refactoring.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.NamedElement;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.test.core.TestClass;
import org.junit.Test;

/**
 * @author Jan Reimann
 *
 */
public class UtilTestFragment extends TestClass{

	private String pathRoleModel = "/roles/ExtractMethod.rolestext";
	private String pathRoleMapping = "/role_mappings/pl0mapping.rolemapping";


	@Test
	public void modelUtilGetObjectsByType(){
		IRoleModelRegistry registry = IRoleModelRegistry.INSTANCE;
		RoleModel roleModel = registry.getRoleModelByName("ExtractX");
		EList<Role> roles = ModelUtil.getObjectsByType(roleModel.eAllContents(), Role.class);
		assertTrue("Both lists must contain the same roles", roleModel.getRoles().containsAll(roles));
	}
	
	@Test
	public void modelUtilFilterObjectsAttribute(){
		IRoleModelRegistry registry = IRoleModelRegistry.INSTANCE;
		RoleModel roleModel = registry.getRoleModelByName("ExtractX");
		EList<EObject> mappings = ModelUtil.filterObjectsByAttribute(roleModel.eAllContents(), "name", "Extractee");
		assertEquals("There must be 1 role with modifier 'input'", 1, mappings.size());
		assertTrue("The filtered element must be an instance of 'NamedElement'", mappings.get(0) instanceof NamedElement);
	}
}
