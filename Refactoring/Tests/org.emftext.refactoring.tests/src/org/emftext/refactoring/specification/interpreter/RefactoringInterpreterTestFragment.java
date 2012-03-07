/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.test.QueryUtil;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.junit.Test;

@TestData("RefactoringInterpreterTest")
public class RefactoringInterpreterTestFragment extends TestClass{

	private static final String MODEL = "MODEL_";
	private static final String PATH = "PATH_";
	
	@Test
	@InputData({MODEL,PATH})
	public void getAppliedRoles(){
		Resource resource = getTestDataSet().getResourceByPattern(MODEL, false);
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		assertNotNull("No rolemapping registry found", registry);
		EObject model = TestUtil.getModelFromResource(resource);
		Map<String, RoleMapping> roleMappings = registry.getRoleMappingsForUri(model.eClass().getEPackage().getNsURI());
		assertNotNull("No role mappings found for metamodel " + model.eClass().getEPackage().getNsURI(), roleMappings);
		
		File path = getTestDataSet().getInputFileByPattern(PATH);
		assertNotNull("Could not find a file containing a query path for resource " + resource.getURI().toFileString(), path);
		String query = QueryUtil.getLineInFile(path, 1);
		List<EObject> elements = QueryUtil.queryResource(resource, query);
		assertNotNull("Query '" + query + "' had no result for resource " + resource.getURI().toFileString(), elements);
		assertTrue("Query '" + query + "' had no result for resource " + resource.getURI().toFileString(), elements.size() > 0);
		
		List<RoleMapping> mappings = RoleUtil.getPossibleMappingsForInputSelection(elements, roleMappings, 1.0);
		assertNotNull("No possible mappings could be found for the queried elements", mappings);
		assertTrue("No possible mappings could be found for the queried elements", mappings.size() > 0);
		for (RoleMapping mapping : mappings) {
			Set<Role> roles = RoleUtil.getAppliedRoles(elements, mapping);
			assertNotNull("Elements have no roles applied", roles);
			assertTrue("Elements have no roles applied", roles.size() > 0);
		}
	}

	@Test
	@InputData({MODEL,PATH})
	public void getPossibleRefactoringSpecifications(){
		Resource resource = getTestDataSet().getResourceByPattern(MODEL, false);
		List<EObject> elements = getElementsByQuery(PATH, 1, resource);
		List<RefactoringSpecification> refSpecs = IRoleMappingRegistry.INSTANCE.getPossibleRefactorings(elements, 1.0);
		assertNotNull("No refspecs found", refSpecs);
		assertTrue("No refspecs found", refSpecs.size() > 0);
	}


	private List<EObject> getElementsByQuery(String pattern, int queryLineNumber, Resource resource){
		File path = getTestDataSet().getInputFileByPattern(pattern);
		String query = QueryUtil.getLineInFile(path, queryLineNumber);
		List<EObject> elements = QueryUtil.queryResource(resource, query);
		return elements;
	}
}
