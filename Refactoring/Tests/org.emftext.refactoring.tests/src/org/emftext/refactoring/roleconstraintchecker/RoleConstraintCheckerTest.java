/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
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

	private String path = "resources/relationTestMapping.rolemapping";
	private RoleMappingModel mappingModel;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		mappingModel = getExpectedModelFromFile(path, RoleMappingModel.class);
	}
	
	public void testProhibitionConstraints(){
		EcoreUtil.resolveAll(mappingModel);
		EPackage metamodel = mappingModel.getTargetMetamodel();
		assertNotNull("Metamodel mustn't be null", metamodel);
		EList<Mapping> mappings = mappingModel.getMappings();
		assertTrue("There must be mappings", mappings.size() > 0);
		EList<EObject> prohibitionMappings = ModelUtil.filterObjectsByAttribute(mappings.iterator(), "name", "TestProhibitionMapping");
		assertTrue("There must be a prohibition mapping", prohibitionMappings.size() == 1);
		Mapping prohibitionMapping = (Mapping) prohibitionMappings.get(0);
//		prohibitionMapping.getMappedRoleModel()
		EList<ConcreteMapping> concreteMappings = prohibitionMapping.getRoleToMetaelement();
		assertTrue("There must be concrete mappings", concreteMappings.size() > 0);
		IRoleConstraintValidator validator = RoleConstraintValidatorFactory.eInstance.getValidator(mappingModel);
		assertNotNull("Validator mustn't be null", validator);
		List<IStatus> stati = validator.validateMapping((Mapping) prohibitionMappings.get(0));
		assertTrue("There must be 2 error status", stati.size() == 2);
		assertTrue("The status code must be an ERROR", stati.get(0).getSeverity() == IStatus.ERROR);
	}
}
