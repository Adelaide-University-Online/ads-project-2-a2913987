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

    /**
     * Compare course with another course object.
     *
     * @param obj course to compare
     * @return true if object same course code
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Course)) {
            return false;
        }

        Course other = (Course) obj;
        return this.code.equals(other.code);
    }

    /**
     * Return hash code for course.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return code.hashCode();
    }

    /**
     * Return string version of this course.
     *
     * @return course as string
     */
    @Override
    public String toString() {
        return "Course code:" + code + "]";
    }

}
