package org.emftext.refactoring.rolemodelmatching;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;

public class RolemodelMatchingInitialization {

	private static final String TEXT_ECORE_EXT 	= ".text.ecore";
	
	protected static void registerMetamodel(String nsUri, EPackage metamodel, String ext, Factory factory) {
		registerPackage(metamodel);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put(ext, factory);
	}

	protected static void registerTestingRootAsPlatformRoot() {
		Map<String, URI> resourceMap = EcorePlugin.getPlatformResourceMap();
		File root = new File(".");
		assertTrue(root.exists());
	
		root = root.getAbsoluteFile();
		assertTrue(root.exists());
		root = root.getParentFile().getParentFile();
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

	protected static Resource getResourceFromURI(String nsURI) {
		assertNotNull(nsURI);
		URI uri = URI.createURI(nsURI, true);
		ResourceSet rs = new ResourceSetImpl();
//		rs.getLoadOptions().putAll(null);
		Resource resource = rs.getResource(uri, true);
		assertNotNull(resource);
		return resource;
	}

	protected static Map<String, EPackage> initMetamodels(String[] metamodelURIs) {
		Map<String, EPackage> metamodels = new LinkedHashMap<String, EPackage>();
		for (String metamodelURI : metamodelURIs) {
			if(metamodelURI.endsWith(TEXT_ECORE_EXT)){
				registerTextEcoreLanguage();
			} else {
				registerEcoreLanguage();
			}
			Resource resource = getResourceFromURI(metamodelURI);
			EObject model = resource.getContents().get(0);
			assertTrue(model + " is not a Ecore metamodel", model instanceof EPackage);
			registerPackage((EPackage) model);
			metamodels.put(metamodelURI, (EPackage) model);
		}
		return metamodels;
	}
	
	private static void registerPackage(EPackage rootPackage) {
		String nsUri = rootPackage.getNsURI();
		EPackage.Registry.INSTANCE.put(nsUri, rootPackage);
		List<EPackage> subpackages = rootPackage.getESubpackages();
		for (EPackage subPackage : subpackages) {
			registerPackage(subPackage);
		}
	}

	protected static void initAndRegisterArchiveMetamodel(String pathString, String nsURI, Class<?> clazz, Map<String, EPackage> metamodels){
		URL classResource = clazz.getResource(pathString);
		assertNotNull("Path '" + pathString + "' could not be found in class '" + clazz.getName() + "'", classResource);
		String path = classResource.getFile();
		path = path.replace("file:/", "archive:file:/");
		URI metamodelUri = URI.createURI(path);
		assertNotNull("URI of path '" + path + "' mustn't be null", metamodelUri);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(metamodelUri, true);
		assertNotNull("Resource for URI '" + metamodelUri +"' mustn't be null", resource);
		assertTrue("First element in resource '" + resource + "' must be an EPackage", resource.getContents().get(0) instanceof EPackage);
		EPackage metamodel = (EPackage) resource.getContents().get(0);
		metamodels.put(nsURI, metamodel);
	}

	private static void registerTextEcoreLanguage() {
		registerMetamodel(
				EcorePackage.eNS_URI
				, EcorePackage.eINSTANCE
				, "ecore"
				, new TextEcoreResourceFactory());
	}

	private static void registerEcoreLanguage() {
		registerMetamodel(
				EcorePackage.eNS_URI
				, EcorePackage.eINSTANCE
				, "ecore"
				, new EcoreResourceFactoryImpl());
	}

	protected static Map<String, RoleModel> initRoleModels(String[] rolemodelURIs) {
		// init roles metamodel
		registerMetamodel(
				RolesPackage.eNS_URI, 
				RolesPackage.eINSTANCE, 
				new RolestextMetaInformation().getSyntaxName(), 
				new RolestextResourceFactory());
		// load rolemodels
		Map<String, RoleModel> rolemodels = new LinkedHashMap<String, RoleModel>();
		for (String rolemodelURI : rolemodelURIs) {
			Resource resource = getResourceFromURI(rolemodelURI);
			EObject model = resource.getContents().get(0);
			assertTrue(model + " is not a rolemodel", model instanceof RoleModel);
			rolemodels.put(rolemodelURI, (RoleModel) model);
		}
		return rolemodels;
	}

	public RolemodelMatchingInitialization() {
		super();
	}

}