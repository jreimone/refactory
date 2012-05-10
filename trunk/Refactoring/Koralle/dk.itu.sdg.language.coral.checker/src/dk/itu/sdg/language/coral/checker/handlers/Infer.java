package dk.itu.sdg.language.coral.checker.handlers;

import java.util.HashSet;

import org.antlr.runtime3_4_0.CommonTokenStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import dk.itu.sdg.language.coral.checker.CheckGenerator;
import dk.itu.sdg.language.coral.checker.CommonStrings;
import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.Pair;
import dk.itu.sdg.language.coral.checker.PathFinder;

@SuppressWarnings("restriction")
public class Infer extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		//TODO: put this into a Job!!!
		
		if (selection.size() == 2) {
			Object[]  selections = selection.toArray();
			final Object fstSelection = selections[0];
			final Object sndSelection = selections[1];	
			
			IResource fstFile = this.getResource(fstSelection);
			IResource sndFile = this.getResource(sndSelection);
			
			if (fstFile != null && sndFile != null ) {
				
				Job job = new Job("Infer Relations from Two Files") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						// Set total number of work units
						monitor.beginTask("Inferring...", 100);
						
						monitor.subTask("Reading Files...");
						monitor.worked(20);

						GReader reader = new GReader(Infer.getResource(fstSelection), Infer.getResource(sndSelection));
							
						monitor.subTask("Find Longest Common Strings...");
						monitor.worked(20);

						CommonSubStrings commonsSubs = new CommonSubStrings();
						Pair<CommonTokenStream, CommonTokenStream> contents = reader.getTexts();
							
						String fstFileAsString = contents.fst.toString();
						String sndFileAsString = contents.snd.toString();			
						CommonStrings commons = commonsSubs.longestSubstr(fstFileAsString, sndFileAsString);
							
						monitor.subTask("Find Modell Elements Longest Common Strings...");
						monitor.worked(20);

						PathFinder pathFinder = new PathFinder();
						pathFinder.findCommonContents(reader.getEmfResources().fst, reader.getEmfResources().snd, commons);
						pathFinder.findCommonContentsOffsets(fstFileAsString, sndFileAsString, null);
						Pair relations = pathFinder.findCommonContentsElements(reader.getEmfResources().fst, reader.getEmfResources().snd, null);
							
						monitor.subTask("Generate Relations as Constraints...");
						monitor.worked(20);

						CheckGenerator generator = new CheckGenerator();
						generator.generateFixedRelations((HashSet)relations.fst);
						generator.generateStringTransformationRelations((HashSet)relations.snd);
						String classContents = generator.generateClass();
						generator.saveFile(classContents);
						
						
						return Status.OK_STATUS;
					}
				};
				job.schedule();
			}

		} else if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];

			if (fstSelection instanceof Project) {
				//TODO: implement to get all files of languages and compare them
				MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Under construction...");
			}
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select two files.");
		}

		return null;
	}
	
	public static IResource getResource(Object selection) {
		
		IResource resource = null;
		if (selection instanceof File) {
			File file = (File) selection;
			resource = file;
		} else if (selection instanceof CompilationUnit) {
			CompilationUnit file = (CompilationUnit) selection;			
			resource = file.getResource();
		}
		return resource;
	}
}
