//import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

class AdventOfCode
{
    public static void main(String []args)
    {
        //System.out.println("Hello, AoC 2024!");
        String filePath = "inputs/day01.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {


            ArrayList<Integer> column1 = new ArrayList<Integer>();
            ArrayList<Integer> column2 = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
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
            e.printStackTrace();
        }

        filePath = "inputs/day02.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int total = 0;
            String line;
            //ArrayList<Integer> column1 = new ArrayList<Integer>();
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] inputs = line.split("\\s+");
                //column1.add(Integer.parseInt(inputs[0]));
                //column2.add(Integer.parseInt(inputs[1]));
                ArrayList<Integer> current_row = new ArrayList<Integer>();
                for (String number : inputs) {
                    current_row.add(Integer.parseInt(number));
                }
                // Is it "safe?"
                // (1) all increasing or all decreasing
                // (2) differ by at least one AND at most three
                int previous = -1;
                boolean isIncreasing;
                for (Integer current : current_row) {

                }


            }

            System.out.println(total);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
