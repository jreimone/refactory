package org.emftext.refactoring.smell.registry;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ModificationListener extends EContentAdapter {

	private Resource resource;

	public ModificationListener(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void notifyChanged(Notification notification) {
//		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if(notifier instanceof EObject){
			try {
//				Object feature = notification.getFeature();
				if(resource != null){
//					if(feature != null && !feature.equals(SmellPackage.Literals.QUALITY__CALCULATIONS)){
//						resource.save(Collections.EMPTY_MAP);
//					}
//					if(feature == null){
//						resource.save(Collections.EMPTY_MAP);
//					}
					EObject model = EcoreUtil.getRootContainer((EObject) notifier);
					if(model == null){
						model = (EObject) notifier;
					}
					boolean allElementsHaveContainers = true;
					TreeIterator<EObject> iterator = model.eAllContents();
					while (iterator.hasNext()) {
						EObject element = (EObject) iterator.next();
						if(element.eContainer() == null){
							allElementsHaveContainers = false;
						} else if(element.eContainer().eResource() == null){
							allElementsHaveContainers = false;
						}
					}
					if(allElementsHaveContainers){
						resource.save(Collections.EMPTY_MAP);
					}
				}
			} catch (IOException e) {
//				e.printStackTrace();
			}
		} else {
			System.err.println("Notifier is not an EObject: " + notifier);
		}
	}

}
