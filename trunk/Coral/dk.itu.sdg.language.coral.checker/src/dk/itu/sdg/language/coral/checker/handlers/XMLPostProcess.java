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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.UIJob;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dk.itu.sdg.language.coral.checker.ResourceUtil;

public class XMLPostProcess extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//get all XML files
		//get DOM
		//modify text nodes
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		Project project = null;

		if (selection.size() == 1) {
			Object[]  selections = selection.toArray();
			Object fstSelection = selections[0];

			if (fstSelection instanceof Project || fstSelection instanceof JavaProject) {
				project = (Project) fstSelection;
				postProcessXMLs(project);
			}
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Information", "Please select a project...");
		}
		
		return null;
	}
		
	
	public void postProcessXMLs(final Project project) {

		UIJob job = new UIJob("Converting BombXMLs to XML") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {

				ArrayList<File> files = ResourceUtil.getFilesFromResource(project);

				monitor.beginTask("Converting...", (files.size() * files.size()));
				
				Map<String,Set<File>> clusteredFiles = ResourceUtil.clusterFiles(files);
				
				Object[] xmlFiles = clusteredFiles.get("xml").toArray();
				
				for (int i = 0; i < xmlFiles.length; i++) {
					File file = (File) xmlFiles[i];
//					file.getLocationUR().
					postProcess(file);
				}
				
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	}
	
	protected void postProcess(File file) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document dom = null;
		try {
			db = dbf.newDocumentBuilder();
			java.io.File ioFile = new java.io.File(file.getLocation().toString());
			dom = db.parse(ioFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (dom != null) {
			Element rootElement = dom.getDocumentElement();
		
			//modification necessary for BOMBXML to work correctly
			//it inserts special tags around text nodes
			modifyTextNodes(rootElement);
		}
		
		OutputFormat format = new OutputFormat(dom);
		format.setIndenting(true);
		format.setPreserveEmptyAttributes(true);
		format.setPreserveSpace(true);
		
		try {
					
			String platformString = file.getLocation().toString();
			//IFile myFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			
//			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(myFile.getLocation().toString())),format);
			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new java.io.File(platformString)),format);
			serializer.serialize(dom);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void modifyTextNodes(Node node) {
		
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);

			if (((currentNode.getNodeType() == Node.CDATA_SECTION_NODE) || (currentNode.getNodeType() == Node.TEXT_NODE)) && !currentNode.getNodeValue().trim().isEmpty()) {
				String content = currentNode.getNodeValue();
				
				if(content.startsWith("[_b0mBxMl_]") && content.endsWith("[_b0mBxMl_]")) {			
					currentNode.setNodeValue(content.replaceAll("\\[_b0mBxMl_\\]",""));
				}
			} else if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				modifyTextNodes(currentNode);
			}
		}
	}
}
