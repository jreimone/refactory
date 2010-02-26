/**
 * 
 */
package org.emftext.refactoring.indexconnector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.Program;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.AbstractRefactoringTest;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.refactoring.util.ModelUtil;
import org.junit.Test;

/**
 * @author Jan Reimann
 *
 */
public class IndexConnectorTest{

	private String path = "/pl0/wirth.pl0";
	private String roleMappingPath = "/role_mappings/pl0mapping.rolemapping";
	private String roleModelPath = "/roles/ExtractMethod.rolestext";
	private String refSpecPath = "/refspecs/ExtractMethod.refspec";
	
	@Test
	public void connectorGetRoleMapping(){
//		Resource resource = TestUtil.getResourceInWorkspace(this, path);
		Resource resource = null;
		IndexConnector connector = IndexConnectorFactory.defaultINSTANCE.getIndexConnector();
		assertNotNull(connector);
		Program pl0Prog = TestUtil.getExpectedModelFromResource(resource, Program.class);
//		delay(3000);
		RoleMappingModel mappingModel = connector.getRoleMapping(pl0Prog.eClass().getEPackage().getNsURI());
//		delay(3000);
		assertNotNull(mappingModel);
//		Resource mappingResource = TestUtil.getResourceInWorkspace(this, roleMappingPath);
		Resource mappingResource = null;
		RoleMappingModel targetMM = TestUtil.getExpectedModelFromResource(mappingResource, RoleMappingModel.class);
		//		assertTrue(ModelUtil.bothModelsAreEqual(mappingModel, targetMM));
//		assertEquals(mappingModel, targetMM);
	}
	
	@Test
	public void connectorGetRefSpec(){
		IndexConnector connector = IndexConnectorFactory.defaultINSTANCE.getIndexConnector();
		assertNotNull(connector);
//		Resource resource = TestUtil.getResourceInWorkspace(this, roleModelPath);
		Resource resource = null;
		RoleModel roleModel = TestUtil.getExpectedModelFromResource(resource, RoleModel.class);
//		delay(3000);
		RefactoringSpecification refSpec = connector.getRefactoringSpecification(roleModel);
//		delay(3000);
		assertNotNull(refSpec);
//		Resource refSpecResource = TestUtil.getResourceInWorkspace(this, refSpecPath);
		Resource refSpecResource = null;
		RefactoringSpecification refSpecTarget = TestUtil.getExpectedModelFromResource(refSpecResource, RefactoringSpecification.class);
//		assertEquals(refSpec, refSpecTarget);
	}
}
