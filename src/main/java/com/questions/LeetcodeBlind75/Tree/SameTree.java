package com.questions.LeetcodeBlind75.Tree;

public class SameTree {

    public static void main(String[] args) {
        TNode n1 = new TNode(1);
        n1.left = new TNode(2);
        n1.right = new TNode(3);

        TNode n2 = new TNode(1);
        n2.left = new TNode(2);
        n2.right = new TNode(4);

        SameTree b = new SameTree();

        System.out.println(b.isSameTree(n1, n2));
    }

    public boolean isSameTree(TNode p, TNode q) {

        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if (p.data != q.data) {
            return false;
        }

        if(!isSameTree(p.left, q.left)){
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }

        return true;
    }
}
