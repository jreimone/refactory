/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface PatternLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "patternLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/incquery/patternlanguage/PatternLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "patternLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PatternLanguagePackage eINSTANCE = org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl <em>Pattern Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternModel()
   * @generated
   */
  int PATTERN_MODEL = 0;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PACKAGE_NAME = 0;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PATTERNS = 1;

  /**
   * The number of structural features of the '<em>Pattern Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPattern()
   * @generated
   */
  int PATTERN = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__MODIFIERS = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__NAME = 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__PARAMETERS = 3;

  /**
   * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__BODIES = 4;

  /**
   * The feature id for the '<em><b>File Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__FILE_NAME = 5;

  /**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__PARAMETERS = 1;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationParameterImpl <em>Annotation Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationParameterImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAnnotationParameter()
   * @generated
   */
  int ANNOTATION_PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PARAMETER__VALUE = 1;

  /**
   * The number of structural features of the '<em>Annotation Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ModifiersImpl <em>Modifiers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ModifiersImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getModifiers()
   * @generated
   */
  int MODIFIERS = 4;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS__PRIVATE = 0;

  /**
   * The number of structural features of the '<em>Modifiers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>References</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__REFERENCES = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableReferenceImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getVariableReference()
   * @generated
   */
  int VARIABLE_REFERENCE = 6;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE__VAR = 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE__VARIABLE = 1;

  /**
   * The number of structural features of the '<em>Variable Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.TypeImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getType()
   * @generated
   */
  int TYPE = 7;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPENAME = 0;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternBodyImpl <em>Pattern Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternBodyImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternBody()
   * @generated
   */
  int PATTERN_BODY = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_BODY__NAME = 0;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_BODY__CONSTRAINTS = 1;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_BODY__VARIABLES = 2;

  /**
   * The number of structural features of the '<em>Pattern Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_BODY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 9;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl <em>Pattern Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternCall()
   * @generated
   */
  int PATTERN_CALL = 10;

  /**
   * The feature id for the '<em><b>Pattern Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL__PATTERN_REF = 0;

  /**
   * The feature id for the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL__TRANSITIVE = 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL__PARAMETERS = 2;

  /**
   * The number of structural features of the '<em>Pattern Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_CALL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionElementImpl <em>Path Expression Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionElementImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionElement()
   * @generated
   */
  int PATH_EXPRESSION_ELEMENT = 11;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_ELEMENT__TYPE = 0;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_ELEMENT__TAIL = 1;

  /**
   * The number of structural features of the '<em>Path Expression Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ValueReferenceImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getValueReference()
   * @generated
   */
  int VALUE_REFERENCE = 12;

  /**
   * The number of structural features of the '<em>Value Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_REFERENCE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.LiteralValueReferenceImpl <em>Literal Value Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.LiteralValueReferenceImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getLiteralValueReference()
   * @generated
   */
  int LITERAL_VALUE_REFERENCE = 13;

  /**
   * The number of structural features of the '<em>Literal Value Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_VALUE_REFERENCE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ComputationValueImpl <em>Computation Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ComputationValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getComputationValue()
   * @generated
   */
  int COMPUTATION_VALUE = 14;

  /**
   * The number of structural features of the '<em>Computation Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTATION_VALUE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatorExpressionImpl <em>Aggregator Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatorExpressionImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAggregatorExpression()
   * @generated
   */
  int AGGREGATOR_EXPRESSION = 15;

  /**
   * The number of structural features of the '<em>Aggregator Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ParameterRefImpl <em>Parameter Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ParameterRefImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getParameterRef()
   * @generated
   */
  int PARAMETER_REF = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF__NAME = VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF__TYPE = VARIABLE__TYPE;

  /**
   * The feature id for the '<em><b>References</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF__REFERENCES = VARIABLE__REFERENCES;

  /**
   * The feature id for the '<em><b>Referred Param</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF__REFERRED_PARAM = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parameter Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.LocalVariableImpl <em>Local Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.LocalVariableImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getLocalVariable()
   * @generated
   */
  int LOCAL_VARIABLE = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE__NAME = VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE__TYPE = VARIABLE__TYPE;

  /**
   * The feature id for the '<em><b>References</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE__REFERENCES = VARIABLE__REFERENCES;

  /**
   * The number of structural features of the '<em>Local Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.EntityTypeImpl <em>Entity Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.EntityTypeImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getEntityType()
   * @generated
   */
  int ENTITY_TYPE = 18;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_TYPE__TYPENAME = TYPE__TYPENAME;

  /**
   * The number of structural features of the '<em>Entity Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.RelationTypeImpl <em>Relation Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.RelationTypeImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getRelationType()
   * @generated
   */
  int RELATION_TYPE = 19;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_TYPE__TYPENAME = TYPE__TYPENAME;

  /**
   * The number of structural features of the '<em>Relation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCompositionConstraintImpl <em>Pattern Composition Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCompositionConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternCompositionConstraint()
   * @generated
   */
  int PATTERN_COMPOSITION_CONSTRAINT = 20;

  /**
   * The feature id for the '<em><b>Negative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE = CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_COMPOSITION_CONSTRAINT__CALL = CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Pattern Composition Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_COMPOSITION_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.CompareConstraintImpl <em>Compare Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.CompareConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCompareConstraint()
   * @generated
   */
  int COMPARE_CONSTRAINT = 21;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_CONSTRAINT__LEFT_OPERAND = CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_CONSTRAINT__FEATURE = CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_CONSTRAINT__RIGHT_OPERAND = CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Compare Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.CheckConstraintImpl <em>Check Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.CheckConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCheckConstraint()
   * @generated
   */
  int CHECK_CONSTRAINT = 22;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_CONSTRAINT__EXPRESSION = CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Check Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionConstraintImpl <em>Path Expression Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionConstraint()
   * @generated
   */
  int PATH_EXPRESSION_CONSTRAINT = 23;

  /**
   * The feature id for the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_CONSTRAINT__HEAD = CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Path Expression Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionHeadImpl <em>Path Expression Head</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionHeadImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionHead()
   * @generated
   */
  int PATH_EXPRESSION_HEAD = 24;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_HEAD__TYPE = PATH_EXPRESSION_ELEMENT__TYPE;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_HEAD__TAIL = PATH_EXPRESSION_ELEMENT__TAIL;

  /**
   * The feature id for the '<em><b>Src</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_HEAD__SRC = PATH_EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Dst</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_HEAD__DST = PATH_EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Path Expression Head</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_HEAD_FEATURE_COUNT = PATH_EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionTailImpl <em>Path Expression Tail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionTailImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionTail()
   * @generated
   */
  int PATH_EXPRESSION_TAIL = 25;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_TAIL__TYPE = PATH_EXPRESSION_ELEMENT__TYPE;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_TAIL__TAIL = PATH_EXPRESSION_ELEMENT__TAIL;

  /**
   * The feature id for the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_TAIL__INDEX = PATH_EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Closure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_TAIL__CLOSURE = PATH_EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Path Expression Tail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_EXPRESSION_TAIL_FEATURE_COUNT = PATH_EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.IntValueImpl <em>Int Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.IntValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getIntValue()
   * @generated
   */
  int INT_VALUE = 26;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_VALUE__VALUE = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_VALUE_FEATURE_COUNT = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.StringValueImpl <em>String Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.StringValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getStringValue()
   * @generated
   */
  int STRING_VALUE = 27;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE__VALUE = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE_FEATURE_COUNT = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.BoolValueImpl <em>Bool Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.BoolValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getBoolValue()
   * @generated
   */
  int BOOL_VALUE = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_VALUE__VALUE = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_VALUE_FEATURE_COUNT = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.DoubleValueImpl <em>Double Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.DoubleValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getDoubleValue()
   * @generated
   */
  int DOUBLE_VALUE = 29;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_VALUE__VALUE = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_VALUE_FEATURE_COUNT = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableValueImpl <em>Variable Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getVariableValue()
   * @generated
   */
  int VARIABLE_VALUE = 30;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_VALUE__VALUE = VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_VALUE_FEATURE_COUNT = VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ListValueImpl <em>List Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ListValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getListValue()
   * @generated
   */
  int LIST_VALUE = 31;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_VALUE__VALUES = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_VALUE_FEATURE_COUNT = LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatedValueImpl <em>Aggregated Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatedValueImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAggregatedValue()
   * @generated
   */
  int AGGREGATED_VALUE = 32;

  /**
   * The feature id for the '<em><b>Aggregator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATED_VALUE__AGGREGATOR = COMPUTATION_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATED_VALUE__CALL = COMPUTATION_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Aggregated Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATED_VALUE_FEATURE_COUNT = COMPUTATION_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.CountAggregatorImpl <em>Count Aggregator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.CountAggregatorImpl
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCountAggregator()
   * @generated
   */
  int COUNT_AGGREGATOR = 33;

  /**
   * The number of structural features of the '<em>Count Aggregator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COUNT_AGGREGATOR_FEATURE_COUNT = AGGREGATOR_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature <em>Compare Feature</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCompareFeature()
   * @generated
   */
  int COMPARE_FEATURE = 34;


  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Model</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
   * @generated
   */
  EClass getPatternModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPackageName <em>Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPackageName()
   * @see #getPatternModel()
   * @generated
   */
  EAttribute getPatternModel_PackageName();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPatterns <em>Patterns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Patterns</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPatterns()
   * @see #getPatternModel()
   * @generated
   */
  EReference getPatternModel_Patterns();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getAnnotations()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Annotations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modifiers</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getModifiers()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getName()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getParameters()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getBodies <em>Bodies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bodies</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getBodies()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Bodies();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getFileName <em>File Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Pattern#getFileName()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_FileName();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Annotation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Annotation#getName()
   * @see #getAnnotation()
   * @generated
   */
  EAttribute getAnnotation_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Annotation#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Annotation#getParameters()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter <em>Annotation Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Parameter</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter
   * @generated
   */
  EClass getAnnotationParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getName()
   * @see #getAnnotationParameter()
   * @generated
   */
  EAttribute getAnnotationParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getValue()
   * @see #getAnnotationParameter()
   * @generated
   */
  EReference getAnnotationParameter_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifiers</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers
   * @generated
   */
  EClass getModifiers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers#isPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Modifiers#isPrivate()
   * @see #getModifiers()
   * @generated
   */
  EAttribute getModifiers_Private();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Type();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getReferences <em>References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>References</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Variable#getReferences()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_References();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference <em>Variable Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Reference</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference
   * @generated
   */
  EClass getVariableReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference#getVar()
   * @see #getVariableReference()
   * @generated
   */
  EAttribute getVariableReference_Var();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference
   * @see #getVariableReference()
   * @generated
   */
  EReference getVariableReference_Variable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Type#getTypename <em>Typename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Typename</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Type#getTypename()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Typename();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody <em>Pattern Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Body</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
   * @generated
   */
  EClass getPatternBody();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody#getName()
   * @see #getPatternBody()
   * @generated
   */
  EAttribute getPatternBody_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody#getConstraints()
   * @see #getPatternBody()
   * @generated
   */
  EReference getPatternBody_Constraints();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
   * @see #getPatternBody()
   * @generated
   */
  EReference getPatternBody_Variables();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall <em>Pattern Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Call</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall
   * @generated
   */
  EClass getPatternCall();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getPatternRef <em>Pattern Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pattern Ref</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getPatternRef()
   * @see #getPatternCall()
   * @generated
   */
  EReference getPatternCall_PatternRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#isTransitive <em>Transitive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Transitive</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#isTransitive()
   * @see #getPatternCall()
   * @generated
   */
  EAttribute getPatternCall_Transitive();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getParameters()
   * @see #getPatternCall()
   * @generated
   */
  EReference getPatternCall_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement <em>Path Expression Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Expression Element</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement
   * @generated
   */
  EClass getPathExpressionElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement#getType()
   * @see #getPathExpressionElement()
   * @generated
   */
  EReference getPathExpressionElement_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement#getTail()
   * @see #getPathExpressionElement()
   * @generated
   */
  EReference getPathExpressionElement_Tail();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference <em>Value Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Reference</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
   * @generated
   */
  EClass getValueReference();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference <em>Literal Value Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Value Reference</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference
   * @generated
   */
  EClass getLiteralValueReference();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ComputationValue <em>Computation Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Computation Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ComputationValue
   * @generated
   */
  EClass getComputationValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatorExpression <em>Aggregator Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregator Expression</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AggregatorExpression
   * @generated
   */
  EClass getAggregatorExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef <em>Parameter Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Ref</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef
   * @generated
   */
  EClass getParameterRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef#getReferredParam <em>Referred Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referred Param</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef#getReferredParam()
   * @see #getParameterRef()
   * @generated
   */
  EReference getParameterRef_ReferredParam();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.LocalVariable <em>Local Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.LocalVariable
   * @generated
   */
  EClass getLocalVariable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.EntityType <em>Entity Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.EntityType
   * @generated
   */
  EClass getEntityType();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.RelationType <em>Relation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.RelationType
   * @generated
   */
  EClass getRelationType();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint <em>Pattern Composition Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Composition Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint
   * @generated
   */
  EClass getPatternCompositionConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#isNegative <em>Negative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Negative</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#isNegative()
   * @see #getPatternCompositionConstraint()
   * @generated
   */
  EAttribute getPatternCompositionConstraint_Negative();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#getCall()
   * @see #getPatternCompositionConstraint()
   * @generated
   */
  EReference getPatternCompositionConstraint_Call();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint <em>Compare Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compare Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint
   * @generated
   */
  EClass getCompareConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getLeftOperand()
   * @see #getCompareConstraint()
   * @generated
   */
  EReference getCompareConstraint_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getFeature()
   * @see #getCompareConstraint()
   * @generated
   */
  EAttribute getCompareConstraint_Feature();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getRightOperand()
   * @see #getCompareConstraint()
   * @generated
   */
  EReference getCompareConstraint_RightOperand();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint <em>Check Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint
   * @generated
   */
  EClass getCheckConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint#getExpression()
   * @see #getCheckConstraint()
   * @generated
   */
  EReference getCheckConstraint_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint <em>Path Expression Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Expression Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint
   * @generated
   */
  EClass getPathExpressionConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint#getHead <em>Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Head</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint#getHead()
   * @see #getPathExpressionConstraint()
   * @generated
   */
  EReference getPathExpressionConstraint_Head();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead <em>Path Expression Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Expression Head</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead
   * @generated
   */
  EClass getPathExpressionHead();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getSrc <em>Src</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Src</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getSrc()
   * @see #getPathExpressionHead()
   * @generated
   */
  EReference getPathExpressionHead_Src();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getDst <em>Dst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dst</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getDst()
   * @see #getPathExpressionHead()
   * @generated
   */
  EReference getPathExpressionHead_Dst();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail <em>Path Expression Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Expression Tail</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail
   * @generated
   */
  EClass getPathExpressionTail();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#getIndex()
   * @see #getPathExpressionTail()
   * @generated
   */
  EAttribute getPathExpressionTail_Index();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#isClosure <em>Closure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Closure</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#isClosure()
   * @see #getPathExpressionTail()
   * @generated
   */
  EAttribute getPathExpressionTail_Closure();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.IntValue <em>Int Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.IntValue
   * @generated
   */
  EClass getIntValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.IntValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.IntValue#getValue()
   * @see #getIntValue()
   * @generated
   */
  EAttribute getIntValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.StringValue
   * @generated
   */
  EClass getStringValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.StringValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.StringValue#getValue()
   * @see #getStringValue()
   * @generated
   */
  EAttribute getStringValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue <em>Bool Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue
   * @generated
   */
  EClass getBoolValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue#isValue()
   * @see #getBoolValue()
   * @generated
   */
  EAttribute getBoolValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue <em>Double Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue
   * @generated
   */
  EClass getDoubleValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue#getValue()
   * @see #getDoubleValue()
   * @generated
   */
  EAttribute getDoubleValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue <em>Variable Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue
   * @generated
   */
  EClass getVariableValue();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue#getValue()
   * @see #getVariableValue()
   * @generated
   */
  EReference getVariableValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ListValue <em>List Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ListValue
   * @generated
   */
  EClass getListValue();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ListValue#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ListValue#getValues()
   * @see #getListValue()
   * @generated
   */
  EReference getListValue_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue <em>Aggregated Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregated Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue
   * @generated
   */
  EClass getAggregatedValue();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getAggregator <em>Aggregator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Aggregator</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getAggregator()
   * @see #getAggregatedValue()
   * @generated
   */
  EReference getAggregatedValue_Aggregator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getCall()
   * @see #getAggregatedValue()
   * @generated
   */
  EReference getAggregatedValue_Call();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator <em>Count Aggregator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Count Aggregator</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator
   * @generated
   */
  EClass getCountAggregator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature <em>Compare Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Compare Feature</em>'.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature
   * @generated
   */
  EEnum getCompareFeature();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PatternLanguageFactory getPatternLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl <em>Pattern Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternModel()
     * @generated
     */
    EClass PATTERN_MODEL = eINSTANCE.getPatternModel();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_MODEL__PACKAGE_NAME = eINSTANCE.getPatternModel_PackageName();

    /**
     * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_MODEL__PATTERNS = eINSTANCE.getPatternModel_Patterns();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPattern()
     * @generated
     */
    EClass PATTERN = eINSTANCE.getPattern();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__ANNOTATIONS = eINSTANCE.getPattern_Annotations();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__MODIFIERS = eINSTANCE.getPattern_Modifiers();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__NAME = eINSTANCE.getPattern_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__PARAMETERS = eINSTANCE.getPattern_Parameters();

    /**
     * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__BODIES = eINSTANCE.getPattern_Bodies();

    /**
     * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__FILE_NAME = eINSTANCE.getPattern_FileName();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION__NAME = eINSTANCE.getAnnotation_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__PARAMETERS = eINSTANCE.getAnnotation_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationParameterImpl <em>Annotation Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AnnotationParameterImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAnnotationParameter()
     * @generated
     */
    EClass ANNOTATION_PARAMETER = eINSTANCE.getAnnotationParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_PARAMETER__NAME = eINSTANCE.getAnnotationParameter_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_PARAMETER__VALUE = eINSTANCE.getAnnotationParameter_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ModifiersImpl <em>Modifiers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ModifiersImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getModifiers()
     * @generated
     */
    EClass MODIFIERS = eINSTANCE.getModifiers();

    /**
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODIFIERS__PRIVATE = eINSTANCE.getModifiers_Private();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>References</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__REFERENCES = eINSTANCE.getVariable_References();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableReferenceImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getVariableReference()
     * @generated
     */
    EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_REFERENCE__VAR = eINSTANCE.getVariableReference_Var();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.TypeImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Typename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__TYPENAME = eINSTANCE.getType_Typename();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternBodyImpl <em>Pattern Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternBodyImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternBody()
     * @generated
     */
    EClass PATTERN_BODY = eINSTANCE.getPatternBody();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_BODY__NAME = eINSTANCE.getPatternBody_Name();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_BODY__CONSTRAINTS = eINSTANCE.getPatternBody_Constraints();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_BODY__VARIABLES = eINSTANCE.getPatternBody_Variables();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl <em>Pattern Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternCall()
     * @generated
     */
    EClass PATTERN_CALL = eINSTANCE.getPatternCall();

    /**
     * The meta object literal for the '<em><b>Pattern Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_CALL__PATTERN_REF = eINSTANCE.getPatternCall_PatternRef();

    /**
     * The meta object literal for the '<em><b>Transitive</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_CALL__TRANSITIVE = eINSTANCE.getPatternCall_Transitive();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_CALL__PARAMETERS = eINSTANCE.getPatternCall_Parameters();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionElementImpl <em>Path Expression Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionElementImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionElement()
     * @generated
     */
    EClass PATH_EXPRESSION_ELEMENT = eINSTANCE.getPathExpressionElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_EXPRESSION_ELEMENT__TYPE = eINSTANCE.getPathExpressionElement_Type();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_EXPRESSION_ELEMENT__TAIL = eINSTANCE.getPathExpressionElement_Tail();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ValueReferenceImpl <em>Value Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ValueReferenceImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getValueReference()
     * @generated
     */
    EClass VALUE_REFERENCE = eINSTANCE.getValueReference();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.LiteralValueReferenceImpl <em>Literal Value Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.LiteralValueReferenceImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getLiteralValueReference()
     * @generated
     */
    EClass LITERAL_VALUE_REFERENCE = eINSTANCE.getLiteralValueReference();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ComputationValueImpl <em>Computation Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ComputationValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getComputationValue()
     * @generated
     */
    EClass COMPUTATION_VALUE = eINSTANCE.getComputationValue();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatorExpressionImpl <em>Aggregator Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatorExpressionImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAggregatorExpression()
     * @generated
     */
    EClass AGGREGATOR_EXPRESSION = eINSTANCE.getAggregatorExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ParameterRefImpl <em>Parameter Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ParameterRefImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getParameterRef()
     * @generated
     */
    EClass PARAMETER_REF = eINSTANCE.getParameterRef();

    /**
     * The meta object literal for the '<em><b>Referred Param</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_REF__REFERRED_PARAM = eINSTANCE.getParameterRef_ReferredParam();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.LocalVariableImpl <em>Local Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.LocalVariableImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getLocalVariable()
     * @generated
     */
    EClass LOCAL_VARIABLE = eINSTANCE.getLocalVariable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.EntityTypeImpl <em>Entity Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.EntityTypeImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getEntityType()
     * @generated
     */
    EClass ENTITY_TYPE = eINSTANCE.getEntityType();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.RelationTypeImpl <em>Relation Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.RelationTypeImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getRelationType()
     * @generated
     */
    EClass RELATION_TYPE = eINSTANCE.getRelationType();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCompositionConstraintImpl <em>Pattern Composition Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCompositionConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPatternCompositionConstraint()
     * @generated
     */
    EClass PATTERN_COMPOSITION_CONSTRAINT = eINSTANCE.getPatternCompositionConstraint();

    /**
     * The meta object literal for the '<em><b>Negative</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE = eINSTANCE.getPatternCompositionConstraint_Negative();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_COMPOSITION_CONSTRAINT__CALL = eINSTANCE.getPatternCompositionConstraint_Call();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.CompareConstraintImpl <em>Compare Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.CompareConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCompareConstraint()
     * @generated
     */
    EClass COMPARE_CONSTRAINT = eINSTANCE.getCompareConstraint();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE_CONSTRAINT__LEFT_OPERAND = eINSTANCE.getCompareConstraint_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPARE_CONSTRAINT__FEATURE = eINSTANCE.getCompareConstraint_Feature();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE_CONSTRAINT__RIGHT_OPERAND = eINSTANCE.getCompareConstraint_RightOperand();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.CheckConstraintImpl <em>Check Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.CheckConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCheckConstraint()
     * @generated
     */
    EClass CHECK_CONSTRAINT = eINSTANCE.getCheckConstraint();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK_CONSTRAINT__EXPRESSION = eINSTANCE.getCheckConstraint_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionConstraintImpl <em>Path Expression Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionConstraint()
     * @generated
     */
    EClass PATH_EXPRESSION_CONSTRAINT = eINSTANCE.getPathExpressionConstraint();

    /**
     * The meta object literal for the '<em><b>Head</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_EXPRESSION_CONSTRAINT__HEAD = eINSTANCE.getPathExpressionConstraint_Head();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionHeadImpl <em>Path Expression Head</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionHeadImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionHead()
     * @generated
     */
    EClass PATH_EXPRESSION_HEAD = eINSTANCE.getPathExpressionHead();

    /**
     * The meta object literal for the '<em><b>Src</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_EXPRESSION_HEAD__SRC = eINSTANCE.getPathExpressionHead_Src();

    /**
     * The meta object literal for the '<em><b>Dst</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_EXPRESSION_HEAD__DST = eINSTANCE.getPathExpressionHead_Dst();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionTailImpl <em>Path Expression Tail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionTailImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getPathExpressionTail()
     * @generated
     */
    EClass PATH_EXPRESSION_TAIL = eINSTANCE.getPathExpressionTail();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATH_EXPRESSION_TAIL__INDEX = eINSTANCE.getPathExpressionTail_Index();

    /**
     * The meta object literal for the '<em><b>Closure</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATH_EXPRESSION_TAIL__CLOSURE = eINSTANCE.getPathExpressionTail_Closure();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.IntValueImpl <em>Int Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.IntValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getIntValue()
     * @generated
     */
    EClass INT_VALUE = eINSTANCE.getIntValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_VALUE__VALUE = eINSTANCE.getIntValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.StringValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getStringValue()
     * @generated
     */
    EClass STRING_VALUE = eINSTANCE.getStringValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.BoolValueImpl <em>Bool Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.BoolValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getBoolValue()
     * @generated
     */
    EClass BOOL_VALUE = eINSTANCE.getBoolValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_VALUE__VALUE = eINSTANCE.getBoolValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.DoubleValueImpl <em>Double Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.DoubleValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getDoubleValue()
     * @generated
     */
    EClass DOUBLE_VALUE = eINSTANCE.getDoubleValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_VALUE__VALUE = eINSTANCE.getDoubleValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableValueImpl <em>Variable Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.VariableValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getVariableValue()
     * @generated
     */
    EClass VARIABLE_VALUE = eINSTANCE.getVariableValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_VALUE__VALUE = eINSTANCE.getVariableValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ListValueImpl <em>List Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.ListValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getListValue()
     * @generated
     */
    EClass LIST_VALUE = eINSTANCE.getListValue();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_VALUE__VALUES = eINSTANCE.getListValue_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatedValueImpl <em>Aggregated Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.AggregatedValueImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getAggregatedValue()
     * @generated
     */
    EClass AGGREGATED_VALUE = eINSTANCE.getAggregatedValue();

    /**
     * The meta object literal for the '<em><b>Aggregator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AGGREGATED_VALUE__AGGREGATOR = eINSTANCE.getAggregatedValue_Aggregator();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AGGREGATED_VALUE__CALL = eINSTANCE.getAggregatedValue_Call();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.CountAggregatorImpl <em>Count Aggregator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.CountAggregatorImpl
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCountAggregator()
     * @generated
     */
    EClass COUNT_AGGREGATOR = eINSTANCE.getCountAggregator();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature <em>Compare Feature</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature
     * @see org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternLanguagePackageImpl#getCompareFeature()
     * @generated
     */
    EEnum COMPARE_FEATURE = eINSTANCE.getCompareFeature();

  }

} //PatternLanguagePackage
