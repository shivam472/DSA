package Algorithms.src.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 5, 9, 2};
        int n = arr.length;

        // time complexity -> O(n^2) but less number of operations than bubble sort
        for(int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }

        System.out.println("Sorted array: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
