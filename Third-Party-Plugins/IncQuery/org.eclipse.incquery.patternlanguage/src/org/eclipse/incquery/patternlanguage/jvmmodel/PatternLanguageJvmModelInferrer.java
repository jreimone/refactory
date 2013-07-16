/**
 * Copyright (c) 2010-2012, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Zoltan Ujhelyi - initial API and implementation
 */
package org.eclipse.incquery.patternlanguage.jvmmodel;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class PatternLanguageJvmModelInferrer extends AbstractModelInferrer {
  /**
   * Is called for each instance of the first argument's type contained in a resource.
   * 
   * @param element - the model to create one or more JvmDeclaredTypes from.
   * @param acceptor - each created JvmDeclaredType without a container should be passed to the acceptor in order get attached to the
   *                   current resource.
   * @param isPreLinkingPhase - whether the method is called in a pre linking phase, i.e. when the global index isn't fully updated. You
   *        must not rely on linking using the index if iPrelinkingPhase is <code>true</code>
   */
  protected void _infer(final PatternModel element, final IAcceptor<JvmDeclaredType> acceptor, final boolean isPrelinkingPhase) {
  }
  
  public void infer(final EObject element, final Object acceptor, final boolean isPrelinkingPhase) {
    if (element instanceof PatternModel
         && acceptor instanceof IAcceptor) {
      _infer((PatternModel)element, (IAcceptor<JvmDeclaredType>)acceptor, isPrelinkingPhase);
      return;
    } else if (element != null
         && acceptor instanceof IJvmDeclaredTypeAcceptor) {
      _infer(element, (IJvmDeclaredTypeAcceptor)acceptor, isPrelinkingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, acceptor, isPrelinkingPhase).toString());
    }
  }
}
