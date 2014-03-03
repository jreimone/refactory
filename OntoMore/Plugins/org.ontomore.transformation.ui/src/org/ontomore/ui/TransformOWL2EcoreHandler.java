package org.ontomore.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.ontomore.transformation.OWL2EcoreTransformer;

public class TransformOWL2EcoreHandler extends AbstractHandler {

	private IFile file;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			String fileName = getFileNameFromSelection(selection);
			new OWL2EcoreTransformer().runTransformation(fileName);
			refreshWorkspace();
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception during transformation and generation of new file",
					e);
		}
		return null;
	}
	
	private String getFileNameFromSelection(ISelection selection) {
		if (!(selection instanceof TreeSelection)) {
			throw new RuntimeException("Unsupported Selection");
		}
		TreeSelection concreSelection = (TreeSelection) selection;
		Object firstObject = concreSelection.getFirstElement();
		if (!(firstObject instanceof IFile)) {
			throw new RuntimeException("Unsupported type of selected element");
		}
		file = (IFile) firstObject;
		return file.getLocation().toOSString();
	}
	
	private void refreshWorkspace() throws CoreException {
		file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
	}
}
