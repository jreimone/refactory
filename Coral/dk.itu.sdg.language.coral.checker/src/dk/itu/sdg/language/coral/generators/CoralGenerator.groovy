package dk.itu.sdg.language.coral.generators

import groovy.text.GStringTemplateEngine


import dk.itu.sdg.language.coral.DirectedRelation
import dk.itu.sdg.language.coral.FixedRelation
import dk.itu.sdg.language.coral.FixedRelationDirected
import dk.itu.sdg.language.coral.UndirectedRelation
import dk.itu.sdg.language.coral.checker.InferedCoral

class CoralGenerator extends AbstractGenerator {
	
	def private fileName = "Infered"
	def private nameExtension = ".coral"
	def private InferedCoral inferedCoral
	
	public void setData(InferedCoral inferedCoral) {
		this.inferedCoral = inferedCoral
	}
	
	public String generate() {
		
		this.generateLanguageTypes()
		this.generateRelations()
		this.save("Infered", nameExtension)
		return content
	}
	
	private String generateLanguageTypes() {
		def inferedLanguages = [languages:inferedCoral.languages]		
		
		def template = '''<% languages.each{lang -> %>
<%= lang.key  %> {
			<% lang.value.each{ type ->
					def end = type.toString().lastIndexOf(".") + 1%> 
  <%= type.toString().subSequence(end, type.toString().length()) %> is <%= type.toString() %>; <%}%>
} 
<%}%>
'''
//				def end = type.toString().lastIndexOf(".") + 1 
//		.subSequence(end, type.toString().length())
		
		def engine = new GStringTemplateEngine()
		def languageContent = engine.createTemplate(template).make(inferedLanguages)
		this.content = languageContent.toString()
		
		return this.content
	}
	
	
	private String generateRelations() {	
		this.content = this.content + this.generateFixedRelations()
		this.content = this.content + this.generateStringTransformRelations()	
	}
	
	private String generateFixedRelations() {
		
		def fixedRelations = [fixedRelations:inferedCoral.fixedRelations]
	
		def undirectedTemplate = 
'''
<% fixedRelations.each{rel -> 
	def fstTypeNameLong = rel.get("fstTypeName")
	def fstPart = fstTypeNameLong.toString().lastIndexOf(".") + 1
	def fstTypeName = fstTypeNameLong.subSequence(fstPart, fstTypeNameLong.toString().length())

	def sndTypeNameLong = rel.get("sndTypeName")
	def sndPart = sndTypeNameLong.toString().lastIndexOf(".") + 1
	def sndTypeName = sndTypeNameLong.subSequence(sndPart, sndTypeNameLong.toString().length())	%>
fixed: <%= fstTypeName %>::<%= rel.get("fstAttrName") %> in <%= rel.get("fstLang") %> <--> <%= sndTypeName %>::<%= rel.get("sndAttrName") %> in <%= rel.get("sndLang") %>
	is info display "Generated Undirected Fixed Relation"; <%}%>
'''
		
		def engine = new GStringTemplateEngine()
		def undirectedRelationsContent = engine.createTemplate(undirectedTemplate).make(fixedRelations)
		
		return undirectedRelationsContent.toString()
	}

	private String generateStringTransformRelations() {
		
		def index = 0
		def relations = [strTransRelations:inferedCoral.stringTransformRelations, index:index]

		def template = 
'''
<% strTransRelations.each{rel ->  
	def fstTypeNameLong = rel.get("fstTypeName")
	def fstPart = fstTypeNameLong.toString().lastIndexOf(".") + 1
	def fstTypeName = fstTypeNameLong.subSequence(fstPart, fstTypeNameLong.toString().length())

	def sndTypeNameLong = rel.get("sndTypeName")
	def sndPart = sndTypeNameLong.toString().lastIndexOf(".") + 1
	def sndTypeName = sndTypeNameLong.subSequence(sndPart, sndTypeNameLong.toString().length())	%>
string transformation: <%= fstTypeName %> in <%= rel.get("fstLang") %> <--> <%= sndTypeName %> in <%= rel.get("sndLang") %> with generatedDirectedStringTransform<%= index %>
	is info display "Undirected String Transformation Relation (#<%= index %>)"
	implementation "	if (leftHand.<%= rel.get("fstAttrName") %>.toLowerCase().contains(\'\'\'<%= rel.get("common") %>\'\'\'.toLowerCase()) && rightHand.<%= rel.get("sndAttrName") %>.toLowerCase().contains(\'\'\'<%= rel.get("common") %>\'\'\'.toLowerCase())) {
			return true	
		}";
	<% index++ }%>

'''
		
		def engine = new GStringTemplateEngine()
		def relationsContent = engine.createTemplate(template).make(relations)
		
		return relationsContent.toString()
	}
}
