/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecPrinter implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextPrinter {
	
	protected final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/** Holds the resource that is associated with this printer. may be null if the printer is used stand alone. */
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource resource;
	private java.util.Map<?, ?> options;
	
	public RefspecPrinter(java.io.OutputStream outputStream, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource resource) {
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
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.Variable) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_Variable((org.emftext.language.refactoring.refactoring_specification.Variable) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.VariableReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference((org.emftext.language.refactoring.refactoring_specification.VariableReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RoleReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference((org.emftext.language.refactoring.refactoring_specification.RoleReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.refactoring_specification.RelationReference) {
			print_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference((org.emftext.language.refactoring.refactoring_specification.RelationReference) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecReferenceResolverSwitch) new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecProblem(errorMessage, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource getResource() {
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
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
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
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("REFACTORING");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__NAME));
			if (o != null) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
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
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("usedRoleModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.REFACTORING_SPECIFICATION__USED_ROLE_MODEL));
			if (o != null) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
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
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VAR_DECLARATION));
		printCountingMap.put("varDeclaration", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE));
		printCountingMap.put("sourceRoleReference", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__TARGET_CONTEXT));
		printCountingMap.put("targetContext", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("create");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("new");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("sourceRoleReference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__SOURCE_ROLE_REFERENCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("sourceRoleReference", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_0(element, localtab, out1, printCountingMap1);
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
	}
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_CREATE_0(org.emftext.language.refactoring.refactoring_specification.CREATE element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("varDeclaration");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.CREATE__VAR_DECLARATION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("varDeclaration", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_MOVE(org.emftext.language.refactoring.refactoring_specification.MOVE element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.MOVE__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
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
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_Variable(org.emftext.language.refactoring.refactoring_specification.Variable element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME));
			if (o != null) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_VariableReference(org.emftext.language.refactoring.refactoring_specification.VariableReference element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE));
			if (o != null) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableReferenceVariableReferenceResolver().deResolve((org.emftext.language.refactoring.refactoring_specification.Variable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.VARIABLE_REFERENCE__VARIABLE), element));
				out.print(" ");
			}
			printCountingMap.put("variable", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RoleReference(org.emftext.language.refactoring.refactoring_specification.RoleReference element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE));
		printCountingMap.put("role", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("role");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE));
			if (o != null) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleReferenceRoleReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.ROLE_REFERENCE__ROLE), element));
				out.print(" ");
			}
			printCountingMap.put("role", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_refactoring_005fspecification_RelationReference(org.emftext.language.refactoring.refactoring_specification.RelationReference element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION));
		printCountingMap.put("relation", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("relation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION));
			if (o != null) {
				org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationReferenceRelationReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Relation) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.RELATION_REFERENCE__RELATION), element));
				out.print(" ");
			}
			printCountingMap.put("relation", count - 1);
		}
	}
	
}
