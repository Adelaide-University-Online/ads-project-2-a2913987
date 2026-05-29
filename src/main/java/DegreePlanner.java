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



    /**
     * Compare planner with another planner object.
     *
     * @param obj object to compare
     * @return true if same graph, courses and maxConcurrent
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DegreePlanner)) {
            return false;
        }

        DegreePlanner other = (DegreePlanner) obj;

        return maxCoursesAtOnce == other.maxCoursesAtOnce
                && courses.equals(other.courses)
                && graph.equals(other.graph);
    }

    /**
     * Return hash code for planner.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return (maxCoursesAtOnce + " " + courses + " " + graph).hashCode();
    }

    /**
     * Return string version of this planner.
     *
     * @return planner as string
     */
    @Override
    public String toString() {
        return "Courses: " + courses.size()
                + "\nCourses allowed in Study Period: " + maxCoursesAtOnce;
    }



}
