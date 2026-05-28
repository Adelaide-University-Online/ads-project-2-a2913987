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

    /**
     * Insert edge into graph
     *
     * @param edge edge to insert
     */
    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);

        if (!isDirected()) {
            edges[edge.getDest()].add(
                    new Edge(edge.getDest(), edge.getSource(), edge.getWeight())
            );
        }
    }


    /**
     * Check if edge exists
     *
     * @param source source vertex
     * @param dest destination vertex
     * @return true if edge exists
     */
    @Override
    public boolean isEdge(int source, int dest) {
        for (Edge edge : edges[source]) {
            if (edge.getSource() == source && edge.getDest() == dest) {
                return true;
            }

        }

        return false;
    }

    /**
     * Get edge from source to destination
     *
     * @param source source vertex
     * @param dest destination vertex
     * @return edge if found
     */
    @Override
    public Edge getEdge(int source, int dest) {
        for (Edge edge : edges[source]) {
            if (edge.getSource() == source && edge.getDest() == dest) {

                return edge;
            }
        }

        return null;
    }

    /**
     * Get edges leaving source vertex
     *
     * @param source source vertex
     * @return iterator of edges
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    /**
     * Compare graph with another graph object.
     *
     * @param obj object to compare
     * @return true if graphs are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjacencyListGraph)) {
            return false;
        }
        AdjacencyListGraph other = (AdjacencyListGraph) obj;
        if (getNumV() != other.getNumV() || isDirected() != other.isDirected()) {
            return false;
        }

        // Check that each adjacency list matches
        for (int i = 0; i < getNumV(); i++) {
            if (!edges[i].equals(other.edges[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return hash code for graph.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = 42 * getNumV() + (isDirected() ? 1 : 0);

        // Include adjacency list in hash code
        for (List<Edge> list : edges) {
            result = 42 * result + list.hashCode();
        }

        return result;
    }

    /**
     * Return string version of this graph.
     *
     * @return graph as string
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < getNumV(); i++) {
            output.append(i).append(": ").append(edges[i]).append("\n");
        }
        return output.toString();
    }

}
