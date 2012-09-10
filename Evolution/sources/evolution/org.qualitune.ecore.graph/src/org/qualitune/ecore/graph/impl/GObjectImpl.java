/**
 * 
 */
package org.qualitune.ecore.graph.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.qualitune.ecore.graph.GObject;

import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * @author jreimann
 *
 */
public abstract class GObjectImpl extends EObjectImpl implements GObject {

	private SynchronousMapList<GReference> outEdges;
	private List<GReference> inEdges;
	private List<GReference> edges;
	private List<GObject> vertices;
	
	@Override
	public GObject gGraph() {
		GObject container = (GObject) eContainer();
		if(container == null){
			return null;
		}
		return container.gGraph();
	}
	
	@Override
	public Collection<GReference> getInEdges(GObject vertex) {
		return vertex.gGetInEdges();
	}

	@Override
	public Collection<GReference> getOutEdges(GObject vertex) {
		return vertex.gGetOutEdges();
	}

	@Override
	public Collection<GObject> getPredecessors(GObject vertex) {
		return vertex.gGetPredecessors();
	}

	@Override
	public Collection<GObject> getSuccessors(GObject vertex) {
		return vertex.gGetSuccessors();
	}

	@Override
	public int inDegree(GObject vertex) {
		return vertex.gGetInEdges().size();
	}

	@Override
	public int outDegree(GObject vertex) {
		return vertex.gGetOutEdges().size();
	}

	@Override
	public boolean isPredecessor(GObject v1, GObject v2) {
		return getPredecessors(v1).contains(v2);
	}

	@Override
	public boolean isSuccessor(GObject v1, GObject v2) {
		return getSuccessors(v1).contains(v2);
	}

	@Override
	public int getPredecessorCount(GObject vertex) {
		return vertex.gGetPredecessors().size();
	}

	@Override
	public int getSuccessorCount(GObject vertex) {
		return vertex.gGetSuccessors().size();
	}

	@Override
	public GObject getSource(GReference directed_edge) {
		return directed_edge.getStart();
	}

	@Override
	public GObject getDest(GReference directed_edge) {
		return directed_edge.getEnd();
	}

	@Override
	public boolean isSource(GObject vertex, GReference edge) {
		return edge.getStart().equals(vertex);
	}

	@Override
	public boolean isDest(GObject vertex, GReference edge) {
		return edge.getEnd().equals(vertex);
	}

	@Override
	public boolean addEdge(GReference e, GObject v1, GObject v2) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public boolean addEdge(GReference e, GObject v1, GObject v2, EdgeType edgeType) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public Pair<GObject> getEndpoints(GReference edge) {
		return new Pair<GObject>(edge.getStart(), edge.getEnd());
	}

	@Override
	public GObject getOpposite(GObject vertex, GReference edge) {
		return edge.getStart().equals(vertex)?edge.getEnd():edge.getStart();
	}

	@Override
	public boolean containsVertex(GObject vertex) {
		return getVertices().contains(vertex);
	}

	@Override
	public boolean containsEdge(GReference edge) {
		return getEdges().contains(edge);
	}

	@Override
	public int getEdgeCount() {
		return getEdges().size();
	}

	@Override
	public int getVertexCount() {
		return getVertices().size();
	}

	@Override
	public Collection<GObject> getIncidentVertices(GReference edge) {
		return edge.getIncidentVertices();
	}

	@Override
	public GReference findEdge(GObject v1, GObject v2) {
		Collection<GReference> edgeSet = findEdgeSet(v1, v2);
		if(edgeSet.size() > 0){
			return edgeSet.iterator().next();
		}
		return null;
	}

	@Override
	public Collection<GReference> findEdgeSet(GObject v1, GObject v2) {
		Collection<GReference> connectingEdges = new ArrayList<GReference>();
		Collection<GReference> edges = null;
		if(v1.gGetSuccessorCount() <= v2.gGetPredecessorCount()){
			edges = v1.gGetOutEdges();
		} else {
			edges = v2.gGetInEdges();
		}
		for (GReference edge : edges) {
			if((edge.getStart().equals(v1) && edge.getEnd().equals(v2)) || 
					(edge.getStart().equals(v2) && edge.getEnd().equals(v1))){
				connectingEdges.add(edge);
			}
		}
		if(v2.gGetSuccessorCount() <= v1.gGetPredecessorCount()){
			edges = v2.gGetOutEdges();
		} else {
			edges = v1.gGetInEdges();
		}
		for (GReference edge : edges) {
			if((edge.getStart().equals(v1) && edge.getEnd().equals(v2)) || 
					(edge.getStart().equals(v2) && edge.getEnd().equals(v1))){
				connectingEdges.add(edge);
			}
		}
		return connectingEdges;
	}

