package com.questions.LeetcodeBlind75.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        TNode n = new TNode(-10);
        n.left = new TNode(9);
        n.right = new TNode(20);
        n.right.left = new TNode(15);
        n.right.right = new TNode(7);

        LevelOrderTraversal s = new LevelOrderTraversal();
        s.levelOrder(n);
    }

    private void levelOrder(TNode node) {

        Queue<TNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            TNode node1 = q.poll();
            System.out.println(node1.data);

            if(node1.left!=null) {
                levelOrder(node.left);
            }

            if(node1.right!=null) {
                levelOrder(node.right);
            }

        }


    }
}
