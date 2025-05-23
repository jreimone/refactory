/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * This class is used to create an example project via the new dialog of Eclipse.
 * The contents of the example project are obtained from a ZIP file named
 * <code>newProject.zip</code> that must be located in the resource.ui plug-in. If
 * not such ZIP file can be found, an empty project containing an example file of
 * the DSL is created.
 */
public class CoedNewProjectWizardLogic {
	
	/**
	 * Creates the example project by unzipping the contents of
	 * <code>newProjectZip</code>.
	 */
	public void createExampleProject(IProgressMonitor monitor, IPath projectPath, String projectName, String bundleName, String newProjectZip) throws InterruptedException {
		try {
			monitor.beginTask("Creating Example Project", 120);
			
			// Create the project folder
			String projectFolder = projectPath.toOSString() + File.separator + projectName;
			File projectFolderFile = new File(projectFolder);
			
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().getProject(projectName);
			
			// If the project does not exist, we will create it and populate it.
			if (!project.exists()) {
				projectFolderFile.mkdirs();
				monitor.worked(10);
				
				Bundle bundle = Platform.getBundle(bundleName);
				URL newProjectZipURL = bundle.getEntry(newProjectZip);
				
				if (newProjectZipURL != null) {
					// Copy plug-in project code
					extractProject(projectFolderFile, newProjectZipURL, new SubProgressMonitor(monitor, 100));
				}
				
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				
				IProjectDescription desc = workspace.newProjectDescription(project.getName());
				if (!projectPath.equals(workspace.getRoot().getLocation())) {
					desc.setLocation(new Path(projectFolder));
				}
				
				String natureID = org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedNature.NATURE_ID;
				List<ICommand> buildCommands = new ArrayList<ICommand>();
				for (String builderID : org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedNature.BUILDER_IDS) {
					ICommand command = desc.newCommand();
					command.setBuilderName(builderID);
					buildCommands.add(command);
				}
				
				desc.setNatureIds(new String[] {natureID});
				desc.setBuildSpec(buildCommands.toArray(new ICommand[buildCommands.size()]));
				addProjectToSelectedWorkingSet(project);
				project.create(desc, monitor);
				// Now, we ensure that the project is open.
				project.open(monitor);
				renameProject(project, projectName);
				
				IFile defaultNewFile = project.getFile("NEW_FILE_PLACEHOLDER");
				if (newProjectZipURL == null) {
					defaultNewFile.create(new ByteArrayInputStream(new byte[0]), true, null);
				}
				if (defaultNewFile.exists()) {
					org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation info = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation();
					String fileName = "new_file." + info.getSyntaxName();
					String content = info.getNewFileContentProvider().getNewFileContent("new_file." + info.getSyntaxName());
					defaultNewFile.setContents(new ByteArrayInputStream(content.getBytes()), IFile.FORCE, null);
					defaultNewFile.move(project.getProjectRelativePath().append(fileName), true, null);
				}
			}
			
			monitor.worked(10);
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		} finally {
			monitor.done();
		}
	}
	
	/**
	 * Adds the newly created project to the currently selected working set.
	 * 
	 * @param project the project to be added to the selected working set
	 */
	private void addProjectToSelectedWorkingSet(IProject project) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		ISelectionService selectionService = workbench.getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable) firstElement;
				IWorkingSet workingSet = (IWorkingSet) adaptable.getAdapter(IWorkingSet.class);
				if (workingSet != null) {
					// new project wizard was invoked by right-clicking a working set
					IWorkingSetManager workingSetManager = workbench.getWorkingSetManager();
					workingSetManager.addToWorkingSets(project, new IWorkingSet[]{workingSet});
				}
			}
		}
	}
	
	/**
	 * Unzip the project archive to the specified folder
	 * 
	 * @param projectFolderFile The folder where to unzip the project archive
	 * @param monitor Monitor to display progress and/or cancel operation
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws java.io.FileNotFoundException
	 */
	private void extractProject(File projectFolderFile, URL url, IProgressMonitor monitor) throws java.io.FileNotFoundException, IOException, InterruptedException {
		
		// Get project archive
		URL urlZipLocal = org.eclipse.core.runtime.FileLocator.toFileURL(url);
		
		// Walk each element and unzip
		java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(urlZipLocal.getPath());
		
		try {
			// Allow for a hundred work units
			monitor.beginTask("Extracting Project", zipFile.size());
			
			unzip(zipFile, projectFolderFile, monitor);
		} finally {
			zipFile.close();
			monitor.done();
		}
	}
	
	/**
	 * Unzips the platform formatted zip file to specified folder
	 * 
	 * @param zipFile The platform formatted zip file
	 * @param projectFolderFile The folder where to unzip the project archive
	 * @param monitor Monitor to display progress and/or cancel operation
	 * 
	 * @throws IOException
	 * 
	 * @throws java.io.FileNotFoundException
	 * 
	 * @throws InterruptedException
	 */
	private void unzip(java.util.zip.ZipFile zipFile, File projectFolderFile, IProgressMonitor monitor) throws IOException, java.io.FileNotFoundException, InterruptedException {
		
		Enumeration<? extends java.util.zip.ZipEntry> e = zipFile.entries();
		
		while (e.hasMoreElements()) {
			java.util.zip.ZipEntry zipEntry = (java.util.zip.ZipEntry) e.nextElement();
			File file = new File(projectFolderFile, zipEntry.getName());
			
			if (zipEntry.isDirectory()) {
				file.mkdirs();
			} else {
				
				// Copy files (and make sure parent directory exist)
				File parentFile = file.getParentFile();
				if (null != parentFile && false == parentFile.exists()) {
					parentFile.mkdirs();
				}
				
				Path path = new Path(file.getPath());
				if ("java".equals(path.getFileExtension())) {
					InputStreamReader is = null;
					OutputStreamWriter os = null;
					
					try {
						is = new InputStreamReader(zipFile.getInputStream(zipEntry), "ISO-8859-1");
						os = new OutputStreamWriter(new FileOutputStream(file), ResourcesPlugin.getEncoding());
						char[] buffer = new char[102400];
						while (true) {
							int len = is.read(buffer);
							if (len < 0) {
								break;
							}
							os.write(buffer, 0, len);
						}
					} finally {
						if (null != is) {
							is.close();
						}
						if (null != os) {
							os.close();
						}
					}
				} else {
					InputStream is = null;
					OutputStream os = null;
					
					try {
						is = zipFile.getInputStream(zipEntry);
						os = new FileOutputStream(file);
						
						byte[] buffer = new byte[102400];
						while (true) {
							int len = is.read(buffer);
							if (len < 0) {
								break;
							}
							os.write(buffer, 0, len);
						}
					} finally {
						if (null != is) {
							is.close();
						}
						if (null != os) {
							os.close();
						}
					}
				}
			}
			
			monitor.worked(1);
			
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
		}
	}
	
	/**
	 * Renames the specified project to the specified name.
	 * 
	 * @param project a project to rename
	 * @param projectName a new name for the project
	 * 
	 * @throws CoreException if something goes wrong
	 */
	private void renameProject(IProject project, String projectName) throws CoreException {
		IProjectDescription description = project.getDescription();
		description.setName(projectName);
	}
	
}
