package org.example;

import org.example.day1.DayOne;

public class Main {

    public static void main(String[] args) {
        DayOne dayOne = new DayOne("src/main/resources/inputFiles/day1/Day1PuzzleInput.txt");
        // Day 1 task 1
        dayOne.totalDistance();
        // Day 1 task 2
        dayOne.similarityScore();
    }
}