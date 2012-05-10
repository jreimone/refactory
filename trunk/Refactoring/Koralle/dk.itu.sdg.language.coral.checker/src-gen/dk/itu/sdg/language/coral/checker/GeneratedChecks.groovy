
package dk.itu.sdg.language.coral.checker
		
 import org.emftext.language.java.references.impl.StringReferenceImpl 
 import html.impl.StringValParameterImpl 
 import org.emftext.language.java.imports.impl.ClassifierImportImpl 
 import org.emftext.language.java.types.impl.ClassifierReferenceImpl 
 import org.emftext.language.java.members.impl.FieldImpl 
 import org.emftext.language.java.references.impl.IdentifierReferenceImpl 
 import org.emftext.language.java.parameters.impl.OrdinaryParameterImpl 
 import org.emftext.language.java.variables.impl.LocalVariableImpl 

 import org.eclipse.emf.ecore.EObject
 import org.eclipse.emf.ecore.resource.Resource

class GeneratedChecks {

	public static Set<CoralRelation> checkAllConstraints(Resource fstModel, Resource sndModel) {
		
		def relations = [] as Set<CoralRelation>
		
			relations.addAll(checkFixedRelationConstraint0(fstModel, sndModel))
			
		
		
			relations.addAll(checkStringTransformConstraint0(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint1(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint2(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint3(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint4(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint5(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint6(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint7(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint8(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint9(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint10(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint11(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint12(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint13(fstModel, sndModel))
			
		
		return relations
	}



	public static Set<CoralRelation> checkFixedRelationConstraint0(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
				org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
					org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (sameName0(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_FIXED, "checkFixedRelationConstraint0", fstModel, sndModel, left, right)
					relations.add(relation)
				}
			}
		}
			
		return relations
	}
	
	def static Boolean sameName0(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {
			
		if (leftHand.value.equals(rightHand.value)) {
			return true	
		}
		return false
	}
		



	public static Set<CoralRelation> checkStringTransformConstraint0(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.imports.impl.ClassifierImportImpl) {
				org.emftext.language.java.imports.impl.ClassifierImportImpl el = (org.emftext.language.java.imports.impl.ClassifierImportImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.imports.impl.ClassifierImportImpl) {
					org.emftext.language.java.imports.impl.ClassifierImportImpl el = (org.emftext.language.java.imports.impl.ClassifierImportImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName0(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint0", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName0(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains("abel".toLowerCase()) && rightHand.value.toLowerCase().contains("abel".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint1(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.types.impl.ClassifierReferenceImpl) {
				org.emftext.language.java.types.impl.ClassifierReferenceImpl el = (org.emftext.language.java.types.impl.ClassifierReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.types.impl.ClassifierReferenceImpl) {
					org.emftext.language.java.types.impl.ClassifierReferenceImpl el = (org.emftext.language.java.types.impl.ClassifierReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName1(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint1", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName1(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains("abel".toLowerCase()) && rightHand.value.toLowerCase().contains("abel".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint2(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.imports.impl.ClassifierImportImpl) {
				org.emftext.language.java.imports.impl.ClassifierImportImpl el = (org.emftext.language.java.imports.impl.ClassifierImportImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.imports.impl.ClassifierImportImpl) {
					org.emftext.language.java.imports.impl.ClassifierImportImpl el = (org.emftext.language.java.imports.impl.ClassifierImportImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName2(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint2", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName2(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains("ox".toLowerCase()) && rightHand.value.toLowerCase().contains("ox".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint3(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.types.impl.ClassifierReferenceImpl) {
				org.emftext.language.java.types.impl.ClassifierReferenceImpl el = (org.emftext.language.java.types.impl.ClassifierReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.types.impl.ClassifierReferenceImpl) {
					org.emftext.language.java.types.impl.ClassifierReferenceImpl el = (org.emftext.language.java.types.impl.ClassifierReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName3(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint3", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName3(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains("ox".toLowerCase()) && rightHand.value.toLowerCase().contains("ox".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint4(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.members.impl.FieldImpl) {
				org.emftext.language.java.members.impl.FieldImpl el = (org.emftext.language.java.members.impl.FieldImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.members.impl.FieldImpl) {
					org.emftext.language.java.members.impl.FieldImpl el = (org.emftext.language.java.members.impl.FieldImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName4(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint4", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName4(org.emftext.language.java.members.impl.FieldImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains("loginName".toLowerCase()) && rightHand.value.toLowerCase().contains("loginName".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint5(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.references.impl.IdentifierReferenceImpl) {
				org.emftext.language.java.references.impl.IdentifierReferenceImpl el = (org.emftext.language.java.references.impl.IdentifierReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.references.impl.IdentifierReferenceImpl) {
					org.emftext.language.java.references.impl.IdentifierReferenceImpl el = (org.emftext.language.java.references.impl.IdentifierReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName5(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint5", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName5(org.emftext.language.java.references.impl.IdentifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains("loginName".toLowerCase()) && rightHand.value.toLowerCase().contains("loginName".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint6(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) {
				org.emftext.language.java.parameters.impl.OrdinaryParameterImpl el = (org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) {
					org.emftext.language.java.parameters.impl.OrdinaryParameterImpl el = (org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName6(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint6", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName6(org.emftext.language.java.parameters.impl.OrdinaryParameterImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains("loginName".toLowerCase()) && rightHand.value.toLowerCase().contains("loginName".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint7(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.variables.impl.LocalVariableImpl) {
				org.emftext.language.java.variables.impl.LocalVariableImpl el = (org.emftext.language.java.variables.impl.LocalVariableImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.variables.impl.LocalVariableImpl) {
					org.emftext.language.java.variables.impl.LocalVariableImpl el = (org.emftext.language.java.variables.impl.LocalVariableImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName7(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint7", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName7(org.emftext.language.java.variables.impl.LocalVariableImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains("loginName".toLowerCase()) && rightHand.value.toLowerCase().contains("loginName".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint8(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
				org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
					org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName8(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint8", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName8(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains("loginName".toLowerCase()) && rightHand.value.toLowerCase().contains("loginName".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint9(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.members.impl.FieldImpl) {
				org.emftext.language.java.members.impl.FieldImpl el = (org.emftext.language.java.members.impl.FieldImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.members.impl.FieldImpl) {
					org.emftext.language.java.members.impl.FieldImpl el = (org.emftext.language.java.members.impl.FieldImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName9(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint9", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName9(org.emftext.language.java.members.impl.FieldImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains("password".toLowerCase()) && rightHand.value.toLowerCase().contains("password".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint10(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.references.impl.IdentifierReferenceImpl) {
				org.emftext.language.java.references.impl.IdentifierReferenceImpl el = (org.emftext.language.java.references.impl.IdentifierReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.references.impl.IdentifierReferenceImpl) {
					org.emftext.language.java.references.impl.IdentifierReferenceImpl el = (org.emftext.language.java.references.impl.IdentifierReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName10(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint10", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName10(org.emftext.language.java.references.impl.IdentifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains("password".toLowerCase()) && rightHand.value.toLowerCase().contains("password".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint11(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) {
				org.emftext.language.java.parameters.impl.OrdinaryParameterImpl el = (org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) {
					org.emftext.language.java.parameters.impl.OrdinaryParameterImpl el = (org.emftext.language.java.parameters.impl.OrdinaryParameterImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName11(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint11", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName11(org.emftext.language.java.parameters.impl.OrdinaryParameterImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains("password".toLowerCase()) && rightHand.value.toLowerCase().contains("password".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint12(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.variables.impl.LocalVariableImpl) {
				org.emftext.language.java.variables.impl.LocalVariableImpl el = (org.emftext.language.java.variables.impl.LocalVariableImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.variables.impl.LocalVariableImpl) {
					org.emftext.language.java.variables.impl.LocalVariableImpl el = (org.emftext.language.java.variables.impl.LocalVariableImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName12(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint12", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName12(org.emftext.language.java.variables.impl.LocalVariableImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains("password".toLowerCase()) && rightHand.value.toLowerCase().contains("password".toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint13(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
				org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.references.impl.StringReferenceImpl) {
					org.emftext.language.java.references.impl.StringReferenceImpl el = (org.emftext.language.java.references.impl.StringReferenceImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName13(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint13", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName13(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains("password".toLowerCase()) && rightHand.value.toLowerCase().contains("password".toLowerCase())) {
			return true	
		}
		return false
	}
}
		