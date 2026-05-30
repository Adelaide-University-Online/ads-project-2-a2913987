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
     * Build study plan by taking courses with no prerequisites left.
     *
     * @return list of study periods
     */
    public List<List<Course>> plan() {

        int numCourses = graph.getNumV();
        int[] prereqsLeft = new int[numCourses];

        // Count prereqs for each course
        for (int course = 0; course < numCourses; course++) {
            Iterator<Edge> edgeIt = graph.edgeIterator(course);

            while (edgeIt.hasNext()) {
                Edge edge = edgeIt.next();
                int courseAfter = edge.getDest();

                prereqsLeft[courseAfter]++;
            }
        }

        List<Integer> canUseNow = new ArrayList<>();

        // Find courses with no prereqs left
        for (int course = 0; course < numCourses; course++) {
            if (prereqsLeft[course] == 0) {
                canUseNow.add(course);
            }
        }

        List<List<Course>> studyPlan = new ArrayList<>();

        while (!canUseNow.isEmpty()) {
            List<Course> thisPeriod = new ArrayList<>();
            List<Integer> coursesTaken = new ArrayList<>();

            // Take up to maxCoursesAtOnce courses this period
            for (int i = 0; i < canUseNow.size()
                    && coursesTaken.size() < maxCoursesAtOnce; i++) {
                int course = canUseNow.get(i);

                coursesTaken.add(course);
                thisPeriod.add(courses.get(course));
            }

            studyPlan.add(thisPeriod);

            List<Integer> nextCourses = new ArrayList<>();

            // Keep courses that were available but not used
            for (int course : canUseNow) {
                if (!coursesTaken.contains(course)) {
                    nextCourses.add(course);
                }
            }

            // Only coursesTaken can unlock later courses
            for (int course : coursesTaken) {
                Iterator<Edge> it = graph.edgeIterator(course);

                while (it.hasNext()) {
                    Edge edge = it.next();
                    int nextCourse = edge.getDest();

                    prereqsLeft[nextCourse]--;

                    if (prereqsLeft[nextCourse] == 0) {
                        nextCourses.add(nextCourse);
                    }
                }
            }

            canUseNow = nextCourses;
        }
        

        return studyPlan;

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
