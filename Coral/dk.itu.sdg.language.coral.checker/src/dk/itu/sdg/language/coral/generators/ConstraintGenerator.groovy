package dk.itu.sdg.language.coral.generators

import groovy.text.GStringTemplateEngine

import java.util.Set;

import org.eclipse.emf.ecore.EObject

import dk.itu.sdg.language.coral.DSRelation
import dk.itu.sdg.language.coral.DSRelationDirected
import dk.itu.sdg.language.coral.FixedRelation;
import dk.itu.sdg.language.coral.FixedRelationDirected;
import dk.itu.sdg.language.coral.LanguageTypes;
import dk.itu.sdg.language.coral.Relation;
import dk.itu.sdg.language.coral.StringTransformRelation
import dk.itu.sdg.language.coral.StringTransformRelationDirected
import dk.itu.sdg.language.coral.checker.CoralProperties
import dk.itu.sdg.language.coral.resource.coral.mopp.CoralResource

class ConstraintGenerator extends AbstractGenerator {

	def private nameExtension = "Constraints"
	def private Set typesToImport = [] as Set
	def int index = 0
	def String className
	
	
	def private Set<LanguageTypes> languageTypes = [] as Set
	def private Set<Relation> relations = [] as Set
	
	public ConstraintGenerator(CoralResource resource) {
		this.resource = resource
		
		def Iterator<EObject> iterator = resource.allContents
		while (iterator.hasNext()) {
			Object object = iterator.next()
			
			//collect all language types
			if (object instanceof LanguageTypes) {
				this.languageTypes.add(object)
			}
			
			//collect all relations
			if (object instanceof Relation) {
				this.relations.add(object)
			}
		}
		
		def String[] uriSegments = resource.getURI().trimFileExtension().segments()
		className = (uriSegments[uriSegments.length - 1] + nameExtension)
	}
	
	
	public String generate() {

		this.generateMethods()
		this.generateClass()
		this.save("", nameExtension)
		return content
	}
	
	private String generateClass() {
		
		def collectors
		
		def generatedMethods = [packageName:CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin"),className:className,constraints:content, langTypes:languageTypes]
		def template = '''package ${packageName}
<% langTypes.each{ langType -> %> 
//imports for language <%= langType.language %> elements <% 
	langType.types.each { importType -> %>
import <%= importType.type.getQualifiedName() %>; <%}%> <%}%>
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

class ${className} {
${constraints}	
}
		'''
		
		def engine = new GStringTemplateEngine()
		def classContent = engine.createTemplate(template).make(generatedMethods)
		this.content = classContent.toString()
		
		return this.content
	}
	
	private String generateMethods() {
		
		this.content = this.content + this.generateConstraintMethods()
	}
	
	private String generateConstraintMethods() {
		def fixedTemplate = '''
	def static Boolean ${methodName}(${fstTypeName} leftHand, ${sndTypeName} rightHand) {
			
		if (leftHand.${fstAttrName}.equals(rightHand.${sndAttrName})) {
			return true	
		}
		return false
	}
'''
	def stringTransformTemplate = '''
	def static Boolean ${methodName}(${fstTypeName} leftHand, ${sndTypeName} rightHand) {
	${implementation}
		return false
	}
	'''
	
	def dsrTemplate = '''
	def static Boolean ${methodName}(${fstTypeName} leftHand, ${sndTypeName} rightHand) {
		//TODO: implement me!!!
		return false
	}
'''
		def engine = new GStringTemplateEngine()
		def allMethods = ""
		def newMethod = ""
		
		def result
		
		for (relation in this.relations) {
			
			def fillIns = [:]
			
			if (relation instanceof FixedRelation) {
				def FixedRelation rel = (FixedRelation) relation
				
				if (rel.methodName == null) {
					rel.setMethodName("sameName")
				}
				
				fillIns = [methodName:rel.getMethodName(), fstTypeName:rel.getLeft().getType().getSimpleName(), fstAttrName:rel.getLeftAttributeName() , sndTypeName:rel.getRight().getType().getSimpleName(), sndAttrName:rel.getRightAttributeName()]
				
				result = engine.createTemplate(fixedTemplate).make(fillIns)
				
			} else if (relation instanceof FixedRelationDirected) {
				def FixedRelationDirected rel = (FixedRelationDirected) relation
				
				if (rel.methodName == null) {
					rel.setMethodName("sameName")
				}
				
				fillIns = [methodName:rel.getMethodName(), fstTypeName:rel.getKey().getType().getSimpleName(), fstAttrName:rel.getKeyAttributeName() , sndTypeName:rel.getRef().getType().getSimpleName(), sndAttrName:rel.getRefAttributeName()]
				
				result = engine.createTemplate(fixedTemplate).make(fillIns)
			
			
			} else if (relation instanceof StringTransformRelation) {
				def StringTransformRelation rel = (StringTransformRelation) relation;
				
				def stub
				if (rel.getImplementation() != null) {
					stub = rel.getImplementation()
				} else {
					stub = "//TODO: implement me!!!"
				}
				
				fillIns = [methodName:rel.getMethodName(), fstTypeName:rel.getLeft().getType().getSimpleName() , sndTypeName:rel.getRight().getType().getSimpleName(),
					implementation:stub]
				
				result = engine.createTemplate(stringTransformTemplate).make(fillIns)
				
			} else if (relation instanceof StringTransformRelationDirected) {
				def StringTransformRelationDirected rel = (StringTransformRelationDirected) relation;
				
				def stub
				if (rel.getImplementation() != null) {
					stub = rel.getImplementation()
				} else {
					stub = "//TODO: implement me!!!"
				}
				
				fillIns = [methodName:rel.getMethodName(), fstTypeName:rel.getKey().getType().getSimpleName() , sndTypeName:rel.getRef().getType().getSimpleName(),
					implementation:stub]
				
				result = engine.createTemplate(stringTransformTemplate).make(fillIns)
			
			} else if (relation instanceof DSRelation) {
				def DSRelation rel = (DSRelation) relation;
				
				fillIns = [methodName:rel.getMethodName(), fstTypeName:rel.getLeft().getType().getSimpleName() , sndTypeName:rel.getRight().getType().getSimpleName()]
				
				result = engine.createTemplate(dsrTemplate).make(fillIns)
			} else if (relation instanceof DSRelationDirected) {
				def DSRelationDirected rel = (DSRelationDirected) relation;
				
				fillIns = [methodName:rel.getMethodName(), fstTypeName:rel.getKey().getType().getSimpleName() , sndTypeName:rel.getRef().getType().getSimpleName()]
				
				result = engine.createTemplate(dsrTemplate).make(fillIns)
			}
			
			
			newMethod = newMethod + result.toString()
			
			index++
		}
			
		allMethods = allMethods + "\n" + newMethod
			
		return allMethods
	}
}
