package dk.itu.sdg.language.coral.generators

import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Platform
import org.osgi.framework.Bundle

import dk.itu.sdg.language.coral.checker.CoralProperties
import dk.itu.sdg.language.coral.resource.coral.mopp.CoralResource

abstract class AbstractGenerator {
	
	def CoralResource resource
	def String content = ""
	

	
	protected void save(String fileName, String nameExtension) {
		
		//build file name
		def String pathToMainCoralPlugin = CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin")
		def Bundle mainCoralBundle = Platform.getBundle(pathToMainCoralPlugin)
		def IProject mainCoralProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pathToMainCoralPlugin)
		def String pluginPath = mainCoralProject.getLocation().toOSString()
		def File generatedGroovyClass
		
		if (resource != null) {
			def String[] uriSegments = resource.getURI().trimFileExtension().segments()
			
			if (fileName.equals("")) {
				fileName = uriSegments[uriSegments.length - 1]
			}
			
			generatedGroovyClass = new File(pluginPath + "/src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/") + "/" + fileName + nameExtension + ".groovy")
			println (pluginPath + "/src-gen/" + pathToMainCoralPlugin.replaceAll("\\.", "/") + "/" + fileName + nameExtension)
		} else {
			generatedGroovyClass = new File(pluginPath + "/src-gen/" + "/" + fileName + nameExtension)
		}
		
		generatedGroovyClass.write(content)
	}
	
	abstract public String generate()
}
