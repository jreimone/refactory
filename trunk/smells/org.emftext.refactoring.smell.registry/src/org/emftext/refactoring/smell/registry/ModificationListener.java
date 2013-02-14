package org.emftext.refactoring.smell.registry;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.emftext.refactoring.smell.SmellPackage;

public class ModificationListener extends EContentAdapter {

	private Resource resource;

	public ModificationListener(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if(notifier instanceof EObject){
			try {
				if(resource != null && !notification.getFeature().equals(SmellPackage.Literals.QUALITY__CALCULATIONS)){
					resource.save(Collections.EMPTY_MAP);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Notifier is not an EObject: " + notifier);
		}
	}

}
