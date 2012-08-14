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

import org.eclipse.jface.action.Action;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.ui.views.registry.RegistryViewContentProvider;
import org.emftext.refactoring.ui.views.registry.model.TreeLeaf;
import org.emftext.refactoring.ui.views.registry.model.TreeMetaModelParent;
import org.emftext.refactoring.ui.views.registry.model.TreeObject;
import org.emftext.refactoring.ui.views.registry.model.TreeParent;
import org.emftext.refactoring.util.StringUtil;

/**
 * @author jreimann
 *
 */
public class ComplexLatexTableGenAction extends Action {
	/**
	 * 
	 */
	private RegistryViewContentProvider contentProvider;

	/**
	 * @param refactoringStatisticView
	 */
	public ComplexLatexTableGenAction(RegistryViewContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

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
}