/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import java.io.File;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.Before;

/**
 * Run as Plugin-Test
 * 
 * @author Jan Reimann
 *
 */
public class EmptyOutgoingRelationTest extends TestCase {

	private String path = "resources/ExtractMethod.rolestext";
	private Resource resource;
	
	@Before
	public void setUp() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rolestext", new RolestextResourceFactory());
		resourceSet.getPackageRegistry().put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		File file = new File(path);
		assertTrue("File must exist", file.exists());
		resource = resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		assertNotNull("Resource mustn't be null", resource);
	}
	
	public void testEmptyOutgoingRelations(){
		EObject root = resource.getContents().get(0);
		assertTrue("root object must be of type RoleModel", root instanceof RoleModel);
		RoleModel model = (RoleModel) root;
		EList<Relation> relations = model.getRelations();
		Role origContainerRole = null;
		EList<Relation> outgoingRelations1 = new BasicEList<Relation>();
		for (Relation relation : relations) {
			Role source = relation.getSource();
			if("OrigContainer".equals(source.getName())){
				origContainerRole = source;
				outgoingRelations1.add(relation);
			}
		}
		assertNotNull("Role OrigContainer mustn't be null", origContainerRole);
		assertTrue("outgoing relations of OrigContainer must contain relations", outgoingRelations1.size() > 0);
		EList<Relation> outgoingRelations2 = origContainerRole.getOutgoing();
		assertTrue("outgoing relations of OrigContainer must contain relations", outgoingRelations2.size() > 0);
		assertTrue("the previous found relations must be all contained in the outgoing relations of OrigContainer", outgoingRelations2.containsAll(outgoingRelations1));
	}
}
