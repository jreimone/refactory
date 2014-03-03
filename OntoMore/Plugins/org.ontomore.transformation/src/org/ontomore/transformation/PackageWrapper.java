package org.ontomore.transformation;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

public class PackageWrapper {

	private EPackage ePackage;

	public PackageWrapper(String name) {
		this.ePackage = EcoreFactory.eINSTANCE.createEPackage();
		setName(name);
	}

	private void setName(String name) {
		String shortName = getShortName(name);
		ePackage.setName(shortName);
		ePackage.setNsPrefix(shortName);
		ePackage.setNsURI(name);
	}

	/**
	 * Provides a short form of the given URI
	 * 
	 * @return The substring of the URI behind the last "/" without
	 *         extension.
	 */
	private String getShortName(String name) {
		String[] uriParts = name.split("/");
		String uriLastPart = uriParts[uriParts.length - 1];
		int endPos = uriLastPart.indexOf(".");
		if (endPos <= 0) {
			endPos = uriLastPart.length();
		}
		String shortName = uriLastPart.substring(0, endPos);
		return shortName;
	}

	public EPackage getInternalElement() {
		return ePackage;
	}
	
	public void addClassifier(EClassifier classifier) {
		ePackage.getEClassifiers().add(classifier);
	}
	
	public EClassifier getClassifier(String name) {
		return ePackage.getEClassifier(name);
	}

	public EFactory getFactory() {
		return ePackage.getEFactoryInstance();
	}

}
