package dk.itu.sdg.language.coral.checker.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import dk.itu.sdg.language.coral.checker.Reader;
import dk.itu.sdg.language.coral.resource.coral.mopp.GGeneratedCheck;
 

@SuppressWarnings("restriction")
public class Check extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		if (selection.size() == 2) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];
			Object sndSelection = selections[1];
			
			
			
			Reader reader = new Reader(this.getResource(fstSelection), this.getResource(sndSelection));
			
			String a = reader.getEmfResources().fst.getURI().toString();
			String b = reader.getEmfResources().snd.getURI().toString();

			System.out.println(a + " " + reader.getEmfResources().fst.getClass() + " --- " + b + " " + reader.getEmfResources().fst.getClass());
			
			GGeneratedCheck.checkConstraint(reader.getEmfResources().fst, reader.getEmfResources().snd);
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
