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

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class XwpfAbstractExpectedElement implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>> followers = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>>();
	
	public XwpfAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement follower, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[] path) {
		followers.add(new dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfPair<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfExpectedElement, dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
