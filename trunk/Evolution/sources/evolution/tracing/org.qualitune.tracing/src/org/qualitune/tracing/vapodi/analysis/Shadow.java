/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Variable;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class Shadow extends IUmtAnalysisImpl {
	public Shadow() {
		super("shadow");
	}

	public void visit(Branch branch) {
		logger.info("shadow visiting branch");
	}
	
	public void visit(Variable branch) {
		logger.info("shadow visiting VARIABLE");
	}
	
	public void visit(Program branch) {
		logger.info("shadow visiting program");
	}
}
