package org.modelrefactoring.incquery;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public final class Util {
	
	public static final String JAVA_PATH 				= "src/org/modelrefactoring/incquery/TestClass.java";
	public static final String IMPORT_PATTERN_PATH		= "query/org/modelrefactoring/incquery/javaImport.eiq";
	public static final String NON_IMPORT_PATTERN_PATH	= "query/org/modelrefactoring/incquery/withoutJavaImport.eiq";

	public static void invokeQuery(Pattern pattern, ResourceSet rs, int expectedMatches) {
		try {
			AdvancedIncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(rs);
			SpecificationBuilder builder = new SpecificationBuilder();
			IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> querySpecification = builder.getOrCreateSpecification(pattern);
			IncQueryMatcher<? extends IPatternMatch> matcher = engine.getMatcher(querySpecification);
			Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
			assertEquals("There must be two matches", expectedMatches, matches.size());
			for (IPatternMatch match : matches) {
				System.out.println(match);
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}
}