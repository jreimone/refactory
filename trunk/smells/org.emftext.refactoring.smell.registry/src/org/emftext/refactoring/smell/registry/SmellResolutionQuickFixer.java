package org.emftext.refactoring.smell.registry;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class SmellResolutionQuickFixer implements IMarkerResolutionGenerator, IMarkerResolutionGenerator2 {

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		Triple triple = initTripleFromMarker(marker);
		EObject element = triple.getElement();
		Resource resource = triple.getResource();
		RoleMapping roleMapping = triple.getRoleMapping();
		if(roleMapping != null && element != null && resource != null){
			IMarkerResolution quickFix = new SmellResolutionQuickFix(roleMapping, element, resource);
			return new IMarkerResolution[]{quickFix};
		}
		return new IMarkerResolution[]{};
	}

	@Override
	public boolean hasResolutions(IMarker marker) {
		Triple triple = initTripleFromMarker(marker);
		EObject element = triple.getElement();
		Resource resource = triple.getResource();
		RoleMapping roleMapping = triple.getRoleMapping();
		if(element != null && roleMapping != null && resource != null){
			return true;
		}
		return false;
	}

	private Triple initTripleFromMarker(IMarker marker){
		Triple triple = new Triple();
		try {
			String roleMappingUri = (String) marker.getAttribute(IQualitySmellMarker.ROLEMAPPING);
			String elementUri = (String) marker.getAttribute(IMarker.LOCATION);
			IResource iresource = marker.getResource();
			IFile file = (IFile) iresource.getAdapter(IFile.class);
			if(file != null && roleMappingUri != null && elementUri != null){
				ResourceSet rs = new ResourceSetImpl();
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = rs.getResource(uri, true);
				triple.setResource(resource);
				if(resource != null){
					uri = URI.createURI(elementUri);
					EObject element = rs.getEObject(uri, true);
					triple.setElement(element);
					uri = URI.createURI(roleMappingUri);
					Map<String, Map<String, RoleMapping>> roleMappingsMap = IRoleMappingRegistry.INSTANCE.getRoleMappingsMap();
					Map<String, RoleMapping> map = roleMappingsMap.values().iterator().next();
					RoleMapping firstRoleMapping = map.values().iterator().next();
					ResourceSet registryResourceSet = firstRoleMapping.eResource().getResourceSet();
					RoleMapping roleMapping = (RoleMapping) registryResourceSet.getEObject(uri, true);
					triple.setRoleMapping(roleMapping);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return triple;
	}

	private class Triple{
		private Resource resource;
		private EObject element;
		private RoleMapping roleMapping;
		public Resource getResource() {
			return resource;
		}
		public void setResource(Resource resource) {
			this.resource = resource;
		}
		public EObject getElement() {
			return element;
		}
		public void setElement(EObject element) {
			this.element = element;
		}
		public RoleMapping getRoleMapping() {
			return roleMapping;
		}
		public void setRoleMapping(RoleMapping roleMapping) {
			this.roleMapping = roleMapping;
		}
	}
}
