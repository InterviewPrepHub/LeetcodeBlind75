package com.questions.LeetcodeBlind75.Tree;

public class InvertBT {

    public static void main(String[] args) {

        TNode n = new TNode(4);
        n.left = new TNode(2);
        n.left.left = new TNode(1);
        n.left.right = new TNode(3);
        n.right = new TNode(7);
        n.right.left = new TNode(6);
        n.right.right = new TNode(9);
        
        InvertBT r = new InvertBT();

        r.preOrder(n);
        r.invert(n);
        System.out.println();
        r.preOrder(n);
    }

    private void preOrder(TNode root) {

        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    private void invert(TNode root) {

        if (root == null) {
            return;
        }

        swap(root);
        invert(root.left);
        invert(root.right);
    }

    private void swap(TNode root) {

        TNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }
}
