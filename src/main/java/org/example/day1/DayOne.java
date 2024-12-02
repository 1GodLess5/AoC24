package org.example.day1;

import org.example.utility.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class DayOne extends FileHandler {
    public DayOne(String fileName) {
        super(fileName);
    }

    public void totalDistance() {
        ArrayList<String> fileLine = convertFileToLines(this.fileName);
        ArrayList<Integer> firstColumn = fileLinesToIntegerLists(fileLine, true);
        ArrayList<Integer> secondColumn = fileLinesToIntegerLists(fileLine, false);

        firstColumn.sort(Comparator.naturalOrder());
        secondColumn.sort(Comparator.naturalOrder());
        int total = 0;
        for (int i = 0; i < firstColumn.size(); i++) {
            total += firstColumn.get(i) > secondColumn.get(i) ? firstColumn.get(i) - secondColumn.get(i) : secondColumn.get(i) - firstColumn.get(i);
        }

        System.out.println(total);
    }

    public void similarityScore() {
        ArrayList<String> fileLine = convertFileToLines(this.fileName);
        ArrayList<Integer> firstColumn = fileLinesToIntegerLists(fileLine, true);
        ArrayList<Integer> secondColumn = fileLinesToIntegerLists(fileLine, false);

        int total = 0;
        for (Integer firstColumnInteger : firstColumn) {
            int foundTotal = 0;
            for (Integer secondColumnInteger : secondColumn) {
                if (Objects.equals(firstColumnInteger, secondColumnInteger)) {
                    foundTotal++;
                }
            }
            total += firstColumnInteger * foundTotal;
        }

        System.out.println(total);
    }

    private ArrayList<Integer> fileLinesToIntegerLists(ArrayList<String> toConvert, boolean firstColumn) {
        ArrayList<String> fileLine = convertFileToLines(this.fileName);
        ArrayList<Integer> convertedArray = new ArrayList<>();

        for (int i = 0; i < fileLine.size(); i++) {
            String[] lineSplit = fileLine.get(i).split(" {3}");
            if (firstColumn) {
                convertedArray.add(Integer.parseInt(lineSplit[0]));
            } else {
                convertedArray.add(Integer.parseInt(lineSplit[1]));
            }

        }

        return convertedArray;
    }
}
