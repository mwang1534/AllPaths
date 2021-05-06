package com.company;

import java.util.Arrays;

public class AllPaths {
    private static int[][] result = new int[0][];

    public static int [][] allPaths(int[][] graph) {
        traverseGraph(graph, 0, new int[]{0});
        return result;
    }

    public static void traverseGraph (int[][] g, int current,  int[] currPath) {
        for (int i = 0; i < g[current].length; i++) {
            if (g[current][i] == g.length - 1) {
                //add destination node to current path
                int [] newPath = new int[currPath.length+1];
                for (int k = 0; k < currPath.length; k++) {
                    newPath[k] = currPath[k];
                }
                newPath[newPath.length-1] = g[current][i];

                //add current path to paths
                int[][] newPaths = new int[result.length+1][];
                for (int j = 0; j < result.length; j++) {
                    newPaths[j] = result[j];
                }
                newPaths[newPaths.length-1] = newPath;

                result = newPaths;
            }
            else {
                //add destination node to current path
                int[] newPath = new int[currPath.length+1];
                for (int j = 0; j < currPath.length; j++) {
                    newPath[j] = currPath[j];
                }
                newPath[newPath.length-1] = g[current][i];
                //go to next node
                traverseGraph(g, g[current][i], newPath);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allPaths(new int[][]{ {4,3,1}, {3,2,4}, {3}, {4}, {} })));
    }
}
