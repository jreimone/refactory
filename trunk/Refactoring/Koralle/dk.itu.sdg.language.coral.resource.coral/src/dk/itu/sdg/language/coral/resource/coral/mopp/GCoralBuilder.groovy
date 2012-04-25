package dk.itu.sdg.language.coral.resource.coral.mopp

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;

import dk.itu.sdg.language.coral.Relation;
import dk.itu.sdg.language.coral.impl.CoralImpl;
import dk.itu.sdg.language.coral.resource.coral.ICoralBuilder

import groovy.text.GStringTemplateEngine

class GCoralBuilder implements ICoralBuilder {

	@Override
	def boolean isBuildingNeeded(URI uri) {
		return true;
	}

	@Override
	def IStatus build(CoralResource resource, IProgressMonitor monitor) {
		
		
		def relationRules = resource.contents.get(0).relations
		
		println relationRules.size
		
		for ( rule in relationRules ) {
			
			println rule.methodName
			println rule.key.name
			println rule.ref.name
		}
		
		def binding = ["firstname":"Sam", "lastname":"Pullara", "city":"San Francisco", "month":"December", "signed":"Groovy-Dev"]
		
		//TODO: make this string portable!!!
		def file = new File('/Users/ropf/Documents/eclipse/indigo_dresden/dk.itu.sdg.language.coral.resource.coral/src/dk/itu/sdg/language/coral/resource/coral/mopp/Generator.template')
		def engine = new GStringTemplateEngine()
		def template = engine.createTemplate(file).make([greeting: 'Welcome'])
		println template.toString()
				
//	   def tpl = '''
//	   $greeting
//	   <% for (i in 1..10) { %>
//	   Hello <%= i %> <% if (i % 2 == 0) { %> (even) <% } %>
//	   <% } %>
//	   '''
//		
//	   def e = new GStringTemplateEngine()
//	   e.createTemplate(tpl).make([greeting: 'Welcome'])
//	   println tpl.toString()
	   
	   
		return org.eclipse.core.runtime.Status.OK_STATUS
	}


}
