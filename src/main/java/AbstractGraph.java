/**
 * File: AbstractGraph.java
 * Description: Provide common graph fields and getters for children.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

/**
 * AbstractGraph stores shared info for graph classes.
 */
public abstract class AbstractGraph implements Graph {
    private int numV;
    private boolean directed;

    /**
     * Create graph with vertex count and directed/not directed
     *
     * @param numV number of vertices
     * @param directed true if graph is directed
     */
    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    /**
     * Get number of vertices.
     *
     * @return number of vertices
     */
    @Override
    public int getNumV() {
        return numV;
    }

    /**
     * Check if graph is directed.
     *
     * @return true if directed
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

}
