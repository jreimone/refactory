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
import java.util.WeakHashMap;

import org.dresdenocl.essentialocl.standardlibrary.OclBoolean;
import org.dresdenocl.interpreter.IOclInterpreter;
import org.dresdenocl.interpreter.OclInterpreterPlugin;
import org.dresdenocl.language.ocl.resource.ocl.Ocl22Parser;
import org.dresdenocl.metamodels.ecore.EcoreMetamodelPlugin;
import org.dresdenocl.model.IModel;
import org.dresdenocl.model.metamodel.IMetamodel;
import org.dresdenocl.modelbus.ModelBusPlugin;
import org.dresdenocl.modelinstance.IModelInstance;
import org.dresdenocl.modelinstance.IModelInstanceType;
import org.dresdenocl.modelinstancetype.ecore.EcoreModelInstanceTypePlugin;
import org.dresdenocl.modelinstancetype.exception.TypeNotFoundInModelException;
import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.parser.ParseException;
import org.dresdenocl.pivotmodel.ConstrainableElement;
import org.dresdenocl.pivotmodel.Constraint;
import org.dresdenocl.pivotmodel.Type;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.registry.rolemapping.IConstraintInterpreter;
import org.emftext.refactoring.registry.rolemapping.IInterpretationResult;

public class OCLConstraintInterpreter implements IConstraintInterpreter {

	private static Map<IModelInstance, IOclInterpreter> cachedInterpreters = new WeakHashMap<IModelInstance, IOclInterpreter>();
	
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
			IMetamodel metaModel = getMetaModel(EcoreMetamodelPlugin.ID);
			IModel metamodelOCL = metaModel.getModelProvider().getModel(mmResource);
			IModelInstance modelInstance;
			modelInstance = getEmptyModelInstance(metamodelOCL, EcoreModelInstanceTypePlugin.PLUGIN_ID);
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
				org.dresdenocl.interpreter.IInterpretationResult result = interpretConstraint(oclConstraint, modelInstance, modelInstanceElement);
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
				IMetamodel metaModel =getMetaModel(EcoreMetamodelPlugin.ID);
				IModel metamodelOCL = metaModel.getModelProvider().getModel(mmResource);
				constraintFile = FileLocator.resolve(constraintFile);
				List<Constraint> parseConstraints = parseConstraints(URI.createFileURI(constraintFile.getFile()), metamodelOCL, true);
				for (Constraint constraint : parseConstraints) {
					constraints.put(constraint.getName(), constraint);
				}
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (IOException e) {
				// do nothing
			}
		}
		return constraints;
	}

	// ###############################################################
	// following methods where taken from Dresden OCL since the facade plugin is not installed
	// ###############################################################
	
	private static IMetamodel getMetaModel(String id) {
		IMetamodel result = null;
		if(id != null){
			result = ModelBusPlugin.getMetamodelRegistry().getMetamodel(id);
		}
		return result;
	}

	private static IModelInstance getEmptyModelInstance(IModel model, String modelInstanceTypeID) {
		IModelInstanceType modelInstanceType;
		modelInstanceType = getModelInstanceType(modelInstanceTypeID);

		IModelInstance result;

		result = modelInstanceType.getModelInstanceProvider().createEmptyModelInstance(model);

		return result;
	}

	private static IModelInstanceType getModelInstanceType(String id) {
		IModelInstanceType result;
		result = ModelBusPlugin.getModelInstanceTypeRegistry().getModelInstanceType(id);
		return result;
	}

	private static List<Constraint> parseConstraints(URI uri, IModel model, boolean addToModel) {
		try {
			return Ocl22Parser.INSTANCE.doParse(model, uri, addToModel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static org.dresdenocl.interpreter.IInterpretationResult interpretConstraint(Constraint constraint, IModelInstance modelInstance, IModelInstanceElement modelInstanceElement) {
		org.dresdenocl.interpreter.IInterpretationResult result;
		IOclInterpreter interpreter;
		if (cachedInterpreters.containsKey(modelInstance)) {
			interpreter = cachedInterpreters.get(modelInstance);
		}
		else {
			interpreter = OclInterpreterPlugin.createInterpreter(modelInstance);
			cachedInterpreters.put(modelInstance, interpreter);
		}
		result = interpreter.interpretConstraint(constraint, modelInstanceElement);
		return result;
	}
}
