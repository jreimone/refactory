package org.modelrefactoring.guery.test;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import nz.ac.massey.cs.guery.Constraint;
import nz.ac.massey.cs.guery.GroupByClause;
import nz.ac.massey.cs.guery.MotifReader;
import nz.ac.massey.cs.guery.MotifReaderException;
import nz.ac.massey.cs.guery.PathConstraint;
import nz.ac.massey.cs.guery.Processor;
import nz.ac.massey.cs.guery.PropertyConstraint;
import nz.ac.massey.cs.guery.io.dsl.DefaultMotifReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelrefactoring.guery.GueryPackage;
import org.modelrefactoring.guery.Motif;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.graph.EObjectVertex;
import org.modelrefactoring.guery.graph.EReferenceEdge;
import org.modelrefactoring.guery.io.ModelMotifReader;
import org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResourceFactory;

public class MotifAdapterTest {

	@BeforeClass
	public static void init(){
		EPackage.Registry.INSTANCE.put(GueryPackage.eNS_URI, GueryPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new GueryMetaInformation().getSyntaxName(), new GueryResourceFactory());
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, RolesPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new RolestextMetaInformation().getSyntaxName(), new RolestextResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}

	@Test
	public void testQuery1(){
		testQuery("queries/query1.guery");
	}
	
	@Test
	public void testQuery2(){
		testQuery("queries/query2.guery");
	}
	
	@Test
	public void testQuery3(){
		testQuery("queries/query3.guery");
	}
	
	@Test
	public void testQuery4(){
		testQuery("queries/query4.guery");
	}
	
	@Test
	public void testQuery5(){
		testQuery("queries/query5.guery");
	}
	
	@Test
	public void testExtractXwithReferenceClass(){
		testQuery("queries/ExtractXwithReferenceClass0.guery");
	}
	
	private void testQuery(String path){
		nz.ac.massey.cs.guery.Motif<EObjectVertex, EReferenceEdge> motifByModel = getMotifByModel(path);
		nz.ac.massey.cs.guery.Motif<EObjectVertex, EReferenceEdge> motifByGuery = getMotifByGuery(path);
		compare(motifByModel, motifByGuery);
	}
	
	private void compare(nz.ac.massey.cs.guery.Motif<EObjectVertex, EReferenceEdge> motifByModel, nz.ac.massey.cs.guery.Motif<EObjectVertex, EReferenceEdge> motifByGuery) {
		// compare name
		assertEquals("Names must be equal", motifByGuery.getName(), motifByModel.getName());
		// compare roles
		List<String> gueryRoles = motifByGuery.getRoles();
		List<String> roles = motifByModel.getRoles();
		assertEquals("Roles must be equal", gueryRoles, roles);
		// compare path roles
		List<String> gueryPathRoles = motifByGuery.getPathRoles();
		List<String> pathRoles = motifByModel.getPathRoles();
		assertEquals("Path Roles must be equal", gueryPathRoles, pathRoles);
		// compare negated path roles
		List<String> gueryNegatedPathRoles = motifByGuery.getNegatedPathRoles();
		List<String> negatedPathRoles = motifByModel.getNegatedPathRoles();
		assertEquals("Path Roles must be equal", gueryNegatedPathRoles, negatedPathRoles);
		// compare constraints
		List<Constraint> gueryConstraints = motifByGuery.getConstraints();
		List<Constraint> constraints = motifByModel.getConstraints();
		compareConstraints(gueryConstraints, constraints);
		// compare group by
		Collection<GroupByClause<EObjectVertex>> gueryGroupByClauses = motifByGuery.getGroupByClauses();
		Collection<GroupByClause<EObjectVertex>> groupByClauses = motifByModel.getGroupByClauses();
		compareGroupByClauses(gueryGroupByClauses, groupByClauses);
		// compare preprocessors
		Collection<Processor<EObjectVertex,EReferenceEdge>> gueryGraphProcessors = motifByGuery.getGraphProcessors();
		Collection<Processor<EObjectVertex,EReferenceEdge>> graphProcessors = motifByModel.getGraphProcessors();
		compareProcessors(gueryGraphProcessors, graphProcessors);
	}

	private void compareProcessors(Collection<Processor<EObjectVertex, EReferenceEdge>> gueryGraphProcessors, Collection<Processor<EObjectVertex, EReferenceEdge>> graphProcessors) {
		assertEquals("Processor count must be equal", gueryGraphProcessors.size(), graphProcessors.size());
		Processor<?, ?>[] gueryArray = gueryGraphProcessors.toArray(new Processor<?, ?>[0]);
		Processor<?, ?>[] array = graphProcessors.toArray(new Processor<?, ?>[0]);
		for (int i = 0; i < gueryArray.length; i++) {
			Processor<?, ?> gueryProcessor = gueryArray[i];
			Processor<?, ?> processor = array[i];
			assertEquals("Processor count must be equal", gueryProcessor.getClass(), processor.getClass());
		}
	}

