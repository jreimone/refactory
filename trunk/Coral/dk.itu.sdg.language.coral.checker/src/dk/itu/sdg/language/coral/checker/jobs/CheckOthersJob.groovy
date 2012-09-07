package dk.itu.sdg.language.coral.checker.jobs

import java.lang.reflect.Method
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Project
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.progress.UIJob;

import dk.itu.sdg.language.coral.checker.GReader
import dk.itu.sdg.language.coral.checker.ResourceUtil
import dk.itu.sdg.language.coral.checker.VisualCoralRelation
import dk.itu.sdg.language.coral.checker.handlers.Check;
import dk.itu.sdg.language.coral.checker.ui.MarkerGenerator
import dk.itu.sdg.language.coral.resource.coral.ui.model.RelationModel

class CheckOthersJob extends Job {
	
	def final IResource resource
	def HashMap clusteredFiles = []
	def Check checkHandler
	
	CheckOthersJob(IResource resource, Check check) {
		super("Checkinging Relations in Project")
		this.resource = resource
		this.clusteredFiles = clusteredFiles
		this.checkHandler = check
	}
	
	
	@Override
	public IStatus run(IProgressMonitor monitor) {
		
		Project containerProject = this.resource.getProject()
		ArrayList<org.eclipse.core.internal.resources.File> files = ResourceUtil.getFilesFromResource(containerProject)
		Map<String,Set<org.eclipse.core.internal.resources.File>> clusteredFiles = ResourceUtil.clusterFiles(files)
		
		monitor.beginTask("Checking...", 7*files.size())
		
		RelationModel relationModel = RelationModel.getInstance()
						
		ArrayList<ArrayList<Class>> classes = checkHandler.loadCheckerClasses(monitor)
		ArrayList<Method> collectors = checkHandler.getCollectorMethods(monitor, classes.get(0))
		
		Object[] languages = clusteredFiles.keySet().toArray()

		for (Object language : languages) {
			
			//TODO: This must be changed to get the 'longer' file extensions
			if(!language.equals(resource.getFileExtension())) {
				Set<org.eclipse.core.internal.resources.File> filesPerLanguage = clusteredFiles.get(language)
				
				for (org.eclipse.core.internal.resources.File file : filesPerLanguage) {

					
					monitor.subTask("Reading Files... " + "[" + language + "]")
					GReader reader = new GReader(ResourceUtil.getResource(resource), ResourceUtil.getResource(file))
					monitor.worked(1)
					
					if(reader.getEmfResources().fst != null && reader.getEmfResources().snd != null) {
						Set relations = checkHandler.performChecks(monitor, reader, resource, file, collectors, classes)
						
						
						if (relations.size() > 0) {
							
							monitor.subTask("Creating Markers... ")
							MarkerGenerator.createMarkers(resource, file, reader.getEmfResources().fst, reader.getEmfResources().snd, (Set<VisualCoralRelation>)relations)							
							relationModel.addRelations(relations)
						}
					}
					
					
					monitor.worked(1)
				}
			}
		}
		
		
		monitor.done()
		
		return Status.OK_STATUS
	}

	public class OpenEditorJob extends UIJob { //("Open Editors") {
		
		OpenEditorJob(String string) {
			super(string)
		}
					
		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
						
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						
			try {
				IDE.openEditor(page, (IFile)resource);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			return Status.OK_STATUS;
		}
	};
}
