/**
 * 
 */
package org.qualitune.evolution.cods.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.wb.swt.SWTResourceManager;
import org.qualitune.evolution.megamodel.architecture.InstanceModel;
import org.qualitune.evolution.megamodel.architecture.MegaModel;
import org.qualitune.evolution.megamodel.architecture.MetaMetaModel;
import org.qualitune.evolution.megamodel.architecture.MetaModel;
import org.qualitune.evolution.megamodel.architecture.ReferenceModel;
import org.qualitune.evolution.megamodel.architecture.TransformationModel;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

/**
 * @author jreimann
 *
 */
@SuppressWarnings("restriction")
public class CODSView {
	public static class ViewerLabelProvider extends LabelProvider {
		public ViewerLabelProvider(){
			
		}
		
		public Image getImage(Object element) {
			return super.getImage(element);
		}
		public String getText(Object element) {
			if(element instanceof InstanceModel){
				EObject model = ((InstanceModel) element).getModel();
				URI uri = EcoreUtil.getURI(model);
				return uri.toString();
			}
			return super.getText(element);
		}
	}
	
	@Inject
	private MegaModel megamodel;
	private MetaMetaModel metaMetaModel;
	private List<MetaModel> metaModels;
	private List<InstanceModel> instanceModels;
	private List<TransformationModel> transformationModels;
	
	private Composite composite;
	private ExpandBar expandBarModels;
	private ExpandItem expandItemMetametamodels;
	private ExpandItem expandItemMetamodels;
	private ExpandItem expandItemTerminalModels;
	private ExpandItem expandItemReferenceModels;
	private ExpandBar expandBarReferenceModels;
	private ExpandItem expandItemInstanceModels;
	private ExpandBar expandBarTerminalModels;
	private ExpandItem expandItemTransformationModels;
	private TreeColumn treeColumnLocation;
	private Tree treeInstanceModels;
	private TreeViewer treeViewerInstanceModels;
	private Composite compositeInstanceModelsTree;

	public CODSView() {
		megamodel.eAdapters().add(new EContentAdapter(){
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				initModels();
			}
		});
		initModels();
	}

	private void initModels() {
		metaMetaModel = megamodel.getMetaMetaModel();
		metaModels = megamodel.getMetaModels();
		instanceModels = megamodel.getInstanceModels();
		transformationModels = megamodel.getTransformationModels();
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		expandBarModels = new ExpandBar(composite, SWT.NONE);
		expandBarModels.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		
		expandItemReferenceModels = new ExpandItem(expandBarModels, SWT.NONE);
		expandItemReferenceModels.setText("Reference Models");
		
		expandBarReferenceModels = new ExpandBar(expandBarModels, SWT.NONE);
		expandBarReferenceModels.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		expandItemReferenceModels.setControl(expandBarReferenceModels);
		expandItemReferenceModels.setHeight(expandItemReferenceModels.getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		
		expandItemMetametamodels = new ExpandItem(expandBarReferenceModels, SWT.NONE);
		expandItemMetametamodels.setText("Meta-Metamodels");
		
		expandItemMetamodels = new ExpandItem(expandBarReferenceModels, SWT.NONE);
		expandItemMetamodels.setText("Metamodels");
		
		expandItemTerminalModels = new ExpandItem(expandBarModels, SWT.NONE);
		expandItemTerminalModels.setExpanded(true);
		expandItemTerminalModels.setText("Terminal Models");
		
		expandBarTerminalModels = new ExpandBar(expandBarModels, SWT.NONE);
		expandBarTerminalModels.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
		expandItemTerminalModels.setControl(expandBarTerminalModels);
		expandItemTerminalModels.setHeight(expandItemTerminalModels.getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		
		expandItemInstanceModels = new ExpandItem(expandBarTerminalModels, SWT.NONE);
		expandItemInstanceModels.setExpanded(true);
		expandItemInstanceModels.setText("Instance Models");
		
		compositeInstanceModelsTree = new Composite(expandBarTerminalModels, SWT.NONE);
		expandItemInstanceModels.setControl(compositeInstanceModelsTree);
		compositeInstanceModelsTree.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		treeViewerInstanceModels = new TreeViewer(compositeInstanceModelsTree, SWT.BORDER);
		treeInstanceModels = treeViewerInstanceModels.getTree();
		treeInstanceModels.setLinesVisible(true);
		treeInstanceModels.setHeaderVisible(true);
		
		treeColumnLocation = new TreeColumn(treeInstanceModels, SWT.NONE);
		treeColumnLocation.setWidth(300);
		treeColumnLocation.setText("Location");
		treeViewerInstanceModels.setLabelProvider(new ViewerLabelProvider());
		expandItemInstanceModels.setHeight(expandItemInstanceModels.getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		
		expandItemTransformationModels = new ExpandItem(expandBarTerminalModels, SWT.NONE);
		expandItemTransformationModels.setText("Transformation Models");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}
}
