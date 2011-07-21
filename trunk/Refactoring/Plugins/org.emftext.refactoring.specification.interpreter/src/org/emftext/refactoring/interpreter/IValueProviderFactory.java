package org.emftext.refactoring.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * This factory interface is used to provide concrete {@link IValueProvider}s. They might
 * be different when running in a dedicated Eclipse instance or as JUnit tests. 
 * 
 * @author jreimann
 *
 */
public interface IValueProviderFactory {

	/**
	 * Returns the appropriate {@link IValueProvider} for the given command
	 * or creates a new one if none was created for the given command yet.
	 * 
	 * @param command
	 * @param context some arbitrary context objects which can be analysed in this factory
	 * @return
	 */
	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context);
	
	/**
	 * Registers another <code>valueProvider</code> for the given <code>command</code>.
	 * @param command
	 * @param valueProvider
	 */
	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider);
	
	/**
	 * Registers a new value provider for the given <code>command</code>.
	 * @param command
	 */
	public void registerValueProviderForCommand(EObject command);
	
	/**
	 * Returns all collected {@link IValueProvider}s. Implementors should check
	 * if the values are really providable in terms of being contained in the
	 * original model.
	 * 
	 * @return
	 */
	public List<IValueProvider<?, ?>> getValuesToProvide();
}
