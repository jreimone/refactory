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

public class XwpfParseResult implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>> commands = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>>();
	
	public XwpfParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
