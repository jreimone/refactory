/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.CallExpression;
import org.qualitune.tracing.umt.Function;

/**
 * Takes care for
 * - function parameters 
 * - return values
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class Functions extends IUmtAnalysisImpl {

	public Functions(String logPostfix) {
		super("functions");
	}

	// TODO assure iterator returns functions themselves as well
	public void visit(Function function) {
		logger.warn("Function unimplemented");
	}
	
	/**
	 * Does not: Pushes all call parameters onto stack before call, pops them afterwards.
	 * Does: todo 
	 * @param call
	 */
	public void visit(CallExpression call) {
		logger.warn("CallExp unimplemented");
	}
}
