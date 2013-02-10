/**
 * 
 */
package org.qualitune.tracing.atl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.Condition;
import org.qualitune.tracing.umt.Debug;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.InstanceModel;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.IntentionEnum;
import org.qualitune.tracing.umt.MetaModel;
import org.qualitune.tracing.umt.Model;
import org.qualitune.tracing.umt.ModelAttributeVariable;
import org.qualitune.tracing.umt.ModelType;
import org.qualitune.tracing.umt.ModelVariable;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Selection;
import org.qualitune.tracing.umt.TypeFilter;
import org.qualitune.tracing.umt.UmtFactory;
import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.umt.UniverseType;
import org.qualitune.tracing.umt.Variable;
import org.qualitune.tracing.umt.VariableDeclarationInstruction;
import org.qualitune.tracing.umt_abstract_content_adapter.*;
import org.qualitune.tracing.util.VUtil;

/**
 * Encapsulates transformation ATL -> UMT
 * 
 * @author Fabian Haensel
 *
 */
public class Atl2Umt {

	EcoreFactory _ecoreFactory;
	EcorePackage _ecorePackage;
	
	UmtFactory _umtFactory;
	UmtPackage _umtPackage;
	AtlPseudoFactory _atlFactory;
	
	IModel atlCreator = null;
	IReferenceModel atlMetamodel = null;
		
	// maps UMT elements to ATL ones
	TranslationTable translationTable;
	
	// root elements
	Program _umtRoot = null;
	EObject _atlRoot = null;
	
	public Atl2Umt (IReferenceModel atlMetamodel) {
		_ecoreFactory = EcoreFactory.eINSTANCE;
		_ecorePackage = EcorePackage.eINSTANCE;
		_umtFactory = UmtFactory.eINSTANCE;
		_umtPackage = UmtPackage.eINSTANCE;
		
		// This 'factory' alone is not able to produce ATL model elements 
		ModelFactory atlModelFactory = atlMetamodel.getModelFactory();   
		
		try {
			atlCreator = (EMFModel) atlModelFactory.newModel(atlMetamodel);
		} catch (ATLCoreException e) {
			System.err.println("[VAPODI] Error while initialising software component to " +
					"generate new ATL model elements.");
			e.printStackTrace();
		}
		
		_atlFactory = new AtlPseudoFactory(atlCreator, atlMetamodel);
		translationTable = new TranslationTable();
		
		this.atlMetamodel = atlMetamodel;
	}
	
	// returns instance model and meta model
	public List<EObject> atlInstance2umtInstanceAndMetaModel(EObject model, IntentionEnum intention) {
		//printer(inModel);

		/* ASSERT correct input */

		assert(VUtil.typeName(model).equals("OclModel"));

		/* RETRIEVE properties from source object */

		String name = VUtil.getStringAttributeValue(model, "name");
		EObject inMetaModel = VUtil.getRefTarget(model, "metamodel");
		assert(VUtil.typeName(inMetaModel).equals("OclModel"));
		String inMetaModelName = VUtil.getStringAttributeValue(inMetaModel, "name");

		/* CREATE destination object(s) or make other destination model changes */

		InstanceModel instanceModel = _umtFactory.createInstanceModel();
		instanceModel.setName(name);
		VUtil.setAttribute(instanceModel, "intention", intention);
		VUtil.setAttribute(instanceModel, "universe", UniverseType.LIGHT_UNIVERSE);
		
		MetaModel metaModel = _umtFactory.createMetaModel();
		metaModel.setName(inMetaModelName);

		EReference metaModelRef = VUtil.getReference(instanceModel, "metamodel");
		instanceModel.eSet(metaModelRef, metaModel);

		/* CHECK result */
		//assert();
		//printer(program);

		LinkedList<EObject> result = new LinkedList<EObject>();
		result.add(instanceModel);
		result.add(metaModel);
		return result;
	}
	
	public InstructionBlock actionBlock2instructionBlock(EObject atlActionBlock) {
		assert(VUtil.typeName(atlActionBlock).equals("ActionBlock"));
		List<EObject> atlInstructions = VUtil.getRefCollection(atlActionBlock, "statements");
		InstructionBlock ib = _umtFactory.createInstructionBlock();
		List<Instruction> instructions = ib.getInstructions();
		
		for (EObject atlInstruction : atlInstructions) {
			Instruction umtInstruction = atlInstruction2umtInstruction(atlInstruction);
			instructions.add(umtInstruction);
		}
		
		return ib;
	}

