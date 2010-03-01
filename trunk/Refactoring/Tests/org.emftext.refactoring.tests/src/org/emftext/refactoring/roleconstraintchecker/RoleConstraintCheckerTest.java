/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.test.test.AbstractRefactoringTest;
import org.junit.Test;

/**
 * Tests the constraints between roles with the mapped classes
 * 
 * @author Jan Reimann
 *
 */
public class RoleConstraintCheckerTest{
		
	private String path = "/constraintresources/relationTestMapping.rolemapping";
	private RoleMappingModel mappingModel;
	
	@Test
	public void prohibitionConstraints(){
//		mappingModel = getExpectedModelFromFile(path, RoleMappingModel.class);
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
		IRoleConstraintValidator validator = RoleConstraintValidatorFactory.eINSTANCE.createValidator();
		assertNotNull("Validator mustn't be null", validator);
		List<IStatus> stati = validator.validateMapping(prohibitionMapping);
		assertEquals("There must be 2 error status", 2, stati.size());
//		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(0).getSeverity());
//		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(1).getSeverity());
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.test.AbstractRefactoringTest#getFolderNamesToCopyIntoTestProject()
	 */

}
