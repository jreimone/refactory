/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver;

public class ConcreteMappingPackagesOfMetaclassReferenceResolver implements IRolemappingReferenceResolver<ConcreteMapping, EPackage> {

	public void resolve(String identifier, ConcreteMapping concreteMapping, EReference reference, int position, boolean resolveFuzzy, final IRolemappingReferenceResolveResult<EPackage> result) {
		EObject parent = EcoreUtil.getRootContainer(concreteMapping, true);
		// new
		if(parent instanceof RoleMappingModel){
			RoleMappingModel mappingModel = (RoleMappingModel) parent;
			EPackage targetMetamodel = mappingModel.getTargetMetamodel();
			int index = -1;
			List<EPackage> packagesOfMetaclass = concreteMapping.getPackagesOfMetaclass();
			for (int i = 0; i < packagesOfMetaclass.size(); i++) {
				EPackage epackage = packagesOfMetaclass.get(i);
				if(epackage.eIsProxy()){
					index = i;
					break;
				}
			}
			Map<String, EPackage> validPackages = null;
			if(index == -1 || index == 0){
				validPackages = getValidPackages(mappingModel.getImports(), targetMetamodel);
			} else {
				EPackage contextPackage = packagesOfMetaclass.get(index - 1);
				validPackages = getValidPackages(null, contextPackage);
			}
			evaluatePackageName(identifier, resolveFuzzy, result, validPackages);
			return;
		} else {
			result.setErrorMessage("Root container of this model is not a " + RoleMappingModel.class.getSimpleName());
			return;
		}
	}

	protected void evaluatePackageName(String identifier, boolean resolveFuzzy, IRolemappingReferenceResolveResult<EPackage> result, Map<String, EPackage> validPackages) {
		if(resolveFuzzy){
			for (String packageName : validPackages.keySet()) {
				result.addMapping(packageName, validPackages.get(packageName));
			}
		} else {
			EPackage ePackage = validPackages.get(identifier);
			if(ePackage != null){
				result.addMapping(identifier, ePackage);
			} else {
				result.setErrorMessage("No package '" + identifier + "' available");
			}
		}
	}

	private Map<String, EPackage> getValidPackages(List<EPackage> additionalPackages, EPackage contextPackage) {
		Map<String, EPackage> validPackages = new HashMap<String, EPackage>();
		if(additionalPackages != null){
			validPackages.put(contextPackage.getName(), contextPackage);
			for (EPackage ePackage : additionalPackages) {
				if(!ePackage.eIsProxy()){
					validPackages.put(ePackage.getName(), ePackage);
				}
			}
		} else {
			List<EPackage> subpackages = contextPackage.getESubpackages();
			for (EPackage subPackage : subpackages) {
				if(!subPackage.eIsProxy()){
					validPackages.put(subPackage.getName(), subPackage);
				}
			}
		}
		return validPackages;
	}

	public String deResolve(EPackage element, ConcreteMapping container, EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}

}
