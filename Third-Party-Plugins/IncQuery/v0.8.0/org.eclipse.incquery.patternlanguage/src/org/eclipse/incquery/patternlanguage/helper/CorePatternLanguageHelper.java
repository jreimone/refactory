/*******************************************************************************
 * Copyright (c) 2010-2012, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zoltan Ujhelyi - initial API and implementation
 *   Andras Okros - minor changes
 *******************************************************************************/
package org.eclipse.incquery.patternlanguage.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.FunctionEvaluationValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers;
import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@SuppressWarnings("restriction")
public final class CorePatternLanguageHelper {

    private CorePatternLanguageHelper() {
    }

    /**
     * Returns the name of the container package of the selected pattern
     * @return a name of the pattern; never null, but may be empty string
     */
    public static String getPackageName(Pattern pattern) {
        if(pattern == null || pattern.eIsProxy()) {
            return "";
        }
        PatternModel patternModel = (PatternModel) pattern.eContainer();

        return (patternModel == null) ? null : patternModel.getPackageName();
    }
    
    /**
     * Returns the name of the pattern, qualified by package name.
     */
    public static String getFullyQualifiedName(Pattern pattern) {
        String packageName = getPackageName(pattern);
        if (packageName == null || packageName.isEmpty()) {
            return pattern.getName();
        } else {
            return packageName + "." + pattern.getName();
        }
        // TODO ("local pattern?")
    }

