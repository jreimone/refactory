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
package dk.itu.sdg.language.xwpf.resource.xwpf;

/**
 * A basic interface to convert parsed tokens to the attribute type in the meta
 * model. All generated TokenResolvers per default delegate requests to an
 * instance of XwpfDefaultTokenResolver which performs a standard conversion based
 * on the EMF type conversion. This includes conversion of registered EDataTypes.
 * 
 * @see dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultTokenResolver
 */
public interface IXwpfTokenResolver extends dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfConfigurable {
	
	/**
	 * Converts a token into an Object (the value of the attribute).
	 * 
	 * @param lexem the text of the parsed token
	 * @param feature the corresponding feature in the meta model
	 * @param result the result of resolving the lexem, can be used to add processing
	 * errors
	 */
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result);
	
	/**
	 * Converts an Object (the value of an attribute) to a string which can be
	 * printed. This is the inverse of resolving a token with a call to resolve().
	 * 
	 * @param value the Object to be printed as String
	 * @param feature the corresponding feature (EAttribute)
	 * @param container the container of the object
	 * 
	 * @return the String representation or null if a problem occurred
	 */
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container);
	
}
