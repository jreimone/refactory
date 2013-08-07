package org.modelrefactoring.guery.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nz.ac.massey.cs.guery.Constraint;
import nz.ac.massey.cs.guery.GroupByClause;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.PathConstraint;
import nz.ac.massey.cs.guery.Processor;
import nz.ac.massey.cs.guery.PropertyConstraint;
import nz.ac.massey.cs.guery.mvel.CompiledGroupByClause;
import nz.ac.massey.cs.guery.mvel.CompiledPropertyConstraint;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelrefactoring.guery.ConnectedBy;
import org.modelrefactoring.guery.Connection;
import org.modelrefactoring.guery.EdgeSelection;
import org.modelrefactoring.guery.Grouping;
import org.modelrefactoring.guery.NotConnectedBy;
import org.modelrefactoring.guery.PreProcessor;
import org.modelrefactoring.guery.Role;
import org.modelrefactoring.guery.VertexSelection;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EReferenceEdge;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * Just an adapter implementation of {@link Motif} to adapt {@link org.modelrefactoring.guery.Motif}.
 * 
 * @author jreimann
 *
 */
public class ModelMotifAdapter<Vertex extends EObjectVertex> implements Motif<Vertex, EReferenceEdge> {

	private org.modelrefactoring.guery.Motif motif;

	private List<String> roles;
	private List<String> pathRoles;
	private List<String> negatedPathRoles;
	private List<Constraint> constraints;

	private List<GroupByClause<Vertex>> groupByClauses;

