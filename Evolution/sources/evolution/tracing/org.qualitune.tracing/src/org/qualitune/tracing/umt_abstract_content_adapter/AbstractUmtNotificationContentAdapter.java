/**
 * 
 */
package org.qualitune.tracing.umt_abstract_content_adapter;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.qualitune.tracing.umt.Function;
import org.qualitune.tracing.umt.InstructionBlock;
import org.qualitune.tracing.umt.Program;

/**
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 * This one forces you to implement reactions to notifications,
 * input you get is a notification.
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
abstract public class AbstractUmtNotificationContentAdapter extends EContentAdapter {

	protected Logger logger;
	
	public AbstractUmtNotificationContentAdapter() {
		logger = Logger.getLogger(AbstractUmtNotificationContentAdapter.class);
	}
	
	/*
	 * General infrastructure
	 */
	protected void warningUnknown()
	{
		logger.warn("something unknown has changed");	
	}
	
	protected void warningUnknownFeature(Notification n)
	{
		logger.warn("unhandled change to feature of UMT element of type " +
				n.getNotifier().getClass().getName() + " (unknown feature)");
	}
	
	protected void warningUnknownType(Notification n)
	{
		logger.warn("unhandled change to UMT element of type " + 
				n.getNotifier().getClass().getName() + " (unknown type)");
		
	}
	
	protected void warningUnknownEventType(Notification n)
	{
		logger.warn("unhandled change to feature of UMT element of type " +
				n.getNotifier().getClass().getName() + " (unknown event type " + n.getEventType() + ")");
	}
	
	// start observing a Program model
	public void observeProgram(Program program){
		program.eAdapters().add(this);
		System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXxxx");
		new Throwable().printStackTrace();
	}
	
	/*
	 * Notification processing
	 */
	
	//override the notifyChanged method
	public void notifyChanged(Notification n){
		super.notifyChanged(n);

		Object notifier = n.getNotifier();

		/* long list of handleSomething(Notification n), each handleSomething(Notification n)
		 * has an abstract declaration in this class
		 * 
		 * we might make this a map someday
		 */
		if (notifier instanceof Program) {
			handleProgramNotification(n);
		} else if (notifier instanceof Function) {
			handleFunctionNotification(n);
		} else if (notifier instanceof InstructionBlock) {
			handleInstructionBlockNotification(n);
		} else  {
			warningUnknownType(n);
		}
	}

	/**
	 * concrete reactions to changes are abstract.
	 * reacts to additions of new elements to instruction blocks
	 * (feature instructions)
	 * @param n noti
	 */
	abstract protected void handleProgramNotification(Notification n);
	abstract protected void handleInstructionBlockNotification(Notification n);
	abstract protected void handleFunctionNotification(Notification n);
}
