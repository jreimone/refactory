/**
 * 
 */
package org.qualitune.tracing.atl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.qualitune.tracing.atl.ATL.Module;

/**
 * 
 * That's a Depth First Search tree iterator for code sections of ATL programs.
 * 
 * @author Fabian Haensel <fabian.haensel@gmx.de>
 *
 */
public class AtlTreeIterator extends AbstractTreeIterator<EObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1016062957631947752L;

	/**
	 * @param object
	 */
	public AtlTreeIterator(EObject module) {
		super(module);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.util.AbstractTreeIterator#getChildren(java.lang.Object)
	 * 
	 * Copying collections beforehand makes this iterator stable.
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Iterator getChildren(Object atlObject) {
		if (atlObject instanceof Module) {
			LinkedList<EObject> elements = new LinkedList<EObject>();
			Module module = (Module) atlObject;
			elements.addAll( (Collection<? extends EObject>) module.getElements() );
			return elements.iterator();
		} else 
			return ECollections.EMPTY_ELIST.iterator() ;
	}

}
