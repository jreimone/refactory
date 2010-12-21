package org.emftext.language.refactoring.roles.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class RolesCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected RolesCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected RolesCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.RolesCreationWizardTitle);
		setDefaultPageImageDescriptor(RolesDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewRolesWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new RolesCreationWizardPage("DiagramModelFile", getSelection(), "rolesdiag"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle(Messages.RolesCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(Messages.RolesCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new RolesCreationWizardPage("DomainModelFile", getSelection(), "rolestext") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length()
							- ".rolesdiag".length()); //$NON-NLS-1$
					setFileName(RolesDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), fileName, "rolestext")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage.setTitle(Messages.RolesCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(Messages.RolesCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated NOT
	 */
	private String getFileNameWithoutExtension(IPath path) {
		return path.removeFileExtension().lastSegment();
	}

	/**
	 * @generated NOT
	 */
	private boolean equalFileNamesWithoutExtension() {
		return getFileNameWithoutExtension(domainModelFilePage.getFilePath()).equals(getFileNameWithoutExtension(diagramModelFilePage.getFilePath()));
	}

	/**
	 * @generated NOT
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				if (!equalFileNamesWithoutExtension()) {
					IPath diagramPath = diagramModelFilePage.getFilePath();
					String diagramName = getFileNameWithoutExtension(diagramPath);
					String fileExtension = domainModelFilePage.getExtension();
					String uniqueFileName = RolesDiagramEditorUtil.getUniqueFileName(domainModelFilePage.getContainerFullPath(), diagramName, fileExtension);
					domainModelFilePage.setFileName(uniqueFileName);
				}
				diagram = RolesDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						RolesDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(), Messages.RolesCreationWizardOpenEditorError, null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), Messages.RolesCreationWizardCreationError, null, ((CoreException) e.getTargetException()).getStatus());
			} else {
				RolesDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
