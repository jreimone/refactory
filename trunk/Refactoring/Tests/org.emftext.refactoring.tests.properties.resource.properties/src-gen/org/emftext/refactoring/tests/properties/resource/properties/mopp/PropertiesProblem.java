/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesProblem implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesProblem {
	
	private String message;
	private org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType type;
	private org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity severity;
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> quickFixes;
	
	public PropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix>emptySet());
	}
	
	public PropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity severity, org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public PropertiesProblem(String message, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType type, org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity severity, java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemType getType() {
		return type;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.PropertiesEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
