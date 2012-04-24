/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.refactoring.specification.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.emftext.language.refactoring.refactoring_specification.IndexVariable;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.Variable;

/**
 * @author jreimann
 *
 */
public class UniqueVariableNamesConstraint extends AbstractModelConstraint implements IModelConstraint{

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if(target instanceof RefactoringSpecification){
			RefactoringSpecification refSpec = (RefactoringSpecification) target;
			Map<String, Set<IndexVariable>> nameIndicesMap = new HashMap<String, Set<IndexVariable>>();
			Map<String, Set<Variable>> nameVariableMap = new HashMap<String, Set<Variable>>();
			TreeIterator<EObject> iterator = refSpec.eAllContents();
			while (iterator.hasNext()) {
				EObject eObject = (EObject) iterator.next();
				if(eObject instanceof IndexVariable){
					IndexVariable indexVar = (IndexVariable) eObject;
					Set<IndexVariable> variables = nameIndicesMap.get(indexVar.getName());
					if(variables == null){
						variables = new HashSet<IndexVariable>();
						nameIndicesMap.put(indexVar.getName(), variables);
					}
					variables.add(indexVar);
				} else if(eObject instanceof Variable){
					Variable var = (Variable) eObject;
					Set<Variable> variables = nameVariableMap.get(var.getName());
					if(variables == null){
						variables = new HashSet<Variable>();
						nameVariableMap.put(var.getName(), variables);
					}
					variables.add(var);
				}
			}
			for (String name : nameIndicesMap.keySet()) {
				Set<IndexVariable> variables = nameIndicesMap.get(name);
				if(variables.size() > 1){
//					IStatus status = ctx.createFailureStatus(null);
					ConstraintStatus status = new ConstraintStatus(this, target, "Duplicate index variable names are not allowed.", variables);
					return status;
				}
			}
			for (String name : nameVariableMap.keySet()) {
				Set<Variable> variables = nameVariableMap.get(name);
				if(variables.size() > 1){
					ConstraintStatus status = new ConstraintStatus(this, target, "Duplicate variable names are not allowed.", variables);
					return status;
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	@Override
	public IConstraintDescriptor getDescriptor() {
		return new AbstractConstraintDescriptor() {
			public boolean targetsTypeOf(EObject eObject) {
				return true;
			}
			
			public boolean targetsEvent(Notification notification) {
				return false;
			}
			
			public void removeCategory(Category category) {
			}
			
			public boolean isLive() {
				return false;
			}
			
			public boolean isBatch() {
				return true;
			}
			
			public int getStatusCode() {
				return 0;
			}
			
			public ConstraintSeverity getSeverity() {
				return ConstraintSeverity.ERROR;
			}
			
			public String getPluginId() {
				return "org.emftext.language.refactoring.specification.validation";
			}
			
			public String getName() {
				return "name";
			}
			
			public String getMessagePattern() {
				return "message";
			}
			
			public String getId() {
				return null;
			}
			
			public EvaluationMode<?> getEvaluationMode() {
				return EvaluationMode.BATCH;
			}
			
			public String getDescription() {
				return "description";
			}
			
			public Set<Category> getCategories() {
				return null;
			}
			
			public String getBody() {
				return null;
			}
			
			public void addCategory(Category category) {
			}
		};
	}

}
