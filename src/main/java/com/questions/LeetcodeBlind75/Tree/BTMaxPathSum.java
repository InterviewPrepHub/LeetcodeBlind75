package com.questions.LeetcodeBlind75.Tree;

public class BTMaxPathSum {

    public static void main(String[] args) {
        TNode n = new TNode(-10);
        n.left = new TNode(9);
        n.right = new TNode(20);
        n.right.left = new TNode(15);
        n.right.right = new TNode(7);

        BTMaxPathSum s = new BTMaxPathSum();
        s.maxPathSum(n);
    }

    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TNode root) {
        pathSum(root);
        System.out.println(max_sum);
        return max_sum;
    }

    public int pathSum(TNode node) {
        if (node == null) return 0;
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        max_sum = Math.max((left+right+node.data), max_sum);
        return node.data + Math.max(left, right);
    }
}
