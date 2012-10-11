package org.qualitune.evolution.registry;

import java.util.List;

import org.qualitune.evolution.registry.impl.KnowledgeBaseRegistry;

/**
 * The registry for knolwedge bases.
 * 
 * @author jreimann
 *
 */
public interface IKnowledgeBaseRegistry {

	public static IKnowledgeBaseRegistry INSTANCE = new KnowledgeBaseRegistry();
	
	/**
	 * Registers a new knowledge base.
	 * 
	 * @param knowledgeBase
	 */
	public void registerKnowledgeBase(IKnowledgeBase knowledgeBase);
	
	/**
	 * Returns all knowledge bases.
	 * 
	 * @return
	 */
	public List<IKnowledgeBase> getKnowledgeBases();
}
