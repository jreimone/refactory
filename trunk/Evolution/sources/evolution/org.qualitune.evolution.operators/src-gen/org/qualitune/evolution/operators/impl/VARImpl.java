/**
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
 *  
 */
package org.qualitune.evolution.operators.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.qualitune.evolution.operators.EObjectReference;
import org.qualitune.evolution.operators.OperatorsFactory;
import org.qualitune.evolution.operators.OperatorsPackage;
import org.qualitune.evolution.operators.QueryVariable;
import org.qualitune.evolution.operators.Referrable;
import org.qualitune.evolution.operators.Result;
import org.qualitune.evolution.operators.TypeVariable;
import org.qualitune.evolution.operators.VAR;
import org.qualitune.evolution.operators.Variable;
import org.qualitune.evolution.operators.VariableReference;
import org.qualitune.evolution.operators.util.OperatorsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VAR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.evolution.operators.impl.VARImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VARImpl extends OperatorImpl implements VAR {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected QueryVariable variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VARImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorsPackage.Literals.VAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryVariable getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(QueryVariable newVariable, NotificationChain msgs) {
		QueryVariable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorsPackage.VAR__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(QueryVariable newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.VAR__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorsPackage.VAR__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorsPackage.VAR__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorsPackage.VAR__VARIABLE:
				return basicSetVariable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorsPackage.VAR__VARIABLE:
				return getVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperatorsPackage.VAR__VARIABLE:
				setVariable((QueryVariable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperatorsPackage.VAR__VARIABLE:
				setVariable((QueryVariable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperatorsPackage.VAR__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void execute() {
		QueryVariable queryVariable = getVariable();
		Referrable queryObject = queryVariable.getQueryObject();
		EObjectReference operatorResult = OperatorsFactory.eINSTANCE.createEObjectReference();
		setResult(operatorResult);
		queryVariable.setQueryResult(operatorResult);
		EObject contextObject = null;
		if(queryObject instanceof EObjectReference){
			EList<EObject> element = ((EObjectReference) queryObject).getElement();
			if(element != null && element.size() == 1){
				contextObject = element.get(0);
			}
		} else if(queryObject instanceof VariableReference){
			final Variable referencedVariable = ((VariableReference) queryObject).getReferencedVariable();
			if(referencedVariable instanceof TypeVariable){
				contextObject = ((TypeVariable) referencedVariable).getValue();
			} else if(referencedVariable instanceof QueryVariable){
				Result queryResult = ((QueryVariable) referencedVariable).getQueryResult();
				if(queryResult instanceof EObjectReference){
					EList<EObject> results = ((EObjectReference) queryResult).getElement();
					if(results != null && results.size() == 1){
						contextObject = results.get(0);
					} else {
						OperatorsUtil.addErrorToResourceOf(this, "Variable " + referencedVariable.getName() + " refers to a list containing more than 1 element");
					}
				}
			}
		}
		EOperation operation = queryVariable.getOperation();
		EStructuralFeature structuralFeature = queryVariable.getStructuralFeature();
		if(operation != null){
			List<EParameter> parameters = operation.getEParameters();
			if(parameters == null || parameters.size() == 0){
				try {
					Object result = contextObject.eInvoke(operation, null);
					if(result instanceof EObject){
						EObject singleResult = (EObject) result;
						operatorResult.getElement().add(singleResult);
					} else if(result instanceof List<?>){
						List<?> resultList = (List<?>) result;
						List<EObject> eobjects = new BasicEList<EObject>();
						for (Object resultElement : resultList) {
							if(resultElement instanceof EObject){
								eobjects.add((EObject) resultElement);
							}
						}
						if(eobjects.size() == resultList.size()){
							operatorResult.getElement().addAll(eobjects);
						}
					}
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		} else if(structuralFeature != null){
			Object result = contextObject.eGet(structuralFeature, true);
			if(!structuralFeature.isMany()){
				EObject singleResult = (EObject) result;
				operatorResult.getElement().add(singleResult);
			} else {
				List<?> resultList = (List<?>) result;
				for (Object resultElement : resultList) {
					if(resultElement instanceof EObject){
						operatorResult.getElement().add((EObject) resultElement);
					}
				}
			}
		}
		super.execute();
	}

} //VARImpl
