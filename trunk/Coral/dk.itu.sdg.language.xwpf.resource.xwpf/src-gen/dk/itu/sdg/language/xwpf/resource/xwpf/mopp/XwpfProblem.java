/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfProblem implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfProblem {
	
	private String message;
	private dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type;
	private dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity;
	private java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> quickFixes;
	
	public XwpfProblem(String message, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix>emptySet());
	}
	
	public XwpfProblem(String message, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public XwpfProblem(String message, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType type, dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity severity, java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemType getType() {
		return type;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.XwpfEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
