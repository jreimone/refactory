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

public class XwpfSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getContent(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getBodyElement(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getComment(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getFootnote(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getFooter(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getHeader(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getHyperlink(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getNumbering(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getPictureData(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getTable(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getRun(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getPart(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getBody(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getContent(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(),
		};
	}
	
}
