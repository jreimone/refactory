/**
 * 
 */
package org.qualitune.evolution.cods.creation;

import org.eclipse.emf.common.notify.Notification;

/**
 * @author jreimann
 *
 */
public class MegaModelContentAdapter extends org.eclipse.emf.ecore.util.EContentAdapter {

	public void notifyChanged(Notification n){
		super.notifyChanged(n); // the superclass handles adding/removing this Adapter to new elements
		Object notifier = n.getNotifier();
		Object feature = n.getFeature();
//		Notification.CREATE = 0
//		Notification.SET = 1
//		Notification.UNSET = 2
//		Notification.ADD = 3
//		Notification.REMOVE = 4
//      Notification.ADD_MANY = 5
//		Notification.REMOVE_MANY = 6
//		Notification.MOVE = 7
//		Notification.REMOVING_ADAPTER = 8
//		Notification.RESOLVE = 9
		int eventType = n.getEventType();
		System.out.println();
	}
}
