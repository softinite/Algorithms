package com.softinite.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Softinite on 2016-02-20.
 *
 * Source -> https://www.hackerrank.com/challenges/even-tree
 *
 * You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

 To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

 Input Format
 The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
 The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

 Output Format
 Print the answer, a single integer.

 Constraints
 2 <= N <= 100.

 Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

 Sample Input

 10 9
 2 1
 3 1
 4 3
 5 2
 6 1
 7 2
 8 6
 9 8
 10 8
 Sample Output

 2
 Explanation
 On removing edges (1, 3) and (1, 6), we can get the desired result.

 *
 */
public class EvenGraph {

    static class Node {
        List<Node> children;

        Node() {
            children = new ArrayList<>();
        }

    }

    static class Pair {
        int nbSubtrees = 0;
        int countAsChild = 1;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer n = console.nextInt();
        Integer m = console.nextInt();

        Map<Integer, Node> nodes = new HashMap<>();

        IntStream.range(0, m).forEach(i -> {
            int d = console.nextInt();
            int s = console.nextInt();
            Node sn = nodes.get(s);
            if (sn == null) {
                sn = new Node();
                nodes.put(s, sn);
            }
            Node dn = nodes.get(d);
            if (dn == null) {
                dn = new Node();
                nodes.put(d, dn);
            }
            sn.children.add(dn);
        });

        Node root = nodes.get(1);
        System.out.println(countEvenSubtrees(root).nbSubtrees - 1);
    }

    private static Pair countEvenSubtrees(Node root) {
        int nbChildren = root.children.size();
        if (nbChildren == 0) {
            return new Pair();
        }
        Pair result = new Pair();
        for(Node kid : root.children) {
            Pair pair = countEvenSubtrees(kid);
            result.nbSubtrees += pair.nbSubtrees;
            result.countAsChild += pair.countAsChild;
        }
        if (result.countAsChild > 0 && result.countAsChild % 2 == 0) {
            result.countAsChild = 0;
            result.nbSubtrees += 1;
        }
        return result;
    }

}