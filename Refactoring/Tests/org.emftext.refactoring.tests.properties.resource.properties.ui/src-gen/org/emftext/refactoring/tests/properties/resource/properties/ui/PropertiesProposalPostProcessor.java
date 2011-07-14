/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class PropertiesProposalPostProcessor {
	
	public java.util.List<org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal> process(java.util.List<org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
