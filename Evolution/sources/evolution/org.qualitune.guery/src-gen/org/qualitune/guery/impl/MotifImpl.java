/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.qualitune.guery.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.qualitune.guery.EdgeSelection;
import org.qualitune.guery.Grouping;
import org.qualitune.guery.GueryPackage;
import org.qualitune.guery.Motif;
import org.qualitune.guery.PreProcessor;
import org.qualitune.guery.VertexSelection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motif</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.qualitune.guery.impl.MotifImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.qualitune.guery.impl.MotifImpl#getVertexSelection <em>Vertex Selection</em>}</li>
 *   <li>{@link org.qualitune.guery.impl.MotifImpl#getGroupBy <em>Group By</em>}</li>
 *   <li>{@link org.qualitune.guery.impl.MotifImpl#getPrepare <em>Prepare</em>}</li>
 *   <li>{@link org.qualitune.guery.impl.MotifImpl#getEdgeSelections <em>Edge Selections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotifImpl extends EObjectImpl implements Motif {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVertexSelection() <em>Vertex Selection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexSelection()
	 * @generated
	 * @ordered
	 */
	protected VertexSelection vertexSelection;

	/**
	 * The cached value of the '{@link #getGroupBy() <em>Group By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Grouping> groupBy;

	/**
	 * The cached value of the '{@link #getPrepare() <em>Prepare</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrepare()
	 * @generated
	 * @ordered
	 */
	protected EList<PreProcessor> prepare;

	/**
	 * The cached value of the '{@link #getEdgeSelections() <em>Edge Selections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeSelections()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeSelection> edgeSelections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotifImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GueryPackage.Literals.MOTIF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GueryPackage.MOTIF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VertexSelection getVertexSelection() {
		return vertexSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertexSelection(VertexSelection newVertexSelection, NotificationChain msgs) {
		VertexSelection oldVertexSelection = vertexSelection;
		vertexSelection = newVertexSelection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GueryPackage.MOTIF__VERTEX_SELECTION, oldVertexSelection, newVertexSelection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertexSelection(VertexSelection newVertexSelection) {
		if (newVertexSelection != vertexSelection) {
			NotificationChain msgs = null;
			if (vertexSelection != null)
				msgs = ((InternalEObject)vertexSelection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GueryPackage.MOTIF__VERTEX_SELECTION, null, msgs);
			if (newVertexSelection != null)
				msgs = ((InternalEObject)newVertexSelection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GueryPackage.MOTIF__VERTEX_SELECTION, null, msgs);
			msgs = basicSetVertexSelection(newVertexSelection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GueryPackage.MOTIF__VERTEX_SELECTION, newVertexSelection, newVertexSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Grouping> getGroupBy() {
		if (groupBy == null) {
			groupBy = new EObjectContainmentEList<Grouping>(Grouping.class, this, GueryPackage.MOTIF__GROUP_BY);
		}
		return groupBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PreProcessor> getPrepare() {
		if (prepare == null) {
			prepare = new EObjectContainmentEList<PreProcessor>(PreProcessor.class, this, GueryPackage.MOTIF__PREPARE);
		}
		return prepare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgeSelection> getEdgeSelections() {
		if (edgeSelections == null) {
			edgeSelections = new EObjectContainmentEList<EdgeSelection>(EdgeSelection.class, this, GueryPackage.MOTIF__EDGE_SELECTIONS);
		}
		return edgeSelections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GueryPackage.MOTIF__VERTEX_SELECTION:
				return basicSetVertexSelection(null, msgs);
			case GueryPackage.MOTIF__GROUP_BY:
				return ((InternalEList<?>)getGroupBy()).basicRemove(otherEnd, msgs);
			case GueryPackage.MOTIF__PREPARE:
				return ((InternalEList<?>)getPrepare()).basicRemove(otherEnd, msgs);
			case GueryPackage.MOTIF__EDGE_SELECTIONS:
				return ((InternalEList<?>)getEdgeSelections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GueryPackage.MOTIF__NAME:
				return getName();
			case GueryPackage.MOTIF__VERTEX_SELECTION:
				return getVertexSelection();
			case GueryPackage.MOTIF__GROUP_BY:
				return getGroupBy();
			case GueryPackage.MOTIF__PREPARE:
				return getPrepare();
			case GueryPackage.MOTIF__EDGE_SELECTIONS:
				return getEdgeSelections();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GueryPackage.MOTIF__NAME:
				setName((String)newValue);
				return;
			case GueryPackage.MOTIF__VERTEX_SELECTION:
				setVertexSelection((VertexSelection)newValue);
				return;
			case GueryPackage.MOTIF__GROUP_BY:
				getGroupBy().clear();
				getGroupBy().addAll((Collection<? extends Grouping>)newValue);
				return;
			case GueryPackage.MOTIF__PREPARE:
				getPrepare().clear();
				getPrepare().addAll((Collection<? extends PreProcessor>)newValue);
				return;
			case GueryPackage.MOTIF__EDGE_SELECTIONS:
				getEdgeSelections().clear();
				getEdgeSelections().addAll((Collection<? extends EdgeSelection>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GueryPackage.MOTIF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GueryPackage.MOTIF__VERTEX_SELECTION:
				setVertexSelection((VertexSelection)null);
				return;
			case GueryPackage.MOTIF__GROUP_BY:
				getGroupBy().clear();
				return;
			case GueryPackage.MOTIF__PREPARE:
				getPrepare().clear();
				return;
			case GueryPackage.MOTIF__EDGE_SELECTIONS:
				getEdgeSelections().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GueryPackage.MOTIF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GueryPackage.MOTIF__VERTEX_SELECTION:
				return vertexSelection != null;
			case GueryPackage.MOTIF__GROUP_BY:
				return groupBy != null && !groupBy.isEmpty();
			case GueryPackage.MOTIF__PREPARE:
				return prepare != null && !prepare.isEmpty();
			case GueryPackage.MOTIF__EDGE_SELECTIONS:
				return edgeSelections != null && !edgeSelections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MotifImpl
