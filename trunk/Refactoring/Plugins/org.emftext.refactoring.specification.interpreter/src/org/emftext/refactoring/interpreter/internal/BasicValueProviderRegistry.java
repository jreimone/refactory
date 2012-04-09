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
package org.emftext.refactoring.interpreter.internal;

import java.util.LinkedHashMap;
import java.util.Map;

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderRegistry;

public class BasicValueProviderRegistry implements IValueProviderRegistry {

	private Map<RoleMapping, Class<? extends IValueProvider<?, ?>>> valueProviderMap;
	
	public BasicValueProviderRegistry(){
		valueProviderMap = new LinkedHashMap<RoleMapping, Class<? extends IValueProvider<?,?>>>();
	}
	
	public Class<? extends IValueProvider<?, ?>> registerValueProvider(RoleMapping roleMapping, Class<? extends IValueProvider<?, ?>> valueProviderClass) {
		Class<? extends IValueProvider<?, ?>> registeredValueProvider = getValueProviderMap().get(roleMapping);
		if(registeredValueProvider == null){
			getValueProviderMap().put(roleMapping, valueProviderClass);
			registeredValueProvider = valueProviderClass;
		}
		return registeredValueProvider;
	}

	public Class<? extends IValueProvider<?, ?>> getValueProviderByRoleMapping(RoleMapping roleMapping) {
		return getValueProviderMap().get(roleMapping);
	}

	public Map<RoleMapping, Class<? extends IValueProvider<?, ?>>> getValueProviderMap() {
		return valueProviderMap;
	}

}
