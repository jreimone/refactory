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
	
	private final boolean isInternal;

	public EClassVertex(EClass eclass, boolean isInternal) {
		super(eclass);
		this.eclass = eclass;
		this.isInternal = isInternal;
	}

	public EClass getEClass() {
		return eclass;
	}

	public boolean isInternal() {
		return isInternal;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue("EClass: " + eclass.getName())
				.addValue(hashCode())
				.toString();
	}

}
