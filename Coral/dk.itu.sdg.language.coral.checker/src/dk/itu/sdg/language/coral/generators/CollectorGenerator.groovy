package dk.itu.sdg.language.coral.generators

import org.eclipse.emf.ecore.EObject

import dk.itu.sdg.language.coral.DSRelation
import dk.itu.sdg.language.coral.DSRelationDirected
import dk.itu.sdg.language.coral.DirectedRelation;
import dk.itu.sdg.language.coral.FixedRelation;
import dk.itu.sdg.language.coral.FixedRelationDirected;
import dk.itu.sdg.language.coral.FreeRelation
import dk.itu.sdg.language.coral.FreeRelationDirected
import dk.itu.sdg.language.coral.LanguageTypes;
import dk.itu.sdg.language.coral.Relation;
import dk.itu.sdg.language.coral.StringTransformRelation
import dk.itu.sdg.language.coral.StringTransformRelationDirected
import dk.itu.sdg.language.coral.checker.CoralProperties
import dk.itu.sdg.language.coral.resource.coral.mopp.CoralResource
import groovy.text.GStringTemplateEngine


class CollectorGenerator extends AbstractGenerator {
	
	def private nameExtension = "Collector"
	def private Set typesToImport = [] as Set
	def int index = 0
	def String className
	
	def private Set<LanguageTypes> languageTypes = [] as Set
	def private Set<Relation> relations = [] as Set
	
	public CollectorGenerator(CoralResource resource) {
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
		className = (uriSegments[uriSegments.length - 1])
	}
	
	
	public String generate() {
		
		this.generateMethods()
		this.generateClass()
		this.save("", nameExtension)
		return content
	}
	
	private String generateClass() {
		
//		def generatedMethods = [fixedMethods:fixedMethodContents, stringTransformMethods:stringTransformMethodContents, types:typesToImport, fixedRelations:i, stringTransformRelations:j]
//		def classString = ""
		
		

		
		def generatedMethods = [packageName:CoralProperties.getCoralProperties().getProperty("pathToMainCoralPlugin"),className:(className+nameExtension),collectors:content, langTypes:languageTypes]
		def template = '''package ${packageName}
<% langTypes.each{ langType -> %> 
//imports for language <%= langType.language %> elements <% 
	langType.types.each { importType -> %>
import <%= importType.type.getQualifiedName() %> <%} }%>
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

import dk.itu.sdg.language.coral.checker.VisualCoralRelation
import dk.itu.sdg.language.coral.checker.VisualCoralRelationTypes

import dk.itu.sdg.coral.library.InferedConstraints

class ${className} {
${collectors}	
}
		'''
		
		def engine = new GStringTemplateEngine()
		def classContent = engine.createTemplate(template).make(generatedMethods)
		this.content = classContent.toString()
		
		return this.content
	}
	
	private String generateMethods() {
		
		this.content = this.content + this.generateCollectorMethods()	
	}
	
