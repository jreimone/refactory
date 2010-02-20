/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.util;

public class AbstractRefspecInterpreter<ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	public boolean interprete(ContextType context) {
		while (!interpretationStack.empty()) {
			org.eclipse.emf.ecore.EObject next = interpretationStack.pop();
			doSwitch(next, context);
		}
		return false;
	}
	
	public boolean doSwitch(org.eclipse.emf.ecore.EObject object, ContextType context) {
		boolean didInterprete = false;
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.RelationReference) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference((org.emftext.language.refactoring.refactoring_specification.RelationReference) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.RoleReference) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference((org.emftext.language.refactoring.refactoring_specification.RoleReference) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.VariableReference) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference((org.emftext.language.refactoring.refactoring_specification.VariableReference) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.TargetContext) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext((org.emftext.language.refactoring.refactoring_specification.TargetContext) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.SourceContext) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext((org.emftext.language.refactoring.refactoring_specification.SourceContext) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.Variable) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_Variable((org.emftext.language.refactoring.refactoring_specification.Variable) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.MOVE) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE((org.emftext.language.refactoring.refactoring_specification.MOVE) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.CREATE) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE((org.emftext.language.refactoring.refactoring_specification.CREATE) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.PrimitiveCommand) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_PrimitiveCommand((org.emftext.language.refactoring.refactoring_specification.PrimitiveCommand) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.Instruction) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction((org.emftext.language.refactoring.refactoring_specification.Instruction) object, context);
		}
		if (didInterprete) {
			return true;
		}
		if (object instanceof org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) {
			didInterprete = interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification((org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) object, context);
		}
		if (didInterprete) {
			return true;
		}
		return didInterprete;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RefactoringSpecification(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_Instruction(org.emftext.language.refactoring.refactoring_specification.Instruction object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_PrimitiveCommand(org.emftext.language.refactoring.refactoring_specification.PrimitiveCommand object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_Variable(org.emftext.language.refactoring.refactoring_specification.Variable object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_VariableReference(org.emftext.language.refactoring.refactoring_specification.VariableReference object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_SourceContext(org.emftext.language.refactoring.refactoring_specification.SourceContext object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RoleReference(org.emftext.language.refactoring.refactoring_specification.RoleReference object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_RelationReference(org.emftext.language.refactoring.refactoring_specification.RelationReference object, ContextType context) {
		return false;
	}
	
	public boolean interprete_org_emftext_language_refactoring_refactoring_005Fspecification_TargetContext(org.emftext.language.refactoring.refactoring_specification.TargetContext object, ContextType context) {
		return false;
	}
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}
