/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.util;

public abstract class AbstractRefspecInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		boolean goAhead = true;
		while (goAhead && !interpretationStack.empty()) {
			org.eclipse.emf.ecore.EObject next = interpretationStack.pop();
			result = interprete(next, context);
			goAhead = continueInterpretation(result);
		}
		return result;
	}
	
	protected abstract boolean continueInterpretation(ResultType result);
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.PATH) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_PATH((org.emftext.language.refactoring.refactoring_specification.PATH) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.UPDATE) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE((org.emftext.language.refactoring.refactoring_specification.UPDATE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.AdditionalCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand((org.emftext.language.refactoring.refactoring_specification.AdditionalCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.VariableAssignment) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment((org.emftext.language.refactoring.refactoring_specification.VariableAssignment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.TraceObject) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_TraceObject((org.emftext.language.refactoring.refactoring_specification.TraceObject) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.TRACE) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_TRACE((org.emftext.language.refactoring.refactoring_specification.TRACE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableDeclarationCommand((org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand((org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.LAST) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_LAST((org.emftext.language.refactoring.refactoring_specification.LAST) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.FIRST) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_FIRST((org.emftext.language.refactoring.refactoring_specification.FIRST) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectReferenceAssignment((org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ConcreteIndex) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex((org.emftext.language.refactoring.refactoring_specification.ConcreteIndex) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.IndexVariable) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable((org.emftext.language.refactoring.refactoring_specification.IndexVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand((org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.Context) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_Context((org.emftext.language.refactoring.refactoring_specification.Context) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ConstantsReference) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference((org.emftext.language.refactoring.refactoring_specification.ConstantsReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.FromReference) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_FromReference((org.emftext.language.refactoring.refactoring_specification.FromReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.UPTREE) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE((org.emftext.language.refactoring.refactoring_specification.UPTREE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.FromOperator) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator((org.emftext.language.refactoring.refactoring_specification.FromOperator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.FromClause) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_FromClause((org.emftext.language.refactoring.refactoring_specification.FromClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ASSIGN) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN((org.emftext.language.refactoring.refactoring_specification.ASSIGN) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.AttributeCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_AttributeCommand((org.emftext.language.refactoring.refactoring_specification.AttributeCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.SET) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_SET((org.emftext.language.refactoring.refactoring_specification.SET) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ReferenceCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ReferenceCommand((org.emftext.language.refactoring.refactoring_specification.ReferenceCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.VariableReference) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference((org.emftext.language.refactoring.refactoring_specification.VariableReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.TargetContext) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext((org.emftext.language.refactoring.refactoring_specification.TargetContext) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.RelationReference) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference((org.emftext.language.refactoring.refactoring_specification.RelationReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.RoleReference) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference((org.emftext.language.refactoring.refactoring_specification.RoleReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.SourceContext) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext((org.emftext.language.refactoring.refactoring_specification.SourceContext) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.Variable) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_Variable((org.emftext.language.refactoring.refactoring_specification.Variable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.MOVE) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_MOVE((org.emftext.language.refactoring.refactoring_specification.MOVE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.CREATE) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_CREATE((org.emftext.language.refactoring.refactoring_specification.CREATE) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.ContainmentCommand) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_ContainmentCommand((org.emftext.language.refactoring.refactoring_specification.ContainmentCommand) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.Instruction) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_Instruction((org.emftext.language.refactoring.refactoring_specification.Instruction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) {
			result = interprete_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification((org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_Instruction(org.emftext.language.refactoring.refactoring_specification.Instruction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ContainmentCommand(org.emftext.language.refactoring.refactoring_specification.ContainmentCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_Variable(org.emftext.language.refactoring.refactoring_specification.Variable object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference(org.emftext.language.refactoring.refactoring_specification.VariableReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_SourceContext(org.emftext.language.refactoring.refactoring_specification.SourceContext object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference(org.emftext.language.refactoring.refactoring_specification.RoleReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference(org.emftext.language.refactoring.refactoring_specification.RelationReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_TargetContext(org.emftext.language.refactoring.refactoring_specification.TargetContext object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ReferenceCommand(org.emftext.language.refactoring.refactoring_specification.ReferenceCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_SET(org.emftext.language.refactoring.refactoring_specification.SET object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_AttributeCommand(org.emftext.language.refactoring.refactoring_specification.AttributeCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN(org.emftext.language.refactoring.refactoring_specification.ASSIGN object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_FromClause(org.emftext.language.refactoring.refactoring_specification.FromClause object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_FromOperator(org.emftext.language.refactoring.refactoring_specification.FromOperator object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE(org.emftext.language.refactoring.refactoring_specification.UPTREE object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference(org.emftext.language.refactoring.refactoring_specification.ConstantsReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_FromReference(org.emftext.language.refactoring.refactoring_specification.FromReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_Context(org.emftext.language.refactoring.refactoring_specification.Context object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexAssignmentCommand(org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable(org.emftext.language.refactoring.refactoring_specification.IndexVariable object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex(org.emftext.language.refactoring.refactoring_specification.ConcreteIndex object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_FIRST(org.emftext.language.refactoring.refactoring_specification.FIRST object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_LAST(org.emftext.language.refactoring.refactoring_specification.LAST object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectReferenceAssignment(org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_ObjectAssignmentCommand(org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableDeclarationCommand(org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_TRACE(org.emftext.language.refactoring.refactoring_specification.TRACE object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_TraceObject(org.emftext.language.refactoring.refactoring_specification.TraceObject object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment(org.emftext.language.refactoring.refactoring_specification.VariableAssignment object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_AdditionalCommand(org.emftext.language.refactoring.refactoring_specification.AdditionalCommand object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE(org.emftext.language.refactoring.refactoring_specification.UPDATE object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_refactoring_refactoring_005fspecification_PATH(org.emftext.language.refactoring.refactoring_specification.PATH object, ContextType context) {
		return null;
	}
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}
