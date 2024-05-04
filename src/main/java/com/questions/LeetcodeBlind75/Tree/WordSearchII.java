package com.questions.LeetcodeBlind75.Tree;

import java.util.*;

public class WordSearchII {

    TrieNode root;

    WordSearchII() {
        root = new TrieNode();
    }

    public void addWords(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            TrieNode node = curr.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                curr.children.put(ch, node);
            }
            curr = node;
        }

        curr.endOfWord = true;
    }

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();

        List<String> words = new ArrayList<>();
        words.add("ABC");
        words.add("ABFC");
        words.add("ABFD");
        words.add("ABCED");

        for (String word : words) {
            ws.addWords(word);
        }
    }





    /*TrieNode root;

    WordSearchII() {
        root = new TrieNode();
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        List<String> words = new ArrayList<>();
        words.add("ABC");
        words.add("ABFC");
        words.add("ABFD");
        words.add("ABCED");

        WordSearchII ws = new WordSearchII();

        for (String word : words) {
            ws.insert(word);
        }

        Set<String> found = ws.searchWords(board);
        System.out.println(found);

    }

    public void insert(String word) {

        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                current.children.put(ch,new TrieNode());
            }
            current = node;
        }
        current.endOfWord = true;

    }



    public Set<String> searchWords(char[][] board) {

        Set<String> foundWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root, foundWords,"", visited);
            }
        }

        return foundWords;
    }

    private void backtrack(char[][] board, int i, int j, TrieNode node, Set<String> foundWords, String currWord, boolean[][] visited) {

        char ch = board[i][j];
        if(i<0 || j<0 || i>= board.length || j>= board.length || visited[i][j] || !node.children.containsKey(ch)) {
            return;
        };

        node = node.children.get(ch);

        if (node.endOfWord) {
            currWord+=ch;
        }

        if (node.endOfWord) {
            foundWords.add(currWord);
            node.endOfWord = false;
        }

        visited[i][j] = true;
        backtrack(board, i+1, j, node, foundWords, currWord, visited);
        backtrack(board, i, j+1, node, foundWords, currWord, visited);
        backtrack(board, i-1, j, node, foundWords, currWord, visited);
        backtrack(board, i, j-1, node, foundWords, currWord, visited);
        visited[i][j] = false;
    }*/


}


