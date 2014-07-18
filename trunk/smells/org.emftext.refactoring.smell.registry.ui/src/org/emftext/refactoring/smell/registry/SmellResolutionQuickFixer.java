package org.emftext.refactoring.smell.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		MarkerDeserialization deserialization = deserializeMarker(marker);
		if(deserialization != null){
			IMarkerResolution quickFix = new SmellResolutionQuickFix(deserialization);
			return new IMarkerResolution[]{quickFix};
		}
		return new IMarkerResolution[]{};
	}

	@Override
	public boolean hasResolutions(IMarker marker) {
		MarkerDeserialization deserialization = deserializeMarker(marker);
		List<EObject> elements = new ArrayList<EObject>();
		elements.addAll(deserialization.getElements());
		elements.addAll(deserialization.getBindings().values());
		Resource resource = deserialization.getResource();
		RoleMapping roleMapping = deserialization.getRoleMapping();
		if(elements.size() > 0 && roleMapping != null && resource != null){
			return true;
		}
		return false;
	}

	private MarkerDeserialization deserializeMarker(IMarker marker){
		MarkerDeserialization deserialization = new MarkerDeserialization();
		try {
			String roleMappingUri = (String) marker.getAttribute(IQualitySmellMarker.ROLEMAPPING);
			String elementUri = (String) marker.getAttribute(IMarker.LOCATION);
			String bindingsString = (String) marker.getAttribute(IQualitySmellMarker.BINDINGS);
			IResource iresource = marker.getResource();
			IFile file = (IFile) iresource.getAdapter(IFile.class);
			if(file != null && roleMappingUri != null && elementUri != null && bindingsString != null){
				ResourceSet rs = new ResourceSetImpl();
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = rs.getResource(uri, true);
				deserialization.setResource(resource);
				if(resource != null){
					determineBindings(deserialization, bindingsString, rs);
					uri = URI.createURI(roleMappingUri);
					Map<String, Map<String, RoleMapping>> roleMappingsMap = IRoleMappingRegistry.INSTANCE.getRoleMappingsMap();
					Map<String, RoleMapping> map = roleMappingsMap.values().iterator().next();
					RoleMapping firstRoleMapping = map.values().iterator().next();
					ResourceSet registryResourceSet = firstRoleMapping.eResource().getResourceSet();
					RoleMapping roleMapping = (RoleMapping) registryResourceSet.getEObject(uri, true);
					deserialization.setRoleMapping(roleMapping);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return deserialization;
	}

	private void determineBindings(MarkerDeserialization deserialization, String bindingsString, ResourceSet rs) {
		// found here: http://stackoverflow.com/questions/13948751/string-parse-error
		// 3rd answer
		String[] bindings = bindingsString.split("[" + IQualitySmellMarker.BINDINGS_SPLIT_STRING + "]");
		for (String binding : bindings) {
			if(binding != null && !"".equals(binding)){
				String[] parts = binding.split(IQualitySmellMarker.BINDINGS_NAME_SPLIT_STRING);
				String name = null;
				String bindingUri = null;
				if(parts.length == 2){
					name = parts[0];
					bindingUri = parts[1];
				} else {
					bindingUri = parts[0];
				}
				name = name.trim();
				bindingUri = bindingUri.trim();
				URI uri = URI.createURI(bindingUri);
				EObject element = rs.getEObject(uri, true);
				if(name == null){
					deserialization.getElements().add(element);
				} else {
					deserialization.getBindings().put(name, element);
				}
			}
		}
	}

	protected class MarkerDeserialization{
		private Resource resource;
		private List<EObject> elements = new ArrayList<EObject>();
		private Map<String, EObject> bindings = new HashMap<String, EObject>();
		private RoleMapping roleMapping;
		public Resource getResource() {
			return resource;
		}
		public void setResource(Resource resource) {
			this.resource = resource;
		}
		public List<EObject> getElements() {
			return elements;
		}
		public RoleMapping getRoleMapping() {
			return roleMapping;
		}
		public void setRoleMapping(RoleMapping roleMapping) {
			this.roleMapping = roleMapping;
		}
		public Map<String, EObject> getBindings() {
			return bindings;
		}
	}
}
