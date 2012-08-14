/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.ui.views.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.ui.views.registry.model.TreeLeaf;
import org.emftext.refactoring.ui.views.registry.model.TreeMetaModelParent;
import org.emftext.refactoring.ui.views.registry.model.TreeObject;
import org.emftext.refactoring.ui.views.registry.model.TreeParent;

public class RegistryViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {

		/**
		 * 
		 */
		private final RefactoringRegistryView refactoringRegistryView;
		private TreeParent invisibleRoot;
		private TreeViewer viewer;

		private Map<RoleMapping, TreeLeaf> roleMappingLeafMap = new HashMap<RoleMapping, TreeLeaf>();
		private Map<RoleModel, TreeParent> roleModelParentMap = new HashMap<RoleModel, TreeParent>();
		private Map<RoleModel, Map<EPackage, TreeMetaModelParent>> roleModelMetamodelMap = new HashMap<RoleModel, Map<EPackage, TreeMetaModelParent>>();

		public RegistryViewContentProvider(RefactoringRegistryView refactoringRegistryView){
			this.refactoringRegistryView = refactoringRegistryView;
			initialize();
		}
		
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void remove(EObject element){
			TreeObject object2remove = null;
			if(element instanceof RoleModel){
				RoleModel roleModel = (RoleModel) element;
				TreeParent parent = roleModelParentMap.get(roleModel);
				invisibleRoot.removeChild(parent);
				roleModelMetamodelMap.remove(roleModel);
				object2remove = parent;
			} else if(element instanceof RefactoringSpecification){
				RefactoringSpecification refSpec =(RefactoringSpecification) element;
				RoleModel roleModel = refSpec.getUsedRoleModel();
				TreeParent parent = roleModelParentMap.get(roleModel);
				viewer.update(parent, null);
			} else if(element instanceof RoleMapping){
				RoleMapping roleMapping = (RoleMapping) element;
				TreeLeaf leaf = roleMappingLeafMap.get(roleMapping);
				TreeParent parent = leaf.getParent();
				parent.removeChild(leaf);
				if(parent instanceof TreeMetaModelParent && parent.getChildren().length == 0){
					RoleModel roleModel = roleMapping.getMappedRoleModel();
					Map<EPackage, TreeMetaModelParent> map = roleModelMetamodelMap.get(roleModel);
					if(map != null){
						map.remove(((TreeMetaModelParent) parent).getMetamodel());
					}
					object2remove = parent;
				} else {
					object2remove = leaf;
				}
			}
			if(viewer != null && object2remove != null){
				viewer.remove(object2remove);
			}
		}

		public void add(EObject element){
			if(element instanceof RoleModel){
				TreeParent roleParent = new TreeParent(element);
				invisibleRoot.addChild(roleParent);
				roleModelParentMap.put((RoleModel) element, roleParent);
				if(viewer != null){
					viewer.refresh();
//					viewer.add(invisibleRoot, roleParent);
				}
			} else if(element instanceof RoleMapping){
				TreeObject mappingChild = createRoleMappingChild((RoleMapping) element);
				if(viewer != null){
					viewer.add(mappingChild.getParent(), mappingChild);
				}
			} else if(element instanceof RefactoringSpecification){
				RefactoringSpecification refSpec =(RefactoringSpecification) element;
				RoleModel roleModel = refSpec.getUsedRoleModel();
				TreeParent parent = roleModelParentMap.get(roleModel);
				viewer.update(parent, null);
			}
		}

		private TreeObject createRoleMappingChild(RoleMapping element) {
			RoleMappingModel owningMappingModel = element.getOwningMappingModel();
			EPackage metamodel = owningMappingModel.getTargetMetamodel();
			RoleModel roleModel = IRoleModelRegistry.INSTANCE.getRoleModelByName(element.getMappedRoleModel().getName());
			Map<EPackage, TreeMetaModelParent> metamodelTreeMap = roleModelMetamodelMap.get(roleModel);
			if(metamodelTreeMap == null){
				metamodelTreeMap = new HashMap<EPackage, TreeMetaModelParent>();
				roleModelMetamodelMap.put(roleModel, metamodelTreeMap);
			}
			TreeMetaModelParent metamodelObject = metamodelTreeMap.get(metamodel);
			boolean metamodelObjectCreated = false;
			if(metamodelObject == null){
				metamodelObject = new TreeMetaModelParent(metamodel);
				metamodelTreeMap.put(metamodel, metamodelObject);
				TreeParent treeParent = roleModelParentMap.get(roleModel);
				treeParent.addChild(metamodelObject);
				metamodelObjectCreated = true;
			}
			TreeLeaf mappingLeaf = new TreeLeaf(element);
			metamodelObject.addChild(mappingLeaf);
			roleMappingLeafMap.put(element, mappingLeaf);
			return (metamodelObjectCreated ? metamodelObject : mappingLeaf);
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent.equals(this.refactoringRegistryView.getViewSite())) {
				if (invisibleRoot == null) {
					initialize();
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

		private void initialize() {
			invisibleRoot = new TreeParent(null);
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
					roleModelParentMap.put(roleModel, modelParent);
					Map<EPackage, List<RoleMapping>> metamodelMappingsMap = roleModelMetamodelMappingsMap.get(roleModel);
					if (metamodelMappingsMap == null) {
						continue;
					}
					for (EPackage metamodel : metamodelMappingsMap.keySet()) {
						TreeMetaModelParent metamodelParent = new TreeMetaModelParent(metamodel);
						modelParent.addChild(metamodelParent);
						Map<EPackage, TreeMetaModelParent> metamodelTreeMap = roleModelMetamodelMap.get(roleModel);
						if(metamodelTreeMap == null){
							metamodelTreeMap = new HashMap<EPackage, TreeMetaModelParent>();
							roleModelMetamodelMap.put(roleModel, metamodelTreeMap);
						}
						metamodelTreeMap.put(metamodel, metamodelParent);
						List<RoleMapping> metamodelMappings = metamodelMappingsMap.get(metamodel);
						List<RoleMapping> uniqueMappings = new ArrayList<RoleMapping>();
						for (RoleMapping mapping : metamodelMappings) {
							if (!uniqueMappings.contains(mapping)) {
								TreeLeaf mappingChild = new TreeLeaf(mapping);
								metamodelParent.addChild(mappingChild);
								roleMappingLeafMap.put(mapping, mappingChild);
								uniqueMappings.add(mapping);
							}
						}
					}
				}
			}
		}

		public TreeParent getInvisibleRoot() {
			return invisibleRoot;
		}

		public void setViewer(TreeViewer viewer) {
			this.viewer = viewer;
		}
	}