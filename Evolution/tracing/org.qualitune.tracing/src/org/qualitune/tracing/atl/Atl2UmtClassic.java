/**
 * 
 */
package org.qualitune.tracing.atl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.qualitune.tracing.atl.ATL.*;
import org.qualitune.tracing.atl.OCL.*;
import org.qualitune.tracing.atl.OCL.VariableDeclaration;
import org.qualitune.tracing.umt.*;
import org.qualitune.tracing.util.VUtil;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class Atl2UmtClassic {
	 
	protected UmtFactory _umtFactory = null;
	Logger logger = null;
	Program program = null;
	
	public Atl2UmtClassic() {
		 _umtFactory = UmtFactory.eINSTANCE;
		 logger = Logger.getLogger(Atl2UmtClassic.class);
	}
	
	
	
	protected List<Model> model2model(OclModel src, IntentionEnum intention) {
		LinkedList<Model> ret = new LinkedList<Model>(); 
		InstanceModel instanceModel = _umtFactory.createInstanceModel();
		MetaModel metaModel = _umtFactory.createMetaModel();
		
		instanceModel.setMetamodel(metaModel);
		instanceModel.setIntention(intention);
		instanceModel.setName(src.getName());
		instanceModel.setUniverse(UniverseType.LIGHT_UNIVERSE);
		
		metaModel.setName(src.getMetamodel().getName());
		program.getModels().add(instanceModel);
		program.getModels().add(metaModel);
		
		logger.debug("added model " + instanceModel.getName() + " and its metamodel " + metaModel.getName());
		ret.add(instanceModel);
		ret.add(metaModel);
		return ret;
	}
	
	public Program module2program(Module module) {
		Program program = _umtFactory.createProgram();
		this.program = program;
		
		program.setName(module.getName());
		
		assert module.getLibraries().size() == 0;
		
		for (OclModel model : module.getInModels()) {
			program.getModels().addAll(model2model(model,IntentionEnum.IN));
		}
		
		for (OclModel model : module.getOutModels()) {
			program.getModels().addAll(model2model(model,IntentionEnum.OUT));
		}
		
		//VUtil.printEObject(module);
		
		for (ModuleElement moduleElement : module.getElements()) {
			if (moduleElement instanceof MatchedRule) {
				program.getFunctions().add(matchedRule2Function((MatchedRule) moduleElement));
			} else
				logger.warn("ignoring unknown ATL element of type " + moduleElement.eClass().getName());
		}
			
		return program;
	}


	protected InstructionBlock ActionBlock2instructionBlock(ActionBlock actionBlock) {
		InstructionBlock ib = _umtFactory.createInstructionBlock();
		
		return ib;
	}
	
	protected InstanceModel getInstanceModel(String Name) {
		for (Model candidate : program.getModels()) {
			if (candidate instanceof InstanceModel)
				if (candidate.getName().equals(Name))
					return (InstanceModel) candidate;
		}
		logger.error("failed to find instance model named " + Name);
		assert false;
		return null;
	}
	
	protected MetaModel getMetaModel(String name) {
		for (Model candidate : program.getModels()) {
			if (candidate instanceof MetaModel)
				if (candidate.getName().equals(name))
					return (MetaModel) candidate;
		}
		logger.error("failed to find metamodel named " + name);
		assert false;
		return null;
	}
	
	/**
	 * @param metaModelName
	 * @return
	 */
	private InstanceModel getInstanceModelFromMetaModelName(String metaModelName) {
		return getInstanceModel(getMetaModel(metaModelName));
	}
	
	/**
	 * gets the only one instance model of metamodel (yes, ATL fucks up the meta model idea)
	 * @param metaModel
	 * @return
	 */
	private InstanceModel getInstanceModel(MetaModel metaModel) {
		for (Model candidate : program.getModels())
			if (candidate instanceof InstanceModel)
				if (candidate.getMetamodel() == metaModel)
					return (InstanceModel) candidate;
		
		logger.error("failed to find instance model for metamodel " + metaModel.getName());
		assert false;
		return null;
	}



	/**
	 * return existing Model Type or create if not existing
	 * @param typeName
	 * @param metaModel
	 * @return
	 */
	ModelType getType(String typeName, MetaModel metaModel) {
		for (ModelType candidate : metaModel.getTypes()) {
			if (candidate.getName().equals(typeName))
				return candidate;
		}
		// otherwise create it
		logger.debug("creating type " + typeName + " of " + metaModel.getName());
		
		ModelType ret = _umtFactory.createModelType();
		ret.setName(typeName);
		metaModel.getTypes().add(ret);
		return ret;
	}
	
	protected ModelVariable createModelVariable(String varName, String typeName, String metaModelName) {
		ModelVariable modelVar = _umtFactory.createModelVariable();

		InstanceModel instanceModel = getInstanceModelFromMetaModelName(metaModelName);
		MetaModel metaModel = instanceModel.getMetamodel();
		ModelType type = getType(typeName, metaModel);

		modelVar.setName(varName);
		modelVar.setModel(instanceModel);
		modelVar.setType(type);
		
		return modelVar;
	}
	
	



	protected Debug createDebug(String text) {
		Debug debug = _umtFactory.createDebug();
		debug.setText(text);
		return debug;
	}
	
	/**
	 * @param moduleElement
	 * @return
	 */
	private Function matchedRule2Function(MatchedRule rule) {
		Function function = _umtFactory.createFunction();
		function.setName(rule.getName());
		
		InstructionBlock ruleMatchingBlock = _umtFactory.createInstructionBlock();
		Selection selection = _umtFactory.createSelection();
		Branch lightBranch = _umtFactory.createBranch();
		TypeFilter filter = _umtFactory.createTypeFilter();
		
		InstructionBlock lightBody = ActionBlock2instructionBlock(rule.getActionBlock());
		
		lightBranch.setCondition(filter);
		lightBranch.setBody(lightBody);
		selection.getBranches().add(lightBranch);
		
		function.setBody(ruleMatchingBlock);
		
		
		for (InPatternElement inPatternElement : rule.getInPattern().getElements()) {
			if (inPatternElement instanceof SimpleInPatternElement) {
				SimpleInPatternElement sipe = (SimpleInPatternElement) inPatternElement;
				assert(sipe.getType() instanceof OclModelElement);
				OclModelElement type = (OclModelElement) sipe.getType();
				ModelVariable filterVar = createModelVariable(sipe.getVarName(), type.getName(), type.getModel().getName());
				filter.getDependencies().add(filterVar);
			} else
				logger.warn("ignoring unknown InPatternElement of rule.inPattern.elements");
			
		}
		
		for (OutPatternElement outPatternElement : rule.getOutPattern().getElements()) {
			if (outPatternElement instanceof SimpleOutPatternElement) {
				SimpleOutPatternElement sope = (SimpleOutPatternElement) outPatternElement;
				assert sope.getType() instanceof OclModelElement;
				OclModelElement type = (OclModelElement) sope.getType();
				ModelVariable outVar = createModelVariable(sope.getVarName(), type.getName(), type.getModel().getName());

				VariableDeclarationInstruction create = _umtFactory.createVariableDeclarationInstruction();
				create.setDestination(outVar);

				lightBody.getInstructions().add(create);
			} else
				logger.warn("ignoring unknown OutPatternElement of rule.outPattern.elements");
		}
		
		lightBranch.getBody().getInstructions().addAll(ActionBlock2Instructions(rule.getActionBlock()));
		
		return function;
	}



	/**
	 * @param actionBlock
	 * @return
	 */
	private List<Instruction> ActionBlock2Instructions(ActionBlock actionBlock) {
		List<Instruction> ret = new LinkedList<Instruction>();
		
		for (Statement s : actionBlock.getStatements()) {
			if (s instanceof ExpressionStat) {
				ret.addAll(expressionStat2Instructions((ExpressionStat) s));
			} else if (s instanceof BindingStat) {
				ret.addAll(bindingStat2Instructions((BindingStat) s));
			} else if (s instanceof IfStat) {
				ret.addAll(ifStat2Instructions((IfStat) s));
			} else if (s instanceof ForStat) {
				ret.addAll(forStat2Instructions((ForStat) s));
			} else {
				logger.warn("ignoring unknown statement of type " + s.eClass().getName());
			}
		}
		
		return ret;
	}



	/**
	 * @param s
	 * @return
	 */
	private List<Instruction> forStat2Instructions(ForStat s) {
		List<Instruction> ret = new LinkedList<Instruction>();
		logger.info("no idea: ForStat");
		VUtil.printEObject(s);

		return ret;
	}



	/**
	 * @param s
	 * @return
	 */
	private List<Instruction> ifStat2Instructions(IfStat s) {
		List<Instruction> ret = new LinkedList<Instruction>();
		
		logger.info("no idea: IfStat with comment " + s.getCommentsBefore());
		
		// TODO
		List<Variable> condVars = getInvolvedVariables(s.getCondition());
		for (Variable var : condVars) {
			
			logger.info(((ModelAttributeVariable) var).getInstanceOf().getName());
		}
		
		VUtil.printEObject(ret);
		
		return ret;
	}


	private List<Variable> getInvolvedVariables(OperatorCallExp condition) {
		List<Variable> ret = new LinkedList<Variable>();
		Variable var;
		
		if (! isInternalOperation(condition.getOperationName())) {
			logger.warn("custom model element operation is set to be called in a condition. VAPODI doesn't know what you're doing there.");
		}
		
		var = variableExp2Variable(condition.getSource());
		if (var != null)
			ret.add(var);
		
		for (OclExpression argument : condition.getArguments()) {
			var = variableExp2Variable(argument);
			
			if (var != null)
				ret.add(var);
		}
		
		return ret;
	}
	
	protected ModelVariable getVariable(String metaName, String metaEntity, String varName) {
		InstanceModel instanceModel = getInstanceModelFromMetaModelName(metaName);
		ModelVariable modelVar = getModelVariable(instanceModel, metaEntity, varName);
		return modelVar;
	}

	/**
	 * created if not there along with its meta-stuff
	 * @param metaName,metaEntity,varName,varAttribute complete description of a model attribute variable
	 * @return
	 */
	protected ModelAttributeVariable getVariable(String metaName, String metaEntityName, String varName, String varAttribute) {
		ModelVariable modelVar = getVariable(metaName, metaEntityName, varName);
		return getModelAttributeVariable(modelVar,metaEntityName);
	}
	
	protected ModelTypeAttribute getModelTypeAttribute(ModelVariable modelVariable, String attributeName) {
		ModelType modelType = modelVariable.getType();
		for (ModelTypeAttribute candidate :	modelType.getAttributes()) {
			if (candidate.getName().equals(attributeName))
				return candidate;
		}
		// otherwise create it
		ModelTypeAttribute modelTypeAttribute = _umtFactory.createModelTypeAttribute();
		modelTypeAttribute.setName(attributeName);
		modelTypeAttribute.setPartOf(modelType);
		return modelTypeAttribute;
	}
	
	protected ModelAttributeVariable getModelAttributeVariable(ModelVariable modelVariable, String attributeName) {
		for (ModelAttributeVariable candidate : modelVariable.getAttributes()) {
			if (candidate.getName().equals(attributeName))
				return candidate;
		}
		// otherwise create it
		ModelAttributeVariable modelAttribVar = _umtFactory.createModelAttributeVariable();
		modelAttribVar.setName(attributeName);
		modelAttribVar.setPartOf(modelVariable);
		modelAttribVar.setInstanceOf(getModelTypeAttribute(modelVariable, attributeName));
		
		return modelAttribVar;
	}
	
	/**
	 * @param instanceModel
	 * @param varName
	 * @return
	 */
	private ModelVariable getModelVariable(InstanceModel instanceModel,	String typeName, String varName) {
		for (ModelVariable candidate : instanceModel.getVariables()) {
			if (candidate.getName().equals(varName)) {
				return candidate;
			}
		}
		// otherwise create model variable
		ModelVariable ret = _umtFactory.createModelVariable();
		ret.setModel(instanceModel);
		ret.setName(varName);
		ret.setType(getModelType(instanceModel, typeName));
		
		return ret;
	}



	/**
	 * @param typeName
	 * @return
	 */
	private ModelType getModelType(InstanceModel instanceModel, String typeName) {
		MetaModel metaModel = instanceModel.getMetamodel();
		for (ModelType candidate : metaModel.getTypes())
			if (candidate.getName().equals(typeName))
				return candidate;

		// otherwise create it
		ModelType type = _umtFactory.createModelType();
		type.setName(typeName);
		type.setModel(metaModel);
		return type;
	}


	/**
	 * @param metaModelName
	 * @param typeName
	 * @param varName
	 * @param attributeName
	 * @return
	 */
	private ModelAttributeVariable getModelAttributeVariable(String metaModelName, String typeName, String varName,
			String attributeName)
	{
		MetaModel metaModel = getMetaModel(metaModelName);
		InstanceModel instanceModel = getInstanceModel(metaModel);
		ModelVariable modelVariable = getModelVariable(instanceModel, typeName, varName);
		return getModelAttributeVariable(modelVariable, attributeName);
	}
	
	/**
	 * @param source
	 * @return . Null otherwise (!).
	 */
	protected Variable variableExp2Variable(OclExpression source) {
		//VUtil.printer(source);
		if (source instanceof VariableExp) {
			// add variable itself
			
			assert false: "untested";
			
			VariableDeclaration sourceVarItself = ((VariableExp) source).getReferredVariable();
			
			String varName = sourceVarItself.getVarName();
			
			ModelVariable modelVar = _umtFactory.createModelVariable();
			
			return null;
		} else if (source instanceof NavigationOrAttributeCallExp) {
			// add a property of the variable
			// sourceVarItself -> model variable
			// sourceProp -> its attribute
			
			NavigationOrAttributeCallExp sourceProp = (NavigationOrAttributeCallExp) source;
			VariableDeclaration sourceVarItself = ((VariableExp) sourceProp.getSource()).getReferredVariable(); 
			
			String metaModelName = ((OclModelElement) sourceVarItself.getType()).getModel().getName();
			String typeName = sourceVarItself.getType().getName();
			String varName = sourceVarItself.getVarName();
			String attributeName = sourceProp.getName();
			
			logger.debug("wanted: mm: " + metaModelName + ", tn: " + typeName + ", vn: " + varName + ", an:" + attributeName);
			
			return getModelAttributeVariable(metaModelName,typeName,varName,attributeName);
		} else if (source instanceof PrimitiveExp) {
			// constant value, not a variable
			return null;
		} else {
			logger.warn("ignoring unknown OclExpression of type " + source.eClass().getName());
			return null;
		}
	}



	/**
	 * @param operationName
	 * @return
	 */
	private boolean isInternalOperation(String operationName) {
		if (operationName.equals("="))
			return true;
		
		logger.warn("assuming operation " + operationName + " to be internal");
		return true;
		
		//return false;
	}



	/**
	 * @param condition
	 */
	private List<Variable> getInvolvedVariables(OclExpression condition) {
		
		if (condition instanceof OperatorCallExp) {
			return getInvolvedVariables((OperatorCallExp) condition);
		} else {
			logger.warn("ignoring unknown condition of type " + condition.eClass().getName());
			return new LinkedList<Variable>();
		}
	}



	/**
	 * @param s
	 * @return
	 */
	private List<Instruction> bindingStat2Instructions(BindingStat s) {
		List<Instruction> ret = new LinkedList<Instruction>();
		logger.info("no idea: BindingStat");
		VUtil.printEObject(s);

		return ret;
	}



	/**
	 * @param s
	 * @return
	 */
	private List<Instruction> expressionStat2Instructions(ExpressionStat s) {
		List<Instruction> ret = new LinkedList<Instruction>();
		OclExpression e = s.getExpression();
		logger.info("no idea: ExpressionStat");
		VUtil.printEObject(s);
		
		//e.get
		return ret;
	}
}
