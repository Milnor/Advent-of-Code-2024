package aoc24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

import aoc24.InputParser;
import aoc24.Challenge;

// TODO: add correct values to tests
// 1889772
// 23228917

// 287
// 355 was too high

// 169021493
// 10875477 was too low

public class Main
{
        private static boolean isSafe(ArrayList<Integer> report, boolean dampenerOn) {
        // Is it "safe?"
        // (1) all increasing or all decreasing
        // (2) differ by at least one AND at most three
        int previous = -1;
        int problems = 0;
        Boolean isIncreasing = null;
        for (Integer current : report) {
            if (previous < 0) {
                previous = current;
                continue;
            }
            if (previous == current) {
                problems++;
            } 
            else if (previous < current) {
                // test direction
                if (isIncreasing != null && isIncreasing == false) {
                    problems++;
                    isIncreasing = false;
                    
                } else {
                    isIncreasing = true;
                }
                // test gap
                if ((current - previous) > 3) {
                    problems++;
                }
            }
            else if (previous > current) {
                // test direction
                if (isIncreasing != null && isIncreasing == true) {
                        problems++;
                        isIncreasing = true;
                } else {
                    isIncreasing = false;
                }
                // test gap
                if ((previous - current) > 3) {
                    problems++;
                }
            }
            previous = current;
        }

        if (dampenerOn && problems <= 1) {
            return true;
        } 
        if (!dampenerOn && problems == 0) {
            return true;
        }
        return false;

    }

    private static final String DAY_1 = "../inputs/day01.txt";
    private static final String DAY_2 = "../inputs/day02.txt";
    private static final String DAY_3 = "../inputs/day03.txt";
    private static final String DAY_4 = "../inputs/day04.txt";

    public static void main(String []args)
    {
        System.out.println("Advent of Code 2024 in Java:");
        Day01 d1 = new Day01(DAY_1);
        d1.results();
        Day02 d2 = new Day02(DAY_2);
        d2.results();
        Day03 d3 = new Day03(DAY_3);
        d3.results();
        
    }
}
