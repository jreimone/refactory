package dk.itu.sdg.language.epsilon.tree2graph;

import graph.Graph.Edge;
import graph.Graph.Graph;
import graph.Graph.GraphFactory;
import graph.Graph.Node;
import graph.Graph.impl.GraphFactoryImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import tree.Tree.Tree;

import com.google.common.collect.Iterables;

public class Tree2GraphJava {

	private GraphFactory factory = new GraphFactoryImpl();
	private Graph graph;
  	  
	public Graph transform(final Tree t) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(t);
		final Graph graph = this.factory.createGraph();
	    
		Node n1 = this.tree2Node(t);
		graph.getNodes().add(n1);
		
		Iterable<Tree> trees = Iterables.<Tree>filter(IteratorExtensions.<EObject>toIterable(t.eAllContents()), Tree.class);
	    this.graph = graph;
	    for (final Tree tree : trees) {
	    	graph.getNodes().add(this.tree2Node(tree));
	    }
	    
	    return this.graph;
	}
  
	private final HashMap<ArrayList<? extends Object>,Node> nodeCache = CollectionLiterals.newHashMap();
  
  	private Node tree2Node(final Tree t) {
	    final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(t);
	    final Node n;
	    synchronized (nodeCache) {
	    	if (nodeCache.containsKey(cacheKey)) {
	    		return nodeCache.get(cacheKey);
	    	}
	    	n = this.factory.createNode();
	    	nodeCache.put(cacheKey, n);
	    }

	    n.setName(t.getLabel());
	    if (t.getParent() != null) {
	    	Edge e = this.factory.createEdge();
	    	e.setSource(this.tree2Node(t.getParent()));
	    	e.setTarget(n);
	    }
	    return n;
  	}
}
