package org.modelrefactoring.evolution.coed.postprocessor;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.modelrefactoring.evolution.coed.Action;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.RoleMappingAction;
import org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity;
import org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedProblem;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource;

public class MVELActionExpressionPostProcessor extends MVELExpressionPostProcessor {

	@Override
	public String getExpression(EObject context) {
		if(context instanceof RoleMappingAction){
			RoleMappingAction roleMappingAction = (RoleMappingAction) context;
			return roleMappingAction.getBinding();
		}
		return null;
	}

	@Override
	public EObject getContext(CoEvolutionDefinition coed) {
		Action action = coed.getAction();
		if(action != null && action instanceof RoleMappingAction){
			RoleMappingAction roleMappingAction = (RoleMappingAction) action;
			return roleMappingAction;
		}
		return null;
	}

	@Override
	public void addParseError(CoedResource resource, EObject context, String errorMessage) {
		if(context instanceof RoleMappingAction){
			RoleMappingAction roleMappingAction = (RoleMappingAction) context;
			String message = "This action was parsed by MVEL. The following error occured: " + errorMessage;
			resource.addError(message, CoedEProblemType.SYNTAX_ERROR, roleMappingAction);
			// following does not work since the concreteRefactoring is only a proxy in the location map 
//			CoedProblem problem = new CoedProblem(message, CoedEProblemType.SYNTAX_ERROR, CoedEProblemSeverity.ERROR);
//			RoleMapping concreteRefactoring = roleMappingAction.getConcreteRefactoring();
//			int charStart = resource.getLocationMap().getCharEnd(concreteRefactoring);
//			int line = resource.getLocationMap().getLine(concreteRefactoring);
//			int column = resource.getLocationMap().getColumn(concreteRefactoring);
//			int charEnd = resource.getLocationMap().getCharEnd(roleMappingAction);
//			resource.addProblem(problem, column, line, charStart, charEnd);
		}
	}

}
