/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import org.qualitune.tracing.umt.StDrop;
import org.qualitune.tracing.umt.StPut;
import org.qualitune.tracing.umt.VariableAssignment;
import org.qualitune.tracing.umt.VariableDeclarationInstruction;

/**
 * Symbol table tracks variables (which are neither part of src nor dest model) 
 * 
 * Symbol table calls:
 * - st_put (var) -> make ST entry for var, expressing current value of var depends upon current CFS
 * 
 *  Note that there is no st_get call, as that's not possible with ATL's limited capabilities helper functions.
 *  ST is automatically evaluated within CFS_push and addTraceLink themselves 
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class SymbolTable extends IUmtAnalysisImpl {
	
	public SymbolTable() {
		super("SymbolTable");
	}

	// declaration relevant? Yes, as this typically comes with an implicitly default value assignment 
	public void visit (VariableDeclarationInstruction varDecl) {
		StPut stPut   = _umtFactory.createStPut();
		StDrop stDrop = _umtFactory.createStDrop();
		
		stPut.getSymbols().add(varDecl.getDestination());
		stDrop.getSymbols().add(varDecl.getDestination());
		
		composeIntoContainment(varDecl,stPut,LocationEnum.BEFORE);
		composeIntoContainment(varDecl,stDrop,LocationEnum.END_OF_SCOPE);
	}
	
	public void visit (VariableAssignment varAssign) {
		
		StPut stPut = _umtFactory.createStPut();
		
		stPut.getSymbols().add(varAssign.getDestination());
		
		composeIntoContainment(varAssign,stPut,LocationEnum.AFTER);
	}

}
