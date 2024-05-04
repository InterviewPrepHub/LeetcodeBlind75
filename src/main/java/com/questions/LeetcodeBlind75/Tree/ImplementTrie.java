package com.questions.LeetcodeBlind75.Tree;

public class ImplementTrie {

    TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();

    }

    public void insert(String word) {

        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;

    }

    public boolean search(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.endOfWord;
    }
}
