package org.modelrefactoring.guery.custom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.guery.Connection;
import org.modelrefactoring.guery.Constrainable;
import org.modelrefactoring.guery.EdgeSelection;
import org.modelrefactoring.guery.Role;
import org.modelrefactoring.guery.VertexSelection;
import org.modelrefactoring.guery.impl.MotifImpl;


public class MotifCustom extends MotifImpl {

	/**
	 * @model
	 */
	public EList<Constrainable> getConstrainables() {
		EList<Constrainable> constrainables = new BasicEList<Constrainable>();
		constrainables.addAll(this.getGroupBy());
		constrainables.addAll(this.getEdgeSelections());
		constrainables.add(this.getVertexSelection());
		return constrainables;
	}

	@Override
	public EMap<String, EObject> getContexts() {
		EMap<String, EObject> context = new BasicEMap<String, EObject>();
		VertexSelection selection = this.getVertexSelection();
		for (Role role : selection.getRoles()) {
			context.put(role.getName(), role);
		}
		for (EdgeSelection edgeSelection : this.getEdgeSelections()) {
			for (Connection	connection : edgeSelection.getConnections()) {
				context.put(connection.getPath(), connection);
			}
		}
		return context;
	}

	
	
}
