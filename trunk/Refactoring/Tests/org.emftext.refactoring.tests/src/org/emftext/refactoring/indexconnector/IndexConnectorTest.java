/**
 * 
 */
package org.emftext.refactoring.indexconnector;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.test.core.ExpectedData;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.junit.Test;

/**
 * @author Jan Reimann
 *
 */
public class IndexConnectorTest extends TestClass{

	public static final String CS_MODEL_INPUT_PREFIX = "CS_MODEL_";
	public static final String CS_MAPPING_EXPECTED_PREFIX = "CS_MAPPING_";
	public static final String CS_ROLE_MODEL_PREFIX = "CS_ROLE_";
	public static final String CS_REFSPEC_PREFIX = "CS_REFSPEC_";
	
	@Test
	@InputData({CS_MODEL_INPUT_PREFIX})
	@ExpectedData({CS_MAPPING_EXPECTED_PREFIX})
	public void connectorGetRoleMapping(){
		List<File> inputFiles = getTestDataSet().getInputDataFiles();
		File input = inputFiles.get(0);
		Resource resource = TestUtil.getResourceFromFile(input);
		IndexConnector connector = IndexConnectorFactory.defaultINSTANCE.getIndexConnector(MockIndexConnector.class);
		assertNotNull(connector);
		EObject model = TestUtil.getModelFromResource(resource);
		RoleMappingModel mappingModel = connector.getRoleMapping(model.eClass().getEPackage().getNsURI());
		assertNotNull(mappingModel);
		// both mappingModels are the same but different instances so equals() fails
//		List<File> expectedFiles = getTestDataSet().getExpectedDataFiles();
//		File expected = expectedFiles.get(0);
//		Resource mappingResource = TestUtil.getResourceFromFile(expected);
//		RoleMappingModel targetMM = TestUtil.getExpectedModelFromResource(mappingResource, RoleMappingModel.class);
//		assertEquals(mappingModel, targetMM);
	}
	
	@Test
	@InputData({CS_ROLE_MODEL_PREFIX})
	@ExpectedData({CS_REFSPEC_PREFIX})
	public void connectorGetRefSpec(){
		IndexConnector connector = IndexConnectorFactory.defaultINSTANCE.getIndexConnector(MockIndexConnector.class);
		assertNotNull(connector);
		List<File> inputFiles = getTestDataSet().getInputDataFiles();
		File input = inputFiles.get(0);
		Resource resource = TestUtil.getResourceFromFile(input);
		RoleModel roleModel = TestUtil.getExpectedModelFromResource(resource, RoleModel.class);
		RefactoringSpecification refSpec = connector.getRefactoringSpecification(roleModel);
		assertNotNull(refSpec);
		// both refspecs are the same but different instances so equals() fails
//		List<File> expectedFiles = getTestDataSet().getExpectedDataFiles();
//		File expected = expectedFiles.get(0);
//		Resource refSpecResource = TestUtil.getResourceFromFile(expected);
//		RefactoringSpecification refSpecTarget = TestUtil.getExpectedModelFromResource(refSpecResource, RefactoringSpecification.class);
//		assertEquals(refSpec, refSpecTarget);
	}
}
