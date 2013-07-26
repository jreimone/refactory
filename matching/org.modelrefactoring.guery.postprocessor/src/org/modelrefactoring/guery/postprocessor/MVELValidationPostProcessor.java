package org.modelrefactoring.guery.postprocessor;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.guery.Constrainable;
import org.modelrefactoring.guery.Constraint;
import org.modelrefactoring.guery.Motif;
import org.modelrefactoring.guery.MotifModel;
import org.modelrefactoring.guery.resource.guery.GueryEProblemType;
import org.modelrefactoring.guery.resource.guery.mopp.GueryResource;
import org.mvel2.MVELInterpretedRuntime;
import org.mvel2.integration.impl.MapVariableResolverFactory;

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
		Map<String, EObject> variables = motif.getContexts().map();
		MapVariableResolverFactory resolverFactory = new MapVariableResolverFactory(variables);
		String expression = constraint.getExpression();
		MVELInterpretedRuntime interpreter = new MVELInterpretedRuntime(expression, null, resolverFactory);
		try {
			interpreter.parse();
		} catch (Exception e) {
			resource.addError(e.getMessage(), GueryEProblemType.SYNTAX_ERROR, constraint);
		}
	}
}
