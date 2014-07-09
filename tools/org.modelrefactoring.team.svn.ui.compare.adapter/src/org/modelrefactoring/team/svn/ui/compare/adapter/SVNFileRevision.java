package org.modelrefactoring.team.svn.ui.compare.adapter;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.team.core.history.IFileRevision;
import org.eclipse.team.core.history.provider.FileRevision;
import org.eclipse.team.svn.core.PathForURL;
import org.eclipse.team.svn.core.resource.IRepositoryResource;
import org.eclipse.team.svn.core.resource.IRepositoryResource.Information;
import org.eclipse.team.svn.ui.compare.ResourceCompareInput.ResourceElement;

public class SVNFileRevision extends FileRevision {

	private IRepositoryResource repositoryResource;
	private ResourceElement resourceElement;
	
	public SVNFileRevision(IRepositoryResource repositoryResource, ResourceElement resourceElement) {
		super();
		assert repositoryResource != null;
		assert resourceElement != null;
		this.repositoryResource = repositoryResource;
		this.resourceElement = resourceElement;
	}

	@Override
	public URI getURI() {
		URI uri;
		try {
			uri = new URI(repositoryResource.getUrl());
			return uri;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public IFileRevision withAllProperties(IProgressMonitor monitor)throws CoreException {
		return this;
	}

	@Override
	public boolean isPropertyMissing() {
		Information info = repositoryResource.getInfo();
		return !info.hasProperties;
	}

	@Override
	public String getName() {
		return resourceElement.getName();
	}

	@Override
	public IStorage getStorage(IProgressMonitor monitor) throws CoreException {
		return new IStorage() {

			@Override
			public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
				return null;
			}

			@Override
			public boolean isReadOnly() {
				return !resourceElement.isEditable();
			}

			@Override
			public String getName() {
				return resourceElement.getName();
			}

			@Override
			public IPath getFullPath() {
				String url = repositoryResource.getUrl();
				IPath path = new PathForURL(url, true);
				return path;
			}

			@Override
			public InputStream getContents() throws CoreException {
				return resourceElement.getContents();
			}
		};
	}

}
