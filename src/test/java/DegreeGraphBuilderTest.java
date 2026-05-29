/**
 * File: DegreeFileReaderTest.java
 * Description: Tests the DegreeFileReader class.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

/**
 * Tests DegreeGraphBuilder course building
 */
class DegreeGraphBuilderTest {

    private static final String SAMPLE =
            "A, B, C\n" + "A, B\n" + "B, C\n";

    /** All courses are read. */
    @Test
    void checkAllCoursesRead() {
        DegreeGraphBuilder gbuild = new DegreeGraphBuilder();

        gbuild.parse(new Scanner(SAMPLE));

        assertEquals(3, gbuild.getCourseCount());
    }

}
