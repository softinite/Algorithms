package com.softinite.algorithms.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2016-01-01.
 *
 * Source: https://www.hackerrank.com/challenges/saveprincess
 *
 * Problem Statement

 Princess Peach is trapped in one of the four corners of a square grid. You are in the center of the grid and can move
 one step at a time in any of the four directions. Can you rescue the princess?

 Input format

 The first line contains an odd integer N (3 <= N < 100) denoting the size of the grid. This is followed by an NxN grid.
 Each cell is denoted by '-' (ascii value: 45). The bot position is denoted by 'm' and the princess position is denoted by 'p'.

 Grid is indexed using Matrix Convention

 Output format

 Print out the moves you will take to rescue the princess in one go. The moves must be separated by '\n', a newline.
 The valid moves are LEFT or RIGHT or UP or DOWN.

 Sample input

 3
 ---
 -m-
 p--
 Sample output

 DOWN
 LEFT
 Task

 Complete the function displayPathtoPrincess which takes in two parameters - the integer N and the character array grid.
 The grid will be formatted exactly as you see it in the input, so for the sample input the princess is at grid[2][0]. T
 he function shall output moves (LEFT, RIGHT, UP or DOWN) on consecutive lines to rescue/reach the princess.
 The goal is to reach the princess in as few moves as possible.

 The above sample input is just to help you understand the format. The princess ('p') can be in any one of the four corners.

 Scoring
 Your score is calculated as follows : (NxN - number of moves made to rescue the princess)/10, where N is the size of
 the grid (3x3 in the sample testcase).
 *
 */
public class BotSavesPrincess {

    public static final String PRINCESS = "p";
    public static final String MOVE_UP = "UP";
    public static final String MOVE_DOWN = "DOWN";
    public static final String MOVE_LEFT = "LEFT";
    public static final String MOVE_RIGHT = "RIGHT";

    public static void displayPathtoPrincess(Integer n, List<String> grid) {
        String firstRow = grid.get(0);
        String lastRow = grid.get(n - 1);
        if (firstRow.startsWith(PRINCESS)) {
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_UP));
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_LEFT));
        } else if (firstRow.endsWith(PRINCESS)) {
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_UP));
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_RIGHT));
        } else if (lastRow.startsWith(PRINCESS)) {
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_DOWN));
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_LEFT));
        } else if (lastRow.endsWith(PRINCESS)) {
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_DOWN));
            IntStream.range(0, n/2).forEach(i -> System.out.println(MOVE_RIGHT));
        }

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer n = Integer.valueOf(console.nextLine());

        List<String> grid = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> grid.add(console.nextLine()));

        displayPathtoPrincess(n, grid);
    }

}
