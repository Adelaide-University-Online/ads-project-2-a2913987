/**
 * File: LineParser.java
 * Description: Splits degree file lines into course codes.
 * Author: Thomas Brown
 * Student ID: a2913987
 * Email ID: thomas.brown01
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * LineParser splits csv lines into course codes.
 */
public class LineParser {

    /**
     * Split line into course codes
     *
     * @param line line for splitting
     * @return list of course codes
     */
    public List<String> parse(String line) {
        List<String> codes = new ArrayList<>();

        if (line == null || line.isEmpty()) {return codes;}

        String[] tokens = line.split(",");

        for (String token : tokens) {
            String code = token.trim();

           if (!code.isEmpty()) {
               codes.add(code);
           }
        }
        return codes;
    }
}
