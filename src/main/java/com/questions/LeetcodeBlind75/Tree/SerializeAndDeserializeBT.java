package com.questions.LeetcodeBlind75.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBT {

    public static void main(String[] args) {

        TNode n = new TNode(-10);
        n.left = new TNode(9);
        n.right = new TNode(20);
        n.right.left = new TNode(15);
        n.right.right = new TNode(7);

        SerializeAndDeserializeBT s = new SerializeAndDeserializeBT();
        String res = s.serializeTree(n);
        TNode node = s.deserializeTree(res);
        s.preOrder(node);

    }

    private void preOrder(TNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.data);
        preOrder(node.right);
    }

    public String serializeTree(TNode root) {

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        List<String> list = new ArrayList<>();

        while(!queue.isEmpty()) {

            TNode node = queue.poll();
            if (node==null) {
                list.add("#");
            }
            else {
                list.add(""+node.data);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return String.join(" ", list);
    }

    int t = 0;
    public TNode deserializeTree(String serialized) {
        String[] strArr = serialized.split(" ");
        return helper(strArr);

    }

    private TNode helper(String[] strArr) {
        if (strArr[t].equals("#")) {
            return null;
        }

        TNode root = new TNode(Integer.parseInt(strArr[t]));

        t++;
        root.left = helper(strArr);
        t++;
        root.right = helper(strArr);
        return root;
    }

}
