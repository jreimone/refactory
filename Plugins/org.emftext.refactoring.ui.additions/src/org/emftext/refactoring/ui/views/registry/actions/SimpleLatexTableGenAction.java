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
package org.emftext.refactoring.ui.views.registry.actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.ui.views.registry.RegistryViewContentProvider;
import org.emftext.refactoring.ui.views.registry.model.TreeLeaf;
import org.emftext.refactoring.ui.views.registry.model.TreeMetaModelParent;
import org.emftext.refactoring.ui.views.registry.model.TreeObject;
import org.emftext.refactoring.ui.views.registry.model.TreeParent;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.StringUtil;

/**
 * @author jreimann
 *
 */
public class SimpleLatexTableGenAction extends Action {
	/**
	 * 
	 */
	private RegistryViewContentProvider contentProvider;

	/**
	 * @param refactoringStatisticView
	 */
	public SimpleLatexTableGenAction(RegistryViewContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	public void run() {
		TreeParent invisibleRoot = contentProvider.getInvisibleRoot();
		try {
			String tempdir = System.getProperty("java.io.tmpdir");
			if(!tempdir.endsWith(File.separator)){
				tempdir += File.separator;
			}
			tempdir += "Refactor";
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
			RegistryUtil.log("RefactoringRegistryView.makeSimpleLatexTableGenAction() total mappings " + totalMappings, IStatus.INFO);
		} catch (IOException e) {
			e.printStackTrace();
			RegistryUtil.log("an error occurred while generating the LaTeX table", IStatus.ERROR, e);
		}
	}
}