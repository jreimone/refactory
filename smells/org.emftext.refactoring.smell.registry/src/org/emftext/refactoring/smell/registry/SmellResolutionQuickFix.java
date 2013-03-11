package org.emftext.refactoring.smell.registry;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.ui.RefactoringAction;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;

public class SmellResolutionQuickFix implements IMarkerResolution, IMarkerResolution2 {

	private Resource resource;
	private EObject element;
	private RoleMapping roleMapping;
	private IRefactorer refactorer;
	private ImageDescriptor imageDescriptor;
	private Image image;

	public SmellResolutionQuickFix(RoleMapping roleMapping, EObject element, Resource resource) {
		this.roleMapping = roleMapping;
		this.element = element;
		this.resource = resource;
		init();
	}

	public void init() {
		refactorer = RefactorerFactory.eINSTANCE.getRefactorer(resource, roleMapping);
		refactorer.setInput(Lists.newArrayList(element));
		imageDescriptor = IRoleMappingRegistry.INSTANCE.getImageForMapping(roleMapping);
	}

	@Override
	public String getDescription() {
		String comment = roleMapping.getComment();
		if(comment == null || comment.trim().length() == 0){
			comment = "No description given for refactoring '" + roleMapping.getName() + "'";
		}
		comment = comment.trim();
		return comment;
	}

	@Override
	public String getLabel() {
		String label = roleMapping.getName().replace(" ", "");
		label = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, label);
		label = label.replace("_", " ");
		label = WordUtils.capitalizeFully(label);
		return label;
	}

	@Override
	public void run(IMarker marker) {
//		System.out.println("SmellResolutionQuickFix.run()");
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null){
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if(activePage != null){
				IEditorPart editor = null;
				try {
					String editorID = (String) marker.getAttribute(IQualitySmellMarker.EDITOR_ID);
//					if(editorID != null){
//						marker.getResource()
//						activePage.openEditor(input, editorId, activate, matchFlags)
//					} else {
//					}
					editor = IDE.openEditor(activePage, marker);
				} catch (PartInitException e) {
					e.printStackTrace();
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if(editor != null){
					IEditorConnector editorConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(editor);
					RefactoringAction action = new RefactoringAction(refactorer, editorConnector);
					action.run();
				}
			}
		}
	}

//	private IFile getFileFromResource(Resource resource) {
//		URI uri = resource.getURI();
//		String platformString = uri.toPlatformString(true);
//		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
//		return file;
//	}

	@Override
	public Image getImage() {
		if(imageDescriptor != null && image == null){
			image = imageDescriptor.createImage();
		}
		return image;
	}

}
