/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.debug;

public interface IXwpfDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(dk.itu.sdg.language.xwpf.resource.xwpf.debug.XwpfDebugMessage message);
}
