package org.modelrefactoring.guery.test;

import static org.junit.Assert.*;

import java.io.File;

import nz.ac.massey.cs.guery.ComputationMode;
import nz.ac.massey.cs.guery.GQL;
import nz.ac.massey.cs.guery.Motif;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.ResultListener;
import nz.ac.massey.cs.guery.impl.MultiThreadedGQLImpl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.modelrefactoring.guery.GueryPackage;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.graph.MetamodelVertex;
import org.modelrefactoring.guery.io.ModelMotifReader;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactory;

public abstract class AbstractSpecificMotifSolvingTestFragment {

	private EPackage metamodel;
	private MotifModel motifModel;
	private RoleModel roleModel;
	
	private ResultListener<MetamodelVertex, EReferenceEdge> converter;
	
	@Before
	public void init(){
		// languages
		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new GueryMetaInformation().getSyntaxName(), new GueryResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		initAdditionalLanguages();
		metamodel = getTargetMetamodel();
		// GUERY file
		EObject model = loadModel(getGUERYFileName());
		assertNotNull("Resource must contain a model", model);
		assertTrue("Model must be a MotifModel", model instanceof MotifModel);
		motifModel = (MotifModel) model;
		// role model
		model = loadModel(getRoleModelFileName());
		assertNotNull("Resource must contain a model", model);
		assertTrue("Model must be a MotifModel", model instanceof RoleModel);
		roleModel = (RoleModel) model;
	}

	@Test
	public void testCountMappings(){
		System.out.println("Querying the " + metamodel.getName() + " metamodel for '" + roleModel.getName() + "'");
		System.out.println("max results: " + getMaxResults());
		ModelMotifReader<MetamodelVertex> reader = new ModelMotifReader<MetamodelVertex>(motifModel.getMotifs().get(0));
		try {
			Motif<MetamodelVertex, EReferenceEdge> motif = reader.read(null);
			ResultListener<MetamodelVertex, EReferenceEdge> listener = getResultListener();
//			int processors = Runtime.getRuntime().availableProcessors();
			int processors = 1;
			GQL<MetamodelVertex, EReferenceEdge> engine = new MultiThreadedGQLImpl<MetamodelVertex, EReferenceEdge>(processors);
			EPackageGraphAdapter graphAdapter = new EPackageGraphAdapter(metamodel);
			engine.query(graphAdapter, motif, listener, ComputationMode.ALL_INSTANCES);
//			int count = converter.getFoundRoleMappingsCount();
//			System.out.println("found role mappings: " + count);
		} catch (MotifReaderException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract String getGUERYFileName();
	
	protected abstract String getRoleModelFileName();
	
	protected abstract int getMaxResults();
	
	protected abstract EPackage getTargetMetamodel();
	
	protected abstract void initAdditionalLanguages();
	
	protected ResultListener<MetamodelVertex, EReferenceEdge> getResultListener() {
		if(converter == null){
			converter = new CountAndPrintResultListener(getRoleModel(), getMaxResults());
		}
		return converter;
	}
	
	private EObject loadModel(String filePath) {
		File file = new File(filePath);
		assertTrue("File " + filePath + " doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull("Resource " + uri.toString() + " couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		return model;
	}
	
	protected RoleModel getRoleModel(){
		return roleModel;
	}
}
