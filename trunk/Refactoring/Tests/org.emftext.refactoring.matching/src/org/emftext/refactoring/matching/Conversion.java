package org.emftext.refactoring.matching;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.Test;
import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.resource.guery.mopp.GueryResourceFactory;

public class Conversion {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		
		// Register the appropriate resource factory to handle all file extensions.
		//
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
//		("rolestext", new RolestextResourceFactory());
//		
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
//		("guery", new GueryResourceFactory());
		
		// Register the package to ensure it is available during loading.
		//
		Registry registry = EPackage.Registry.INSTANCE;
		registry.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		extensionToFactoryMap.put("guery", new GueryResourceFactory());
		
//		resourceSet.getPackageRegistry().put
//		(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
//		resourceSet.getPackageRegistry().put
//		(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		
		File sourceFile  =new File("C:\\Users\\Robert\\gbswt\\org.emftext.refactoring.extractX\\rolemodel\\ExtractX.rolestext");
		URI uri = URI.createURI(sourceFile.getAbsolutePath());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		RoleModel rolemodel = (RoleModel) model;
		System.out.println(rolemodel.getName());
	}
	
	@Test
	public void testLoadng(){
//		Registry registry = EPackage.Registry.INSTANCE;
//		registry.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
//		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
//		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
//		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		extensionToFactoryMap.put("guery", new GueryResourceFactory());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolestext", new RolestextResourceFactory());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("guery", new GueryResourceFactory());
		
		File sourceFile  =new File("C:\\Users\\Robert\\gbswt\\org.emftext.refactoring.extractX\\rolemodel\\ExtractX.rolestext");
		URI uri = URI.createURI(sourceFile.getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		RoleModel rolemodel = (RoleModel) model;
		System.out.println(rolemodel.getName());
	}
}
