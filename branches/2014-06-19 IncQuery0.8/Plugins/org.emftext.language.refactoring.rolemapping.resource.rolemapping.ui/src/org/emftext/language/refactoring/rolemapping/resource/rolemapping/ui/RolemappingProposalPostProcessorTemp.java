/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RolemappingFactory;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingPrinter2;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class RolemappingProposalPostProcessorTemp {
	
	public List<RolemappingCompletionProposal> process(List<RolemappingCompletionProposal> proposals) {
		RoleMapping mapping = getCurrentRoleMapping(proposals);
		RolemappingCompletionProposal proposal = createProposal(mapping);
		List<RolemappingCompletionProposal> newProposals = new ArrayList<RolemappingCompletionProposal>();
		newProposals.add(proposal);
		newProposals.addAll(proposals);
		return newProposals;
	}

	private RolemappingCompletionProposal createProposal(RoleMapping mapping) {
		List<ConcreteMapping> concreteMappings = proposeConcreteMappings(mapping);
		String proposalString = "";
		for (ConcreteMapping concreteMapping : concreteMappings) {
			String string = getStringForConcreteMapping(concreteMapping);
			proposalString += string + "\n";
		}
		if(!"".equals(proposalString)){
			RolemappingCompletionProposal newProposal = new RolemappingCompletionProposal(null, null, "", true, null, null);
			newProposal.setInsertString(proposalString);
			newProposal.setDisplayString("Autocomplete mapping");
			return newProposal;
		}
		return null;
	}

	private String getStringForConcreteMapping(ConcreteMapping concreteMapping) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		RolemappingPrinter2 printer = new RolemappingPrinter2(stream, null);
		try {
			printer.print(concreteMapping);
			return stream.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private List<ConcreteMapping> proposeConcreteMappings(RoleMapping mapping) {
		RoleModel roleModel = mapping.getMappedRoleModel();
		EPackage metamodel = mapping.getOwningMappingModel().getTargetMetamodel();
		
		Role firstRole = roleModel.getRoles().get(0);
		EClass firstMetaclass = (EClass) metamodel.getEClassifiers().get(0);
		
		Role secondRole = roleModel.getRoles().get(1);
		EClass secondMetaclass = (EClass) metamodel.getEClassifiers().get(1);
		
		ConcreteMapping firstConcreteMapping = RolemappingFactory.eINSTANCE.createConcreteMapping();
		firstConcreteMapping.setRole(firstRole);
		firstConcreteMapping.setMetaclass(firstMetaclass);
		
		ConcreteMapping secondConcreteMapping = RolemappingFactory.eINSTANCE.createConcreteMapping();
		secondConcreteMapping.setRole(secondRole);
		secondConcreteMapping.setMetaclass(secondMetaclass);
		List<ConcreteMapping> mappings = new ArrayList<ConcreteMapping>();
		mappings.add(firstConcreteMapping);
		mappings.add(secondConcreteMapping);
		return mappings;
	}

	private RoleMapping getCurrentRoleMapping(List<RolemappingCompletionProposal> proposals) {
		RoleMapping mapping = null;
		if(proposals != null){
			RolemappingCompletionProposal proposal = proposals.get(0);
			EObject container = proposal.getContainer();
			if(container instanceof ConcreteMapping){
				mapping = (RoleMapping) ((ConcreteMapping) container).eContainer();
			}
		}
		return mapping;
	}
	
}
