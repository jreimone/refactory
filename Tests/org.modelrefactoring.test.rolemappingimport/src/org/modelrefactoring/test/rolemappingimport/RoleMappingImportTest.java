package org.modelrefactoring.test.rolemappingimport;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingMetaInformation;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class RoleMappingImportTest {

	private static final String PATH_BASE			= "testdata/";
	private static final String PATH_METAMODEL		= PATH_BASE + "HierarchicalMetamodel.ecore";
	private static final String PATH_ROLES			= PATH_BASE + "test.rolestext";
	private static final String PATH_ROLEMAPPING	= PATH_BASE + "test.rolemapping";
	
	private static Resource resource;
	private static RoleMappingModel rolemappingModel;
	
	@Ignore("Test for Mapping 4 must result in parsing errors")
	@Test
	public void testParsingErrors(){
		List<Diagnostic> errors = resource.getErrors();
		if(errors != null){
			for (Diagnostic diagnostic : errors) {
				System.out.println(diagnostic.getLine() + ":" + diagnostic.getColumn() + ": " + diagnostic.getMessage());
			}
		}
		assertThat("errors occured while parsing", errors.size(), is(0));
	}
	
	@Test
	public void testMappingWithoutPackagesFromImport(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(0);
		assertThat("no packages must be specified", concreteMapping.getPackagesOfMetaclass().isEmpty(), is(true));
		EClass metaclass = concreteMapping.getMetaclass();
		EPackage metaclassPackage = metaclass.getEPackage();
		EPackage importPackage = rolemappingModel.getImports().get(0);
		assertThat("metaclass must be contained in the imported metamodel", metaclassPackage, equalTo(importPackage));
	}
	
	@Test
	public void testMappingWithSinglePackageFromImport(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(1);
		List<EPackage> packages = concreteMapping.getPackagesOfMetaclass();
		assertThat("packages must not be empty", packages.isEmpty(), is(false));
		assertThat("one package must be specified", packages.size(), is(1));
		EPackage ePackage = packages.get(0);
		EPackage importPackage = rolemappingModel.getImports().get(0);
		assertThat("package must be the same as import metamodel", ePackage, equalTo(importPackage));
		EClass metaclass = concreteMapping.getMetaclass();
		EPackage metaclassPackage = metaclass.getEPackage();
		assertThat("metaclass must be contained in the imported metamodel", metaclassPackage, equalTo(importPackage));
	}
	
	@Test
	public void testMappingWithSubPackageFromImport(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(2);
		List<EPackage> packages = concreteMapping.getPackagesOfMetaclass();
		assertThat("packages must not be empty", packages.isEmpty(), is(false));
		assertThat("one package must be specified", packages.size(), is(2));
		EPackage ePackage = packages.get(1);
		EPackage importPackage = rolemappingModel.getImports().get(0);
		assertThat("package must be a first subpackage of import metamodel", importPackage.getESubpackages().contains(ePackage), is(true));
		EClass metaclass = concreteMapping.getMetaclass();
		EPackage metaclassPackage = metaclass.getEPackage();
		assertThat("metaclass must be contained in the first subpackage of the imported metamodel", metaclassPackage, equalTo(ePackage));
	}
	
	@Test
	public void testFailingMappingWithSubPackageFromImportAsFirstPackage(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(3);
		List<EPackage> packages = concreteMapping.getPackagesOfMetaclass();
		assertThat("packages must not be empty", packages.isEmpty(), is(false));
		assertThat("one package must be specified", packages.size(), is(1));
		EPackage ePackage = packages.get(0);
		assertThat("package must not be resolved because it's a subpackage of the imported package and cannot be referenced as first package", ePackage.eIsProxy(), is(true));
	}
	
	@Test
	public void testMappingWithSubSubPackageFromImport(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(4);
		List<EPackage> packages = concreteMapping.getPackagesOfMetaclass();
		assertThat("packages must not be empty", packages.isEmpty(), is(false));
		assertThat("one package must be specified", packages.size(), is(3));
		EPackage subsubPackage = packages.get(2);
		EPackage subPackage = packages.get(1);
		EPackage importPackage = rolemappingModel.getImports().get(0);
		assertThat("intermediate package must be a subpackage of import metamodel", importPackage.getESubpackages().contains(subPackage), is(true));
		assertThat("package must be a second subpackage of import metamodel", subPackage.getESubpackages().contains(subsubPackage), is(true));
		EClass metaclass = concreteMapping.getMetaclass();
		EPackage metaclassPackage = metaclass.getEPackage();
		assertThat("metaclass must be contained in the second subpackage of the imported metamodel", metaclassPackage, equalTo(subsubPackage));
	}
	
	@Test
	public void testMappingWithPackageFromTargetMetamodel(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(5);
		List<EPackage> packages = concreteMapping.getPackagesOfMetaclass();
		assertThat("packages must not be empty", packages.isEmpty(), is(false));
		assertThat("one package must be specified", packages.size(), is(1));
		EPackage ePackage = packages.get(0);
		assertThat("package must be the same as target metamodel", ePackage, equalTo(rolemappingModel.getTargetMetamodel()));
		EClass metaclass = concreteMapping.getMetaclass();
		EPackage metaclassPackage = metaclass.getEPackage();
		assertThat("metaclass must be contained in the target metamodel", metaclassPackage, equalTo(ePackage));
	}
	
	@Test
	public void testMappingWithoutPackagesFromTargetMetamodel(){
		ConcreteMapping concreteMapping = getConcreteMappingByIndex(6);
		assertThat("no packages must be specified", concreteMapping.getPackagesOfMetaclass().isEmpty(), is(true));
		EClass metaclass = concreteMapping.getMetaclass();
		EPackage metaclassPackage = metaclass.getEPackage();
		EPackage targetMetamodel = rolemappingModel.getTargetMetamodel();
		assertThat("metaclass must be contained in the target metamodel", metaclassPackage, equalTo(targetMetamodel));
	}

	protected ConcreteMapping getConcreteMappingByIndex(int index) {
		List<RoleMapping> mappings = rolemappingModel.getMappings();
		RoleMapping roleMapping = mappings.get(index);
		System.out.println("tested rolemapping: " + roleMapping.getName());
		ConcreteMapping concreteMapping = roleMapping.getRoleToMetaelement().get(0);
		return concreteMapping;
	}
	
	@BeforeClass
	public static void registerLanguages(){
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		EPackage.Registry.INSTANCE.put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolemappingMetaInformation().getSyntaxName(), new RolemappingResourceFactory());
		registerTestingRootAsPlatformRoot();
		loadResource();
	}
	
	private static void loadResource(){
		File file = new File(PATH_ROLEMAPPING);
		assertThat("file '" + file.getName() + "' doesn't exist", file.exists(), is(true));
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		resource = rs.getResource(uri, true);
		assertThat("resource is null", resource, is(not(nullValue())));
		assertThat("resource is empty", resource.getContents().isEmpty(), is(false));
		EObject model = resource.getContents().get(0);
		assertThat("model must be a " + RoleMappingModel.class.getSimpleName(), model, instanceOf(RoleMappingModel.class));
		rolemappingModel = (RoleMappingModel) model;
		assertThat("rolemapping model must have one import", rolemappingModel.getImports().isEmpty(), is(false));
		assertThat("rolemapping model must have one import", rolemappingModel.getImports().size(), is(1));
	}
	
	private static void registerTestingRootAsPlatformRoot() {
		Map<String, URI> resourceMap = EcorePlugin.getPlatformResourceMap();
		File root = new File(PATH_BASE);
		assertTrue(root.exists());

		root = root.getAbsoluteFile().getParentFile();
		assertTrue(root.exists());
		root = root.getParentFile();
		assertTrue(root.exists());
		File[] subDirs = root.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.exists() && pathname.isDirectory() && !pathname.isHidden() && pathname.canRead() && !pathname.getName().startsWith(
						".");
			}
		});
		for (File subDir : subDirs) {
			String rootPath = subDir.getAbsolutePath() + File.separator + ".";
			URI rootUri = URI.createFileURI(rootPath);
			rootUri = rootUri.trimSegments(1);
			String testProjectRoot = rootUri.lastSegment();
			assertNotNull(testProjectRoot);
			rootUri = URI.createFileURI(rootPath);
			resourceMap.put(testProjectRoot, rootUri);
		}
	}
}
