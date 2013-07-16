/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.patternlanguage.patternLanguage.*;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage
 * @generated
 */
public class PatternLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static PatternLanguagePackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PatternLanguageAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = PatternLanguagePackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object)
  {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PatternLanguageSwitch<Adapter> modelSwitch =
    new PatternLanguageSwitch<Adapter>() {
			@Override
			public Adapter casePatternModel(PatternModel object) {
				return createPatternModelAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseAnnotationParameter(AnnotationParameter object) {
				return createAnnotationParameterAdapter();
			}
			@Override
			public Adapter caseModifiers(Modifiers object) {
				return createModifiersAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseVariableReference(VariableReference object) {
				return createVariableReferenceAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter casePatternBody(PatternBody object) {
				return createPatternBodyAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter casePatternCall(PatternCall object) {
				return createPatternCallAdapter();
			}
			@Override
			public Adapter casePathExpressionElement(PathExpressionElement object) {
				return createPathExpressionElementAdapter();
			}
			@Override
			public Adapter caseValueReference(ValueReference object) {
				return createValueReferenceAdapter();
			}
			@Override
			public Adapter caseLiteralValueReference(LiteralValueReference object) {
				return createLiteralValueReferenceAdapter();
			}
			@Override
			public Adapter caseComputationValue(ComputationValue object) {
				return createComputationValueAdapter();
			}
			@Override
			public Adapter caseAggregatorExpression(AggregatorExpression object) {
				return createAggregatorExpressionAdapter();
			}
			@Override
			public Adapter caseParameterRef(ParameterRef object) {
				return createParameterRefAdapter();
			}
			@Override
			public Adapter caseLocalVariable(LocalVariable object) {
				return createLocalVariableAdapter();
			}
			@Override
			public Adapter caseEntityType(EntityType object) {
				return createEntityTypeAdapter();
			}
			@Override
			public Adapter caseRelationType(RelationType object) {
				return createRelationTypeAdapter();
			}
			@Override
			public Adapter casePatternCompositionConstraint(PatternCompositionConstraint object) {
				return createPatternCompositionConstraintAdapter();
			}
			@Override
			public Adapter caseCompareConstraint(CompareConstraint object) {
				return createCompareConstraintAdapter();
			}
			@Override
			public Adapter caseCheckConstraint(CheckConstraint object) {
				return createCheckConstraintAdapter();
			}
			@Override
			public Adapter casePathExpressionConstraint(PathExpressionConstraint object) {
				return createPathExpressionConstraintAdapter();
			}
			@Override
			public Adapter casePathExpressionHead(PathExpressionHead object) {
				return createPathExpressionHeadAdapter();
			}
			@Override
			public Adapter casePathExpressionTail(PathExpressionTail object) {
				return createPathExpressionTailAdapter();
			}
			@Override
			public Adapter caseIntValue(IntValue object) {
				return createIntValueAdapter();
			}
			@Override
			public Adapter caseStringValue(StringValue object) {
				return createStringValueAdapter();
			}
			@Override
			public Adapter caseBoolValue(BoolValue object) {
				return createBoolValueAdapter();
			}
			@Override
			public Adapter caseDoubleValue(DoubleValue object) {
				return createDoubleValueAdapter();
			}
			@Override
			public Adapter caseVariableValue(VariableValue object) {
				return createVariableValueAdapter();
			}
			@Override
			public Adapter caseListValue(ListValue object) {
				return createListValueAdapter();
			}
			@Override
			public Adapter caseAggregatedValue(AggregatedValue object) {
				return createAggregatedValueAdapter();
			}
			@Override
			public Adapter caseCountAggregator(CountAggregator object) {
				return createCountAggregatorAdapter();
			}
			@Override
			public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object) {
				return createJvmIdentifiableElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel <em>Pattern Model</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
	 * @generated
	 */
  public Adapter createPatternModelAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
	 * @generated
	 */
  public Adapter createPatternAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.Annotation
	 * @generated
	 */
  public Adapter createAnnotationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter <em>Annotation Parameter</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter
	 * @generated
	 */
  public Adapter createAnnotationParameterAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers
	 * @generated
	 */
  public Adapter createModifiersAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.Variable
	 * @generated
	 */
  public Adapter createVariableAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference
	 * @generated
	 */
  public Adapter createVariableReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.Type
	 * @generated
	 */
  public Adapter createTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody <em>Pattern Body</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
	 * @generated
	 */
  public Adapter createPatternBodyAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
	 * @generated
	 */
  public Adapter createConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall <em>Pattern Call</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall
	 * @generated
	 */
  public Adapter createPatternCallAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement <em>Path Expression Element</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement
	 * @generated
	 */
  public Adapter createPathExpressionElementAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
	 * @generated
	 */
  public Adapter createValueReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference <em>Literal Value Reference</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference
	 * @generated
	 */
  public Adapter createLiteralValueReferenceAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ComputationValue <em>Computation Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.ComputationValue
	 * @generated
	 */
  public Adapter createComputationValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatorExpression <em>Aggregator Expression</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.AggregatorExpression
	 * @generated
	 */
  public Adapter createAggregatorExpressionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef <em>Parameter Ref</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef
	 * @generated
	 */
  public Adapter createParameterRefAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.LocalVariable <em>Local Variable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.LocalVariable
	 * @generated
	 */
  public Adapter createLocalVariableAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.EntityType <em>Entity Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.EntityType
	 * @generated
	 */
  public Adapter createEntityTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.RelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.RelationType
	 * @generated
	 */
  public Adapter createRelationTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint <em>Pattern Composition Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint
	 * @generated
	 */
  public Adapter createPatternCompositionConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint <em>Compare Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint
	 * @generated
	 */
  public Adapter createCompareConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint <em>Check Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint
	 * @generated
	 */
  public Adapter createCheckConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint <em>Path Expression Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint
	 * @generated
	 */
  public Adapter createPathExpressionConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead <em>Path Expression Head</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead
	 * @generated
	 */
  public Adapter createPathExpressionHeadAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail <em>Path Expression Tail</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail
	 * @generated
	 */
  public Adapter createPathExpressionTailAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.IntValue
	 * @generated
	 */
  public Adapter createIntValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.StringValue
	 * @generated
	 */
  public Adapter createStringValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue
	 * @generated
	 */
  public Adapter createBoolValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue
	 * @generated
	 */
  public Adapter createDoubleValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue <em>Variable Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue
	 * @generated
	 */
  public Adapter createVariableValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.ListValue
	 * @generated
	 */
  public Adapter createListValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue <em>Aggregated Value</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue
	 * @generated
	 */
  public Adapter createAggregatedValueAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator <em>Count Aggregator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator
	 * @generated
	 */
  public Adapter createCountAggregatorAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmIdentifiableElement
	 * @generated
	 */
  public Adapter createJvmIdentifiableElementAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //PatternLanguageAdapterFactory
