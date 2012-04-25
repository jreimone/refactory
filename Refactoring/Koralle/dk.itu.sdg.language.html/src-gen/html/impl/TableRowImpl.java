/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html.impl;

import html.HtmlPackage;
import html.TableCell;
import html.TableRow;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Row</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link html.impl.TableRowImpl#getTableCells <em>Table Cells</em>}</li>
 *   <li>{@link html.impl.TableRowImpl#getTableRows <em>Table Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableRowImpl extends TagImpl implements TableRow {
	/**
	 * The cached value of the '{@link #getTableCells() <em>Table Cells</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableCells()
	 * @generated
	 * @ordered
	 */
	protected EList<TableCell> tableCells;

	/**
	 * The cached value of the '{@link #getTableRows() <em>Table Rows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableRows()
	 * @generated
	 * @ordered
	 */
	protected EList<TableRow> tableRows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableRowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.TABLE_ROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TableCell> getTableCells() {
		if (tableCells == null) {
			tableCells = new EObjectContainmentEList<TableCell>(TableCell.class, this, HtmlPackage.TABLE_ROW__TABLE_CELLS);
		}
		return tableCells;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TableRow> getTableRows() {
		if (tableRows == null) {
			tableRows = new EObjectContainmentEList<TableRow>(TableRow.class, this, HtmlPackage.TABLE_ROW__TABLE_ROWS);
		}
		return tableRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.TABLE_ROW__TABLE_CELLS:
				return ((InternalEList<?>)getTableCells()).basicRemove(otherEnd, msgs);
			case HtmlPackage.TABLE_ROW__TABLE_ROWS:
				return ((InternalEList<?>)getTableRows()).basicRemove(otherEnd, msgs);
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
			case HtmlPackage.TABLE_ROW__TABLE_CELLS:
				return getTableCells();
			case HtmlPackage.TABLE_ROW__TABLE_ROWS:
				return getTableRows();
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
			case HtmlPackage.TABLE_ROW__TABLE_CELLS:
				getTableCells().clear();
				getTableCells().addAll((Collection<? extends TableCell>)newValue);
				return;
			case HtmlPackage.TABLE_ROW__TABLE_ROWS:
				getTableRows().clear();
				getTableRows().addAll((Collection<? extends TableRow>)newValue);
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
			case HtmlPackage.TABLE_ROW__TABLE_CELLS:
				getTableCells().clear();
				return;
			case HtmlPackage.TABLE_ROW__TABLE_ROWS:
				getTableRows().clear();
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
			case HtmlPackage.TABLE_ROW__TABLE_CELLS:
				return tableCells != null && !tableCells.isEmpty();
			case HtmlPackage.TABLE_ROW__TABLE_ROWS:
				return tableRows != null && !tableRows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableRowImpl
