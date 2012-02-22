/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GueryPrinter implements org.qualitune.guery.resource.guery.IGueryTextPrinter {
	
	protected org.qualitune.guery.resource.guery.IGueryTokenResolverFactory tokenResolverFactory = new org.qualitune.guery.resource.guery.mopp.GueryTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.qualitune.guery.resource.guery.IGueryTextResource resource;
	
	private java.util.Map<?, ?> options;
	
	public GueryPrinter(java.io.OutputStream outputStream, org.qualitune.guery.resource.guery.IGueryTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
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
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.qualitune.guery.MotifModel) {
			print_org_qualitune_guery_MotifModel((org.qualitune.guery.MotifModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.Motif) {
			print_org_qualitune_guery_Motif((org.qualitune.guery.Motif) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.PreProcessor) {
			print_org_qualitune_guery_PreProcessor((org.qualitune.guery.PreProcessor) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.VertexSelection) {
			print_org_qualitune_guery_VertexSelection((org.qualitune.guery.VertexSelection) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.Role) {
			print_org_qualitune_guery_Role((org.qualitune.guery.Role) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.Constraint) {
			print_org_qualitune_guery_Constraint((org.qualitune.guery.Constraint) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.ConnectedBy) {
			print_org_qualitune_guery_ConnectedBy((org.qualitune.guery.ConnectedBy) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.NotConnectedBy) {
			print_org_qualitune_guery_NotConnectedBy((org.qualitune.guery.NotConnectedBy) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.Connection) {
			print_org_qualitune_guery_Connection((org.qualitune.guery.Connection) element, globaltab, out);
			return;
		}
		if (element instanceof org.qualitune.guery.Grouping) {
			print_org_qualitune_guery_Grouping((org.qualitune.guery.Grouping) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.qualitune.guery.resource.guery.mopp.GueryReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.qualitune.guery.resource.guery.mopp.GueryReferenceResolverSwitch) new org.qualitune.guery.resource.guery.mopp.GueryMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.qualitune.guery.resource.guery.IGueryTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.qualitune.guery.resource.guery.mopp.GueryProblem(errorMessage, org.qualitune.guery.resource.guery.GueryEProblemType.PRINT_PROBLEM, org.qualitune.guery.resource.guery.GueryEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.qualitune.guery.resource.guery.IGueryTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_qualitune_guery_MotifModel(org.qualitune.guery.MotifModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS));
		printCountingMap.put("motifs", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("motifs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("motifs", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_qualitune_guery_MotifModel_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_qualitune_guery_MotifModel_0(org.qualitune.guery.MotifModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("motifs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF_MODEL__MOTIFS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("motifs", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_Motif(org.qualitune.guery.Motif element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__VERTEX_SELECTION));
		printCountingMap.put("vertexSelection", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__GROUP_BY));
		printCountingMap.put("groupBy", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__PREPARE));
		printCountingMap.put("prepare", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__EDGE_SELECTIONS));
		printCountingMap.put("edgeSelections", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("motif");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("prepare");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__PREPARE));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("prepare", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("vertexSelection");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__VERTEX_SELECTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("vertexSelection", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("edgeSelections");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__EDGE_SELECTIONS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("edgeSelections", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("groupBy");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.MOTIF__GROUP_BY));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("groupBy", 0);
		}
	}
	
	
	public void print_org_qualitune_guery_PreProcessor(org.qualitune.guery.PreProcessor element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME));
		printCountingMap.put("className", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("prepare");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("with");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("className");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("CLASSNAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.PRE_PROCESSOR__CLASS_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("className", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_VertexSelection(org.qualitune.guery.VertexSelection element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES));
		printCountingMap.put("roles", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINT));
		printCountingMap.put("constraint", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("select");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("roles");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("roles", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_qualitune_guery_VertexSelection_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraint");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("constraint", count - 1);
		}
	}
	
	public void print_org_qualitune_guery_VertexSelection_0(org.qualitune.guery.VertexSelection element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("roles");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.VERTEX_SELECTION__ROLES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("roles", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_Role(org.qualitune.guery.Role element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.ROLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_Constraint(org.qualitune.guery.Constraint element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS));
		printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("where");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), element));
				out.print(" ");
			}
			printCountingMap.put("expressions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_qualitune_guery_Constraint_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_qualitune_guery_Constraint_0(org.qualitune.guery.Constraint element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONSTRAINT__EXPRESSIONS), element));
				out.print(" ");
			}
			printCountingMap.put("expressions", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_ConnectedBy(org.qualitune.guery.ConnectedBy element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS));
		printCountingMap.put("connections", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONSTRAINT));
		printCountingMap.put("constraint", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("connected");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("by");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("connections", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_qualitune_guery_ConnectedBy_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraint");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONSTRAINT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("constraint", count - 1);
		}
	}
	
	public void print_org_qualitune_guery_ConnectedBy_0(org.qualitune.guery.ConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTED_BY__CONNECTIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("connections", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_NotConnectedBy(org.qualitune.guery.NotConnectedBy element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS));
		printCountingMap.put("connections", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINT));
		printCountingMap.put("constraint", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("not");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("connected");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("by");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("connections", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_qualitune_guery_NotConnectedBy_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraint");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("constraint", count - 1);
		}
	}
	
	public void print_org_qualitune_guery_NotConnectedBy_0(org.qualitune.guery.NotConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("connections", count - 1);
		}
	}
	
	
	public void print_org_qualitune_guery_Connection(org.qualitune.guery.Connection element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO));
		printCountingMap.put("to", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM));
		printCountingMap.put("from", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH));
		printCountingMap.put("minLength", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH));
		printCountingMap.put("maxLength", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL));
		printCountingMap.put("computeAll", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__PATH), element));
				out.print(" ");
			}
			printCountingMap.put("path", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("from");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionFromReferenceResolver().deResolve((org.qualitune.guery.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM)), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__FROM), element));
				out.print(" ");
			}
			printCountingMap.put("from", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(">");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("to");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionToReferenceResolver().deResolve((org.qualitune.guery.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO)), element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__TO), element));
				out.print(" ");
			}
			printCountingMap.put("to", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_qualitune_guery_Connection_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("computeAll");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__COMPUTE_ALL));
			if (o != null) {
			}
			printCountingMap.put("computeAll", count - 1);
		}
	}
	
	public void print_org_qualitune_guery_Connection_0(org.qualitune.guery.Connection element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("minLength");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MIN_LENGTH), element));
				out.print(" ");
			}
			printCountingMap.put("minLength", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("maxLength");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH));
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.CONNECTION__MAX_LENGTH), element));
				out.print(" ");
			}
			printCountingMap.put("maxLength", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	
	public void print_org_qualitune_guery_Grouping(org.qualitune.guery.Grouping element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS));
		printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("group");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("by");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), element));
				out.print(" ");
			}
			printCountingMap.put("expressions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_qualitune_guery_Grouping_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_qualitune_guery_Grouping_0(org.qualitune.guery.Grouping element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.qualitune.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.qualitune.guery.GueryPackage.GROUPING__EXPRESSIONS), element));
				out.print(" ");
			}
			printCountingMap.put("expressions", count - 1);
		}
	}
	
	
}
