/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;
import org.emftext.refactoring.util.ModelUtil;

public class ReferenceMetaClassPairMetaClassReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair, org.eclipse.emf.ecore.EClass> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EObject parent = container.eContainer().eContainer();
		if(parent instanceof ConcreteMapping){
			ConcreteMapping concreteMapping = (ConcreteMapping) parent;
			EClass metaclass = concreteMapping.getMetaclass();
			CollaborationMapping relationMapping = (CollaborationMapping) container.eContainer();
			
			List<ReferenceMetaClassPair> referencePairs = relationMapping.getReferenceMetaClassPair();
			List<ReferenceMetaClassPair> tempPairList = new LinkedList<ReferenceMetaClassPair>();
			for (ReferenceMetaClassPair referenceMetaClassPair : referencePairs) {
				tempPairList.add(referenceMetaClassPair);
			}
			int index = tempPairList.indexOf(container);
			int size = tempPairList.size();
			for (int i = index + 1; i < size; i++) {
				tempPairList.remove(index + 1);
			}
			EClass matchedClass = getEClass(identifier, metaclass, tempPairList);
			if(matchedClass != null){
				result.addMapping(identifier, matchedClass);
				if(resolveFuzzy){
					return;
				}
			} else {
				String referenceName = referencePairs.get(index).getReference().getName();
				result.setErrorMessage("Metaclass '" + identifier + "' is not reachable from reference '" + referenceName + "'");
			}
		}
	}
	
	private EClass getEClass(String targetIdentifier, EClass metaClass, List<ReferenceMetaClassPair> pairs){
		ReferenceMetaClassPair pair = pairs.get(0);
		pairs.remove(pair);
		if(pairs.size() == 0){
			EReference containingReference = pair.getReference();
			List<EReference> references = metaClass.getEAllReferences();
			for (EReference eReference : references) {
				if(eReference.equals(containingReference)){
					EClass containedClass = eReference.getEReferenceType();
					if(containedClass.getName().equals(targetIdentifier)){
						pair.setMetaClass(containedClass);
						return containedClass;
					}
					List<EClass> subClasses = ModelUtil.getAllSubTypes(containedClass);
					for (EClass subClass : subClasses) {
						if(subClass.getName().equals(targetIdentifier)){
							pair.setMetaClass(subClass);
							return subClass;
						}
					}
				}
			}
		} else {
			EClass stepClass = pair.getMetaClass();
			return getEClass(targetIdentifier, stepClass, pairs);
		}
		return null;
	}
	
//	private EClass getEClassFromEPackage(EPackage epackage, String[] identifierPath, boolean resolveFuzzy){
//		if(identifierPath.length == 1){
//			String className = identifierPath[0];
//			List<EClassifier> eClassifiers = epackage.getEClassifiers();
//			for (EClassifier eClassifier : eClassifiers) {
//				if (eClassifier.getName().equals(className) || resolveFuzzy) {
//					if (eClassifier instanceof EClass) {
//						return (EClass) eClassifier;
//					}
//				}
//			}
//		} else {
//			String identifier = identifierPath[0];
//			identifierPath = removeFirst(identifierPath);
//			List<EPackage> subPackages = epackage.getESubpackages();
//			for (EPackage subpackage : subPackages) {
//				if(subpackage.getName().equals(identifier)){
//					return getEClassFromEPackage(subpackage, identifierPath, resolveFuzzy);
//				}
//			}
//		}
//		return null;
//	}
	
//	private static String[] removeFirst(String[] path) {
//		List<String> temp = new ArrayList<String>();
//		for (int i = 1; i < path.length; i++) {
//			temp.add(path[i]);
//		}
//		return temp.toArray(new String[0]);
//	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
//		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
