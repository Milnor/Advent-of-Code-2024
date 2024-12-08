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

class InputParser
{

    public static List<String> getInput(String pathName)
    {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            System.err.println("Error opening \'" + pathName + "\':" + e.getMessage());
        }
        return lines;
    }

    public static List<List<Integer>> toTwoIntColumns(List<String> data)
    {
        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();
        List<List<Integer>> bothColumns = new ArrayList<>();

        for (String line : data) {
            String[] numbers = line.split("\\s+");
            column1.add(Integer.parseInt(numbers[0]));
            column2.add(Integer.parseInt(numbers[1]));
        }

        bothColumns.add(column1);
        bothColumns.add(column2);

        return bothColumns;
    }

    public static List<List<Integer>> toManyIntRows(List<String> data)
    {
        List<List<Integer>> allRows = new ArrayList<>();

        for (String line : data) {
            String[] inputs = line.split("\\s+");
            ArrayList<Integer> current_row = new ArrayList<>();
            for (String number : inputs) {
                current_row.add(Integer.parseInt(number));
            }
            allRows.add(current_row);
        }

        return allRows;
    }
/*

        filePath = "inputs/day02.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int total1 = 0;
            int total2 = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] inputs = line.split("\\s+");
                ArrayList<Integer> current_row = new ArrayList<Integer>();
                for (String number : inputs) {
                    current_row.add(Integer.parseInt(number));
                }
                if (isSafe(current_row, false)) {
                    total1++;
                }
                if (isSafe(current_row, true)) {
                    total2++;
                }

            }

            System.out.println(total1);
            System.out.println(total2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    */
}