	// could be ModelVariable or PrimitiveVariable as well 
	// @untested
	protected Variable variableExp2Variable(EObject atlVariableExp) {
		VUtil.assertAtlType(atlVariableExp, "VariableExp");
		
		EObject oclModel = VUtil.getRefTarget(atlVariableExp, "referredVariable");
		VUtil.printer(oclModel);
		
		VUtil.assertAtlType(oclModel,"OclModel");
		
		assert !VUtil.isSet(oclModel, "model") : "ReferredVariable refers to a model, but is expected to refere to a variable";
		
		List<EObject> elements = VUtil.getRefCollection(oclModel, "elements");
		assert elements.size() == 1;
		
		// this first
		
		return null;
	}
	
	// @untested
	protected ModelAttributeVariable navigationOrAttributeCallExp2modelAttributeVariable (EObject atlNavigationOrAttributeCallExp) {
		VUtil.assertAtlType(atlNavigationOrAttributeCallExp, "NavigationOrAttributeCallExp");
		
		ModelAttributeVariable ret = _umtFactory.createModelAttributeVariable();
		
		String attributeName = VUtil.getName(atlNavigationOrAttributeCallExp);
		
		VUtil.printer(atlNavigationOrAttributeCallExp);
		
		EObject oclModel = VUtil.getRefTarget(atlNavigationOrAttributeCallExp, "source"); 
		
		
		
		return ret;
	}
	
	// @untested
	protected Variable variable2variable(EObject atlVariable) {
		String atlVarType = VUtil.typeName(atlVariable);
		if (atlVarType.equals("VariableExpr")) {
			return variableExp2Variable(atlVariable);
		} else if (atlVarType.equals("NavigationOrAttributeCallExp")) {
			return navigationOrAttributeCallExp2modelAttributeVariable(atlVariable);
		} else {
			VUtil.myExit("Meta model inconsistency: unknown variable type " + atlVarType);
			return null;
		}
	}
	
	/**
	 * 
	 * @param atlRule
	 * @return ActionBlock of atlRule or new one if not present
	 */
	protected EObject giveAtlActionBlock(EObject atlRule) {
		EReference atlActionBlockRef = VUtil.getReference(atlRule, "actionBlock");
		if (atlRule.eIsSet(atlActionBlockRef))
			return VUtil.getRefTarget(atlRule, "actionBlock");
		else {
			EObject atlActionBlock = _atlFactory.createModelElement("ActionBlock");
			VUtil.setReference(atlRule, atlActionBlockRef, atlActionBlock);
			return atlActionBlock;
		}
	}
	
	public Function matchedRule2function(EObject atlRule) {
		assert(VUtil.typeName(atlRule).equals("MatchedRule"));
		
		// get data from ATL
		String name = VUtil.getStringAttributeValue(atlRule, "name");
		
		boolean isAbstract = VUtil.getBooleanAttributeValue(atlRule, "isAbstract");
		boolean isRefining = VUtil.getBooleanAttributeValue(atlRule, "isRefining");
		boolean isNoDefault = VUtil.getBooleanAttributeValue(atlRule, "isNoDefault");
		VUtil.shouldBe(!isAbstract, "matchedRule " + name + " is abstract");
		VUtil.shouldBe(!isRefining, "matchedRule " + name + " is refining");
		VUtil.shouldBe(!isNoDefault, "matchedRule " + name + " is no default");
		
		// as we *know* that we'll put directives into every function's body, we can safely create a body for each, no waste of resources
		EObject atlActionBlock = giveAtlActionBlock(atlRule);
		
		// TODO: children, superrule , varaiables,
		
		// create UMT data structures
		Function function = _umtFactory.createFunction();
		function.setName(name);
		
		InstructionBlock functionBody = _umtFactory.createInstructionBlock();
		
		Selection selection = _umtFactory.createSelection();
		Branch branch = _umtFactory.createBranch();
		TypeFilter typeFilter = _umtFactory.createTypeFilter();
		InstructionBlock branchBody = actionBlock2instructionBlock(atlActionBlock);
		VariableDeclarationInstruction create = _umtFactory.createVariableDeclarationInstruction();
		List <ModelVariable> requiredElements = inPattern2variables(VUtil.getRefTarget(atlRule, "inPattern"));
		List <ModelVariable> createdElements = outPattern2variables(VUtil.getRefTarget(atlRule, "outPattern"));
		
		// 'wire' them
		function.setBody(functionBody);
		functionBody.getInstructions().add(selection);
		selection.getBranches().add(branch);
		branch.setCondition(typeFilter);
		branch.setBody(branchBody);
		typeFilter.getDependencies().addAll(requiredElements);
		branchBody.getInstructions().add(0,create);
		create.getVariables().addAll(createdElements);
		
		// XXX no translation table entry for 'create', as this is a pure VapodiInstruction
		translationTable.addTranslation(atlActionBlock, branchBody);
		translationTable.addTranslation(atlRule, function);
		return function;
	}

