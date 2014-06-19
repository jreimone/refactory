package org.modelrefactoring.evolution.coed.postprocessor;

import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource;
import org.mvel2.MVEL;

public abstract class MVELExpressionPostProcessor extends AbstractCoedPostProcessor {

	@Override
	public void process(CoedResource resource, CoEvolutionDefinition coed) {
		EObject context = getContext(coed);
		if(context != null){
			String expression = getExpression(context);
			evaluate(expression, context, resource);
		}
	}

	public abstract String getExpression(EObject context);

	public abstract EObject getContext(CoEvolutionDefinition coed);
	
	public abstract void addParseError(CoedResource resource, EObject context, String errorMessage);

	protected void evaluate(String expression, EObject context, CoedResource resource) {
		if(expression != null){
			try {
				// compilation parses the expression 
				// variables stay unbound until the compiled expression is executed against a context
				// thus, this method is suitable to just check the syntax of the expression
				MVEL.compileExpression(expression);
			} catch (Exception e) {
				// just add an error marker
				addParseError(resource, context, e.getMessage());
			}
		}
	}

}
