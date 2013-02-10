/**
 * 
 */
package org.qualitune.tracing.vapodi;

import java.nio.channels.GatheringByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.qualitune.tracing.umt.Branch;
import org.qualitune.tracing.umt.CfsPop;
import org.qualitune.tracing.umt.CfsPush;
import org.qualitune.tracing.umt.Condition;
import org.qualitune.tracing.umt.Debug;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.InstanceModel;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.IntentionEnum;
import org.qualitune.tracing.umt.Loop;
import org.qualitune.tracing.umt.MetaModel;
import org.qualitune.tracing.umt.Model;
import org.qualitune.tracing.umt.NumerousKindsOfBranches;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.Selection;
import org.qualitune.tracing.umt.UmtFactory;
import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.umt.VapodiInstruction;
import org.qualitune.tracing.umt.VariableAssignment;
import org.qualitune.tracing.umt_abstract_content_adapter.*;
import org.qualitune.tracing.util.VUtil;

/**
 * This class encapsulates a number of analyses.
 * 
 * They are presented a semantic view (UMT) of the program to be instrumented, analyse it and give orders
 * how to alter the program by changing its UMT representation. These intrusions are then propagated back to
 * the original program through listeners.
 * 
 * Later we might decide to put these analyses into separate classes each (into common analyses package),
 * depending on their grade of interdependence.
 *  
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class Analyses {
	
	EcoreFactory _ecoreFactory;
	EcorePackage _ecorePackage;
	
	UmtFactory _umtFactory;
	UmtPackage _umtPackage;
	
	static String DEFAULT_TRACING_MODEL_NAME      = "VAPODITRACE_HARDCODED";
	static String DEFAULT_TRACING_META_MODEL_NAME = "VAPODITRACEMETAMODEL_HARDCODED";
	
	
	public Analyses()
	{
		_ecoreFactory = EcoreFactory.eINSTANCE;
		_ecorePackage = EcorePackage.eINSTANCE;
		_umtFactory = UmtFactory.eINSTANCE;
		_umtPackage = UmtPackage.eINSTANCE;
	}
	
	/**
	 * Very basic analysis for demonstration purposes
	 * @param program The program to have its name changed
	 */
	public void setName(Program program) {
		program.setName("this_is_the_name_of_our_changed_program");
	}
	
	
	private void addCfs(Branch branch) {
		InstructionBlock body = branch.getBody();
		EList<Instruction> instructions = body.getInstructions();
		Condition condition = branch.getCondition();
		
		CfsPush cfsPush = _umtFactory.createCfsPush();
		cfsPush.getConditions().add(condition);
		instructions.add(0, cfsPush);
		
		CfsPop cfsPop = _umtFactory.createCfsPop();
		cfsPop.getConditions().add(condition);
		instructions.add(cfsPop);
	}
	
	private void addCfs(Selection selection) {
		for (Branch branch : selection.getBranches()) {
			addCfs(branch);
			EStructuralFeature bodyFeature = branch.eClass().getEStructuralFeature(UmtPackage.BRANCH__BODY);
			if (branch.eIsSet(bodyFeature))
				addCfs(branch.getBody());
		}
	}
	
	private void addCfs(Loop loop) {
		assert(false);
	}
	
	private void addCfs(InstructionBlock ib) {
		for (Instruction i : ib.getInstructions()) {
			if (i instanceof NumerousKindsOfBranches) {
				if (i instanceof Selection)
					addCfs((Selection) i);
				else if (i instanceof Loop)
					addCfs((Loop) i);
				else
					VUtil.warning("Unknown branch type. Did you change the UMT metamodel?");
			}
		} 
	}

	/**
	 * Adds CFS_push / CFS_pop to entry / exit of branches
	 * TODO branching condition parameters
	 * @param program
	 */
	public void addCfs(Program program) {
		// first functions
		System.out.println("going to add CFS directives to branches");
		// TODO function is some kind of branch, too, but can't be included in an instrucitonBlock
		
		for (Function f : program.getFunctions()) {
			EStructuralFeature bodyFeature = f.eClass().getEStructuralFeature(UmtPackage.FUNCTION__BODY);
			if (f.eIsSet(bodyFeature))
				addCfs(f.getBody());
		}
	}
	
	// resets function bodies just to contain a debug entry, more reasonable things to come
	public void addDebugToAllFunctions(Program program) {
		for (Function f : program.getFunctions()) {
			InstructionBlock ib = f.getBody();
			
			if (ib == null) {
				ib = _umtFactory.createInstructionBlock();
				f.setBody(ib);
			}
			
			Debug debug = _umtFactory.createDebug();
			debug.setText("Entering function " + f.getName());
			
			ib.getInstructions().add(debug);			
		}
	}
	
	/**
	 * Suggests a name which is not currently used for tracing model. Starts with
	 * @link{#DEFAULT_TRACING_MODEL_NAME}, appends 'x's to this name until a non-existent candidate is
	 * found.
	 *  
	 * @param program The program to find a unique tracing model name for
	 * @return a unique name for the tracing model
	 */
	private String suggestUniqueModelName(Program program, String candidate) {
		String sugesstion = candidate;
		LinkedList<String> allNames = new LinkedList<String>(); 

		for (Model m : program.getModels()) {
			allNames.add(m.getName());
		}
		
		while (allNames.contains(sugesstion))
			sugesstion += 'x';
		
		return sugesstion;
	}
	
	
	
	/**
	 * what we basically do:
	 * 
	 * @param branch
	 */
	private StaticDependencyTree staticAnalysis(InstructionBlock ib) {
		StaticDependencyTree sdt = new StaticDependencyTree();
		
		for (Instruction instruction : ib.getInstructions()) {
			if (instruction instanceof VapodiInstruction) {
				VUtil.warning("analysis has found a VapodiInstruction. This should not happen, as VapodiIstructions are added after" +
						"analysis phase");
			} else if (instruction instanceof NumerousKindsOfBranches) {
				// do something recursive
			} else if (instruction instanceof VariableAssignment) {
				// yea, most interesting
			} else {
				VUtil.warning("analysis has found an instruction it does not understand of class " + instruction.eClass().getName());
			}
		}
		
		return sdt;
	}
	
	/**
	 * Adds tracing model to set of models which the program can write to.
	 * 
	 * @deprecated Nowadays we do this through merging with the atl_lib/vapodi_base_stub.atl
	 * 
	 * @param program
	 */
	public void addTracingModel(Program program) {
		InstanceModel tracingModel = _umtFactory.createInstanceModel();
		tracingModel.setName(suggestUniqueModelName(program, DEFAULT_TRACING_MODEL_NAME));
		tracingModel.setIntention(IntentionEnum.OUT);
		// following one relevant?
		//tracingModel.setUniverse(UniverseType.LIGHT_UNIVERSE);
		
		MetaModel tracingMetaModel = _umtFactory.createMetaModel();
		tracingMetaModel.setName(suggestUniqueModelName(program, DEFAULT_TRACING_META_MODEL_NAME));
		//tracingMetaModel.setnsURI("http://smt.inf.tu-dresden.de/fab/vapoditrace");
		//tracingMetaModel.setnsPrefix("vapoditrace");
		
		tracingModel.setMetamodel(tracingMetaModel);
		
		// XXX two interdependent adds - looking up each other, independent of order in which they are added!
		program.getModels().add(tracingMetaModel);
		program.getModels().add(tracingModel);
		
	}
}
