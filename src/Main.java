import ucn.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent Of Code Day 2!!");

        List<List<Integer>> list2 = new ArrayList<>();
        readTxt2(list2);

        int safeReports2 = checkReports2(list2);
        System.out.println("The amount of Safe Reports is: " + safeReports2);

        List<String> list = new ArrayList<>();
        //readTxt(list);

        int safeReports = checkReports(list);
        //System.out.println("The amount of Safe Reports is: " + safeReports);

    }

    private static int checkReports2(List<List<Integer>> list2) {

        List<Integer> line;

        int countSafeReports = 0;
        for (int i = 0; i < list2.size(); i++) {

            line = list2.get(i);

            if (isSafe2(line)) {
                countSafeReports++;
            }

        }
        return countSafeReports;

    }

    private static boolean isSafe2(List<Integer> line) {

        int[] numbers = new int[line.size()];

        for (int i = 0; i < line.size(); i++) {
            numbers[i] = line.get(i);
        }


        //System.out.println(numbers[0]);
        //System.out.println(numbers[1]);
        boolean isIncreasing = numbers[0] < numbers[1];

        for (int i = 1; i < numbers.length-1; i++) {

            if (isIncreasing) {

                if (numbers[i] < numbers[i+1]) {
                    if (numbers[i + 1] - numbers[i] > 3) {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {

                if (numbers[i] > numbers[i+1]) {
                    if (numbers[i] - numbers[i + 1] > 3) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

        }

        return true;

    }


    private static int checkReports(List<String> list) {

        int countSafeReports = 0;
        for (int i = 0; i < list.size(); i++) {

            if (isSafe(list.get(i))) {
                countSafeReports++;
            }

        }
        return countSafeReports;

    }

    private static boolean isSafe(String numbersStr) {

        int[] numbers = strToInt(numbersStr);

        System.out.println(numbersStr);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println("\n");

        //System.out.println(numbers[0]);
        //System.out.println(numbers[1]);
        boolean isIncreasing = numbers[0] < numbers[1];

        for (int i = 1; i < numbers.length-1; i++) {

            if (isIncreasing) {

                if (numbers[i] < numbers[i+1]) {
                    if (numbers[i + 1] - numbers[i] > 3) {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {

                if (numbers[i] > numbers[i+1]) {
                    if (numbers[i] - numbers[i + 1] > 3) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

        }

        return true;
    }

    private static int[] strToInt(String numbersStr) {

        String[] list = numbersStr.split(" ");
        int[] numbersList = new int[list.length];

        for (int i = 0; i < numbersList.length; i++) {

            numbersList[i] = Integer.parseInt(list[i]);

        }

        return numbersList;
    }

    private static void readTxt(List<String> list) {

        In arch = new In("input.txt");
        String str = "";

        while (!arch.isEmpty()) {

            String[] line = arch.readLine().split(" ");

            for (int i = 0; i < line.length; i++) {
                str += line[i];
            }

            list.add(str);
        }

    }

    private static void readTxt2(List<List<Integer>> list2) {

        In arch = new In("input.txt");
        List<Integer> numberLine = new ArrayList<>();

        while (!arch.isEmpty()) {

            String[] line = arch.readLine().split(" ");

            for (int i = 0; i < line.length; i++) {

                numberLine.add(Integer.parseInt(line[i]));

            }

            list2.add(numberLine);
        }

    }
}