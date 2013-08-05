/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class ConcreteMappingPackagesOfMetaclassReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EPackage> {
	
	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EPackage> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(String identifier, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		EObject parent = container.eContainer().eContainer();
		if(parent instanceof RoleMappingModel){
			RoleMappingModel roleMappingModel = (RoleMappingModel) parent;
			EPackage targetMetamodel = roleMappingModel.getTargetMetamodel();
			List<EPackage> imports = roleMappingModel.getImports();
			List<EPackage> validMetamodels = new ArrayList<EPackage>();
			List<EPackage> packagesOfMetaclass = new ArrayList<EPackage>(container.getPackagesOfMetaclass());
			if(packagesOfMetaclass.size() == 0){
				validMetamodels.add(targetMetamodel);
				validMetamodels.addAll(imports);
			} else {
				EPackage lastMetamodel = packagesOfMetaclass.get(packagesOfMetaclass.size() - 1);
				if(lastMetamodel.eIsProxy()){ // this is the metamodel for the metaclass intended to resolve here - so it must be a proxy
					if(packagesOfMetaclass.size() > 1){
						lastMetamodel = packagesOfMetaclass.get(packagesOfMetaclass.size() - 2);
						validMetamodels.addAll(lastMetamodel.getESubpackages());
					} else {
						validMetamodels.add(targetMetamodel);
						validMetamodels.addAll(targetMetamodel.getESubpackages());
						validMetamodels.addAll(imports);
					}
				}
			}
			if(resolveFuzzy){
				for (EPackage validMetamodel : validMetamodels) {
					result.addMapping(validMetamodel.getName(), validMetamodel);
				}
			} else {
				for (EPackage validMetamodel : validMetamodels) {
					if(validMetamodel.getName().equals(identifier)){
						result.addMapping(identifier, validMetamodel);
						return;
					}
				}
			}
			result.setErrorMessage("No metamodel found for '" + identifier + "'");
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EPackage element, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
//		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
