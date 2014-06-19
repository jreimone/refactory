package org.emftext.refactoring.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

/**
 * This class provides a {@link Copier} which can be reversed.
 *  
 * @author jreimann
 *
 */
public class InverseableCopier extends Copier {

	private static final long serialVersionUID = -1065624349554517822L;

	public InverseableCopier(boolean resolveProxies, boolean useOriginalReferences) {
		super(resolveProxies, useOriginalReferences);
	}

	public InverseableCopier() {
		super();
	}

	public InverseableCopier(boolean resolveProxies) {
		super(resolveProxies);
	}

	public Map<EObject, EObject> getInverse(){
		Map<EObject, EObject> inverse = new HashMap<EObject, EObject>();
		for (EObject source : keySet()) {
			EObject target = get(source);
			inverse.put(target, source);
		}
		return inverse;
	}
}
