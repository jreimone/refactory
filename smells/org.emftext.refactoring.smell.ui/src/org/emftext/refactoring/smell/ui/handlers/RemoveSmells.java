package org.emftext.refactoring.smell.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.emftext.refactoring.smell.registry.IQualitySmellMarker;
import org.osgi.framework.FrameworkUtil;

public class RemoveSmells extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WorkspaceJob runnable = new WorkspaceJob("Cleaning Quality Smell markers") {

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot().findMarkers(IQualitySmellMarker.ID, true, IResource.DEPTH_INFINITE);
					for (IMarker marker : markers) {
						marker.delete();
					}
				} catch (CoreException e) {
					e.printStackTrace();
					return new Status(IStatus.WARNING, FrameworkUtil.getBundle(getClass()).getSymbolicName(), "Quality Smell markers couldn't be deleted");
				}
				return Status.OK_STATUS;
			}
		};
		runnable.schedule();
		return null;
	}
}
