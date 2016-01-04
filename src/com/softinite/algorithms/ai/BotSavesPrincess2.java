package com.softinite.algorithms.ai;

import java.util.Scanner;

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

    static void nextMove(int n, int r, int c, String [] grid){
        for(int pr = 0; pr < n; pr++) {
            String row = grid[pr];
            int pIndex = row.indexOf("p");
            if (pIndex >= 0) {
                int delta = c - pIndex;
                if (delta != 0) {
                    if (delta < 0) {
                        System.out.println(MOVE_RIGHT);
                    } else {
                        System.out.println(MOVE_LEFT);
                    }
                } else {
                    delta = r - pr;
                    if (delta < 0) {
                        System.out.println(MOVE_DOWN);
                    } else if (delta > 0) {
                        System.out.println(MOVE_UP);
                    }
                }
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

        nextMove(n,r,c,grid);

    }

}
