/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import java.util.List;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class TestpropertiesProposalPostProcessor {
	
	public List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> process(List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
