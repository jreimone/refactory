package incquerytestplugin;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.osgi.framework.Bundle;

public class LoadPatternHandler extends AbstractHandler {

	private static final String PATTERN_RESOURCE	= "query/incquerytestplugin/jamoppTest.eiq";
	private static final String PATTERN_NAME		= "findToStringMethod";
	private boolean alreadyRegistered;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		registerIncQuery();
		Bundle bundle = Activator.getContext().getBundle();
		URI uri = URI.createPlatformPluginURI(bundle.getSymbolicName() + "/" + PATTERN_RESOURCE, true);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = null;
		try {
			resource = rs.getResource(uri, true);
		} catch (Exception e) {
			// do nothing
		}
		if(resource != null){
			try {
				resource.load(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			EObject model = resource.getContents().get(0);
			if(model instanceof PatternModel){
				PatternModel patternModel = (PatternModel) model;
				Pattern loadedPattern = null;
				for (Pattern pattern : patternModel.getPatterns()) {
					if(pattern.getName().equals(PATTERN_NAME)){
						loadedPattern = pattern;
						break;
					}
				}
				if(loadedPattern != null){
					System.out.println(loadedPattern);
				}
			}
		}
		return null;
	}
	
	private void registerIncQuery() {
		if(!alreadyRegistered){
			new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
			alreadyRegistered = true;
		}
	}

}
