/**
 * 
 */
package org.qualitune.tracing.atl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.qualitune.tracing.umt.AddTraceLink;
import org.qualitune.tracing.umt.BlackBoxExpression;
import org.qualitune.tracing.umt.CallExpression;
import org.qualitune.tracing.umt.CfsPop;
import org.qualitune.tracing.umt.CfsPush;
import org.qualitune.tracing.umt.Comment;
import org.qualitune.tracing.umt.Condition;
import org.qualitune.tracing.umt.Debug;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.InstanceModel;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.MetaModel;
import org.qualitune.tracing.umt.Model;
import org.qualitune.tracing.umt.NumerousKindsOfBranches;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.StDrop;
import org.qualitune.tracing.umt.StInstruction;
import org.qualitune.tracing.umt.StPut;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.umt.VariableAssignment;
import org.qualitune.tracing.umt.VariableDeclarationInstruction;
import org.qualitune.tracing.umt_abstract_content_adapter.AbstractUmtEventContentAdapter;
import org.qualitune.tracing.util.VUtil;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 * This class gets added as an adapter to UMT program (the root element of UMT programs). It
 * observes any changes to program or any of its (recursively) contained child elements 
 *
 * Started out from a recipe borrowed from 
 * http://wiki.eclipse.org/EMF/Recipes#Notification_Framework_Recipes
 * (extract gathered from EMF newsgroup discussion)
 */
public class Atl2UmtContentAdapter extends AbstractUmtEventContentAdapter {

	/*
	 * General Infrastructure
	 */
	
	AtlPseudoFactory atlFactory;
	TranslationTable translationTable;
	
	public Atl2UmtContentAdapter(TranslationTable translationTable, IModel atlCreator,
			IReferenceModel atlMetamodel) {
		super();
		atlFactory = new AtlPseudoFactory(atlCreator, atlMetamodel);
		this.translationTable = translationTable;
	}
	
	/*
	 * Actual Change Event Handling
	 */
	
	// demo
	protected void handleProgramSetName(Program program, String newName) {
		EObject atlModule = translationTable.translate(program);
		
		VUtil.setAttribute(atlModule, "name", newName);
	}
	
	protected void handleProgramAddModels(Program program, Model addedModel) {
		if (addedModel.eClass() instanceof InstanceModel)
			handleProgramAddInstanceModel(program, (InstanceModel) addedModel);
		else if (addedModel.eClass() instanceof MetaModel)
			handleProgramAddMetaModel(program, (MetaModel) addedModel);
		else
			logger.warn("severe warning: unknown model type " + addedModel.eClass().getName() + 
					" (can't technically happen). Did you change the UMT metamodel without adapting the content adapter?");
	}

	protected void handleProgramAddInstanceModel(Program program, InstanceModel addedModel) {
		EObject atlModule = translationTable.translate(program);
		EObject atlModel = atlFactory.createModelElement("OclModel");
		VUtil.setAttribute(atlModel, "name", addedModel.getName());

		switch (addedModel.getIntention()) {
		case IN:
			VUtil.addtoReference(atlModule, "inModels", atlModel);
			break;
		case INOUT:
			logger.warn("severe warning: INOUT model intention. Atl2UmtContentAdapter doesn't know how to handle this.");
			break;
		case OMITTED_INTENTION:
			logger.warn("severe warning: omitted model intention. That's likely an error in a UMT analysis.");
			break;
		case OUT:
			VUtil.addtoReference(atlModule, "outModels", atlModel);
			break;
		default:
			logger.warn("severe warning: unknown model intention (can't technically happen). Did you change the " +
					"UMT metamodel?");
			break;
		}

		// get mapping of metamodel, see if already in ATL
		EObject atlMetaModel = translationTable.translate(addedModel.getMetamodel());
		if (atlMetaModel != null) {
			VUtil.setReference(atlModel, "metamodel", atlMetaModel);
		} // else we'll add it later; handleProgramAddModels for metamodels will look back
		
		translationTable.addTranslation(atlModel, addedModel);
	}
	
