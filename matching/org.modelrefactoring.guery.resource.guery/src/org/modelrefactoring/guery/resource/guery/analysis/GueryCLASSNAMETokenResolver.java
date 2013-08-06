/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.analysis;

import nz.ac.massey.cs.guery.Processor;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult;

public class GueryCLASSNAMETokenResolver implements org.modelrefactoring.guery.resource.guery.IGueryTokenResolver {

	private org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultTokenResolver defaultTokenResolver = new org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultTokenResolver(true);

	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if(value instanceof Class<?>){
			return ((Class<?>) value).getName();
		}
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		return defaultTokenResolver.deResolve(value, feature, container, null, null, null);
	}

	public void resolve(String lexem, EStructuralFeature feature, IGueryTokenResolveResult result) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		try {
			Class<?> clazz = classLoader.loadClass(lexem);
			if(Processor.class.isAssignableFrom(clazz)){
				result.setResolvedToken(clazz);
			} else {
				result.setErrorMessage("Class '" + lexem + "' could be loaded but doesn't implement " + Processor.class.getCanonicalName());
			}
		} catch (ClassNotFoundException e) {			
			result.setErrorMessage("Class '" + lexem + "' couldn't be loaded");
			//	By default token resolving is delegated to the DefaultTokenResolver.
//			defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
		}
	}

	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}

}
