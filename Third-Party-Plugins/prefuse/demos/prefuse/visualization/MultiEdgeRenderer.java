/**
 * 
 */
package prefuse.visualization;

import java.awt.geom.Point2D;
import java.util.Iterator;

import prefuse.data.Edge;
import prefuse.data.Node;
import prefuse.render.EdgeRenderer;
import prefuse.visual.EdgeItem;

/**
 * @author jreimann
 *
 */
public class MultiEdgeRenderer extends EdgeRenderer {
	
	private boolean useStraightLineForSingleEdges = true;

	public MultiEdgeRenderer(boolean useStraightLineForSingleEdges){
		this.useStraightLineForSingleEdges = useStraightLineForSingleEdges;
	}
	
    @Override
    protected void getCurveControlPoints(EdgeItem eitem, Point2D[] cp, double x1, double y1, double x2, double y2) {
        // how many from '1' to '2'?
        Node sourceNode = eitem.getSourceNode();
        Node targetNode = eitem.getTargetNode();
        Iterator edges = sourceNode.edges();
        // number of equal edges = same target and source
        int noOfEqualEdges = 0;
        // number of nearequal edges = same nodes, but any order target and
        // source
        int noOfSameNodeEdges = 0;
        int myEdgeIndex = 0;
        int row = eitem.getRow();
        while (edges.hasNext()) {
            Edge edge = (Edge) edges.next();
            int edgeRow = edge.getRow();
            if (edge.getSourceNode() == sourceNode && edge.getTargetNode() == targetNode) {
                if (row == edgeRow) {
                    myEdgeIndex = noOfEqualEdges;
                }
                noOfEqualEdges++;
                noOfSameNodeEdges++;
            } else if (edge.getSourceNode() == targetNode && edge.getTargetNode() == sourceNode) {
                noOfSameNodeEdges++;
            }
        }
        double dx = x2 - x1, dy = y2 - y1;

        // modify to add an offset relative to what this edge's index is
        dx = dx * (1 + myEdgeIndex);
        dy = dy * (1 + myEdgeIndex);
        cp[0].setLocation(x1 + 2 * dx / 3, y1);
        cp[1].setLocation(x2 - dx / 8, y2 - dy / 8);
        if (useStraightLineForSingleEdges && myEdgeIndex == 0 && noOfSameNodeEdges == 1) {
            cp[0].setLocation(x2, y2);
            cp[1].setLocation(x1, y1);
        }
    }

    public boolean isUseStraightLineForSingleEdges() {
        return useStraightLineForSingleEdges;
    }

    public void setUseStraightLineForSingleEdges(boolean useStraightLineForSingleEdges) {
        this.useStraightLineForSingleEdges = useStraightLineForSingleEdges;
    }

}
