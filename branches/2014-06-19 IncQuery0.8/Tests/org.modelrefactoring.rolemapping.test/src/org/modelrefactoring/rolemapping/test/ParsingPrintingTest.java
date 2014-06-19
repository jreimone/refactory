package org.modelrefactoring.rolemapping.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParsingPrintingTest {

	@BeforeClass
	public static void initLanguages(){
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put(new RolemappingMetaInformation().getSyntaxName(), new RolemappingResourceFactory());
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		extensionToFactoryMap.put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		// register role model
		File rmFile = new File("rolemodel/RenameX.rolestext");
		assertTrue("RoleModel '" + rmFile.getPath() + "' doesn't exist", rmFile.exists());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(rmFile.getAbsolutePath()), true);
		assertNotNull("No role model resource could be created", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("No role model is contained in the resource", model instanceof RoleModel);
		RoleModel roleModel = (RoleModel) model;
		try {
			IRoleModelRegistry.INSTANCE.registerRoleModel(roleModel);
		} catch (RoleModelAlreadyRegisteredException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParsingAndPrinting(){
		createAndRegisterMetamodel();
		File rmFile = new File("rolemappings/ParsingTest.rolemapping");
		assertTrue("File " + rmFile.getPath() + " doesn't exist", rmFile.exists());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(rmFile.getAbsolutePath()), true);
		assertNotNull("No role mapping resource could be created", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("No role mapping is contained in the resource", model instanceof RoleMappingModel);
		// Parsing
		RoleMappingModel roleMappingModel = (RoleMappingModel) model;
		// Printing
		File printingFile = new File("rolemappings/PrintingTest.rolemapping");
		if(printingFile.exists()){
			printingFile.delete();
		}
		resource = rs.createResource(URI.createFileURI(printingFile.getAbsolutePath()));
		resource.getContents().add(roleMappingModel);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createAndRegisterMetamodel() {
		File mmFile = new File("metamodel/SubPackagesMM.ecore");
		assertTrue("File " + mmFile.getPath() + " doesn't exist", mmFile.exists());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(mmFile.getAbsolutePath()), true);
		assertNotNull("No EPackage resource could be created", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("No metamodel is contained in the resource", model instanceof EPackage);
		EPackage metamodel = (EPackage) model;
		EPackage.Registry.INSTANCE.put(metamodel.getNsURI(), metamodel);
	}
}
