/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * org.emftext.refactoring.tests.properties.resource.properties.IPropertiesOptions.
 * RESOURCE_CONTENT_TYPE
 */
public class PropertiesUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  PropertiesUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
