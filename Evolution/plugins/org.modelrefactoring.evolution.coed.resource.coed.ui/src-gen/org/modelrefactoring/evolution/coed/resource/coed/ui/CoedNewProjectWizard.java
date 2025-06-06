/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import java.net.URL;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.osgi.framework.Bundle;

/**
 * This class is based on:
 * <i>org.eclipse.gef.examples.ui.pde.internal.wizards.ProjectUnzipperNewWizard</i>
 * .
 * It is responsible for offering an example project via the new dialog of Eclipse.
 */
public class CoedNewProjectWizard extends Wizard implements INewWizard, org.eclipse.core.runtime.IExecutableExtension {
	
	/**
	 * The name of the ZIP file that is used as content for the new project (relative
	 * to the resource UI plugin's root).
	 */
	public final static String NEW_PROJECT_ZIP_FILE_NAME = "newProject.zip";
	
	/**
	 * The single page provided by this base implementation. It provides all the
	 * functionality required to capture the name and location of the target project.
	 */
	private WizardNewProjectCreationPage wizardNewProjectCreationPage;
	
	/**
	 * The name of the project creation page
	 */
	private String pageName = "New " + new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation().getSyntaxName() + " Project";
	
	/**
	 * The title of the project creation page
	 */
	private String pageTitle = pageName;
	
	/**
	 * The description of the project creation page
	 */
	private String pageDescription = "Enter a name and select a location where the new project shall be created.";
	
	/**
	 *  The name of the project in the project creation page
	 */
	private String  pageProjectName = "";
	
	/**
	 * The configuration element associated with this new project wizard
	 */
	private IConfigurationElement config;
	
	/**
	 * Creates the example project by delegating the work to
	 * org.modelrefactoring.evolution.coed.resource.coed.ui.CoedNewProjectWizardLogic.
	 */
	public boolean performFinish() {
		
		try {
			IRunnableWithProgress operation = new WorkspaceModifyOperation() {
				
				public void execute(IProgressMonitor monitor) throws InterruptedException {
					try {
						new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedNewProjectWizardLogic().createExampleProject(monitor, wizardNewProjectCreationPage.getLocationPath(), wizardNewProjectCreationPage.getProjectName(), org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.PLUGIN_ID, NEW_PROJECT_ZIP_FILE_NAME);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			};
			
			getContainer().run(false, true, operation);
			
			// Set perspective
			BasicNewProjectResourceWizard.updatePerspective(config);
		} catch (InterruptedException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Creates the sole wizard page contributed by this base implementation; the
	 * standard Eclipse WizardNewProjectCreationPage.
	 * 
	 * @see WizardNewProjectCreationPage#WizardNewProjectCreationPage(String)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// Set default image for all wizard pages
		IPath path = new Path("icons/new_project_wizban.gif");
		Bundle bundle = org.modelrefactoring.evolution.coed.resource.coed.ui.CoedUIPlugin.getDefault().getBundle();
		URL url = org.eclipse.core.runtime.FileLocator.find(bundle, path, null);
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
		setDefaultPageImageDescriptor(descriptor);
		
		wizardNewProjectCreationPage = new WizardNewProjectCreationPage(pageName);
		wizardNewProjectCreationPage.setTitle(pageTitle);
		wizardNewProjectCreationPage.setDescription(pageDescription);
		wizardNewProjectCreationPage.setInitialProjectName(pageProjectName);
		
		this.addPage(wizardNewProjectCreationPage);
	}
	
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		this.config = config;
	}
	
}
