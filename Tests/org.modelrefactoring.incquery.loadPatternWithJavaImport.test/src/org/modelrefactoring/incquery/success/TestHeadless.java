package org.modelrefactoring.incquery.success;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.resource.JaMoPPUtil;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.resource.java.util.JavaResourceUtil;
import org.junit.Before;
import org.junit.Test;
import org.modelrefactoring.incquery.Util;

public class TestHeadless {

	private JavaResource javaResource;
	private Pattern pattern;

	@Test
	public void testPatternWithJavaImport(){
		ResourceSet rs = javaResource.getResourceSet();
		Util.invokeQuery(pattern, rs, 2);
	}

	@Before
	public void init(){
		initLanguages();
		initJavaResource();
		initPattern();
	}

	private void initPattern() {
		File file = getFile(Util.IMPORT_PATTERN_PATH);
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assertNotNull("Pattern resource " + file.getAbsolutePath() + " couldn't be loaded", resource);
		EObject model = resource.getContents().get(0);
		assertTrue("Pattern resource " + file.getAbsolutePath() + " must contain a Pattern", model instanceof PatternModel);
		PatternModel patternModel = (PatternModel) model;
		List<Pattern> patterns = patternModel.getPatterns();
		assertTrue("Pattern model must only contain one pattern", patterns.size() == 1);
		pattern = patterns.get(0);
	}

	private void initJavaResource() {
		File file = getFile(Util.JAVA_PATH);
		javaResource = JavaResourceUtil.getResource(file.getAbsoluteFile());
		assertNotNull("Resource mustn't be null", javaResource);
		ResourceSet rs = javaResource.getResourceSet();
		JavaClasspath classpath = JavaClasspath.get(rs);
		classpath.registerStdLib();
	}

	private File getFile(String filePath) {
		File file = new File(filePath);
		assertTrue("File must exist", file != null && file.exists());
		return file;
	}

	private void initLanguages() {
		new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		JaMoPPUtil.initialize();
	}
}
