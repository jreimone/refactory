/**
 * 
 */
package org.emftext.refactoring.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.AbstractRefactoringTest;

/**
 * @author Jan Reimann
 *
 */
public class UtilTest extends AbstractRefactoringTest {

	private String pathRoleModel = "resources/ExtractMethod.rolestext";
	private String pathRoleMapping = "resources/relationTestMapping.rolemapping";
	private RoleModel roleModel;
	private RoleMappingModel mappingModel;
	
	/* (non-Javadoc)
	 * @see org.emftext.refactoring.test.AbstractRefactoringTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		roleModel = getExpectedModelFromFile(pathRoleModel, RoleModel.class);
		mappingModel = getExpectedModelFromFile(pathRoleMapping, RoleMappingModel.class);
	}

	public void testModelUtilGetObjectsByType(){	
		EList<Role> roles = ModelUtil.getObjectsByType(roleModel.eAllContents(), Role.class);
		assertTrue("Both lists must contain the same roles", roleModel.getRoles().containsAll(roles));
	}
	
	public void testModelUtilFilterObjectsAttribute(){
		EList<EObject> mappings = ModelUtil.filterObjectsByAttribute(mappingModel.eAllContents(), "name", "TestProhibitionMapping");
		assertEquals("There must be 1 mapping with name 'TestProhibitionMapping'", 1, mappings.size());
		assertTrue("The filtered element must be an instance of 'Mapping'", mappings.get(0) instanceof Mapping);
	}
}
