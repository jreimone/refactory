/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfOptions.RESOURCE_CONTENT_TYPE
 */
public class XwpfUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  XwpfUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
