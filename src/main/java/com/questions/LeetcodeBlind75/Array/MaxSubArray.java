package com.questions.LeetcodeBlind75.Array;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaxSubArray m = new MaxSubArray();
        int res = m.maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 1; i < nums.length; i++) {
            max_ending_here += nums[i];

            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i+1;
            }
        }

        System.out.println(start);
        System.out.println(end);

        return max_so_far;

    }
}
