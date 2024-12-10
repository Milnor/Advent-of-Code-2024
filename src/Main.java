package aoc24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

import aoc24.Color;
import aoc24.InputParser;
import aoc24.Challenge;

// TODO: add correct values to tests
// Day 1
// 1889772
// 23228917

// Day 2
// 287
// 355 was too high

// Day 3
// 169021493
// 111762583

public class Main
{

    private static final String DAY_1 = "../inputs/day01.txt";
    private static final String DAY_2 = "../inputs/day02.txt";
    private static final String DAY_3 = "../inputs/day03.txt";
    private static final String DAY_4 = "../inputs/day04.txt";

    public static void main(String []args)
    {
        System.out.println(Color.ANSI_BOLD + "Advent of Code 2024 " 
                           + Color.ANSI_RESET + "in " 
                           + Color.ANSI_YELLOW + "Java" + Color.ANSI_RESET
                           + ":");

        Day01 d1 = new Day01(DAY_1);
        d1.results();
        Day02 d2 = new Day02(DAY_2);
        d2.results();
        Day03 d3 = new Day03(DAY_3);
        d3.results();
        Day04 d4 = new Day04(DAY_4);
        d4.results();        
    }
}

