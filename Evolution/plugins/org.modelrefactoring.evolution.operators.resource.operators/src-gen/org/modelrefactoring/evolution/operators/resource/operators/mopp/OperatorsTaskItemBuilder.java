/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * The OperatorsTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class OperatorsTaskItemBuilder {
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items in " + new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation().getSyntaxName() + " files");
		new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMarkerHelper().removeAllMarkers(resource, IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItem> taskItems = new java.util.ArrayList<org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItem>();
		org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItemDetector taskItemDetector = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItemDetector();
		InputStream inputStream = null;
		try {
			inputStream = resource.getContents();
			String charset = resource.getCharset();
			String content = org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStreamUtil.getContent(inputStream, charset);
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextScanner lexer = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMetaInformation().createLexer();
			lexer.setText(content);
			
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (IOException e) {
			org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsPlugin.logError("Exception while searching for task items", e);
		} catch (CoreException e) {
			org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsPlugin.logError("Exception while searching for task items", e);
		}
		
		try {
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			// Ignore this
		}
		
		for (org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(IMarker.USER_EDITABLE, false);
			markerAttributes.put(IMarker.DONE, false);
			markerAttributes.put(IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(IMarker.MESSAGE, taskItem.getMessage());
			new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsMarkerHelper().createMarker(resource, IMarker.TASK, markerAttributes);
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
