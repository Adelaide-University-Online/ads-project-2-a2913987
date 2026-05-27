/**
 * File: EdgeTest.java
 * Description: Tests the Edge class.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Tests if edges store vertices, weights, equality, hash codes and returning string.
 */
class EdgeTest {

    /** Source is saved.*/
    @Test
    void checkSourceIsSaved() {
        Edge edge = new Edge(1, 2);

        assertEquals(1, edge.getSource());
    }

    /** Destination  is saved.*/
    @Test
    void checkDestinationIsSaved() {
        Edge edge = new Edge(1, 2);

        assertEquals(2, edge.getDest());
    }

    /** Edge weight starts at zero.*/
    @Test
    void checkWeightStartsAtZero() {
        Edge edge = new Edge(1, 2);

        assertEquals(0.0, edge.getWeight());
    }

    /** Source vertex changes*/
    @Test
    void checkSourceChanged() {
        Edge edge = new Edge(1, 2);

        edge.setSource(3);

        assertEquals(3, edge.getSource());
    }

    /** Destination vertex changes*/
    @Test
    void checkDestinationChanged() {
        Edge edge = new Edge(1, 2);

        edge.setDest(4);

        assertEquals(4, edge.getDest());
    }

    /** Edge weight changes. */
    @Test
    void checkWeightChanged() {
        Edge edge = new Edge(1, 2);

        edge.setWeight(5.5);

        assertEquals(5.5, edge.getWeight());
    }


    /** Edges same source and destination equal. */
    @Test
    void checkSameEdgesEqual() {
        Edge edge1 = new Edge(1, 2);
        Edge edge2 = new Edge(1, 2);

        assertEquals(edge1, edge2);
    }

    /** Edges same source, destination, weight are equal. */
    @Test
    void checkSameEdgesWithWeightEqual() {
        Edge edge1 = new Edge(1, 2, 2);
        Edge edge2 = new Edge(1, 2, 2);

        assertEquals(edge1, edge2);
    }

    /** Edge does not equal null.*/
    @Test
    void checkEdgeDoesNotEqualNull() {
        Edge edge = new Edge(1, 2);

        assertNotEquals(null, edge);
    }

    /** Equal edges same hash code. */
    @Test
    void checkSameEdgesHaveSameHashCode() {
        Edge edge1 = new Edge(1, 2, 3);
        Edge edge2 = new Edge(1, 2, 3);

        assertEquals(edge1, edge2);
        assertEquals(edge1.hashCode(), edge2.hashCode());
    }

    /** HashSet stores separately edges with different weights . */
    @Test
    void checkHashSetNoStoreSameEdgeTwice() {
        Edge edge1 = new Edge(1, 2);
        Edge edge2 = new Edge(1, 2);

        edge1.setWeight(3.0);
        edge2.setWeight(7.0);

        Set<Edge> edges = new HashSet<>();
        edges.add(edge1);
        edges.add(edge2);

        assertNotEquals(1, edges.size());
    }

    /** Edges with different weights have different hash codes. */
    @Test
    public void testHashCodeConsistentWithEquals() {
        Edge edge1 = new Edge(3, 7, 1.0);
        Edge edge2 = new Edge(3, 7, 50.0);
        assertNotEquals(edge1.hashCode(), edge2.hashCode());
    }

    /** toString shows source, destination and weight clearly.*/
    @Test
    void checkToStringShowsEdgeClearly() {
        Edge edge = new Edge(1, 2);
        assertEquals("Source: 1, Dest: 2, Weight: 0.0", edge.toString());
    }

}
