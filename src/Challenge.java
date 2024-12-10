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
        int previous = -1;
        int current = -1;
        for (List<Integer> row : rows) {
            // pass
        }

        return allRows;
    }

    public Day02(String inputFile) {
        super(inputFile);
        var rows = InputParser.toManyIntRows(this.data);
        var intervals = toIntervals(rows);
    }
}

class Day03 extends Challenge
{
    public static int doMultiply(String opcode) {
        var op = opcode.split(",");
        var x = Integer.parseInt(op[0].substring(4));                       // strip out mul(
        var y = Integer.parseInt(op[1].substring(0, op[1].length() - 1));   // strip out )
        return x * y;
    }

    public Day03(String inputFile) {
        super(inputFile);

        // Part 1
        int total = 0;
        String lines = this.data.toString();
            // See https://stackoverflow.com/questions/6020384/create-array-of-regex-matches
            String[] matches = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)")
                                      .matcher(lines)
                                      .results()
                                      .map(MatchResult::group)
                                      .toArray(String[]::new);
            for (String match : matches) {

                //System.out.println("Matches: " + match);
                total += doMultiply(match);
            }
        
        this.part1 = total;

        // Part 2
        total = 0;
        // trim out don't()...do()
        // the ? makes the regex non-greedy
        String enabled = lines.replaceAll("don\\'t\\(\\).*?do\\(\\)", "");
        // trim out don't()...EOF if it exists
        enabled = enabled.replaceAll("don\\'t\\(\\).*$", "");
        matches = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)")
                         .matcher(enabled)
                         .results()
                         .map(MatchResult::group)
                         .toArray(String[]::new);
        for (String match : matches) {
            total += doMultiply(match);
        }

        this.part2 = total;

    }
}