	protected void handleProgramAddMetaModel(Program program, MetaModel addedModel) {
		EObject atlModule = translationTable.translate(program);
		EObject atlMetaModel = atlFactory.createModelElement("OclModel");
		VUtil.setAttribute(atlMetaModel, "name", addedModel.getName());

		// look up 'orphaned' models which don't have a metamodel assigned because until it hasn't been available until just now
		
		for (Model m : program.getModels()) {
			if (m.getMetamodel() == addedModel) {
				EObject atlModel = translationTable.translate(m);
				VUtil.setReference(atlModel, "metamodel", atlMetaModel);
			}
		}
		
		atlModule.eResource().getContents().add(atlMetaModel);
		
		translationTable.addTranslation(atlMetaModel,addedModel);
	}
	
	/**
	 * UNUSED
	 */
	private EObject instructionBlock2actionBody(InstructionBlock ib) {
		EObject actionBody = atlFactory.createModelElement("ActionBody");
		
		return actionBody;
	}
	
	// a new ib has been assigned to a function
	// [assumption] we have to create new ActionBlock 
	protected void handleFunctionSetBody(Function function, InstructionBlock ib) {
		// a matched rule until now
		EObject rule = translationTable.translate(function);
		
		EObject ourActionBlock = atlFactory.createModelElement("ActionBlock");
		
		List<String> commentsAfter = new LinkedList<String>();
		commentsAfter.add("-- comment behind newly generated ActionBlock");
		VUtil.setAttribute(ourActionBlock, "commentsAfter", commentsAfter);
		
		VUtil.setReference(rule, "actionBlock", ourActionBlock);
		translationTable.addTranslation(ourActionBlock, ib);
	}

	
	protected EObject umt2AtlInstruction(Debug umtDebug) {
		EObject atlExpressionStat = createAtlPrintln(umtDebug.getText());
		
		translationTable.addTranslation(atlExpressionStat, umtDebug);
		return atlExpressionStat;
	}

	public EObject createAtlPrintln(String msg) {
		EObject atlExpressionStat = atlFactory.createModelElement("ExpressionStat");
		EObject atlOperationCallExp = atlFactory.createModelElement("OperationCallExp");
		EObject atlStringExp = atlFactory.createModelElement("StringExp");

		VUtil.setReference(atlExpressionStat, "expression", atlOperationCallExp);
		VUtil.setReference(atlOperationCallExp, "source", atlStringExp);
		
		VUtil.setAttribute(atlOperationCallExp, "operationName", "println");
		VUtil.setAttribute(atlStringExp, "stringSymbol", msg);
		return atlExpressionStat;
	}
	
	protected EObject umt2AtlInstruction(BlackBoxExpression umt) {
		logger.warn("UMT instruction mapped to null instead of specific ATL instruction. This will almost "+
				"certainly lead to unwanted program shutdown.");
		return null;
	}
	
	protected EObject umt2AtlInstruction(VariableDeclarationInstruction umt) {
		logger.warn("UMT instruction mapped to null instead of specific ATL instruction. This will almost "+
				"certainly lead to unwanted program shutdown.");
		return null;
	}
	
	protected EObject umt2AtlInstruction(VariableAssignment umt) {
		logger.warn("UMT instruction mapped to null instead of specific ATL instruction. This will almost "+
				"certainly lead to unwanted program shutdown.");
		return null;
	}
	
	protected EObject umt2AtlInstruction(CallExpression umt) {
		logger.warn("UMT instruction mapped to null instead of specific ATL instruction. This will almost "+
				"certainly lead to unwanted program shutdown.");
		return null;
	}
	
	protected EObject umt2AtlInstruction(NumerousKindsOfBranches umt) {
		logger.warn("UMT instruction mapped to null instead of specific ATL instruction. This will almost "+
				"certainly lead to unwanted program shutdown.");
		return null;
	}

	protected EObject umt2AtlInstruction(AddTraceLink umt) {
		return null;
	}
	
	//	<statements xsi:type="atl:ExpressionStat" location="29:3-29:24">
	//    <expression xsi:type="ocl:OperationCallExp" location="29:3-29:23" operationName="CFS_pop">
	//      <source xsi:type="ocl:VariableExp" location="29:3-29:13" referredVariable="/8" />
	//    </expression>
	//  </statements>
		
	//	<ocl:VariableDeclaration location="29:3-29:13" varName="thisModule" variableExp="/0/@elements.1/@actionBlock/@statements.2/@expression/@source"/>
	
	// mapped to call to called rule CFS_pop (parameterless)
	
