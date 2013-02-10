/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.umt.VariableDeclaration;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class Shadow implements IUmtAnalysis {
	public void visit(Branch branch) {
		System.out.println("shadow visiting branch");
	}
	
	public void visit(Variable branch) {
		System.out.println("shadow visiting VARIABLE");
	}
	
	public void visit(Program branch) {
		System.out.println("shadow visiting program");
	}
}
