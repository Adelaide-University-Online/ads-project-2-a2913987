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

import java.util.*;

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
     * Build study plan. Keeps selecting courses with prereqs that
     * are already among plannedCourses.
     *
     * @return list of study periods
     */
    public List<List<Course>> plan() {
        int numV = graph.getNumV();
        Set<Integer> plannedCourses = new HashSet<>();
        List<List<Course>> studyPlan = new ArrayList<>();

        // Create study periods until each course is in a plan
        while (plannedCourses.size() < numV) {
            List<Integer> availableCourses = new LinkedList<>();

            // Find courses not planned with no remaining prerequisites
            for (int v = 0; v < numV; v++) {
                if (!plannedCourses.contains(v) && prereqsDone(v, plannedCourses)) {
                    availableCourses.add(v);
                }
            }

            List<Course> currentPeriod = new LinkedList<>();

            // Can take only maxCoursesAtOnce in currentPeriod
            for (int i = 0; i < availableCourses.size() && currentPeriod.size() < maxCoursesAtOnce; i++) {
                int v = availableCourses.get(i);
                currentPeriod.add(courses.get(v));
                plannedCourses.add(v);
            }

            studyPlan.add(currentPeriod);
        }
        return studyPlan;

    }

    /**
     * Check if prereqs for this course are already in plannedCourses set.
     *
     * @param course course vertex id
     * @param plannedCourses completed course ids
     * @return true if prerequisites are completed
     */
    private boolean prereqsDone(int course, Set<Integer> plannedCourses) {

        // Iterate over course vertex in graph
        for (int i = 0; i < graph.getNumV(); i++) {

            // Get edges of current vertex
            Iterator<Edge> it = graph.edgeIterator(i);

            // Check each edge from this vertex
            while (it.hasNext()) {
                Edge edge = it.next();

                // If this edge is a missing prerequisite for course, course is not ready
                if (edge.getDest() == course && !plannedCourses.contains(edge.getSource())) {
                    return false;
                }
            }
        }

        return true;
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
