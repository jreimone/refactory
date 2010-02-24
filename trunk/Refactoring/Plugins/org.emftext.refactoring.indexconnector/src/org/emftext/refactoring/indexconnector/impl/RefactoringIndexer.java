package org.emftext.refactoring.indexconnector.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.index.indexer.Indexer;

public class RefactoringIndexer implements Indexer {

	public static final String KEY_ROLEMAPPING_FOR_METAMODEL_URI 	= "ROLEMAPPING_FOR_METAMODEL_URI";
	public static final String KEY_IS_ROLEMAPPING 					= "IS_ROLEMAPPING";
	public static final String KEY_IS_REFSPEC 						= "IS_REFSPEC";
	public static final String KEY_REFSPEC_FOR_ROLEMODEL_URI		= "REFSPEC_FOR_ROLEMODEL_URI";

	public RefactoringIndexer() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.reuseware.sokan.index.indexer.Indexer#createIndex(org.eclipse.emf.common.util.URI, java.util.Map, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public Map<String, String> createIndex(URI artifactURI,
			Map<String, String> currentInfos, ResourceSet resourceSet) {
		Map<String, String> metaData = new LinkedHashMap<String, String>();
		Resource resource = resourceSet.getResource(artifactURI, true);
		if(resource == null){
			return null;
		}
		EList<EObject> contents = resource.getContents();
		if(contents.size() > 0){
			EObject root = contents.get(0);
			metaData.putAll(handleRoleMappingModel(root));
			metaData.putAll(handleRefactoringSpecification(root));
		}
		return metaData;
	}

	private Map<String, String> handleRefactoringSpecification(EObject root) {
		Map<String, String> metaData = new LinkedHashMap<String, String>();
		if(root instanceof RefactoringSpecification){
			metaData.put(KEY_IS_REFSPEC, Boolean.TRUE.toString());
			RefactoringSpecification refSpec = (RefactoringSpecification) root;
			RoleModel roleModel = refSpec.getUsedRoleModel();
			Resource rmResource = roleModel.eResource();
			URI rmUri = rmResource.getURI();
			if(rmUri != null){
				metaData.put(KEY_REFSPEC_FOR_ROLEMODEL_URI, rmUri.toPlatformString(true));
			}
		} else {
			metaData.put(KEY_IS_REFSPEC, Boolean.FALSE.toString());
		}
		return metaData;
	}

	private Map<String, String> handleRoleMappingModel(EObject root) {
		Map<String, String> metaData = new LinkedHashMap<String, String>();
		if(root instanceof RoleMappingModel){
			metaData.put(KEY_IS_ROLEMAPPING, Boolean.TRUE.toString());
			RoleMappingModel roleMapping = (RoleMappingModel) root;
			EPackage targetMM = roleMapping.getTargetMetamodel();
			String nsURI = targetMM.getNsURI();
			metaData.put(KEY_ROLEMAPPING_FOR_METAMODEL_URI, nsURI);
		} else {
			metaData.put(KEY_IS_ROLEMAPPING, Boolean.FALSE.toString());
		}
		return metaData;
	}

	/* (non-Javadoc)
	 * @see org.reuseware.sokan.index.indexer.Indexer#getDependent(org.reuseware.sokan.ID)
	 */
	public Map<ID, Set<String>> getDependent(ID artifactID) {
		// TODO Auto-generated method stub
		return null;
	}

}
