package org.qualitune.evolution.ui.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.qualitune.evolution.registry.IKnowledgeBaseRegistry;
import org.qualitune.evolution.registry.IKnowledgeBase;
import org.qualitune.evolution.ui.views.ImplicitDependencyView;

public class GetImplicitDependenciesHandler extends AbstractHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Map<EObject, Collection<EObject>> modelChildrenMap = new HashMap<EObject, Collection<EObject>>();
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		Object firstElement = currentSelection.getFirstElement();
		if(firstElement instanceof IFile){
			IFile file = (IFile) firstElement;
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			if(!uri.isPlatformResource()){
				uri = URI.createPlatformResourceURI(uri.toString(), true);
			}
			try {
				ResourceSet rs = new ResourceSetImpl();
				IKnowledgeBaseRegistry registry = IKnowledgeBaseRegistry.INSTANCE;
				List<IKnowledgeBase> knowledgeBases = registry.getKnowledgeBases();
				for (IKnowledgeBase knowledgeBase : knowledgeBases) {
					Map<EObject, Collection<EObject>> dependencies = knowledgeBase.getDependencies(uri, rs);
					if(dependencies != null){
						modelChildrenMap.putAll(dependencies);
					}
				}
				ImplicitDependencyView view = (ImplicitDependencyView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ImplicitDependencyView.ID);
				Resource resource = rs.getResource(uri, true);
				view.updateModel(modelChildrenMap, resource);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return null;
	}




}