	private String generateCollectorMethods() {
		
		def templateDirected = '''
		public static Set<VisualCoralRelation> checkRelationCollector${index}(Resource fstModel, Resource sndModel) {
					
			def leftHands = []
			def rightHands = []
						
			def Iterator<EObject> i = fstModel.allContents
			while (i.hasNext()) {
				Object element = i.next();
							
				if (element instanceof <%= rel.getKey().getType().getSimpleName()%>) {
					leftHands.add(element)
				}
			}
						
			i = sndModel.allContents
			while (i.hasNext()) {
				Object element = i.next()
							
				if (element instanceof <%= rel.getRef().getType().getSimpleName()%>) {
					rightHands.add(element)
				}
			}
	
			//change order of left and right
			if(leftHands.size() == 0 && rightHands.size() == 0) {
				i = sndModel.allContents
				while (i.hasNext()) {
					Object element = i.next()
						
					if (element instanceof <%= rel.getKey().getType().getSimpleName()%>) {
						leftHands.add(element)
					}
				}
					
				i = fstModel.getAllContents();
				while (i.hasNext()) {
					Object element = i.next()
						
					if (element instanceof <%= rel.getRef().getType().getSimpleName()%>) {
						rightHands.add(element)
					}
				}
			}

			def Set<VisualCoralRelation> relations = [] as Set
					
			for (left in leftHands) {
				for (right in rightHands) {
					if (${className}Constraints.${methodName}(left,right)) {
						def VisualCoralRelation relation = new VisualCoralRelation(left, right, "${displayMessage}", "${severity}", ${type}, fstModel, sndModel, "${pathToConstraint}", "${className}Constraints", "${methodName}")
						relations.add(relation)
					}
				}
			}
			return relations
		}
		'''
		
		def templateUndirected = '''
		public static Set<VisualCoralRelation> checkRelationCollector${index}(Resource fstModel, Resource sndModel) {
					
			def leftHands = []
			def rightHands = []
						
			def Iterator<EObject> i = fstModel.allContents
			while (i.hasNext()) {
				Object element = i.next();
							
				if (element instanceof <%= rel.getLeft().getType().getSimpleName()%>) {
					leftHands.add(element)
				}
			}
						
			i = sndModel.allContents
			while (i.hasNext()) {
				Object element = i.next()
							
				if (element instanceof <%= rel.getRight().getType().getSimpleName()%>) {
					rightHands.add(element)
				}
			}
	
			//change order of left and right
			if(leftHands.size() == 0 && rightHands.size() == 0) {
				i = sndModel.allContents
				while (i.hasNext()) {
					Object element = i.next()
						
					if (element instanceof <%= rel.getLeft().getType().getSimpleName()%>) {
						leftHands.add(element)
					}
				}
					
				i = fstModel.getAllContents();
				while (i.hasNext()) {
					Object element = i.next()
						
					if (element instanceof <%= rel.getRight().getType().getSimpleName()%>) {
						rightHands.add(element)
					}
				}
			}

			def Set<VisualCoralRelation> relations = [] as Set
					
			for (left in leftHands) {
				for (right in rightHands) {
					if (${className}Constraints.${methodName}(left,right)) {
						def VisualCoralRelation relation = new VisualCoralRelation(left, right, "${displayMessage}", "${severity}", ${type}, fstModel, sndModel, "${pathToConstraint}", "${className}Constraints", "${methodName}")
						relations.add(relation)
					}
				}
			}	
			return relations
		}
		'''

		def engine = new GStringTemplateEngine()
		def allMethods = ""
		def newMethod = ""
				
		
		def index = 0
		
		for (relation in this.relations) {
			
			def fillIns = [:]
			
			if (relation instanceof FixedRelation) {
				def FixedRelation rel = (FixedRelation) relation
				
				def methodName = rel.getMethodName()
				if (methodName == null) {
					methodName = "sameName"
				}
				
				fillIns = [rel:rel, index:index, className:className, methodName:methodName, displayMessage:rel.getMyErrorType().getMessage(), 
					severity:rel.getMyErrorType().getSecondType(), type:"VisualCoralRelationTypes.UNDIRECTED_FIXED", pathToConstraint:resource.getURIFragment(rel)]
				
			} else if (relation instanceof FixedRelationDirected) {
				def FixedRelationDirected rel = (FixedRelationDirected) relation;
				
				def methodName = rel.getMethodName()
				if (methodName == null) {
					methodName = "sameName"
				}
				
				fillIns = [rel:rel, index:index, className:className, methodName:methodName, displayMessage:rel.getMyErrorType().getMessage(),
					severity:rel.getMyErrorType().getSecondType(), type:"VisualCoralRelationTypes.DIRECTED_FIXED", pathToConstraint:resource.getURIFragment(rel)]
	
			} else if (relation instanceof StringTransformRelation) {
				def StringTransformRelation rel = (StringTransformRelation) relation;
				
				fillIns = [rel:rel, index:index, className:className, methodName:rel.getMethodName(), displayMessage:rel.getMyErrorType().getMessage(),
					severity:rel.getMyErrorType().getSecondType(), type:"VisualCoralRelationTypes.UNDIRECTED_STRINGTRANSFORM", pathToConstraint:resource.getURIFragment(rel)]

				
			} else if (relation instanceof StringTransformRelationDirected) {
				def StringTransformRelationDirected rel = (StringTransformRelationDirected) relation;
				
				fillIns = [rel:rel, index:index, className:className, methodName:rel.getMethodName(), displayMessage:rel.getMyErrorType().getMessage(),
					severity:rel.getMyErrorType().getSecondType(), type:"VisualCoralRelationTypes.DIRECTED_STRINGTRANSFORM", pathToConstraint:resource.getURIFragment(rel)]

				
			} else if (relation instanceof FreeRelation) {
				def FreeRelation rel = (FreeRelation) relation;
				//TODO: hier muss was geschehen!!! 
				//der ganze if block im template muss dann weg
			} else if (relation instanceof FreeRelationDirected) {
				def FreeRelationDirected rel = (FreeRelationDirected) relation;
				//TODO: hier muss was geschehen!!!
				//der ganze if block im template muss dann weg
			} else if (relation instanceof DSRelation) {
				def DSRelation rel = (DSRelation) relation;
				
				fillIns = [rel:rel, index:index, className:className, methodName:rel.getMethodName(), displayMessage:rel.getMyErrorType().getMessage(),
					severity:rel.getMyErrorType().getSecondType(), type:"VisualCoralRelationTypes.UNDIRECTED_DSR", pathToConstraint:resource.getURIFragment(rel)]
				
			} else if (relation instanceof DSRelationDirected) {
				def DSRelationDirected rel = (DSRelationDirected) relation;
				
				fillIns = [rel:rel, index:index, className:className, methodName:rel.getMethodName(), displayMessage:rel.getMyErrorType().getMessage(),
					severity:rel.getMyErrorType().getSecondType(), type:"VisualCoralRelationTypes.DIRECTED_DSR", pathToConstraint:resource.getURIFragment(rel)]

			}
			
			def result
			if (relation instanceof DirectedRelation) {
				result = engine.createTemplate(templateDirected).make(fillIns)
			} else {
				result = engine.createTemplate(templateUndirected).make(fillIns)
			}
			
			
			newMethod = newMethod + result.toString()
			
			index++
		}
			
		allMethods = allMethods + "\n" + newMethod
			
		return allMethods
	}
}
