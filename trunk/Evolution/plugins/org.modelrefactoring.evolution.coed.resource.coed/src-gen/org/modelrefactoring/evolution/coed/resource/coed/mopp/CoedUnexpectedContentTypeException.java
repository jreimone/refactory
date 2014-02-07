/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.antlr.runtime3_4_0.RecognitionException;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions.RESOURCE_CONTENT_
 * TYPE
 */
public class CoedUnexpectedContentTypeException extends RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  CoedUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
