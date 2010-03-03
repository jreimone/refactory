package org.emftext.refactoring.indexconnector.impl;

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
import org.reuseware.sokan.IndexMetaData;
import org.reuseware.sokan.SokanFactory;
import org.reuseware.sokan.index.indexer.Indexer;

public class RefactoringIndexer implements Indexer {

	public static final String KEY_ROLEMAPPING_FOR_METAMODEL_URI 	= "ROLEMAPPING_FOR_METAMODEL_URI";
	public static final String KEY_IS_ROLEMAPPING 					= "IS_ROLEMAPPING";
	public static final String KEY_IS_REFSPEC 						= "IS_REFSPEC";
	public static final String KEY_REFSPEC_FOR_ROLEMODEL_URI		= "REFSPEC_FOR_ROLEMODEL_URI";

	public RefactoringIndexer() {
		// TODO Auto-generated constructor stub
	}

	private IndexMetaData handleRefactoringSpecification(EObject root) {
//		Map<String, String> metaData = new LinkedHashMap<String, String>();
		IndexMetaData metaData = SokanFactory.eINSTANCE.createIndexMetaData();
		if(root instanceof RefactoringSpecification){
			metaData.putSingle(KEY_IS_REFSPEC, Boolean.TRUE.toString());
//			metaData.put(KEY_IS_REFSPEC, Boolean.TRUE.toString());
			RefactoringSpecification refSpec = (RefactoringSpecification) root;
			RoleModel roleModel = refSpec.getUsedRoleModel();
			Resource rmResource = roleModel.eResource();
			URI rmUri = rmResource.getURI();
			if(rmUri != null){
				metaData.putSingle(KEY_REFSPEC_FOR_ROLEMODEL_URI, rmUri.toPlatformString(true));
			}
		} else {
			metaData.putSingle(KEY_IS_REFSPEC, Boolean.FALSE.toString());
		}
		return metaData;
	}

	private IndexMetaData handleRoleMappingModel(EObject root) {
//		Map<String, String> metaData = new LinkedHashMap<String, String>();
		IndexMetaData metaData = SokanFactory.eINSTANCE.createIndexMetaData();
		if(root instanceof RoleMappingModel){
			metaData.putSingle(KEY_IS_ROLEMAPPING, Boolean.TRUE.toString());
			RoleMappingModel roleMapping = (RoleMappingModel) root;
			EPackage targetMM = roleMapping.getTargetMetamodel();
			String nsURI = targetMM.getNsURI();
			metaData.putSingle(KEY_ROLEMAPPING_FOR_METAMODEL_URI, nsURI);
		} else {
			metaData.putSingle(KEY_IS_ROLEMAPPING, Boolean.FALSE.toString());
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

	public void createIndex(URI artifactURI, IndexMetaData metaData, ResourceSet resourceSet) {
//		Map<String, String> metaData = new LinkedHashMap<String, String>();
		Resource resource = resourceSet.getResource(artifactURI, true);
		if(resource == null){
			return;
		}
		EList<EObject> contents = resource.getContents();
		if(contents.size() > 0){
			EObject root = contents.get(0);
			metaData.putAll(handleRoleMappingModel(root));
			metaData.putAll(handleRefactoringSpecification(root));
		}
//		return metaData;
	}

}
