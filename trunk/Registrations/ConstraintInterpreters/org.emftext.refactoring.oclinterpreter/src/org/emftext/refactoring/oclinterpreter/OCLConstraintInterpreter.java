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
package org.emftext.refactoring.oclinterpreter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.registry.rolemapping.IConstraintInterpreter;
import org.emftext.refactoring.registry.rolemapping.IInterpretationResult;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.model.metamodel.IMetamodel;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.pivotmodel.ConstrainableElement;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.Type;

public class OCLConstraintInterpreter implements IConstraintInterpreter {

	public OCLConstraintInterpreter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInterprete(Object constraint) {
		if(constraint instanceof Constraint){
			return true;
		}
		return false;
	}

	@Override
	public IInterpretationResult interpreteConstraint(Object constraint, final String errorMessage, EObject model, Resource mmResource) {
		Exception ex = null;
		try {
			Constraint oclConstraint = (Constraint) constraint;
			IMetamodel metaModel = Ocl2ForEclipseFacade.getMetaModel(Ocl2ForEclipseFacade.ECORE_META_MODEL);
			IModel metamodelOCL = metaModel.getModelProvider().getModel(mmResource);
			IModelInstance modelInstance;
			modelInstance = Ocl2ForEclipseFacade.getEmptyModelInstance(metamodelOCL, Ocl2ForEclipseFacade.ECORE_MODEL_INSTANCE_TYPE);
			List<ConstrainableElement> constrainedElements = oclConstraint.getConstrainedElement();
			Set<EClassifier> contextSet = new HashSet<EClassifier>();
			for (ConstrainableElement constrainableElement : constrainedElements) {
				Type type = (Type) constrainableElement;
				String name = type.getName();
				EPackage metamodel = (EPackage) mmResource.getContents().get(0);
				EClassifier classifier = metamodel.getEClassifier(name);
				if(classifier != null){
					contextSet.add(classifier);
				}
			}
			TreeIterator<EObject> contents = model.eAllContents();
			List<IModelInstanceElement> modelInstanceElements = new ArrayList<IModelInstanceElement>();
			while (contents.hasNext()) {
				EObject next = contents.next();
				if(contextSet.contains(next.eClass())){
					modelInstanceElements.add(modelInstance.addModelInstanceElement(next));
				}
			}
			for (IModelInstanceElement modelInstanceElement : modelInstanceElements) {
				tudresden.ocl20.pivot.interpreter.IInterpretationResult result = Ocl2ForEclipseFacade.interpretConstraint(oclConstraint, modelInstance, modelInstanceElement);
				if(result != null && !result.getResult().oclIsInvalid().isTrue() 
						&& !result.getResult().oclIsUndefined().isTrue() 
						&& !((OclBoolean) result.getResult()).isTrue()) {
					return new IInterpretationResult() {

						@Override
						public boolean wasSuccessful() {
							return false;
						}

						@Override
						public String getErrorMessage() {
							return errorMessage;
						}
					};
				} else {
					return new IInterpretationResult() {

						@Override
						public boolean wasSuccessful() {
							return true;
						}

						@Override
						public String getErrorMessage() {
							return null;
						}
					};
				}
			}
		} catch (IllegalArgumentException e) {
			ex = e;
		} catch (ModelAccessException e) {
			ex = e;
		} catch (TypeNotFoundInModelException e) {
			ex = e;
		}
		return new ErrorInterpretationResult(ex);
	}

	@Override
	public Map<String, Object> getConstraints(URL constraintFile, Resource mmResource) {
		Map<String, Object> constraints = new HashMap<String, Object>();
		if(constraintFile != null){
			try {
				IMetamodel metaModel = Ocl2ForEclipseFacade.getMetaModel(Ocl2ForEclipseFacade.ECORE_META_MODEL);
				IModel metamodelOCL = metaModel.getModelProvider().getModel(mmResource);
				constraintFile = FileLocator.resolve(constraintFile);
				List<Constraint> parseConstraints = Ocl2ForEclipseFacade.parseConstraints(constraintFile, metamodelOCL, true);
				for (Constraint constraint : parseConstraints) {
					constraints.put(constraint.getName(), constraint);
				}
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (ParseException e) {
				// do nothing
			} catch (IOException e) {
				// do nothing
			}
		}
		return constraints;
	}

}
