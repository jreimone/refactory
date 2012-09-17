/**
 * 
 */
package org.qualitune.ecore.graph.impl;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections15.map.HashedMap;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.qualitune.ecore.graph.GObject;

/**
 * @author jreimann
 *
 */
public class EObjectContainmentEListGraph<Type extends GObject> extends EObjectContainmentEList<Type> {

	private static final long serialVersionUID = 1957809370350201461L;
	private GObject owner;
	private EReference reference;
	private Map<GObject, GReference> targetEdgeMap;

	public EObjectContainmentEListGraph(Class<?> dataClass, InternalEObject owner, int featureID, EReference reference) {
		super(dataClass, owner, featureID);
		this.owner = (GObject) owner;
		this.reference = reference;
		targetEdgeMap = new HashedMap<GObject, GReference>();
	}

	@Override
	public boolean add(Type object) {
		boolean result = super.add(object);
		if(result){
			GReference edge = new GReference(owner, object, reference);
			addInternal(object, edge);
		}
		return result;
	}

	@Override
	public void add(int index, Type object) {
		super.add(index, object);
		GReference edge = new GReference(owner, object, reference);
		addInternal(object, edge);
	}

	private void addInternal(Type object, GReference edge) {
		owner.getEdges().add(edge);
		owner.gGetOutEdges().add(edge);
		object.gGetInEdges().add(edge);
		if(owner.gGraph() != null){
			owner.gGraph().getEdges().add(edge);
			// must be done for adding pending edges from child elements
			owner.gGraph().getEdges().addAll(object.getEdges());
		}
		targetEdgeMap.put(object, edge);
	}

	@Override
	public boolean addAll(Collection<? extends Type> collection) {
		boolean result = super.addAll(collection);
		if(result){
			for (Type type : collection) {
				GReference edge = new GReference(owner, type, reference);
				addInternal(type, edge);
			}
		}
		return result;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Type> collection) {
		boolean result = super.addAll(index, collection);
		if(result){
			for (Type type : collection) {
				GReference edge = new GReference(owner, type, reference);
				addInternal(type, edge);
			}
		}
		return result;
	}


	@Override
	public void addUnique(Type object) {
		int addedElements = size();
		super.addUnique(object);
		addedElements = size() - addedElements; 
		if(addedElements > 0){
			GReference edge = new GReference(owner, object, reference);
			addInternal(object, edge);
		}
	}

	@Override
	public void addUnique(int index, Type object) {
		int addedElements = size();
		super.addUnique(index, object);
		addedElements = size() - addedElements; 
		if(addedElements > 0){
			GReference edge = new GReference(owner, object, reference);
			addInternal(object, edge);
		}
	}
	
	@Override
	public boolean remove(Object object) {
		boolean result = super.remove(object);
		if(result){
			GObject element = (GObject) object;
			GReference edge = targetEdgeMap.get(element);
			GObject start = edge.getStart();
			GObject end = edge.getEnd();
			start.gGetOutEdges().remove(edge);
			end.gGetInEdges().remove(edge);
			if(element.gGraph() != null){
				element.gGraph().getVertices().remove(element);
			}
			targetEdgeMap.remove(element);
		}
		return result;
	}

	@Override
	public Type remove(int index) {
		// TODO Auto-generated method stub
		return super.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		// TODO Auto-generated method stub
		return super.removeAll(collection);
	}

	@Override
	public NotificationChain basicRemove(Object object, NotificationChain notifications) {
		// TODO Auto-generated method stub
		return super.basicRemove(object, notifications);
	}

}
