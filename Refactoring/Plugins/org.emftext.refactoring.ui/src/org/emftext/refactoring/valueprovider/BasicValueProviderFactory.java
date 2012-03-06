package org.emftext.refactoring.valueprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.internal.ObjectAssignmentInterpreter;

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
			registerValueProviderForCommand(command);
		} else {
			if (command instanceof ObjectAssignmentInterpreter){
				if(context.length >= 1 && (context[0] instanceof Role)){
					Role role = (Role) context[0];
					EClass metaclass = refactorer.getRoleMapping().getEClassForRole(role);
					valueProvider.setName("Select one " + metaclass.getName());
				}
			}
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

	public void registerValueProviderForCommand(EObject command) {
		IValueProvider<?, ?> valueProvider = valueProviderMap.get(command);
		if(valueProvider == null){
			if(command instanceof ASSIGN){
				valueProvider = new DialogAttributeValueProvider(refactorer.getRoleMapping());
			} else if (command instanceof ObjectAssignmentInterpreter){
				valueProvider = new DialogOneListElementProvider(refactorer.getRoleMapping());
			}
			registerValueProviderForCommand(command, valueProvider);
		}
	}

}
