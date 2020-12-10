package com.ds.array;

public class ReverseArray {

    static void reverse(int a[]) {
        int len = a.length;
        int left = 0, right = len - 1;
        for (int i = 0; i < len / 2; i++) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        for (int x : a) {
            System.out.println(x + "");
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};

        reverse(arr);
    }
}
