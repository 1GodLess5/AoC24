package org.example;

import org.example.day1.DayOne;
import org.example.day2.DayTwo;

public class Main {

    public static void main(String[] args) {
        // Day 1
        DayOne dayOne = new DayOne("src/main/resources/inputFiles/day1/Day1PuzzleInput.txt");
        // Day 1 task 1
        dayOne.totalDistance();
        // Day 1 task 2
        dayOne.similarityScore();

        // Day 2
        DayTwo dayTwo = new DayTwo("src/main/resources/inputFiles/day2/Day2PuzzleInput.txt");
        // Day 2 task 1 + 2
        dayTwo.safeReportsCount();

    }
}