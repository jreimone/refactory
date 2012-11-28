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
package dk.itu.sdg.language.xwpf.resource.xwpf.ui;

public class XwpfUIMetaInformation extends dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation {
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfHoverTextProvider getHoverTextProvider() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfHoverTextProvider();
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfImageProvider getImageProvider() {
		return dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfImageProvider.INSTANCE;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager createColorManager() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource,
	 * dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager) instead.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfTokenScanner createTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfTokenScanner createTokenScanner(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource, dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfColorManager colorManager) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfTokenScanner(resource, colorManager);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCodeCompletionHelper createCodeCompletionHelper() {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfCodeCompletionHelper();
	}
	
}
