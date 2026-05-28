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


public class DegreeGraphBuilder {

    private final LineParser lineParser = new LineParser();
    private final Map<String, Integer> codeToVert = new HashMap<>();
    private final List<Course> courses = new ArrayList<>();
    private Graph graph;


}

