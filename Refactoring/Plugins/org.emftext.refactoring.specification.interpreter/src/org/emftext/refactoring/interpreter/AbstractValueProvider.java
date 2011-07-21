/**
 * 
 */
package org.emftext.refactoring.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.swt.widgets.Composite;

/**
 * This is an abstract implementation of {@link IValueProvider}. Here, only the copier methods will be implementd.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractValueProvider<ValueFrom, ValueType> implements IValueProvider<ValueFrom, ValueType> {

	private ValueType value;
	
	private Copier copier;
	private Map<EObject, EObject> inverseCopier;
	
	private String name;

	public Copier getCopier() {
		return copier;
	}

	public Map<EObject, EObject> getInverseCopier() {
		if(inverseCopier == null && copier != null){
			inverseCopier = new LinkedHashMap<EObject, EObject>();
			for (EObject originalObject : copier.keySet()) {
				inverseCopier.put(copier.get(originalObject), originalObject);
			}
		}
		return inverseCopier;
	}

	public void setCopier(Copier copier) {
		this.copier = copier;
	}

	public ValueType getValue() {
		return value;
	}

	public void setValue(ValueType value) {
		this.value = value;
	}

	public Composite getProvidingComposite(){
		return null;
	}
	
	public void setFakePropagationContext(Object... context) {
		// do nothing
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
