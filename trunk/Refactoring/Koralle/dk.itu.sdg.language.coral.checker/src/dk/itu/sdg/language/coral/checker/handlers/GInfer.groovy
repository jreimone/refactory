package dk.itu.sdg.language.coral.checker.handlers

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import dk.itu.sdg.language.coral.checker.Reader;

class GInfer extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		def IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 2) {
			def selections = selection.toArray();
			def fstSelection = selections[0];
			def sndSelection = selections[1];
			
			
			def firstString = this.getResourceContent(fstSelection)
			def secondString = this.getResourceContent(sndSelection)
			
			println firstString
			println secondString
					
//			CommonSubStrings.longestSubstr(first, second);
			
//			Reader reader = new Reader(this.getResource(fstSelection), this.getResource(sndSelection));
//			
//			String a = reader.getEmfResources().fst.getURI().toString();
//			String b = reader.getEmfResources().snd.getURI().toString();
//
//			System.out.println(a + " " + reader.getEmfResources().fst.getClass() + " --- " + b + " " + reader.getEmfResources().snd.getClass());
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select two files.")
		}

		return null;
	}

	def private String getResourceContent(Object selection) {
		
		def content
		def file
		
		if (selection instanceof File) {
			file = (File) selection
			content = file.getF
		} else if (selection instanceof CompilationUnit) {
			file = (CompilationUnit) selection;
			content = file.getText();
		}
				
		return content;
	}
}
