/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.MOVE;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.refactoring_specification.SourceContext;
import org.emftext.language.refactoring.refactoring_specification.TargetContext;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;

/**
 * @author Jan Reimann
 *
 */
public class MOVEInterpreter {

	private RefactoringInterpreterContext context;
	private Mapping mapping;
	private List<? extends EObject> selection;
	
	public MOVEInterpreter(Mapping mapping) {
		super();
		this.mapping = mapping;
	}

	public Boolean interpreteMOVE(MOVE object, RefactoringInterpreterContext context, List<? extends EObject> selection) {
		this.context = context;
		SourceContext sourceContext = object.getSource();
		List<? extends EObject> sourceObjects = null;
		if(sourceContext instanceof RelationReference){
			MultiplicityRelation relation = ((RelationReference) sourceContext).getRelation();
			Role targetRole = relation.getTarget();
			if(targetRole.getModifier().contains(RoleModifier.INPUT)){
				sourceObjects = selection;
			}
		}
		
		TargetContext targetContext = object.getTarget();
		
		return false;
	}
}
