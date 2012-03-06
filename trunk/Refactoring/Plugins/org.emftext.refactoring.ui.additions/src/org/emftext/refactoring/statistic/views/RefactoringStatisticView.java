package org.emftext.refactoring.statistic.views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.StringUtil;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class RefactoringStatisticView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.emftext.refactoring.statistic.views.RefactoringStatisticView";
	private static final String EVEN_COLOR = "#D3D3D3";
	private static final String ZOO_PREFIX = "EMFText_Concrete_Syntax_Zoo_";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action refactoringDocGenAction;
	private Action complexLatexTableGenAction;
	private Action complexWikiTableGenAction;
	private Action simpleLatexTableGenAction;
	private Action doubleClickAction;
	private ViewContentProvider contentProvider;

	private AdapterFactoryLabelProvider labelProvider;

	abstract class TreeObject implements IAdaptable {

		private EObject object;
		private TreeParent parent;

		public TreeObject(EObject object) {
			this.object = object;
		}

		public void setParent(TreeParent parent) {
			this.parent = parent;
		}

		public TreeParent getParent() {
			return parent;
		}

		@SuppressWarnings("rawtypes")
		public Object getAdapter(Class key) {
			return null;
		}

		public EObject getObject() {
			return object;
		}
	}

	class TreeLeaf extends TreeObject {

		private RoleMapping mapping;

		public TreeLeaf(RoleMapping object) {
			super(object);
			this.mapping = object;
		}

		public boolean hasPostProcessorRegistered() {
			IRefactoringPostProcessor postProcessor = IRoleMappingRegistry.INSTANCE.getPostProcessor(mapping);
			if (postProcessor != null) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return mapping.getName();
		}
	}

	class TreeParent extends TreeObject {

		private List<TreeObject> children;

		public TreeParent(EObject object) {
			super(object);
			children = new ArrayList<TreeObject>();
		}

		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}

		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}

		public TreeObject[] getChildren() {
			return (TreeObject[]) children.toArray(new TreeObject[children.size()]);
		}

		public boolean hasChildren() {
			return children.size() > 0;
		}

		@Override
		public String toString() {
			if (getObject() instanceof RoleModel) {
				return ((RoleModel) getObject()).getName();
			}
			return super.toString();
		}
	}

	class TreeMetaModelParent extends TreeParent {

		private EPackage metamodel;

		public TreeMetaModelParent(EPackage metamodel) {
			super(metamodel);
			this.metamodel = metamodel;
		}

		public EPackage getMetamodel() {
			return metamodel;
		}

		public int getCountMetaclasses() {
			return countMetaclasses(getMetamodel());
		}

		public int getCountStructuralFeatures() {
			return countStructuralFeatures(getMetamodel());
		}

		public double getCountStructuralFeaturesPerMetaclass() {
			return new Integer(getCountStructuralFeatures()).doubleValue() / new Integer(
					getCountMetaclasses()).doubleValue();
		}

		private int countMetaclasses(EPackage epackage) {
			int count = 0;
			if (epackage.getEClassifiers() != null) {
				for (EClassifier classifier : epackage.getEClassifiers()) {
					if (classifier instanceof EClass) {
						count++;
					}
				}
			}
			for (EPackage subPackage : epackage.getESubpackages()) {
				count += countMetaclasses(subPackage);
			}
			return count;
		}

		private int countStructuralFeatures(EPackage epackage) {
			int count = 0;
			if (epackage.getEClassifiers() != null) {
				for (EClassifier classifier : epackage.getEClassifiers()) {
					if (classifier instanceof EClass) {
						count += ((EClass) classifier).getEStructuralFeatures().size();
						// count += ((EClass)
						// classifier).getEReferences().size();
					}
				}
			}
			for (EPackage subPackage : epackage.getESubpackages()) {
				count += countStructuralFeatures(subPackage);
			}
			return count;
		}

		@Override
		public String toString() {
			return metamodel.getNsURI();
		}
	}

	class ViewContentProvider implements IStructuredContentProvider,
			ITreeContentProvider {

		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot == null) {
					invisibleRoot = initialize();
				}
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject) child).getParent();
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent) parent).getChildren();
			}
			return new Object[0];
		}

		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent) parent).hasChildren();
			return false;
		}

		private TreeParent initialize() {
			TreeParent invisibleRoot = new TreeParent(null);
			Collection<RoleModel> roleModels = IRoleModelRegistry.INSTANCE.getAllRegisteredRoleModels();
			Map<String, Map<String, RoleMapping>> nsUriMappingsMap = IRoleMappingRegistry.INSTANCE.getRoleMappingsMap();
			Map<RoleModel, Map<EPackage, List<RoleMapping>>> roleModelMetamodelMappingsMap = new LinkedHashMap<RoleModel, Map<EPackage, List<RoleMapping>>>();
			for (String nsUriString : nsUriMappingsMap.keySet()) {
				Map<String, RoleMapping> mappingNameMap = nsUriMappingsMap.get(nsUriString);
				for (String mappingName : mappingNameMap.keySet()) {
					RoleMapping mapping = mappingNameMap.get(mappingName);
					RoleModel roleModel = mapping.getMappedRoleModel();
					RoleMappingModel roleMapping = mapping.getOwningMappingModel();
					EPackage metamodel = roleMapping.getTargetMetamodel();
					Map<EPackage, List<RoleMapping>> metamodelMappingsMap = roleModelMetamodelMappingsMap.get(roleModel);
					if (metamodelMappingsMap == null) {
						roleModelMetamodelMappingsMap.put(roleModel, new LinkedHashMap<EPackage, List<RoleMapping>>());
						metamodelMappingsMap = roleModelMetamodelMappingsMap.get(roleModel);
					}
					List<RoleMapping> metamodelMappings = metamodelMappingsMap.get(metamodel);
					if (metamodelMappings == null) {
						metamodelMappingsMap.put(metamodel, new LinkedList<RoleMapping>());
						metamodelMappings = metamodelMappingsMap.get(metamodel);
					}
					metamodelMappings.add(mapping);
				}
			}
			for (RoleModel roleModel : roleModels) {
				RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(roleModel);
				if (refSpec != null) {
					TreeParent modelParent = new TreeParent(roleModel);
					invisibleRoot.addChild(modelParent);
					Map<EPackage, List<RoleMapping>> metamodelMappingsMap = roleModelMetamodelMappingsMap.get(roleModel);
					if (metamodelMappingsMap == null) {
						continue;
					}
					for (EPackage metamodel : metamodelMappingsMap.keySet()) {
						TreeMetaModelParent metamodelParent = new TreeMetaModelParent(
								metamodel);
						modelParent.addChild(metamodelParent);
						List<RoleMapping> metamodelMappings = metamodelMappingsMap.get(metamodel);
						List<RoleMapping> uniqueMappings = new ArrayList<RoleMapping>();
						for (RoleMapping mapping : metamodelMappings) {
							if (!uniqueMappings.contains(mapping)) {
								TreeObject mappingChild = new TreeLeaf(mapping);
								metamodelParent.addChild(mappingChild);
								uniqueMappings.add(mapping);
							}
						}
					}
				}
			}
			return invisibleRoot;
		}

		public TreeParent getInvisibleRoot() {
			return invisibleRoot;
		}
	}

	class ViewLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof TreeObject) {
				TreeObject object = (TreeObject) element;
				EObject eObject = object.getObject();
				switch (columnIndex) {
					case 0: // Refactoring mapped to Metamodel
						if (object instanceof TreeParent) {
							return labelProvider.getImage(eObject);
						} else {
							return null;
						}
					case 1: // Specific Refactoring
						if (object instanceof TreeLeaf) {
							return labelProvider.getImage(eObject);
						}
					default:
						return null;
				}
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof TreeObject) {
				TreeObject object = (TreeObject) element;
				// EObject eObject = object.getObject();
				switch (columnIndex) {
					case 0: // Refactoring mapped to Metamodel
						if (object instanceof TreeMetaModelParent) {
							return object.toString();
						} else if (object instanceof TreeParent) {
							return StringUtil.convertCamelCaseToWords(object.toString());
						}
						return "";
					case 1: // Specific Refactoring
						if (object instanceof TreeLeaf) {
							return StringUtil.convertCamelCaseToWords(object.toString());
						}
						return "";
					case 2: // PostProcessor (PP)
						if (object instanceof TreeLeaf) {
							boolean hasPostProcessor = ((TreeLeaf) object).hasPostProcessorRegistered();
							if (hasPostProcessor) {
								return "X";
							}
						}
						return "";
					case 3: // count of Metaclasses
						if (object instanceof TreeMetaModelParent) {
							int count = ((TreeMetaModelParent) object).getCountMetaclasses();
							return String.valueOf(count);
						}
						return "";
						// case 4: // count of Relations
						// if(object instanceof TreeLeaf){
						// int count = ((TreeLeaf)
						// object).getCountStructuralFeatures();
						// return String.valueOf(count);
						// }
						// return "";
					case 4: // count of StructuralFeatures
						if (object instanceof TreeMetaModelParent) {
							int count = ((TreeMetaModelParent) object).getCountStructuralFeatures();
							return String.valueOf(count);
						}
						return "";
						// case 5: // average Relations per Metaclass
						// if(object instanceof TreeLeaf){
						// double average = ((TreeLeaf)
						// object).getCountStructuralFeaturesPerMetaclass();
						// String averageString = String.valueOf(average);
						// int dotIndex = averageString.indexOf(".");
						// if(dotIndex + 3 <= averageString.length()){
						// averageString = averageString.substring(0, dotIndex +
						// 3);
						// }
						// return averageString;
						// }
						// return "";
					case 5: // summation
						if (object instanceof TreeMetaModelParent) {
							int sum = ((TreeMetaModelParent) object).getCountStructuralFeatures() + ((TreeMetaModelParent) object).getCountMetaclasses();
							return String.valueOf(sum);
						}
						return "";
					default:
						return "";
				}
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		public void dispose() {
			// TODO Auto-generated method stub

		}

		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public RefactoringStatisticView() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent,
				SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);

		Tree tree = viewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setWidth(300);
		column1.setText("Refactoring mapped to Metamodel");
		TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
		column2.setWidth(200);
		column2.setText("Specific Refactoring");
		TreeColumn column3 = new TreeColumn(tree, SWT.CENTER);
		column3.setWidth(40);
		column3.setText("PP");
		TreeColumn column4 = new TreeColumn(tree, SWT.CENTER);
		column4.setWidth(40);
		column4.setText("MC");
		TreeColumn column5 = new TreeColumn(tree, SWT.CENTER);
		column5.setWidth(40);
		column5.setText("SF");
		TreeColumn column6 = new TreeColumn(tree, SWT.CENTER);
		column6.setWidth(40);
		column6.setText("SUM");

		drillDownAdapter = new DrillDownAdapter(viewer);
		contentProvider = new ViewContentProvider();
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		viewer.expandToLevel(2);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				RefactoringStatisticView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(refactoringDocGenAction);
		manager.add(new Separator());
		manager.add(complexLatexTableGenAction);
		manager.add(new Separator());
		manager.add(complexWikiTableGenAction);
		manager.add(new Separator());
		manager.add(simpleLatexTableGenAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(refactoringDocGenAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refactoringDocGenAction);
		manager.add(complexLatexTableGenAction);
		manager.add(complexWikiTableGenAction);
		manager.add(simpleLatexTableGenAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		makeRefactoringDocGenAction();
		makeComplexLatexTableGenAction();
		makeComplexWikiTableGenAction();
		makeSimpleLatexTableGenAction();

		doubleClickAction = new Action() {

			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	private void makeComplexWikiTableGenAction() {
		complexWikiTableGenAction = new Action() {

			public void run() {
				TreeParent invisibleRoot = contentProvider.getInvisibleRoot();
				try {
					String tempdir = System.getProperty("java.io.tmpdir") + "Refactor";
					File tempDir = new File(tempdir);
					boolean success = true;
					if (!tempDir.isDirectory()) {
						success = tempDir.mkdir();
					}
					if (success) {
						File tableFile = File.createTempFile("refactoringsComplex_", ".wiki", tempDir);
						tableFile.deleteOnExit();
						FileWriter writer = new FileWriter(tableFile);
						int specificCount = countSpecificRefactorings(invisibleRoot);
						int genericCount = invisibleRoot.getChildren().length;
						RegistryUtil.log("Reused " + genericCount + " generic refactorings for " + specificCount + " specific refactorings.", IStatus.INFO);
						writer.append("Reused '''" + genericCount + "''' generic refactorings for '''" + specificCount + "''' specific refactorings.\n");
						writer.append("{| class=\"wikitable sortable\" border=\"1\" style=\"width:100%;border-collapse:collapse;border:1px solid;\"\n");
						writer.append("! width=\"33%\" | Refactoring (Generic Name)\n");
						writer.append("! width=\"33%\" | Applied for metamodel\n");
						writer.append("! width=\"33%\" class=\"unsortable\" | Specific Refactoring\n\n");
						int even = 0;
						String style = "";
						for (TreeObject roleModelParent : invisibleRoot.getChildren()) {
							if (roleModelParent instanceof TreeParent && !(roleModelParent instanceof TreeMetaModelParent)) {
								RoleModel rolemodel = (RoleModel) roleModelParent.getObject();
								String roleModelName = rolemodel.getName();
								writer.append("|-\n");
								writer.append("! [[Refactoring:" + roleModelName + "|" + StringUtil.convertCamelCaseToWords(roleModelName) + "]]\n");
								writer.append("| colspan=\"2\"|\n");
								writer.append("{| class=\"wikitable\" style=\"width:100%;\"\n");
								writer.append("! width=\"50%\" align=\"right\" |\n");
								writer.append("! width=\"50%\" align=\"right\" |\n");

								for (TreeObject metamodelChild : ((TreeParent) roleModelParent).getChildren()) {
									if (metamodelChild instanceof TreeMetaModelParent) {
										even++;
										if (even % 2 == 0) {
											style = "style=\"background:" + EVEN_COLOR + ";\"";
										} else {
											style = "";
										}
										writer.append("|- " + style + "\n");
										EPackage metamodel = ((TreeMetaModelParent) metamodelChild).getMetamodel();
										String metamodelShort = StringUtil.firstLetterUpperCase(metamodel.getName());
										TreeObject[] mappingChildren = ((TreeParent) metamodelChild).getChildren();
										if (mappingChildren.length > 1) {
											writer.append("| [[" + ZOO_PREFIX + metamodelShort + "|" + metamodelShort + "]]\n");
											writer.append("| \n");
											writer.append("{| \n");
											for (TreeObject mappingChild : mappingChildren) {
												if (mappingChild instanceof TreeLeaf) {
													RoleMapping mapping = (RoleMapping) mappingChild.getObject();
													writer.append(" | [[Refactoring:" + roleModelName + ":" + metamodelShort + ":" + mapping.getName() + "|" + StringUtil.convertCamelCaseToWords(mapping.getName()) + "]]\n");
													writer.append(" |- \n");
												}
											}
											writer.append(" |} \n");
//											writer.append("|- \n");
										} else {
											TreeObject mappingLeaf = mappingChildren[0];
											RoleMapping mapping = (RoleMapping) mappingLeaf.getObject();
											writer.append("| [[" + ZOO_PREFIX + metamodelShort + "|" + metamodelShort + "]]\n");
											writer.append("| [[Refactoring:" + roleModelName + ":" + metamodelShort + ":" + mapping.getName() + "|" + StringUtil.convertCamelCaseToWords(mapping.getName()) + "]]\n");
//											writer.append("|- \n");
										}
										TreeObject[] children = ((TreeParent) roleModelParent).getChildren();
										if (children[children.length - 1].equals(metamodelChild)) {
											writer.append("|- \n");
										}
									}
								}
								writer.append("|}\n\n");
							}
						}
						writer.append("|}");
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			private int countSpecificRefactorings(TreeParent invisibleRoot) {
				int count = 0;
				for (TreeObject child : invisibleRoot.getChildren()) {
					if (child instanceof TreeParent) {
						count += countSpecificRefactorings((TreeParent) child);
					} else {
						count++;
					}
				}
				return count;
			}
		};
		complexWikiTableGenAction.setText("Generate complex Wiki table");
		complexWikiTableGenAction.setToolTipText("Generate complex Wiki table");
		complexWikiTableGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	}

	private void makeSimpleLatexTableGenAction() {
		simpleLatexTableGenAction = new Action() {

			public void run() {
				TreeParent invisibleRoot = contentProvider.getInvisibleRoot();
				try {
					String tempdir = System.getProperty("java.io.tmpdir") + "Refactor";
					File tempDir = new File(tempdir);
					boolean success = true;
					if (!tempDir.isDirectory()) {
						success = tempDir.mkdir();
					}
					int totalMappings = 0;
					if (success) {
						Map<EPackage, Map<RoleModel, Integer>> mappingCountMap = new LinkedHashMap<EPackage, Map<RoleModel, Integer>>();
						List<RoleModel> roleModels = new LinkedList<RoleModel>();
						Map<EPackage, Map<RoleModel, Integer>> ppCountMap = new LinkedHashMap<EPackage, Map<RoleModel, Integer>>();
						for (TreeObject object : invisibleRoot.getChildren()) {
							if (object instanceof TreeParent && !(object instanceof TreeMetaModelParent)) {
								TreeParent parent = (TreeParent) object;
								RoleModel roleModel = (RoleModel) parent.getObject();
								roleModels.add(roleModel);
								TreeObject[] roleModelChildren = parent.getChildren();
								// int count = parent.getChildren().length;
								// writer.append("\\multirow{" + count
								// +"}{*}{\\textit{" +
								// StringUtil.convertCamelCaseToWords(roleModel.getName())
								// + "}} \n");
								for (TreeObject treeObject : roleModelChildren) {
									if (treeObject instanceof TreeMetaModelParent) {
										TreeMetaModelParent metamodelParent = (TreeMetaModelParent) treeObject;
										EPackage metamodel = metamodelParent.getMetamodel();
										Map<RoleModel, Integer> metamodelMap = mappingCountMap.get(metamodel);
										if (metamodelMap == null) {
											metamodelMap = new LinkedHashMap<RoleModel, Integer>();
											mappingCountMap.put(metamodel, metamodelMap);
										}
										int mappingCount = metamodelParent.getChildren().length;
										metamodelMap.put(roleModel, mappingCount);
										TreeObject[] children = metamodelParent.getChildren();
										for (TreeObject child : children) {
											if (child instanceof TreeLeaf) {
												TreeLeaf leaf = (TreeLeaf) child;
												boolean hasPostProcessor = leaf.hasPostProcessorRegistered();
												if (hasPostProcessor) {
													Map<RoleModel, Integer> ppCount = ppCountMap.get(metamodel);
													if (ppCount == null) {
														ppCount = new LinkedHashMap<RoleModel, Integer>();
														ppCountMap.put(metamodel, ppCount);
													}
													if (ppCount.get(roleModel) == null) {
														ppCount.put(roleModel, 1);
													} else {
														ppCount.put(roleModel, ppCount.get(roleModel) + 1);
													}
												}
											}
										}
										// count--;
										String mmName = StringUtil.firstLetterUpperCase(metamodel.getName());
										mmName = mmName.replaceAll("_", " ");
										// Integer ppCount =
										// ppCountMap.get(metamodel);
										// writer.append("& " + mmName + " & " +
										// mappingCount + " & " + ((ppCount ==
										// null)?"":ppCount) + " \\\\ " +
										// ((count ==
										// 0)?"\\hline":"\\cline{2-4}\n"));
									}
								}
								// writer.append("\n\n");
							}
						}
						Set<EPackage> metamodels = mappingCountMap.keySet();
						File tableFile = File.createTempFile("refactoringsSimple_", ".latex", tempDir);
						tableFile.deleteOnExit();
						FileWriter writer = new FileWriter(tableFile);
						writer.append("\\begingroup\n");
						writer.append("\\footnotesize\n");
						writer.append("\\begin{longtable}{|l|");
						for (int i = 0; i < metamodels.size(); i++) {
							writer.append("c|");
						}
						writer.append("}\n");
						writer.append("\\caption{Refactorings applied to metamodels}\\label{tab:evaluation}\\\\\n");
						writer.append("\\hline\n");
						for (EPackage ePackage : metamodels) {
							String metamodelString = StringUtil.firstLetterUpperCase(ePackage.getName()).replaceAll("_", " ");
							// writer.append(" & \\multicolumn{1}{R{3cm}|}{\\textbf{"
							// + metamodelString + "}}");
							writer.append(" & \\multicolumn{1}{R{2.5cm}|}{" + metamodelString + "}\n");
						}
						writer.append("\\\\ \\hline\n\n");
						for (RoleModel roleModel : roleModels) {
							writer.append(StringUtil.convertCamelCaseToWords(roleModel.getName()));
							for (EPackage ePackage : metamodels) {
								Map<RoleModel, Integer> countMap = mappingCountMap.get(ePackage);
								Map<RoleModel, Integer> ppCount = ppCountMap.get(ePackage);
								Integer ppCountValue = null;
								if (ppCount != null) {
									ppCountValue = ppCount.get(roleModel);
								}
								Integer mappingCount = countMap.get(roleModel);
								totalMappings += mappingCount == null ? 0
										: mappingCount;
								String mappingCountString = (mappingCount == null) ? ""
										: "" + mappingCount;
								String ppString = (ppCountValue == null) ? ""
										: "(" + ppCountValue + ")";
								String metamodelString = StringUtil.firstLetterUpperCase(ePackage.getName()).replaceAll("_", " ");
								writer.append("\n & " + mappingCountString + ppString + "%" + metamodelString);
							}
							writer.append("\n\\\\ \\hline\n\n");
						}
						// writer.append("\\multicolumn{4}{l}{MP = RoleMapping Count (quantity the role model was mapped)} \\\\\n");
						// writer.append("\\multicolumn{4}{l}{PP = Post Processors (quantity of needed post processors)}\n");
						writer.append("\\end{longtable}\n");
						writer.append("\\endgroup\n");
						writer.close();
					}
					RegistryUtil.log("RefactoringStatisticView.makeSimpleLatexTableGenAction() total mappings " + totalMappings, IStatus.INFO);
				} catch (IOException e) {
					e.printStackTrace();
					RegistryUtil.log("an error occurred while generating the LaTeX table", IStatus.ERROR, e);
				}
			}
		};
		simpleLatexTableGenAction.setText("Generate simple LaTeX table");
		simpleLatexTableGenAction.setToolTipText("Generate simple LaTeX table");
		simpleLatexTableGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
	}

	private void makeComplexLatexTableGenAction() {
		complexLatexTableGenAction = new Action() {

			public void run() {
				TreeParent invisibleRoot = contentProvider.getInvisibleRoot();
				try {
					String tempdir = System.getProperty("java.io.tmpdir") + "Refactor";
					File tempDir = new File(tempdir);
					boolean success = true;
					if (!tempDir.isDirectory()) {
						success = tempDir.mkdir();
					}
					if (success) {
						File tableFile = File.createTempFile("refactoringsComplex_", ".latex", tempDir);
						tableFile.deleteOnExit();
						FileWriter writer = new FileWriter(tableFile);
						writer.append("\\begingroup\n");
						writer.append("\\footnotesize\n");
						writer.append("\\begin{longtable}{|l|l|c|c|c|c|}\n");
						writer.append("\\caption{Refactorings applied to metamodels}\\\\\n");
						writer.append("\\hline\n");
						writer.append("\\textbf{Metamodel} & \\textbf{Specific Name} & \\textbf{PP} & \\textbf{MC} & \\textbf{SF} & \\textbf{SUM}\\\\ \\hline\n");
						for (TreeObject object : invisibleRoot.getChildren()) {
							if (object instanceof TreeParent && !(object instanceof TreeMetaModelParent)) {
								TreeParent parent = (TreeParent) object;
								RoleModel roleModel = (RoleModel) parent.getObject();
								writer.append("\\multicolumn{6}{|c|}{\\textit{" + StringUtil.convertCamelCaseToWords(roleModel.getName()) + "}}\\\\ \\hline\n");
								for (TreeObject child : parent.getChildren()) {
									if (child instanceof TreeMetaModelParent) {
										TreeMetaModelParent metamodelParent = (TreeMetaModelParent) child;
										TreeObject[] metamodelChildren = metamodelParent.getChildren();
										for (TreeObject treeObject : metamodelChildren) {
											if (treeObject instanceof TreeLeaf) {
												TreeLeaf leaf = (TreeLeaf) treeObject;
												String mmName = StringUtil.firstLetterUpperCase(metamodelParent.getMetamodel().getName());
												mmName = mmName.replaceAll("_", " ");
												writer.append(mmName);
												writer.append(" & ");
												RoleMapping mapping = (RoleMapping) leaf.getObject();
												writer.append(StringUtil.convertCamelCaseToWords(mapping.getName()));
												writer.append(" & ");
												boolean hasPostProcessor = leaf.hasPostProcessorRegistered();
												if (hasPostProcessor) {
													writer.append("X");
												}
												writer.append(" & ");
												writer.append(String.valueOf(metamodelParent.getCountMetaclasses()));
												writer.append(" & ");
												writer.append(String.valueOf(metamodelParent.getCountStructuralFeatures()));
												writer.append(" & ");
												int sum = metamodelParent.getCountMetaclasses() + metamodelParent.getCountStructuralFeatures();
												writer.append(String.valueOf(sum));
												writer.append("\\\\ \\hline\n");
											}
										}
									}
								}
							}
						}
						writer.append("\\end{longtable}\n");
						writer.append("\\endgroup\n");
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		complexLatexTableGenAction.setText("Generate complex LaTeX table");
		complexLatexTableGenAction.setToolTipText("Generate complex LaTeX table");
		complexLatexTableGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
	}

	private void makeRefactoringDocGenAction() {
		refactoringDocGenAction = new Action() {

			public void run() {
				ISelection selection = viewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection) selection).getFirstElement();
					if (first != null) {
						if (first instanceof TreeParent) {
							TreeParent parent = (TreeParent) first;
							RoleModel roleModel = (RoleModel) parent.getObject();
							if (roleModel != null) {
								try {
									String tempdir = System.getProperty("java.io.tmpdir") + "Refactor";
									File tempDir = new File(tempdir);
									boolean success = true;
									if (!tempDir.isDirectory()) {
										success = tempDir.mkdir();
									}
									if (success) {
										File documentation = File.createTempFile("doc_" + roleModel.getName() + "_", ".wiki", tempDir);
										documentation.deleteOnExit();
										FileWriter writer = new FileWriter(
												documentation);
										writer.append("==" + StringUtil.convertCamelCaseToWords(roleModel.getName()) + "==\n");
										String comment = roleModel.getComment();
										if (comment != null) {
											comment = comment.trim().replaceAll("[\r\n]", " ");
											comment = comment.replaceAll("[\t]", "");
										} else {
											comment = "";
										}
										writer.append(comment + "\n\n");
										writer.append("[[Image:Example.jpg]]");
										writer.append("\n\n");
										for (Role role : roleModel.getRoles()) {
											writer.append(";'''" + role.getName() + "'''\n");
											comment = role.getComment();
											if (comment != null) {
												comment = comment.trim().replaceAll("[\r\n]", " ");
												comment = comment.replaceAll("[\t]", "");
											} else {
												comment = "";
											}
											writer.append(":" + comment + "\n\n");
										}
										writer.append("\n\n");
										writer.append("The textual representation of the role model above and the single steps being needed for this refactoring can be seen in the following:");
										writer.append("\n\n");
										writer.append("[http://svn-st.inf.tu-dresden.de/svn/reuseware/trunk/Refactoring/Registrations/Refactorings/org.emftext.refactoring.extractXwithReference/rolemodels/ExtractXwithReference.rolestext ExtractXwithReference.rolestext]");
										writer.append("\n<br>\n");
										writer.append("[http://svn-st.inf.tu-dresden.de/svn/reuseware/trunk/Refactoring/Registrations/Refactorings/org.emftext.refactoring.extractXwithReference/refspecs/ExtractXwithReference.refspec ExtractXwithReference.refspec]");
										writer.close();
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		};
		refactoringDocGenAction.setText("Generate Documentation of selected Refactoring");
		refactoringDocGenAction.setToolTipText("Generate Documentation of selected Refactoring");
		refactoringDocGenAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "Refactoring Statistics", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}