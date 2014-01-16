/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * The TestpropertiesTaskItemBuilder is used to find task items in text documents.
 * The current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class TestpropertiesTaskItemBuilder {
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper().removeAllMarkers(resource, IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItem> taskItems = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItem>();
		org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItemDetector taskItemDetector = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItemDetector();
		InputStream inputStream = null;
		try {
			inputStream = resource.getContents();
			String charset = resource.getCharset();
			String content = org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesStreamUtil.getContent(inputStream, charset);
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextScanner lexer = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation().createLexer();
			lexer.setText(content);
			
			org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (IOException e) {
			org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesPlugin.logError("Exception while searching for task items", e);
		} catch (CoreException e) {
			org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesPlugin.logError("Exception while searching for task items", e);
		}
		
		try {
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			// Ignore this
		}
		
		for (org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(IMarker.USER_EDITABLE, false);
			markerAttributes.put(IMarker.DONE, false);
			markerAttributes.put(IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(IMarker.MESSAGE, taskItem.getMessage());
			new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMarkerHelper().createMarker(resource, IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return IMarker.TASK;
	}
	
	public boolean isInBinFolder(IFile resource) {
		IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
