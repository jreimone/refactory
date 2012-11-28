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
package dk.itu.sdg.language.xwpf.resource.xwpf.ui.debug;

public class XwpfDebugModelPresentation implements org.eclipse.debug.ui.IDebugModelPresentation {
	
	public XwpfDebugModelPresentation() {
		super();
	}
	
	public void addListener(org.eclipse.jface.viewers.ILabelProviderListener listener) {
		// do nothing
	}
	
	public void dispose() {
		// do nothing
	}
	
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}
	
	public void removeListener(org.eclipse.jface.viewers.ILabelProviderListener listener) {
		// do nothing
	}
	
	public org.eclipse.ui.IEditorInput getEditorInput(Object element) {
		if (element instanceof org.eclipse.core.resources.IFile) {
			return new org.eclipse.ui.part.FileEditorInput((org.eclipse.core.resources.IFile) element);
		} else if (element instanceof org.eclipse.debug.core.model.ILineBreakpoint) {
			return new org.eclipse.ui.part.FileEditorInput((org.eclipse.core.resources.IFile) ((org.eclipse.debug.core.model.ILineBreakpoint) element).getMarker().getResource());
		} else {
			return null;
		}
	}
	
	public String getEditorId(org.eclipse.ui.IEditorInput input, Object element) {
		if (element instanceof org.eclipse.core.resources.IFile || element instanceof org.eclipse.debug.core.model.ILineBreakpoint) {
			return dk.itu.sdg.language.xwpf.resource.xwpf.ui.XwpfUIPlugin.EDITOR_ID;
		}
		return null;
	}
	
	public void setAttribute(String attribute, Object value) {
		// not supported
	}
	
	public org.eclipse.swt.graphics.Image getImage(Object element) {
		return null;
	}
	
	public String getText(Object element) {
		return null;
	}
	
	public void computeDetail(org.eclipse.debug.core.model.IValue value, org.eclipse.debug.ui.IValueDetailListener listener) {
		// listener.detailComputed(value, "detail");
	}
	
}
