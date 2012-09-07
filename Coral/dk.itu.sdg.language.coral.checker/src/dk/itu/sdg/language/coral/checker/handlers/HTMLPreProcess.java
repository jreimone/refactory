package dk.itu.sdg.language.coral.checker.handlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dk.itu.sdg.language.coral.checker.ResourceUtil;

public class HTMLPreProcess  extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//get all XML files
		//get DOM
		//modify text nodes
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		IResource project = null;

		if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];

			if (fstSelection instanceof Project || fstSelection instanceof JavaProject) {
				project = (IResource) fstSelection;
				preProcessHTMLs(project);
			} else if (fstSelection instanceof Resource || fstSelection instanceof File) {
				project = ((IResource)fstSelection).getProject();
				preProcessHTMLs(project);
			}
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select a project...");
		}
		
		return null;
	}
	
	public void preProcessHTMLs(final IResource project) {

		Job job = new Job("Bombing HTMLs") {
			@Override
			public IStatus run(IProgressMonitor monitor) {

				ArrayList<File> files = ResourceUtil.getFilesFromResource(project);

				monitor.beginTask("Converting...", (files.size() * files.size()));
				
				Map<String,Set<File>> clusteredFiles = ResourceUtil.clusterFiles(files);
				
				Object[] htmlFiles = clusteredFiles.get("html").toArray();	
				
				for (int i = 0; i < htmlFiles.length; i++) {
					File file = (File) htmlFiles[i];
					preProcess(file);
				}
				
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	}
	
	protected void preProcess(File file) {
		
		//TODO: implement me!!!
		//Figure out which parser and serializer to use!!!
		
		

	}
	
	private void modifyTextNodes(Node node) {
		
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);

			if (((currentNode.getNodeType() == Node.CDATA_SECTION_NODE) || (currentNode.getNodeType() == Node.TEXT_NODE)) && !currentNode.getNodeValue().trim().isEmpty()) {
				String content = currentNode.getNodeValue();
				
				if(!content.startsWith("[_b0mBxMl_]") && !content.endsWith("[_b0mBxMl_]")) {			
					currentNode.setNodeValue("[_b0mBxMl_]" + content + "[_b0mBxMl_]");
				}
			} else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				modifyTextNodes(currentNode);
			}
		}
	}

}
