package aoc24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class InputParser
{

    public static List<String> getInput(String pathName)
    {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(pathName));
            return lines;
        } catch (IOException e) {
            System.err.println("Error opening \'" + pathName + "\':" + e.getMessage());
        }
        return lines;
    }

/*
try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            ArrayList<Integer> column1 = new ArrayList<Integer>();
            ArrayList<Integer> column2 = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] inputs = line.split("\\s+");
                column1.add(Integer.parseInt(inputs[0]));
                column2.add(Integer.parseInt(inputs[1]));
            }
            Collections.sort(column1);
            Collections.sort(column2);

            int total = 0;
            for (int i = 0; i < column1.size(); i++) {
                total += Math.abs(column1.get(i) - column2.get(i));
            }

            System.out.println(total);

            total = 0;

            for (Integer number : column1) {
                total += (number * Collections.frequency(column2, number));
            }

            System.out.println(total);


        } catch (IOException e) {
            System.err.println("Error opening <FILE>: " + e.getMessage());
        }

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
