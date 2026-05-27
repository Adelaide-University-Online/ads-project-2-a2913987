/**
 * File: Course.java
 * Description: Defines a course in a degree with a course code and prerequisites.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.util.List;

/**
 * A course code identifies the course and used in equality and hashing. Prerequisites are handled
 * as edges in Graph.
 */
public class Course {

    private final String code;

    /**
     * Construct a Course with a code.
     *
     * @param code course code
     */
    public Course(String code) {
        this.code = code;
    }

    /**
     * Returns this course's code.
     *
     * @return the course code
     */
    public String getCode() {
        return code;
    }
}
