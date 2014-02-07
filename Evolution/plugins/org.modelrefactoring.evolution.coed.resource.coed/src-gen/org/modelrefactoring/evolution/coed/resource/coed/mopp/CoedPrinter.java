/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

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

public class CoedPrinter implements org.modelrefactoring.evolution.coed.resource.coed.ICoedTextPrinter {
	
	protected org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolverFactory tokenResolverFactory = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public CoedPrinter(OutputStream outputStream, org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource) {
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
		
		if (element instanceof org.modelrefactoring.evolution.coed.CoEvolutionDefinition) {
			print_org_modelrefactoring_evolution_coed_CoEvolutionDefinition((org.modelrefactoring.evolution.coed.CoEvolutionDefinition) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.coed.MetamodelImport) {
			print_org_modelrefactoring_evolution_coed_MetamodelImport((org.modelrefactoring.evolution.coed.MetamodelImport) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.coed.PlainCondition) {
			print_org_modelrefactoring_evolution_coed_PlainCondition((org.modelrefactoring.evolution.coed.PlainCondition) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.coed.RoleMappingEvent) {
			print_org_modelrefactoring_evolution_coed_RoleMappingEvent((org.modelrefactoring.evolution.coed.RoleMappingEvent) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.evolution.coed.RoleMappingAction) {
			print_org_modelrefactoring_evolution_coed_RoleMappingAction((org.modelrefactoring.evolution.coed.RoleMappingAction) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedReferenceResolverSwitch) new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedProblem(errorMessage, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemType.PRINT_PROBLEM, org.modelrefactoring.evolution.coed.resource.coed.CoedEProblemSeverity.WARNING), cause);
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
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource getResource() {
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
	
	public void print_org_modelrefactoring_evolution_coed_CoEvolutionDefinition(org.modelrefactoring.evolution.coed.CoEvolutionDefinition element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__EVENT));
		printCountingMap.put("event", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS));
		printCountingMap.put("imports", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("CoED");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("for");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCoEvolutionDefinitionMetamodelReferenceResolver().deResolve((org.eclipse.emf.ecore.EPackage) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_org_modelrefactoring_evolution_coed_CoEvolutionDefinition_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("incoming");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("event");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__EVENT));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("event", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__CONDITION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("outgoing");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__ACTION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_modelrefactoring_evolution_coed_CoEvolutionDefinition_0(org.modelrefactoring.evolution.coed.CoEvolutionDefinition element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("import");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("imports");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.CO_EVOLUTION_DEFINITION__IMPORTS));
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
			printCountingMap.put("imports", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_coed_MetamodelImport(org.modelrefactoring.evolution.coed.MetamodelImport element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__SHORTCUT));
		printCountingMap.put("shortcut", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("shortcut");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__SHORTCUT));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__SHORTCUT), element));
				out.print(" ");
			}
			printCountingMap.put("shortcut", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetamodelImportMetamodelReferenceResolver().deResolve((org.eclipse.emf.ecore.EPackage) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.METAMODEL_IMPORT__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_coed_PlainCondition(org.modelrefactoring.evolution.coed.PlainCondition element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CO_ED));
		printCountingMap.put("coED", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("condition");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CONDITION));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_123_125");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.PLAIN_CONDITION__CONDITION), element));
				out.print(" ");
			}
			printCountingMap.put("condition", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_coed_RoleMappingEvent(org.modelrefactoring.evolution.coed.RoleMappingEvent element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CO_ED));
		printCountingMap.put("coED", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING));
		printCountingMap.put("concreteRefactoring", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT));
		printCountingMap.put("metamodelImport", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("refactoring");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("metamodelImport");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleMappingEventMetamodelImportReferenceResolver().deResolve((org.modelrefactoring.evolution.coed.MetamodelImport) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__METAMODEL_IMPORT), element));
			}
			printCountingMap.put("metamodelImport", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("concreteRefactoring");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleMappingEventConcreteRefactoringReferenceResolver().deResolve((org.emftext.language.refactoring.rolemapping.RoleMapping) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_EVENT__CONCRETE_REFACTORING), element));
				out.print(" ");
			}
			printCountingMap.put("concreteRefactoring", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_evolution_coed_RoleMappingAction(org.modelrefactoring.evolution.coed.RoleMappingAction element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CO_ED));
		printCountingMap.put("coED", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING));
		printCountingMap.put("concreteRefactoring", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__BINDING));
		printCountingMap.put("binding", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("corefactoring");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("concreteRefactoring");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleMappingActionConcreteRefactoringReferenceResolver().deResolve((org.emftext.language.refactoring.rolemapping.RoleMapping) o, element, (EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING)), element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__CONCRETE_REFACTORING), element));
				out.print(" ");
			}
			printCountingMap.put("concreteRefactoring", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_modelrefactoring_evolution_coed_RoleMappingAction_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_modelrefactoring_evolution_coed_RoleMappingAction_0(org.modelrefactoring.evolution.coed.RoleMappingAction element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("binding");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__BINDING));
			if (o != null) {
				org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_123_125");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.evolution.coed.CoedPackage.ROLE_MAPPING_ACTION__BINDING), element));
				out.print(" ");
			}
			printCountingMap.put("binding", count - 1);
		}
	}
	
	
}
