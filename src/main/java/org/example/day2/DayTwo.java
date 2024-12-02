package org.example.day2;

import org.example.utility.FileHandler;
import java.util.ArrayList;

public class DayTwo extends FileHandler {

    public DayTwo(String fileName) {
        super(fileName);
    }

    public void safeReportsCount() {
        ArrayList<String> fileLines = convertFileToLines(fileName);
        int counter = 0;

        for (String fileLine : fileLines) {
            ArrayList<Integer> convertToInteger = stringLineToInteger(fileLine);

            boolean checkSafe = isLineSafe(convertToInteger);
            if (checkSafe) {
                counter++;
            } else {
                boolean badLevel;
                for (int i = 0; i < convertToInteger.size(); i++) {
                    badLevel = singleBadLevel(convertToInteger, i);
                    if (badLevel) {
                        counter++;
                        break;
                    }
                }

            }
        }
        System.out.println(counter);
    }

    private ArrayList<Integer> stringLineToInteger (String stringLine) {
        ArrayList<Integer> convertedToInteger = new ArrayList<>();

        String[] lineSplit = stringLine.split(" ");
        for (String s : lineSplit) {
            convertedToInteger.add(Integer.parseInt(s));
        }

        return convertedToInteger;
    }

    private boolean isLineSafe(ArrayList<Integer> checkLine) {
        if (checkLine.size() < 2) {
            return false;
        }

        // DECREASING ORDER
        if (checkLine.get(0) > checkLine.get(1)) {
            for (int i = 0; i < checkLine.size(); i++) {
                if ((i + 1) >= checkLine.size()) {
                    return true;
                }
                if (checkLine.get(i) > checkLine.get(i + 1)){
                    int difference = checkLine.get(i) - checkLine.get(i + 1);
                    if (difference != 1 && difference != 2 && difference != 3) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            // INCREASING ORDER
        } else if (checkLine.get(0) < checkLine.get(1)) {
            for (int i = 0; i < checkLine.size(); i++) {
                if ((i + 1) >= checkLine.size()) {
                    return true;
                }
                if (checkLine.get(i) < checkLine.get(i + 1)){
                    int difference = checkLine.get(i + 1) - checkLine.get(i);
                    if (difference != 1 && difference != 2 && difference != 3) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else return false;

        return false;
    }

    private boolean singleBadLevel(ArrayList<Integer> currentList, int indexToRemove) {
        boolean fixedList;
        ArrayList<Integer> tempList = new ArrayList<>(currentList);

        tempList.remove(indexToRemove);
        fixedList = isLineSafe(tempList);

        return fixedList;
    }
}
