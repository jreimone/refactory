/**
 * 
 */
package prefuse.visualization;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.qualitune.evolution.guery.graph.EClassVertex;
import org.qualitune.evolution.guery.graph.EPackageGraphAdapter;
import org.qualitune.evolution.guery.registry.EReferenceEdge;

import prefuse.data.Edge;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.demos.GraphView;
import prefuse.demos.RadialGraphView;
import prefuse.util.ui.UILib;

/**
 * @author jreimann
 *
 */
public class Visualizations {
	
	public static void main(String[] argv) {
        JFrame frame = aggregateVisualization(createGraph(getResource()));
        frame.setVisible(true);
        
        frame = radialGraphView(createGraph(getResource()));
        frame.setVisible(true);
        
        frame = graphView(createGraph(getResource()));
        frame.setVisible(true);
    }
	
    private static Resource getResource() {
		EPackage.Registry.INSTANCE.put(PL0Package.eNS_URI, PL0Package.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(new Pl0MetaInformation().getSyntaxName(), new Pl0ResourceFactory());
		EPackage pl0MM = (EPackage) EPackage.Registry.INSTANCE.get(PL0Package.eNS_URI);
		return pl0MM.eResource();
	}
	
	private static Graph createGraph(Resource resource) {
    	EPackageGraphAdapter adapter = new EPackageGraphAdapter(resource);
    	Iterator<EReferenceEdge> iterator = adapter.getEdges();
    	Graph g = new Graph();
    	g.addColumn("name", String.class);
    	Map<EClassVertex, Node> vertexNodeMap = new HashMap<EClassVertex, Node>();
    	while (iterator.hasNext()) {
			EReferenceEdge edge = iterator.next();
			EClassVertex start = (EClassVertex) adapter.getStart(edge);
			EClassVertex end = (EClassVertex) adapter.getEnd(edge);
			Node startNode = vertexNodeMap.get(start);
			if(startNode == null){
				startNode = g.addNode();
				startNode.setString("name", start.getEClass().getName());
				vertexNodeMap.put(start, startNode);
			}
			Node endNode = vertexNodeMap.get(end);
			if(endNode == null){
				endNode = g.addNode();
				endNode.setString("name", end.getEClass().getName());
				vertexNodeMap.put(end, endNode);
			}
			Edge nodeEdge = g.addEdge(startNode, endNode);
			nodeEdge.setString("name", edge.getReference().getName());
		}
		return g;
	}
	
    public static JFrame aggregateVisualization(Graph graph) {
        AggregateVisualization ad = new AggregateVisualization(graph);
        JFrame frame = new JFrame("p r e f u s e  |  a g g r e g a t e d");
        frame.getContentPane().add(ad);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
    public static JFrame radialGraphView(Graph graph){
        UILib.setPlatformLookAndFeel();
        RadialGraphView graphView = new RadialGraphView(graph, "name");
        JFrame frame = new JFrame("p r e f u s e  |  r a d i a l g r a p h v i e w");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(graphView);
        frame.pack();
        return frame;
    }
    
    public static JFrame graphView(Graph graph){
        UILib.setPlatformLookAndFeel();
        final GraphView view = new GraphView(graph, "name");
        JFrame frame = new JFrame("p r e f u s e  |  g r a p h v i e w");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                view.getM_vis().run("layout");
            }
            public void windowDeactivated(WindowEvent e) {
                view.getM_vis().cancel("layout");
            }
        });
        return frame;
    }
}
