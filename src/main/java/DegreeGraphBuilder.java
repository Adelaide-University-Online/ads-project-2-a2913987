/**
 * File: DegreeGraphBuilder.java
 * Description: Reads a degree file and builds courses.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;



public class DegreeGraphBuilder {

    private final LineParser lineParser = new LineParser();
    private final Map<String, Integer> convertToId = new HashMap<>();
    private final List<Course> courses = new ArrayList<>();
    private Graph graph;

    /**
     * Read degree file.
     *
     * @param filename file to read
     * @throws FileNotFoundException if file is missing
     */
    public void read(String filename) throws FileNotFoundException {
        // Turn filename into a File object, then create a Scanner to read it
        Scanner scanner = new Scanner(new File(filename));

        parse(scanner);

        scanner.close();
    }

    /**
     * Build course list and prerequisite graph from file contents.
     *
     * @param scanner scanner for file contents
     */
    void parse(Scanner scanner) {
        convertToId.clear();
        courses.clear();

        List<String> degreeCodes = lineParser.parse(scanner.nextLine());
        graph = new AdjacencyListGraph(degreeCodes.size(), true);

        // Create course code and add to course list
        for (int i = 0; i < degreeCodes.size(); i++) {

            String code = degreeCodes.get(i);
            convertToId.put(code, i);
            courses.add(new Course(code));

        }

        // Read line and add prerequisite edges to graph
        while (scanner.hasNextLine()) {
            List<String> parts = lineParser.parse(scanner.nextLine());

            if (parts.isEmpty()) {
                continue;
            }

            // Get the id of first course on this line
            int courseId = convertToId.get(parts.get(0));

            // Iterate of ids in line and insert as edges in graph
            for (int i = 1; i < parts.size(); i++) {
                int prereqId = convertToId.get(parts.get(i));
                graph.insert(new Edge(prereqId, courseId));
            }

        }

    }

    /**
     * Get graph.
     *
     * @return graph
     */
    public Graph getGraph() {
        return graph;
    }


    /**
     * Get courses.
     *
     * @return course lis
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Get number of courses.
     *
     * @return course count
     */
    public int getCourseCount() {
        return courses.size();
    }

    /**
     * Get vertex id for courses code.
     *
     * @param code course code
     * @return vertex id
     */
    public int getVertexId(String code) {
        return convertToId.get(code);
    }



}

