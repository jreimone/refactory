/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * The GueryTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items.
 */
public class GueryTaskItemBuilder extends org.qualitune.guery.resource.guery.mopp.GueryBuilderAdapter {
	
	/**
	 * The ID of the item task builder.
	 */
	public final static String BUILDER_ID = "org.qualitune.guery.resource.guery.taskItemBuilder";
	
	@Override	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.qualitune.guery.resource.guery.mopp.GueryTaskItem> taskItems = new java.util.ArrayList<org.qualitune.guery.resource.guery.mopp.GueryTaskItem>();
		org.qualitune.guery.resource.guery.mopp.GueryTaskItemDetector taskItemDetector = new org.qualitune.guery.resource.guery.mopp.GueryTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = org.qualitune.guery.resource.guery.util.GueryStreamUtil.getContent(inputStream);
			org.qualitune.guery.resource.guery.IGueryTextScanner lexer = new org.qualitune.guery.resource.guery.mopp.GueryMetaInformation().createLexer();
			lexer.setText(content);
			
			org.qualitune.guery.resource.guery.IGueryTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			org.qualitune.guery.resource.guery.mopp.GueryPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			org.qualitune.guery.resource.guery.mopp.GueryPlugin.logError("Exception while searching for task items", e);
		}
		
		for (org.qualitune.guery.resource.guery.mopp.GueryTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new org.qualitune.guery.resource.guery.mopp.GueryMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
