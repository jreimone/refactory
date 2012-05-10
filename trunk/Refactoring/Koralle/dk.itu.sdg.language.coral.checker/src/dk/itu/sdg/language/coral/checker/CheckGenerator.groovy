package dk.itu.sdg.language.coral.checker

import java.util.HashSet;

import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.osgi.framework.Bundle

import groovy.text.GStringTemplateEngine

class CheckGenerator {
	
	def private i = 0, j = 0
	def typesToImport = [] as Set
	def fixedMethodContents = ""
	def stringTransformMethodContents = ""
	def classString = ""
	
	public String generateClass() {
		
		def generatedMethods = [fixedMethods:fixedMethodContents, stringTransformMethods:stringTransformMethodContents, types:typesToImport, fixedRelations:i, stringTransformRelations:j]
		def classString = ""
		
		def template = '''
package dk.itu.sdg.language.coral.checker
		
<% types.each{ type -> %> import <%= type  %> 
<%} %>
 import org.eclipse.emf.ecore.EObject
 import org.eclipse.emf.ecore.resource.Resource

class GeneratedChecks {

	public static Set<CoralRelation> checkAllConstraints(Resource fstModel, Resource sndModel) {
		
		def relations = [] as Set<CoralRelation>
		<% if (fixedRelations > 0) { %>
			<% for (i in 0..fixedRelations - 1) { %>relations.addAll(checkFixedRelationConstraint${i}(fstModel, sndModel))
			<%} %>
		<%} %>
		<% if (stringTransformRelations > 0) { %>
			<% for (j in 0..stringTransformRelations - 1) { %>relations.addAll(checkStringTransformConstraint${j}(fstModel, sndModel))
			<%} %>
		<%} %>
		return relations
	}

${fixedMethods}

${stringTransformMethods}
}
		'''
		
		def engine = new GStringTemplateEngine()
		def classContent = engine.createTemplate(template).make(generatedMethods)
		classString = classContent.toString()
		
		return classString
	}
	
	public String generateFixedRelations(HashSet fixedRelations) {
		
		def template = '''
	public static Set<CoralRelation> checkFixedRelationConstraint${index}(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof ${fstTypeName}) {
				${fstTypeName} el = (${fstTypeName}) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof ${sndTypeName}) {
				${sndTypeName} el = (${sndTypeName}) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof ${fstTypeName}) {
					${fstTypeName} el = (${fstTypeName}) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof ${sndTypeName}) {
					${sndTypeName} el = (${sndTypeName}) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (sameName$index(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_FIXED, "checkFixedRelationConstraint${index}", fstModel, sndModel, left, right)
					relations.add(relation)
				}
			}
		}
			
		return relations
	}
	
	def static Boolean sameName$index(${fstTypeName} leftHand, ${sndTypeName} rightHand) {
			
		if (leftHand.${fstAttrName}.equals(rightHand.${sndAttrName})) {
			return true	
		}
		return false
	}
		'''

		def engine = new GStringTemplateEngine()
		def methods = ""
		
		for (fixedRelation in fixedRelations) {
			fixedRelation.put("index",i)
			
			def result = engine.createTemplate(template).make(fixedRelation)
			methods = methods + result.toString()
			
			typesToImport.add(fixedRelation.get("fstTypeName"))
			typesToImport.add(fixedRelation.get("sndTypeName"))
			i++	
		}		
		
		fixedMethodContents = fixedMethodContents + "\n" + methods
		
		return fixedMethodContents
	}


	public String generateStringTransformationRelations(HashSet stringTransformRelations) {
		
		def engine = new GStringTemplateEngine()
		def methods = ""
		
		def template = '''
	public static Set<CoralRelation> checkStringTransformConstraint${index}(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof ${fstTypeName}) {
				${fstTypeName} el = (${fstTypeName}) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof ${sndTypeName}) {
				${sndTypeName} el = (${sndTypeName}) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof ${fstTypeName}) {
					${fstTypeName} el = (${fstTypeName}) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof ${sndTypeName}) {
					${sndTypeName} el = (${sndTypeName}) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName${index}(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint${index}", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName${index}(${fstTypeName} leftHand, ${sndTypeName} rightHand) {						
		if (leftHand.${fstAttrName}.toLowerCase().contains("${common}".toLowerCase()) && rightHand.${sndAttrName}.toLowerCase().contains("${common}".toLowerCase())) {
			return true	
		}
		return false
	}'''
	
		for (stringTransformRelation in stringTransformRelations) {
			stringTransformRelation.put("index",j)
			
			if (stringTransformRelation.get("fstAttrName") != null && stringTransformRelation.get("fstAttrName") != null) {
				def result = engine.createTemplate(template).make(stringTransformRelation)
				methods = methods + result.toString()
				
				typesToImport.add(stringTransformRelation.get("fstTypeName"))
				typesToImport.add(stringTransformRelation.get("sndTypeName"))
				j++
			} else {
				//ignored mined relation since the mined attribute is null!
				//TODO: check where this comes from!
			}
		}
		
		stringTransformMethodContents = stringTransformMethodContents + "\n" + methods
		
		return stringTransformMethodContents
	}
	
	public void saveFile(String content) {
		
		def Bundle bundle = Activator.getDefault().getBundle();
		def IPath path = new Path("src-gen/dk/itu/sdg/language/coral/checker/GeneratedChecks.groovy");
		def URL groovyClassUrl = FileLocator.find(bundle, path, Collections.EMPTY_MAP);
		def File groovyClass = new File(FileLocator.toFileURL(groovyClassUrl).toURI());
		
		if (content == null) {
			groovyClass.write(classString)
		} else {
			groovyClass.write(content)
		}
	}
	
	public void compile() {
		
	}
}
