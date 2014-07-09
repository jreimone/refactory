package org.modelrefactoring.team.svn.ui.compare.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.team.core.history.IFileRevision;
import org.eclipse.team.svn.core.resource.IRepositoryResource;
import org.eclipse.team.svn.ui.compare.ResourceCompareInput.ResourceElement;

public class ResourceElementIFileRevisionAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if(adapterType != null && adaptableObject != null && adapterType.equals(IFileRevision.class) && adaptableObject instanceof ResourceElement){
			ResourceElement resourceElement = (ResourceElement) adaptableObject;
			IRepositoryResource repositoryResource = resourceElement.getRepositoryResource();
			if(repositoryResource != null){
				IFileRevision fileRevision = new SVNFileRevision(repositoryResource, resourceElement);
				return fileRevision;
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[]{IFileRevision.class};
	}

}
