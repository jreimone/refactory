/*******************************************************************************
 * Copyright (c) 2010-2012, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zoltan Ujhelyi - initial API and implementation
 *******************************************************************************/
package org.eclipse.incquery.patternlanguage.scoping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * <p>
 * An extended abstract declarative scope provider to facilitate the reusing of abstract declarative scope providers
 * together with XBase scope provider.
 * </p>
 * <p>
 * See <a href= "http://www.eclipse.org/forums/index.php/mv/msg/219841/699521/#msg_699521"
 * >http://www.eclipse.org/forums/index.php/mv/msg/219841/699521/#msg_699521</a> for details.
 * </p>
 * 
 * @author Zoltan Ujhelyi
 * 
 */
public class PatternLanguageDeclarativeScopeProvider extends MyAbstractDeclarativeScopeProvider {

    private static final class PrivateDescFilter implements Predicate<IEObjectDescription> {
        @Override
        public boolean apply(IEObjectDescription input) {
            // filter not local, private patterns (private patterns in other
            // resources)
            // this information stored in the userdata of the
            // EObjectDescription
            // EObjectDescription only created for not local eObjects, so
            // check for resource equality is unnecessary.
            if ("true".equals(input.getUserData("private"))) {
                return false;
            }
            return true;
        }
    }

    private static final class UndefinedVariable implements Predicate<Variable> {
        @Override
        public boolean apply(Variable input) {
            return input.getName() != null && !input.getName().isEmpty();
        }
    }

    private static final class CreateObjectDescFunction implements Function<Variable, IEObjectDescription> {
        @Override
        public IEObjectDescription apply(Variable from) {
            return EObjectDescription.create(from.getName(), from);
        }
    }

    /**
     * Custom scoping for patternRef in {@link PatternCall}. Currently returns all Pattern that is visible from the
     * current context.
     * 
     * TODO redo
     * 
     * @param ctx
     * @param ref
     * @return
     * 
     */
    public IScope scope_PatternCall_patternRef(PatternCall ctx, EReference ref) {
    	IScope delegateScope = delegateGetScope(ctx, ref);
    	EObject container = EcoreUtil.getRootContainer(ctx);
    	Iterable<Pattern> patterns;
    	if (container instanceof PatternModel) {
    		patterns = ((PatternModel)container).getPatterns(); 
    	} else {
    		patterns = ImmutableList.of();
    	}
    	return new FilteringScope(Scopes.scopeFor(patterns, delegateScope), new PrivateDescFilter());
    }

    public IScope scope_VariableReference_variable(EObject ctx, EReference ref) {
        EObject it = ctx;
        PatternBody body = null;
        while (it != null && !(it instanceof Pattern)) {
            if (it instanceof PatternBody) {
                body = (PatternBody) it;
            }
            it = it.eContainer();
        }
        CreateObjectDescFunction createObjectDescFunction = new CreateObjectDescFunction();
        EList<Variable> variables;
        if (body != null) {
            variables = body.getVariables();
        } else if (it != null) {
            Pattern pattern = (Pattern) it; // If it is not null, this works
            variables = pattern.getParameters();
        } else {
            return IScope.NULLSCOPE;
        }
        UndefinedVariable variableFilter = new UndefinedVariable();
        IScope localScope = new SimpleScope(IScope.NULLSCOPE, Iterables.transform(
                Iterables.filter(variables, variableFilter), createObjectDescFunction));
        return localScope;
    }
}
