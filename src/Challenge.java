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

