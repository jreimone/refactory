package org.modelrefactoring.sirius.fail;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

public class StartUpProcessor {

	@Execute
	public void startUp(){
		URI uri = URI.createPlatformPluginURI("/org.modelrefactoring.sirius.fail/fragment.e4xmi", true);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		assert resource != null;
		EObject root = resource.getContents().get(0);
		ModelValidationService service = ModelValidationService.getInstance();
		IBatchValidator validator = service.<EObject, IBatchValidator>newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(false);
		IStatus status = validator.validate(root);
		assert status != null;
	}
}
