/**
 * File: DegreePlanner.java
 * Description: Organises courses into study periods.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.util.List;

/**
 * DegreePlanner builds course order.
 */
public class DegreePlanner {

    private final Graph graph;
    private final List<Course> courses;
    private final int maxCoursesAtOnce;

    /**
     * Create planner.
     *
     * @param graph prerequisite graph
     * @param courses course list
     * @param maxCoursesAtOnce max courses per study period
     * @throws IllegalArgumentException if inputs are invalid
     */
    public DegreePlanner(Graph graph, List<Course> courses, int maxCoursesAtOnce) {
        if (graph == null || courses == null) {
            throw new IllegalArgumentException("Missing Graph and courses");
        }

        this.graph = graph;
        this.courses = courses;
        this.maxCoursesAtOnce = maxCoursesAtOnce;
    }

    /**
     * Get max courses per study period.
     *
     * @return max concurrent courses
     */
    public int getMaxCoursesAtOnce() {
        return maxCoursesAtOnce;
    }

}
