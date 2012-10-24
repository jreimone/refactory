package dk.itu.sdg.language.coral.checker.handlers

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.internal.resources.File
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;


import dk.itu.sdg.language.coral.checker.jobs.Convert2PrologJob;

class Convert2PrologHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		def IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event)
		
		if (selection.size() == 1) {
			def Object[] selections = selection.toArray()
			def Object fstSelection = selections[0]

			if (fstSelection instanceof Project) {
				
				def Project project = (Project) fstSelection
				convertProject(project)
				
			} else if (fstSelection instanceof org.eclipse.core.internal.resources.File) {
				
				def File file = (File) fstSelection
				convertFile(file)
			} else if (fstSelection instanceof CompilationUnit) {
				CompilationUnit cUnit = (CompilationUnit) fstSelection;			
			
				convertJavaFile((IResource)fstSelection);
			}	
			
		}
	}
	
	protected void convertProject(final IResource resource) {
		
		def Convert2PrologJob job = new Convert2PrologJob(resource)
		job.schedule()
	}
	
	protected void convertFile(final IResource resource) {
		
		def Convert2PrologJob job = new Convert2PrologJob(resource)
		job.schedule()
	}
	
	protected void convertJavaFile(final IResource resource) {
		
		def Convert2PrologJob job = new Convert2PrologJob(resource)
		job.schedule()
	}
}
