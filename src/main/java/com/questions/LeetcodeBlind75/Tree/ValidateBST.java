package com.questions.LeetcodeBlind75.Tree;

public class ValidateBST {

    public static void main(String[] args) {

        TNode n1 = new TNode(5);
        n1.left = new TNode(1);
        n1.right = new TNode(8);
        n1.right.left = new TNode(7);
        n1.right.right = new TNode(9);

        ValidateBST v = new ValidateBST();
        System.out.println(v.checkBST(n1));
    }


    boolean checkBST(TNode root) {

        int max_val = Integer.MAX_VALUE;
        int min_val = Integer.MIN_VALUE;

        return checkBST(root, min_val, max_val);
    }

    boolean checkBST(TNode root, int min_val, int max_val) {
        if(root == null) {
            return true;
        }

        if (root.data < min_val || root.data > max_val) {
            return false;
        }

        boolean left = checkBST(root.left, min_val, root.data-1);
        boolean right = checkBST(root.right, root.data+1, max_val);

        if (left == true && right == true) {
            return true;
        } else {
            return false;
        }
    }

}
