/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextPrinter implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextPrinter {
	
	protected final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	protected org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolverFactory tokenResolverFactory = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/** Holds the resource that is associated with this printer. may be null if the printer is used stand alone. */
	private org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource;
	private java.util.Map<?, ?> options;
	
	public RolestextPrinter(java.io.OutputStream outputStream, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource) {
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
		
		if (element instanceof org.emftext.language.refactoring.roles.RoleModel) {
			print_org_emftext_language_refactoring_roles_RoleModel((org.emftext.language.refactoring.roles.RoleModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.roles.Role) {
			print_org_emftext_language_refactoring_roles_Role((org.emftext.language.refactoring.roles.Role) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.roles.RoleProhibition) {
			print_org_emftext_language_refactoring_roles_RoleProhibition((org.emftext.language.refactoring.roles.RoleProhibition) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.roles.RoleImplication) {
			print_org_emftext_language_refactoring_roles_RoleImplication((org.emftext.language.refactoring.roles.RoleImplication) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.roles.RoleAssociation) {
			print_org_emftext_language_refactoring_roles_RoleAssociation((org.emftext.language.refactoring.roles.RoleAssociation) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.roles.RoleComposition) {
			print_org_emftext_language_refactoring_roles_RoleComposition((org.emftext.language.refactoring.roles.RoleComposition) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.refactoring.roles.Multiplicity) {
			print_org_emftext_language_refactoring_roles_Multiplicity((org.emftext.language.refactoring.roles.Multiplicity) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextReferenceResolverSwitch) new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextProblem(errorMessage, org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource getResource() {
		return resource;
	}
	
	/** Calls {@link #doPrint(EObject, String)} and writes the result to the underlying output stream. */
	public void print(org.eclipse.emf.ecore.EObject element)  {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_language_refactoring_roles_RoleModel(org.emftext.language.refactoring.roles.RoleModel element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__ROLES));
		printCountingMap.put("roles", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__RELATIONS));
		printCountingMap.put("relations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("RoleModel");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__NAME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("roles");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__ROLES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("roles", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("relations");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_MODEL__RELATIONS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("relations", 0);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_refactoring_roles_Role(org.emftext.language.refactoring.roles.Role element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL));
		printCountingMap.put("optional", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME));
		printCountingMap.put("selectOnRuntime", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT));
		printCountingMap.put("input", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("role");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__NAME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_Role_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_Role_0(org.emftext.language.refactoring.roles.Role element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_Role_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_Role_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_Role_0_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_Role_0_0(org.emftext.language.refactoring.roles.Role element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("optional");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("OPTIONAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__OPTIONAL), element));
				out.print(" ");
			}
			printCountingMap.put("optional", count - 1);
		}
	}
	public void print_org_emftext_language_refactoring_roles_Role_0_1(org.emftext.language.refactoring.roles.Role element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("input");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("INPUT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__INPUT), element));
				out.print(" ");
			}
			printCountingMap.put("input", count - 1);
		}
	}
	public void print_org_emftext_language_refactoring_roles_Role_0_2(org.emftext.language.refactoring.roles.Role element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("selectOnRuntime");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("RUNTIME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE__SELECT_ON_RUNTIME), element));
				out.print(" ");
			}
			printCountingMap.put("selectOnRuntime", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_roles_RoleProhibition(org.emftext.language.refactoring.roles.RoleProhibition element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE));
		printCountingMap.put("transitive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE));
		printCountingMap.put("reflexive", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("|-|");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleProhibition_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleProhibition_0(org.emftext.language.refactoring.roles.RoleProhibition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleProhibition_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleProhibition_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleProhibition_0_0(org.emftext.language.refactoring.roles.RoleProhibition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("transitive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__TRANSITIVE), element));
				out.print(" ");
			}
			printCountingMap.put("transitive", count - 1);
		}
	}
	public void print_org_emftext_language_refactoring_roles_RoleProhibition_0_1(org.emftext.language.refactoring.roles.RoleProhibition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("reflexive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_PROHIBITION__REFLEXIVE), element));
				out.print(" ");
			}
			printCountingMap.put("reflexive", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_roles_RoleImplication(org.emftext.language.refactoring.roles.RoleImplication element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE));
		printCountingMap.put("transitive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE));
		printCountingMap.put("reflexive", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleImplication_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleImplication_0(org.emftext.language.refactoring.roles.RoleImplication element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleImplication_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleImplication_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleImplication_0_0(org.emftext.language.refactoring.roles.RoleImplication element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("transitive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__TRANSITIVE), element));
				out.print(" ");
			}
			printCountingMap.put("transitive", count - 1);
		}
	}
	public void print_org_emftext_language_refactoring_roles_RoleImplication_0_1(org.emftext.language.refactoring.roles.RoleImplication element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("reflexive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_IMPLICATION__REFLEXIVE), element));
				out.print(" ");
			}
			printCountingMap.put("reflexive", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_roles_RoleAssociation(org.emftext.language.refactoring.roles.RoleAssociation element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE));
		printCountingMap.put("transitive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE));
		printCountingMap.put("reflexive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_MULTIPLICITY));
		printCountingMap.put("sourceMultiplicity", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_MULTIPLICITY));
		printCountingMap.put("targetMultiplicity", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME));
		printCountingMap.put("sourceName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME));
		printCountingMap.put("targetName", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("sourceName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("sourceName", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("sourceMultiplicity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__SOURCE_MULTIPLICITY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("sourceMultiplicity", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("--");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("targetName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("targetName", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetMultiplicity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TARGET_MULTIPLICITY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetMultiplicity", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleAssociation_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleAssociation_0(org.emftext.language.refactoring.roles.RoleAssociation element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleAssociation_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleAssociation_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleAssociation_0_0(org.emftext.language.refactoring.roles.RoleAssociation element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("transitive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__TRANSITIVE), element));
				out.print(" ");
			}
			printCountingMap.put("transitive", count - 1);
		}
	}
	public void print_org_emftext_language_refactoring_roles_RoleAssociation_0_1(org.emftext.language.refactoring.roles.RoleAssociation element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("reflexive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_ASSOCIATION__REFLEXIVE), element));
				out.print(" ");
			}
			printCountingMap.put("reflexive", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_roles_RoleComposition(org.emftext.language.refactoring.roles.RoleComposition element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE));
		printCountingMap.put("transitive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE));
		printCountingMap.put("reflexive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_MULTIPLICITY));
		printCountingMap.put("sourceMultiplicity", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_MULTIPLICITY));
		printCountingMap.put("targetMultiplicity", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME));
		printCountingMap.put("sourceName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME));
		printCountingMap.put("targetName", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationSourceReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("sourceName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("sourceName", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("sourceMultiplicity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__SOURCE_MULTIPLICITY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("sourceMultiplicity", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("<>-");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationTargetReferenceResolver().deResolve((org.emftext.language.refactoring.roles.Role) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET)), element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("targetName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("targetName", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetMultiplicity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TARGET_MULTIPLICITY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetMultiplicity", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleComposition_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleComposition_0(org.emftext.language.refactoring.roles.RoleComposition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleComposition_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_refactoring_roles_RoleComposition_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	public void print_org_emftext_language_refactoring_roles_RoleComposition_0_0(org.emftext.language.refactoring.roles.RoleComposition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("transitive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("TRANSITIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__TRANSITIVE), element));
				out.print(" ");
			}
			printCountingMap.put("transitive", count - 1);
		}
	}
	public void print_org_emftext_language_refactoring_roles_RoleComposition_0_1(org.emftext.language.refactoring.roles.RoleComposition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("reflexive");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("REFLEXIVE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.ROLE_COMPOSITION__REFLEXIVE), element));
				out.print(" ");
			}
			printCountingMap.put("reflexive", count - 1);
		}
	}
	
	public void print_org_emftext_language_refactoring_roles_Multiplicity(org.emftext.language.refactoring.roles.Multiplicity element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND));
		printCountingMap.put("lowerBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND));
		printCountingMap.put("upperBound", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lowerBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__LOWER_BOUND), element));
				out.print(" ");
			}
			printCountingMap.put("lowerBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("..");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("upperBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND));
			if (o != null) {
				org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.refactoring.roles.RolesPackage.MULTIPLICITY__UPPER_BOUND), element));
				out.print(" ");
			}
			printCountingMap.put("upperBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
}
