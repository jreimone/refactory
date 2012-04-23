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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.ui.views.registry.model.TreeLeaf;
import org.emftext.refactoring.ui.views.registry.model.TreeMetaModelParent;
import org.emftext.refactoring.ui.views.registry.model.TreeObject;
import org.emftext.refactoring.ui.views.registry.model.TreeParent;
import org.emftext.refactoring.util.StringUtil;

class ViewLabelProvider implements ITableLabelProvider, ITableColorProvider {

		private AdapterFactoryLabelProvider labelProvider;
		
		public ViewLabelProvider(){
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
					org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		}
		
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

		@Override
		public Color getForeground(Object element, int columnIndex) {
			return null;
		}

		@Override
		public Color getBackground(Object element, int columnIndex) {
			if(element instanceof TreeParent){
				EObject object = ((TreeParent) element).getObject();
				if(object instanceof RoleModel){
					RoleModel roleModel = (RoleModel) object;
					RefactoringSpecification refSpec = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(roleModel);
					if(refSpec == null){
						Display display = Display.getDefault();
						RGB rgb = new RGB(0.0f, 0.33f, 1.0f);
						Color color = new Color(display, rgb);
//						return display.getSystemColor(SWT.COLOR_RED);
						return color;
					}
				}
			}
			return null;
		}
	}