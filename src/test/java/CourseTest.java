/**
 * File: Course.java
 * Description: Tests the Course class.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests Course stores code, equality, hash code and returning string.
 */
class CourseTest {

    /** Course code saved. */
    @Test
    void checkCourseCodeSaved() {
        Course course = new Course("COMP1043");

        assertEquals("COMP1043", course.getCode());
    }

    /** Null code throws error. */
    @Test
    void checkNullCodeThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> new Course(null));
    }

    /** Courses same code equal. */
    @Test
    void checkSameCoursesEqual() {
        Course course1 = new Course("COMP1043");
        Course course2 = new Course("COMP1043");

        assertEquals(course1, course2);
    }

    /** Course does not equal string. */
    @Test
    void checkCourseDoesNotEqualString() {
        Course course = new Course("COMP1043");

        assertNotEquals("COMP1043", course);
    }

    /** Equal courses same hash code. */
    @Test
    void checkEqualCoursesSameHashCode() {
        Course course1 = new Course("COMP1043");
        Course course2 = new Course("COMP1043");

        assertEquals(course1.hashCode(), course2.hashCode());
    }

    /** toString shows code. */
    @Test
    void checkToStringShowsCode() {
        Course course = new Course("MATH2032");

        assertTrue(course.toString().contains("MATH2032"));
    }
}
