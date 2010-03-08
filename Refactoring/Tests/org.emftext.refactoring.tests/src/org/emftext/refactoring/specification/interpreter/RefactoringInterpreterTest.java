/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.test.QueryUtil;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestDataSet;
import org.junit.Test;

public class RefactoringInterpreterTest extends TestClass{

	private static final String MODEL = "MODEL_";
	private static final String PATH = "PATH_";
	private static final String CREATE = "CREATE_";
	private static final String CREATE_PATH = "CREATE_PATH_";
	
	private IRefactorer getRefactorer(Resource resource){
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		assertNotNull(refactorer);
		return refactorer;
	}
	
	private Resource getResourceByPattern(String pattern) {
		TestDataSet dataSet = getTestDataSet();
		File file = dataSet.getInputFileByPattern(pattern);
		Resource resource = TestUtil.getResourceFromFile(file);
		return resource;
	}
	
	@Test
	@InputData({MODEL,PATH})
	public void getAppliedRoles(){
		Resource resource = getResourceByPattern(MODEL);
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		assertNotNull(registry);
		EObject model = TestUtil.getModelFromResource(resource);
		RoleMappingModel mappingModel = registry.getRoleMappingForUri(model.eClass().getEPackage().getNsURI());
		assertNotNull(mappingModel);
		
		File path = getTestDataSet().getInputFileByPattern(PATH);
		assertNotNull(path);
		String query = QueryUtil.getLineInFile(path, 1);
		List<EObject> elements = QueryUtil.queryResource(resource, query);
		assertNotNull(elements);
		assertTrue(elements.size() > 0);
		
		List<Mapping> mappings = RoleUtil.getPossibleMappingsForInputSelection(elements, mappingModel, 1.0);
		assertNotNull(mappings);
		assertTrue(mappings.size() > 0);
		for (Mapping mapping : mappings) {
			Set<Role> roles = RoleUtil.getAppliedRoles(elements, mapping);
			assertNotNull(roles);
			assertTrue(roles.size() > 0);
		}
	}

	@Test
	@InputData({MODEL,PATH})
	public void getPossibleRefactoringSpecifications(){
		Resource resource = getResourceByPattern(MODEL);
		IRefactorer refactorer = getRefactorer(resource);
		
		List<EObject> elements = getElementsByQuery(PATH, 1, resource);
		refactorer.setInput(elements);
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
		assertTrue(refSpecs.size() > 0);
	}

	@Test
	@InputData({CREATE, CREATE_PATH})
	public void refactorCREATE(){
		Resource resource = getResourceByPattern(CREATE);
		IRefactorer refactorer = getRefactorer(resource);
		
		List<EObject> elements = getElementsByQuery(CREATE_PATH, 1, resource);
		refactorer.setInput(elements);
		List<Mapping> mappings = refactorer.getPossibleMappings(1.0);
		assertNotNull(mappings);
		assertTrue(mappings.size() > 0);
		Mapping mapping = mappings.get(0);
		EObject refactoredRoot = refactorer.refactor(mapping, false);
		assertNotNull(refactoredRoot);
		
		ResourceSet rs = resource.getResourceSet();
		File origFile = getTestDataSet().getInputFileByPattern(CREATE);
		String newName = origFile.getName();
//		newName = newName.replace(CREATE, "CREATE_REFACTORED_").replace(".pl0", ".xmi");
		newName = newName.replace(CREATE, "CREATE_REFACTORED_");
		File refactoredFile = new File(origFile.getAbsoluteFile().getParent() + File.separator + newName);
		Resource refactoredResource = rs.createResource(URI.createFileURI(refactoredFile.getAbsolutePath()));
		boolean added = refactoredResource.getContents().add(refactoredRoot);
		assertTrue(added);
		try {
			refactoredResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<EObject> getElementsByQuery(String pattern, int queryLineNumber, Resource resource){
		File path = getTestDataSet().getInputFileByPattern(pattern);
		String query = QueryUtil.getLineInFile(path, queryLineNumber);
		List<EObject> elements = QueryUtil.queryResource(resource, query);
		return elements;
	}
	
//	@Test
	@InputData({MODEL,PATH})
	public void refactoringInterpreter(){
		Resource resource = getResourceByPattern(MODEL);
		IRefactorer refactorer = getRefactorer(resource);
		
		List<EObject> elements = getElementsByQuery(PATH, 1, resource);
		refactorer.setInput(elements);
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
		assertTrue(refSpecs.size() > 0);
		RefactoringSpecification refSpec = refSpecs.get(0);
//		EObject refactoredModel = refactorer.refactor(refSpec, true);
//		assertNotNull(refactoredModel);
	}
}
