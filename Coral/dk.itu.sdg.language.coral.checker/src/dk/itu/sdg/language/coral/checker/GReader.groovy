package dk.itu.sdg.language.coral.checker;


import dk.itu.sdg.language.hbm.xml.mopp.HbmXmlResourceFactoryDelegator
import dk.itu.sdg.language.html.resource.html.mopp.HtmlResourceFactory;

import org.emftext.language.java.resource.java.mopp.JavaResourceFactory;
import org.emftext.language.javaproperties.resource.properties.mopp.PropertiesResourceFactory;
import de.devboost.smarttext.resource.stxt.mopp.StxtResourceFactory;
import dk.itu.sdg.language.bombXML.resource.xml.mopp.XmlResourceFactory

import org.eclipse.emf.common.util.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;



import org.antlr.runtime3_4_0.CommonTokenStream;

import antlr.TokenStream;

public class GReader {
	
	def private Resource emfResource = null
	def private Pair<Resource,Resource> emfResources = null
	
	def public IResource fstRes, sndRes
	
	public GReader(IResource file) {
		this.emfResource = readAsModel(file)
	}
	
	public GReader(IResource fstFile, IResource sndFile) {
		this.fstRes = fstFile
		this.sndRes = sndFile
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

		def String[] fileNameParts = file.getName().split("\\.")
		def String filetype = file.getFileExtension()
		
		if (fileNameParts.size() > 2) {
			filetype = file.getName().substring(file.getName().indexOf(".") + 1, file.getName().length())
		}
		
		def ResourceSet rs
		def Resource resource = null
		
		
		if (filetype.equals("html")) {
			
			def HtmlResourceFactory factory = new HtmlResourceFactory()

			rs = new ResourceSetImpl()
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory)
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true)			
			
		} else if (filetype.equals("java")) {
		
			def JavaResourceFactory factory = new JavaResourceFactory()

			rs = new ResourceSetImpl()
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory)
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true)
			
		} else if (filetype.equals("properties")) {
		
			def PropertiesResourceFactory factory = new PropertiesResourceFactory()

			rs = new ResourceSetImpl()
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory)
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true)
			
		} else if (filetype.equals("hbm.xml")) {
		
			def HbmXmlResourceFactoryDelegator factory = new HbmXmlResourceFactoryDelegator()
			
			rs = new ResourceSetImpl()
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("hbm.xml", factory)
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString())
			resource = rs.getResource(uri, true)
			
		} else if (filetype.equals("xml")) {
			
			def XmlResourceFactory factory = new XmlResourceFactory()
		
			rs = new ResourceSetImpl()
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory)
			def platFromResource = URI.createPlatformResourceURI(file.getFullPath().toString())
			resource = rs.getResource(platFromResource, true)	
			
			
//			def input = new File(file.getLocation().toString())
//			def content = input.text
//			
//			def DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			
//			def DocumentBuilder db = dbf.newDocumentBuilder();
//			def dom = db.parse(input);
//			
//			def Element docEle = dom.getDocumentElement()
//			//modification necessary for BOMBXML to work correctly
//			//it inserts special tags around text nodes
//			modifyTextNodes(docEle)
//
//			def OutputFormat format = new OutputFormat(dom);
//			format.setIndenting(true);
//
//			def XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(file.getLocation().toString()+"2")),format);
//			serializer.serialize(dom);
						

		
		} else if (filetype.equals("txt")) {
		
			def StxtResourceFactory factory = new StxtResourceFactory()
		
			rs = new ResourceSetImpl()
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(filetype, factory)
			resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString()), true)
			
		} else { 
			println ("Skipped resource: " + file.getFullPath().toString() + " of type " + filetype)
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
	
	public CommonTokenStream getText() {
		
		if (emfResource != null) {
			return emfResource.parser.input
		}
	}
	
	public Pair<CommonTokenStream, CommonTokenStream> getTexts() {
		
		if (emfResources != null) {
			return new Pair<TokenStream, TokenStream>(emfResources.fst.parser.input, emfResources.snd.parser.input);
		}
	}
}
