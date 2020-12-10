package com.ds.array;

//Given an array of elements of length N, ranging from 0 to N – 1.
// All elements may not be present in the array.
// If the element is not present then there will be -1 present in the array.
// Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
public class ArrangeArrAt_I_thPosition {

    static void reArragne(int[] a) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] > 0 && a[i] != i) {
                int temp = a[a[i]];
                a[a[i]] = a[i];
                a[i] = temp;

            }
        }

        for(int x : a){
            System.out.println(x+ "");
        }
    }

    public static void main(String args[]) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        reArragne(arr);
    }

}
