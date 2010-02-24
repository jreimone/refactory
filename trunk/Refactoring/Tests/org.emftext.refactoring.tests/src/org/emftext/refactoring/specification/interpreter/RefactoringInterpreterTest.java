/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.test.AbstractRefactoringTest;
import org.emftext.refactoring.test.WorkspaceBuilder;
import org.emftext.refactoring.test.WorkspaceUtil;
import org.junit.Test;

public class RefactoringInterpreterTest extends AbstractRefactoringTest {

	private String path = "/pl0/wirth.pl0";
//	private Program pl0Program;
//	private IRefactorer refactorer;

//	public RefactoringInterpreterTest(){
//		WorkspaceBuilder.clearWorkspace();
//	}
	
	private IRefactorer getRefactorer(Resource resource){
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		assertNotNull(refactorer);
		return refactorer;
	}

	@Test
	public void getPossibleRefactoringSpecifications(){
		Resource resource = WorkspaceUtil.getResourceInWorkspace(this, path);
		IRefactorer refactorer = getRefactorer(resource);
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
	}

	@Test
	public void refactoringInterpreter(){
		Resource resource = WorkspaceUtil.getResourceInWorkspace(this, path);
		IRefactorer refactorer = getRefactorer(resource);
		EObject refactoredModel = refactorer.refactor(null, true);
		assertNull(refactoredModel);
	}
}
