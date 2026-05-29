/**
 * File: DegreePlannerTest.java
 * Description: Tests for DegreePlanner.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests DegreePlanner building study plans.
 */
class DegreePlannerTest {

    /**
     * Make course list from course codes for tests.
     *
     * @param codes course codes
     * @return course list
     */
    private List<Course> makeCourses(String[] codes) {
        List<Course> list = new ArrayList<>();

        for (String code : codes) {
            list.add(new Course(code));
        }

        return list;
    }

    /** Max courses saved. */
    @Test
    void checkMaxCoursesAtOnceSaved() {
        List<Course> courses = makeCourses(new String[]{"A"});
        Graph graph = new AdjacencyListGraph(1, true);

        DegreePlanner planner = new DegreePlanner(graph, courses, 4);

        assertEquals(4, planner.getMaxCoursesAtOnce());
    }

    /** One course one study period. */
    @Test
    void checkSingleCourseCreatesOnePeriod() {
        List<Course> courses = makeCourses(new String[]{"A"});
        Graph graph = new AdjacencyListGraph(1, true);

        DegreePlanner planner = new DegreePlanner(graph, courses, 1);
        List<List<Course>> studyPlan = planner.plan();

        assertEquals(1, studyPlan.size());
        assertEquals("A", studyPlan.get(0).get(0).getCode());
    }

    /** Courses added in order. */
    @Test
    void checkCoursesAddedInOrder() {
        List<Course> courses = makeCourses(new String[]{"A", "B", "C"});
        Graph graph = new AdjacencyListGraph(3, true);

        graph.insert(new Edge(0, 1));
        graph.insert(new Edge(1, 2));

        DegreePlanner planner = new DegreePlanner(graph, courses, 2);
        List<List<Course>> studyPlan = planner.plan();

        assertEquals(3, studyPlan.size());
        assertEquals("A", studyPlan.get(0).get(0).getCode());
        assertEquals("B", studyPlan.get(1).get(0).getCode());
        assertEquals("C", studyPlan.get(2).get(0).getCode());
    }

    /** Different courses share study period. */
    @Test
    void checkDiffCoursesSharePeriod() {
        List<Course> courses = makeCourses(new String[]{"A", "B"});
        Graph graph = new AdjacencyListGraph(2, true);

        DegreePlanner planner = new DegreePlanner(graph, courses, 2);
        List<List<Course>> studyPlan = planner.plan();

        assertEquals(1, studyPlan.size());
        assertEquals(2, studyPlan.get(0).size());
    }



}
