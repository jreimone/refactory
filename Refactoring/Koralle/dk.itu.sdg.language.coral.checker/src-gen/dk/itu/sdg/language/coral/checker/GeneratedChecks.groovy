
package dk.itu.sdg.language.coral.checker
		
 import org.emftext.language.java.references.impl.StringReferenceImpl 
 import html.impl.StringValParameterImpl 
 import org.emftext.language.java.imports.impl.ClassifierImportImpl 
 import org.emftext.language.java.types.impl.ClassifierReferenceImpl 
 import org.emftext.language.java.members.impl.FieldImpl 
 import org.emftext.language.java.references.impl.IdentifierReferenceImpl 
 import org.emftext.language.java.parameters.impl.OrdinaryParameterImpl 
 import org.emftext.language.java.variables.impl.LocalVariableImpl 
 import de.devboost.smarttext.impl.WordImpl 
 import org.emftext.language.java.classifiers.impl.ClassImpl 
 import org.emftext.language.java.references.impl.MethodCallImpl 
 import org.emftext.language.java.members.impl.ConstructorImpl 
 import html.impl.StringParameterImpl 

 import org.eclipse.emf.ecore.EObject
 import org.eclipse.emf.ecore.resource.Resource

class GeneratedChecks {

	public static Set<CoralRelation> checkAllConstraints(Resource fstModel, Resource sndModel) {
		
		def relations = [] as Set<CoralRelation>
		
			relations.addAll(checkFixedRelationConstraint0(fstModel, sndModel))
			relations.addAll(checkFixedRelationConstraint1(fstModel, sndModel))
			relations.addAll(checkFixedRelationConstraint2(fstModel, sndModel))
			
		
		
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
			relations.addAll(checkStringTransformConstraint14(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint15(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint16(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint17(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint18(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint19(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint20(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint21(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint22(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint23(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint24(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint25(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint26(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint27(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint28(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint29(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint30(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint31(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint32(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint33(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint34(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint35(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint36(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint37(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint38(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint39(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint40(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint41(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint42(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint43(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint44(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint45(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint46(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint47(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint48(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint49(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint50(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint51(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint52(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint53(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint54(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint55(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint56(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint57(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint58(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint59(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint60(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint61(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint62(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint63(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint64(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint65(fstModel, sndModel))
			relations.addAll(checkStringTransformConstraint66(fstModel, sndModel))
			
		
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
		



	public static Set<CoralRelation> checkFixedRelationConstraint1(Resource fstModel, Resource sndModel) {
		
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
				if (sameName1(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_FIXED, "checkFixedRelationConstraint1", fstModel, sndModel, left, right)
					relations.add(relation)
				}
			}
		}
			
		return relations
	}
	
	def static Boolean sameName1(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {
			
		if (leftHand.value.equals(rightHand.value)) {
			return true	
		}
		return false
	}
		



	public static Set<CoralRelation> checkFixedRelationConstraint2(Resource fstModel, Resource sndModel) {
		
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
				if (sameName2(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_FIXED, "checkFixedRelationConstraint2", fstModel, sndModel, left, right)
					relations.add(relation)
				}
			}
		}
			
		return relations
	}
	
	def static Boolean sameName2(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {
			
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
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
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
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
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
		if (leftHand.classifier.toLowerCase().contains('''ox'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ox'''.toLowerCase())) {
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
				if (stringTransformName3(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint3", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName3(org.emftext.language.java.members.impl.FieldImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''password'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''password'''.toLowerCase())) {
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
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
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
				if (stringTransformName5(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint5", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName5(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
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
				if (stringTransformName6(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint6", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName6(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
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
				if (stringTransformName7(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint7", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName7(org.emftext.language.java.members.impl.FieldImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
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
				if (stringTransformName8(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint8", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName8(org.emftext.language.java.references.impl.IdentifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
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
				if (stringTransformName9(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint9", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName9(org.emftext.language.java.parameters.impl.OrdinaryParameterImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
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
				if (stringTransformName10(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint10", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName10(org.emftext.language.java.variables.impl.LocalVariableImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
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
				if (stringTransformName11(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint11", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName11(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
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
				if (stringTransformName12(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint12", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName12(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
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
				if (stringTransformName13(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint13", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName13(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint14(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName14(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint14", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName14(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''ox'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ox'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint15(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName15(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint15", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName15(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''ox'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ox'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint16(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName16(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint16", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName16(org.emftext.language.java.members.impl.FieldImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''password'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''password'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint17(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName17(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint17", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName17(org.emftext.language.java.references.impl.IdentifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''password'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''password'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint18(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName18(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint18", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName18(org.emftext.language.java.parameters.impl.OrdinaryParameterImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''password'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''password'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint19(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName19(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint19", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName19(org.emftext.language.java.variables.impl.LocalVariableImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''password'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''password'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint20(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName20(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint20", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName20(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''password'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''password'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint21(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName21(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint21", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName21(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint22(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName22(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint22", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName22(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint23(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName23(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint23", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName23(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''class'''.toLowerCase()) && rightHand.name.toLowerCase().contains('''class'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint24(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName24(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint24", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName24(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''ink'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ink'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint25(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName25(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint25", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName25(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''ink'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ink'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint26(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName26(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint26", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName26(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''class'''.toLowerCase()) && rightHand.name.toLowerCase().contains('''class'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint27(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName27(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint27", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName27(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint28(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName28(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint28", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName28(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint29(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName29(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint29", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName29(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint30(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName30(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint30", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName30(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint31(Resource fstModel, Resource sndModel) {
		
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
				if (stringTransformName31(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint31", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName31(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, html.impl.StringValParameterImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''class'''.toLowerCase()) && rightHand.name.toLowerCase().contains('''class'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint32(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName32(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint32", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName32(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"title"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"title"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint33(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName33(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint33", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName33(org.emftext.language.java.members.impl.FieldImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint34(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName34(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint34", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName34(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"form"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"form"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint35(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName35(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint35", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName35(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint36(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName36(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint36", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName36(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint37(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName37(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint37", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName37(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"form"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"form"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint38(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName38(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint38", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName38(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''orm'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''orm'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint39(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.classifiers.impl.ClassImpl) {
				org.emftext.language.java.classifiers.impl.ClassImpl el = (org.emftext.language.java.classifiers.impl.ClassImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.classifiers.impl.ClassImpl) {
					org.emftext.language.java.classifiers.impl.ClassImpl el = (org.emftext.language.java.classifiers.impl.ClassImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName39(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint39", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName39(org.emftext.language.java.classifiers.impl.ClassImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.extends.toLowerCase().contains('''orm'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''orm'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint40(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName40(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint40", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName40(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint41(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName41(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint41", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName41(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint42(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName42(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint42", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName42(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"hide"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"hide"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint43(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName43(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint43", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName43(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"feedback"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"feedback"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint44(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.references.impl.MethodCallImpl) {
				org.emftext.language.java.references.impl.MethodCallImpl el = (org.emftext.language.java.references.impl.MethodCallImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.references.impl.MethodCallImpl) {
					org.emftext.language.java.references.impl.MethodCallImpl el = (org.emftext.language.java.references.impl.MethodCallImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName44(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint44", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName44(org.emftext.language.java.references.impl.MethodCallImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''nput'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''nput'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint45(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName45(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint45", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName45(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''orm'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''orm'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint46(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.classifiers.impl.ClassImpl) {
				org.emftext.language.java.classifiers.impl.ClassImpl el = (org.emftext.language.java.classifiers.impl.ClassImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.classifiers.impl.ClassImpl) {
					org.emftext.language.java.classifiers.impl.ClassImpl el = (org.emftext.language.java.classifiers.impl.ClassImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName46(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint46", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName46(org.emftext.language.java.classifiers.impl.ClassImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''orm'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''orm'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint47(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof org.emftext.language.java.members.impl.ConstructorImpl) {
				org.emftext.language.java.members.impl.ConstructorImpl el = (org.emftext.language.java.members.impl.ConstructorImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof org.emftext.language.java.members.impl.ConstructorImpl) {
					org.emftext.language.java.members.impl.ConstructorImpl el = (org.emftext.language.java.members.impl.ConstructorImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName47(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint47", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName47(org.emftext.language.java.members.impl.ConstructorImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''orm'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''orm'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint48(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName48(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint48", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName48(org.emftext.language.java.references.impl.IdentifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''orm'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''orm'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint49(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName49(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint49", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName49(org.emftext.language.java.members.impl.FieldImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint50(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName50(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint50", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName50(org.emftext.language.java.references.impl.IdentifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint51(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName51(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint51", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName51(org.emftext.language.java.parameters.impl.OrdinaryParameterImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint52(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName52(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint52", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName52(org.emftext.language.java.variables.impl.LocalVariableImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint53(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName53(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint53", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName53(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''loginName'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''loginName'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint54(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName54(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint54", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName54(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"jtrac"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"jtrac"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint55(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName55(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint55", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName55(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"title"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"title"'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint56(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName56(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint56", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName56(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"loginName"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"loginName"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint57(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName57(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint57", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName57(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''"form"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''"form"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint58(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName58(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint58", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName58(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint59(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName59(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint59", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName59(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''abel'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''abel'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint60(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName60(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint60", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName60(org.emftext.language.java.references.impl.StringReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''alt"'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''alt"'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint61(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName61(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint61", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName61(org.emftext.language.java.imports.impl.ClassifierImportImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.classifier.toLowerCase().contains('''ink'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ink'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint62(Resource fstModel, Resource sndModel) {
		
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
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
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
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName62(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint62", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName62(org.emftext.language.java.types.impl.ClassifierReferenceImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.target.toLowerCase().contains('''ink'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''ink'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint63(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName63(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint63", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName63(html.impl.StringValParameterImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''link'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''link'''.toLowerCase())) {
			return true	
		}
		return false
	}

	public static Set<CoralRelation> checkStringTransformConstraint64(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName64(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint64", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName64(html.impl.StringValParameterImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.value.toLowerCase().contains('''style'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''style'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint65(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof html.impl.StringValParameterImpl) {
				html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringValParameterImpl) {
					html.impl.StringValParameterImpl el = (html.impl.StringValParameterImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName65(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint65", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName65(html.impl.StringValParameterImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''style'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''style'''.toLowerCase())) {
			return true	
		}
		return false
	}
	public static Set<CoralRelation> checkStringTransformConstraint66(Resource fstModel, Resource sndModel) {
		
		def leftHands = []
		def rightHands = []
			
		def Iterator<EObject> i = fstModel.getAllContents();
		while (i.hasNext()) {
			Object element = i.next();
				
			if (element instanceof html.impl.StringParameterImpl) {
				html.impl.StringParameterImpl el = (html.impl.StringParameterImpl) element
				leftHands.add(el)
			}
		}
			
		i = sndModel.getAllContents()
		while (i.hasNext()) {
			Object element = i.next()
				
			if (element instanceof de.devboost.smarttext.impl.WordImpl) {
				de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
				rightHands.add(el)
			}
		}
			
					
		//change order of left and right
		if(leftHands.size() == 0 && rightHands.size() == 0) {
			i = sndModel.getAllContents()
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof html.impl.StringParameterImpl) {
					html.impl.StringParameterImpl el = (html.impl.StringParameterImpl) element
					leftHands.add(el)
				}
			}
				
			i = fstModel.getAllContents();
			while (i.hasNext()) {
				Object element = i.next()
					
				if (element instanceof de.devboost.smarttext.impl.WordImpl) {
					de.devboost.smarttext.impl.WordImpl el = (de.devboost.smarttext.impl.WordImpl) element
					rightHands.add(el)
				}
			}
		}
	
		def relations = [] as Set<CoralRelation>
			
		for (left in leftHands) {
			for (right in rightHands) {
				if (stringTransformName66(left,right)) {
					def CoralRelation relation = new CoralRelation(left, right, CoralRelation.GENERATED_STRINGTRANSFORM, "checkStringTransformConstraint66", fstModel, sndModel, left, right)
					relations.add(relation)					
				}
			}
		}
			
		return relations
	}
	
	def static Boolean stringTransformName66(html.impl.StringParameterImpl leftHand, de.devboost.smarttext.impl.WordImpl rightHand) {						
		if (leftHand.name.toLowerCase().contains('''t'''.toLowerCase()) && rightHand.value.toLowerCase().contains('''t'''.toLowerCase())) {
			return true	
		}
		return false
	}

}
		