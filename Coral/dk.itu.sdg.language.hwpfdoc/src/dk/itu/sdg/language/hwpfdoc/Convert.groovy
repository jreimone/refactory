package dk.itu.sdg.language.hwpfdoc

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.core.internal.resources.File
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;


class Convert extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 1) {
			Object[]  selections = selection.toArray()
			Object fstSelection = selections[0]
			
			if (fstSelection instanceof File) {
				def final File file = (File) fstSelection;

				Job convertToModelJob = new Job("Converting Word File...") {
					
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						def HWPFDocCreator converter = new HWPFDocCreator(file)
						def modelDocument = converter.convertDocToModel()
						converter.saveModel(modelDocument)
						return Status.OK_STATUS;
					}
				};
			
				convertToModelJob.schedule()
			}
		}
		
		return null;
	}

}