	/**
	 * @param refTarget
	 * @return
	 */
	private List<ModelVariable> outPattern2variables(EObject outPattern) {
		assert(VUtil.typeName(outPattern).equals("OutPattern"));
		List<ModelVariable> ret = new LinkedList<ModelVariable>();

		for (EObject simpleOutPatternElement : VUtil.getRefCollection(outPattern, "elements")) {
			ModelVariable createdElement = _umtFactory.createModelVariable();

			createdElement.setName(VUtil.getStringAttributeValue(simpleOutPatternElement, "varName"));
			
			EObject type = VUtil.getRefTarget(simpleOutPatternElement, "type");
			assert(VUtil.typeName(type).equals("OclModelElement"));

			String typeName = VUtil.getStringAttributeValue(type, "name");
			EObject typeMetaModel = VUtil.getRefTarget(type, "model");
			String typeMetaModelName = VUtil.getStringAttributeValue(typeMetaModel, "name");
			//System.out.println("out: " + createdElement.getName() + " : " + typeMetaModelName + "!" + typeName);
			
			ModelType createdElementModelType = lookupModelTypeFromMetaModel(typeName,typeMetaModelName);
			createdElement.setType(createdElementModelType);

			ret.add(createdElement);
		}
		return ret;
	}

	private InstanceModel lookupInstanceModel(String name) {
		for (Model m : _umtRoot.getModels()) {
			if (m.getName().equals(name)) {
				assert (m instanceof InstanceModel) : "Expecting model named " + name + " to be of type InstanceModel";
				return (InstanceModel) m;
			}
		}
		return null;
	}
	
	private MetaModel lookupMetaModel(String name) {
		for (Model m : _umtRoot.getModels()) {
			if (m.getName().equals(name)) {
				assert (m instanceof MetaModel) : "Expecting model named " + name + " to be of type MetaModel";
				return (MetaModel) m;
			}
		}
		return null;
	}
	
	// this was the logical way, yet ATL has a serious glitch regarding model specification (handle is not instance, but metamodel)
	private ModelType lookupModelTypeFromInstanceModel(String typeName, String instanceModelName) {
		InstanceModel instanceModel = lookupInstanceModel(instanceModelName);
		assert (instanceModel != null);
		
		MetaModel metaModel = instanceModel.getMetamodel();
		assert (metaModel != null);
		
		for (ModelType mt : metaModel.getTypes()) {
			if (mt.getName().equals(typeName))
				return mt;
		}
		
		// if model type does not exist, create it
		
		ModelType newModelType = _umtFactory.createModelType();
		newModelType.setName(typeName);
		newModelType.setModel(metaModel);
		
		return newModelType;
	}
	
	private ModelType lookupModelTypeFromMetaModel(String typeName, String metaModelName) {
		MetaModel metaModel = lookupMetaModel(metaModelName);
		assert (metaModel != null);
		
		for (ModelType mt : metaModel.getTypes()) {
			if (mt.getName().equals(typeName))
				return mt;
		}
		
		// if model type does not exist, create it
		
		ModelType newModelType = _umtFactory.createModelType();
		newModelType.setName(typeName);
		newModelType.setModel(metaModel);
		
		return newModelType;
	}
	
