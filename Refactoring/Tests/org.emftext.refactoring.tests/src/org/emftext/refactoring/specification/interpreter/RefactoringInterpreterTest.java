/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.Body;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.Statement;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.emftext.refactoring.indexconnector.IndexConnectorFactory;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.refactoring.util.ModelUtil;
import org.emftext.refactoring.util.RoleUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.emftext.test.core.TestDataSet;
import org.junit.Test;

@TestData("pl0")
public class RefactoringInterpreterTest extends TestClass{

	private String path = "wirth";
	
	private IRefactorer getRefactorer(Resource resource){
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		assertNotNull(refactorer);
		return refactorer;
	}
	
	@Test
	@InputData("wirth")
	public void getAppliedRoles(){
		TestDataSet dataSet = getTestDataSet();
		File file = dataSet.getInputFileByPattern(path);
		Resource resource = TestUtil.getResourceFromFile(file);
		// TODO mock for connector
		IndexConnector connector = IndexConnectorFactory.defaultINSTANCE.getIndexConnector();
		assertNotNull(connector);
		Program pl0Prog = TestUtil.getExpectedModelFromResource(resource, Program.class);
		RoleMappingModel mappingModel = connector.getRoleMapping(pl0Prog.eClass().getEPackage().getNsURI());
		assertNotNull(mappingModel);
		Body body = pl0Prog.getBlock().getBody();
		assertNotNull(body);
		EList<Statement> statements = ModelUtil.getObjectsByType(body.eAllContents(), Statement.class);
		assertNotNull(statements);
		assertTrue(statements.size() >= 3);
		List<Statement> selection = statements.subList(0, 2);		
		List<Mapping> mappings = RoleUtil.getPossibleMappingsForInputSelection(selection, mappingModel, 1.0);
		assertNotNull(mappings);
		assertTrue(mappings.size() > 0);
		for (Mapping mapping : mappings) {
			Set<Role> roles = RoleUtil.getAppliedRoles(selection, mapping);
			assertNotNull(roles);
			assertTrue(roles.size() > 0);
		}
	}

	@Test
	public void getPossibleRefactoringSpecifications(){
//		WorkspaceBuilder.setTest(this);
//		WorkspaceBuilder.buildTestWorkspace();
//		Resource resource = TestUtil.getResourceInWorkspace(this, path);
		Resource resource = null;
		IRefactorer refactorer = getRefactorer(resource);
		Program pl0Prog = TestUtil.getExpectedModelFromResource(resource, Program.class);
		Body body = pl0Prog.getBlock().getBody();
		assertNotNull(body);
		EList<Statement> statements = ModelUtil.getObjectsByType(body.eAllContents(), Statement.class);
		assertNotNull(statements);
		assertTrue(statements.size() >= 3);
		List<Statement> selection = statements.subList(0, 2);
		refactorer.setInput(selection);
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
		assertTrue(refSpecs.size() > 0);
	}

	@Test
	public void refactoringInterpreter(){
//		WorkspaceBuilder.setTest(this);
//		WorkspaceBuilder.buildTestWorkspace();
//		Resource resource = TestUtil.getResourceInWorkspace(this, path);
		Resource resource = null;
		IRefactorer refactorer = getRefactorer(resource);
		EObject refactoredModel = refactorer.refactor(null, true);
		assertNull(refactoredModel);
	}
}
