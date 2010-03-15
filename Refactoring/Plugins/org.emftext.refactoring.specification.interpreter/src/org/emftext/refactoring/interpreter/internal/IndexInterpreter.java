/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.ConcreteIndex;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.FIRST;
import org.emftext.language.refactoring.refactoring_specification.FromReference;
import org.emftext.language.refactoring.refactoring_specification.IndexAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.LAST;
import org.emftext.language.refactoring.refactoring_specification.VariableReference;

/**
 * @author Jan Reimann
 *
 */
public class IndexInterpreter {

	private RefactoringInterpreterContext context;
	private List<? extends EObject> selection;
	
	public boolean interpreteIndexCommand(IndexAssignmentCommand command, RefactoringInterpreterContext context, List<? extends EObject> selection){
		this.context = context;
		this.selection = selection;
		if(command instanceof FIRST){
			return interpreteFirst((FIRST)command);
		}
		if(command instanceof ConcreteIndex){
			return interpreteConcreteIndex((ConcreteIndex) command);
		}
		if(command instanceof LAST){
			return interpreteLast((LAST) command);
		}
		return false;
	}
	
	private boolean interpreteFirst(FIRST first){
		FromReference reference = first.getReference();
		if(reference instanceof VariableReference){
			EObject object = context.getEObjectForVariable(((VariableReference) reference).getVariable());
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
