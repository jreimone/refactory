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
import org.emftext.language.timedAutomata.TimedAutomataPackage;
import org.modelrefactoring.guery.graph.EClassVertex;
import org.modelrefactoring.guery.graph.EPackageGraphAdapter;
import org.modelrefactoring.guery.graph.EReferenceEdge;

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
        JFrame frame = aggregateVisualization(createGraph(getMetamodel()));
        frame.setVisible(true);
        
        Map<String, String> edgeTypeColorMap = new HashMap<String, String>();
		edgeTypeColorMap.put("containment", "200,0,0");
		edgeTypeColorMap.put("reference", "200,200,200");
        frame = radialGraphView(createGraph(getMetamodel()), "edgeType", edgeTypeColorMap, false);
        frame.setVisible(true);
        
        frame = graphView(createGraph(getMetamodel()), "edgeType", edgeTypeColorMap, false);
        frame.setVisible(true);
        
        JFrame closeFrame = new JFrame("Close Frame");
        closeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        closeFrame.setVisible(true);
    }
	
    private static EPackage getMetamodel() {
		return TimedAutomataPackage.eINSTANCE;
	}
	
	private static Graph createGraph(EPackage metamodel) {
    	EPackageGraphAdapter adapter = new EPackageGraphAdapter(metamodel);
    	adapter.initialiseGraph();
    	Iterator<EReferenceEdge> iterator = adapter.getEdges();
    	Graph g = new Graph(true);
    	g.addColumn("name", String.class);
    	g.addColumn("edgeType", String.class);
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
			nodeEdge.setString("edgeType", (edge.getReference().isContainment())?"containment":"reference");
			nodeEdge.setString("name", edge.getReference().getName());
//			nodeEdge.s
		}
		return g;
	}
	
    public static JFrame aggregateVisualization(Graph graph) {
        AggregateVisualization ad = new AggregateVisualization(graph);
        JFrame frame = new JFrame("p r e f u s e  |  a g g r e g a t e d");
        frame.getContentPane().add(ad);
        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
    public static JFrame radialGraphView(Graph graph, String edgeTypePredicate, Map<String, String> edgeTypeColorMap, boolean useStraightLineForSingleEdges){
        UILib.setPlatformLookAndFeel();
        RadialGraphView graphView = new RadialGraphView(graph, "name", edgeTypePredicate, edgeTypeColorMap, useStraightLineForSingleEdges);
        JFrame frame = new JFrame("p r e f u s e  |  r a d i a l g r a p h v i e w");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(graphView);
        frame.pack();
        return frame;
    }
    
    public static JFrame graphView(Graph graph, String edgeTypePredicate, Map<String, String> edgeTypeColorMap, boolean useStraightLineForSingleEdges){
        UILib.setPlatformLookAndFeel();
        final GraphView view = new GraphView(graph, "name", edgeTypePredicate, edgeTypeColorMap, useStraightLineForSingleEdges);
        JFrame frame = new JFrame("p r e f u s e  |  g r a p h v i e w");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
