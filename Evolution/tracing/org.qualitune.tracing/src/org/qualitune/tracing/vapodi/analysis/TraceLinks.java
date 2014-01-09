/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.AddTraceLink;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.umt.VariableAssignment;
import org.qualitune.tracing.umt.VariableDeclarationInstruction;
import org.qualitune.tracing.umt.VariableProcessingInstruction;
import org.qualitune.tracing.umt.VariableReset;
import org.qualitune.tracing.vapoditrace.TraceType;

/**
 * This analysis adds addTraceLink directives behind any output model altering instructions.
 *  
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class TraceLinks extends IUmtAnalysisImpl {
	
	public TraceLinks() {
		super("TracLinks");
	}

	/**
	 * Add 'add trace link' directive after variable processing instruction if variable belongs to. 
	 * @param varProcInst Instruction that is processed.
	 */
	public void visit(VariableProcessingInstruction varProcInst) {
		TraceType semantics;
		Variable destination = varProcInst.getDestination();
	
		if (! belongsToOutputModel(destination))
			return;		
		
		logger.warn("Test message warn: Ignoring instruction of type VariableReset.");
		logger.info("Test message info: Ignoring instruction of type VariableReset.");
		logger.debug("Test message debug: Ignoring instruction of type VariableReset.");
		
		
		if (varProcInst instanceof VariableReset) {
			// TODO think this through
			semantics = TraceType.CREATE;
		} else if (varProcInst instanceof VariableDeclarationInstruction) {
			semantics = TraceType.CREATE;
		} else if (varProcInst instanceof VariableAssignment) {
			semantics = TraceType.WRITE;
		} else {
			logger.warn("observed unknown instruction of type. Assuming WRITE semantics.");
			semantics = TraceType.WRITE;
		}
		
		/* Parameters of varProcInst pushed onto stack (before) resp. popped (after) by CFS analysis */
		
		AddTraceLink addTraceLink = _umtFactory.createAddTraceLink();
		addTraceLink.setSemantics(semantics);
		addTraceLink.setDestination(destination);
		
		composeIntoContainment(varProcInst,addTraceLink,LocationEnum.AFTER);
	}
}
