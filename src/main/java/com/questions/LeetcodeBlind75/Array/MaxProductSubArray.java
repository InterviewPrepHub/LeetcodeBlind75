package com.questions.LeetcodeBlind75.Array;

public class MaxProductSubArray {

    public static void main(String[] args) {
//        int[] arr = {2,3,-2,4};
        int[] arr = {-2,0,-1};
        maxProduct(arr);
    }

    private static void maxProduct(int[] arr) {

        int max_ending_here = arr[0];
        int max_so_far = Integer.MIN_VALUE;

        for (int i = 1; i <arr.length; i++) {
            max_ending_here *= arr[i];

            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }

            if (max_ending_here < 0 ) {
                max_ending_here = 1;
            }
        }

        System.out.println(max_so_far);
    }
}
