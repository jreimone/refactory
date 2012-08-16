/**
 * 
 */
package org.qualitune.evolution.guery.graph;

import org.eclipse.emf.ecore.EPackage;

import com.google.common.base.Objects;

/**
 * @author jreimann
 *
 */
public class EPackageVertex extends MetamodelVertex {

	private EPackage epackage;

	/**
	 * @param modelElement
	 */
	public EPackageVertex(EPackage epackage) {
		super(epackage);
		this.epackage = epackage;
	}

	private static final long serialVersionUID = -640198567556835833L;

	/**
	 * @return the epackage
	 */
	public EPackage getPackage() {
		return epackage;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue("EPackage: " + epackage.getName())
				.addValue(hashCode())
				.toString();
	}
}
