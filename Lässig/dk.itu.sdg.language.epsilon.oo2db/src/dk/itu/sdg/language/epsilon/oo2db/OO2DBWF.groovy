package dk.itu.sdg.language.epsilon.oo2db

import oo.OO.OOPackage;
import oo.OO.Package;

import org.codehaus.groovy.classgen.ReturnAdder;
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.common.util.URI

import db.DB.DBFactory;
import db.DB.DBPackage;
import db.DB.Database;

class OO2DBWF {
	
	def static modelAPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.language.epsilon.oo2db/input/OOInstance.model"
	def static modelBPath = "/Users/ropf/Documents/eclipse/juno_dresden/dk.itu.sdg.language.epsilon.oo2db/output/DBInstance.model"
	
	def static private ResourceSet rs = new ResourceSetImpl()
	
	def static public void run() {
		OOPackage ooPackageInstance = OOPackage.eINSTANCE;
		DBPackage dbPackageInstance = DBPackage.eINSTANCE;
		
		def resource = readInputModel(modelAPath)
		def db = runTransformer(resource)
		writeModel(db)
		
		//println("TRANSFORMATION IS DONE...")
	}
	
	def static Resource readInputModel(String path) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		
		Resource modelAResource = OO2DBWF.rs.getResource(URI.createFileURI(path),true)
		
		return modelAResource
	}
	
	def static db.DB.Database runTransformer(Resource resource) {
		
		db.DB.Database transformed = null
		if (resource.contents.get(0) instanceof Package) {
			Package p = (Package) resource.contents.get(0);
			
			
			//transformed = new OO2DBGroovy().transform(p);
		
			def long startTime1 = System.currentTimeMillis()
			transformed = new OO2DBJava().transform(p)
			def long endTime1 = System.currentTimeMillis() - startTime1
		
			def long startTime2 = System.currentTimeMillis()
			transformed = new OO2DBGroovy().transform(p)
			def long endTime2 = System.currentTimeMillis() - startTime2
			
			def long startTime3 = System.currentTimeMillis()
			transformed = new OO2DB().transform(p)
			def long endTime3 = System.currentTimeMillis() - startTime3
			
			//Java,Groovy,Xtend
			println(endTime1 + "," + endTime2 + "," + endTime3)
			
			transformed
		} else {
			println("No Package instance found in model slot");
			return;
		}
	}
	
	def static void writeModel(Database db) {
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());		
		def uri = rs.createResource(URI.createURI(modelBPath))
		def Resource resource = uri
		resource.getContents().add(db)
	
		//TODO set right save thing
//		resource.save(System.out, null);
//		resource.save(null);
	}
	
	def public static void main(String[] args) {
		this.run()
	}

}
