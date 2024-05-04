package com.questions.LeetcodeBlind75.Tree;

public class KthSmallestElementInBST {

    public static void main(String[] args) {

        TNode n1 = new TNode(5);
        n1.left = new TNode(1);
        n1.right = new TNode(8);
        n1.right.left = new TNode(7);
        n1.right.right = new TNode(9);

        KthSmallestElementInBST k = new KthSmallestElementInBST();
//        k.kthSmallest(n1, 2);

        k.kthSmallest1(n1,2);
    }

    //we need to track two different things
    //1. where in our inorder traversal we are on
    //2. result we want to return
    private int kthSmallest1(TNode root, int k) {
        int[] arr = new int[2]; //we will store two things. 1. where we are in thr tree, 2. result we want to return
        //arr[0] is the count and arr[1] = current node element
        inOrder(root, arr, k);

        return arr[1];
    }

    private void inOrder(TNode root, int[] arr, int k) {

        if(root == null) {
            return;
        }

        inOrder(root.left, arr, k);
        if(++arr[0] == k) {
            arr[1] = root.data;
            return;
        }
        inOrder(root.right, arr, k);
    }

    public int kthSmallest(TNode root, int k) {
        int count = 0;
        TNode curr = root;

        while (curr!=null) {

            if (curr.left == null) {
                count++;
                if (count == k) {
                    return curr.data;
                }
                curr = curr.right;
            } else {

                //keep the prev node as predecessor;
                TNode predecessor = curr.left;  //1

                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;   //5
                    curr = curr.left;   //1

                } else {
                    //restore original tree

                    predecessor.right = null;

                    count++;

                    if (count == k) {
                        return curr.data;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }

}
