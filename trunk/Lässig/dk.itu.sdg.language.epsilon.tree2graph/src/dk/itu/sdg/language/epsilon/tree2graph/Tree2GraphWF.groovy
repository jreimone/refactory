package dk.itu.sdg.language.epsilon.tree2graph

import graph.Graph.Graph
import graph.Graph.GraphPackage

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import tree.Tree.Tree
import tree.Tree.TreePackage


class Tree2GraphWF {
	
	def static modelAPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.language.epsilon.tree2graph/input/tree.model"
	def static modelBPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.language.epsilon.tree2graph/output/graph.model"
	
	def static private ResourceSet rs = new ResourceSetImpl()
	
	def static public void run() {
		TreePackage treePackageInstance = TreePackage.eINSTANCE;
		GraphPackage graphPackageInstance = GraphPackage.eINSTANCE;
		
		def resource = readInputModel(modelAPath)
		def resultModel = runTransformer(resource)
		writeModel(resultModel)
		
//		println("TRANSFORMATION IS DONE...")
	}
	
	def static Resource readInputModel(String path) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		
		Resource modelAResource = Tree2GraphWF.rs.getResource(URI.createFileURI(path),true)
	}
	
	def static Graph runTransformer(Resource resource) {
		
		def Graph transformed = null
		if (resource.contents.get(0) instanceof Tree) {
			def Tree p = (Tree) resource.contents.get(0);
			
			def long startTime1 = System.currentTimeMillis()
			transformed = new Tree2GraphJava().transform(p)
			def long endTime1 = System.currentTimeMillis() - startTime1
		
			def long startTime2 = System.currentTimeMillis()
			transformed = new Tree2GraphGroovy().transform(p)
			def long endTime2 = System.currentTimeMillis() - startTime2
			
			def long startTime3 = System.currentTimeMillis()
			transformed = new Tree2Graph().transform(p)
			def long endTime3 = System.currentTimeMillis() - startTime3
			
			//Java,Groovy,Xtend
			println(endTime1 + "," + endTime2 + "," + endTime3)

			transformed			
		} else {
			println("No Tree instance found in model slot")
			return
		}
	}
	
	def static void writeModel(Object model) {
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());		
		def uri = rs.createResource(URI.createURI(modelBPath))
		def Resource resource = uri
		resource.getContents().add(model)
	
		//TODO set right save thing
//		resource.save(System.out, null);
//		resource.save(null);
	}
	
	def public static void main(String[] args) {
		this.run()
	}

}
