package Algorithms.src.sorting;

public class QuickSort {

    public static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l;
        int j = h;

        while(i < j) {
            while(a[i] <= pivot && i < h) i++;
            while(a[j] > pivot && j > l) j--;

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

    // time complexity (best case) -> O(nlogn)
    // time complexity (worst case) -> O(n^2) -> if the array is already sorted
    // space complexity (best case) -> O(logn)
    // space complexity (worst case) -> O(n^2) -> if the array is already sorted
    public static void quickSort(int a[], int l, int h) {
        if(l < h) {
            int j = partition(a, l, h); // returns the partitioning position
            quickSort(a, l, j-1);
            quickSort(a, j+1, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        quickSort(arr, 0, 8);

        System.out.println("Sorted array: ");
        for(int x : arr) {
            System.out.print(x + " ");
        }

    }
}
