/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.AbstractRefactoringTest;
import org.emftext.refactoring.util.ModelUtil;
import org.junit.Before;

/**
 * Tests the constraints between roles with the mapped classes
 * 
 * @author Jan Reimann
 *
 */
public class RoleConstraintCheckerTest extends AbstractRefactoringTest {

//	private String path = "test/testMapping.rolemapping";
	private String path = "resources/relationTestMapping.rolemapping";
//	private String path1 = "resources/TestAssociation.rolestext";
//	private String path2 = "resources/TestComposition.rolestext";
//	private String path3 = "resources/TestImplication.rolestext";
//	private String path4 = "resources/TestProhibition.rolestext";
	private RoleMappingModel mappingModel;
	private List<RoleModel> roleModels;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		mappingModel = getExpectedModelFromFile(path, RoleMappingModel.class);
		roleModels = new ArrayList<RoleModel>();
//		roleModels.add(getExpectedModelFromFile(path1, RoleModel.class));
//		roleModels.add(getExpectedModelFromFile(path2, RoleModel.class));
//		roleModels.add(getExpectedModelFromFile(path3, RoleModel.class));
//		roleModels.add(getExpectedModelFromFile(path4, RoleModel.class));
	}
	
	public void testProhibitionConstraints(){
//		EcoreUtil.resolveAll(mappingModel);
		EPackage metamodel = mappingModel.getTargetMetamodel();
		assertNotNull("Metamodel mustn't be null", metamodel);
		EList<Mapping> mappings = mappingModel.getMappings();
		assertTrue("There must be mappings", mappings.size() > 0);
		EList<EObject> prohibitionMappings = ModelUtil.filterObjectsByAttribute(mappings.iterator(), "name", "TestProhibitionMapping");
		assertEquals("There must be a prohibition mapping", 1, prohibitionMappings.size());
		Mapping prohibitionMapping = (Mapping) prohibitionMappings.get(0);
//		prohibitionMapping.getMappedRoleModel()
		EList<ConcreteMapping> concreteMappings = prohibitionMapping.getRoleToMetaelement();
		assertTrue("There must be concrete mappings", concreteMappings.size() > 0);
		IRoleConstraintValidator validator = RoleConstraintValidatorFactory.eInstance.getValidator(mappingModel);
		assertNotNull("Validator mustn't be null", validator);
		List<IStatus> stati = validator.validateMapping((Mapping) prohibitionMappings.get(0));
		assertEquals("There must be 2 error status", 2, stati.size());
		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(0).getSeverity());
		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(1).getSeverity());
	}
}
