/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class TestpropertiesProposalPostProcessor {
	
	public java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> process(java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
