package com.questions.LeetcodeBlind75.Array;

import java.util.HashMap;

public class ContainDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,3};

        System.out.println(findDuplicate(arr));

    }

    private static boolean findDuplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return true;
            } else {
                map.put(arr[i], 1);
            }
        }

        return false;
    }
}
