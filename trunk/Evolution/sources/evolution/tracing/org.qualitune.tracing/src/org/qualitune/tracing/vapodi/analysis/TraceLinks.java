/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.VariableDeclaration;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class TraceLinks implements IUmtAnalysis {
	
	public void visit (VariableDeclaration variableDeclaration) {
		System.out.println("TL visiting var-decl");
	}
	
	public void visit (Instruction variableDeclaration) {
		System.out.println("TL visiting any UMT instruction");
	}
}
