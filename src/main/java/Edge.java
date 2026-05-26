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

public class Edge {
    private int source;
    private int dest;
    private double weight;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }


    public int getSource() {
        return source;
    }

    public int getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean equals(Edge other) {
        return this.source == other.source
                && this.dest == other.dest;
    }

    @Override
    public int hashCode() {
        return source + dest + (int) weight;
    }

    @Override
    public String toString() {
        return "" + source + dest;
    }

}
