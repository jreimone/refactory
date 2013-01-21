package dk.itu.sdg.language.epsilon.tree2graph

import graph.Graph.Edge
import graph.Graph.Graph
import graph.Graph.GraphFactory
import graph.Graph.Node
import graph.Graph.impl.GraphFactoryImpl

import java.util.ArrayList
import java.util.HashMap

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.lib.CollectionLiterals
import org.eclipse.xtext.xbase.lib.IteratorExtensions

import tree.Tree.Tree

import com.google.common.collect.Iterables

class Tree2GraphGroovy {
	
	def private factory = new GraphFactoryImpl()
	def private graph
  	  
	def public Graph transform(final Tree t) {
		def cacheKey = CollectionLiterals.newArrayList(t)
		def graph = this.factory.createGraph()
	
		graph.nodes.add(this.tree2Node(t))
		
		def trees = Iterables.<Tree>filter(IteratorExtensions.<EObject>toIterable(t.eAllContents()), Tree.class)
		this.graph = graph
		for (final Tree tree in trees) {
			graph.nodes.add(this.tree2Node(tree))
		}
		
		return this.graph
	}
  
	def private final HashMap<ArrayList<? extends Object>,Node> nodeCache = CollectionLiterals.newHashMap()
  
	def private Node tree2Node(final Tree t) {
		def final cacheKey = CollectionLiterals.newArrayList(t)
		def final n
		synchronized (nodeCache) {
			if (nodeCache.containsKey(cacheKey)) {
				return nodeCache.get(cacheKey)
			}
			n = this.factory.createNode()
			nodeCache.put(cacheKey, n)
		}

		n.name = t.label
		if (t.parent != null) {
			def e = this.factory.createEdge()
			e.source = this.tree2Node(t.parent)
			e.target = n
		}
				
		return n
	}
}
