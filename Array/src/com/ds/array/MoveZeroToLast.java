package com.ds.array;

public class MoveZeroToLast {

    private static void moveZeroes(int nums[]) {
        int len = nums.length;

        for (int lastNonZero = 0,curr = 0; curr < len; curr++) {
            if (nums[curr] != 0) {
                swap(nums, lastNonZero, curr);
                lastNonZero++;
            }
        }

        for(int x : nums){
            System.out.println(x+ "");
        }
    }

    private static void swap(int nums[], int lastNonZero, int curr) {
        int temp = nums[curr];
        nums[curr] = nums[lastNonZero];
        nums[lastNonZero] = temp;
    }


    public static void main(String args[]) {
        int nums[] = {1, 0, 9, 0, 0, 12, 0};

        moveZeroes(nums);
    }
}
