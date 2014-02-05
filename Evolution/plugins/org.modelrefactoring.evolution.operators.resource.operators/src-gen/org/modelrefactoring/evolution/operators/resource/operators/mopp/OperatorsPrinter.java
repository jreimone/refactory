/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class OperatorsPrinter implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextPrinter {
	
	protected org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolverFactory tokenResolverFactory = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public OperatorsPrinter(OutputStream outputStream, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(Map<String, Integer> featureCounter, Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(EObject element, PrintWriter out, String globaltab) {
		if (element == null) {
			throw new IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.modelrefactoring.evolution.operators.EObjectReference) {
			print_org_modelrefactoring_evolution_operators_EObjectReference((org.modelrefactoring.evolution.operators.EObjectReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.VariableReference) {
			print_org_modelrefactoring_evolution_operators_VariableReference((org.modelrefactoring.evolution.operators.VariableReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.VAR) {
			print_org_modelrefactoring_evolution_operators_VAR((org.modelrefactoring.evolution.operators.VAR) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.QueryVariable) {
			print_org_modelrefactoring_evolution_operators_QueryVariable((org.modelrefactoring.evolution.operators.QueryVariable) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier) {
			print_org_modelrefactoring_evolution_operators_EStructuralFeatureQualifier((org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.EOperationQualifier) {
			print_org_modelrefactoring_evolution_operators_EOperationQualifier((org.modelrefactoring.evolution.operators.EOperationQualifier) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.CREATE) {
			print_org_modelrefactoring_evolution_operators_CREATE((org.modelrefactoring.evolution.operators.CREATE) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.TypeVariable) {
			print_org_modelrefactoring_evolution_operators_TypeVariable((org.modelrefactoring.evolution.operators.TypeVariable) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.DELETE) {
			print_org_modelrefactoring_evolution_operators_DELETE((org.modelrefactoring.evolution.operators.DELETE) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.ASSIGN) {
			print_org_modelrefactoring_evolution_operators_ASSIGN((org.modelrefactoring.evolution.operators.ASSIGN) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.SET) {
			print_org_modelrefactoring_evolution_operators_SET((org.modelrefactoring.evolution.operators.SET) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.operators.MOVE) {
			print_org_modelrefactoring_evolution_operators_MOVE((org.modelrefactoring.evolution.operators.MOVE) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsReferenceResolverSwitch) new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsProblem(errorMessage, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemType.PRINT_PROBLEM, org.modelrefactoring.evolution.operators.resource.operators.OperatorsEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(Map<?,?> options) {
		this.options = options;
	}
	
	public Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(EObject element) throws java.io.IOException {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
	}
	
	public void print_org_modelrefactoring_evolution_operators_EObjectReference(org.modelrefactoring.evolution.operators.EObjectReference element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS));
		printCountingMap.put("elements", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("elements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceElementsReferenceResolver().deResolve((org.eclipse.emf.ecore.EObject) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), element));
				out.print(" ");
			}
			printCountingMap.put("elements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_org_modelrefactoring_evolution_operators_EObjectReference_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_modelrefactoring_evolution_operators_EObjectReference_0(org.modelrefactoring.evolution.operators.EObjectReference element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("elements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceElementsReferenceResolver().deResolve((org.eclipse.emf.ecore.EObject) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOBJECT_REFERENCE__ELEMENTS), element));
				out.print(" ");
			}
			printCountingMap.put("elements", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_VariableReference(org.modelrefactoring.evolution.operators.VariableReference element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE));
		printCountingMap.put("referencedVariable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("referencedVariable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableReferenceReferencedVariableReferenceResolver().deResolve((org.modelrefactoring.evolution.operators.Variable) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VARIABLE_REFERENCE__REFERENCED_VARIABLE), element));
				out.print(" ");
			}
			printCountingMap.put("referencedVariable", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_VAR(org.modelrefactoring.evolution.operators.VAR element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VAR__RESULT));
		printCountingMap.put("result", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VAR__EXECUTED));
		printCountingMap.put("executed", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VAR__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("var");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.VAR__VARIABLE));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_QueryVariable(org.modelrefactoring.evolution.operators.QueryVariable element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT));
		printCountingMap.put("queryObject", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUERY_RESULT));
		printCountingMap.put("queryResult", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUALIFIER));
		printCountingMap.put("qualifier", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__NAME));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("queryObject");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUERY_OBJECT));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("queryObject", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("qualifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.QUERY_VARIABLE__QUALIFIER));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("qualifier", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_EStructuralFeatureQualifier(org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ESTRUCTURAL_FEATURE_QUALIFIER__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ESTRUCTURAL_FEATURE_QUALIFIER__STRUCTURAL_FEATURE));
		printCountingMap.put("structuralFeature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("structuralFeature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ESTRUCTURAL_FEATURE_QUALIFIER__STRUCTURAL_FEATURE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEStructuralFeatureQualifierStructuralFeatureReferenceResolver().deResolve((org.eclipse.emf.ecore.EStructuralFeature) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ESTRUCTURAL_FEATURE_QUALIFIER__STRUCTURAL_FEATURE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ESTRUCTURAL_FEATURE_QUALIFIER__STRUCTURAL_FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("structuralFeature", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_EOperationQualifier(org.modelrefactoring.evolution.operators.EOperationQualifier element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION));
		printCountingMap.put("operation", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("operation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEOperationQualifierOperationReferenceResolver().deResolve((org.eclipse.emf.ecore.EOperation) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.EOPERATION_QUALIFIER__OPERATION), element));
				out.print(" ");
			}
			printCountingMap.put("operation", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_CREATE(org.modelrefactoring.evolution.operators.CREATE element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__RESULT));
		printCountingMap.put("result", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__EXECUTED));
		printCountingMap.put("executed", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE));
		printCountingMap.put("newInstanceVariable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT));
		printCountingMap.put("parent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE));
		printCountingMap.put("parentCompositeReference", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("create");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("newInstanceVariable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__NEW_INSTANCE_VARIABLE));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("newInstanceVariable", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("in");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("parent", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("parentCompositeReference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCREATEParentCompositeReferenceReferenceResolver().deResolve((org.eclipse.emf.ecore.EReference) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.CREATE__PARENT_COMPOSITE_REFERENCE), element));
				out.print(" ");
			}
			printCountingMap.put("parentCompositeReference", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_TypeVariable(org.modelrefactoring.evolution.operators.TypeVariable element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__INSTANCE));
		printCountingMap.put("instance", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__NAME));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("new");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypeVariableTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EClass) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.TYPE_VARIABLE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_DELETE(org.modelrefactoring.evolution.operators.DELETE element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.DELETE__RESULT));
		printCountingMap.put("result", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.DELETE__EXECUTED));
		printCountingMap.put("executed", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.DELETE__DELETION));
		printCountingMap.put("deletion", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("delete");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("deletion");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.DELETE__DELETION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("deletion", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_ASSIGN(org.modelrefactoring.evolution.operators.ASSIGN element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__RESULT));
		printCountingMap.put("result", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__EXECUTED));
		printCountingMap.put("executed", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE));
		printCountingMap.put("attribute", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER));
		printCountingMap.put("attributeOwner", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("attributeOwner");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE_OWNER));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("attributeOwner", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("attribute");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getASSIGNAttributeReferenceResolver().deResolve((org.eclipse.emf.ecore.EAttribute) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__ATTRIBUTE), element));
			}
			printCountingMap.put("attribute", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__VALUE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.ASSIGN__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_SET(org.modelrefactoring.evolution.operators.SET element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__RESULT));
		printCountingMap.put("result", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__EXECUTED));
		printCountingMap.put("executed", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE));
		printCountingMap.put("reference", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE_OWNER));
		printCountingMap.put("referenceOwner", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("referenceOwner");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE_OWNER));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("referenceOwner", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("reference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSETReferenceReferenceResolver().deResolve((org.eclipse.emf.ecore.EReference) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__REFERENCE), element));
			}
			printCountingMap.put("reference", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.SET__VALUE));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_operators_MOVE(org.modelrefactoring.evolution.operators.MOVE element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__RESULT));
		printCountingMap.put("result", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__EXECUTED));
		printCountingMap.put("executed", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__NEW_PARENT));
		printCountingMap.put("newParent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE));
		printCountingMap.put("parentReference", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__MOVEE));
		printCountingMap.put("movee", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("move");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("movee");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__MOVEE));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("movee", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("to");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("newParent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__NEW_PARENT));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("newParent", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("parentReference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE));
			if (o != null) {
				org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMOVEParentReferenceReferenceResolver().deResolve((org.eclipse.emf.ecore.EReference) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.operators.OperatorsPackage.MOVE__PARENT_REFERENCE), element));
				out.print(" ");
			}
			printCountingMap.put("parentReference", count - 1);
		}
	}
	
	
}
