package org.qualitune.guery.postprocessor;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.mvel2.MVELInterpretedRuntime;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.qualitune.guery.Constrainable;
import org.qualitune.guery.Constraint;
import org.qualitune.guery.Motif;
import org.qualitune.guery.MotifModel;
import org.qualitune.guery.resource.guery.GueryEProblemType;
import org.qualitune.guery.resource.guery.mopp.GueryResource;

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
		Object result = null;
		try {
			result = interpreter.parse();
			if(result instanceof Boolean && !(Boolean) result){
				resource.addError("The constraint could not be parsed correctly." +
						"\nUsually, a navigation expression starting from a variable expression is the cause."
						, GueryEProblemType.ANALYSIS_PROBLEM
						, constraint);
			}
		} catch (Exception e) {
			resource.addError(e.getMessage(), GueryEProblemType.SYNTAX_ERROR, constraint);
		}
	}
}
