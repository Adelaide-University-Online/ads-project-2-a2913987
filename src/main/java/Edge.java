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
        this.weight = 0.0;
    }

    /**
     * Create edge from source, destination, weight.
     *
     * @param source source vertex
     * @param dest destination vertex
     * @param weight edges weight
     */
    public Edge(int source, int dest, double weight) {
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
     * Compare edge with another edge object.
     *
     * @param o object to compare
     * @return true if object is Edge with same source, destination, weight
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Edge other)) {return false;}

        return this.source == other.source
                && this.dest == other.dest
                && this.weight == other.weight;
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