	private int getNumberOfInvolvedVariables(List<Condition> conditions) {
		int count = 0;
		for (Condition condition : conditions)
			count += condition.getDependencies().size();
		return count;
	}
	
	protected EObject umt2AtlInstruction(CfsPop umtInstruction) {
		EObject atlExpressionStat = atlFactory.createModelElement("ExpressionStat");
		EObject atlOperationCallExp = atlFactory.createModelElement("OperationCallExp");
		EObject atlVariableExp = atlFactory.createModelElement("VariableExp");
		EObject thisModule = atlFactory.createModelElement("VariableDeclaration");
		EObject atlIntegerExpression = atlFactory.createModelElement("IntegerExp");
		
		VUtil.setReference(atlExpressionStat, "expression", atlOperationCallExp);
		VUtil.setReference(atlOperationCallExp, "source", atlVariableExp);
		VUtil.setReference(atlVariableExp, "referredVariable", thisModule);

		VUtil.setAttribute(atlOperationCallExp, "operationName", "CFS_pop_multiple");
		VUtil.setAttribute(thisModule, "varName", "thisModule");
		VUtil.addtoReference(atlOperationCallExp, "arguments", atlIntegerExpression);

		VUtil.setAttribute(atlIntegerExpression, "integerSymbol", umtInstruction.getVariables().size());
		
		// ugly
		thisModule.eResource().getContents().add(thisModule);

		return atlExpressionStat;
	}

	private EObject atlCfsPush(Variable var) {
		EObject atlExpressionStat = atlFactory.createModelElement("ExpressionStat");
		EObject atlOperationCallExp = atlFactory.createModelElement("OperationCallExp");
		EObject atlVariableExp = atlFactory.createModelElement("VariableExp");
		EObject thisModule = atlFactory.createModelElement("VariableDeclaration");
		
		VUtil.setReference(atlExpressionStat, "expression", atlOperationCallExp);
		VUtil.setReference(atlOperationCallExp, "source", atlVariableExp);
		VUtil.setReference(atlVariableExp, "referredVariable", thisModule);
		
		VUtil.setAttribute(atlOperationCallExp, "operationName", "CFS_push");
		VUtil.setAttribute(thisModule, "varName", "thisModule");
		
		// ugly
		thisModule.eResource().getContents().add(thisModule);
		
		return atlExpressionStat;
	}
	protected List<EObject> umt2AtlInstruction(CfsPush umtInstruction) {
		// for every condition : for every var @ dependencies : add a CFS_push_X(var) call
		List<EObject> ret = new LinkedList<EObject>();
		
		for (Variable condition : umtInstruction.getVariables()) {
			//TraceType tt;
			
			//for (Variable var : condition.getDependencies()) {
				//ret += atlCfsPush(var);
			//}
		}
		
		return ret;
	}
	
