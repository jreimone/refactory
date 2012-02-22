/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see org.qualitune.guery.resource.guery.IGueryOptions.RESOURCE_CONTENT_TYPE
 */
public class GueryUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  GueryUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
