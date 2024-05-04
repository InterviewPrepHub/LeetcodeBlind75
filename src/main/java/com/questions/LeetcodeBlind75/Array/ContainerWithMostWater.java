package com.questions.LeetcodeBlind75.Array;

public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(trapWater(heights));
    }

    private static int trapWater(int[] heights) {

        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;

        while (left < right) {
            int minHt = Math.min(heights[left], heights[right]);
            int currArea = minHt * (right-left);

            maxArea = Math.max(maxArea, currArea);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
