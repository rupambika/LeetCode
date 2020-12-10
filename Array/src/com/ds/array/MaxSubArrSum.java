package com.ds.array;
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
//
//
//
//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.

public class MaxSubArrSum {
    static int maxSubArray(int nums []) {
        int len = nums.length;
        int maxSum = nums[0];
        int currSum=nums[0];

        for(int i=1; i< len ; i++){
            currSum = Math.max(nums[i]  , currSum+nums[i]);
            maxSum = Math.max( maxSum , currSum);
        }
        return maxSum;
    }

    public static void main(String args[]) {
       // int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int nums[] = {-1,-2,4};
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(a));

    }
}
