/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.VariableDeclaration;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class ControlFlowStack implements IUmtAnalysis {
	
	public void visit(Program program) {
		System.out.println("CFS visiting program");
	}

	public void visit(Branch branch) {
		System.out.println("CFS visiting branch");
	}
	
	public void visit(VariableDeclaration variableDeclaration) {
		System.out.println("CFS visiting var-decl");
	}
}
