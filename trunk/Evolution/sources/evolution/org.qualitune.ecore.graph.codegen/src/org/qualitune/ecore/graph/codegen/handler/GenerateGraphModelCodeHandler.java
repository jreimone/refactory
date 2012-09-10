package org.qualitune.ecore.graph.codegen.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.qualitune.ecore.graph.codegen.GraphModelCodeGenerator;

public class GenerateGraphModelCodeHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelectionChecked(event);
		if(currentSelection instanceof IStructuredSelection){
			IStructuredSelection selection = (IStructuredSelection) currentSelection;
			final GenModel genModel = (GenModel) selection.getFirstElement();
			Job generationJob = new Job("Generate graph model code for metamodel " + genModel.getModelName()) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						monitor.beginTask("Generation starts", 5);
						GraphModelCodeGenerator generator = new GraphModelCodeGenerator();
						
						monitor.subTask("Prepare genmodel for " + genModel.getModelName());
						generator.init(genModel);
						monitor.worked(1);
						
						monitor.subTask("Generate original model code for " + genModel.getModelName());
						generator.generateModel();
						monitor.worked(1);
						
						monitor.subTask("Plugin refresh of " + genModel.getModelPluginID());
						IProject project = generator.getProject();
						project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
						monitor.worked(1);
						
						monitor.subTask("Generate graph model code for " + genModel.getModelName());
						generator.generateGraphModel();
						monitor.worked(1);
						
						monitor.subTask("Plugin refresh of " + genModel.getModelPluginID());
						project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
						monitor.worked(1);
					} catch (CoreException e) {
						e.printStackTrace();
					}
					monitor.done();
					return Status.OK_STATUS;
				}
			};
			if(generationJob != null){
				generationJob.setUser(true);
				generationJob.schedule();
			}
		}
		return null;
	}

}
