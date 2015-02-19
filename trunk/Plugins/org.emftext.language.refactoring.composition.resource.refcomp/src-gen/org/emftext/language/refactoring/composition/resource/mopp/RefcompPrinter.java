/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

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

public class RefcompPrinter implements org.emftext.language.refactoring.composition.resource.IRefcompTextPrinter {
	
	protected org.emftext.language.refactoring.composition.resource.IRefcompTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.composition.resource.mopp.RefcompTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public RefcompPrinter(OutputStream outputStream, org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource) {
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
		
		if (element instanceof org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping) {
			print_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping((org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping) {
			print_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping((org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) {
			print_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding((org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.refactoring.composition.resource.mopp.RefcompReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.composition.resource.mopp.RefcompReferenceResolverSwitch) new org.emftext.language.refactoring.composition.resource.mopp.RefcompMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		org.emftext.language.refactoring.composition.resource.IRefcompTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.refactoring.composition.resource.mopp.RefcompProblem(errorMessage, org.emftext.language.refactoring.composition.resource.RefcompEProblemType.PRINT_PROBLEM, org.emftext.language.refactoring.composition.resource.RefcompEProblemSeverity.WARNING), cause);
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
	
	public org.emftext.language.refactoring.composition.resource.IRefcompTextResource getResource() {
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
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_CompositeRoleMapping(org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL));
		printCountingMap.put("targetMetamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST));
		printCountingMap.put("first", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE));
		printCountingMap.put("sequence", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("COMPOSITE");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("REFACTORING");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("FOR");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("targetMetamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeRoleMappingTargetMetamodelReferenceResolver().deResolve((org.eclipse.emf.ecore.EPackage) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__TARGET_METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("targetMetamodel", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("first");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeRoleMappingFirstReferenceResolver().deResolve((org.emftext.language.refactoring.rolemapping.RoleMapping) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__FIRST), element));
				out.print(" ");
			}
			printCountingMap.put("first", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("sequence");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.COMPOSITE_ROLE_MAPPING__SEQUENCE));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("sequence", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping(org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING));
		printCountingMap.put("nextMapping", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__PREVIOUS_MAPPING));
		printCountingMap.put("previousMapping", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS));
		printCountingMap.put("bindings", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING));
		printCountingMap.put("roleMapping", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("roleMapping");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getBoundRoleMappingRoleMappingReferenceResolver().deResolve((org.emftext.language.refactoring.rolemapping.RoleMapping) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__ROLE_MAPPING), element));
			}
			printCountingMap.put("roleMapping", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping_0(org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bindings");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__BINDINGS));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("bindings", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_BoundRoleMapping_1(org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("nextMapping");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.BOUND_ROLE_MAPPING__NEXT_MAPPING));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("nextMapping", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding(org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL));
		printCountingMap.put("sourceRoleModel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL));
		printCountingMap.put("targetRoleModel", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingSourceReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE), element));
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingTargetReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding_0(org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("sourceRoleModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingSourceRoleModelReferenceResolver().deResolve((org.emftext.language.refactoring.roles.RoleModel) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__SOURCE_ROLE_MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("sourceRoleModel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoringcomposition_SourceTargetBinding_1(org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("targetRoleModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL));
			if (o != null) {
				org.emftext.language.refactoring.composition.resource.IRefcompTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSourceTargetBindingTargetRoleModelReferenceResolver().deResolve((org.emftext.language.refactoring.roles.RoleModel) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.SOURCE_TARGET_BINDING__TARGET_ROLE_MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("targetRoleModel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
	}
	
	
}
