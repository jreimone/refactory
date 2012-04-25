package dk.itu.sdg.language.coral.checker;

import html.resource.html.mopp.HtmlResourceFactory;
import org.emftext.language.java.resource.java.mopp.JavaResourceFactory;
import org.emftext.language.javaproperties.resource.properties.mopp.PropertiesResourceFactory;

import org.eclipse.emf.common.util.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class Reader {
	
	private Resource emfResource = null;
	private Pair<Resource,Resource> emfResources = null;
	
	public Reader() {
	}
	
	public Reader(IResource file) {
		this.emfResource = readAsModel(file);
	}
	
	public Reader(IResource fstFile, IResource sndFile) {
		this.emfResources = readAsModels(fstFile, sndFile);
	}
	
	/**
	 * TODO: This is preliminary!!!
	 * there should be a better handling of the registered languages based on the coral model
	 * 
	 * @param file the file as eclipse resource
	 * @return 
	 */
	private Resource readAsModel(IResource file) {

		String filetype = file.getFileExtension();
		ResourceSet rs;
		Resource resource = null;
		
		
		if (filetype.equals("html")) {
			
			HtmlResourceFactory factory = new HtmlResourceFactory();

			rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory);
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true);
//			resource = rs.getResource(URI.createFileURI(file.getFullPath().toString()), true);
			
		} else if (filetype.equals("java")) {
			JavaResourceFactory factory = new JavaResourceFactory();

			rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory);
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true);
//			resource = rs.getResource(URI.createFileURI(file.getFullPath().toString()), true);
			
		} else if (filetype.equals("properties")) {
			PropertiesResourceFactory factory = new PropertiesResourceFactory();

			rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory);
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true);
//			resource = rs.getResource(URI.createFileURI(file.getFullPath().toString()), true);
			
		} else if (filetype.equals("xml")) {
			
		}
		
		
		return resource;
	}
	
	private Pair<Resource,Resource> readAsModels(IResource fstFile, IResource sndFile) {
				
		Resource fstResource = readAsModel(fstFile);
		Resource sndResource = readAsModel(sndFile);
		
		return new Pair<Resource, Resource>(fstResource, sndResource);
	}
	
	public Resource getEmfResource() {
		return emfResource;
	}
	
	public Pair<Resource,Resource> getEmfResources() {
		return emfResources;
	}
}
