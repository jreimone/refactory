/**
 * 
 */
package org.emftext.refactoring.matching;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.pl0.PL0Package;
import org.junit.Test;
import org.qualitune.evolution.guery.graph.MetamodelVertex;
import org.qualitune.evolution.guery.registry.EReferenceEdge;
import org.qualitune.guery.GueryPackage;

/**
 * @author jreimann
 *
 */
public class SolverTest {
	
	@Test
	public void testSolver() {
		// TODO Auto-generated method stub
//		loadMotifs();
//		SolvingMotif sm=new SolvingMotif(loadMotifs(), );
		
//		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
//		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
//		extensionToFactoryMap.put("rolestext", new RolestextResourceFactory());
//		extensionToFactoryMap.put("guery", new GueryResourceFactory());
//		
////		assertTrue(sourceFile.exists());
////		System.out.println(sourceFile.getAbsolutePath());
//		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
//		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource resource = resourceSet.getResource(uri, true);
//		EObject model = resource.getContents().get(0);
//		RoleModel rolemodel = (RoleModel) model;
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		String path = "../org.emftext.language.pl0/metamodel/pl0.ecore";
		File file = new File(path);
//		assertTrue(file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		Resource resource = PL0Package.eINSTANCE.eResource();
//		Resource pl0MM = resourceSet.getResource(uri, true);
		SolvingMotif solver = new SolvingMotif(loadMotifs(), resource);
		solver.findMotifInstances();
		
		
//		URI fileURI=URI.createFileURI("C:\\Users\\Robert\\gbswt\\org.emftext.refactoring.matching\\src\\org\\emftext\\refactoring\\matching\\Conversion.java");
//		Resource r=resourceSet.createResource(fileURI);
//		Resource res=resourceSet.createResource(URI.createURI(GueryPackage.eNS_URI));
//		Resource resource = resourceSet.createResource(URI.createURI("http:///My.guery"));
//		SolvingMotif sm=new SolvingMotif(loadMotifs(), r);
//		
//		sm.findMotifInstances();
	}
	
	private static Motif<MetamodelVertex,EReferenceEdge> loadMotifs(){
		InputStream in=null;
		try {
			in = new FileInputStream("ExtractXwithReferenceClass.guery");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		MotifReader<MetamodelVertex,EReferenceEdge> reader = new DefaultMotifReader<MetamodelVertex,EReferenceEdge>();
		Motif<MetamodelVertex,EReferenceEdge> motif=null;
		try {
			motif = reader.read(in);
		} catch (MotifReaderException e) {
			e.printStackTrace();
		}
		
		return motif;
	}
}
