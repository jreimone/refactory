/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.indexconnector.sokan;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.IndexMetaData;
import org.reuseware.sokan.IndexRow;
import org.reuseware.sokan.index.DependencyMap;
import org.reuseware.sokan.index.indexer.Indexer;
import org.reuseware.sokan.index.util.IndexUtil;
import org.reuseware.sokan.index.util.ResourceUtil;

public class InverseModelReferencesIndexer implements Indexer {

	protected static final String INDEXER_ID = "org.emftext.refactoring.indexer.inversereferences";
	protected static final String KEY_INVERSE_REFERENCED_RESOURCES	= "INVERSE_REFERENCED_RESOURCES";
	
	public InverseModelReferencesIndexer() {
		// TODO Auto-generated constructor stub
	}

	public void createIndex(URI artifactURI, IndexMetaData metaData, ResourceSet resourceSet) {
		String idString = ResourceUtil.idString(ResourceUtil.idFrom(artifactURI));
		List<IndexRow> index = IndexUtil.INSTANCE.getIndex();
		for (IndexRow indexRow : index) {
			IndexMetaData rowMetaData = indexRow.getMetaData();
			List<String> values = rowMetaData.getMulti(ModelReferencesIndexer.KEY_REFERENCED_RESOURCES);
			if(values != null){
				for (String value : values) {
					if(idString.equals(value)){
						String inverseReference = ResourceUtil.idString(indexRow.getArtifactID());
						metaData.addMultiple(KEY_INVERSE_REFERENCED_RESOURCES, inverseReference);
//						System.out.println("set inverse reference in " + platformString + " for " + inverseReference);
					}
				}
			}
		}
	}

	public void getDependent(ID artifactID, DependencyMap depMap) {
//		depMap.put(artifactID, Arrays.asList(new String[]{ModelReferencesIndexer.INDEXER_ID, INDEXER_ID}));
	}

}
