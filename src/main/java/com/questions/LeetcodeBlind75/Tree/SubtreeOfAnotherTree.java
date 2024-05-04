package com.questions.LeetcodeBlind75.Tree;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

        TNode n1 = new TNode(3);
        n1.left = new TNode(4);
        n1.left.left = new TNode(1);
        n1.left.right = new TNode(2);
        n1.right = new TNode(5);

        TNode n2 = new TNode(4);
        n2.left = new TNode(1);
        n2.right = new TNode(2);

        SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();
        boolean res1 = s.isSubtree(n1, n2);
        System.out.println(res1);
    }

    boolean res;

    public boolean isSubtree(TNode root, TNode subRoot) {

        if (root == null) return false;
        if (isSubtree1(root,subRoot)) {
            return true;
        }

        //recursively check if the left and right side of tree has substree
        return isSubtree1(root.left, subRoot) || isSubtree1(root.right, subRoot);

    }

    public boolean isSubtree1(TNode root, TNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data != subRoot.data) {
            return false;
        }

        if(!isSubtree1(root.left, subRoot.left)) {
            return false;
        }

        if (!isSubtree1(root.right, subRoot.right)) {
            return false;
        }

        return true;
    }
}