	private void compareGroupByClauses(Collection<GroupByClause<EObjectVertex>> gueryGroupByClauses, Collection<GroupByClause<EObjectVertex>> groupByClauses) {
		assertEquals("GroupBy clause count must be equal", gueryGroupByClauses.size(), groupByClauses.size());
		GroupByClause<?>[] gueryArray = gueryGroupByClauses.toArray(new GroupByClause<?>[0]);
		GroupByClause<?>[] array = groupByClauses.toArray(new GroupByClause<?>[0]);
		for (int i = 0; i < gueryArray.length; i++) {
			GroupByClause<?> gueryGroupByClause = gueryArray[i];
			GroupByClause<?> groupByClause = array[i];
			assertEquals("Role of GroupByClause must be equal", gueryGroupByClause.getRole(), groupByClause.getRole());
			assertEquals("Expression of GroupByClause must be equal", gueryGroupByClause.getExpression(), groupByClause.getExpression());
		}
	}

	private void compareConstraints(List<? extends Constraint> gueryConstraints, List<? extends Constraint> constraints) {
		assertEquals("Constraint count must be equal", gueryConstraints.size(), constraints.size());
		for (Constraint gueryConstraint : gueryConstraints) {
			Constraint constraint = constraints.get(gueryConstraints.indexOf(gueryConstraint));
			if(gueryConstraint instanceof PathConstraint<?, ?>){
				assertTrue("Constraint '" + constraint + "' (determined from DSL) must be an instance of " + PathConstraint.class.getSimpleName(), constraint instanceof PathConstraint<?, ?>);
				PathConstraint<?, ?> gueryPathConstraint = (PathConstraint<?, ?>) gueryConstraint;
				PathConstraint<?, ?> pathConstraint = (PathConstraint<?, ?>) constraint;
				assertEquals("Role of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.getRole(), pathConstraint.getRole());
				assertEquals("Source of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.getSource(), pathConstraint.getSource());
				assertEquals("Target of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.getTarget(), pathConstraint.getTarget());
				assertEquals("Min length of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.getMinLength(), pathConstraint.getMinLength());
				assertEquals("Max length of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.getMaxLength(), pathConstraint.getMaxLength());
				assertEquals("ComputeAll of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.isComputeAll(), pathConstraint.isComputeAll());
				assertEquals("IsNegated of path constraint '" + pathConstraint + "' must be the same", gueryPathConstraint.isNegated(), pathConstraint.isNegated());
				List<PropertyConstraint> gueryConstraintsForGueryPathConstraint = gueryPathConstraint.getConstraints();
				List<PropertyConstraint> constraintsForPathConstraint = pathConstraint.getConstraints();
				compareConstraints(gueryConstraintsForGueryPathConstraint, constraintsForPathConstraint);
			} else if(gueryConstraint instanceof PropertyConstraint){
				assertTrue("Constraint '" + constraint + "' (determined from DSL) must be an instance of " + PropertyConstraint.class.getSimpleName(), constraint instanceof PropertyConstraint);
				PropertyConstraint gueryPropertyConstraint = (PropertyConstraint) gueryConstraint;
				PropertyConstraint propertyConstraint = (PropertyConstraint) constraint;
				assertEquals("Expression of property constraint '" + propertyConstraint + "' must be the same", gueryPropertyConstraint.getExpression(), propertyConstraint.getExpression());
				assertEquals("Used role names of property constraint '" + propertyConstraint + "' must be the same", gueryPropertyConstraint.getRoles(), propertyConstraint.getRoles());
			}
		}
	}

	protected <Vertex extends EObjectVertex> nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> getMotifByModel(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		EObject model = resource.getContents().get(0);
		assertTrue("Given model must be an instance of MotifModel", model instanceof MotifModel);
		Motif motif = ((MotifModel) model).getMotifs().get(0);
		ModelMotifReader<Vertex> reader = new ModelMotifReader<Vertex>(motif);
		nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> gueryMotif;
		try {
			gueryMotif = reader.read(null);
			return gueryMotif;
		} catch (MotifReaderException e) {
			e.printStackTrace();
			fail("MotifRead threw exception");
		}
		return null;
	}

	protected <Vertex extends EObjectVertex> nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> getMotifByGuery(String path){
		File file = new File(path);
		assertTrue("File '" + path + "' doesn't exist", file.exists());
		try {
			FileInputStream stream = new FileInputStream(file);
			MotifReader<Vertex, EReferenceEdge> reader = new DefaultMotifReader<Vertex, EReferenceEdge>();
			nz.ac.massey.cs.guery.Motif<Vertex, EReferenceEdge> motif = reader.read(stream);
			return motif;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("File '" + path + "' wasn't found");
		} catch (MotifReaderException e) {
			e.printStackTrace();
			fail(path + " couldn't be parsed: " + e.getLocalizedMessage());
		}
		return null;
	}
}
