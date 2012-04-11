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
package org.emftext.refactoring.valueprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;

public class BasicValueProviderFactory implements IValueProviderFactory {

	private IRefactorer refactorer;
	private Map<EObject, IValueProvider<?, ?>> valueProviderMap;

	public BasicValueProviderFactory(IRefactorer refactorer) {
		super();
		this.refactorer = refactorer;
		valueProviderMap = new HashMap<EObject, IValueProvider<?,?>>();
	}

	public IValueProvider<?, ?> getValueProviderForCommand(EObject command, Object... context) {
		IValueProvider<?, ?> valueProvider = valueProviderMap.get(command);
		if(valueProvider == null){
			valueProvider = registerValueProviderForCommand(command, context);
		} 
		return valueProvider;
	}

	public List<IValueProvider<?, ?>> getValuesToProvide() {
		List<IValueProvider<?, ?>> valueProviders = new ArrayList<IValueProvider<?,?>>(valueProviderMap.values());
		return valueProviders;
	}

	public void registerValueProviderForCommand(EObject command, IValueProvider<?, ?> valueProvider) {
		if(command != null && valueProvider != null){
			valueProviderMap.put(command, valueProvider);
		}
	}

	public IValueProvider<?, ?>  registerValueProviderForCommand(EObject command, Object... context) {
		IValueProvider<?, ?> valueProvider = valueProviderMap.get(command);
		if(valueProvider == null){
			if(command instanceof ASSIGN){
				valueProvider = new DialogAttributeValueProvider(refactorer.getRoleMapping());
			} else if (command instanceof ObjectAssignmentCommand){
				valueProvider = new DialogOneListElementProvider(refactorer.getRoleMapping());
				if(context.length >= 1 && (context[0] instanceof Role)){
					Role role = (Role) context[0];
					EClass metaclass = refactorer.getRoleMapping().getEClassForRole(role);
					valueProvider.setName("Select one " + metaclass.getName());
				}
			}
			registerValueProviderForCommand(command, valueProvider);
		}
		return valueProvider;
	}

}
