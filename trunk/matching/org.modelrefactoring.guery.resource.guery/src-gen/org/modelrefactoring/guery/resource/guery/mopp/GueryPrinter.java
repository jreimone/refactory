/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryPrinter implements org.modelrefactoring.guery.resource.guery.IGueryTextPrinter {
	
	protected org.modelrefactoring.guery.resource.guery.IGueryTokenResolverFactory tokenResolverFactory = new org.modelrefactoring.guery.resource.guery.mopp.GueryTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.modelrefactoring.guery.resource.guery.IGueryTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public GueryPrinter(java.io.OutputStream outputStream, org.modelrefactoring.guery.resource.guery.IGueryTextResource resource) {
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
		
		if (element instanceof org.modelrefactoring.guery.MotifModel) {
			print_org_modelrefactoring_guery_MotifModel((org.modelrefactoring.guery.MotifModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.Motif) {
			print_org_modelrefactoring_guery_Motif((org.modelrefactoring.guery.Motif) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.PreProcessor) {
			print_org_modelrefactoring_guery_PreProcessor((org.modelrefactoring.guery.PreProcessor) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.VertexSelection) {
			print_org_modelrefactoring_guery_VertexSelection((org.modelrefactoring.guery.VertexSelection) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.Role) {
			print_org_modelrefactoring_guery_Role((org.modelrefactoring.guery.Role) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.Constraint) {
			print_org_modelrefactoring_guery_Constraint((org.modelrefactoring.guery.Constraint) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.ConnectedBy) {
			print_org_modelrefactoring_guery_ConnectedBy((org.modelrefactoring.guery.ConnectedBy) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.NotConnectedBy) {
			print_org_modelrefactoring_guery_NotConnectedBy((org.modelrefactoring.guery.NotConnectedBy) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.Connection) {
			print_org_modelrefactoring_guery_Connection((org.modelrefactoring.guery.Connection) element, globaltab, out);
			return;
		}
		if (element instanceof org.modelrefactoring.guery.Grouping) {
			print_org_modelrefactoring_guery_Grouping((org.modelrefactoring.guery.Grouping) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.modelrefactoring.guery.resource.guery.mopp.GueryReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.modelrefactoring.guery.resource.guery.mopp.GueryReferenceResolverSwitch) new org.modelrefactoring.guery.resource.guery.mopp.GueryMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.modelrefactoring.guery.resource.guery.IGueryTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.modelrefactoring.guery.resource.guery.mopp.GueryProblem(errorMessage, org.modelrefactoring.guery.resource.guery.GueryEProblemType.PRINT_PROBLEM, org.modelrefactoring.guery.resource.guery.GueryEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
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
	
	public org.modelrefactoring.guery.resource.guery.IGueryTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
	}
	
	public void print_org_modelrefactoring_guery_MotifModel(org.modelrefactoring.guery.MotifModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS));
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
			print_org_modelrefactoring_guery_MotifModel_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_modelrefactoring_guery_MotifModel_0(org.modelrefactoring.guery.MotifModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF_MODEL__MOTIFS));
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
	
	
	public void print_org_modelrefactoring_guery_Motif(org.modelrefactoring.guery.Motif element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__VERTEX_SELECTION));
		printCountingMap.put("vertexSelection", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__GROUP_BY));
		printCountingMap.put("groupBy", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__PREPARE));
		printCountingMap.put("prepare", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__EDGE_SELECTIONS));
		printCountingMap.put("edgeSelections", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("motif");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__NAME));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("prepare");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__PREPARE));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__VERTEX_SELECTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("vertexSelection", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("edgeSelections");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__EDGE_SELECTIONS));
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
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.MOTIF__GROUP_BY));
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
	
	
	public void print_org_modelrefactoring_guery_PreProcessor(org.modelrefactoring.guery.PreProcessor element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.PRE_PROCESSOR__CLASS));
		printCountingMap.put("class", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("prepare with");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("class");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.PRE_PROCESSOR__CLASS));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("CLASSNAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.PRE_PROCESSOR__CLASS), element));
				out.print(" ");
			}
			printCountingMap.put("class", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_guery_VertexSelection(org.modelrefactoring.guery.VertexSelection element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS));
		printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES));
		printCountingMap.put("roles", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES));
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
			print_org_modelrefactoring_guery_VertexSelection_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_modelrefactoring_guery_VertexSelection_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_modelrefactoring_guery_VertexSelection_0(org.modelrefactoring.guery.VertexSelection element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("roles");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__ROLES));
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
	
	public void print_org_modelrefactoring_guery_VertexSelection_1(org.modelrefactoring.guery.VertexSelection element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_modelrefactoring_guery_VertexSelection_1_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_modelrefactoring_guery_VertexSelection_1_0(org.modelrefactoring.guery.VertexSelection element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.VERTEX_SELECTION__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_guery_Role(org.modelrefactoring.guery.Role element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.ROLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.ROLE__NAME));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.ROLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_guery_Constraint(org.modelrefactoring.guery.Constraint element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINT__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINT__EXPRESSION));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONSTRAINT__EXPRESSION), element));
				out.print(" ");
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_guery_ConnectedBy(org.modelrefactoring.guery.ConnectedBy element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS));
		printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS));
		printCountingMap.put("connections", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
		out.print("connected by");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS));
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
			print_org_modelrefactoring_guery_ConnectedBy_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_modelrefactoring_guery_ConnectedBy_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_modelrefactoring_guery_ConnectedBy_0(org.modelrefactoring.guery.ConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONNECTIONS));
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
	
	public void print_org_modelrefactoring_guery_ConnectedBy_1(org.modelrefactoring.guery.ConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_modelrefactoring_guery_ConnectedBy_1_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_modelrefactoring_guery_ConnectedBy_1_0(org.modelrefactoring.guery.ConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTED_BY__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_guery_NotConnectedBy(org.modelrefactoring.guery.NotConnectedBy element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS));
		printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS));
		printCountingMap.put("connections", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
		out.print("not connected by");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS));
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
			print_org_modelrefactoring_guery_NotConnectedBy_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_modelrefactoring_guery_NotConnectedBy_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_modelrefactoring_guery_NotConnectedBy_0(org.modelrefactoring.guery.NotConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("connections");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONNECTIONS));
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
	
	public void print_org_modelrefactoring_guery_NotConnectedBy_1(org.modelrefactoring.guery.NotConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_modelrefactoring_guery_NotConnectedBy_1_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_modelrefactoring_guery_NotConnectedBy_1_0(org.modelrefactoring.guery.NotConnectedBy element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.NOT_CONNECTED_BY__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
	}
	
	
	public void print_org_modelrefactoring_guery_Connection(org.modelrefactoring.guery.Connection element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO));
		printCountingMap.put("to", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM));
		printCountingMap.put("from", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MIN_LENGTH));
		printCountingMap.put("minLength", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MAX_LENGTH));
		printCountingMap.put("maxLength", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL));
		printCountingMap.put("computeAll", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__PATH));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__PATH), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionFromReferenceResolver().deResolve((org.modelrefactoring.guery.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM)), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__FROM), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectionToReferenceResolver().deResolve((org.modelrefactoring.guery.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO)), element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__TO), element));
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
		print_org_modelrefactoring_guery_Connection_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("computeAll");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__COMPUTE_ALL));
			if (o != null) {
			}
			printCountingMap.put("computeAll", count - 1);
		}
	}
	
	public void print_org_modelrefactoring_guery_Connection_0(org.modelrefactoring.guery.Connection element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("minLength");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MIN_LENGTH));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MIN_LENGTH), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MAX_LENGTH));
			if (o != null) {
				org.modelrefactoring.guery.resource.guery.IGueryTokenResolver resolver = tokenResolverFactory.createTokenResolver("CARDINALITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.CONNECTION__MAX_LENGTH), element));
				out.print(" ");
			}
			printCountingMap.put("maxLength", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	
	public void print_org_modelrefactoring_guery_Grouping(org.modelrefactoring.guery.Grouping element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS));
		printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
		out.print("group by");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_modelrefactoring_guery_Grouping_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_org_modelrefactoring_guery_Grouping_0(org.modelrefactoring.guery.Grouping element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.modelrefactoring.guery.GueryPackage.GROUPING__CONSTRAINTS));
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
			printCountingMap.put("constraints", count - 1);
		}
	}
	
	
}
