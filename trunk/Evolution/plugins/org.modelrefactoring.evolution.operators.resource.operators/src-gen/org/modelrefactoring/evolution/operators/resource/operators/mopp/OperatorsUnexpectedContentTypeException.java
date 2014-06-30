/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.antlr.runtime3_4_0.RecognitionException;

/**
 * <p>
 * An Excpetion to represent invalid content types for parser instances.
 * </p>
 * 
 * @see
 * org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions.RE
 * SOURCE_CONTENT_TYPE
 */
public class OperatorsUnexpectedContentTypeException extends RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  OperatorsUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
