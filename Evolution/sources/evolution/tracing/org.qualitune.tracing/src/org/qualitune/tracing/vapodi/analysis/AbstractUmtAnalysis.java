/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.Program;

/**
 * 'Skeleton' for hierarchically running analyses.
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public abstract class AbstractUmtAnalysis {
	
	/* a concrete analysis might chose to implement
	 *     analyse(Instruction instruction)
	 * -> will be called upon every occurrence of Instruction
	 */
	
	
	
	public void run(Program program) {
		//visit(program);
	}
}
