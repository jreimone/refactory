/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.AFTER;
import org.emftext.language.refactoring.refactoring_specification.ConcreteIndex;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FIRST;
import org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.LAST;
import org.emftext.language.refactoring.refactoring_specification.ObjectReference;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.RefactoringStatus;

/**
 * @author Jan Reimann
 *
 */
public class IndexAssignmentInterpreter {

	private RefactoringInterpreterContext context;
	private List<? extends EObject> selection;
	
	public IRefactoringStatus interpreteIndexCommand(IndexAssignmentCommand command, RefactoringInterpreterContext context, List<? extends EObject> selection){
		this.context = context;
		this.selection = selection;
		boolean result = true;
		if(command instanceof FIRST){
			result = interpreteFirst((FIRST) command);
		}
		if(command instanceof ConcreteIndex){
			result = interpreteConcreteIndex((ConcreteIndex) command);
		}
		if(command instanceof LAST){
			result = interpreteLast((LAST) command);
		}
		if(command instanceof AFTER){
			result = interpreteAfter((AFTER) command);
		}
		if(!result){
			return new RefactoringStatus(IRefactoringStatus.WARNING, "Couldn't determine the correct position in the model");
		}
		return new RefactoringStatus(IRefactoringStatus.OK);
	}
	
	private boolean interpreteAfter(AFTER after) {
		ObjectReference reference = after.getReference();
		if(reference instanceof VariableReference){
			EObject object = (EObject) context.getObjectForVariable(((VariableReference) reference).getVariable());
			return setIndexForAfter(after, object);
		}
		if(reference instanceof ConstantsReference){
			Constants constant = ((ConstantsReference) reference).getReferencedConstant();
			List<? extends EObject> elements = null;
			switch (constant) {
			case INPUT:
				elements = selection;
			default:
				break;
			}
			if(elements == null){
				return false;
			}
			EObject firstElement = elements.get(0);
			return setIndexForAfter(after, firstElement);
		}
		return false;
	}

	private boolean setIndexForAfter(AFTER after, EObject object) {
		// TODO: extract methods in this class and consolidate them !!!!
		EObject parent = object.eContainer();
		if(parent == null){
			// object is root
			if(EcoreUtil.getRootContainer(object).equals(object)){
				context.setIndexForVariable(after.getVariable(), 0);
				return true;
			}
			return true;
		}
		EStructuralFeature feature = object.eContainingFeature();
		if(feature.isMany()){
			int index = ((List<?>) parent.eGet(feature)).indexOf(object);
			index++;
			context.setIndexForVariable(after.getVariable(), index);
			return true;
		} else {
			context.setIndexForVariable(after.getVariable(), 0);
			return true;
		}
	}

	private boolean interpreteFirst(FIRST first){
		ObjectReference reference = first.getReference();
		if(reference instanceof VariableReference){
			EObject object = (EObject) context.getObjectForVariable(((VariableReference) reference).getVariable());
			return setIndexForFIRST(first, object);
		}
		if(reference instanceof ConstantsReference){
			Constants constant = ((ConstantsReference) reference).getReferencedConstant();
			List<? extends EObject> elements = null;
			switch (constant) {
			case INPUT:
				elements = selection;
			default:
				break;
			}
			if(elements == null){
				return false;
			}
			EObject firstElement = elements.get(0);
			return setIndexForFIRST(first, firstElement);
		}
		return false;
	}

	/**
	 * @param first
	 * @param object
	 * @return
	 */
	private boolean setIndexForFIRST(FIRST first, EObject object) {
		EObject parent = object.eContainer();
		if(parent == null){
			// object is root
			if(EcoreUtil.getRootContainer(object).equals(object)){
				context.setIndexForVariable(first.getVariable(), 0);
				return true;
			}
			return true;
		}
		EStructuralFeature feature = object.eContainingFeature();
		if(feature.isMany()){
			int index = ((List<?>) parent.eGet(feature)).indexOf(object);
			context.setIndexForVariable(first.getVariable(), index);
			return true;
		} else {
			context.setIndexForVariable(first.getVariable(), 0);
			return true;
		}
	}
	
	private boolean interpreteConcreteIndex(ConcreteIndex index){
		context.setIndexForVariable(index.getVariable(), index.getIndex());
		return true;
	}
	
	private boolean interpreteLast(LAST last){
		throw new UnsupportedOperationException("implement LAST");
	}
}
