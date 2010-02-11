/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

// java.lang.Exception class to represent invalid content types for parser instances.
//
// @see org.emftext.language.refactoring.roles.resource.rolestext.IRolestextOptions.RESOURCE_CONTENT_TYPE
public class RolestextUnexpectedContentTypeException extends org.antlr.runtime3_2_0.RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  RolestextUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
}
