/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class TestpropertiesPrinter implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextPrinter {
	
	protected org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolverFactory tokenResolverFactory = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public TestpropertiesPrinter(OutputStream outputStream, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource) {
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
		
		if (element instanceof org.emftext.refactoring.tests.properties.PropertyModel) {
			print_org_emftext_refactoring_tests_properties_PropertyModel((org.emftext.refactoring.tests.properties.PropertyModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.Category) {
			print_org_emftext_refactoring_tests_properties_Category((org.emftext.refactoring.tests.properties.Category) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.KeyValuePair) {
			print_org_emftext_refactoring_tests_properties_KeyValuePair((org.emftext.refactoring.tests.properties.KeyValuePair) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.Key) {
			print_org_emftext_refactoring_tests_properties_Key((org.emftext.refactoring.tests.properties.Key) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.EObjectReferenceValue) {
			print_org_emftext_refactoring_tests_properties_EObjectReferenceValue((org.emftext.refactoring.tests.properties.EObjectReferenceValue) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.refactoring.tests.properties.StringValue) {
			print_org_emftext_refactoring_tests_properties_StringValue((org.emftext.refactoring.tests.properties.StringValue) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesReferenceResolverSwitch) new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesProblem(errorMessage, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemType.PRINT_PROBLEM, org.emftext.refactoring.tests.properties.resource.testproperties.TestpropertiesEProblemSeverity.WARNING), cause);
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
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource getResource() {
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
	
	public void print_org_emftext_refactoring_tests_properties_PropertyModel(org.emftext.refactoring.tests.properties.PropertyModel element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES));
		printCountingMap.put("categories", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_refactoring_tests_properties_PropertyModel_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_emftext_refactoring_tests_properties_PropertyModel_0(org.emftext.refactoring.tests.properties.PropertyModel element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("categories");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.PROPERTY_MODEL__CATEGORIES));
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
			printCountingMap.put("categories", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_org_emftext_refactoring_tests_properties_Category(org.emftext.refactoring.tests.properties.Category element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS));
		printCountingMap.put("pairs", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME));
			if (o != null) {
				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pairs");
		if (count > 0) {
			List<?> list = (List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.CATEGORY__PAIRS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("pairs", 0);
		}
	}
	
	
	public void print_org_emftext_refactoring_tests_properties_KeyValuePair(org.emftext.refactoring.tests.properties.KeyValuePair element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY));
		printCountingMap.put("key", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_refactoring_tests_properties_KeyValuePair_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__VALUE));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_org_emftext_refactoring_tests_properties_KeyValuePair_0(org.emftext.refactoring.tests.properties.KeyValuePair element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("key");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY_VALUE_PAIR__KEY));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("key", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
	}
	
	
	public void print_org_emftext_refactoring_tests_properties_Key(org.emftext.refactoring.tests.properties.Key element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME));
			if (o != null) {
				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.KEY__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	
	public void print_org_emftext_refactoring_tests_properties_EObjectReferenceValue(org.emftext.refactoring.tests.properties.EObjectReferenceValue element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE));
		printCountingMap.put("objectReference", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("objectReference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE));
			if (o != null) {
				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEObjectReferenceValueObjectReferenceReferenceResolver().deResolve((org.eclipse.emf.ecore.EObject) o, element, (EReference) element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE)), element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.EOBJECT_REFERENCE_VALUE__OBJECT_REFERENCE), element));
				out.print(" ");
			}
			printCountingMap.put("objectReference", count - 1);
		}
	}
	
	
	public void print_org_emftext_refactoring_tests_properties_StringValue(org.emftext.refactoring.tests.properties.StringValue element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE));
			if (o != null) {
				org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.refactoring.tests.properties.PropertiesPackage.STRING_VALUE__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
}
