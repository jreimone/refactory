/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
	
	private IRefactorer getRefactorer(Resource resource){
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		assertNotNull(refactorer);
		return refactorer;
	}
	
	@Test
	@InputData({MODEL,PATH})
	public void getAppliedRoles(){
		TestDataSet dataSet = getTestDataSet();
		File file = dataSet.getInputFileByPattern(MODEL);
		Resource resource = TestUtil.getResourceFromFile(file);
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		assertNotNull(registry);
		EObject model = TestUtil.getModelFromResource(resource);
		RoleMappingModel mappingModel = registry.getRoleMappingForUri(model.eClass().getEPackage().getNsURI());
		assertNotNull(mappingModel);
		
		File path = dataSet.getInputFileByPattern(PATH);
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
		TestDataSet dataSet = getTestDataSet();
		File file = dataSet.getInputFileByPattern(MODEL);
		Resource resource = TestUtil.getResourceFromFile(file);
		IRefactorer refactorer = getRefactorer(resource);
		
		File path = dataSet.getInputFileByPattern(PATH);
		String query = QueryUtil.getLineInFile(path, 1);
		List<EObject> elements = QueryUtil.queryResource(resource, query);
		refactorer.setInput(elements);
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
		assertTrue(refSpecs.size() > 0);
	}

	@Test
	@InputData({MODEL,PATH})
	public void refactoringInterpreter(){
		TestDataSet dataSet = getTestDataSet();
		File file = dataSet.getInputFileByPattern(MODEL);
		Resource resource = TestUtil.getResourceFromFile(file);
		IRefactorer refactorer = getRefactorer(resource);
		
		File path = dataSet.getInputFileByPattern(PATH);
		String query = QueryUtil.getLineInFile(path, 1);
		List<EObject> elements = QueryUtil.queryResource(resource, query);
		refactorer.setInput(elements);
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
		assertTrue(refSpecs.size() > 0);
		RefactoringSpecification refSpec = refSpecs.get(0);
//		EObject refactoredModel = refactorer.refactor(refSpec, true);
//		assertNotNull(refactoredModel);
	}
}
