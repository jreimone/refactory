package org.ontomore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.ontomore.util.modelProvider.RoleModelProvider.RENAME_X;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.junit.Test;
import org.ontomore.util.modelProvider.EcoreRoleMappingProvider;
import org.ontomore.util.modelProvider.OWLRoleMappingProvider;
import org.ontomore.util.modelProvider.RefSpecProvider;
import org.ontomore.util.modelProvider.RoleMappingModelProvider;
import org.ontomore.util.modelProvider.RoleModelProvider;

public class ModelProviderTest {

	@Test
	public void testRoleModelProvider() {
		assertTrue(RENAME_X.toString().contains("RenameX.rolestext"));
	}
	
	@Test
	public void testAllRoleModelNames() {
		for (RoleModelProvider roleModelProvider : RoleModelProvider.values()) {
			assertTrue(roleModelProvider.toString().contains(".rolestext"));
		}
	}
	
	@Test
	public void testAllRoleModels() {
		for (RoleModelProvider roleModelProvider : RoleModelProvider.values()) {
			RoleModel roleModel = roleModelProvider.toModel();
			assertTrue(roleModel.toString().contains("RoleModelImpl"));
		}
	}

	@Test
	public void testRefSpecProvider() {
		assertTrue(RefSpecProvider.RENAME_X.toString().contains("RenameX.refspec"));
	}
	
	@Test
	public void testAllRefSpecNames() {
		for (RefSpecProvider refSpecProvider : RefSpecProvider.values()) {
			assertTrue(refSpecProvider.toString().contains(".refspec"));
		}
	}
	
	@Test
	public void testAllRefSpecs() {
		for (RefSpecProvider refSpecProvider : RefSpecProvider.values()) {
			RefactoringSpecification refSpec = refSpecProvider.toModel();
			assertTrue(refSpec.toString().contains("RefactoringSpecificationImpl"));
		}
	}
	
	@Test
	public void testOWLRoleMappingModelProvider() {
		assertTrue(RoleMappingModelProvider.OWL_RENAME.toString().contains("rename.rolemapping"));
	}
	
	@Test
	public void testAllOWLRoleMappingModelNames() {
		for (RoleMappingModelProvider roleMappingModelProvider : RoleMappingModelProvider.values()) {
			assertTrue(roleMappingModelProvider.toString().contains(".rolemapping"));
		}
	}
	
	@Test
	public void testAllRoleMappingModels() {
		for (RoleMappingModelProvider roleMappingModelProvider : RoleMappingModelProvider.values()) {
			RoleMappingModel roleMappingModel = roleMappingModelProvider.toModel();
			assertTrue(roleMappingModel.toString().contains("RoleMappingModelImpl"));
		}
	}

	@Test
	public void testGetOWLRoleMapping() {
		RoleMapping roleMapping = OWLRoleMappingProvider.RENAME_ELEMENT.toRoleMapping();
		Object nameOfAcutalRoleMapping = roleMapping.getName();
		String nameOfExpectedRoleMapping = "Rename Element";
		assertEquals(nameOfExpectedRoleMapping, nameOfAcutalRoleMapping);
	}
	
	@Test
	public void testAllOWLRoleMappings() {
		for (OWLRoleMappingProvider roleMappingProvider : OWLRoleMappingProvider.values()) {
			RoleMapping roleMapping = roleMappingProvider.toRoleMapping();
			assertTrue(roleMapping.toString().contains("RoleMappingImpl"));
		}
	}
	
	@Test
	public void testAllEcoreRoleMappings() {
		for (EcoreRoleMappingProvider roleMappingProvider : EcoreRoleMappingProvider.values()) {
			RoleMapping roleMapping = roleMappingProvider.toRoleMapping();
			assertTrue(roleMapping.toString().contains("RoleMappingImpl"));
		}
	}
}
