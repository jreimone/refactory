/**
 * 
 */
package org.emftext.refactoring.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.Test;

/**
 * @author Jan Reimann
 *
 */
public class UtilTest{

	private String pathRoleModel = "/roles/ExtractMethod.rolestext";
	private String pathRoleMapping = "/role_mappings/pl0mapping.rolemapping";
	private RoleModel roleModel;
	private RoleMappingModel mappingModel;


	@Test
	public void modelUtilGetObjectsByType(){
//		roleModel = getExpectedModelFromFile(pathRoleModel, RoleModel.class);
		EList<Role> roles = ModelUtil.getObjectsByType(roleModel.eAllContents(), Role.class);
		assertTrue("Both lists must contain the same roles", roleModel.getRoles().containsAll(roles));
	}
	
	@Test
	public void modelUtilFilterObjectsAttribute(){
//		mappingModel = getExpectedModelFromFile(pathRoleMapping, RoleMappingModel.class);
		EList<EObject> mappings = ModelUtil.filterObjectsByAttribute(mappingModel.eAllContents(), "name", "ExtractMethod4Statements");
		assertEquals("There must be 1 mapping with name 'ExtractMethod4Statements'", 1, mappings.size());
		assertTrue("The filtered element must be an instance of 'RoleMapping'", mappings.get(0) instanceof RoleMapping);
	}
}
