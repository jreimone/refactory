package dk.itu.sdg.language.coral.resource.coral.mopp

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.java.members.*
import html.*

/*
* This class gets regenerated on every build of a coral model
*/
class GGeneratedCheck {
	
	def void checkAllRules() {
		
	}
	
	def static checkConstraint(Resource fstModel, Resource sndModel) {
		def keys = fstModel.contents.get(0).eAllContents().findAll({type -> type instanceof Field})
		def refs = sndModel.contents.get(0).eAllContents().findAll({type -> type instanceof StringValParameter})
	
		println keys.size() + " " + refs.size()
		
		for (key in keys) {
			for (ref in refs) {
				println sameName(key,ref) + " " + key.name + " " + ref.value
			}
		}	
	}
	
	def static boolean sameName(Field key, StringValParameter ref) {
		
		if (key.name == ref.value) {
			return true	
		}
		return false
	}
}
