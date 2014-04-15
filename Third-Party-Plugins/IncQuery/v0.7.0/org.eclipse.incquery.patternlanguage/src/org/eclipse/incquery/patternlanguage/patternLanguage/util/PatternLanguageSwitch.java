/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.incquery.patternlanguage.patternLanguage.*;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage
 * @generated
 */
public class PatternLanguageSwitch<T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static PatternLanguagePackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PatternLanguageSwitch()
  {
		if (modelPackage == null) {
			modelPackage = PatternLanguagePackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID) {
			case PatternLanguagePackage.PATTERN_MODEL: {
				PatternModel patternModel = (PatternModel)theEObject;
				T result = casePatternModel(patternModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.ANNOTATION_PARAMETER: {
				AnnotationParameter annotationParameter = (AnnotationParameter)theEObject;
				T result = caseAnnotationParameter(annotationParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.MODIFIERS: {
				Modifiers modifiers = (Modifiers)theEObject;
				T result = caseModifiers(modifiers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseJvmIdentifiableElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATTERN_BODY: {
				PatternBody patternBody = (PatternBody)theEObject;
				T result = casePatternBody(patternBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATTERN_CALL: {
				PatternCall patternCall = (PatternCall)theEObject;
				T result = casePatternCall(patternCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT: {
				PathExpressionElement pathExpressionElement = (PathExpressionElement)theEObject;
				T result = casePathExpressionElement(pathExpressionElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.VALUE_REFERENCE: {
				ValueReference valueReference = (ValueReference)theEObject;
				T result = caseValueReference(valueReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.LITERAL_VALUE_REFERENCE: {
				LiteralValueReference literalValueReference = (LiteralValueReference)theEObject;
				T result = caseLiteralValueReference(literalValueReference);
				if (result == null) result = caseValueReference(literalValueReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.COMPUTATION_VALUE: {
				ComputationValue computationValue = (ComputationValue)theEObject;
				T result = caseComputationValue(computationValue);
				if (result == null) result = caseValueReference(computationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.AGGREGATOR_EXPRESSION: {
				AggregatorExpression aggregatorExpression = (AggregatorExpression)theEObject;
				T result = caseAggregatorExpression(aggregatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PARAMETER_REF: {
				ParameterRef parameterRef = (ParameterRef)theEObject;
				T result = caseParameterRef(parameterRef);
				if (result == null) result = caseVariable(parameterRef);
				if (result == null) result = caseJvmIdentifiableElement(parameterRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.LOCAL_VARIABLE: {
				LocalVariable localVariable = (LocalVariable)theEObject;
				T result = caseLocalVariable(localVariable);
				if (result == null) result = caseVariable(localVariable);
				if (result == null) result = caseJvmIdentifiableElement(localVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.ENTITY_TYPE: {
				EntityType entityType = (EntityType)theEObject;
				T result = caseEntityType(entityType);
				if (result == null) result = caseType(entityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.RELATION_TYPE: {
				RelationType relationType = (RelationType)theEObject;
				T result = caseRelationType(relationType);
				if (result == null) result = caseType(relationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT: {
				PatternCompositionConstraint patternCompositionConstraint = (PatternCompositionConstraint)theEObject;
				T result = casePatternCompositionConstraint(patternCompositionConstraint);
				if (result == null) result = caseConstraint(patternCompositionConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.COMPARE_CONSTRAINT: {
				CompareConstraint compareConstraint = (CompareConstraint)theEObject;
				T result = caseCompareConstraint(compareConstraint);
				if (result == null) result = caseConstraint(compareConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.CHECK_CONSTRAINT: {
				CheckConstraint checkConstraint = (CheckConstraint)theEObject;
				T result = caseCheckConstraint(checkConstraint);
				if (result == null) result = caseConstraint(checkConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATH_EXPRESSION_CONSTRAINT: {
				PathExpressionConstraint pathExpressionConstraint = (PathExpressionConstraint)theEObject;
				T result = casePathExpressionConstraint(pathExpressionConstraint);
				if (result == null) result = caseConstraint(pathExpressionConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATH_EXPRESSION_HEAD: {
				PathExpressionHead pathExpressionHead = (PathExpressionHead)theEObject;
				T result = casePathExpressionHead(pathExpressionHead);
				if (result == null) result = casePathExpressionElement(pathExpressionHead);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.PATH_EXPRESSION_TAIL: {
				PathExpressionTail pathExpressionTail = (PathExpressionTail)theEObject;
				T result = casePathExpressionTail(pathExpressionTail);
				if (result == null) result = casePathExpressionElement(pathExpressionTail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.INT_VALUE: {
				IntValue intValue = (IntValue)theEObject;
				T result = caseIntValue(intValue);
				if (result == null) result = caseLiteralValueReference(intValue);
				if (result == null) result = caseValueReference(intValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.STRING_VALUE: {
				StringValue stringValue = (StringValue)theEObject;
				T result = caseStringValue(stringValue);
				if (result == null) result = caseLiteralValueReference(stringValue);
				if (result == null) result = caseValueReference(stringValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.BOOL_VALUE: {
				BoolValue boolValue = (BoolValue)theEObject;
				T result = caseBoolValue(boolValue);
				if (result == null) result = caseLiteralValueReference(boolValue);
				if (result == null) result = caseValueReference(boolValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.DOUBLE_VALUE: {
				DoubleValue doubleValue = (DoubleValue)theEObject;
				T result = caseDoubleValue(doubleValue);
				if (result == null) result = caseLiteralValueReference(doubleValue);
				if (result == null) result = caseValueReference(doubleValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.VARIABLE_VALUE: {
				VariableValue variableValue = (VariableValue)theEObject;
				T result = caseVariableValue(variableValue);
				if (result == null) result = caseValueReference(variableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.LIST_VALUE: {
				ListValue listValue = (ListValue)theEObject;
				T result = caseListValue(listValue);
				if (result == null) result = caseLiteralValueReference(listValue);
				if (result == null) result = caseValueReference(listValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.AGGREGATED_VALUE: {
				AggregatedValue aggregatedValue = (AggregatedValue)theEObject;
				T result = caseAggregatedValue(aggregatedValue);
				if (result == null) result = caseComputationValue(aggregatedValue);
				if (result == null) result = caseValueReference(aggregatedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternLanguagePackage.COUNT_AGGREGATOR: {
				CountAggregator countAggregator = (CountAggregator)theEObject;
				T result = caseCountAggregator(countAggregator);
				if (result == null) result = caseAggregatorExpression(countAggregator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePatternModel(PatternModel object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePattern(Pattern object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAnnotation(Annotation object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Parameter</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAnnotationParameter(AnnotationParameter object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiers</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseModifiers(Modifiers object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariable(Variable object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariableReference(VariableReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseType(Type object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Body</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePatternBody(PatternBody object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConstraint(Constraint object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Call</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePatternCall(PatternCall object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Expression Element</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Expression Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePathExpressionElement(PathExpressionElement object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Value Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseValueReference(ValueReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Value Reference</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Value Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLiteralValueReference(LiteralValueReference object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Computation Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseComputationValue(ComputationValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregator Expression</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAggregatorExpression(AggregatorExpression object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Ref</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseParameterRef(ParameterRef object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLocalVariable(LocalVariable object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseEntityType(EntityType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRelationType(RelationType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Composition Constraint</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Composition Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePatternCompositionConstraint(PatternCompositionConstraint object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Constraint</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCompareConstraint(CompareConstraint object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Check Constraint</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCheckConstraint(CheckConstraint object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Expression Constraint</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Expression Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePathExpressionConstraint(PathExpressionConstraint object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Expression Head</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Expression Head</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePathExpressionHead(PathExpressionHead object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Expression Tail</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Expression Tail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePathExpressionTail(PathExpressionTail object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIntValue(IntValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStringValue(StringValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBoolValue(BoolValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Double Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDoubleValue(DoubleValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVariableValue(VariableValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>List Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseListValue(ListValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregated Value</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregated Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAggregatedValue(AggregatedValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Count Aggregator</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Count Aggregator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCountAggregator(CountAggregator object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseJvmIdentifiableElement(JvmIdentifiableElement object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object)
  {
		return null;
	}

} //PatternLanguageSwitch
