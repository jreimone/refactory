/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.AbstractRefactoringTest;
import org.junit.Test;

/**
 * Run as Plugin-Test
 * 
 * @author Jan Reimann
 *
 */
public class EmptyOutgoingRelationTest extends AbstractRefactoringTest {

	private String path = "/roles/ExtractMethod.rolestext";
	private RoleModel model;
	
	@Test
	public void emptyOutgoingRelations(){
		model = getExpectedModelFromFile(path, RoleModel.class);
		assertNotNull(model);
		EList<Relation> relations = model.getRelations();
		Role origContainerRole = null;
		EList<Relation> outgoingRelations1 = new BasicEList<Relation>();
		for (Relation relation : relations) {
			Role source = relation.getSource();
			if("OrigContainer".equals(source.getName())){
				origContainerRole = source;
				outgoingRelations1.add(relation);
			}
		}
		assertNotNull("Role OrigContainer mustn't be null", origContainerRole);
		assertTrue("outgoing relations of OrigContainer must contain relations", outgoingRelations1.size() > 0);
		EList<Relation> outgoingRelations2 = origContainerRole.getOutgoing();
		assertTrue("outgoing relations of OrigContainer must contain relations", outgoingRelations2.size() > 0);
		assertTrue("the previous found relations must be all contained in the outgoing relations of OrigContainer", outgoingRelations2.containsAll(outgoingRelations1));
	}
}
