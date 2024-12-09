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

import aoc24.InputParser;

public class Challenge
{
    List<String> data;
    int part1;
    int part2;
    
    public Challenge(String inputFile) {
        this.part1 = 0;
        this.part2 = 0;
        this.data = InputParser.getInput(inputFile); 
    }   

    public void results() {
        System.out.println("Part 1: " + this.part1 + " Part 2: " + this.part2);
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
        for (String line : this.data) {
            // See https://stackoverflow.com/questions/6020384/create-array-of-regex-matches
            String[] matches = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)")
                                      .matcher(line)
                                      .results()
                                      .map(MatchResult::group)
                                      .toArray(String[]::new);
            for (String match : matches) {

                //System.out.println("Matches: " + match);
                total += doMultiply(match);
            }
        }
        this.part1 = total;

        // Part 2
        total = 0;
        String keepers = "";
        // First chunk to keep is beginning until don't()
        // Then we want anything between do() and don't()
        // Finally, if do() occurs last we want do() through EOF
        // ... or maybe there's a simpler algorithm:
        // string split() on don't()
        //  a b c [dont] d e f [dont] g h i [dont] j k l
        //  keep first hunk
        //  in subsequent hunks, split on do() and keep second portion
        String[] pieces = this.data.get(0).split("don't()");
        keepers += pieces[0];
        for (int i = 1; i < pieces.length; i++) {
            // edge case
            if (pieces[i].startsWith("do()")) {
                keepers += pieces[i];
            } else {
                String[] subPiece = pieces[i].split("do()");
                if (subPiece.length > 1) {
                    for (int j = 1; j < subPiece.length; j++) {
                        keepers += subPiece[j];
                    }
                }
            }
        }
        String[] matches = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)")
                         .matcher(keepers)
                         .results()
                         .map(MatchResult::group)
                         .toArray(String[]::new);
        for (String match : matches) {
            total += doMultiply(match);
        }
        this.part2 = total;

    }
}