	@Override
	public boolean addVertex(GObject vertex) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public boolean addEdge(GReference edge, Collection<? extends GObject> vertices) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public boolean addEdge(GReference edge, Collection<? extends GObject> vertices, EdgeType edge_type) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public boolean removeVertex(GObject vertex) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public boolean removeEdge(GReference edge) {
		throw new UnsupportedOperationException("Model/graph changes are intended to be made with Ecore API");
	}

	@Override
	public boolean isNeighbor(GObject v1, GObject v2) {
		return v1.gGetNeighbors().contains(v2);
	}

	@Override
	public boolean isIncident(GObject vertex, GReference edge) {
		return edge.getIncidentVertices().contains(vertex);
	}

	@Override
	public int degree(GObject vertex) {
		return vertex.gInDegree() + vertex.gOutDegree();
	}

	@Override
	public int getNeighborCount(GObject vertex) {
		return vertex.gGetNeighbors().size();
	}

	@Override
	public int getIncidentCount(GReference edge) {
		return edge.getIncidentVertices().size();
	}

	@Override
	public EdgeType getEdgeType(GReference edge) {
		return EdgeType.DIRECTED;
	}

	@Override
	public EdgeType getDefaultEdgeType() {
		return EdgeType.DIRECTED;
	}

	@Override
	public Collection<GReference> getEdges(EdgeType edge_type) {
		return getEdges();
	}

	@Override
	public int getEdgeCount(EdgeType edge_type) {
		return getEdges(edge_type).size();
	}

	@Override
	public Collection<GReference> getEdges() {
		if(edges == null){
			edges = new LinkedList<GReference>();
		}
		return edges;
	}

	@Override
	public Collection<GObject> getVertices() {
		if(vertices == null){
			vertices = new LinkedList<GObject>();
		}
		return vertices;
	}

	@Override
	public Collection<GObject> getNeighbors(GObject vertex) {
		return vertex.gGetNeighbors();
	}

	@Override
	public Collection<GReference> getIncidentEdges(GObject vertex) {
		return vertex.gGetIncidentEdges();
	}

	@Override
	public List<GReference> gGetIncidentEdges() {
		List<GReference> incidentEdges = new ArrayList<GReference>();
		incidentEdges.addAll(gGetInEdges());
		incidentEdges.addAll(gGetOutEdges());
		return incidentEdges;
	}

	@Override
	public List<GObject> gGetPredecessors() {
		List<GReference> inEdges = gGetInEdges();
		List<GObject> predecessors = new ArrayList<GObject>();
		for (GReference edge : inEdges) {
			predecessors.add(edge.getStart());
		}
		return predecessors;
	}

	@Override
	public List<GObject> gGetSuccessors() {
		List<GReference> inEdges = gGetOutEdges();
		List<GObject> successors = new ArrayList<GObject>();
		for (GReference edge : inEdges) {
			successors.add(edge.getEnd());
		}
		return null;
	}

	@Override
	public int gGetSuccessorCount() {
		return gGetSuccessors().size();
	}

	@Override
	public int gGetPredecessorCount() {
		return gGetPredecessors().size();
	}

	@Override
	public int gInDegree() {
		return gGetInEdges().size();
	}

	@Override
	public int gOutDegree() {
		return gGetOutEdges().size();
	}

	@Override
	public List<GReference> gGetInEdges() {
		if(inEdges == null){
			inEdges = new LinkedList<GReference>();
		}
		return inEdges;
	}

	@Override
	public List<GReference> gGetOutEdges() {
		if(outEdges == null){
			outEdges = new SynchronousMapList<GReference>();
		}
		return outEdges;
	}

	@Override
	public List<GObject> gGetNeighbors() {
		List<GObject> neighbors = new ArrayList<GObject>();
		for (GReference edge : gGetInEdges()) {
			neighbors.add(edge.getStart());
		}
		for (GReference edge : gGetOutEdges()) {
			neighbors.add(edge.getEnd());
		}
		return neighbors;
	}

	@Override
	public Set<GReference> gGetOutEdgesByReference(EReference reference) {
		if(outEdges == null){
			outEdges = new SynchronousMapList<GReference>();
		}
		Map<EReference, Set<GReference>> elementMap = outEdges.getElementMap();
		Set<GReference> set = elementMap.get(reference);
		if(set == null){
			set = new LinkedHashSet<GReference>();
			elementMap.put(reference, set);
		}
		return set;
	}
}
