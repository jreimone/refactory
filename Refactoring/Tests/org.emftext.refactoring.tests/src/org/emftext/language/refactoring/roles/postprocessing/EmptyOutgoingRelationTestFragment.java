/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.TestUtil;
import org.emftext.test.core.InputData;
import org.emftext.test.core.TestClass;
import org.emftext.test.core.TestData;
import org.emftext.test.core.TestDataSet;
import org.junit.Test;

/**
 * 
 * @author Jan Reimann
 *
 */
@TestData("EmptyOutgoingRelationTest")
public class EmptyOutgoingRelationTestFragment extends TestClass{

	private String path = "ExtractMethod";
	private RoleModel model;
	
	@Test
	@InputData("ExtractMethod")
	public void emptyOutgoingRelations(){
		TestDataSet dataSet = getTestDataSet();
		File file = dataSet.getInputFileByPattern(path);
		model = TestUtil.getExpectedModelFromFile(file, RoleModel.class);
		assertNotNull(model);
		EList<Collaboration> relations = model.getCollaborations();
		Role origContainerRole = null;
		EList<Collaboration> outgoingRelations1 = new BasicEList<Collaboration>();
		for (Collaboration relation : relations) {
			Role source = relation.getSource();
			if("OrigContainer".equals(source.getName())){
				origContainerRole = source;
				outgoingRelations1.add(relation);
			}
		}
		assertNotNull("Role OrigContainer mustn't be null", origContainerRole);
		assertTrue("outgoing relations of OrigContainer must contain relations", outgoingRelations1.size() > 0);
		EList<Collaboration> outgoingRelations2 = origContainerRole.getOutgoing();
		assertTrue("outgoing relations of OrigContainer must contain relations", outgoingRelations2.size() > 0);
		assertTrue("the previous found relations must be all contained in the outgoing relations of OrigContainer", outgoingRelations2.containsAll(outgoingRelations1));
	}
}
