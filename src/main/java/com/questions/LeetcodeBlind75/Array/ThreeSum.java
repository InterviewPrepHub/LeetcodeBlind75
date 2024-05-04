package com.questions.LeetcodeBlind75.Array;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = 0;
//        Output: [[-1,-1,2],[-1,0,1]]

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];

            int start = i+1;
            int end = nums.length-1;

            while (start<end) {
                if (first+nums[start]+nums[end] == target) {
                    System.out.println(first+","+nums[start]+","+nums[end]);
                    break;
                }

                if (first+nums[start]+nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }

        }
    }
}
