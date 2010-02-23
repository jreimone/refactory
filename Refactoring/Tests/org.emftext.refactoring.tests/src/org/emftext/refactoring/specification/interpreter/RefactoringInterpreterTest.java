/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.Program;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.test.AbstractRefactoringTest;

/**
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterTest extends AbstractRefactoringTest {

	private String path = "resources/p1.pl0";
	private Program pl0Program;
//	private String tempPath = "platform:/resource/EMFTextTest/pl0/test.pl0";

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.test.AbstractRefactoringTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		pl0Program = getExpectedModelFromFile(path, Program.class);
	}
	
	public void testRefactorerFactory(){
		Resource resource = pl0Program.eResource();
//		ResourceSet rs = new ResourceSetImpl();
//		URI uri = URI.createURI(tempPath);
//		resource = rs.getResource(uri, true);
		IRefactorer refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		assertNotNull(refactorer);
		EObject refactoredModel = refactorer.refactor(null, true);
		assertNull(refactoredModel);
	}
}
