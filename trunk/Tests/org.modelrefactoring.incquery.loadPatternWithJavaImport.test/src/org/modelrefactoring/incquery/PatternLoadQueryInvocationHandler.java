package org.modelrefactoring.incquery;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.modelrefactoring.incquery.fail.PatternWithJavaImportHandler;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public abstract class PatternLoadQueryInvocationHandler extends AbstractHandler {

	public PatternLoadQueryInvocationHandler() {
		super();
	}

	protected abstract String getPatternPath();
	protected abstract int getExpectedMatchesCount();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Pattern pattern = loadPattern();
		Resource javaResource = loadResource(Util.JAVA_PATH);
		ResourceSet rs = javaResource.getResourceSet();
		Util.invokeQuery(pattern, rs, getExpectedMatchesCount());
		return null;
	}

	private Pattern loadPattern() {
		PatternModel patternModel = loadModel(getPatternPath(), PatternModel.class);
		List<Pattern> patterns = patternModel.getPatterns();
		assert patterns.size() == 1;
		Pattern pattern = patterns.get(0);
		assert pattern != null;
		return pattern;
	}

	private <T extends EObject> T loadModel(String pluginRelativePath, Class<T> expectedClass) {
		Resource resource = loadResource(pluginRelativePath);
		List<EObject> contents = resource.getContents();
		assert contents.size() > 0;
		EObject model = contents.get(0);
		assert expectedClass.isInstance(model);
		return expectedClass.cast(model);
	}

	private Resource loadResource(String pluginRelativePath) {
		Bundle bundle = FrameworkUtil.getBundle(PatternWithJavaImportHandler.class);
		String pluginId = bundle.getSymbolicName();
		URI uri = URI.createPlatformPluginURI(pluginId + "/" + pluginRelativePath, true);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = null;
		try {
			resource = rs.getResource(uri, true);
		} catch (Exception e) {
			// do nothing
		}
		assert resource != null;
		return resource;
	}

}