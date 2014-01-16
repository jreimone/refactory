/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class TestpropertiesNewFileContentProvider {
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesMetaInformation getMetaInformation() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new EClass[] {
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(),
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
		EObject root = new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (IOException e) {
			new org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextPrinter getPrinter(OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource());
	}
	
}
