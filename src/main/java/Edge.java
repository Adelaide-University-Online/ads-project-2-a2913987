/**
 * File: Edge.java
 * Description: Stores a directed connection between two vertices in the graph.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/



/**
 * Edge defines a connection between two vertices in a graph.
 */
public class Edge {
    private int source;
    private int dest;
    private double weight;

    /**
     * Create edge from source vertex to destination vertex.
     *
     * @param source source vertex
     * @param dest destination vertex
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    /**
     * Get source vertex.
     *
     * @return source vertex
     */
    public int getSource() {
        return source;
    }

    /**
     * Get destination vertex.
     *
     * @return destination vertex
     */
    public int getDest() {
        return dest;
    }

    /**
     * Get edge weight.
     *
     * @return edge weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set source vertex.
     *
     * @param source source vertex
     */
    public void setSource(int source) {
        this.source = source;
    }

    /**
     * Set destination vertex.
     *
     * @param dest destination vertex
     */
    public void setDest(int dest) {
        this.dest = dest;
    }

    /**
     * Set edge weight.
     *
     * @param weight edge weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Compare edge with another edge.
     *
     * @param other edge to compare
     * @return true if source and destination match
     */
    public boolean equals(Edge other) {
        return this.source == other.source
                && this.dest == other.dest;
    }

    /**
     * Return hash code for edge.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return source + dest + (int) weight;
    }

    /**
     * Return string version of this edge.
     *
     * @return edge as string
     */
    @Override
    public String toString() {
        return "" + source + dest;
    }

}
