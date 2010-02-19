/**
 * 
 */
package org.emftext.refactoring.roleconstraintchecker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.refactoring.util.ModelUtil;
import org.junit.Before;

/**
 * Run as JUnit-Plugin-Test !!!
 *
 */
public class RoleConstraintCheckerTestXMI extends TestCase {

	private String path = "test/testMapping.xmi";
	private String path1 = "test/TestProhibition.xmi";
	private RoleMappingModel mappingModel;
	private List<RoleModel> roleModels;
	
	private ResourceSet resourceSet;
	
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
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(RolemappingPackage.eNS_URI, RolemappingPackage.eINSTANCE);
		mappingModel = getExpectedModelFromFile(path, RoleMappingModel.class);
		roleModels = new ArrayList<RoleModel>();
		roleModels.add(getExpectedModelFromFile(path1, RoleModel.class));
	}
	
	public void testProhibitionConstraints(){
		EcoreUtil.resolveAll(mappingModel);
		EPackage metamodel = mappingModel.getTargetMetamodel();
		assertNotNull("Metamodel mustn't be null", metamodel);
		EList<Mapping> mappings = mappingModel.getMappings();
		assertTrue("There must be mappings", mappings.size() > 0);
		EList<EObject> prohibitionMappings = ModelUtil.filterObjectsByAttribute(mappings.iterator(), "name", "TestProhibitionMapping");
		assertEquals("There must be a prohibition mapping", 1, prohibitionMappings.size());
		Mapping prohibitionMapping = (Mapping) prohibitionMappings.get(0);
		EList<ConcreteMapping> concreteMappings = prohibitionMapping.getRoleToMetaelement();
		assertTrue("There must be concrete mappings", concreteMappings.size() > 0);
		IRoleConstraintValidator validator = RoleConstraintValidatorFactory.eInstance.createValidator();
		assertNotNull("Validator mustn't be null", validator);
		List<IStatus> stati = validator.validateMapping((Mapping) prohibitionMappings.get(0));
		assertEquals("There must be 2 error status", 2, stati.size());
		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(0).getSeverity());
		assertEquals("The status code must be an ERROR", IStatus.ERROR, stati.get(1).getSeverity());
	}
}
