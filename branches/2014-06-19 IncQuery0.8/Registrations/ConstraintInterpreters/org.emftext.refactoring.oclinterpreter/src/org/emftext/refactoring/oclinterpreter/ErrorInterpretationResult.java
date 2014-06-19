/**
 * 
 */
package org.emftext.refactoring.oclinterpreter;

import org.emftext.refactoring.registry.rolemapping.IInterpretationResult;

/**
 * @author jreimann
 *
 */
public class ErrorInterpretationResult implements IInterpretationResult {

	private Exception ex;
	private String message;

	public ErrorInterpretationResult(String message) {
		super();
		this.message = message;
	}

	public ErrorInterpretationResult(Exception ex) {
		this.ex = ex;
	}

	@Override
	public boolean wasSuccessful() {
		return false;
	}

	@Override
	public String getErrorMessage() {
		if(ex != null){
			return ex.getMessage();
		}
		return message;
	}

}
