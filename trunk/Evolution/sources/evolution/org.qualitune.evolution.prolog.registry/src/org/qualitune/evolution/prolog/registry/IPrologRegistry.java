package org.qualitune.evolution.prolog.registry;

import org.qualitune.evolution.prolog.registry.impl.PrologRegistry;

import alice.tuprolog.Prolog;
import alice.tuprolog.Theory;

/**
 * This interface provides an API for registering new rules in the Prolog knowledge base.
 * 
 * @author jreimann
 *
 */
public interface IPrologRegistry {

	public static IPrologRegistry INSTANCE = new PrologRegistry();
	
	/**
	 * The given <code>knowledgeBase</code> will be Prolog parsed and registered in the 
	 * global Prolog knowledge base.
	 * 
	 * @param knowledgeBase
	 * @return returns the {@link Theory theory} which is generated from the <code>knowledgeBase</code>
	 */
	public Theory registerKnowledge(String knowledgeBase);

	/**
	 * Returns the current used Prolog engine.
	 * @return
	 */
	public Prolog getEngine();

	/**
	 * Returns the global knowledge base where all other theories are appended.
	 * 
	 * @return
	 */
	public Theory getKnowledgeBase();
}
