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
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfCompound extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement {
	
	public XwpfCompound(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfChoice choice, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality) {
		super(cardinality, new dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
