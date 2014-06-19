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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.ui.views.registry.model.TreeParent;
import org.emftext.refactoring.util.StringUtil;

/**
 * @author jreimann
 *
 */
public class MakeRefactoringDocGenAction extends Action {
	/**
	 * 
	 */
	private TreeViewer viewer;

	/**
	 * @param refactoringStatisticView
	 */
	public MakeRefactoringDocGenAction(TreeViewer viewer) {
		this.viewer = viewer;
	}

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
}