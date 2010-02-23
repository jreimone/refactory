/**
 * 
 */
package org.emftext.refactoring.indexconnector.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.reuseware.sokan.IndexRow;
import org.reuseware.sokan.index.util.IndexUtil;
import org.reuseware.sokan.index.util.ResourceUtil;

/**
 * @author Jan Reimann
 *
 */
public class SokanIndexConnector implements IndexConnector {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.indexconnector.IndexConnector#getRoleMapping(java.lang.String)
	 */
	public RoleMappingModel getRoleMapping(String metamodelURI) {
		List<IndexRow> rows = getRowsByKey(RefactoringIndexer.KEY_IS_ROLEMAPPING);
		for (IndexRow row : rows) {
			Map<String, String> metaData = row.getMetaData();
			if(Boolean.valueOf(metaData.get(RefactoringIndexer.KEY_IS_ROLEMAPPING))){
				String mmUri = metaData.get(RefactoringIndexer.KEY_ROLEMAPPING_FOR_METAMODEL_URI);
				if(mmUri != null){
					if(mmUri.equals(metamodelURI)){
						RoleMappingModel rmModel = getExpectedModelByUri(row.getPhyURI(), RoleMappingModel.class);
						if(rmModel != null){
							return rmModel;
						}
					}
				}
			}
		}				
		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> T getExpectedModelByUri(String uri, Class<T> clazz){
		URI resourceUri = ResourceUtil.INSTANCE.uriFrom(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(resourceUri, true);
		EObject root = resource.getContents().get(0);
		if(clazz.isInstance(root)){
			return (T) root;
		}
		return null;
	}
	
	private List<IndexRow> getRowsByKey(String key){
		List<IndexRow> rows = new LinkedList<IndexRow>();
		List<IndexRow> index = IndexUtil.INSTANCE.getIndex();
		for (IndexRow indexRow : index) {
			Map<String, String> metaData = indexRow.getMetaData();
			if(metaData.containsKey(key)){
				rows.add(indexRow);
			}
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.indexconnector.IndexConnector#getRefactoringSpecification(org.emftext.language.refactoring.roles.RoleModel)
	 */
	public RefactoringSpecification getRefactoringSpecification(
			RoleModel roleModel) {
		List<IndexRow> rows = getRowsByKey(RefactoringIndexer.KEY_IS_REFSPEC);
		Resource rmResource = roleModel.eResource();
		URI rmUri = rmResource.getURI();
		if(rmUri == null){
			return null;
		}
		String rmPlatformString = rmUri.toPlatformString(true);
		for (IndexRow row : rows) {
			Map<String, String> metaData = row.getMetaData();
			String rmIndexPlatformString = metaData.get(RefactoringIndexer.KEY_REFSPEC_FOR_ROLEMODEL_URI);
			if(rmIndexPlatformString.equals(rmPlatformString)){
				RefactoringSpecification refSpec = getExpectedModelByUri(row.getPhyURI(), RefactoringSpecification.class);
				if(refSpec != null){
					return refSpec;
				}
			}
		}
		return null;
	}

}