	private List<Processor<Vertex, EReferenceEdge>> processors;

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
			VertexSelection vertexSelection = motif.getVertexSelection();
			EList<org.modelrefactoring.guery.Constraint> vertexConstraints = vertexSelection.getConstraints();
			for (org.modelrefactoring.guery.Constraint constraint : vertexConstraints) {
				PropertyConstraint propertyConstraint = createPropertyConstraint(constraint);
				constraints.add(propertyConstraint);
			}
			List<EdgeSelection> edgeSelections = motif.getEdgeSelections();
			for (EdgeSelection edgeSelection : edgeSelections) {
				List<Connection> connections = edgeSelection.getConnections();
				for (Connection connection : connections) {
					PathConstraint<EObjectVertex,EReferenceEdge> pathConstraint = createPathConstraint(edgeSelection, connection);
					constraints.add(pathConstraint);
				}
			}
			// the following was adapted from gueryParser.addConstraint(Token constraintT)
			// to attach a PropertyConstraint to a PathConstraint when a path is constrained with it
			Collection<Constraint> pathConstraints = Collections2.filter(new ArrayList<Constraint>(constraints),new Predicate<Constraint>(){@Override public boolean apply(Constraint arg) {return arg instanceof PathConstraint;}});
			for (EdgeSelection edgeSelection : edgeSelections) {
				List<org.modelrefactoring.guery.Constraint> modelConstraints = edgeSelection.getConstraints();
				for (org.modelrefactoring.guery.Constraint constraint : modelConstraints) {
					PropertyConstraint propertyConstraint = createPropertyConstraint(constraint);
					boolean addedToPathConstraint = false;
					for (Constraint filteredPathConstraint : pathConstraints) {
						PathConstraint<?, ?> pathConstraint = (PathConstraint<?, ?>) filteredPathConstraint;
						if (propertyConstraint.getRoles().size()==1 && propertyConstraint.getFirstRole().equals(pathConstraint.getRole())) {
							pathConstraint.addConstraint(propertyConstraint);
							addedToPathConstraint = true;
						} 
					}
					if(!addedToPathConstraint){
						constraints.add(propertyConstraint);
					}
				}
			}
		}
		return constraints;
	}

	private PropertyConstraint createPropertyConstraint(org.modelrefactoring.guery.Constraint constraint){
		String expression = constraint.getExpression();
		CompiledPropertyConstraint propertyConstraint = new CompiledPropertyConstraint(expression);
		return propertyConstraint;
	}

	private PathConstraint<EObjectVertex, EReferenceEdge> createPathConstraint(EdgeSelection edgeSelection, Connection connection) {
		PathConstraint<EObjectVertex, EReferenceEdge> gueryConstraint = new PathConstraint<EObjectVertex, EReferenceEdge>();
		gueryConstraint.setRole(connection.getPath());
		gueryConstraint.setSource(connection.getFrom().getName());
		gueryConstraint.setTarget(connection.getTo().getName());
		gueryConstraint.setNegated(false);
		gueryConstraint.setMinLength(connection.getMinLength());
		gueryConstraint.setMaxLength(connection.getMaxLength());
		gueryConstraint.setComputeAll(connection.isComputeAll());
		boolean negated = edgeSelection instanceof NotConnectedBy;
		gueryConstraint.setNegated(negated);
		return gueryConstraint;
	}

	@Override
	public Collection<GroupByClause<Vertex>> getGroupByClauses() {
		if(groupByClauses == null){
			groupByClauses = new ArrayList<GroupByClause<Vertex>>();
			List<Grouping> groupings = motif.getGroupBy();
			for (Grouping grouping : groupings) {
				List<org.modelrefactoring.guery.Constraint> groupByConstraints = grouping.getConstraints();
				for (org.modelrefactoring.guery.Constraint groupBy : groupByConstraints) {
					CompiledGroupByClause<Vertex> clause = new CompiledGroupByClause<Vertex>(groupBy.getExpression());
					groupByClauses.add(clause);
				}
			}
		}
		return groupByClauses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Processor<Vertex, EReferenceEdge>> getGraphProcessors() {
		if(processors == null){
			processors = new ArrayList<Processor<Vertex, EReferenceEdge>>();
			List<PreProcessor> preprocessors = motif.getPrepare();
			for (PreProcessor preProcessor : preprocessors) {
				@SuppressWarnings("rawtypes")
				Class<Processor> processorClass = getProcessorClass(preProcessor);
				try {
					@SuppressWarnings("rawtypes")
					Processor processor = processorClass.newInstance();
					processors.add(processor);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return processors;
	}

	@Override
	public String getName() {
		return motif.getName();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Class<Processor> getProcessorClass(PreProcessor processor){
		//		if(Platform.isRunning()){
		//		URI uri2 = EcoreUtil.getURI(container);
		//		Resource resource = container.eResource();
		//		if(resource != null){
		//			URI uri = resource.getURI();
		//			if(uri.isPlatformResource()){
		//				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		//				IFile file = root.getFile(new Path(uri.toPlatformString(true)));
		//				if(file != null && file.exists()){
		//					IProject project = file.getProject();
		//					if(project != null && project.exists()){
		//						IJavaProject javaProject = (IJavaProject) project.getAdapter(IJavaProject.class);
		//						if(javaProject != null){
		//							String id1 = javaProject.getElementName();
		//							String id2 = javaProject.getHandleIdentifier();
		////							Platform.getBundle(javaProject.get)
		//							try {
		//								IType type = javaProject.findType(lexem);
		//								if(type != null){
		//									IClassFile classFile = type.getClassFile();
		//									IJavaModel javaModel = classFile.getJavaModel();
		//									//									JavaCore.getClasspathContainer(containerPath, project)
		//									System.out.println();
		//								}
		//							} catch (JavaModelException e) {
		//								result.setErrorMessage("Class '" + lexem + "' couldn't be loaded");
		//							}
		//						}
		//					}
		//				}
		//			}
		//		}
		//	} else {
		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			Class<?> clazz = classLoader.loadClass(processor.getProcessorClassName());
			if(Processor.class.isAssignableFrom(clazz)){
				return (Class<Processor>) clazz;
			} 
		} catch (ClassNotFoundException e) {			
		}
		//	}
		return null;
	}
}
