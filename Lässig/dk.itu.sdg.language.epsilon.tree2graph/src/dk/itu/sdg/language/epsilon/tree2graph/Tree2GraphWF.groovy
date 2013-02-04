package dk.itu.sdg.language.epsilon.tree2graph

import graph.Graph.Graph
import graph.Graph.GraphPackage

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.osgi.framework.Bundle

import tree.Tree.Tree
import tree.Tree.TreePackage


class Tree2GraphWF {

	def static modelAPath = "input/tree.model"
	def static modelBPath = "output/graph.model"

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

		String pluginId = Activator.getDefault().getBundle().getSymbolicName()
		URI uri = URI.createPlatformPluginURI("/" + pluginId + "/" + path, true)
		Resource modelAResource = Tree2GraphWF.rs.getResource(uri,true)

		return modelAResource
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl())

		Bundle bundle = Activator.getDefault().getBundle()

		String loc1 = bundle.getLocation()
		def pluginPath = loc1.replace("reference:file:/", "")
		def uri = URI.createFileURI(pluginPath + modelBPath)

		def Resource resource = rs.createResource(uri)
		if(!(model == null)){
			resource.getContents().addAll(model)
			resource.save(null)

			//TODO set right save thing
			//		resource.save(System.out, null);
			//		resource.save(null);
		}
	}

	def public static void main(String[] args) {
		this.run()
	}
}
