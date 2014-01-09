/**
 * 
 */
package org.qualitune.tracing.umt_abstract_content_adapter;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.Instruction;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.Model;
import org.qualitune.tracing.umt.Program;
import org.qualitune.tracing.umt.UmtPackage;
import org.qualitune.tracing.util.VUtil;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 * 
 * This class implements handleAffectedUmtELementNotification(n),
 * forces you to implement handleSomeEvent(affectedUmt,data).
 *
 * classes to implement
 * V1) high level: e.g. programNameChange(newName) or programNameChange(oldName, newName)  
 * V2) low level:  e.g. programNameChange(Notification n)
 * 
 * other approaches
 * V3) reflection: allow both, use reflection to find out which one to call
 * V4) abstract method programNameChange(Notification n) which calls programNameChange(newName);
 *     concrete class might implement programNameChange(newName) if sufficient, otherwise has to override
 *     programNameChange(Notification n) 
 */
abstract public class AbstractUmtEventContentAdapter extends AbstractUmtNotificationContentAdapter {
	
	protected void handleProgramNotification(Notification n){
		int featureID = n.getFeatureID(Program.class);
		Program program = (Program) n.getNotifier();
		
		if (featureID == UmtPackage.PROGRAM__NAME){
			if (n.getEventType() == Notification.SET){
				String newName = n.getNewStringValue();
				handleProgramSetName(program, newName);
			} else {
				warningUnknownEventType(n);
			}
		} else if (featureID == UmtPackage.PROGRAM__MODELS){
			if (n.getEventType() == Notification.ADD){
				Model addedModel = (Model) n.getNewValue();
				handleProgramAddModels(program, addedModel);
			} else {
				warningUnknownEventType(n);
			}
		} else
			warningUnknownFeature(n);
	}
	
	
	protected void handleFunctionNotification(Notification n){
		int featureID = n.getFeatureID(Function.class);
		Function function = (Function) n.getNotifier();
		
		if (featureID == UmtPackage.FUNCTION__BODY){
			if (n.getEventType() == Notification.SET){
				InstructionBlock newInstructionBlock = (InstructionBlock) n.getNewValue();
				handleFunctionSetBody(function, newInstructionBlock);
			} else
				warningUnknownEventType(n);
		} else
			warningUnknownFeature(n);
	}
	
	protected void handleInstructionBlockNotification(Notification n){
		InstructionBlock ib = (InstructionBlock) n.getNotifier();
		int featureID = n.getFeatureID(InstructionBlock.class);
		
		if (featureID == UmtPackage.INSTRUCTION_BLOCK__INSTRUCTIONS){
			if (n.getEventType() == Notification.ADD){
				Instruction addedInstruction = (Instruction) n.getNewValue();
				handleInstructionBlockAddInstruction(ib,addedInstruction,n.getPosition());
			} else
				warningUnknownEventType(n);
		} else
			warningUnknownFeature(n);
	}
	
	abstract protected void handleProgramSetName(Program program, String newName);
	abstract protected void handleProgramAddModels(Program program, Model addedModel);
	abstract protected void handleFunctionSetBody(Function function, InstructionBlock ib);
	abstract protected void handleInstructionBlockAddInstruction(InstructionBlock ib, Instruction addedInstruction, int position);
}
