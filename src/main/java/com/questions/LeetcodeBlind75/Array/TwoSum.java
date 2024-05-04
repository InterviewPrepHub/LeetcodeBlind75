package com.questions.LeetcodeBlind75.Array;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int start = 0;
        int end = nums.length-1;

        while(start < end) {

            if(Math.abs(nums[start] - nums[end]) == target) {
                System.out.println("["+nums[start]+","+nums[end]+"]");
            }
            if (Math.abs(nums[start] - nums[end]) > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
