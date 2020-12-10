package com.ds.array;

public class SortZeroAndOne {

    static void sortZeroAndOne(int[] arr) {

        int len = arr.length;
        int left = 0, right = len - 1;

        while (left < right) {

            while (arr[left] == 0 & left < right)
                left ++;
            while(arr[right] ==1 && left < right)
                right --;

            // swap left and right indexes
            int temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        print(arr, len);
    }

    // function to print segregated array
    static void print(int arr[], int n) {
        System.out.print("Array after segregation is ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String args[]) {
        //int a[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int a[] = {0,1,1,1,1,0};
        sortZeroAndOne(a);
    }
}
