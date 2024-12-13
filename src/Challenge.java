package aoc24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import aoc24.Color;
import aoc24.InputParser;

public class Challenge
{
    List<String> data;
    int day;
    int part1;
    int part2;
    
    public Challenge(String inputFile) {
        this.part1 = 0;
        this.part2 = 0;
        // https://stackoverflow.com/questions/43584348/java-match-regex-and-extract-group-oneliner
        String dayNumber = Pattern.compile("\\d{1,2}")
                                  .matcher(inputFile)
                                  .results()
                                  .map(m -> m.group(0))
                                  .findFirst()
                                  .orElse(null);
        this.day = Integer.parseInt(dayNumber);
        this.data = InputParser.getInput(inputFile); 
    }   

    public void results() {
        System.out.println(" Day " + this.day + Color.ANSI_RED + "\t1: " + 
                           Color.ANSI_GREEN + this.part1 + Color.ANSI_RED + 
                           "\t2: " + Color.ANSI_GREEN + this.part2 + 
                           Color.ANSI_RESET);
    }
}

class Day01 extends Challenge
{
    public Day01(String inputFile) {
        // Parse inputs
        super(inputFile);
        var columns = InputParser.toTwoIntColumns(this.data);
        var col1 = columns.get(0);
        var col2 = columns.get(1);

        // Part 1
        Collections.sort(col1);
        Collections.sort(col2);
        int total = 0;
        for (int i = 0; i < col1.size(); i++) {
            total += Math.abs(col1.get(i) - col2.get(i));
        }
        this.part1 = total;

        // Part 2
        total = 0;
        for (Integer number : col1) {
            total += (number * Collections.frequency(col2, number));
        }
        this.part2 = total;
    }
}

class Day02 extends Challenge
{
    public static List<List<Integer>> toIntervals(List<List<Integer>> rows) {

        List<List<Integer>> allRows = new ArrayList<>();

        for (List<Integer> row : rows) {
            List<Integer> currentRow = new ArrayList();
            int previous = row.get(0);
            for (int i = 1; i < row.size(); i++) {
                int current = row.get(i);
                int interval = current - previous;
                currentRow.add(interval);
                previous = current;
            }
            allRows.add(currentRow);
        }

        return allRows;
    }

    private static boolean isSafe(List<Integer> intervals) {

        Boolean increasing = null;
        boolean safe = true;

        for (int interval : intervals) {
            if (0 == interval) {
                safe = false;
            } else if (interval > 0) {
                if (null == increasing) {
                    increasing = true;
                } else if (false == increasing) {
                    // change in direction
                    safe = false;
                }

            } else if (interval < 0) {
                if (null == increasing) {
                    increasing = false;
                } else if (increasing) {
                    // change in direction
                    safe = false;
                }
            }
            // check magnitude
            if (Math.abs(interval) > 3) {
                safe = false;
            }
        }

        return safe;
    }

    public Day02(String inputFile) {
        super(inputFile);
        var rows = InputParser.toManyIntRows(this.data);
        var allIntervals = toIntervals(rows);

        // Part 1
        int safe = 0;
        for (List<Integer> intervalList : allIntervals) {
            if (isSafe(intervalList)) {
                safe++;
            }
        }
        this.part1 = safe;

        // Part 2
        safe = 0;
        for (List<Integer> row : rows) {
            // Apply Problem Dampener
        }
        this.part2 = safe;
    }
}

class Day03 extends Challenge
{
    private static int doMultiply(String opcode) {
        var op = opcode.split(",");
        var x = Integer.parseInt(op[0].substring(4));                       // strip out mul(
        var y = Integer.parseInt(op[1].substring(0, op[1].length() - 1));   // strip out )
        return x * y;
    }

    private static int calculateTotals(String lines) {
        
            // See https://stackoverflow.com/questions/6020384/create-array-of-regex-matches
            int total = 0;
            String[] matches = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)")
                                      .matcher(lines)
                                      .results()
                                      .map(MatchResult::group)
                                      .toArray(String[]::new);
            for (String match : matches) {

                //System.out.println("Matches: " + match);
                total += doMultiply(match);
            }
            return total;
    }

    public Day03(String inputFile) {
        super(inputFile);

        // Part 1
        String lines = this.data.toString();
        this.part1 = calculateTotals(lines);

        // Part 2
        // trim out don't()...do(), the ? makes the regex non-greedy
        String enabled = lines.replaceAll("don\\'t\\(\\).*?do\\(\\)", "");
        // trim out don't()...EOF if it exists
        enabled = enabled.replaceAll("don\\'t\\(\\).*$", "");
        this.part2 = calculateTotals(enabled);
    }
}

class Day04 extends Challenge
{

    public Day04(String inputFile) {
        super(inputFile);
        //var rows = InputParser.toManyIntRows(this.data);
        //var intervals = toIntervals(rows);
        this.part1 = -1;
        this.part2 = -1;
    }
}
