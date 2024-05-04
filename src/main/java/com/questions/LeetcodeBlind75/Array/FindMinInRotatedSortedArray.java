package com.questions.LeetcodeBlind75.Array;

public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int pivot = findPivot(arr);
        System.out.println(arr[pivot]);
    }

    private static int findPivot(int[] arr) {

        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int mid = left + (right-left)/2;

            if(arr[mid] > arr[mid+1]) {
                return mid+1;
            }
            if(arr[left] > arr[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
