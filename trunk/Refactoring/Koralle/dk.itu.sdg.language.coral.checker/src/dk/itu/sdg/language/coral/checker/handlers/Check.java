package dk.itu.sdg.language.coral.checker.handlers;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import dk.itu.sdg.language.coral.checker.Activator;
import dk.itu.sdg.language.coral.checker.CoralRelation;
import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.GeneratedChecks;
import dk.itu.sdg.language.coral.checker.MarkerGenerator;
 

@SuppressWarnings("restriction")
public class Check extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 2) {
			Object[]  selections = selection.toArray();
			final Object fstSelection = selections[0];
			final Object sndSelection = selections[1];

			Job job = new Job("Check Relations of Two Files") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// Set total number of work units
					monitor.beginTask("Inferring...", 100);
					
					monitor.subTask("Reading Files...");
					monitor.worked(50);

					GReader reader = new GReader(Infer.getResource(fstSelection), Infer.getResource(sndSelection));		
				
					//TODO:  incorporate manually written methods!!!
					Bundle bundle = Activator.getDefault().getBundle();
					IPath path = new Path("src-gen/dk/itu/sdg/language/coral/checker/GeneratedChecks.groovy");
					URL groovyClassUrl = FileLocator.find(bundle, path, Collections.EMPTY_MAP);
					try {
						File generatedRelationsClass = new File(FileLocator.toFileURL(groovyClassUrl).toURI());
					
						ClassLoader parent = getClass().getClassLoader();
						GroovyClassLoader loader = new GroovyClassLoader(parent);
						Class groovyClass = loader.parseClass(generatedRelationsClass);
		
						GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
						ArrayList<Resource> args = new ArrayList<Resource>();
						args.add(reader.getEmfResources().fst);
						args.add(reader.getEmfResources().snd);
						
						monitor.subTask("Checking Constraints...");
						monitor.worked(45);
						Object relations = groovyObject.invokeMethod("checkAllConstraints", args.toArray());
					
						System.out.println(relations);
						MarkerGenerator.createMarkers(Infer.getResource(fstSelection), Infer.getResource(sndSelection), reader.getEmfResources().fst, reader.getEmfResources().snd, (Set<CoralRelation>)relations);
						
					} catch (URISyntaxException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				
				
//					Set<CoralRelation> relations = GeneratedChecks.checkAllConstraints(reader.getEmfResources().fst, reader.getEmfResources().snd);
					

					
					
					return Status.OK_STATUS;
				}
			};
			job.schedule();
			
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				IDE.openEditor(page, (IFile)Infer.getResource(fstSelection));
				IDE.openEditor(page, (IFile)Infer.getResource(sndSelection));
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];

			if (fstSelection instanceof Project) {
				//TODO: implement to get all files of languages and check them
				MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Under construction...");
			} else if (getResource(fstSelection) != null) {
				//TODO: implement to get all files of languages and check them with this single one
				MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Under construction...");
			}
			
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select two files.");
		}

		return null;
	}
	
	private IResource getResource(Object selection) {
		
		IResource resource = null;
		if (selection instanceof org.eclipse.core.internal.resources.File) {
			org.eclipse.core.internal.resources.File file = (org.eclipse.core.internal.resources.File) selection;
			resource = file;
		} else if (selection instanceof CompilationUnit) {
			CompilationUnit file = (CompilationUnit) selection;			
			resource = file.getResource();
		}
		return resource;
	}
	
//	private void checkConstraint(Resource fstModel, Resource sndModel) {
//		
//		Set<EObject> fstElements = new HashSet<EObject>();
//		Iterator<EObject> i = fstModel.getAllContents();
//		while (i.hasNext()) {
//			Object o = i.next();
//			
//			if (o instanceof Field) {
//				Field element = (Field) o;
//				fstElements.add(element);
//			}
//		}
//		Set<EObject> sndElements = new HashSet<EObject>();
//		Iterator<EObject> j = sndModel.getAllContents();
//		while (i.hasNext()) {
//			Object o = i.next();
//			
//			if (o instanceof StringValParameter) {
//				StringValParameter element = (StringValParameter) o;
//				sndElements.add(element);
//			}
//		}
//		
//
//		for (Field fstElement : fstElements) {
//			
//			for (StringValParameter sndElement : sndElements) {
//				
//				sameName()
//			}
//		}
//	}
}
