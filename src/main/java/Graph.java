/**
 * File: Graph.java
 * Description: Defines graph for the degree planner.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.util.Iterator;

/**
 * Graph defines what's used by graph classes.
 */
public interface Graph {

    /**
     * Get number of vertices.
     *
     * @return number of vertices
     */
    int getNumV();

    /**
     * Check if graph is directed.
     *
     * @return true if directed
     */
    boolean isDirected();

    /**
     * Insert edge into graph.
     *
     * @param edge edge to insert
     */
    void insert(Edge edge);

    /**
     * Check if edge exists.
     *
     * @param source source vertex
     * @param dest destination vertex
     * @return true if edge exists
     */
    boolean isEdge(int source, int dest);

    /**
     * Get edge from source to destination.
     *
     * @param source source vertex
     * @param dest destination vertex
     * @return edge if found
     */
    Edge getEdge(int source, int dest);

    /**
     * Get edges leaving source vertex.
     *
     * @param source source vertex
     * @return iterator of edges
     */
    Iterator<Edge> edgeIterator(int source);

}
