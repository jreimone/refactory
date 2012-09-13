package org.qualitune.ecore.graph.visualization;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import nz.ac.massey.cs.guery.GraphAdapter;
import nz.ac.massey.cs.guery.adapters.jung.JungAdapter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.qualitune.ecore.graph.GObject;
import org.qualitune.ecore.graph.impl.GReference;

import prefuse.data.Edge;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.visualization.Visualizations;

public class VisualizeGcoreModel extends AbstractHandler {

	private AdapterFactoryLabelProvider labelProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelectionChecked(event);
		if(currentSelection instanceof IStructuredSelection){
			IStructuredSelection selection = (IStructuredSelection) currentSelection;
			GObject graph = ((GObject) selection.getFirstElement()).gGraph();
			JungAdapter<GObject, GReference> adapter = new JungAdapter<GObject, GReference>(graph);
			// prefuse
			Graph prefuseGraph = createPrefuseGraph(adapter);
			
			Map<String, String> edgeTypeColorMap = new HashMap<String, String>();
			edgeTypeColorMap.put("containment", "200,0,0");
			edgeTypeColorMap.put("reference", "200,200,200");
			JFrame frame = Visualizations.radialGraphView(prefuseGraph, "edgeType", edgeTypeColorMap, false);
			frame.setVisible(true);
	        
//			frame = Visualizations.aggregateVisualization(prefuseGraph);
//	        frame.setVisible(true);
	        
//	        frame = Visualizations.graphView(prefuseGraph);
//	        frame.setVisible(true);
		}
		return null;
	}

	private Graph createPrefuseGraph(GraphAdapter<GObject, GReference> adapter) {
		Iterator<GReference> iterator = adapter.getEdges();
		Graph g = new Graph(true);
		g.addColumn("name", String.class);
		g.addColumn("edgeType", String.class);
		Map<GObject, Node> vertexNodeMap = new HashMap<GObject, Node>();
		while (iterator.hasNext()) {
			GReference edge = iterator.next();
			GObject start = adapter.getStart(edge);
			GObject end = adapter.getEnd(edge);
			Node startNode = vertexNodeMap.get(start);
			if(startNode == null){
				startNode = g.addNode();
				startNode.setString("name", getLabel(start));
				vertexNodeMap.put(start, startNode);
			}
			Node endNode = vertexNodeMap.get(end);
			if(endNode == null){
				endNode = g.addNode();
				endNode.setString("name", getLabel(end));
				vertexNodeMap.put(end, endNode);
			}
			Edge nodeEdge = g.addEdge(startNode, endNode);
			nodeEdge.setString("edgeType", (edge.getReference().isContainment())?"containment":"reference");
			nodeEdge.setString("name", edge.getReference().getName());
		}
		return g;
	}

	private String getLabel(GObject element){
		if(labelProvider == null){
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		}
		return labelProvider.getText(element);
	}
}
