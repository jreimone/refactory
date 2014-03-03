package org.ontomore.owl.refactoring;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.owl.ClassAtomic;
import org.emftext.language.owl.Conjunction;
import org.emftext.language.owl.Disjunction;
import org.emftext.language.owl.Frame;
import org.emftext.language.owl.IRIIdentified;
import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.OntologyDocument;
import org.emftext.language.owl.OwlFactory;
import org.emftext.language.owl.Primary;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

/**
 * Defines the refactoring for adding a covering axiom to an owl class.
 * 
 * @author Erik Tittel
 * 
 */
public class AddCoveringAxiomPostProcessor extends AbstractRefactoringPostProcessor {

	private org.emftext.language.owl.Class superclass = null;
	private List<org.emftext.language.owl.Class> subclasses;

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change) {

		checkRoleInstances(roleRuntimeInstanceMap);

		determineSuperclass(roleRuntimeInstanceMap);
		boolean intermediateResult = determineSubclasses(resourceSet);
		if (!intermediateResult) {
			return new Status(IStatus.WARNING, "org.ontomore.refactoring",
					"Preconditions for refactoring not met.");
		}
		constructSubclassDescriptions();
		return new Status(IStatus.OK, "org.ontomore.refactoring",
				"\"Add Covering Axiom\"-Refactoring successfully executed");
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,
			ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {

		return process(roleRuntimeInstanceMap, resourceSet, change);
	}

	/**
	 * This method shows that there are several role instances although it
	 * should be just one! The role "Element" is the input role. When the
	 * refactoring is invoked on a single class, there should be just one
	 * instance playing that role.
	 * 
	 * @param roleRuntimeInstanceMap
	 */
	private void checkRoleInstances(
			Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		for (Role role : roleRuntimeInstanceMap.keySet()) {
			System.out.println("Role: " + role.getName());
			for (EObject obj : roleRuntimeInstanceMap.get(role)) {
				if (obj instanceof IRIIdentified) {
					IRIIdentified iriIdentified = (IRIIdentified) obj;
					System.out.println("  Ontology object (role instance): "
							+ iriIdentified.getIri());
				}
			}
		}
	}

	/**
	 * Investigates the role-instance-map in terms of the Element-input-role and
	 * defines the first owl class playing that role as the superclass.
	 * 
	 * @param roleRuntimeInstanceMap
	 */
	private void determineSuperclass(
			Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		superclass = RoleUtil.getFirstObjectForRole("Element", org.emftext.language.owl.Class.class, roleRuntimeInstanceMap);
//		for (Role role : roleRuntimeInstanceMap.keySet()) {
//			if (role.getName().equals("Element")) {
//				EObject object = roleRuntimeInstanceMap.get(role).get(0);
//				if (object instanceof org.emftext.language.owl.Class) {
//					org.emftext.language.owl.Class owlClass = (org.emftext.language.owl.Class) object;
//					System.out.println("Superclass name: " + owlClass.getIri());
//					superclass = owlClass;
//				}
//			}
//		}
	}

	/**
	 * Investigates all classes of the ontology and defines those with a
	 * reference to the superclass as subclasses.
	 * 
	 * @param resourceSet
	 * @return
	 */
	private boolean determineSubclasses(ResourceSet resourceSet) {
		Resource res = resourceSet.getResources().get(0);
		EObject obj = res.getContents().get(0);
		if (!(obj instanceof OntologyDocument)) {
			return false;
		}
		OntologyDocument ontoDoc = (OntologyDocument) obj;
		Ontology onto = ontoDoc.getOntology();
		EList<Frame> frames = onto.getFrames();
		subclasses = new LinkedList<org.emftext.language.owl.Class>();
		for (Frame frame : frames) {
			if (frame instanceof org.emftext.language.owl.Class) {
				org.emftext.language.owl.Class owlClass = (org.emftext.language.owl.Class) frame;
				// assumption!!! every subclass has just this one super class
				// axiom
				if (owlClass.getSuperClassesDescriptions().size() > 0) {
					Disjunction disj = (Disjunction) owlClass
							.getSuperClassesDescriptions().get(0);
					Conjunction conj = (Conjunction) disj.getConjunctions()
							.get(0);
					Primary primary = (Primary) conj.getPrimaries().get(0);
					if (primary instanceof ClassAtomic) {
						ClassAtomic classAtomic = (ClassAtomic) primary;
						if (classAtomic.getClazz().equals(superclass)) {
							System.out.println("   Subclass: "
									+ owlClass.getIri());
							subclasses.add(owlClass);
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * Adds a new covering axiom to the superclass. For this a disjunction is
	 * added to the class with a conjunction for each subclass. The conjunctions
	 * hold a classAtomic that in turn has the reference to the superclass.
	 */
	private void constructSubclassDescriptions() {
		Disjunction disj = OwlFactory.eINSTANCE.createDisjunction();
		superclass.getSuperClassesDescriptions().add(disj);
		for (org.emftext.language.owl.Class subclass : subclasses) {
			Conjunction conj = OwlFactory.eINSTANCE.createConjunction();
			disj.getConjunctions().add(conj);
			ClassAtomic atomicClass = OwlFactory.eINSTANCE.createClassAtomic();
			conj.getPrimaries().add(atomicClass);
			atomicClass.setClazz(subclass);
		}
	}

}
