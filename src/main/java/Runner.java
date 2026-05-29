/**
 * File: Runner.java
 * Description:
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.io.FileNotFoundException;

public class Runner {
    
    public static void main(String[] args) {
        String filename = "example_file_XBDA.txt";

        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        try {
            gbuild.read(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find: " + filename);
            return;
        }

        System.out.println(gbuild.getCourseCount());
        System.out.println(gbuild.getCourses());
        System.out.println(gbuild.getGraph());
    }
}
