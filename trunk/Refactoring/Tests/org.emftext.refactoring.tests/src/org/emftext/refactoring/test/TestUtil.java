/**
 * 
 */
package org.emftext.refactoring.test;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Jan Reimann
 *
 */
public class TestUtil {

	public static Resource getResourceFromFile(File file) {
		assertNotNull(file);
		assertTrue(file.exists());
		String filePath = file.getAbsolutePath();
		URI uri = URI.createFileURI(filePath);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull(resource);
		return resource;
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getExpectedModelFromFile(File file, Class<T> expectedType){
		Resource resource = getResourceFromFile(file);
		assertNotNull("Resource mustn't be null", resource);
		EObject root = resource.getContents().get(0);
		assertTrue("root object must be of type '" + expectedType.getSimpleName() + "'", expectedType.isInstance(root));
		return (T) root;
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getExpectedModelFromResource(Resource resource, Class<T> expectedType){
		assertNotNull("Resource mustn't be null", resource);
		EList<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertTrue(contents.size() > 0);
		EObject root = contents.get(0);
		assertNotNull(root);
		assertTrue("root object must be of type '" + expectedType.getSimpleName() + "'", expectedType.isInstance(root));
		return (T) root;
	}
	
	public static EObject getModelFromResource(Resource resource){
		EObject model = getExpectedModelFromResource(resource, EObject.class);
		assertNotNull(model);
		return model;
	}
	
	public static File getFileByPath(String path){
		File file = new File(path);
		assertNotNull(file);
		assertTrue(file.exists());
		return file;
	}
}
