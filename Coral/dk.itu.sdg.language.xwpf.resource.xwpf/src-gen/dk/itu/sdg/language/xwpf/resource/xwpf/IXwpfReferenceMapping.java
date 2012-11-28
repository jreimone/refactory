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
 * A mapping from an identifier to something else. The &quot;something else&quot;
 * is defined by subclasses of this interface. Implementors of such subclasses are
 * used during the process of resolving references, where identifiers need to be
 * mapped to other objects.
 * This interface must not be implemented by clients.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IXwpfReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the identifier that is mapped.
	 */
	public String getIdentifier();
	
	/**
	 * A mapping can have a warning attached that contains additional information
	 * (e.g., when the mapping might be wrong under specific conditions). The warning
	 * is meant to be presented to the user together with the mapping result.
	 */
	public String getWarning();
}
