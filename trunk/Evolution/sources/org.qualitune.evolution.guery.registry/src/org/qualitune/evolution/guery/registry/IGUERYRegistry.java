/**
 * 
 */
package org.qualitune.evolution.guery.registry;

import java.util.List;

import nz.ac.massey.cs.guery.Motif;

import org.qualitune.evolution.guery.registry.impl.GUERYRegistry;

/**
 * This interface provides an API for registering new {@link Motif motifs} to the GUERY registry.
 * 
 * @author jreimann
 *
 */
public interface IGUERYRegistry {

	public static IGUERYRegistry INSTANCE = new GUERYRegistry();
	
	/**
	 * Registers a new motif to the registry.
	 * @param motif
	 */
	public void registerMotif(Motif<EObjectVertex, EReferenceEdge> motif);
	
	/**
	 * Returns all motifs.
	 * @return
	 */
	public List<Motif<EObjectVertex, EReferenceEdge>> getRegisteredMotifs();
}
