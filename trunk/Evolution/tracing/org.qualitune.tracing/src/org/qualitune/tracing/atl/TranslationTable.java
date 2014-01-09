/**
 * 
 */
package org.qualitune.tracing.atl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.qualitune.tracing.umt.VapodiInstruction;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class TranslationTable {
	protected Map<EObject,EObject> translationTable;
	
	public TranslationTable() {
		translationTable = new HashMap<EObject,EObject>();
	}

	protected EObject translate(EObject umt) {
		if (umt instanceof VapodiInstruction)
			return null; // as VapodiInstructions are purely added by VAPODI, they can't have existed before and thus have no mapping
		else
			return translationTable.get(umt);
	}

	protected void addTranslation(EObject atl, EObject umt) {
		translationTable.put(umt, atl);
	}
}
