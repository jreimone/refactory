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
package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.emftext.refactoring.registry.rolemapping.IConstraintInterpreter;
import org.emftext.refactoring.registry.rolemapping.IConstraintInterpreterExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IConstraintInterpreterRegistry;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * @author jreimann
 *
 */
public class ConstraintInterpreterRegistry implements IConstraintInterpreterRegistry {

	private Set<IConstraintInterpreter> interpreters;
	
	public ConstraintInterpreterRegistry() {
		super();
		interpreters = new HashSet<IConstraintInterpreter>();
		initInterpreters();
	}

	private void initInterpreters() {
		if(Platform.isRunning()){
			IConfigurationElement[] configurationElements = RegistryUtil.collectConfigurationElements(IConstraintInterpreterExtensionPoint.ID);
			for (IConfigurationElement configurationElement : configurationElements) {
				try {
					IConstraintInterpreter interpreter = (IConstraintInterpreter) configurationElement.createExecutableExtension(IConstraintInterpreterExtensionPoint.INTERPRETER_IMPL);
					registerInterpreter(interpreter);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public IConstraintInterpreter getInterpreterForConstraint(Object constraint) {
		for (IConstraintInterpreter interpreter : interpreters) {
			if(interpreter.canInterprete(constraint)){
				return interpreter;
			}
		}
		return null;
	}

	@Override
	public void registerInterpreter(IConstraintInterpreter interpreter) {
		interpreters.add(interpreter);
	}

	@Override
	public Set<IConstraintInterpreter> getAllInterpreters() {
		return interpreters;
	}

}
