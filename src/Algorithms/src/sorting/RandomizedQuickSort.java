package Algorithms.src.sorting;

import java.util.Random;

public class RandomizedQuickSort {

    // Fisher–Yates shuffle
    public static void shuffle(int[] a) {
        int index, temp;
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for(int i = a.length-1; i > 0; i--) {
            // Pick a random index from 0 to i
            index = r.nextInt(i+1);

            // if index = i, no need to swap
            if(index != i) {
                // Swap arr[i] with the element at random index
                temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
        }
    }

    public static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l;
        int j = h;

        while(i < j) {
            while(a[i] <= pivot && i <= h-1) i++;
            while(a[j] > pivot && j >= l) j--;

            if(i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // swap jth and lth element
        int temp = a[j];
        a[j] = a[l];
        a[l] = temp;

        return j; // partitioning position
    }

    // time complexity (worst case) -> O(nlogn)
    // space complexity (worst case) -> O(logn)
    // l -> low
    // h -> high
    public static void quickSort(int a[], int l, int h) {
        if(l < h) {
            int j = partition(a, l, h); // returns the partitioning position
            quickSort(a, l, j-1);
            quickSort(a, j+1, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        
        // To randomly shuffle the array to achieve best case complexity
        shuffle(arr);

        quickSort(arr, 0, arr.length-1);

        System.out.println("Sorted array: ");
        for(int x : arr) {
            System.out.print(x + " ");
        }

    }
}