    /**
     * @param pattern
     * @return true if the pattern has a private modifier, false otherwise.
     */
    public static boolean isPrivate(Pattern pattern) {
        for (Modifiers mod : pattern.getModifiers()) {
            if (mod.isPrivate()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param pattern
     * @return true if the pattern contains xbase check() or eval() expressions, false otherwise.
     */
    public static boolean hasXBaseExpression(Pattern pattern) {
    	final TreeIterator<EObject> eAllContents = pattern.eAllContents();
    	while (eAllContents.hasNext()) {
    		if (eAllContents.next() instanceof XExpression)
    			return true;
    	}
        return false;
    }

    /**
     * @return all xbase check() or eval() expressions in the pattern
     */
    public static Collection<XExpression> getAllTopLevelXBaseExpressions(EObject patternOrBody) {
    	final List<XExpression> result = new ArrayList<XExpression>();
    	final TreeIterator<EObject> eAllContents = patternOrBody.eAllContents();
    	while (eAllContents.hasNext()) {
    		final EObject content = eAllContents.next();
			if (content instanceof XExpression) {
				result.add((XExpression) content);
				// do not include subexpressions
    			eAllContents.prune();
    		}
    	}
        return result;
    }

    /**
     * Returns the parameter of a pattern by name
     *
     * @param pattern
     * @param name
     * @return the requested parameter of the pattern, or null if none exists
     * @since 0.7.0
     */
    public static Variable getParameterByName(final Pattern pattern, final String name) {
        return Iterables.find(pattern.getParameters(), new Predicate<Variable>() {

            @Override
            public boolean apply(Variable variable) {
                return name.equals(variable.getName());
            }
        }, null);
    }

    /** Compiles a map for name-based lookup of symbolic parameter positions. */
    public static Map<String, Integer> getParameterPositionsByName(Pattern pattern) {
        EList<Variable> parameters = pattern.getParameters();
        Map<String, Integer> posMapping = new HashMap<String, Integer>();
        int parameterPosition = 0;
        for (Variable parameter : parameters) {
            posMapping.put(parameter.getName(), parameterPosition++);
        }
        return posMapping;
    }

    /**
	 * Finds all pattern variables referenced from the given XExpression. </p>
	 * <p>
	 * <strong>Warning</strong> This method cannot be used in JvmModelInferrer,
	 * as that is used to set up the list of available local variables.
	 */
    public static Set<Variable> getReferencedPatternVariablesOfXExpression(XExpression xExpression, IJvmModelAssociations associations) {
        Set<Variable> result = new HashSet<Variable>();
        if (xExpression != null) {
            TreeIterator<EObject> eAllContents = xExpression.eAllContents();
            while (eAllContents.hasNext()) {
                EObject expression = eAllContents.next();
                EList<EObject> eCrossReferences = expression.eCrossReferences();
                for (EObject eObject : eCrossReferences) {
                    if (eObject instanceof JvmFormalParameter && !EcoreUtil.isAncestor(xExpression, eObject)) {
                    	for (EObject obj : associations.getSourceElements(eObject)) {
                    		if (obj instanceof Variable) {
                    		result.add((Variable) obj);
                    		}
                    	}
                    }
                }
            }
        }
        return result;
    }

    public static List<Variable> getUsedVariables(XExpression xExpression, Iterable<Variable> allVariables){
        List<EObject> contents = Lists.newArrayList(xExpression.eAllContents());
    	Iterable<XFeatureCall> featuredCalls = Iterables.filter(contents, XFeatureCall.class);
        final Set<String> valNames = Sets.newHashSet(Iterables.transform(featuredCalls, new Function<XFeatureCall,String>() {
            @Override
            public String apply(final XFeatureCall call) {
              return call.getConcreteSyntaxFeatureName();
            }
          }));
        Iterable<Variable> calledVariables = Iterables.filter(allVariables, new Predicate<Variable>() {
            @Override
            public boolean apply(final Variable var) {
              return valNames.contains(var.getName());
            }
          });
        return IterableExtensions.sortBy(calledVariables, new Function1<Variable,String>() {
            public String apply(final Variable var) {
              return var.getName();
            }
          });
    }

    public static EList<Variable> getAllVariablesInBody(PatternBody body, EList<Variable> previous) {
        EList<Variable> variables = previous;

        Map<String, Variable> parameterMap = new HashMap<String, Variable>();

        EList<Variable> parameters = ((Pattern) body.eContainer()).getParameters();
        for (Variable var : variables) {
            parameterMap.put(var.getName(), var);
        }
        for (Variable var : parameters) {
            if (!parameterMap.containsKey(var.getName())) {
                // Creating a new paramater ref variable
                ParameterRef refVar = initializeParameterRef(var);
                parameterMap.put(var.getName(), refVar);
                variables.add(refVar);
            }
        }
        int unnamedCounter = 0;
        for (Constraint constraint : body.getConstraints()) {
            Iterator<EObject> it = constraint.eAllContents();
            while (it.hasNext()) {
                EObject obj = it.next();
                if (obj instanceof VariableReference) {
                    VariableReference varRef = (VariableReference) obj;
                    String varName = varRef.getVar();
                    if ("_".equals(varName)) {
                        varName = String.format("_<%d>", unnamedCounter);
                        unnamedCounter++;
                    }
                    Variable var;
                    if (parameterMap.containsKey(varName)) {
                        var = parameterMap.get(varName);
                    } else {
                        var = initializeLocalVariable(varName);
                        variables.add(var);
                        parameterMap.put(varName, var);
                    }
                    varRef.setVariable(var);
                }
            }
        }

        return variables;
    }

    /**
     * @param varName
     * @return
     */
    private static Variable initializeLocalVariable(String varName) {
        Variable decl;
        decl = PatternLanguageFactory.eINSTANCE.createVariable();
        decl.setName(varName);
        return decl;
    }

    /**
     * @param var
     * @return
     */
    private static ParameterRef initializeParameterRef(Variable var) {
        ParameterRef refVar = PatternLanguageFactory.eINSTANCE.createParameterRef();
        refVar.setName(var.getName());
        // refVar.setType(var.getType());
        refVar.setReferredParam(var);
        return refVar;
    }

    /** Finds all patterns referenced from the given pattern. */
    public static Set<Pattern> getReferencedPatterns(Pattern sourcePattern) {
        Set<Pattern> result = new HashSet<Pattern>();
        TreeIterator<EObject> eAllContents = sourcePattern.eAllContents();
        while (eAllContents.hasNext()) {
            EObject element = eAllContents.next();
            if (element instanceof PatternCall) {
                PatternCall call = (PatternCall) element;
                final Pattern patternRef = call.getPatternRef();
                if (patternRef != null) {
                    result.add(patternRef);
                }
            }
        }
        return result;
    }

    public static Set<Pattern> getReferencedPatternsTransitive(Pattern pattern) {
        Set<Pattern> referencedPatterns = new HashSet<Pattern>();
        calculateReferencedPatternsTransitive(pattern, referencedPatterns);
        return referencedPatterns;
    }

    private static void calculateReferencedPatternsTransitive(Pattern pattern, Set<Pattern> addedPatterns) {
        Set<Pattern> candidates = getReferencedPatterns(pattern);
        candidates.removeAll(addedPatterns);
        addedPatterns.addAll(candidates);
        for (Pattern newCandidate : candidates) {
            calculateReferencedPatternsTransitive(newCandidate, addedPatterns);
        }
    }

    private static class AnnotationNameFilter implements Predicate<Annotation> {

        private final String name;

        public AnnotationNameFilter(String name) {
            this.name = name;
        }

        @Override
        public boolean apply(Annotation annotation) {
            return name.equals(annotation.getName());
        }
    }

    /**
     * Returns the first annotation of a given name from a pattern. This method ignores multiple defined annotations by
     * the same name. For getting a filtered collections of annotations, see
     * {@link #getAnnotationsByName(Pattern, String)}
     *
     * @param pattern
     *            the pattern instance
     * @param name
     *            the name of the annotation to return
     * @returns the first annotation or null if no such annotation exists
     * @since 0.7.0
     */
    public static Annotation getFirstAnnotationByName(Pattern pattern, String name) {
        return Iterables.find(pattern.getAnnotations(), new AnnotationNameFilter(name), null);
    }

    /**
     * Returns the collection of annotations of a pattern by a name. For getting the first annotations by name, see
     * {@link #getAnnotationByName(Pattern, String)}
     *
     * @param pattern
     *            the pattern instance
     * @param name
     *            the name of the annotation to return
     * @returns a non-null, but possibly empty collection of annotations
     * @since 0.7.0
     */
    public static Collection<Annotation> getAnnotationsByName(Pattern pattern, String name) {
        return Collections2.filter(pattern.getAnnotations(), new AnnotationNameFilter(name));
    }

    public static ListMultimap<String, ValueReference> getAnnotationParameters(Annotation annotation) {
        ListMultimap<String, ValueReference> parameterMap = ArrayListMultimap.create();
        for (AnnotationParameter param : annotation.getParameters()) {
            parameterMap.put(param.getName(), param.getValue());
        }
        return parameterMap;
    }

    /**
     * Returns all annotation parameters with a selected name
     *
     * @param annotation
     * @param parameterName
     * @return a lazy collection of annotation parameters with the selected name. May be empty, but is never null.
     */
    public static Collection<ValueReference> getAnnotationParameters(final Annotation annotation,
            final String parameterName) {
        return Collections2.transform(
                Collections2.filter(annotation.getParameters(), new Predicate<AnnotationParameter>() {
                    @Override
                    public boolean apply(AnnotationParameter parameter) {
                        Preconditions.checkArgument(parameter != null);
                        return parameter.getName().equals(parameterName);
                    }
                }), new Function<AnnotationParameter, ValueReference>() {
                    @Override
                    public ValueReference apply(AnnotationParameter parameter) {
                        Preconditions.checkArgument(parameter != null);
                        return parameter.getValue();
                    }
                });
    }

    /**
     * Returns the first annotation parameter with a selected name.
     *
     * @param annotation
     * @param parameterName
     * @return the annotation with the selected name, or null if no such annotation exists.
     */
    public static ValueReference getFirstAnnotationParameter(final Annotation annotation, final String parameterName) {
        Collection<ValueReference> parameters = getAnnotationParameters(annotation, parameterName);
        return (!parameters.isEmpty()) ? parameters.iterator().next() : null;
    }

    /**
     * @param valueReference
     * @return all variables from the ValueReference object. (Either referenced directly, or referenced throught an
     *         AggregatedValue.)
     */
    public static Set<Variable> getVariablesFromValueReference(ValueReference valueReference) {
        Set<Variable> resultSet = new HashSet<Variable>();
        if (valueReference != null) {
            if (valueReference instanceof VariableValue) {
                resultSet.add(((VariableValue) valueReference).getValue().getVariable());
            } else if (valueReference instanceof AggregatedValue) {
                AggregatedValue aggregatedValue = (AggregatedValue) valueReference;
                for (ValueReference valueReferenceInner : aggregatedValue.getCall().getParameters()) {
                    for (Variable variable : getVariablesFromValueReference(valueReferenceInner)) {
                        resultSet.add(variable);
                    }
                }
            } else if (valueReference instanceof FunctionEvaluationValue) {
            	FunctionEvaluationValue eval = (FunctionEvaluationValue) valueReference;
            	final List<Variable> usedVariables =
            			CorePatternLanguageHelper.getUsedVariables(eval.getExpression(), containerPatternBody(eval).getVariables());
            	resultSet.addAll(usedVariables);
            }
        }
        return resultSet;
    }

    /**
     * @return the pattern body that contains the value reference
     */
	public static PatternBody containerPatternBody(ValueReference val) {
		for (EObject cursor = val; cursor!=null; cursor = cursor.eContainer())
			if (cursor instanceof PatternBody)
				return (PatternBody) cursor;
		// cursor == null --> not contained in PatternBody
		throw new IllegalArgumentException(
				String.format(
						"Misplaced value reference %s not contained in any pattern body",
						val));
	}

	/**
     * @param patternBody
     * @return A list of variables, which are running/unnamed variables in the pattern body. These variables' name
     *         starts with the "_" prefix, and can be found in find, count find calls.
     */
    public static List<Variable> getUnnamedRunningVariables(PatternBody patternBody) {
        List<Variable> resultList = new ArrayList<Variable>();
        for (Constraint constraint : patternBody.getConstraints()) {
            if (constraint instanceof CompareConstraint) {
                // Just from aggregated elements
                CompareConstraint compareConstraint = (CompareConstraint) constraint;
                ValueReference leftValueReference = compareConstraint.getLeftOperand();
                ValueReference rightValueReference = compareConstraint.getRightOperand();
                resultList.addAll(getUnnamedVariablesFromValueReference(leftValueReference, true));
                resultList.addAll(getUnnamedVariablesFromValueReference(rightValueReference, true));
            } else if (constraint instanceof PatternCompositionConstraint) {
                // All from here, aggregates and normal running variables
                PatternCompositionConstraint patternCompositionConstraint = (PatternCompositionConstraint) constraint;
                for (ValueReference valueReference : patternCompositionConstraint.getCall().getParameters()) {
                    resultList.addAll(getUnnamedVariablesFromValueReference(valueReference, false));
                }
            } else if (constraint instanceof PathExpressionConstraint) {
                // Just from aggregated elements
                PathExpressionConstraint pathExpressionConstraint = (PathExpressionConstraint) constraint;
                PathExpressionHead pathExpressionHead = pathExpressionConstraint.getHead();
                ValueReference valueReference = pathExpressionHead.getDst();
                resultList.addAll(getUnnamedVariablesFromValueReference(valueReference, true));
            }
        }
        return resultList;
    }

    private static Set<Variable> getUnnamedVariablesFromValueReference(ValueReference valueReference,
            boolean onlyFromAggregatedValues) {
        Set<Variable> resultSet = new HashSet<Variable>();
        if (valueReference != null) {
            if (valueReference instanceof VariableValue) {
                Variable variable = ((VariableValue) valueReference).getValue().getVariable();
                if (variable.getName().startsWith("_") && !onlyFromAggregatedValues) {
                    resultSet.add(variable);
                }
            } else if (valueReference instanceof AggregatedValue) {
                AggregatedValue aggregatedValue = (AggregatedValue) valueReference;
                for (ValueReference valueReferenceInner : aggregatedValue.getCall().getParameters()) {
                    for (Variable variable : getUnnamedVariablesFromValueReference(valueReferenceInner, false)) {
                        if (variable.getName().startsWith("_")) {
                            resultSet.add(variable);
                        }
                    }
                }
            } else if (valueReference instanceof FunctionEvaluationValue) {
            	// TODO this is constant empty?
            	FunctionEvaluationValue eval = (FunctionEvaluationValue) valueReference;
            	final List<Variable> usedVariables =
            			CorePatternLanguageHelper.getUsedVariables(eval.getExpression(),
            					containerPatternBody(eval).getVariables());
                if (!onlyFromAggregatedValues) {
                	for (Variable variable : usedVariables) {
                	    // XXX can this ever be true?
                		if (variable.getName().startsWith("_")) {
                			resultSet.add(variable);
                		}
                	}
                }
            }
        }
        return resultSet;
    }

}
