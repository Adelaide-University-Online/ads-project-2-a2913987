/**
 * File: AdjacencyListGraphTest.java
 * Description: Tests the AdjacencyListGraph class.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

/**
 * Tests graph edges stored, found, and handled by direction.
 */
class AdjacencyListGraphTest {

    /** Vertex count saved. */
    @Test
    void checkVertexCountSaved() {
        AdjacencyListGraph graph = new AdjacencyListGraph(3, true);

        assertEquals(3, graph.getNumV());
    }

    /** Directed graph saves directed setting. */
    @Test
    void checkDirectedGraphSaved() {
        AdjacencyListGraph graph = new AdjacencyListGraph(2, true);

        assertTrue(graph.isDirected());
    }


    /** Inserted edge returned. */
    @Test
    void checkInsertedEdgeReturned() {
        AdjacencyListGraph graph = new AdjacencyListGraph(3, true);

        graph.insert(new Edge(0, 1, 2.0));

        Edge edge = graph.getEdge(0, 1);

        assertNotNull(edge);
        assertEquals(0, edge.getSource());
        assertEquals(1, edge.getDest());
        assertEquals(2.0, edge.getWeight());
    }

    /** Missing edge returns null. */
    @Test
    void checkMissingEdgeReturnsNull() {
        AdjacencyListGraph graph = new AdjacencyListGraph(3, true);

        assertNull(graph.getEdge(0, 1));
    }

    /** Undirected edge goes both ways. */
    @Test
    void checkUndirectedEdgeGoesBothWays() {
        AdjacencyListGraph graph = new AdjacencyListGraph(3, false);

        graph.insert(new Edge(0, 1));

        assertTrue(graph.isEdge(0, 1));
        assertTrue(graph.isEdge(1, 0));
    }

    /** Reverse edge keeps same weight. */
    @Test
    void checkReverseEdgeKeepsWeight() {
        AdjacencyListGraph graph = new AdjacencyListGraph(3, false);

        graph.insert(new Edge(0, 1, 5.5));

        Edge edge = graph.getEdge(1, 0);

        assertNotNull(edge);
        assertEquals(5.5, edge.getWeight());
    }

    /** Edge iterator returns outgoing edge. */
    @Test
    void checkEdgeIteratorReturnsOutgoingEdge() {
        AdjacencyListGraph graph = new AdjacencyListGraph(3, true);

        graph.insert(new Edge(0, 1));

        Iterator<Edge> iterator = graph.edgeIterator(0);

        assertTrue(iterator.hasNext());

        Edge edge = iterator.next();

        assertEquals(0, edge.getSource());
        assertEquals(1, edge.getDest());
        assertFalse(iterator.hasNext());
    }



    /** Equal graphs same hash code. */
    @Test
    void checkEqualGraphsSameHashCode() {
        AdjacencyListGraph graph1 = new AdjacencyListGraph(2, true);
        AdjacencyListGraph graph2 = new AdjacencyListGraph(2, true);

        graph1.insert(new Edge(0, 1));
        graph2.insert(new Edge(0, 1));

        assertEquals(graph1, graph2);
        assertEquals(graph1.hashCode(), graph2.hashCode());
    }

    /** Different edges not equal. */
    @Test
    void checkDifferentEdgesNotEqual() {
        AdjacencyListGraph graph1 = new AdjacencyListGraph(2, true);
        AdjacencyListGraph graph2 = new AdjacencyListGraph(2, true);

        graph1.insert(new Edge(0, 1));

        assertNotEquals(graph1, graph2);
    }

    /** toString shows vertex. */
    @Test
    void checkToStringShowsVertex() {
        AdjacencyListGraph graph = new AdjacencyListGraph(2, true);

        graph.insert(new Edge(0, 1));

        assertTrue(graph.toString().contains("0:"));
    }

}
