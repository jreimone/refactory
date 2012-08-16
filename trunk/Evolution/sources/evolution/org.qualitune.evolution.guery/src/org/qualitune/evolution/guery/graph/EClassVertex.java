/**
 * 
 */
package org.qualitune.evolution.guery.graph;

import org.eclipse.emf.ecore.EClass;

import com.google.common.base.Objects;

/**
 * @author jreimann
 *
 */
public class EClassVertex extends MetamodelVertex {

	private static final long serialVersionUID = -884056766024131382L;

	private final EClass eclass;

	public EClassVertex(EClass eclass) {
		super(eclass);
		this.eclass = eclass;
	}

	public EClass getEClass() {
		return eclass;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue("EClass: " + eclass.getName())
				.addValue(hashCode())
				.toString();
	}
}
