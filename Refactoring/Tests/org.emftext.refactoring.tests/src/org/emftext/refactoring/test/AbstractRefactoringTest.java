/**
 * 
 */
package org.emftext.refactoring.test;

import java.io.File;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResourceFactory;
import org.emftext.language.refactoring.roles.RolesFactory;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;

/**
 * An abstract TestCase class for setting up the needed metamodels in the registry.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractRefactoringTest extends TestCase {

	private ResourceSet resourceSet;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolestext", new RolestextResourceFactory());
		resourceSet.getPackageRegistry().put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolemapping", new RolemappingResourceFactory());
		resourceSet.getPackageRegistry().put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pl0", new Pl0ResourceFactory());
		resourceSet.getPackageRegistry().put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
	}
	
	
	@SuppressWarnings("unchecked")
	public <T extends EObject> T getExpectedModelFromFile(String filePath, Class<T> expectedType){
		File file = new File(filePath);
		assertTrue("File must exist", file.exists());
		Resource resource = resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		assertNotNull("Resource mustn't be null", resource);
		EObject root = resource.getContents().get(0);
		assertTrue("root object must be of type '" + expectedType.getSimpleName() + "'", expectedType.isInstance(root));
		return (T) root;
	}

//	/**
//	 * @return the resourceSet
//	 */
//	public ResourceSet getResourceSet() {
//		return resourceSet;
//	}
	
}
