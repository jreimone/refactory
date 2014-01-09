/**
 * 
 */
package org.qualitune.tracing.vapodi.analysis;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.qualitune.tracing.umt.BlackBoxExpression;
import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.CalculatedExpression;
import org.qualitune.tracing.umt.CfsPop;
import org.qualitune.tracing.umt.CfsPush;
import org.qualitune.tracing.umt.Condition;
import org.qualitune.tracing.umt.Expression;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.ModelAttributeVariable;
import org.qualitune.tracing.umt.ModelVariable;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.vapoditrace.ConcernType;
import org.qualitune.tracing.vapoditrace.DynamicEntity;
import org.qualitune.tracing.vapoditrace.TraceType;
import org.qualitune.tracing.vapoditrace.UniverseType;

/**
 * Adds CFS push/pop directives throughout the code where necessary
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class ControlFlowStack extends IUmtAnalysisImpl {
	
	public ControlFlowStack() {
		super("CFS");
	}

	List<DynamicEntity> variables2DynamicEntities(List<Variable> variables) {
		List<DynamicEntity> ret = new LinkedList<DynamicEntity>();
		
		for (Variable v : variables) {
			DynamicEntity de = _vapodiTraceFactory.createDynamicEntity();
			de.setObject(v);
			
			// now let's inspect the given variable for further refinement of its DynamicEntity
			
			// V1)
			
			if (v instanceof ModelVariable) {
				de.setConcern(ConcernType.OBJECT);	
			} else if (v instanceof ModelAttributeVariable) {
				de.setConcern(ConcernType.ATTRIBUTE);
			} else { // they are primitive variables and have to be resolved by the runtime system using ST
				
			
			}
			
			
			
			
			de.setUniverse(UniverseType.LIGHT_UNIVERSE);
			de.setSemantics(TraceType.READ);
		}
		
		return ret;
	}

	/**
	 * Adds CFS push to begin and CFS pop to end of branch.  
	 * @param branch branch to instrument
	 */
	public void visit(Branch branch) {
		InstructionBlock body = branch.getBody();
		EList<Instruction> instructions = body.getInstructions();
		Condition condition = branch.getCondition();
		
		CfsPush cfsPush = _umtFactory.createCfsPush();
		cfsPush.getVariables().addAll(condition.getDependencies());
		instructions.add(0, cfsPush);
		
		CfsPop cfsPop = _umtFactory.createCfsPop();
		cfsPop.getVariables().addAll(condition.getDependencies());
		instructions.add(cfsPop);
	}

	
	// do not confuse this function with those visited by analysis runner 
	// add cfs_push before, pop after
	protected void visitExpression (Expression expression) {
		CfsPush cfsPush = _umtFactory.createCfsPush();
		CfsPop cfsPop = _umtFactory.createCfsPop();
		
		// take parameters with READ semantics
		
		cfsPush.getVariables().addAll(expression.getParameters());
		cfsPop.getVariables().addAll(expression.getParameters());
		
		composeIntoContainment(expression, cfsPush, LocationEnum.BEFORE);
		composeIntoContainment(expression, cfsPop, LocationEnum.AFTER);
	}
	
	public void visit(CalculatedExpression expression) {
		visitExpression(expression);
	}
	
	public void visit(BlackBoxExpression expression) {
		visitExpression(expression);
	}
}
