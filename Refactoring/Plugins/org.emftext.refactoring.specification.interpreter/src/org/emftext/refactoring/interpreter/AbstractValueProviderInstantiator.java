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
package org.emftext.refactoring.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.util.RegistryUtil;

public abstract class AbstractValueProviderInstantiator <ValueFrom, ValueType> {

	private IValueProviderRegistry registry;
	
	public AbstractValueProviderInstantiator(){
		registry = IValueProviderRegistry.INSTANCE;
	}
	
	@SuppressWarnings("unchecked")
	public IValueProvider<ValueFrom, ValueType> getNewValueProvider(RoleMapping roleMapping){
		Class<? extends IValueProvider<?,?>> valueProviderClass = registry.getValueProviderByRoleMapping(roleMapping);
		if(valueProviderClass == null){
			return getDefaultValueProvider(roleMapping);
		}
		IValueProvider<ValueFrom, ValueType> valueProvider = null;
		try {
			valueProvider = (IValueProvider<ValueFrom, ValueType>) valueProviderClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			RegistryUtil.log("ValueProvider could not be instantiated", IStatus.ERROR, e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			RegistryUtil.log("ValueProvider could not be instantiated", IStatus.ERROR, e);
		}
		return valueProvider;
	}

	public abstract IValueProvider<ValueFrom, ValueType> getDefaultValueProvider(RoleMapping roleMapping);
}
