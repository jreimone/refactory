package dk.itu.sdg.language.coral.checker.handlers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import dk.itu.sdg.language.coral.checker.CommonStrings;
import dk.itu.sdg.language.coral.checker.PathFinder;
import dk.itu.sdg.language.coral.checker.Reader;

@SuppressWarnings("restriction")
public class Infer extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 2) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];
			Object sndSelection = selections[1];
			
			//TODO: do the same thing again with decapitalized letters to find similar strings better
			String firstString = this.getResourceContent(fstSelection);
			String secondString = this.getResourceContent(sndSelection);
			
			CommonSubStrings commonsSubs = new CommonSubStrings();
			CommonStrings commons = commonsSubs.longestSubstr(firstString, secondString);
//			System.out.println(commons);
			
			Reader reader = new Reader(this.getResource(fstSelection), this.getResource(sndSelection));
			
			PathFinder pathFinder = new PathFinder();
			pathFinder.findPathes(reader.getEmfResources().fst, reader.getEmfResources().snd, commons);
			
//			String a = reader.getEmfResources().fst.getURI().toString();
//			String b = reader.getEmfResources().snd.getURI().toString();
////
//			System.out.println(a + " " + reader.getEmfResources().fst.getClass() + " --- " + b + " " + reader.getEmfResources().snd.getClass());
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select two files.");
		}

		return null;
	}
	
	private IResource getResource(Object selection) {
		
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
	
	/**
	 * CAUTION: For large files a String might be too small to hold the files contents!!!
	 * In that case the CommonSubstringMethod has to be adapted to work on parts of files.
	 * 
	 * @param selection
	 * @return the content of the file as string
	 */
	private String getResourceContent(Object selection) {

		String content = "";
		File file = null;
		
		if (selection instanceof File) {
			file = (File) selection;	
		} else if (selection instanceof CompilationUnit) {
			file = (File)((CompilationUnit)selection).getResource();		
		}
		
		if (file != null) {
			InputStream fileStream;
			try {
				fileStream = file.getContents();
			
				DataInputStream inputStream = new DataInputStream(fileStream);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String stringLine;
				
				while ((stringLine = bufferedReader.readLine()) != null)   {
					content = content + "\n" + stringLine;
				}
				
				inputStream.close();
				
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return content;
	}
}
