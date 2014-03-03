package org.corefactoring.rolemappingregistry.test;

import static org.junit.Assert.assertEquals;

import org.corefactoring.rolemappingregistry.RoleMappingInitializer;
import org.corefactoring.rolemappingregistry.RoleMappingRegistry;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ontomore.util.Direction;
import org.ontomore.util.Ecore2OWLDirection;
import org.ontomore.util.OWL2EcoreDirection;
import org.ontomore.util.modelProvider.EcoreRoleMappingProvider;
import org.ontomore.util.modelProvider.OWLRoleMappingProvider;

public class RoleMappingRegistryTest {

	private RoleMappingRegistry registry;

	@Before
	public void setUp() {
		registry = RoleMappingRegistry.INSTANCE;
		RoleMappingInitializer.registerRoleMappingMapper();
	}

	@After
	public void tearDown() {
		registry = null;
	}

	@Test
	public void testGetOwlRenameElementRoleMapping() {
		Direction direction = new Ecore2OWLDirection();
		RoleMapping ecoreRenameRoleMapping = EcoreRoleMappingProvider.RENAME.toRoleMapping();
		EClass classInputElement = EcoreFactory.eINSTANCE.createEClass();
		RoleMapping roleMappingFromRegistry = registry.getCorrespondingRoleMappingByDirection(
				ecoreRenameRoleMapping, classInputElement, direction);
		assertEquals(OWLRoleMappingProvider.RENAME_ELEMENT.toString(),
				roleMappingFromRegistry.getName());
	}

	@Test
	public void testGetOwlRenameOntologyRoleMapping() {
		Direction direction = new Ecore2OWLDirection();
		RoleMapping ecoreRenameRoleMapping = EcoreRoleMappingProvider.RENAME.toRoleMapping();
		EPackage packageInputElement = EcoreFactory.eINSTANCE.createEPackage();
		RoleMapping roleMappingFromRegistry = registry.getCorrespondingRoleMappingByDirection(
				ecoreRenameRoleMapping, packageInputElement, direction);
		assertEquals(OWLRoleMappingProvider.RENAME_ONTOLOGY.toString(),
				roleMappingFromRegistry.getName());
	}

	@Test
	public void testGetEcoreRenameRoleMapping() {
		Direction direction = new OWL2EcoreDirection();
		RoleMapping owlRenameRoleMapping = OWLRoleMappingProvider.RENAME_ELEMENT.toRoleMapping();
		EObject inputElement = null;
		RoleMapping roleMappingFromRegistry = registry.getCorrespondingRoleMappingByDirection(
				owlRenameRoleMapping, inputElement, direction);

		assertEquals(EcoreRoleMappingProvider.RENAME.toString(), roleMappingFromRegistry.getName());
	}

	@Test
	public void testGetOwlDuplicateClassRoleMapping() {
		Direction direction = new Ecore2OWLDirection();
		RoleMapping ecoreDuplicateClassRoleMapping = EcoreRoleMappingProvider.DUPLICATE_CLASS.toRoleMapping();
		EObject inputElement = EcoreFactory.eINSTANCE.createEClass();
		RoleMapping roleMappingFromRegistry = registry.getCorrespondingRoleMappingByDirection(
				ecoreDuplicateClassRoleMapping, inputElement, direction);

		assertEquals(OWLRoleMappingProvider.DUPLICATE_CLASS.toString(),
				roleMappingFromRegistry.getName());
	}

	@Test
	public void testGetEcoreDuplicateClassRoleMapping() {
		Direction direction = new OWL2EcoreDirection();
		RoleMapping owlDuplicateClassRoleMapping = OWLRoleMappingProvider.DUPLICATE_CLASS.toRoleMapping();

		EObject inputElement = EcoreFactory.eINSTANCE.createEClass();
		RoleMapping roleMappingFromRegistry = registry.getCorrespondingRoleMappingByDirection(
				owlDuplicateClassRoleMapping, inputElement, direction);

		assertEquals(EcoreRoleMappingProvider.DUPLICATE_CLASS.toString(),
				roleMappingFromRegistry.getName());
	}

}
