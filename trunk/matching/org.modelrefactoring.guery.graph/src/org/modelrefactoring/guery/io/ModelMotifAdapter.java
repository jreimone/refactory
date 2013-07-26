package org.modelrefactoring.guery.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nz.ac.massey.cs.guery.Constraint;
import nz.ac.massey.cs.guery.GroupByClause;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.PathConstraint;
import nz.ac.massey.cs.guery.Processor;

import org.eclipse.emf.common.util.EList;
import org.modelrefactoring.guery.ConnectedBy;
import org.modelrefactoring.guery.Connection;
import org.modelrefactoring.guery.EdgeSelection;
import org.modelrefactoring.guery.Grouping;
import org.modelrefactoring.guery.NotConnectedBy;
import org.modelrefactoring.guery.Role;
import org.modelrefactoring.guery.VertexSelection;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EReferenceEdge;

/**
 * Just an adapter implementation of {@link Motif} to adapt {@link org.qualitune.guery.Motif}.
 * 
 * @author jreimann
 *
 */
public class ModelMotifAdapter implements Motif<EObjectVertex, EReferenceEdge> {

	private org.modelrefactoring.guery.Motif motif;
	
	private List<String> roles;
	private List<String> pathRoles;
	private List<String> negatedPathRoles;
	private List<Constraint> constraints;
	
	public ModelMotifAdapter(org.modelrefactoring.guery.Motif motif) {
		super();
		this.motif = motif;
	}

	@Override
	public List<String> getRoles() {
		if(roles == null){
			roles = new ArrayList<String>();
			List<Role> roles2 = motif.getVertexSelection().getRoles();
			for (Role role : roles2) {
				roles.add(role.getName());
			}
		}
		return roles;
	}

	@Override
	public List<String> getPathRoles() {
		if(pathRoles == null){
			pathRoles = new ArrayList<String>();
			List<EdgeSelection> selections = motif.getEdgeSelections();
			for (EdgeSelection edgeSelection : selections) {
				if(edgeSelection instanceof ConnectedBy){
					List<Connection> connections = edgeSelection.getConnections();
					for (Connection connection : connections) {
						pathRoles.add(connection.getPath());
					}
				}
			}
		}
		return pathRoles;
	}

	@Override
	public List<String> getNegatedPathRoles() {
		if(negatedPathRoles == null){
			negatedPathRoles = new ArrayList<String>();
			List<EdgeSelection> selections = motif.getEdgeSelections();
			for (EdgeSelection edgeSelection : selections) {
				if(edgeSelection instanceof NotConnectedBy){
					List<Connection> connections = edgeSelection.getConnections();
					for (Connection connection : connections) {
						negatedPathRoles.add(connection.getPath());
					}
				}
			}
		}
		return negatedPathRoles;
	}

	@Override
	public List<Constraint> getConstraints() {
		if(constraints == null){
			constraints = new ArrayList<Constraint>();
			EList<org.modelrefactoring.guery.Constraint> constraints2;
			List<EdgeSelection> edgeSelections = motif.getEdgeSelections();
			for (EdgeSelection edgeSelection : edgeSelections) {
				constraints2 = edgeSelection.getConstraints();
				for (org.modelrefactoring.guery.Constraint constraint : constraints2) {
					PathConstraint<EObjectVertex, EReferenceEdge> gueryConstraint = new PathConstraint<EObjectVertex, EReferenceEdge>();
//					gueryConstraint.
				}
			}
			VertexSelection vertexSelection = motif.getVertexSelection();
			List<Grouping> groupBy = motif.getGroupBy();
		}
		return constraints;
	}

	@Override
	public Collection<GroupByClause<EObjectVertex>> getGroupByClauses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Processor<EObjectVertex, EReferenceEdge>> getGraphProcessors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return motif.getName();
	}

}
