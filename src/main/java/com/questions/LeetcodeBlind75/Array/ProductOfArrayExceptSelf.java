package com.questions.LeetcodeBlind75.Array;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }

    private static void productExceptSelf(int[] arr) {

        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = res * arr[i];
        }

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = res/arr[i];
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
