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
package org.eclipse.incquery.patternlanguage.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

@SuppressWarnings("all")
public class BasePatternLanguageGeneratorPostProcessor implements IXtext2EcorePostProcessor {
  public void process(final GeneratedMetamodel metamodel) {
    EPackage _ePackage = metamodel.getEPackage();
    this.process(_ePackage);
  }
  
  public void process(final EPackage p) {
    EClass patternClass = null;
    EClass bodyClass = null;
    EClass varClass = null;
    EClass paramRefClass = null;
    EClass varRefClass = null;
    EClass pathExpressionConstraint = null;
    EClass pathExpressionElement = null;
    EClass pathExpressionHead = null;
    EClass pathExpressionTail = null;
    EClass type = null;
    EList<EClassifier> _eClassifiers = p.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    for (final EClass c : _filter) {
      String _name = c.getName();
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_name, "Pattern")) {
          _matched=true;
          patternClass = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "PatternBody")) {
          _matched=true;
          bodyClass = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "Variable")) {
          _matched=true;
          varClass = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "ParameterRef")) {
          _matched=true;
          paramRefClass = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "VariableReference")) {
          _matched=true;
          varRefClass = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "PathExpressionConstraint")) {
          _matched=true;
          pathExpressionConstraint = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "PathExpressionElement")) {
          _matched=true;
          pathExpressionElement = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "PathExpressionHead")) {
          _matched=true;
          pathExpressionHead = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "PathExpressionTail")) {
          _matched=true;
          pathExpressionTail = c;
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "Type")) {
          _matched=true;
          type = c;
        }
      }
    }
    this.generateEReference(bodyClass, varClass);
    this.generateReferenceToVariableDecl(varClass, varRefClass);
    this.generateEOperation(bodyClass, varClass);
    this.changeHeadType(pathExpressionConstraint, pathExpressionHead);
    this.changeTailType(pathExpressionElement, pathExpressionTail);
    this.addJvmIdentifiableOperations(varClass);
    this.setTransientReference(paramRefClass);
    this.addWarningComment(varRefClass);
    this.updateTypeClass(type);
  }
  
  public boolean addJvmIdentifiableOperations(final EClass varClass) {
    boolean _xblockexpression = false;
    {
      final EOperation getSimpleNameOp = EcoreFactory.eINSTANCE.createEOperation();
      getSimpleNameOp.setName("getSimpleName");
      getSimpleNameOp.setLowerBound(1);
      getSimpleNameOp.setUpperBound(1);
      EDataType _eString = EcorePackage.eINSTANCE.getEString();
      getSimpleNameOp.setEType(_eString);
      final EAnnotation body = EcoreFactory.eINSTANCE.createEAnnotation();
      body.setSource(GenModelPackage.eNS_URI);
      EClass _eStringToStringMapEntry = EcorePackage.eINSTANCE.getEStringToStringMapEntry();
      EObject _create = EcoreFactory.eINSTANCE.create(_eStringToStringMapEntry);
      final BasicEMap.Entry<String, String> map = ((BasicEMap.Entry<String, String>) _create);
      map.setKey("body");
      map.setValue("return this.name;");
      EMap<String, String> _details = body.getDetails();
      _details.add(map);
      EList<EAnnotation> _eAnnotations = getSimpleNameOp.getEAnnotations();
      _eAnnotations.add(body);
      EList<EOperation> _eOperations = varClass.getEOperations();
      _xblockexpression = _eOperations.add(getSimpleNameOp);
    }
    return _xblockexpression;
  }
  
  public void generateInverseContainerOfBody(final EClass bodyClass, final EClass patternClass) {
    final EReference patternRef = EcoreFactory.eINSTANCE.createEReference();
    patternRef.setTransient(true);
    patternRef.setDerived(true);
    patternRef.setName("pattern");
    patternRef.setLowerBound(1);
    patternRef.setUpperBound(1);
    patternRef.setChangeable(true);
    patternRef.setContainment(true);
    EStructuralFeature _eStructuralFeature = patternClass.getEStructuralFeature("bodies");
    patternRef.setEOpposite(((EReference) _eStructuralFeature));
  }
  
  public boolean generateEReference(final EClass bodyClass, final EClass varClass) {
    boolean _xblockexpression = false;
    {
      final EReference varRef = EcoreFactory.eINSTANCE.createEReference();
      varRef.setTransient(true);
      varRef.setDerived(true);
      varRef.setName("variables");
      varRef.setLowerBound(0);
      varRef.setUpperBound((-1));
      varRef.setEType(varClass);
      varRef.setChangeable(false);
      varRef.setContainment(true);
      final EAnnotation body = EcoreFactory.eINSTANCE.createEAnnotation();
      body.setSource(GenModelPackage.eNS_URI);
      EClass _eStringToStringMapEntry = EcorePackage.eINSTANCE.getEStringToStringMapEntry();
      EObject _create = EcoreFactory.eINSTANCE.create(_eStringToStringMapEntry);
      final BasicEMap.Entry<String, String> map = ((BasicEMap.Entry<String, String>) _create);
      map.setKey("suppressedGetVisibility");
      map.setValue("true");
      EMap<String, String> _details = body.getDetails();
      _details.add(map);
      EList<EAnnotation> _eAnnotations = varRef.getEAnnotations();
      _eAnnotations.add(body);
      EList<EStructuralFeature> _eStructuralFeatures = bodyClass.getEStructuralFeatures();
      _xblockexpression = _eStructuralFeatures.add(varRef);
    }
    return _xblockexpression;
  }
  
  /**
   * Generates a variable reference (and its opposite) in the pattern body and its usages.
   */
  public boolean generateReferenceToVariableDecl(final EClass varClass, final EClass varRefClass) {
    boolean _xblockexpression = false;
    {
      final EReference varRefs = EcoreFactory.eINSTANCE.createEReference();
      varRefs.setTransient(true);
      varRefs.setDerived(true);
      varRefs.setName("references");
      varRefs.setLowerBound(0);
      varRefs.setUpperBound((-1));
      varRefs.setEType(varRefClass);
      varRefs.setContainment(false);
      EList<EStructuralFeature> _eStructuralFeatures = varClass.getEStructuralFeatures();
      _eStructuralFeatures.add(varRefs);
      final EReference variable = EcoreFactory.eINSTANCE.createEReference();
      variable.setTransient(true);
      variable.setDerived(true);
      variable.setName("variable");
      variable.setLowerBound(0);
      variable.setUpperBound(1);
      variable.setEType(varClass);
      variable.setContainment(false);
      EList<EStructuralFeature> _eStructuralFeatures_1 = varRefClass.getEStructuralFeatures();
      _eStructuralFeatures_1.add(variable);
      varRefs.setEOpposite(variable);
      variable.setEOpposite(varRefs);
      final EOperation op = EcoreFactory.eINSTANCE.createEOperation();
      op.setEType(varClass);
      op.setName("getVariable");
      op.setUpperBound(1);
      final EAnnotation body = EcoreFactory.eINSTANCE.createEAnnotation();
      body.setSource(GenModelPackage.eNS_URI);
      EClass _eStringToStringMapEntry = EcorePackage.eINSTANCE.getEStringToStringMapEntry();
      EObject _create = EcoreFactory.eINSTANCE.create(_eStringToStringMapEntry);
      final BasicEMap.Entry<String, String> map = ((BasicEMap.Entry<String, String>) _create);
      map.setKey("body");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if (variable == null) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("InternalEObject container = this.eContainer;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("while (container != null");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("&& !(container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("|| container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.Pattern)) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("container = container.eInternalContainer();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//The side-effect of this call initializes the variable");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("((org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody) container).getVariables();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (container instanceof org.eclipse.incquery.patternlanguage.patternLanguage.Pattern) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("org.eclipse.incquery.patternlanguage.patternLanguage.Pattern pattern =");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("(org.eclipse.incquery.patternlanguage.patternLanguage.Pattern) container;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (org.eclipse.incquery.patternlanguage.patternLanguage.Variable var : pattern.getParameters()) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (var.getName() != null && var.getName().equals(getVar())) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("var.getReferences().add(this);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("return variable;");
      map.setValue(_builder.toString());
      EMap<String, String> _details = body.getDetails();
      _details.add(map);
      EList<EAnnotation> _eAnnotations = op.getEAnnotations();
      _eAnnotations.add(body);
      EList<EOperation> _eOperations = varRefClass.getEOperations();
      _eOperations.add(op);
      final EAnnotation suppressAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
      suppressAnnotation.setSource(GenModelPackage.eNS_URI);
      EClass _eStringToStringMapEntry_1 = EcorePackage.eINSTANCE.getEStringToStringMapEntry();
      EObject _create_1 = EcoreFactory.eINSTANCE.create(_eStringToStringMapEntry_1);
      final BasicEMap.Entry<String, String> suppressBody = ((BasicEMap.Entry<String, String>) _create_1);
      suppressBody.setKey("suppressedGetVisibility");
      suppressBody.setValue("true");
      EMap<String, String> _details_1 = suppressAnnotation.getDetails();
      _details_1.add(suppressBody);
      EList<EReference> _eAllReferences = varRefClass.getEAllReferences();
      final Function1<EReference, Boolean> _function = new Function1<EReference, Boolean>() {
        public Boolean apply(final EReference it) {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, "variable"));
        }
      };
      EReference _findFirst = IterableExtensions.<EReference>findFirst(_eAllReferences, _function);
      EList<EAnnotation> _eAnnotations_1 = _findFirst.getEAnnotations();
      _xblockexpression = _eAnnotations_1.add(suppressAnnotation);
    }
    return _xblockexpression;
  }
  
  /**
   * Generates an EOperation that corresponds with the derived attribute called ''variables''
   * of the PatternBody.
   */
  public boolean generateEOperation(final EClass bodyClass, final EClass varClass) {
    boolean _xblockexpression = false;
    {
      final EOperation op = EcoreFactory.eINSTANCE.createEOperation();
      op.setName("getVariables");
      op.setEType(varClass);
      op.setUpperBound((-1));
      final EAnnotation body = EcoreFactory.eINSTANCE.createEAnnotation();
      body.setSource(GenModelPackage.eNS_URI);
      EClass _eStringToStringMapEntry = EcorePackage.eINSTANCE.getEStringToStringMapEntry();
      EObject _create = EcoreFactory.eINSTANCE.create(_eStringToStringMapEntry);
      final BasicEMap.Entry<String, String> map = ((BasicEMap.Entry<String, String>) _create);
      map.setKey("body");
      map.setValue(
        "\tif (variables == null)\r\n      {\r\n          variables = new EObjectContainmentEList<Variable>(Variable.class, this, PatternLanguagePackage.PATTERN_BODY__VARIABLES);\r\n      }\r\n\r\n      return org.eclipse.incquery.patternlanguage.helper.CorePatternLanguageHelper.getAllVariablesInBody(this, variables);");
      EMap<String, String> _details = body.getDetails();
      _details.add(map);
      EList<EAnnotation> _eAnnotations = op.getEAnnotations();
      _eAnnotations.add(body);
      EList<EOperation> _eOperations = bodyClass.getEOperations();
      _xblockexpression = _eOperations.add(op);
    }
    return _xblockexpression;
  }
  
  public void changeHeadType(final EClass constraint, final EClass head) {
    EList<EStructuralFeature> _eStructuralFeatures = constraint.getEStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      public Boolean apply(final EStructuralFeature e) {
        String _name = e.getName();
        return Boolean.valueOf(Objects.equal(_name, "head"));
      }
    };
    EStructuralFeature _findFirst = IterableExtensions.<EStructuralFeature>findFirst(_eStructuralFeatures, _function);
    _findFirst.setEType(head);
  }
  
  /**
   * The method updates the EClass element: it changes the type of the "tail" EStructuralFeature to the second parameter
   * @param element the EClass to change
   * @param tail the type to set
   */
  public void changeTailType(final EClass element, final EClass tail) {
    EList<EStructuralFeature> _eStructuralFeatures = element.getEStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      public Boolean apply(final EStructuralFeature e) {
        String _name = e.getName();
        return Boolean.valueOf(Objects.equal(_name, "tail"));
      }
    };
    EStructuralFeature _findFirst = IterableExtensions.<EStructuralFeature>findFirst(_eStructuralFeatures, _function);
    _findFirst.setEType(tail);
  }
  
  public void updateTypeClass(final EClass type) {
    EList<EStructuralFeature> _eStructuralFeatures = type.getEStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      public Boolean apply(final EStructuralFeature e) {
        String _name = e.getName();
        return Boolean.valueOf(Objects.equal(_name, "typename"));
      }
    };
    final EStructuralFeature nameFeature = IterableExtensions.<EStructuralFeature>findFirst(_eStructuralFeatures, _function);
    nameFeature.setTransient(true);
  }
  
  public boolean addWarningComment(final EClass varRefClass) {
    boolean _xblockexpression = false;
    {
      EList<EStructuralFeature> _eStructuralFeatures = varRefClass.getEStructuralFeatures();
      final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
        public Boolean apply(final EStructuralFeature e) {
          String _name = e.getName();
          return Boolean.valueOf(Objects.equal(_name, "var"));
        }
      };
      final EStructuralFeature varFeature = IterableExtensions.<EStructuralFeature>findFirst(_eStructuralFeatures, _function);
      EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
      annotation.setSource("http://www.eclipse.org/emf/2002/GenModel");
      EMap<String, String> _details = annotation.getDetails();
      _details.put("documentation", 
        "<p>Warning! This feature contains the original reference text,\r\n         not the variable name. For variable name, use the\r\n         {@link #variable}/{@link Variable#getName} reference chain.\r\n\r\n\t\tThis is significant when using anonymous variables (named \'_\').</p>");
      EList<EAnnotation> _eAnnotations = varFeature.getEAnnotations();
      _xblockexpression = _eAnnotations.add(annotation);
    }
    return _xblockexpression;
  }
  
  public void setTransientReference(final EClass paramRefClass) {
    EList<EReference> _eAllReferences = paramRefClass.getEAllReferences();
    final Function1<EReference, Boolean> _function = new Function1<EReference, Boolean>() {
      public Boolean apply(final EReference r) {
        String _name = r.getName();
        return Boolean.valueOf(Objects.equal(_name, "referredParam"));
      }
    };
    final EReference ref = IterableExtensions.<EReference>findFirst(_eAllReferences, _function);
    ref.setTransient(true);
  }
}
