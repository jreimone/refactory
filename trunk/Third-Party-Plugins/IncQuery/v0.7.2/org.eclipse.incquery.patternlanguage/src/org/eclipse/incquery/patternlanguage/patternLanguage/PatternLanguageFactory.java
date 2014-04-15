/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage
 * @generated
 */
public interface PatternLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PatternLanguageFactory eINSTANCE = org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Model</em>'.
   * @generated
   */
  PatternModel createPatternModel();

  /**
   * Returns a new object of class '<em>Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern</em>'.
   * @generated
   */
  Pattern createPattern();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  Annotation createAnnotation();

  /**
   * Returns a new object of class '<em>Annotation Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation Parameter</em>'.
   * @generated
   */
  AnnotationParameter createAnnotationParameter();

  /**
   * Returns a new object of class '<em>Modifiers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Modifiers</em>'.
   * @generated
   */
  Modifiers createModifiers();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Variable Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Reference</em>'.
   * @generated
   */
  VariableReference createVariableReference();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Pattern Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Body</em>'.
   * @generated
   */
  PatternBody createPatternBody();

  /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Pattern Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Call</em>'.
   * @generated
   */
  PatternCall createPatternCall();

  /**
   * Returns a new object of class '<em>Path Expression Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Expression Element</em>'.
   * @generated
   */
  PathExpressionElement createPathExpressionElement();

  /**
   * Returns a new object of class '<em>Value Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Reference</em>'.
   * @generated
   */
  ValueReference createValueReference();

  /**
   * Returns a new object of class '<em>Literal Value Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Value Reference</em>'.
   * @generated
   */
  LiteralValueReference createLiteralValueReference();

  /**
   * Returns a new object of class '<em>Computation Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Computation Value</em>'.
   * @generated
   */
  ComputationValue createComputationValue();

  /**
   * Returns a new object of class '<em>Aggregator Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aggregator Expression</em>'.
   * @generated
   */
  AggregatorExpression createAggregatorExpression();

  /**
   * Returns a new object of class '<em>Parameter Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Ref</em>'.
   * @generated
   */
  ParameterRef createParameterRef();

  /**
   * Returns a new object of class '<em>Local Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Variable</em>'.
   * @generated
   */
  LocalVariable createLocalVariable();

  /**
   * Returns a new object of class '<em>Entity Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity Type</em>'.
   * @generated
   */
  EntityType createEntityType();

  /**
   * Returns a new object of class '<em>Relation Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation Type</em>'.
   * @generated
   */
  RelationType createRelationType();

  /**
   * Returns a new object of class '<em>Pattern Composition Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Composition Constraint</em>'.
   * @generated
   */
  PatternCompositionConstraint createPatternCompositionConstraint();

  /**
   * Returns a new object of class '<em>Compare Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compare Constraint</em>'.
   * @generated
   */
  CompareConstraint createCompareConstraint();

  /**
   * Returns a new object of class '<em>Check Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Check Constraint</em>'.
   * @generated
   */
  CheckConstraint createCheckConstraint();

  /**
   * Returns a new object of class '<em>Path Expression Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Expression Constraint</em>'.
   * @generated
   */
  PathExpressionConstraint createPathExpressionConstraint();

  /**
   * Returns a new object of class '<em>Path Expression Head</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Expression Head</em>'.
   * @generated
   */
  PathExpressionHead createPathExpressionHead();

  /**
   * Returns a new object of class '<em>Path Expression Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Expression Tail</em>'.
   * @generated
   */
  PathExpressionTail createPathExpressionTail();

  /**
   * Returns a new object of class '<em>Int Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Value</em>'.
   * @generated
   */
  IntValue createIntValue();

  /**
   * Returns a new object of class '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Value</em>'.
   * @generated
   */
  StringValue createStringValue();

  /**
   * Returns a new object of class '<em>Bool Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Value</em>'.
   * @generated
   */
  BoolValue createBoolValue();

  /**
   * Returns a new object of class '<em>Double Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Double Value</em>'.
   * @generated
   */
  DoubleValue createDoubleValue();

  /**
   * Returns a new object of class '<em>Variable Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Value</em>'.
   * @generated
   */
  VariableValue createVariableValue();

  /**
   * Returns a new object of class '<em>List Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Value</em>'.
   * @generated
   */
  ListValue createListValue();

  /**
   * Returns a new object of class '<em>Aggregated Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aggregated Value</em>'.
   * @generated
   */
  AggregatedValue createAggregatedValue();

  /**
   * Returns a new object of class '<em>Count Aggregator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Count Aggregator</em>'.
   * @generated
   */
  CountAggregator createCountAggregator();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PatternLanguagePackage getPatternLanguagePackage();

} //PatternLanguageFactory
