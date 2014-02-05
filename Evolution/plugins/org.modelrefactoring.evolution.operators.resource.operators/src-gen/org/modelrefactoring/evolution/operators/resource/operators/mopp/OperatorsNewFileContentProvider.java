/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class OperatorsNewFileContentProvider {
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsMetaInformation getMetaInformation() {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new EClass[] {
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getDELETE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE(),
			org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVAR(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(EClass[] startClasses, EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(EClass eClass, EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		EObject root = new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (IOException e) {
			new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextPrinter getPrinter(OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource());
	}
	
}
