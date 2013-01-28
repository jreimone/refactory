package org.emftext.refactoring.smell.ui.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.emftext.refactoring.smell.QualitySmellModel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.emftext.refactoring.smell.QualitySmell;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.refactoring.smell.SmellPackage.Literals;
import org.eclipse.core.databinding.observable.Realm;

@SuppressWarnings("restriction")
public class GenericSmellView {
	private DataBindingContext m_bindingContext;

	@Inject
	private QualitySmellModel smellModel;
	
	private Table tableSmells;
	private TableViewer tableViewerSmells;
	
	public GenericSmellView() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		
		tableViewerSmells = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableSmells = tableViewerSmells.getTable();
		tableSmells.setLinesVisible(true);
		tableSmells.setHeaderVisible(true);
		tableSmells.setSize(64, 24);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewerSmells, SWT.NONE);
		TableColumn tblclmnGenericSmellName = tableViewerColumn.getColumn();
		tblclmnGenericSmellName.setWidth(400);
		tblclmnGenericSmellName.setText("Generic Smell");
		m_bindingContext = initDataBindings();
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.QUALITY_SMELL__NAME});
		tableViewerSmells.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewerSmells.setContentProvider(listContentProvider);
		//
		IObservableList smellModelSmellsObserveList = EMFObservables.observeList(Realm.getDefault(), smellModel, Literals.QUALITY_SMELL_MODEL__SMELLS);
		tableViewerSmells.setInput(smellModelSmellsObserveList);
		//
		return bindingContext;
	}
}
