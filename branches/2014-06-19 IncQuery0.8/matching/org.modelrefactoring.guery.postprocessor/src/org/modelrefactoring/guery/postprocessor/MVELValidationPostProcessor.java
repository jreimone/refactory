package org.modelrefactoring.guery.postprocessor;

import java.util.List;

import org.modelrefactoring.guery.Constrainable;
import org.modelrefactoring.guery.Constraint;
import org.modelrefactoring.guery.Motif;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.resource.guery.GueryEProblemType;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResource;
import org.mvel2.MVEL;

public class MVELValidationPostProcessor extends AbstractGueryPostProcessor {

	@Override
	public void process(GueryResource resource, MotifModel model) {
		List<Motif> motifs = model.getMotifs();
		for (Motif motif : motifs) {
			List<Constrainable> constrainables = motif.getConstrainables();
			for (Constrainable constrainable : constrainables) {
				for (Constraint constraint : constrainable.getConstraints()) {
					validateConstraint(resource, constraint, motif);
				}
			}
		}
	}

	private void validateConstraint(GueryResource resource, Constraint constraint, Motif motif) {
//		Map<String, EObject> variables = motif.getContexts().map();
//		MapVariableResolverFactory resolverFactory = new MapVariableResolverFactory(variables);
		String expression = constraint.getExpression();
		try {
			MVEL.compileExpression(expression);
		} catch (Exception e) {
			String message = "This string is parsed by MVEL. The following error occured:\n\n" + e.getMessage();
			resource.addError(message, GueryEProblemType.SYNTAX_ERROR, constraint);
		}
	}
}
