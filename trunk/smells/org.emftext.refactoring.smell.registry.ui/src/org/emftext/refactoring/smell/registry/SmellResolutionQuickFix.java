package org.emftext.refactoring.smell.registry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.eclipse.core.commands.Command;
import org.eclipse.core.resources.IMarker;
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
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.IDE;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.ui.RefactoringMenuContributor;

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
		String label = null;
		if(StringUtils.contains(roleMapping.getName(), " ")){
			label = roleMapping.getName();
		} else {
			label = roleMapping.getName().replace(" ", "");
			label = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, label);
			label = label.replace("_", " ");
			label = WordUtils.capitalizeFully(label);
		}
		return label;
	}

	@Override
	public void run(IMarker marker) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null){
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if(activePage != null){
				IEditorPart editor = null;
				try {
//					String editorID = (String) marker.getAttribute(IQualitySmellMarker.EDITOR_ID);
					editor = IDE.openEditor(activePage, marker);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				if(editor != null){
					IEditorConnector editorConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(editor);
					
					IHandlerService handlerService = (IHandlerService) activeWorkbenchWindow.getService(IHandlerService.class);
					Command command = RefactoringMenuContributor.getCommandForRefactoring(activeWorkbenchWindow, roleMapping, refactorer, editorConnector, editor);
					try {
						handlerService.executeCommand(command.getId(), null);
					} catch (Exception ex) {
						throw new RuntimeException("Command '" + command.getId() + "' threw an exception");
					}
				}
			}
		}
	}

	@Override
	public Image getImage() {
		if(imageDescriptor != null && image == null){
			image = imageDescriptor.createImage();
		}
		return image;
	}

}