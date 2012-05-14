package dk.itu.sdg.language.coral.checker.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import dk.itu.sdg.language.coral.checker.CheckGenerator;
import dk.itu.sdg.language.coral.checker.CommonStrings;
import dk.itu.sdg.language.coral.checker.GReader;
import dk.itu.sdg.language.coral.checker.Pair;
import dk.itu.sdg.language.coral.checker.PathFinder;
import dk.itu.sdg.language.coral.checker.ResourceUtil;

@SuppressWarnings("restriction")
public class Infer extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
				
		if (selection.size() == 2) {
			Object[]  selections = selection.toArray();
			final Object fstSelection = selections[0];
			final Object sndSelection = selections[1];	
			
			IResource fstFile = ResourceUtil.getResource(fstSelection);
			IResource sndFile = ResourceUtil.getResource(sndSelection);
			
			inferFromTwoFiles(fstFile, sndFile);
			
			
		} else if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];

			if (fstSelection instanceof Project) {
				Project project = (Project) fstSelection;
				
				inferFromProject(project);
			}
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select two files.");
		}

		return null;
	}
	
	public void inferFromProject(final Project project) {
		
		Job job = new Job("Infer Relations from Project") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {

				CheckGenerator generator = new CheckGenerator();
				
				ArrayList<File> files = ResourceUtil.getFilesFromResource(project);

				monitor.beginTask("Inferring...", (files.size() * files.size()));
				
				Map<String,Set<File>> clusteredFiles = ResourceUtil.clusterFiles(files);
				int numberOfLanguages = clusteredFiles.keySet().size();
				Object[] languages = clusteredFiles.keySet().toArray();
				
				for (int i = 0; i < numberOfLanguages - 1; i++) {
					Set<File> filesPerLanguageA = clusteredFiles.get(languages[i]);
					
					for (int j = i + 1; j < numberOfLanguages; j++) {
						Set<File> filesPerLanguageB = clusteredFiles.get(languages[j]);
						
						//TODO: Improve how files are loaded, i.e., cache them
						for (File fstFile : filesPerLanguageA) {
							
							monitor.subTask("Reading Files...");
							GReader fstReader = new GReader(fstFile);
							
							for (File sndFile : filesPerLanguageB) {
								GReader sndReader = new GReader(sndFile);
								
								
								monitor.subTask("Find Longest Common Strings...");
								CommonSubStrings commonsSubs = new CommonSubStrings();
								
//								System.out.println(fstFile.getName() + " --- " + sndFile.getName()); 
								
								String fstFileAsString = fstReader.getText().toString();
								String sndFileAsString = sndReader.getText().toString();			
								CommonStrings commons = commonsSubs.longestSubstr(fstFileAsString, sndFileAsString);
								
								monitor.worked(1);	
								
								monitor.subTask("Find Modell Elements for Longest Common Strings...");

								PathFinder pathFinder = new PathFinder();
								pathFinder.findCommonContents(fstReader.getEmfResource(), sndReader.getEmfResource(), commons);
								pathFinder.findCommonContentsOffsets(fstFileAsString, sndFileAsString, null);
								Pair relations = pathFinder.findCommonContentsElements(fstReader.getEmfResource(), sndReader.getEmfResource(), null);
								
								monitor.worked(1);
									
								monitor.subTask("Generate Relations as Constraints...");

								generator.generateFixedRelations((HashSet)relations.fst);
								generator.generateStringTransformationRelations((HashSet)relations.snd);
								
								monitor.worked(1);
							}
						}
					}
				}
				
				String classContents = generator.generateClass();
				generator.saveFile(classContents);
				
				monitor.worked(20);	
				
				
				
				
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}		
		
	
	public void inferFromTwoFiles(final IResource fstFile, final IResource sndFile) {
		
		if (fstFile != null && sndFile != null ) {
			
			Job job = new Job("Infer Relations from Two Files") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// Set total number of work units
					monitor.beginTask("Inferring...", 100);
					
					monitor.subTask("Reading Files...");
					monitor.worked(20);

					GReader reader = new GReader(fstFile, sndFile);
						
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

	}
}
