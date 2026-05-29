/**
 * File: LineParserTest.java
 * Description: Tests for LineParser splitting.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests LineParser splits course code lines.
 */
class LineParserTest {
    /** Simple line splits into codes. */
    @Test
    void checkSimpleLineSplitsIntoCodes() {
        LineParser parser = new LineParser();

        List<String> codes = parser.parse("A,B,C");

        assertEquals(3, codes.size());
        assertEquals("A", codes.get(0));
        assertEquals("B", codes.get(1));
        assertEquals("C", codes.get(2));
    }

    /** Trailing space ignored. */
    @Test
    void checkTrailingSpaceIgnored() {
        LineParser parser = new LineParser();

        List<String> codes = parser.parse("INFT3046, INFS3081 ");

        assertEquals(2, codes.size());
        assertEquals("INFS3081", codes.get(1));
    }

    /** Empty code between commas ignored. */
    @Test
    void checkEmptyCodeIgnored() {
        LineParser parser = new LineParser();

        List<String> result = parser.parse("COMP1043, , MATH1080");

        assertEquals(List.of("COMP1043", "MATH1080"), result);
    }

    /** Empty line returns empty list. */
    @Test
    void checkEmptyLineReturnsEmptyList() {
        LineParser parser = new LineParser();

        assertTrue(parser.parse("").isEmpty());
    }

}
