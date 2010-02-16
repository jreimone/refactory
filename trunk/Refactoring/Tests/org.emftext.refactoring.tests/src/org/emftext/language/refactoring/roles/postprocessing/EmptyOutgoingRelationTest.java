/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.test.AbstractRefactoringTest;
import org.junit.Before;

/**
 * Run as Plugin-Test
 * 
 * @author Jan Reimann
 *
 */
public class EmptyOutgoingRelationTest extends AbstractRefactoringTest {

	private String path = "resources/ExtractMethod.rolestext";
	private RoleModel model;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		model = getExpectedModelFromFile(path, RoleModel.class);
	}
	
	public void testEmptyOutgoingRelations(){
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
