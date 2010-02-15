/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class RelationMappingReferencesReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.RelationMapping, org.eclipse.emf.ecore.EReference> {

	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.RelationMapping, org.eclipse.emf.ecore.EReference> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.RelationMapping, org.eclipse.emf.ecore.EReference>();

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.RelationMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		EObject parent = container.eContainer().eContainer().eContainer();
		if(!(parent instanceof RoleMappingModel)){
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		RoleMappingModel mappingModel = (RoleMappingModel) parent;
		EPackage metaModel = mappingModel.getTargetMetamodel();
		if(metaModel != null && !metaModel.eIsProxy()){
			EList<EReference> references = getObjectsByType(metaModel.eAllContents(), EReference.class);
			for (EReference eReference : references) {
				String name = eReference.getName().trim();
				if(identifier.trim().equals(name)){
					result.addMapping(identifier, eReference);
					return;
				}
			}
			result.setErrorMessage("No EReference with name '" + identifier + "' exists");
		} else {
			result.setErrorMessage("Could not resolve Role Mapping Model '" + mappingModel.getName() + "'");
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends EObject> EList<T> getObjectsByType(Iterator<EObject> it, Class<T> type){
		EList<T> list = new BasicEList<T>();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if(type.isInstance(eObject)){
				list.add( (T) eObject);
			}
		}
		return list;
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EReference element, org.emftext.language.refactoring.rolemapping.RelationMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
