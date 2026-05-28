/**
 * File: AdjacencyListGraph.java
 * Description: Holds graph edges using adjacency lists.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * AdjacencyListGraph holds outgoing edges in a list.
 */
public class AdjacencyListGraph extends AbstractGraph {
    private List<Edge>[] edges;

    /**
     * Create graph with vertex count and direction.
     *
     * @param numV number of vertices
     * @param directed true if graph is directed
     */
    public AdjacencyListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];

        // Each vertex starts with an empty list of outgoing edges
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }

    }
}
