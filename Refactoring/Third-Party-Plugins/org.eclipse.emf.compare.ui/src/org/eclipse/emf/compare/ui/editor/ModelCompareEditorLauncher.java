/*******************************************************************************
 * Copyright (c) 2006, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.ui.editor;

import java.io.IOException;

import org.eclipse.compare.CompareUI;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorLauncher;

/**
 * This launcher will be called to open a CompareEditor for the edition of emfdiff files.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class ModelCompareEditorLauncher implements IEditorLauncher {
	/**
	 * {@inheritDoc}
	 * 
	 * @see IEditorLauncher#open(IPath)
	 */
	public void open(IPath file) {
		try {
			final EObject snapshot = ModelUtils.load(file.toFile(), new ResourceSetImpl());
			if (snapshot instanceof ComparisonSnapshot) {
				CompareUI.openCompareEditor(new ModelCompareEditorInput((ComparisonSnapshot)snapshot));
			}
		} catch (final IOException e) {
			// file couldn't be read
			assert false;
		}
	}
}
