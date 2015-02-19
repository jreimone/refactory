/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.io.InputStream;

/**
 * A InputStreamProcessor can be used like a normal InputStream, but provides
 * information about the encoding that is used to represent characters as bytes.
 */
public abstract class RefcompInputStreamProcessor extends InputStream {
	
	/**
	 * Returns the encoding of the characters that can be read from this
	 * InputStreamProcessor. This encoding is passed to subsequent streams (e.g., the
	 * ANTLRInputStream).
	 */
	public abstract String getOutputEncoding();
}
