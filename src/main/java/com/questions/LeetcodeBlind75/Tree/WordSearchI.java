package com.questions.LeetcodeBlind75.Tree;

import java.util.ArrayList;
import java.util.List;

public class WordSearchI {

    public static void main(String[] args) {

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        boolean res = findWordI(board, "ABCCED");
//        boolean res = findWord(board, "ABFE");
        System.out.println(res);


        /*List<String> words = new ArrayList<>();
        words.add("ABC");
        words.add("ABFC");
        words.add("ABFD");
        words.add("ABCED");
        
        boolean res1 = findWordII(board, words);*/
    }

    public static boolean findWordI(char[][] grid, String word) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        List<Character> path = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //check if ch exists in next horizontal or vertical
                if(isSafe(grid, word, i, j, 0, visited, path)) {
                    System.out.println(path);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isSafe(char[][] grid, String word, int i, int j, int index, boolean[][] visited, List<Character> path) {

        if(index == word.length()) return true;

        if (i>=grid.length || i<0 || j<0 || j>= grid.length || visited[i][j] || grid[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        path.add(grid[i][j]);

        if(isSafe(grid, word, i+1, j, index+1, visited, path) ||
        isSafe(grid, word, i, j+1, index+1, visited, path) ||
        isSafe(grid, word, i-1, j, index+1, visited, path) ||
        isSafe(grid, word, i, j-1, index+1, visited, path)) {
            return true;
        }


        visited[i][j] = false;
        path.remove(path.size() - 1);

        return false;
    }


}
