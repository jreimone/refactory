/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

// java.lang.Exception class to represent invalid content types for parser instances.
//
// @see org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecOptions.RESOURCE_CONTENT_TYPE
public class RefspecUnexpectedContentTypeException extends org.antlr.runtime3_2_0.RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  RefspecUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
}
