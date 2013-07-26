package org.modelrefactoring.guery.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nz.ac.massey.cs.guery.Constraint;
import nz.ac.massey.cs.guery.GroupByClause;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.PathConstraint;
import nz.ac.massey.cs.guery.Processor;
import nz.ac.massey.cs.guery.mvel.CompiledGroupByClause;

import org.modelrefactoring.guery.ConnectedBy;
import org.modelrefactoring.guery.Connection;
import org.modelrefactoring.guery.EdgeSelection;
import org.modelrefactoring.guery.Grouping;
import org.modelrefactoring.guery.NotConnectedBy;
import org.modelrefactoring.guery.PreProcessor;
import org.modelrefactoring.guery.Role;
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

	private ArrayList<GroupByClause<EObjectVertex>> groupByClauses;

	private ArrayList<Processor<EObjectVertex, EReferenceEdge>> processors;

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
			List<EdgeSelection> edgeSelections = motif.getEdgeSelections();
			for (EdgeSelection edgeSelection : edgeSelections) {
				
					List<org.modelrefactoring.guery.Constraint> modelConstraints = edgeSelection.getConstraints();
					List<Connection> connections = edgeSelection.getConnections();
					for (org.modelrefactoring.guery.Constraint constraint : modelConstraints) {
						PathConstraint<EObjectVertex, EReferenceEdge> gueryConstraint = new PathConstraint<EObjectVertex, EReferenceEdge>();
						int index = modelConstraints.indexOf(constraint);
						Connection connection = connections.get(index);
						gueryConstraint.setRole(connection.getPath());
						gueryConstraint.setSource(connection.getFrom().getName());
						gueryConstraint.setTarget(connection.getTo().getName());
						gueryConstraint.setNegated(false);
						gueryConstraint.setMinLength(connection.getMinLength());
						gueryConstraint.setMaxLength(connection.getMaxLength());
						gueryConstraint.setComputeAll(connection.isComputeAll());
						boolean negated = edgeSelection instanceof ConnectedBy;
						gueryConstraint.setNegated(negated);
						constraints.add(gueryConstraint);
				}
			}
		}
		return constraints;
	}

	@Override
	public Collection<GroupByClause<EObjectVertex>> getGroupByClauses() {
		if(groupByClauses == null){
			groupByClauses = new ArrayList<GroupByClause<EObjectVertex>>();
			List<Grouping> groupings = motif.getGroupBy();
			for (Grouping grouping : groupings) {
				List<org.modelrefactoring.guery.Constraint> groupByConstraints = grouping.getConstraints();
				for (org.modelrefactoring.guery.Constraint groupBy : groupByConstraints) {
					CompiledGroupByClause<EObjectVertex> clause = new CompiledGroupByClause<EObjectVertex>(groupBy.getExpression());
					groupByClauses.add(clause);
				}
			}
		}
		return groupByClauses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Processor<EObjectVertex, EReferenceEdge>> getGraphProcessors() {
		if(processors == null){
			processors = new ArrayList<Processor<EObjectVertex, EReferenceEdge>>();
			List<PreProcessor> preprocessors = motif.getPrepare();
			for (PreProcessor preProcessor : preprocessors) {
				@SuppressWarnings("rawtypes")
				Class class_ = preProcessor.getClass_();
				if(Processor.class.isAssignableFrom(class_)){
					try {
						@SuppressWarnings("rawtypes")
						Processor processor = (Processor) class_.newInstance();
						processors.add(processor);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return processors;
	}

	@Override
	public String getName() {
		return motif.getName();
	}

}
