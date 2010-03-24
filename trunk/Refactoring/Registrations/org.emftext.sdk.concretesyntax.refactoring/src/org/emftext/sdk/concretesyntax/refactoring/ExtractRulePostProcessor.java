package org.emftext.sdk.concretesyntax.refactoring;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.SyntaxElement;

/**
 * A post processor for the 'Extract Rule' refactoring of the
 * CS language. The post processor mainly established the reference
 * between the old rule (i.e., the one elements were removed from)
 * and the new rule. It does so by creating a new meta class and a
 * containment reference from the meta class of the old rule.
 */
// TODO the role mapping specified to put the moved elements in
// reference 'children' of class 'Role'. This is wrong, because
// this reference has type 'SyntaxElement', but is supposed to
// hold exactly one element of type 'Choice' only. We must either
// change the mapping or repair this while post processing.
public class ExtractRulePostProcessor implements IRefactoringPostProcessor {

	public ExtractRulePostProcessor() {
		super();
	}

	public Boolean process(Map<Role, Object> roleMap) {
		EObject newContainer = getEObjectByName(roleMap, "NewContainer");
		if (newContainer == null) {
			return false;
		}
		EObject oldContainer = getEObjectByName(roleMap, "OrigContainer");
		if (oldContainer == null) {
			// fail
			return false;
		}
		if (!(oldContainer instanceof SyntaxElement)) {
			// fail
			return false;
		}
		EObject movedReference = getEObjectByName(roleMap, "MovedReference");
		if (movedReference == null) {
			// fail
			return false;
		}
		if (!(movedReference instanceof Containment)) {
			// fail
			return false;
		}
		
		Containment newContainment = (Containment) movedReference;
		
		Rule oldRule = getContainingRule(oldContainer);
		if (oldRule == null) {
			// fail
			return false;
		}
		Rule newRule = getContainingRule(newContainer);
		if (newRule == null) {
			// fail
			return false;
		}
		
		// Create new meta class
		EClass newEClass = EcoreFactory.eINSTANCE.createEClass();
		newEClass.setName("NewClass"); // TODO avoid name clashes
		GenClass newGenClass = GenModelFactory.eINSTANCE.createGenClass();
		newGenClass.setEcoreClass(newEClass);
		
		// Add new meta class to packages of old rule
		GenClass oldMetaclass = oldRule.getMetaclass();
		EPackage ePackage = oldMetaclass.getEcoreClass().getEPackage();
		ePackage.getEClassifiers().add(newEClass);
		GenPackage genPackage = oldMetaclass.getGenPackage();
		genPackage.getGenClasses().add(newGenClass);
		
		// Add new containment feature
		EReference newContainmentEFeature = EcoreFactory.eINSTANCE.createEReference();
		newContainmentEFeature.setName("newClass");
		newContainmentEFeature.setContainment(true);
		newContainmentEFeature.setEType(newEClass);
		GenFeature newContainmentGenFeature = GenModelFactory.eINSTANCE.createGenFeature();
		newContainmentGenFeature.setEcoreFeature(newContainmentEFeature);
		oldMetaclass.getEcoreClass().getEStructuralFeatures().add(newContainmentEFeature);
		oldMetaclass.getGenFeatures().add(newContainmentGenFeature);

		// Add containment reference in old rule to new class
		newContainment.setFeature(newContainmentGenFeature);
		
		// Set new meta class in new rule
		newRule.setMetaclass(newGenClass);
		return true;
	}

	private Rule getContainingRule(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Rule) {
			return (Rule) object;
		} else {
			EObject parent = object.eContainer();
			return getContainingRule(parent);
		}
	}

	private EObject getEObjectByName(Map<Role, Object> roleMap, String roleName) {
		Set<Role> roles = roleMap.keySet();
		for (Role role : roles) {
			if (roleName.equals(role.getName())) {
				Object object = roleMap.get(role);
				if (object instanceof EObject) {
					EObject eObject = (EObject) object;
					return eObject;
				}
			}
		}
		return null;
	}
}
