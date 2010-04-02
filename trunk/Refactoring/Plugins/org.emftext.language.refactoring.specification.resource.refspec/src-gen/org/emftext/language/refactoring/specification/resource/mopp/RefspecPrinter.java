/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecPrinter implements org.emftext.language.refactoring.specification.resource.IRefspecTextPrinter {
	
	protected org.emftext.language.refactoring.specification.resource.IRefspecTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.specification.resource.mopp.RefspecTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/** Holds the resource that is associated with this printer. may be null if the printer is used stand alone. */
	private org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource;
	private java.util.Map<?, ?> options;
	
	public RefspecPrinter(java.io.OutputStream outputStream, org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected static int matchCount(java.util.Map<java.lang.String, java.lang.Integer> featureCounter, java.util.Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;
		
		for(java.lang.String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
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
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, java.lang.String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification((org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.CREATE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE((org.emftext.language.refactoring.refactoring_specification.CREATE) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.MOVE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE((org.emftext.language.refactoring.refactoring_specification.MOVE) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.SET) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_SET((org.emftext.language.refactoring.refactoring_specification.SET) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.ASSIGN) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN((org.emftext.language.refactoring.refactoring_specification.ASSIGN) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.UPDATE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE((org.emftext.language.refactoring.refactoring_specification.UPDATE) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.Variable) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_Variable((org.emftext.language.refactoring.refactoring_specification.Variable) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.VariableReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference((org.emftext.language.refactoring.refactoring_specification.VariableReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.VariableAssignment) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment((org.emftext.language.refactoring.refactoring_specification.VariableAssignment) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RoleReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference((org.emftext.language.refactoring.refactoring_specification.RoleReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.TRACE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_TRACE((org.emftext.language.refactoring.refactoring_specification.TRACE) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RelationReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference((org.emftext.language.refactoring.refactoring_specification.RelationReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.ConstantsReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference((org.emftext.language.refactoring.refactoring_specification.ConstantsReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.FromClause) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_FromClause((org.emftext.language.refactoring.refactoring_specification.FromClause) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.UPTREE) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE((org.emftext.language.refactoring.refactoring_specification.UPTREE) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.PATH) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_PATH((org.emftext.language.refactoring.refactoring_specification.PATH) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.FIRST) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_FIRST((org.emftext.language.refactoring.refactoring_specification.FIRST) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.LAST) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_LAST((org.emftext.language.refactoring.refactoring_specification.LAST) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.ConcreteIndex) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex((org.emftext.language.refactoring.refactoring_specification.ConcreteIndex) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.IndexVariable) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable((org.emftext.language.refactoring.refactoring_specification.IndexVariable) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.specification.resource.mopp.RefspecReferenceResolverSwitch) new org.emftext.language.refactoring.specification.resource.mopp.RefspecMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.refactoring.specification.resource.IRefspecTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.refactoring.specification.resource.mopp.RefspecProblem(errorMessage, org.emftext.language.refactoring.specification.resource.RefspecEProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextResource getResource() {
		return resource;
	}
	
	/** Calls {@link #doPrint(EObject, String)} and writes the result to the underlying output stream. */
	public void print(org.eclipse.emf.ecore.EObject element)  {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL));
		printCountingMap.put("usedRoleModel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS));
		printCountingMap.put("instructions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("REFACTORING");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME), element));
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
		count = printCountingMap.get("usedRoleModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRefactoringSpecificationUsedRoleModelReferenceResolver().deResolve((org.emftext.language.refactoring.roles.RoleModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("usedRoleModel", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("STEPS");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RefactoringSpecification_0(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("instructions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__INSTRUCTIONS));
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
			printCountingMap.put("instructions", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE(org.emftext.language.refactoring.refactoring_specification.CREATE element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX));
		printCountingMap.put("index", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE));
		printCountingMap.put("sourceRole", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT));
		printCountingMap.put("targetContext", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("create");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("new");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("sourceRole");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCREATESourceRoleReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE), element));
			}
			printCountingMap.put("sourceRole", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("in");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetContext");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetContext", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_0(org.emftext.language.refactoring.refactoring_specification.CREATE element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("at");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("index");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentCommandIndexReferenceResolver().deResolve((org.emftext.language.refactoring.refactoring_specification.IndexVariable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__INDEX), element));
				out.print(" ");
			}
			printCountingMap.put("index", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX));
		printCountingMap.put("index", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("move");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("to");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE_0(org.emftext.language.refactoring.refactoring_specification.MOVE element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("at");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("index");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentCommandIndexReferenceResolver().deResolve((org.emftext.language.refactoring.refactoring_specification.IndexVariable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__INDEX), element));
				out.print(" ");
			}
			printCountingMap.put("index", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_SET(org.emftext.language.refactoring.refactoring_specification.SET element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.SET__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.SET__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("use");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("of");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.SET__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("in");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.SET__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN(org.emftext.language.refactoring.refactoring_specification.ASSIGN element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE));
		printCountingMap.put("sourceAttribute", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE));
		printCountingMap.put("targetAttribute", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__ADDITIONAL_COMMAND));
		printCountingMap.put("additionalCommand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("assign");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("targetAttribute");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("DOT_NOTATION");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getASSIGNTargetAttributeReferenceResolver().deResolve((org.emftext.language.refactoring.roles.RoleAttribute) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__TARGET_ATTRIBUTE), element));
				out.print(" ");
			}
			printCountingMap.put("targetAttribute", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_0(org.emftext.language.refactoring.refactoring_specification.ASSIGN element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("sourceAttribute");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("DOT_NOTATION");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getASSIGNSourceAttributeReferenceResolver().deResolve((org.emftext.language.refactoring.roles.RoleAttribute) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__SOURCE_ATTRIBUTE), element));
			}
			printCountingMap.put("sourceAttribute", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("for");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ASSIGN_1(org.emftext.language.refactoring.refactoring_specification.ASSIGN element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("additionalCommand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ASSIGN__ADDITIONAL_COMMAND));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("additionalCommand", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_UPDATE(org.emftext.language.refactoring.refactoring_specification.UPDATE element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("update");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_Variable(org.emftext.language.refactoring.refactoring_specification.Variable element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__CONTAINER_COMMAND));
		printCountingMap.put("containerCommand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference(org.emftext.language.refactoring.refactoring_specification.VariableReference element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableReferenceVariableReferenceResolver().deResolve((org.emftext.language.refactoring.refactoring_specification.Variable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), element));
				out.print(" ");
			}
			printCountingMap.put("variable", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_VariableAssignment(org.emftext.language.refactoring.refactoring_specification.VariableAssignment element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT));
		printCountingMap.put("assignment", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("object");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("assignment");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_ASSIGNMENT__ASSIGNMENT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("assignment", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference(org.emftext.language.refactoring.refactoring_specification.RoleReference element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__DECLARATION));
		printCountingMap.put("declaration", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE));
		printCountingMap.put("role", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__FROM));
		printCountingMap.put("from", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("role");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleReferenceRoleReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE), element));
			}
			printCountingMap.put("role", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("from");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("from");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__FROM));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("from", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_TRACE(org.emftext.language.refactoring.refactoring_specification.TRACE element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__DECLARATION));
		printCountingMap.put("declaration", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__REFERENCE));
		printCountingMap.put("reference", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE));
		printCountingMap.put("role", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("role");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("UPPER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTRACERoleReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__ROLE), element));
				out.print(" ");
			}
			printCountingMap.put("role", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("as");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("trace");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.TRACE__REFERENCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reference", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference(org.emftext.language.refactoring.refactoring_specification.RelationReference element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION));
		printCountingMap.put("relation", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("relation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("DOT_NOTATION");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationReferenceRelationReferenceResolver().deResolve((org.emftext.language.refactoring.roles.MultiplicityRelation) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), element));
				out.print(" ");
			}
			printCountingMap.put("relation", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ConstantsReference(org.emftext.language.refactoring.refactoring_specification.ConstantsReference element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT));
		printCountingMap.put("referencedConstant", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("referencedConstant");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("CONSTANTS");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONSTANTS_REFERENCE__REFERENCED_CONSTANT), element));
				out.print(" ");
			}
			printCountingMap.put("referencedConstant", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_FromClause(org.emftext.language.refactoring.refactoring_specification.FromClause element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FROM_CLAUSE__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FROM_CLAUSE__REFERENCE));
		printCountingMap.put("reference", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FROM_CLAUSE__OPERATOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FROM_CLAUSE__REFERENCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reference", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_UPTREE(org.emftext.language.refactoring.refactoring_specification.UPTREE element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("uptree");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_PATH(org.emftext.language.refactoring.refactoring_specification.PATH element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("path");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_FIRST(org.emftext.language.refactoring.refactoring_specification.FIRST element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FIRST__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FIRST__REFERENCE));
		printCountingMap.put("reference", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("index");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FIRST__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":=");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("first");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.FIRST__REFERENCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reference", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_LAST(org.emftext.language.refactoring.refactoring_specification.LAST element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.LAST__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.LAST__REFERENCE));
		printCountingMap.put("reference", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("index");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.LAST__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":=");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("last");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.LAST__REFERENCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reference", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_ConcreteIndex(org.emftext.language.refactoring.refactoring_specification.ConcreteIndex element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__INDEX));
		printCountingMap.put("index", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("index");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":=");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("index");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__INDEX));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CONCRETE_INDEX__INDEX), element));
				out.print(" ");
			}
			printCountingMap.put("index", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_IndexVariable(org.emftext.language.refactoring.refactoring_specification.IndexVariable element, java.lang.String outertab, java.io.PrintWriter out) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.INDEX_VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.INDEX_VARIABLE__INDEX_COMMAND));
		printCountingMap.put("indexCommand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.INDEX_VARIABLE__NAME));
			if (o != null) {
				org.emftext.language.refactoring.specification.resource.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("LOWER_IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.INDEX_VARIABLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
}
