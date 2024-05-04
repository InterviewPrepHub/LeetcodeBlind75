package com.questions.LeetcodeBlind75.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructBTFromPreOrderAndInOrderTraversal {

    public static void main(String[] args) {
        TNode n1 = new TNode(3);
        n1.left = new TNode(9);
        n1.right = new TNode(20);
        n1.right.left = new TNode(15);
        n1.right.right = new TNode(7);

        ConstructBTFromPreOrderAndInOrderTraversal c = new ConstructBTFromPreOrderAndInOrderTraversal();
        c.constructBT(n1);
    }

    private void constructBT(TNode root) {

        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> preOrderList = new ArrayList<>();

        buildInOrder(root, inOrderList);
        buildPreOrder(root, preOrderList);

        Integer[] inOrder = inOrderList.stream().toArray(Integer[]::new);
        Integer[] preOrder = preOrderList.stream().toArray(Integer[]::new);

        TNode root1 = constructBT(inOrder, inOrder, 0, inOrderList.size()-1);
        printInOrder(root1);
    }

    private void printInOrder(TNode root) {

        if (root == null) return;

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    int preIndex = 0;

    private TNode constructBT(Integer[] inOrder, Integer[] preOrder, int start, int end) {

        if(start > end) {
            return null;
        }

        //pick curr Node from preOrder using preIndex and increment preIndex
        TNode tNode = new TNode(preOrder[preIndex++]);

        //if this node has no children
        if(start == end) return tNode;

        //find the index of this node in Inorder traversal
        int index = search(inOrder, start, end, tNode.data);

        tNode.left = constructBT(inOrder, preOrder, start, index-1);
        tNode.right = constructBT(inOrder, preOrder, start+1, end);

        return tNode;

    }

    private int search(Integer[] inOrder, int start, int end, int data) {
        int i;
        for (i = start; i <= end; i++) {
            if(inOrder[i] == data) {
                return i;
            }
        }
        return i;
    }

    private void buildPreOrder(TNode root, List<Integer> preOrder) {
        if(root == null) {
            return;
        }
        preOrder.add(root.data);
        buildInOrder(root.left, preOrder);
        buildInOrder(root.right, preOrder);
    }

    private void buildInOrder(TNode root, List<Integer> inOrder) {

        if(root == null) {
            return;
        }
        buildInOrder(root.left, inOrder);
        inOrder.add(root.data);
        buildInOrder(root.right, inOrder);
    }
}
