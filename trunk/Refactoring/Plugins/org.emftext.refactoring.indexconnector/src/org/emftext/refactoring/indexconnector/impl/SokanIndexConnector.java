/**
 * 
 */
package org.emftext.refactoring.indexconnector.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.IndexMetaData;
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
		List<IndexRow> rows = getRowsByBooleanKey(RefactoringIndexer.KEY_IS_ROLEMAPPING, "true");
		for (IndexRow row : rows) {
			IndexMetaData metaData = row.getMetaData();
			if(Boolean.valueOf(metaData.getSingle(RefactoringIndexer.KEY_IS_ROLEMAPPING))){
				String mmUri = metaData.getSingle(RefactoringIndexer.KEY_ROLEMAPPING_FOR_METAMODEL_URI);
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
		URI resourceUri = ResourceUtil.uriFrom(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(resourceUri, true);
		EObject root = resource.getContents().get(0);
		if(clazz.isInstance(root)){
			return (T) root;
		}
		return null;
	}

	private List<IndexRow> getRowsByBooleanKey(String key, String value){
		List<IndexRow> rows = new LinkedList<IndexRow>();
		List<IndexRow> index = IndexUtil.INSTANCE.getIndex();
		for (IndexRow indexRow : index) {
			IndexMetaData metaData = indexRow.getMetaData();
			if(metaData.getSingle(key) != null){
//				if(Boolean.parseBoolean(metaData.get(key))){
				if(Boolean.parseBoolean(metaData.getSingle(key)) == Boolean.parseBoolean(value)){
					rows.add(indexRow);
				}
//				}
			}
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.indexconnector.IndexConnector#getRefactoringSpecification(org.emftext.language.refactoring.roles.RoleModel)
	 */
	public RefactoringSpecification getRefactoringSpecification(RoleModel roleModel) {
		List<IndexRow> rows = getRowsByBooleanKey(RefactoringIndexer.KEY_IS_REFSPEC, "true");
		Resource rmResource = roleModel.eResource();
		URI rmUri = rmResource.getURI();
		if(rmUri == null){
			return null;
		}
		String rmPlatformString = rmUri.toPlatformString(true);
		if(rmPlatformString == null){
			rmPlatformString = URI.createURI(rmUri.toString()).toString();
		}
		for (IndexRow row : rows) {
			IndexMetaData metaData = row.getMetaData();
			String rmIndexPlatformString = metaData.getSingle(RefactoringIndexer.KEY_REFSPEC_FOR_ROLEMODEL_URI);
			if(rmIndexPlatformString.equals(rmPlatformString)){
				RefactoringSpecification refSpec = getExpectedModelByUri(row.getPhyURI(), RefactoringSpecification.class);
				if(refSpec != null){
					return refSpec;
				}
			}
		}
		return null;
	}

	public List<Resource> getReferencingResources(Resource referee) {
		URI uri = referee.getURI();
		if(uri == null){
			return null;
		}
		ID refereeID = ResourceUtil.idFrom(uri);
		if(refereeID == null){
			return null;
		}
		IndexRow row = IndexUtil.INSTANCE.getIndex(refereeID);
		if(row == null){
			return null;
		}
		IndexMetaData metaData = row.getMetaData();
		List<Resource> referers = new LinkedList<Resource>();
		List<String> refererStrings = metaData.getMulti(ModelReferencesIndexer.KEY_REFERENCED_RESOURCES);
		for (String string : refererStrings) {
			URI refererUri = ResourceUtil.uriFrom(string);
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(refererUri, true);
			if(resource == null){
				resource = rs.createResource(refererUri);
			}
			if(resource != null){
				referers.add(resource);
			}
		}
		return referers;
	}

}
