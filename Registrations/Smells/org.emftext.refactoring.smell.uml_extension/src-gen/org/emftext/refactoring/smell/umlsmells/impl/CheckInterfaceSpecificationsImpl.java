/**
 */
package org.emftext.refactoring.smell.umlsmells.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;

import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationResult;
import org.emftext.refactoring.smell.calculation.Monotonicity;
import org.emftext.refactoring.smell.calculation.impl.MetricImpl;

import org.emftext.refactoring.smell.umlsmells.CheckInterfaceSpecifications;
import org.emftext.refactoring.smell.umlsmells.UmlsmellsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check Interface Specifications</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CheckInterfaceSpecificationsImpl extends MetricImpl implements CheckInterfaceSpecifications {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckInterfaceSpecificationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlsmellsPackage.Literals.CHECK_INTERFACE_SPECIFICATIONS;
	}
	
	@Override
	public String getName() {
		return "Check Interface Specification Count";
	}

	@Override
	public Monotonicity getMonotonicity() {
		return Monotonicity.DECREASING;
	}

	@Override
	public String getDescription() {
		return "Determines all interfaces having no implementation";
	}

	@Override
	public String getSmellMessage() {
		return "This interface has no implementation or extending interface";
	}

	@Override
	public CalculationResult calculate(EObject model, float threshold) {
		CalculationResult result = CalculationFactory.eINSTANCE.createCalculationResult();
		result.setResultingValue(0);
		if(model == null || !(model instanceof Model)){
			return null;
		}
		Model umlModel = (Model) model;
		Set<Interface> referencedInterfaces = new HashSet<Interface>();
		Set<Interface> unusedInterfaces = new HashSet<Interface>();
		for (Element e1 : umlModel.allOwnedElements()){
			if (e1 instanceof Class){
				for (Interface referencedInterface : ((Class) e1).getAllImplementedInterfaces()){
					referencedInterfaces.add(referencedInterface);
					if(unusedInterfaces.contains(referencedInterface)){
						unusedInterfaces.remove(referencedInterface);
					}
				}
			}
			if (e1 instanceof Interface){
				Interface interfaceClass = (Interface) e1;
				for (Interface referencedInterface : interfaceClass.getAllUsedInterfaces()){
					referencedInterfaces.add(referencedInterface);
					if(unusedInterfaces.contains(referencedInterface)){
						unusedInterfaces.remove(referencedInterface);
					}
				}
				unusedInterfaces.add(interfaceClass);
			}
		}
		result.getCausingObjects().addAll(unusedInterfaces);
		result.setResultingValue(result.getCausingObjects().size());
		return result;
	}

} //CheckInterfaceSpecificationsImpl
