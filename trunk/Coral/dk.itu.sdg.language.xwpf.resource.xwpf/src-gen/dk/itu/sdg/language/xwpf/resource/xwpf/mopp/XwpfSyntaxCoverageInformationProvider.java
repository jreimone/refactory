/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getContent(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getBodyElement(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getComment(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getFootnote(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getFooter(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getHeader(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getHyperlink(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getNumbering(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getPictureData(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getParagraph(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getTable(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getRun(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getPart(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getBody(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getContent(),
			dk.itu.sdg.language.xwpf.XwpfPackage.eINSTANCE.getDocument(),
		};
	}
	
}
