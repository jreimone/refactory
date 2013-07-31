package org.modelrefactoring.incquery.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.QuerySpecificationRegistry;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.java.resource.java.util.JavaResourceUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class IncQueryHeadlessTest {

	private static Resource javaResource;
	private static Pattern pattern;

	@BeforeClass
	public static void setUp(){
		initJavaResource();
		initPattern();
	}

	private static void initPattern() {
		// Xtext resource magic -- this is needed for EIQs
//		new EMFPatternLanguageStandaloneSetup()
//		{
//		 @Override
//		 public Injector createInjector() {
//		  return Guice.createInjector(new GeneratorModule());
//		 }
//		}.createInjectorAndDoEMFRegistration();
		File file = new File("src/org/modelrefactoring/incquery/test/query/dataTransmissionWithoutCompression.eiq");
		assertTrue("File must exist", file != null && file.exists());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		assertNotNull("Pattern resource " + file.getAbsolutePath() + " couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("Pattern resource " + file.getAbsolutePath() + " must contain a Pattern", model instanceof PatternModel);
		PatternModel patternModel = (PatternModel) model;
		List<Pattern> patterns = patternModel.getPatterns();
		for (Pattern pattern : patterns) {
			if(pattern.getName().equals("dataTransmissionWithoutCompression")){
				IncQueryHeadlessTest.pattern = pattern;
				break;
			}
		}
	}

	private static void initJavaResource() {
		JaMoPPUtil.initialize();
		File file = new File("src/org/modelrefactoring/incquery/test/model/DataTransmissionWithoutCompression.java");
		assertTrue("File must exist", file != null && file.exists());
		javaResource = JavaResourceUtil.getResource(file);
		ResourceSet rs = javaResource.getResourceSet();
		Set<EObject> findUnresolvedProxies = JavaResourceUtil.findUnresolvedProxies(rs);
		EcoreUtil.resolveAll(rs);
		Set<EObject> findUnresolvedProxies2 = JavaResourceUtil.findUnresolvedProxies(rs);
//		JavaResourceUtil.resolveAll(javaResource);
		assertNotNull("Java resource " + file.getAbsolutePath() + " couldn't be loaded", javaResource);
	}

	@Test
	public void testFindMatchesHeadless(){
		System.out.println("-------------------");
		System.out.println("file: " + javaResource.getURI().toString());
		IQuerySpecification<?> querySpecification = QuerySpecificationRegistry.getOrCreateQuerySpecification(pattern);
		if(querySpecification != null){
			try {
				ResourceSet rs = javaResource.getResourceSet();
				IncQueryEngine engine = IncQueryEngine.on(javaResource);
//				IncQueryEngine engine = IncQueryEngine.on(rs);
				IncQueryMatcher<? extends IPatternMatch> matcher = querySpecification.getMatcher(engine);
				Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
				for (IPatternMatch match : matches) {
					System.out.println(match);
				}
			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		}					
	}

}