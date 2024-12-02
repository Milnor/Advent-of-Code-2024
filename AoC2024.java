import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

class AdventOfCode
{

    private static boolean isSafe(ArrayList<Integer> report) {

        // Is it "safe?"
        // (1) all increasing or all decreasing
        // (2) differ by at least one AND at most three
        int previous = -1;
        Boolean isIncreasing = null;
        for (Integer current : report) {
            if (previous < 0) {
                previous = current;
                continue;
            }
            if (previous == current) {
                return false;
            } 
            else if (previous < current) {
                // test direction
                if (isIncreasing != null) {
                    if (isIncreasing == false) {
                        return false;
                    }
                } else {
                    isIncreasing = true;
                }
                // test gap
                if ((current - previous) > 3) {
                    return false;
                }
            }
            else if (previous > current) {
                // test direction
                if (isIncreasing != null) {
                    if (isIncreasing == true) {
                        return false;
                    }
                } else {
                    isIncreasing = false;
                }
                // test gap
                if ((previous - current) > 3) {
                    return false;
                }
            }
            previous = current;
        }

        return true;
    }

    public static void main(String []args)
    {
        String filePath = "inputs/day01.txt";

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
            e.printStackTrace();
        }

        filePath = "inputs/day02.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int total = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] inputs = line.split("\\s+");
                ArrayList<Integer> current_row = new ArrayList<Integer>();
                for (String number : inputs) {
                    current_row.add(Integer.parseInt(number));
                }
                if (isSafe(current_row)) {
                    total++;
                }

            }

            System.out.println(total);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
