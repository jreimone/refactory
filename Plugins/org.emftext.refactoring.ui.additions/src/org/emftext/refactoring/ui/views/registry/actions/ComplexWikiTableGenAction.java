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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
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
public class ComplexWikiTableGenAction extends Action {
	
	private static final String EVEN_COLOR = "#D3D3D3";
	private static final String ZOO_PREFIX = "EMFText_Concrete_Syntax_Zoo_";
	

	private RegistryViewContentProvider contentProvider;
	
	/**
	 * @param refactoringStatisticView
	 */
	public ComplexWikiTableGenAction(RegistryViewContentProvider contentProvider) {
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
}