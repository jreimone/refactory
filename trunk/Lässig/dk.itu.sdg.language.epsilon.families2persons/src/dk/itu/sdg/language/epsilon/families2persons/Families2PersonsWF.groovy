package dk.itu.sdg.language.epsilon.families2persons

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.swt.widgets.Tree

import persons.PersonsPackage
import families.FamiliesPackage

class Families2PersonsWF {
	
	def static modelAPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.language.epsilon.families2persons/input/sample-Families.xmi"
	def static modelBPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.language.epsilon.families2persons/output/sample-Persons.xmi"
	
	def static private ResourceSet rs = new ResourceSetImpl()
	
	def static public void run() {
		FamiliesPackage treePackageInstance = FamiliesPackage.eINSTANCE;
		PersonsPackage graphPackageInstance = PersonsPackage.eINSTANCE;
		
		def resource = readInputModel(modelAPath)
		def resultModel = runTransformer(resource)
		writeModel(resultModel)
		
//		println("TRANSFORMATION IS DONE...")
	}
	
	def static Resource readInputModel(String path) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		Resource modelAResource = Families2PersonsWF.rs.getResource(URI.createFileURI(path),true)
	}
	
	def static Object runTransformer(Resource resource) {
		
		def transformed = null
		def families = resource.contents
		
		if(!families.isEmpty()) {
			
			def long startTime1 = System.currentTimeMillis()
			transformed = new Families2PersonsJava().transform(families)
			def long endTime1 = System.currentTimeMillis() - startTime1
		
			def long startTime2 = System.currentTimeMillis()
			transformed = new Families2PersonsGroovy().transform(families)
			def long endTime2 = System.currentTimeMillis() - startTime2
			
			def long startTime3 = System.currentTimeMillis()
			transformed = new Families2Persons().transform(families)
			def long endTime3 = System.currentTimeMillis() - startTime3
			
			//Java,Groovy,Xtend
			println(endTime1 + "," + endTime2 + "," + endTime3)
			
			transformed
		} else {
			println("No Tree instance found in model slot")
			return
		}
	}
	
	def static void writeModel(Object contents) {
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		def uri = rs.createResource(URI.createURI(modelBPath))
		def Resource resource = uri
		resource.getContents().addAll(contents)
	
		//TODO set right save thing
//		resource.save(System.out, null);
//		resource.save(null);
	}
	
	def public static void main(String[] args) {
		this.run()
	}
}
