/**
 * File: Runner.java
 * Description: Reads a file with courses, builds a graph, outputs study plan.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Runner initiates degree planner program.
 */
public class Runner {

    /**
     * Run degree planner.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String filename = "example_file_XBDA.txt";
        int maxCoursesAtOnce = 2;

        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        try {
            gbuild.read(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find: " + filename);
            return;
        }

        DegreePlanner planner = new DegreePlanner(
                gbuild.getGraph(), gbuild.getCourses(), maxCoursesAtOnce);

        List<List<Course>> studyPlan = planner.plan();

        // Print each study period on its own line. Starts at SP 1
        int period = 1;

        for (List<Course> coursesThisPeriod : studyPlan) {
            List<String> codes = new ArrayList<>();

            for (Course course : coursesThisPeriod) {
                codes.add(course.getCode());
            }

            System.out.println("Study Period " + period + ": " + String.join(", ", codes));
            period++;
        }

    }
}
