package dk.itu.sdg.language.epsilon.tree2graph

import graph.Graph.GraphFactory
import graph.Graph.impl.GraphFactoryImpl
import graph.Graph.Graph
import tree.Tree.Tree
import graph.Graph.Node

class Tree2Graph {
	
	var GraphFactory factory = new GraphFactoryImpl()
	var Graph graph

	def Graph create graph: factory.createGraph() transform(Tree t) {
		var trees = t.eAllContents.toIterable.filter(typeof(Tree))
		this.graph = graph
		
		graph.nodes += t.tree2Node()
		
		for (tree : trees) {
			graph.nodes += tree.tree2Node()
		}
	}

	def Node create n: factory.createNode() tree2Node(Tree t) {
		n.name = t.label
	
		// If t is not the top tree
		// create an edge connecting n
		// with the Node created from t's parent
		if (t.parent != null) {
			var e = factory.createEdge()
			e.source = t.parent.tree2Node()
			e.target = n	
		}
	}
}