/**
 * 
 */
package org.qualitune.evolution.guery;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.qualitune.evolution.guery.graph.EObjectVertex;
import org.qualitune.evolution.guery.graph.EReferenceEdge;
import org.qualitune.guery.MotifModel;

import nz.ac.massey.cs.guery.Constraint;
import nz.ac.massey.cs.guery.GroupByClause;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.Processor;

/**
 * Reads a {@link MotifModel} (created with the GUERY EMFText editor) and transforms it to
 * a {@link Motif}. 
 * <br>
 * The parameter <code>source</code> from method {@link #read(InputStream)} is ignored in this
 * implementation because the {@link MotifModel motif model} is passed in the constructor already. 
 * 
 * @author jreimann
 *
 */
public class ModelMotifReader implements MotifReader<EObjectVertex<?>, EReferenceEdge> {

	private MotifModel motifModel;
	
	public ModelMotifReader(MotifModel motifModel){
		this.motifModel = motifModel;
	}
	
	@Override
	public Motif<EObjectVertex<?>, EReferenceEdge> read(InputStream source) throws MotifReaderException {
		Motif<EObjectVertex<?>, EReferenceEdge> motif = new Motif<EObjectVertex<?>, EReferenceEdge>() {
			
			@Override
			public List<String> getRoles() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<String> getPathRoles() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<String> getNegatedPathRoles() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<GroupByClause<EObjectVertex<?>>> getGroupByClauses() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<Processor<EObjectVertex<?>, EReferenceEdge>> getGraphProcessors() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Constraint> getConstraints() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return motif;
	}

}
