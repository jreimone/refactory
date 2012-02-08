package org.qualitune.evolution.prolog.generator;

import org.eclipse.emf.ecore.EObject;
import org.qualitune.evolution.prolog.generator.impl.PrologGenerator;

import alice.tuprolog.Theory;

/**
 * This interface should be implemented to provide a generator for a Prolog fact base.
 * 
 * @author jreimann
 *
 */
public interface IPrologGenerator {

	/**
	 * Default implementation of this interface.
	 */
	public static IPrologGenerator INSTANCE = new PrologGenerator();
	
	/**
	 * This method generates a fact base for the given <code>model</code>. The fact base
	 * is encoded as a {@link Theory}.<br>
	 * The fact base contains facts for explicit references from the given <code>model</code>
	 * to other models being situated in another resource.
	 * 
	 * @param model the model to generate the fact base for
	 * @return the {@link Theory} containing the fact base for the given <code>model</code>
	 */
	public Theory generateTheory(EObject model);
}
