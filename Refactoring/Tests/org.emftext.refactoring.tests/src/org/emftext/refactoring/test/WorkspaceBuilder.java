/**
 * 
 */
package org.emftext.refactoring.test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.emftext.test.test.AbstractRefactoringTest;
import org.reuseware.sokan.IndexRow;
import org.reuseware.sokan.Store;
import org.reuseware.sokan.index.util.IndexUtil;
import org.reuseware.sokan.index.util.StoreUtil;
import org.reuseware.sokan.resource.util.BuildUtil;

public class WorkspaceBuilder {

	private static AbstractRefactoringTest test;
	private static boolean alreadyBuilt = false;
	private static IProject testProject;
	public static WorkspaceBuilder INSTANCE = new WorkspaceBuilder();

	public static final String TEST_PROJECT_NAME = "EMFTextTest";
	public static final String[] FOLDERS_TO_BE_COPIED_INTO_TEST_PROJECT = new String[]{
		"refspecs",
		"role_mappings",
		"roles",
		"pl0"
	};

	public static final List<String> VALID_EXTENSIONS_FOR_COPYING = Arrays.asList(
			"refspec",
			"rolemapping",
			"rolestext",
			"pl0"
	);

	private WorkspaceBuilder(){
		// empty
	}

//	public static void setTest(AbstractRefactoringTest test){
////		if(!test.equals(WorkspaceBuilder.test)){
////			clearWorkspace();
////		}
//		clearWorkspace();
//		WorkspaceBuilder.test = test;
//	}

	protected static void clearWorkspace(){
		//		if(!allTestCasesWereInvoked()){
		//			return;
		//		}
		if(testProject != null){
			StoreUtil.INSTANCE.unmarkStore(testProject);
			try {
				testProject.delete(true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
//		List<IndexRow> rows = IndexUtil.INSTANCE.getIndex();
//		for (IndexRow indexRow : rows) {
//			IndexUtil.INSTANCE.remove(indexRow.getArtifactID(), false);
//		}
		alreadyBuilt = false;
	}

//	public static void buildTestWorkspace(){
//		String testProjectName = test.getTestProjectName();
//		if(testProjectName == null || "".equals(testProjectName)){
//			testProjectName = TEST_PROJECT_NAME;
//		}
//		String[] folders = test.getFolderNamesToCopyIntoTestProject();
//		if(folders == null){
//			folders = FOLDERS_TO_BE_COPIED_INTO_TEST_PROJECT;
//		}
//		List<String> extensions = test.getValidExtensions();
//		if(extensions == null){
//			extensions = VALID_EXTENSIONS_FOR_COPYING;
//		}
//		if(alreadyBuilt){
//			return;
//		}
//		IWorkspace ws = ResourcesPlugin.getWorkspace();
//		assertNotNull(ws);
//		IWorkspaceRoot wsr = ws.getRoot();
//		assertNotNull(wsr);
//		testProject = wsr.getProject(testProjectName);
//		assertNotNull(testProject);
//		try {
//			if(!testProject.exists()){
//				testProject.create(null);
//			}
//			testProject.open(null);
//			assertTrue(testProject.exists());
//			assertTrue(testProject.isOpen());
//			for (String folderName : folders) {
//				IFolder folder = testProject.getFolder(folderName);
//				if(!folder.exists()){
//					folder.create(IResource.NONE, true, null);
//				}
//				File dir = new File(folderName);
//				copyFilesIntoTestProject(dir, folder, extensions);
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//			assert false;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			assert false;
//		}
//		initializeSokan();
//		alreadyBuilt = true;
//	}

	public static void copyFilesIntoTestProject(File fromFolder, IFolder toIFolder, List<String> filterExtensions) throws CoreException, FileNotFoundException{
		assertTrue(fromFolder.exists());
		assertTrue(fromFolder.isDirectory());
		File[] files = fromFolder.listFiles();
		for (File file : files) {
			if(file.isFile()){
				String ext = file.getName().split("\\.")[1];
				if(filterExtensions.contains(ext)){
					IFile ifile = toIFolder.getFile(file.getName());
					if(!ifile.exists()){
						FileInputStream is = new FileInputStream(file);
						ifile.create(is, true, null);
					}
					assertTrue(ifile.exists());
				}
			}
		}
	}

	private static void initializeSokan(){
		List<String> patterns = new ArrayList<String>(1);
		patterns.add("*.*");
		Store store = StoreUtil.INSTANCE.buildStore(patterns, testProject);
		BuildUtil.INSTANCE.toggleStore(testProject, store);
	}

//	public static IProject getTestProject() {
//		return testProject;
//	}

}
