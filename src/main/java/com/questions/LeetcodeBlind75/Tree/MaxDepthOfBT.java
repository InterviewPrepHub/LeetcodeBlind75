package com.questions.LeetcodeBlind75.Tree;

public class MaxDepthOfBT {

    public static void main(String[] args) {
        TNode n = new TNode(3);
        n.left = new TNode(9);
        n.right = new TNode(20);
        n.right.left = new TNode(15);
        n.right.right = new TNode(7);

        MaxDepthOfBT m = new MaxDepthOfBT();
        System.out.println(m.maxDepth(n));
    }

    public int maxDepth(TNode root) {

        if(root != null) {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return left > right ? left +1 : right+1;
        } else  {
            return 0;
        }


    }


}
