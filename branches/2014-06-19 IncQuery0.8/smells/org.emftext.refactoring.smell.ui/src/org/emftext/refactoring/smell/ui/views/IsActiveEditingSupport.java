package org.emftext.refactoring.smell.ui.views;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.emftext.refactoring.smell.Quality;

public class IsActiveEditingSupport extends EditingSupport {

	private TableViewer viewer;

	public IsActiveEditingSupport(TableViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new CheckboxCellEditor(viewer.getTable(), SWT.CHECK);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof Quality){
			return ((Quality) element).isActive();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof Quality && value instanceof Boolean){
			Quality quality = (Quality) element;
			boolean newValue = (Boolean) value;
			boolean oldValue = quality.isActive();
			quality.setActive(newValue);
			viewer.update(element, null);
//			if(!oldValue && newValue){
//				updateMarkedAndOpenFiles();
//			}
		}
	}

//	private void updateMarkedAndOpenFiles() {
//		Set<IFile> alreadyHandledFiles = new HashSet<IFile>();
//		try {
//			// open files
//			IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
//			for (IEditorReference editorReference : editorReferences) {
//				IEditorInput editorInput = editorReference.getEditorInput();
//				if(editorInput instanceof IFileEditorInput){
//					IFile openFile = ((IFileEditorInput) editorInput).getFile();
//					if(alreadyHandledFiles.add(openFile)){
//						SmellChecker.removeAllMarkers(openFile);
//						openFile.touch(new NullProgressMonitor());
//					}
//				}
//			}
//			// marked files
//			IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot().findMarkers(IQualitySmellMarker.ID, true, IResource.DEPTH_INFINITE);
//			for (IMarker marker : markers) {
//				IFile file = (IFile) marker.getResource();
//				if(alreadyHandledFiles.add(file)){
//					SmellChecker.removeAllMarkers(file);
//					file.touch(new NullProgressMonitor());
//				}
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//	}

}
