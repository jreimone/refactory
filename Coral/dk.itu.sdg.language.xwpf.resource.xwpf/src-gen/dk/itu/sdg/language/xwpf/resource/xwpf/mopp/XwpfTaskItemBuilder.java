/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * The XwpfTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class XwpfTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItem> taskItems = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItem>();
		dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItemDetector taskItemDetector = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStreamUtil.getContent(inputStream);
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextScanner lexer = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMetaInformation().createLexer();
			lexer.setText(content);
			
			dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfPlugin.logError("Exception while searching for task items", e);
		}
		
		for (dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
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
