package org.modelrefactoring.evolution.coed.postprocessor;

import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.Condition;
import org.modelrefactoring.evolution.coed.PlainCondition;
import org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity;
import org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedProblem;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource;

public class MVELConditionExpressionPostProcessor extends MVELExpressionPostProcessor {

	@Override
	public String getExpression(EObject context) {
		if(context instanceof PlainCondition){
			return ((PlainCondition) context).getCondition();
		}
		return null;
	}

	@Override
	public EObject getContext(CoEvolutionDefinition coed) {
		Condition condition = coed.getCondition();
		if(condition != null && condition instanceof PlainCondition){
			PlainCondition plainCondition = (PlainCondition) condition;
			return plainCondition;
		}
		return null;
	}

	@Override
	public void addParseError(CoedResource resource, EObject context, String errorMessage) {
		if(context instanceof PlainCondition){
			PlainCondition plainCondition = (PlainCondition) context;
			String message = "This condition was parsed by MVEL. The following error occured: " + errorMessage;
			CoedProblem problem = new CoedProblem(message, CoedEProblemType.SYNTAX_ERROR, CoedEProblemSeverity.ERROR);
			int charStart = resource.getLocationMap().getCharStart(plainCondition) + "condition ".length();
			int line = resource.getLocationMap().getLine(plainCondition);
			int column = resource.getLocationMap().getColumn(plainCondition);
			int charEnd = resource.getLocationMap().getCharEnd(plainCondition);
			resource.addProblem(problem, column, line, charStart, charEnd);
		}
	}

}
