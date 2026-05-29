/**
 * File: DegreeFileReaderTest.java
 * Description: Tests the DegreeFileReader class.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

/**
 * Tests DegreeGraphBuilder course building
 */
class DegreeGraphBuilderTest {

    private static final String SAMPLE =
            "A, B, C\n" + "A, B\n" + "B, C\n";

    /** All courses are read. */
    @Test
    void checkAllCoursesRead() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner(SAMPLE));

        assertEquals(3, gbuild.getCourseCount());
    }


    /** Vertex ids are assigned to courses. */
    @Test
    void checkCourseVertexIdsAssigned() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner(SAMPLE));

        assertEquals(0, gbuild.getVertexId("A"));
        assertEquals(1, gbuild.getVertexId("B"));
        assertEquals(2, gbuild.getVertexId("C"));
    }

    /** Prerequisite edges are added. */
    @Test
    void checkPrerequisiteEdgesAdded() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner(SAMPLE));

        Graph graph = gbuild.getGraph();

        int a = gbuild.getVertexId("A");
        int b = gbuild.getVertexId("B");
        int c = gbuild.getVertexId("C");

        assertTrue(graph.isEdge(b, a));
        assertTrue(graph.isEdge(c, b));
    }


    /** Graph is directed. */
    @Test
    void checkGraphIsDirected() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner(SAMPLE));

        assertTrue(gbuild.getGraph().isDirected());
    }






    /** Simple line splits into codes. */
    @Test
    void checkSimpleLineSplitsIntoCodes() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner("A,B,C\n"));

        assertEquals(3, gbuild.getCourseCount());
        assertEquals(0, gbuild.getVertexId("A"));
        assertEquals(1, gbuild.getVertexId("B"));
        assertEquals(2, gbuild.getVertexId("C"));
    }

    /** Trailing space ignored. */
    @Test
    void checkTrailingSpaceIgnored() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner("INFT3046, INFS3081 \n"));

        assertEquals(2, gbuild.getCourseCount());
        assertEquals(1, gbuild.getVertexId("INFS3081"));
    }

    /** Empty code between commas ignored. */
    @Test
    void checkEmptyCodeIgnored() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner("COMP1043, , MATH1080\n"));

        assertEquals(2, gbuild.getCourseCount());
        assertEquals(0, gbuild.getVertexId("COMP1043"));
        assertEquals(1, gbuild.getVertexId("MATH1080"));
    }

    /** Empty line returns no courses. */
    @Test
    void checkEmptyLineReturnsNoCourses() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner("\n"));

        assertEquals(0, gbuild.getCourseCount());
    }


}