	/**
	 * @param inPattern
	 * @return
	 */
	private List<ModelVariable> inPattern2variables(EObject inPattern) {
		assert(VUtil.typeName(inPattern).equals("InPattern"));
		List<ModelVariable> ret = new LinkedList<ModelVariable>();
		
		for (EObject simpleInPatternElement : VUtil.getRefCollection(inPattern, "elements")) {
			ModelVariable requiredElement = _umtFactory.createModelVariable();
			
			requiredElement.setName(VUtil.getStringAttributeValue(simpleInPatternElement, "varName"));
			//VUtil.printer(simpleInPatternElement);
			
			EObject type = VUtil.getRefTarget(simpleInPatternElement, "type");
			assert(VUtil.typeName(type).equals("OclModelElement"));
			
			String typeName = VUtil.getStringAttributeValue(type, "name");
			EObject typeMetaModel = VUtil.getRefTarget(type, "model");
			String typeMetaModelName = VUtil.getStringAttributeValue(typeMetaModel, "name");
			//System.out.println(requiredElement.getName() + " : " + typeMetaModelName + "!" + typeName);
			
			ModelType requiredElementModelType = lookupModelTypeFromMetaModel(typeName,typeMetaModelName);
			requiredElement.setType(requiredElementModelType);
			
			ret.add(requiredElement);
		}
		return ret;
	}
	
	protected Instruction atlInstruction2umtInstruction(EObject atlInstruction) {
		String atlInstructionType = VUtil.typeName(atlInstruction);
		Instruction ret;
		
		if (atlInstructionType.equals("IfStat")) {
			ret = ifStat2Selection(atlInstruction);
		} else {
			VUtil.warning("Unknown ATL instruction type " + atlInstructionType + ", creating debug instead.");
			Debug debug = _umtFactory.createDebug();
			debug.setText("replacement for " + atlInstructionType);
			List<String> msgList = new LinkedList<String>();
			msgList.add("-- [VAPODI] warning: ATL instruction below is not handled by VAPODI and has been ignored for its analysis");
			VUtil.setAttribute(atlInstruction, "commentsBefore", msgList);
			ret = debug;
		}
		// translation routines do this themselves
		//translationTable.addTranslation(atlInstruction, ret);
		return ret;
	}
	
	private InstructionBlock statements2instructionBlock(List <EObject> atlStatments) {
		InstructionBlock ib = _umtFactory.createInstructionBlock();
		List <Instruction> instructions = ib.getInstructions(); 
		
		for (EObject atlStatement : atlStatments) {
			instructions.add(atlInstruction2umtInstruction(atlStatement));
		}
		
		return ib;
	}
	
//	<condition xsi:type="ocl:OperatorCallExp" location="18:6-18:27" operationName="=">
//    <source xsi:type="ocl:NavigationOrAttributeCallExp" location="18:6-18:17" name="name">
//      <source xsi:type="ocl:VariableExp" location="18:6-18:12" referredVariable="/0/@elements.0/@inPattern/@elements.0"/>
//    </source>
//    <arguments xsi:type="ocl:VariableExp" location="18:20-18:27" referredVariable="/0/@elements.0/@variables.0"/>
//  </condition>

  private List<Variable> gatherInvolvedVariables(EObject atlOperatorCallExp) {
		VUtil.assertAtlType(atlOperatorCallExp, "OperatorCallExp");
		
		/* number of properties, we go for thinks like X = Y
		 * - source
		 * - arguments
		 */
		assert VUtil.isSet(atlOperatorCallExp, "operationName");
		assert ! VUtil.isSet(atlOperatorCallExp, "type");
		assert ! VUtil.isSet(atlOperatorCallExp, "ifExp3");
		assert ! VUtil.isSet(atlOperatorCallExp, "appliedProperty");
		assert ! VUtil.isSet(atlOperatorCallExp, "collection");
		assert ! VUtil.isSet(atlOperatorCallExp, "letExp");
		assert ! VUtil.isSet(atlOperatorCallExp, "loopExp");
		assert ! VUtil.isSet(atlOperatorCallExp, "parentOperation");
		assert ! VUtil.isSet(atlOperatorCallExp, "initializedVariable");
		assert ! VUtil.isSet(atlOperatorCallExp, "ifExp2");
		assert ! VUtil.isSet(atlOperatorCallExp, "owningOperation");
		assert ! VUtil.isSet(atlOperatorCallExp, "ifExp1");
		assert ! VUtil.isSet(atlOperatorCallExp, "owningAttribute");
				
		List<Variable> ret = new LinkedList<Variable>();
		
		EObject source = VUtil.getRefTarget(atlOperatorCallExp, "source");
		if (VUtil.isAtlVariable(source))
			ret.add(variable2variable(source));
		
		for (EObject argument :  VUtil.getRefCollection(atlOperatorCallExp, "arguments"))
			if (VUtil.isAtlVariable(argument))
				ret.add(variable2variable(argument));
		
		
		
		return ret;
	}
	
