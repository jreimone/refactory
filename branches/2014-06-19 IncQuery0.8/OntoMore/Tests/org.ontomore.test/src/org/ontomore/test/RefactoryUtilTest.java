package org.ontomore.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ontomore.util.ModelStorageUtil;
import org.ontomore.util.QueryUtil;
import org.ontomore.util.RefactoryUtil;
import org.ontomore.util.modelProvider.RefSpecProvider;
import org.ontomore.util.modelProvider.RoleMappingModelProvider;
import org.ontomore.util.modelProvider.RoleModelProvider;

public class RefactoryUtilTest {


	private String base = ModelStorageUtil.getBase("org.ontomore.test");
	
	private static RefactoryUtil refactoryUtil;

	@BeforeClass
	public static void setUp() {
		initRefactoryUtil();
	}

	private static void initRefactoryUtil() {
		// roleMappings must not be cached, otherwise they might contain errors
		RoleMappingModelProvider.OWL_RENAME.toModel();
		// all known RoleModels, RefSpecs, and RoleMappingModels are
		// registered in constructor of RefactoryUtil.
		refactoryUtil = RefactoryUtil.getInstance();
	}

	@Test
	public void testRegisterModels() {
		RoleModel roleModel = RoleModelProvider.RENAME_X.toModel();
		assertTrue(refactoryUtil.isRoleModelAlreadyRegistered(roleModel));

		RefactoringSpecification refSpec = RefSpecProvider.RENAME_X.toModel();
		assertTrue(refactoryUtil.isRefSpecAlreadyRegistered(refSpec));
		
		RoleMappingModel roleMappingModel = RoleMappingModelProvider.OWL_RENAME.toModel();
		assertTrue(refactoryUtil.isRoleMappingModelAlreadyRegistered(roleMappingModel));
	}
	
	@Test
	public void testGetRoleMappingsFromRefactorer() {
		EPackage model = (EPackage) ModelStorageUtil.loadModelFromFileName(base + "testdata/IN_rename.ecore");
		String expectedRoleMappingName = "Rename EElement";

		EClass inputElement = QueryUtil.queryFirstEClass(model);
		List<EObject> inputElements = QueryUtil.getEObjectListOfSingleElement(inputElement);
		List<RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getPossibleRoleMappingsForResource(model.eResource(), inputElements, 1.0);

		List<String> actualRoleMappingNames = getRoleMappingNames(roleMappings);
		assertTrue(actualRoleMappingNames.contains(expectedRoleMappingName));
	}

	private List<String> getRoleMappingNames(List<RoleMapping> roleMappings) {
		List<String> roleMappingNames = new ArrayList<String>();
		for (RoleMapping roleMapping : roleMappings) {
			roleMappingNames.add(roleMapping.getName());
		}
		return roleMappingNames;
	}

	
}
