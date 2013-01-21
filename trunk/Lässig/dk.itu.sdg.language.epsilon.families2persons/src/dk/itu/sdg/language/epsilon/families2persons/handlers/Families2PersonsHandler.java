package dk.itu.sdg.language.epsilon.families2persons.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import dk.itu.sdg.language.epsilon.families2persons.Families2PersonsWF;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class Families2PersonsHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public Families2PersonsHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Families2PersonsWF.run();
		return null;
	}
}
