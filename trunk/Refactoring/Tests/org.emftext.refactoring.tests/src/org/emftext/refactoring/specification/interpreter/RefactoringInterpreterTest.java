/**
 * 
 */
package org.emftext.refactoring.specification.interpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.Program;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.test.AbstractRefactoringTest;
import org.reuseware.sokan.Store;
import org.reuseware.sokan.index.util.StoreUtil;
import org.reuseware.sokan.resource.util.BuildUtil;

/**
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterTest extends AbstractRefactoringTest {

	private static final String TEST_PROJECT_NAME = "EMFTextTest";
	private static final String[] DIRS_TO_BE_COPIED_INTO_TEST_PROJECT = new String[]{
		"refspecs",
		"role_mappings",
		"roles",
		"pl0"
	};
	
	private String path = "/pl0/wirth.pl0";
	private Program pl0Program;
	private IRefactorer refactorer;
	private IProject testProject;

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.test.AbstractRefactoringTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		pl0Program = getExpectedModelFromFile(path, Program.class);
		buildTestWorkspace();
		initializeSokan();
	}

	private void buildTestWorkspace() throws CoreException, FileNotFoundException{
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		assertNotNull(ws);
		IWorkspaceRoot wsr = ws.getRoot();
		assertNotNull(wsr);
		testProject = wsr.getProject(TEST_PROJECT_NAME);
		assertNotNull(testProject);
		if(!testProject.exists()){
			testProject.create(null);
			testProject.open(null);
		}
		assertTrue(testProject.exists());
		assertTrue(testProject.isOpen());
		for (String folderName : DIRS_TO_BE_COPIED_INTO_TEST_PROJECT) {
			IFolder folder = testProject.getFolder(folderName);
			if(!folder.exists()){
				folder.create(IResource.NONE, true, null);
			}
			File dir = new File(folderName);
			copyFilesIntoTestProject(dir, folder);
		}
	}
	
	private static void copyFilesIntoTestProject(File fromFolder, IFolder toIFolder) throws CoreException, FileNotFoundException{
		assertTrue(fromFolder.exists());
		assertTrue(fromFolder.isDirectory());
		File[] files = fromFolder.listFiles();
		for (File file : files) {
			IFile ifile = toIFolder.getFile(file.getName());
			if(!ifile.exists()){
				FileInputStream is = new FileInputStream(file);
				ifile.create(is, true, null);
			}
			assertTrue(ifile.exists());
		}
	}
	
	private void initializeSokan(){
		List<String> patterns = new ArrayList<String>(1);
		patterns.add("*.*");
		Store store = StoreUtil.INSTANCE.buildStore(patterns, testProject);
		BuildUtil.INSTANCE.toggleStore(testProject, store);
//		for (String folderName : DIRS_TO_BE_COPIED_INTO_TEST_PROJECT) {
//			IFolder folder = testProject.getFolder(folderName);
//			assertTrue(folder.exists());
//			
//		}
	}

	public void testRefactorerFactory(){
		IFile file = (IFile) testProject.findMember(path);
		String filePath = file.getFullPath().toOSString();
		URI uri = URI.createFileURI(filePath);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		//		ResourceSet rs = new ResourceSetImpl();
		//		URI uri = URI.createURI(tempPath);
		//		resource = rs.getResource(uri, true);
		refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource);
		assertNotNull(refactorer);
	}

	public void testGetPossibleRefactoringSpecifications(){
		List<RefactoringSpecification> refSpecs = refactorer.getPossibleRefactorings(1.0);
		assertNotNull(refSpecs);
	}

	public void testRefactoringInterpreter(){
		EObject refactoredModel = refactorer.refactor(null, true);
		assertNull(refactoredModel);
	}
}
