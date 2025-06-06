package org.modelrefactoring.incquery.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.java.resource.java.util.JavaResourceUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class IncQueryHeadlessTest {

	private static Resource javaResource;
	private static Pattern pattern;

	@Test
	public void testFindMatchesHeadless(){
		System.out.println("-------------------");
		System.out.println("file: " + javaResource.getURI().toString());
		try {
			ResourceSet rs = javaResource.getResourceSet();
			//			incQueryOld(rs);
			incQueryNew(rs);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	//	private void incQueryOld(ResourceSet rs) throws IncQueryException {
	//		IQuerySpecification<?> querySpecification = QuerySpecificationRegistry.getOrCreateQuerySpecification(pattern);
	//		if(querySpecification != null){
	//			IncQueryEngine engine = IncQueryEngine.on(rs);
	//			IncQueryMatcher<? extends IPatternMatch> matcher = querySpecification.getMatcher(engine);
	//			if (matcher!=null) {
	//				Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
	//				assertEquals("", 2, matches.size());
	//				for (IPatternMatch match : matches) {
	//					System.out.println(match);
	//				}
	//			}
	//		}
	//	}

	// taken from here:
	// https://wiki.eclipse.org/EMFIncQuery/UserDocumentation/API/Advanced#The_IncQuery_Generic_API
	private void incQueryNew(ResourceSet rs) throws IncQueryException {
		//		IncQueryEngine engine = IncQueryEngine.on(rs);
		// get all matches of the pattern
		// create an *unmanaged* engine to ensure that noone else is going
		// to use our engine
		AdvancedIncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(rs);
		// A specification builder is used to translate patterns to query specifications
		SpecificationBuilder builder = new SpecificationBuilder();
		// attempt to retrieve a registered query specification		    
		IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> querySpecification = builder.getOrCreateSpecification(pattern);
		IncQueryMatcher<? extends IPatternMatch> matcher = engine.getMatcher(querySpecification);
		Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
		assertEquals("", 2, matches.size());
		for (IPatternMatch match : matches) {
			System.out.println(match);
		}
	}

	@BeforeClass
	public static void setUp(){
		initLanguages();
		initJavaResource();
		initPattern();
	}

	private static void initLanguages() {
		// Initializing Xtext-based resource parser
		// Do not use if EMF-IncQuery tooling is loaded!
		new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		JaMoPPUtil.initialize();
	}

	private static void initPattern() {
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
		File file = new File("src/org/modelrefactoring/incquery/test/model/DataTransmissionWithoutCompression.java");
		assertTrue("File must exist", file != null && file.exists());
		javaResource = JavaResourceUtil.getResource(file);
		ResourceSet rs = javaResource.getResourceSet();

		////////// this is adapted from JaMoPPC
		File root = new File(".");
		List<File> allJars = collectJars(root);
		JavaClasspath classpath = JavaClasspath.get(rs);
		classpath.registerStdLib();
		// register jar files
		for (File jarFile : allJars) {
			if (!jarFile.exists()) {
				System.out.println("not found: " + jarFile);
				return;
			}
			try {
				System.out.println("Registering JAR " + jarFile.getCanonicalPath());
				classpath.registerClassifierJar(URI.createFileURI(jarFile.getCanonicalPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		loadAllFilesInResourceSet(rs, file.getParentFile(), ".java");
		if (!resolveAllProxies(rs, 0)) {
			System.err.println("Resolution of some Proxies failed...");
			Iterator<Notifier> it = rs.getAllContents();
			while (it.hasNext()) {
				Notifier next = it.next();
				if (next instanceof EObject) {
					EObject o = (EObject) next;
					if (o.eIsProxy()) {
						try {
							it.remove();
						} catch (UnsupportedOperationException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		//////////this is adapted from JaMoPPC -- till here
		assertNotNull("Java resource " + file.getAbsolutePath() + " couldn't be loaded", javaResource);
	}

	private static List<File> collectJars(File root) {
		List<File> jarFiles = new ArrayList<File>();
		File[] files = root.listFiles();
		for (File file : files) {
			if(file.isFile() && file.getName().endsWith(".jar")){
				jarFiles.add(file);
				continue;
			}
			if(file.isDirectory()){
				jarFiles.addAll(collectJars(file));
			}
		}
		return jarFiles; 
	}

	//###################### the following is copied from JaMoPPC ######################################

	private static void loadAllFilesInResourceSet(ResourceSet rs, File startFolder, String extension) {
		for (File member : startFolder.listFiles()) {
			if (member.isFile()) {
				if (member.getName().endsWith(extension)) {
					System.out.println("Parsing " + member);
					parseResource(rs, member);
				} else {
					System.out.println("Skipping " + member);
				}
			}
			if (member.isDirectory()) {
				if (!member.getName().startsWith(".")) {
					System.out.println("Recursing into " + member);
					loadAllFilesInResourceSet(rs, member, extension);
				} else {
					System.out.println("Skipping " + member);
				}
			}
		}
	}

	private static void parseResource(ResourceSet rs, File file) {
		try {
			loadResource(rs, file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadResource(ResourceSet rs, String filePath) {
		loadResource(rs, URI.createFileURI(filePath));
	}

	private static void loadResource(ResourceSet rs, URI uri) {
		rs.getResource(uri, true);
	}

	protected static boolean resolveAllProxies(ResourceSet rs, int resourcesProcessedBefore) {
		boolean failure = false;
		List<EObject> eobjects = new LinkedList<EObject>();
		for (Iterator<Notifier> i = rs.getAllContents(); i.hasNext();) {
			Notifier next = i.next();
			if (next instanceof EObject) {
				eobjects.add((EObject) next);
			}
		}
		int resourcesProcessed = rs.getResources().size();
		if (resourcesProcessed == resourcesProcessedBefore) {
			return true;
		}

		System.out.println("Resolving cross-references of " + eobjects.size()
				+ " EObjects.");
		int resolved = 0;
		int notResolved = 0;
		int eobjectCnt = 0;
		for (EObject next : eobjects) {
			eobjectCnt++;
			if (eobjectCnt % 1000 == 0) {
				System.out.println(eobjectCnt + "/" + eobjects.size()
						+ " done: Resolved " + resolved + " crossrefs, "
						+ notResolved + " crossrefs could not be resolved.");
			}

			InternalEObject nextElement = (InternalEObject) next;
			for (EObject crElement : nextElement.eCrossReferences()) {
				crElement = EcoreUtil.resolve(crElement, rs);
				if (crElement.eIsProxy()) {
					failure = true;
					notResolved++;
					System.out
					.println("Can not find referenced element in classpath: "
							+ ((InternalEObject) crElement).eProxyURI());
				} else {
					resolved++;
				}
			}
		}

		System.out.println(eobjectCnt + "/" + eobjects.size()
				+ " done: Resolved " + resolved + " crossrefs, " + notResolved
				+ " crossrefs could not be resolved.");

		//call this method again, because the resolving might have triggered loading
		//of additional resources that may also contain references that need to be resolved.
		return !failure && resolveAllProxies(rs, resourcesProcessed);
	}
}