	/**
	 * @param atlIfStat
	 * @return
	 */
	private Instruction ifStat2Selection(EObject atlIfStat) {
		VUtil.assertAtlType(atlIfStat, "IfStat");
		
		EObject atlCondition = VUtil.getRefTarget(atlIfStat, "condition");
		List<EObject> atlThenStatements = VUtil.getRefCollection(atlIfStat, "thenStatements");
		List<EObject> atlElseStatements = VUtil.getRefCollection(atlIfStat, "elseStatements");
		
		//VUtil.assertAtlType(atlCondition, "OclExpression"); - could be others as well
		
		InstructionBlock thenBody = statements2instructionBlock(atlThenStatements);
		InstructionBlock elseBody = statements2instructionBlock(atlElseStatements);
		
		Selection selection = _umtFactory.createSelection();
		Branch thenBranch   = _umtFactory.createBranch();
		Branch elseBranch   = _umtFactory.createBranch();
		Condition ifCondition = _umtFactory.createLogicalCondition();
		
		List<Branch> branches = selection.getBranches();
		branches.add(thenBranch);
		branches.add(elseBranch);
		
		thenBranch.setCondition(ifCondition);
		// looks strange, but remember that this construct expresses a dependency from 
		// elements of ifCondition to execution of this branch
		elseBranch.setCondition(EcoreUtil.copy(ifCondition));
		
		thenBranch.setBody(thenBody);
		elseBranch.setBody(elseBody);
		
		ifCondition.getDependencies().addAll(gatherInvolvedVariables(atlCondition));
		
		translationTable.addTranslation(atlIfStat, selection);
		return selection;
	}

	public Program module2program(EObject atlModule) {
		/* ASSERT correct input */
		
		assert(VUtil.typeName(atlModule).equals("Module"));
		
		/* RETRIEVE properties from source object */
		
		//EReference librariesRef, inModelsRef,outModelsRef,elementsRef;
		
		String name;
		boolean isRefining;
		EcoreEList<EObject> inModels;
		EcoreEList<EObject> outModels;
		EcoreEList<EObject> elements; 
		
		name = VUtil.getStringAttributeValue(atlModule, "name");
		
		// same check twice actually to see how default values are handled 
		isRefining = VUtil.getBooleanAttributeValue(atlModule, "isRefining");
		VUtil.shouldBe(! isRefining,"This module is in refining mode.");
		VUtil.shouldBe(! VUtil.isSet(atlModule,"isRefining"),"This module is in refining mode.");
		
		VUtil.shouldBe(! VUtil.isSet(atlModule,"libraries"),"This module has libraries.");
		
		Program program = _umtFactory.createProgram();
		VUtil.setAttribute(program,"name",name);
		
		_umtRoot = program;
		_atlRoot = atlModule;
		
		inModels = VUtil.getRefCollection(atlModule,"inModels");
		for (EObject inModel : inModels) {
			VUtil.addtoReference(program,"models",atlInstance2umtInstanceAndMetaModel(inModel,IntentionEnum.IN));
		}
		
		outModels = VUtil.getRefCollection(atlModule,"outModels");
		for (EObject outModel : outModels) {
			//program.getModels().addAll((handleModel(outModel,IntentionEnum.OUT));
			VUtil.addtoReference(program,"models",atlInstance2umtInstanceAndMetaModel(outModel,IntentionEnum.OUT));
		}
		
		elements = VUtil.getRefCollection(atlModule,"elements");
		for (EObject element : elements) {
			// atlMatchedRule, Helper, atlCalledRule, ...
			String typeName = VUtil.typeName(element);
			if (typeName.equals("MatchedRule")) {
				program.getFunctions().add(matchedRule2function(element));
			} else
				VUtil.warning("unhandled element type " + typeName);
		}
		
		// who has to have a mapping entry?
		// i)  changes can happen to *any* UMT object, so *all* UMT object have to have a translation table entry
		// ii) changes can happen to *some* UMT objects, so *some* UMT object has to have a translation table entry
		// (we go for ii for now, might change)
		translationTable.addTranslation(atlModule, program);
		
		// important: add this one *after* complete construction of UMT model
		program.eAdapters().add(new Atl2UmtContentAdapter(translationTable,atlCreator,atlMetamodel));
		
		return program;
	}

}
