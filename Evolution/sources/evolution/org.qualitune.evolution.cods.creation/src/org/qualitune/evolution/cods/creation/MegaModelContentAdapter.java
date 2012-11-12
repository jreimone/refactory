/**
 * 
 */
package org.qualitune.evolution.cods.creation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;

/**
 * @author jreimann
 *
 */
public class MegaModelContentAdapter extends org.eclipse.emf.ecore.util.EContentAdapter implements MegaModelChangeSubject {

	private Map<Integer, Set<MegaModelChangeObserver>> observerMap;
	
	public MegaModelContentAdapter(){
		observerMap = new HashMap<Integer, Set<MegaModelChangeObserver>>();
	}
	
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
		Object newValue = n.getNewValue();
		int eventType = n.getEventType();
		switch (eventType) {
		case Notification.ADD:
			Set<MegaModelChangeObserver> addObservers = observerMap.get(eventType);
			for (MegaModelChangeObserver megaModelChangeObserver : addObservers) {
				megaModelChangeObserver.megaModelChanged();
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void registerObserver(MegaModelChangeObserver observer, int kind) {
		if(observer != null){
			Set<MegaModelChangeObserver> kindObservers = observerMap.get(kind);
			if(kindObservers == null){
				kindObservers = new HashSet<MegaModelChangeObserver>();
				observerMap.put(kind, kindObservers);
			}
		}
	}
}
