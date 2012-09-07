package dk.itu.sdg.language.coral.checker;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import dk.itu.sdg.language.coral.resource.coral.mopp.CoralResourceFactory;

public class CoralReader {
	
	Resource emfResource = null;
 	
	public CoralReader() {
		readCoralModel();
	}

	private Resource readCoralModel() {
		
		CoralResourceFactory factory = new CoralResourceFactory();

		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("coral", factory);
		Resource resource = rs.getResource(URI.createFileURI("PATHFROMPROPERTIESFILE".toString()), true);
		
		return resource;
	}
	
	public Resource getEmfResource() {
		return emfResource;
	}

}
