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


class EdgeTest {
        @Test
    void checkSourceIsSaved() {
        Edge edge = new Edge(1, 2);

        assertEquals(1, edge.getSource());
    }

    @Test
    void checkDestinationIsSaved() {
        Edge edge = new Edge(1, 2);

        assertEquals(2, edge.getDest());
    }

    @Test
    void checkWeightStartsAtZero() {
        Edge edge = new Edge(1, 2);

        assertEquals(0.0, edge.getWeight());
    }

    @Test
    void checkSourceChanged() {
        Edge edge = new Edge(1, 2);

        edge.setSource(3);

        assertEquals(3, edge.getSource());
    }

    @Test
    void checkDestinationChanged() {
        Edge edge = new Edge(1, 2);

        edge.setDest(4);

        assertEquals(4, edge.getDest());
    }

    @Test
    void checkWeightChanged() {
        Edge edge = new Edge(1, 2);

        edge.setWeight(5.5);

        assertEquals(5.5, edge.getWeight());
    }


    @Test
    void checkSameEdgesEqual() {
        Edge edge1 = new Edge(1, 2);
        Edge edge2 = new Edge(1, 2);

        assertEquals(edge1, edge2);
    }



}