	protected List<EObject> umt2AtlInstruction(StInstruction stInstruction) {
		List<EObject> ret = new LinkedList<EObject>();
		String operationName;
		
		if (stInstruction instanceof StPut)
			operationName = "ST_put";
		else if (stInstruction instanceof StDrop)
			operationName = "ST_drop";
		else {
			VUtil.myExit("unknown symbol table instruction of type " + stInstruction.eClass().getName());
			return null;
		}
		
		for (Variable symbol : stInstruction.getSymbols()) {
			// ATL: ST_put/drop("symbol") (where symbol is a string representation of the referred variable)
			EObject atlExpressionStat = atlFactory.createModelElement("ExpressionStat");
			EObject atlOperationCallExp = atlFactory.createModelElement("OperationCallExp");
			EObject atlVariableExp = atlFactory.createModelElement("VariableExp");
			EObject thisModule = atlFactory.createModelElement("VariableDeclaration");
			EObject atlStringExpression = atlFactory.createModelElement("StringExp");
			
			VUtil.setReference(atlExpressionStat, "expression", atlOperationCallExp);
			VUtil.setReference(atlOperationCallExp, "source", atlVariableExp);
			VUtil.setReference(atlVariableExp, "referredVariable", thisModule);

			VUtil.setAttribute(atlOperationCallExp, "operationName", operationName);
			VUtil.setAttribute(thisModule, "varName", "thisModule");
			VUtil.setAttribute(atlStringExpression, "stringSymbol", symbol.getName());
			VUtil.addtoReference(atlOperationCallExp, "arguments", atlStringExpression);

			// ugly
			thisModule.eResource().getContents().add(thisModule);

			ret.add(atlExpressionStat);
		}
		return ret;
	}
	
	
	/**
	 * we don't need to be able to map any UMT instruction, at the end only a subset (hint: make interface/
	 * inheritance group) can usefully be added.
	 * 
	 * ... . Gets mapped.
	 *  
	 * @param umtInstruction
	 * @return ATL instruction equivalent to the given UMT instruction
	 */
	protected EObject umt2AtlInstruction(EObject umtInstruction) {
		EObject atlRet;
		
		// alternative approaches: duck typing, reflection; both not much less evil, yet more complicated
		
		if (umtInstruction instanceof Comment) {
			logger.warn("ATL does not directly support comments in this fashion. Ignoring demand to add " +
					"comment with text '" + ((Comment) umtInstruction).getText() + " '(might lead to program shutdown).");
			return null;
		} if (umtInstruction instanceof Debug) {
			atlRet = umt2AtlInstruction ( (Debug) umtInstruction);
		} else if (umtInstruction instanceof CfsPush && false) {
			// XXX atlRet = umt2AtlInstruction ( (CfsPush) umtInstruction);
		} else if (umtInstruction instanceof CfsPop) {
			atlRet = umt2AtlInstruction ( (CfsPop) umtInstruction);
		} else {
			logger.warn("Don't know how to handle UMT instruction " + umtInstruction.eClass().getName() +
					"; UMT instruction mapped to generic placeholder instead of specific ATL instruction.");
			return createAtlPrintln("warning: actionless placeholder for instruction of type " + umtInstruction.eClass().getName());
		}
		
		// Necessary for every instruction? Should only be needed for branches etc.
		translationTable.addTranslation(atlRet, umtInstruction);
		
		return atlRet;
	}
	
	// scenario: there is a request to insert a UMT instruction @ position, where is that in ATL ActionBlock?
	private int umtInstructionBlockPosition2atlActionBlockPosition(InstructionBlock ib, EObject atlActionBlock, int position) {
		assert(atlActionBlock == translationTable.translate(ib));
		EList<Instruction> instructions = ib.getInstructions();
		EcoreEList<EObject> atlStatements = VUtil.getRefCollection(atlActionBlock, "statements");
		
		System.out.println("pos " + position + " inst.size " + instructions.size() + " atl.size " + atlStatements.size());
		
		// if position is 1st in UMT block, it's the 1st position in ATL block as well
		if (position == 0) {
			return 0;
		}
		
		// if position is last in UMT block, it's the last position in ATL block as well;
		// -1 because the instruction has already been added to UMT block when this method is called
		if (position == instructions.size() - 1) {
			return atlStatements.size();
		}
		
		// otherwise we don't have to pay attention to these corner cases
		
		logger.warn("XXX currently we should not reach this point 7zb");
		
		/* XXX untested, currently expected to fail 
		 * - not all instructions have atl pendants (spec: not pure vapodi instructions)
		 * - 'crawling around' if none at all has atl pendant (so feel free to grab any spot)
		 */
		Instruction instructionAtPosition = instructions.get(position);
		EObject atlInstructionAtPosition = translationTable.translate(instructionAtPosition);
		assert (atlInstructionAtPosition != null);
		
		int currentPosition = 0;
		for (EObject atlStatement : atlStatements) {
			if (atlStatement == atlInstructionAtPosition)
				return currentPosition;
			currentPosition++;
		}
		// will lead to problems
		
		return -1;
	}
	
	protected void handleInstructionBlockAddInstruction(InstructionBlock ib, Instruction addedInstruction, int position) {
		EObject actionBlock = translationTable.translate(ib);
		
		assert (actionBlock != null);
		
		// parameter 'position' is position UMT block, find out where that lies in ATL block
		int atlPosition = umtInstructionBlockPosition2atlActionBlockPosition(ib, actionBlock, position);
		if (atlPosition == -1)
			VUtil.myExit("Did not find respective ATL instruction in ActionBlock");
				
		VUtil.addtoReference(actionBlock, "statements", umt2AtlInstruction(addedInstruction));
	}
}

