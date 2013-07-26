package org.modelrefactoring.guery.io;

import java.io.InputStream;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;

import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EReferenceEdge;

/**
 * Reads a {@link org.modelrefactoring.guery.Motif} (created with the GUERY EMFText editor) and transforms it to
 * a {@link Motif}. 
 * <br>
 * The parameter <code>source</code> from method {@link #read(InputStream)} is ignored in this
 * implementation because the {@link org.modelrefactoring.guery.Motif motif} is passed in the constructor already. 
 * 
 * @author jreimann
 *
 */
public class ModelMotifReader implements MotifReader<EObjectVertex, EReferenceEdge> {

	private org.modelrefactoring.guery.Motif motif;
	
	public ModelMotifReader(org.modelrefactoring.guery.Motif motif){
		this.motif = motif;
	}
	
	/**
	 * This method just returns a {@link ModelMotifAdapter} which adapts a {@link org.modelrefactoring.guery.Motif}
	 * to a GUERY {@link Motif}.
	 * 
	 * @param source is ignored because the {@link org.modelrefactoring.guery.Motif} to be converted to a GUERY {@link Motif}
	 * is passed in the constructor already
	 * @return the GUERY {@link Motif}, converted from a {@link org.modelrefactoring.guery.Motif} parsed
	 * by the EMFText generated parser of the GUERY DSL
	 */
	@Override
	public Motif<EObjectVertex, EReferenceEdge> read(InputStream source) throws MotifReaderException {
		Motif<EObjectVertex, EReferenceEdge> gueryMotif = new ModelMotifAdapter(motif);
		return gueryMotif;
	}

}
