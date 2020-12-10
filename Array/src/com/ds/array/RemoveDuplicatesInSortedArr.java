package com.ds.array;
//Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
//
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4]

public class RemoveDuplicatesInSortedArr {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len-1; i++) {

            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j++] = nums[len - 1];
        return j;

    }

    public static void main(String args[]) {
        int[] nums = {1, 1, 2};
        int length = removeDuplicates(nums);
        System.out.println(length);
    }
}
