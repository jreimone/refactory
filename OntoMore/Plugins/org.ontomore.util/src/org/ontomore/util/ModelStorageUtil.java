package org.ontomore.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.emftext.language.refactoring.specification.resource.mopp.RefspecResourceFactory;

/**
 * Cares about loading and storing models from and to files.
 * 
 * @author Erik Tittel
 */
public class ModelStorageUtil {

	public static final String WORKSPACE_DIRECTORY = getWorkspaceDirectory();
	private static ResourceSet resourceSet = null;
	private static Map<String, EObject> modelCache = new HashMap<String, EObject>();

	private static String getWorkspaceDirectory() {
		File file = new File("test.txt");
		file = file.getAbsoluteFile();
		File plugin = file.getParentFile();
		File workspace = plugin.getParentFile();
		String workspacePath = workspace.getAbsolutePath().replaceAll("\\\\", "/");
		return workspacePath + "/";
	}

	/**
	 * The absolute plug-in path plus a closing slash.
	 */
	public static String getBase(String pluginName) {
		return WORKSPACE_DIRECTORY + pluginName + "/";
	}

	public static EObject loadModelFromFileName(String fileName) {
		URI fileURI = URI.createFileURI(fileName);
		EObject result = modelCache.get(fileName);
		if (result == null) {
			result = loadModelFromFileURI(fileURI);
			modelCache.put(fileName, result);
		}
		return result;
	}

	public static EObject loadModelFromFileURI(URI fileURI) {
		EObject result = null;
		initResourceSet();
		try {
			Resource resource = resourceSet.getResource(fileURI, true);
			// NPEs are catched by catch clause
			if (!resource.isLoaded()) {
				resource.load(null);
			}
			result = resource.getContents().get(0);
		} catch (Exception e) {
			throw new RuntimeException("Model could not be loaded from file: " + fileURI);
		}
		if (result == null) {
			throw new RuntimeException("Loaded model is empty, from: " + fileURI);
		}
		return result;
	}

	private static void initResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			Map<String, Object> extensionToFactoryMap = resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap();
			extensionToFactoryMap.put("owl",
					new org.emftext.language.owl.resource.owl.mopp.OwlResourceFactory());
			extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl());
			extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl());
			extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
			extensionToFactoryMap.put("refspec", new RefspecResourceFactory());
			extensionToFactoryMap.put("rolemapping", new RolemappingResourceFactory());
		}
	}

	public static EObject reloadModelFromFileName(String fileName) {
		URI fileURI = URI.createFileURI(fileName);
		return reloadModelFromFileURI(fileURI);
	}

	private static EObject reloadModelFromFileURI(URI fileURI) {
		EObject result = null;
		initResourceSet();
		try {
			Resource resource = resourceSet.getResource(fileURI, true);
			// NPEs are catched by catch clause
			resource.unload();
			resource.load(null);
			result = resource.getContents().get(0);
		} catch (Exception e) {
			throw new RuntimeException("Model could not be loaded from file: " + fileURI);
		}
		if (result == null) {
			throw new RuntimeException("Loaded model is empty, from: " + fileURI);
		}
		return result;
	}

	public static void saveModelInResource(EObject model, String fileName) {
		URI fileURI = URI.createFileURI(fileName);
		saveModelInResource(model, fileURI);
	}

	public static void saveModelInResource(EObject model, URI fileURI) {
		Resource documentResource = resourceSet.createResource(fileURI);
		if (documentResource == null) {
			throw new RuntimeException("Resource for file " + fileURI + " could not be created");
		}
		documentResource.getContents().add(model);
		try {
			documentResource.save(null);
		} catch (IOException e) {
			throw new RuntimeException("Model could not be saved: " + fileURI);
		}
	}

	public static String getMetaModelAsString(EObject model) {
		EClass metaClass = model.eClass();
		EPackage ePackage = metaClass.getEPackage();
		return ePackage.getNsURI();
	}

}
