/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A quick fix that replaces the target of a reference with another EObject. This
 * class is used to implement default quick fixes for references that could not be
 * resolved, but can also be used by custom reference resolvers.
 */
public class OperatorsChangeReferenceQuickFix extends org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsQuickFix {
	
	private EObject container;
	private EReference reference;
	private EObject oldTarget;
	private EObject newTarget;
	
	public OperatorsChangeReferenceQuickFix(String displayString, String imageKey, EObject container, EReference reference, EObject oldTarget, EObject newTarget) {
		super(displayString, imageKey, Arrays.asList(container, reference, oldTarget));
		this.container = container;
		this.reference = reference;
		this.oldTarget = oldTarget;
		this.newTarget = newTarget;
	}
	
	@Override
	public void applyChanges() {
		EcoreUtil.replace(container, reference, oldTarget, newTarget);
	}
	
}
