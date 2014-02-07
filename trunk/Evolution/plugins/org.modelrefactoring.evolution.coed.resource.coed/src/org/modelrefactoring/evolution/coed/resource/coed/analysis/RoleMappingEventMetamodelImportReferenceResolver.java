/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.modelrefactoring.evolution.coed.MetamodelImport;
import org.modelrefactoring.evolution.coed.RoleMappingEvent;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver;

public class RoleMappingEventMetamodelImportReferenceResolver implements ICoedReferenceResolver<RoleMappingEvent, MetamodelImport> {
	
	public void resolve(String identifier, RoleMappingEvent container, EReference reference, int position, boolean resolveFuzzy, final ICoedReferenceResolveResult<MetamodelImport> result) {
		List<MetamodelImport> imports = container.getCoED().getImports();
		for (MetamodelImport metamodelImport : imports) {
			if(resolveFuzzy){
				result.addMapping(metamodelImport.getShortcut(), metamodelImport);
			} else {
				if(identifier.equals(metamodelImport.getShortcut())){
					result.addMapping(identifier, metamodelImport);
					return;
				}
			}
		}
		result.setErrorMessage("Metamodel shortcut '" + identifier + "' not defined");
	}
	
	public String deResolve(MetamodelImport element, RoleMappingEvent container, EReference reference) {
		return element.getShortcut();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
