package com.softinite.algorithms.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2016-01-02.
 *
 * Problem Statement

 In this version of "Bot saves princess", Princess Peach and bot's position are randomly set. Can you save the princess?

 Task

 Complete the function nextMove which takes in 4 parameters - an integer N, integers r and c indicating the row & column
 position of the bot and the character array grid - and outputs the next move the bot makes to rescue the princess.

 Input Format

 The first line of the input is N (<100), the size of the board (NxN). The second line of the input contains
 two space separated integers, which is the position of the bot.

 Grid is indexed using Matrix Convention

 The position of the princess is indicated by the character 'p' and the position of the bot is indicated by
 the character 'm' and each cell is denoted by '-' (ascii value: 45).

 Output Format

 Output only the next move you take to rescue the princess. Valid moves are LEFT, RIGHT, UP or DOWN

 Sample Input

 5
 2 3
 -----
 -----
 p--m-
 -----
 -----
 Sample Output

 LEFT
 Resultant State

 -----
 -----
 p-m--
 -----
 -----
 Explanation

 As you can see, bot is one step closer to the princess.

 Scoring
 Your score for every testcase would be (NxN minus number of moves made to rescue the princess)/10 where N is the size of
 the grid (5x5 in the sample testcase). Maximum score is 17.5
 *
 *
 */
public class BotSavesPrincess2 {

    public static final String MOVE_UP = "UP";
    public static final String MOVE_DOWN = "DOWN";
    public static final String MOVE_LEFT = "LEFT";
    public static final String MOVE_RIGHT = "RIGHT";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer n = Integer.valueOf(console.nextLine());
        String rc = console.nextLine();
        String[] rca = rc.split("\\s");
        Integer r = Integer.valueOf(rca[0]);
        Integer c = Integer.valueOf(rca[1]);

        char [][]grid = new char[n][n];

        IntStream.range(0, n).forEach(i -> grid[i] = console.nextLine().toCharArray());

        nextMove(n, r, c, grid);
    }

    public static void nextMove(Integer n, Integer r, Integer c, char[][] grid) {
        int deltaR = 0;
        int deltaC = 0;

        boolean found = false;

        for(int pr = 0; pr < n && !found; pr++) {
            for(int pc = 0; pc < n && !found; pc++) {
                if (grid[pr][pc] == 'p') {
                    deltaR = r - pr;
                    deltaC = c - pc;
                    found = true;
                }
            }
        }

        String moveRow = MOVE_DOWN;
        String moveCol = MOVE_RIGHT;

        if (deltaR < 0) {
            moveRow = MOVE_UP;
            deltaR = -deltaR;
        }
        if (deltaC < 0) {
            moveCol = MOVE_LEFT;
            deltaC = -deltaC;
        }
        for(int i = 0; i < deltaC; i++) {
            System.out.println(moveCol);
        }
        for(int i = 0; i < deltaR; i++) {
            System.out.println(moveRow);
        }
    }

}
