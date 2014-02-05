/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import org.eclipse.core.resources.IResource;

public class OperatorsUIMetaInformation extends org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation {
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsHoverTextProvider getHoverTextProvider() {
		return new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsHoverTextProvider();
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsImageProvider getImageProvider() {
		return org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsImageProvider.INSTANCE;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorManager createColorManager() {
		return new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.modelrefactoring.evolution.operators.resource.operators.I
	 * OperatorsTextResource,
	 * org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorMan
	 * ager) instead.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsTokenScanner createTokenScanner(org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorManager colorManager) {
		return (org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.ui.IOperatorsTokenScanner createTokenScanner(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource, org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsColorManager colorManager) {
		return new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsTokenScanner(resource, colorManager);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsCodeCompletionHelper createCodeCompletionHelper() {
		return new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new org.modelrefactoring.evolution.operators.resource.operators.ui.debug.OperatorsLineBreakpointAdapter();
	}
	
}
