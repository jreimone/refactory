/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.debug;

public class XwpfSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfStackFrame) {
			dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfStackFrame frame = (dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
