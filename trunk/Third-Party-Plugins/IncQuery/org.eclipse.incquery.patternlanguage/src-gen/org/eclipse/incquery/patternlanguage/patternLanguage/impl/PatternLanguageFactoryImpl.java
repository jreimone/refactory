/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.incquery.patternlanguage.patternLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternLanguageFactoryImpl extends EFactoryImpl implements PatternLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PatternLanguageFactory init()
  {
    try
    {
      PatternLanguageFactory thePatternLanguageFactory = (PatternLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/incquery/patternlanguage/PatternLanguage"); 
      if (thePatternLanguageFactory != null)
      {
        return thePatternLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PatternLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case PatternLanguagePackage.PATTERN_MODEL: return createPatternModel();
      case PatternLanguagePackage.PATTERN: return createPattern();
      case PatternLanguagePackage.ANNOTATION: return createAnnotation();
      case PatternLanguagePackage.ANNOTATION_PARAMETER: return createAnnotationParameter();
      case PatternLanguagePackage.MODIFIERS: return createModifiers();
      case PatternLanguagePackage.VARIABLE: return createVariable();
      case PatternLanguagePackage.VARIABLE_REFERENCE: return createVariableReference();
      case PatternLanguagePackage.TYPE: return createType();
      case PatternLanguagePackage.PATTERN_BODY: return createPatternBody();
      case PatternLanguagePackage.CONSTRAINT: return createConstraint();
      case PatternLanguagePackage.PATTERN_CALL: return createPatternCall();
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT: return createPathExpressionElement();
      case PatternLanguagePackage.VALUE_REFERENCE: return createValueReference();
      case PatternLanguagePackage.LITERAL_VALUE_REFERENCE: return createLiteralValueReference();
      case PatternLanguagePackage.COMPUTATION_VALUE: return createComputationValue();
      case PatternLanguagePackage.AGGREGATOR_EXPRESSION: return createAggregatorExpression();
      case PatternLanguagePackage.PARAMETER_REF: return createParameterRef();
      case PatternLanguagePackage.LOCAL_VARIABLE: return createLocalVariable();
      case PatternLanguagePackage.ENTITY_TYPE: return createEntityType();
      case PatternLanguagePackage.RELATION_TYPE: return createRelationType();
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT: return createPatternCompositionConstraint();
      case PatternLanguagePackage.COMPARE_CONSTRAINT: return createCompareConstraint();
      case PatternLanguagePackage.CHECK_CONSTRAINT: return createCheckConstraint();
      case PatternLanguagePackage.PATH_EXPRESSION_CONSTRAINT: return createPathExpressionConstraint();
      case PatternLanguagePackage.PATH_EXPRESSION_HEAD: return createPathExpressionHead();
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL: return createPathExpressionTail();
      case PatternLanguagePackage.INT_VALUE: return createIntValue();
      case PatternLanguagePackage.STRING_VALUE: return createStringValue();
      case PatternLanguagePackage.BOOL_VALUE: return createBoolValue();
      case PatternLanguagePackage.DOUBLE_VALUE: return createDoubleValue();
      case PatternLanguagePackage.VARIABLE_VALUE: return createVariableValue();
      case PatternLanguagePackage.LIST_VALUE: return createListValue();
      case PatternLanguagePackage.AGGREGATED_VALUE: return createAggregatedValue();
      case PatternLanguagePackage.COUNT_AGGREGATOR: return createCountAggregator();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case PatternLanguagePackage.COMPARE_FEATURE:
        return createCompareFeatureFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case PatternLanguagePackage.COMPARE_FEATURE:
        return convertCompareFeatureToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternModel createPatternModel()
  {
    PatternModelImpl patternModel = new PatternModelImpl();
    return patternModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern createPattern()
  {
    PatternImpl pattern = new PatternImpl();
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationParameter createAnnotationParameter()
  {
    AnnotationParameterImpl annotationParameter = new AnnotationParameterImpl();
    return annotationParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modifiers createModifiers()
  {
    ModifiersImpl modifiers = new ModifiersImpl();
    return modifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableReference createVariableReference()
  {
    VariableReferenceImpl variableReference = new VariableReferenceImpl();
    return variableReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternBody createPatternBody()
  {
    PatternBodyImpl patternBody = new PatternBodyImpl();
    return patternBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternCall createPatternCall()
  {
    PatternCallImpl patternCall = new PatternCallImpl();
    return patternCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathExpressionElement createPathExpressionElement()
  {
    PathExpressionElementImpl pathExpressionElement = new PathExpressionElementImpl();
    return pathExpressionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueReference createValueReference()
  {
    ValueReferenceImpl valueReference = new ValueReferenceImpl();
    return valueReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralValueReference createLiteralValueReference()
  {
    LiteralValueReferenceImpl literalValueReference = new LiteralValueReferenceImpl();
    return literalValueReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComputationValue createComputationValue()
  {
    ComputationValueImpl computationValue = new ComputationValueImpl();
    return computationValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregatorExpression createAggregatorExpression()
  {
    AggregatorExpressionImpl aggregatorExpression = new AggregatorExpressionImpl();
    return aggregatorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterRef createParameterRef()
  {
    ParameterRefImpl parameterRef = new ParameterRefImpl();
    return parameterRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalVariable createLocalVariable()
  {
    LocalVariableImpl localVariable = new LocalVariableImpl();
    return localVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityType createEntityType()
  {
    EntityTypeImpl entityType = new EntityTypeImpl();
    return entityType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationType createRelationType()
  {
    RelationTypeImpl relationType = new RelationTypeImpl();
    return relationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternCompositionConstraint createPatternCompositionConstraint()
  {
    PatternCompositionConstraintImpl patternCompositionConstraint = new PatternCompositionConstraintImpl();
    return patternCompositionConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompareConstraint createCompareConstraint()
  {
    CompareConstraintImpl compareConstraint = new CompareConstraintImpl();
    return compareConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CheckConstraint createCheckConstraint()
  {
    CheckConstraintImpl checkConstraint = new CheckConstraintImpl();
    return checkConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathExpressionConstraint createPathExpressionConstraint()
  {
    PathExpressionConstraintImpl pathExpressionConstraint = new PathExpressionConstraintImpl();
    return pathExpressionConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathExpressionHead createPathExpressionHead()
  {
    PathExpressionHeadImpl pathExpressionHead = new PathExpressionHeadImpl();
    return pathExpressionHead;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathExpressionTail createPathExpressionTail()
  {
    PathExpressionTailImpl pathExpressionTail = new PathExpressionTailImpl();
    return pathExpressionTail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntValue createIntValue()
  {
    IntValueImpl intValue = new IntValueImpl();
    return intValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringValue createStringValue()
  {
    StringValueImpl stringValue = new StringValueImpl();
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolValue createBoolValue()
  {
    BoolValueImpl boolValue = new BoolValueImpl();
    return boolValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleValue createDoubleValue()
  {
    DoubleValueImpl doubleValue = new DoubleValueImpl();
    return doubleValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableValue createVariableValue()
  {
    VariableValueImpl variableValue = new VariableValueImpl();
    return variableValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListValue createListValue()
  {
    ListValueImpl listValue = new ListValueImpl();
    return listValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregatedValue createAggregatedValue()
  {
    AggregatedValueImpl aggregatedValue = new AggregatedValueImpl();
    return aggregatedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CountAggregator createCountAggregator()
  {
    CountAggregatorImpl countAggregator = new CountAggregatorImpl();
    return countAggregator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompareFeature createCompareFeatureFromString(EDataType eDataType, String initialValue)
  {
    CompareFeature result = CompareFeature.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCompareFeatureToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternLanguagePackage getPatternLanguagePackage()
  {
    return (PatternLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PatternLanguagePackage getPackage()
  {
    return PatternLanguagePackage.eINSTANCE;
  }

} //PatternLanguageFactoryImpl
