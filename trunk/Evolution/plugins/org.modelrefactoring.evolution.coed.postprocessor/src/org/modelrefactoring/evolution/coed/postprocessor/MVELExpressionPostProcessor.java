package org.modelrefactoring.evolution.coed.postprocessor;

import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.Condition;
import org.modelrefactoring.evolution.coed.PlainCondition;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource;
import org.mvel2.MVEL;

public class MVELExpressionPostProcessor extends AbstractCoedPostProcessor {

	@Override
	public void process(CoedResource resource, CoEvolutionDefinition coed) {
		Condition condition = coed.getCondition();
		if(condition instanceof PlainCondition){
			PlainCondition plainCondition = (PlainCondition) condition;
			evaluate(plainCondition.getCondition(), condition, resource);
		} 
		Action action = coed.getAction();
		if(action instanceof RoleMappingAction){
			RoleMappingAction roleMappingAction = (RoleMappingAction) action;
			evaluate(roleMappingAction.getBinding(), roleMappingAction, resource);
		}
	}

	private void evaluate(String expression, EObject context, CoedResource resource) {
		try {
			// compilation parses the expression 
			// variables stay unbound until the compiled expression is executed against a context
			// thus, this method is suitable to just check the syntax of the expression
			MVEL.compileExpression(expression);
		} catch (Exception e) {
			// just add an error marker
			String message = "This expression was parsed by MVEL. The following error occured:\n\n" + e.getMessage();
			resource.addError(message, CoedEProblemType.SYNTAX_ERROR, context);
		}
	}
}
