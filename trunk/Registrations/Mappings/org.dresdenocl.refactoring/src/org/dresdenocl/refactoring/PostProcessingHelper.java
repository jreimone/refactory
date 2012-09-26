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
/**
 * 
 */
package org.dresdenocl.refactoring;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tudresden.ocl20.pivot.language.ocl.ImplicitFeatureCallCS;
import tudresden.ocl20.pivot.language.ocl.InvariantExpCS;
import tudresden.ocl20.pivot.language.ocl.NamedLiteralExpCS;
import tudresden.ocl20.pivot.language.ocl.NavigationCallExp;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.OclFactory;
import tudresden.ocl20.pivot.language.ocl.PrePostOrBodyDeclarationCS;
import tudresden.ocl20.pivot.language.ocl.SimpleNameCS;
import tudresden.ocl20.pivot.pivotmodel.PivotModelFactory;
import tudresden.ocl20.pivot.pivotmodel.Property;

/**
 * @author Michael Muck
 *
 */
public class PostProcessingHelper {

	/**
	 * Checks whether <code>comprisedExp</code> is included in <code>comprisingExp</code> by means of name similarity
	 * and not object equality.<br><br>
	 * 
	 * <b>Example:</b><br>
	 * <code>dbtr.pstlAdr</code> is comprised by <code>dbtr.pstlAdr.adrTp->size()</code>. <br><br>
	 * 
	 * So these both {@link OclExpressionCS expressions} would return <code>true</code> although their model object 
	 * representations are not equal but their substring representation.
	 * 
	 * @param comprisingExp
	 * @param comprisedExp
	 * @return
	 */
	public static boolean isExpressionComprised(OclExpressionCS comprisingExp, OclExpressionCS comprisedExp){
		boolean comprised = true;
		if(comprisingExp instanceof NavigationCallExp && comprisedExp instanceof NavigationCallExp){
			NavigationCallExp comprisingNC = (NavigationCallExp) comprisingExp;
			NavigationCallExp comprisedNC = (NavigationCallExp) comprisedExp;
			OclExpressionCS comprisingSource = comprisingNC.getSource();
			OclExpressionCS comprisedSource = comprisedNC.getSource();
			if(EcoreUtil.equals(comprisingSource, comprisedSource)){
				List<ImplicitFeatureCallCS> comprisingFeatureCalls = comprisingNC.getFeatureCalls();
				List<ImplicitFeatureCallCS> comprisedFeatureCalls = comprisedNC.getFeatureCalls();
				if(comprisedFeatureCalls.size() > comprisingFeatureCalls.size()){
					return false;
				}
				for (int i = 0; i < comprisedFeatureCalls.size(); i++) {
					ImplicitFeatureCallCS comprisedFeatureCall = comprisedFeatureCalls.get(i);
					ImplicitFeatureCallCS comprisingFeatureCall = comprisingFeatureCalls.get(i);
					String comprisedOperator = comprisedNC.getNavigationOperator().get(i);
					String comprisingOperator = comprisingNC.getNavigationOperator().get(i);
					if(!EcoreUtil.equals(comprisedFeatureCall, comprisingFeatureCall)){
						return false;
					}
					if(!comprisedOperator.equals(comprisingOperator)){
						return false;
					}
				}
			} else {
				return false;
			}
		} else {
			return EcoreUtil.equals(comprisingExp, comprisedExp);
		}
		return comprised;
	}

	public EObject getConstraintRoot(EObject source) {
		EObject constraintRoot = source.eContainer();
		while (	!(constraintRoot instanceof InvariantExpCS) && 
				!(constraintRoot instanceof PrePostOrBodyDeclarationCS)) 
		{
			constraintRoot = constraintRoot.eContainer();
		}
		System.out.println("found constraint-root as: "+constraintRoot.toString());
		return constraintRoot;
	}

	public void removeObjectFromParent(EObject removee) {
		EObject parent = removee.eContainer();
		//System.out.println("parent to remove item from: "+parent);
		//System.out.println("removees containing feature: "+parent.eGet(removee.eContainingFeature()));

		if (parent.eGet(removee.eContainingFeature()) instanceof EList) {
			System.out.println("removing object from elist ");
			((EList<?>)parent.eGet(removee.eContainingFeature())).remove(removee);
		} else {
			System.out.println("removing object from eobject");
			parent.eUnset(removee.eContainingFeature());
		}
	}

	//checking if an parent container is now empty an can be removed
	//should be called after removing objects from a tree
	public void cleanEmptyParentContainer(EObject parent) {

	}

	/**
	 * Replaces <code>replacee</code> as child of its parent by <code>replacement</code>.
	 * 
	 * @param replacee
	 * @param replacement
	 */
	public static void replaceExpression(EObject replacee, EObject replacement) {
		replaceExpression(null, replacee, replacement);
	}

	/**
	 * Replaces <code>replacee</code> as child of <code>context</code> by <code>replacement</code>.
	 * 
	 * @param context
	 * @param replacee
	 * @param replacement
	 */
	public static void replaceExpression(EObject context, EObject replacee, EObject replacement) {
		if(replacement instanceof SimpleNameCS){
			if(context != null && context instanceof NavigationCallExp && replacee instanceof NavigationCallExp){
				NavigationCallExp contextNC = (NavigationCallExp) context;
				NavigationCallExp replaceeNC = (NavigationCallExp) replacee;
				NamedLiteralExpCS newNamedLiteral = createNewNamedLiteral((SimpleNameCS) replacement);
				OclExpressionCS replaceSource = replaceeNC.getSource();
				OclExpressionCS contextSource = contextNC.getSource();
				int lastIndex = -1;
				if(EcoreUtil.equals(replaceSource, contextSource)){
					List<ImplicitFeatureCallCS> replaceFeatureCalls = replaceeNC.getFeatureCalls();
					List<ImplicitFeatureCallCS> contextFeatureCalls = contextNC.getFeatureCalls();
					for (int i = 0; i < replaceFeatureCalls.size(); i++) {
						ImplicitFeatureCallCS replaceeFeatureCall = replaceFeatureCalls.get(i);
						ImplicitFeatureCallCS contextFeatureCall = contextFeatureCalls.get(i);
						if(EcoreUtil.equals(replaceeFeatureCall, contextFeatureCall)){
							lastIndex++;
						}
					}
					if(lastIndex == replaceFeatureCalls.size() - 1){
						contextNC.setSource(newNamedLiteral);
						for (int i = 0; i <= lastIndex; i++) {
							contextFeatureCalls.remove(0);
							contextNC.getNavigationOperator().remove(0);
						}
					}
				}
			} else {
				NamedLiteralExpCS newNamedLiteral = createNewNamedLiteral((SimpleNameCS) replacement);			

				EObject replaceeParent = replacee.eContainer();
				EReference containmentFeature = replacee.eContainmentFeature();
				if(replaceeParent != null && containmentFeature != null){
					replaceeParent.eSet(containmentFeature, newNamedLiteral);
				}
			}
		}
	}

	/**
	 * Creates a new {@link NamedLiteralExpCS} based on the given {@link SimpleNameCS}.
	 * @param original
	 * @return
	 */
	public static NamedLiteralExpCS createNewNamedLiteral(SimpleNameCS original) {
		NamedLiteralExpCS newNamedLiteral = OclFactory.eINSTANCE.createNamedLiteralExpCS();
		Property tempProperty = PivotModelFactory.eINSTANCE.createProperty();
		tempProperty.setName(original.getSimpleName());
		newNamedLiteral.setNamedElement(tempProperty);
		return newNamedLiteral;
	}

}
