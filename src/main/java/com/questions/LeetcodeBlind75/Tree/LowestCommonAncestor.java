package com.questions.LeetcodeBlind75.Tree;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TNode n1 = new TNode(6);
        n1.left = new TNode(2);
        n1.left.left = new TNode(0);
        n1.left.right = new TNode(4);
        n1.left.right.left = new TNode(3);
        n1.left.right.right = new TNode(5);
        n1.right = new TNode(8);
        n1.right.left = new TNode(7);
        n1.right.right = new TNode(9);

        LowestCommonAncestor l = new LowestCommonAncestor();
        l.lca(n1, new TNode(2), new TNode(7));

    }

    private TNode lca(TNode root, TNode A, TNode B) {

        if (root == null) {
            return null;
        }

        if(root == A || root == B) {
            return root;
        }

        TNode left = lca(root.left, A, B);
        TNode right = lca(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}























