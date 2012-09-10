/**
 * 
 */
package org.qualitune.ecore.graph.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;

/**
 * @author jreimann
 *
 */
public class SynchronousMapList<EReferenceEdgeType extends GReference> extends LinkedList<EReferenceEdgeType> {

	private static final long serialVersionUID = -4660950933210964198L;
	
	
	private Map<EReference, Set<EReferenceEdgeType>> elementMap;
	
	public SynchronousMapList(){
		super();
		this.elementMap = new HashMap<EReference, Set<EReferenceEdgeType>>();
	}

	@Override
	public EReferenceEdgeType removeFirst() {
		EReferenceEdgeType first = super.removeFirst();
		removeInternal(first);
		return first;
	}

	@Override
	public EReferenceEdgeType removeLast() {
		EReferenceEdgeType last = super.removeLast();
		removeInternal(last);
		return last;
	}

	@Override
	public void addFirst(EReferenceEdgeType e) {
		super.addFirst(e);
		addInternal(e);
	}

	private void addInternal(EReferenceEdgeType e) {
		EReference reference = e.getReference();
		Set<EReferenceEdgeType> values = elementMap.get(reference);
		if(values == null){
			values = new LinkedHashSet<EReferenceEdgeType>();
			elementMap.put(reference, values);
		}
		values.add(e);
	}

	@Override
	public void addLast(EReferenceEdgeType e) {
		super.addLast(e);
		addInternal(e);
	}

	@Override
	public boolean add(EReferenceEdgeType e) {
		boolean result = super.add(e);
		if(result){
			addInternal(e);
		}
		return result; 
	}

	@Override
	public boolean remove(Object o) {
		boolean result = super.remove(o);
		if(result){
			@SuppressWarnings("unchecked")
			EReferenceEdgeType element = (EReferenceEdgeType) o;
			removeInternal(element);
		}
		return result;
	}

	private void removeInternal(EReferenceEdgeType element) {
		EReference reference = element.getReference();
		elementMap.remove(reference);
	}

	@Override
	public boolean addAll(Collection<? extends EReferenceEdgeType> c) {
		boolean result = super.addAll(c);
		if(result){
			for (EReferenceEdgeType element : c) {
				removeInternal(element);
			}
		}
		return result;
	}

	@Override
	public boolean addAll(int index, Collection<? extends EReferenceEdgeType> c) {
		boolean result = super.addAll(index, c);
		if(result){
			for (EReferenceEdgeType element : c) {
				removeInternal(element);
			}
		}
		return result;
	}

	@Override
	public EReferenceEdgeType set(int index, EReferenceEdgeType element) {
		EReferenceEdgeType former = super.set(index, element);
		elementMap.remove(former);
		addInternal(element);
		return former;
	}

	@Override
	public void add(int index, EReferenceEdgeType element) {
		super.add(index, element);
		addInternal(element);
	}

	@Override
	public EReferenceEdgeType remove(int index) {
		EReferenceEdgeType old = super.remove(index);
		removeInternal(old);
		return old;
	}

	@Override
	public EReferenceEdgeType remove() {
		EReferenceEdgeType head = super.remove();
		removeInternal(head);
		return head;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeFirstOccurrence(Object o) {
		boolean result = super.removeFirstOccurrence(o);
		if(result){
			removeInternal((EReferenceEdgeType) o);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeLastOccurrence(Object o) {
		boolean result = super.removeLastOccurrence(o);
		if(result){
			removeInternal((EReferenceEdgeType) o);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result = super.removeAll(c);
		if(result){
			for (Object value : c) {
				removeInternal((EReferenceEdgeType) value);
			}
		}
		return result;
	}

	public Map<EReference, Set<EReferenceEdgeType>> getElementMap() {
		return elementMap;
	}

	
}
