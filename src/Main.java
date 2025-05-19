import ucn.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent Of Code Day 2!!");

        List<List<Integer>> list = new ArrayList<>();
        readTxt(list);



        int safeReports = checkReports(list);
        System.out.println("The amount of Safe Reports is: " + safeReports);

    }

    private static int checkReports(List<List<Integer>> list) {

        int countSafeReports = 0;
        for (int i = 0; i < list.size(); i++) {

            if (isSafe(list.get(i))) {
                countSafeReports++;
            }
        }
        return countSafeReports;

    }

    private static boolean isSafe(List<Integer> numbersList) {

        boolean isIncreasing = numbersList.get(0) < numbersList.get(1);

        if (isIncreasing) {
            return increasingList(numbersList);
        } else {
            return decreasingList(numbersList);
        }

    }

    private static boolean decreasingList(List<Integer> numbersList) {

        for (int i = 0; i < numbersList.size() - 1; i++) {

            if (numbersList.get(i) - numbersList.get(i+1) > 0 && numbersList.get(i) - numbersList.get(i+1) < 4) {
                continue;
            } else {
                return false;
            }

        }
        return true;

    }

    private static boolean increasingList(List<Integer> numbersList) {

        for (int i = 0; i < numbersList.size() - 1; i++) {

            if (numbersList.get(i+1) - numbersList.get(i) > 0 && numbersList.get(i+1) - numbersList.get(i) < 4) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    private static void readTxt(List<List<Integer>> list) {

        In arch = new In("input.txt");

        while (!arch.isEmpty()) {

            List<Integer> numberLine = new ArrayList<>();
            String[] line = arch.readLine().split(" ");

            for (int i = 0; i < line.length; i++) {
                numberLine.add(Integer.parseInt(line[i]));
            }

            list.add(numberLine);
        }

    }
}