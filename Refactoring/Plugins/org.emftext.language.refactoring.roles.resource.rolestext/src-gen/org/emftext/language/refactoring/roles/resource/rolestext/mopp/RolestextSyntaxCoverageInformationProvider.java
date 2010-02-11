/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel(),
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRole(),
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleProhibition(),
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleImplication(),
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleAssociation(),
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleComposition(),
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getMultiplicity(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRoleModel(),
		};
	}
	
}
