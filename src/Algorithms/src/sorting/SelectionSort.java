package Algorithms.src.sorting;

public class SelectionSort {
    /*
    public static int findMin(int[] arr, int index) {
        int minIndex = index;
        for(int i = index + 1; i < arr.length; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    */
    public static void main(String[] args) {
        int[] arr = {4, 1, 9, 2, 3, 6};
        int n = arr.length;

        // time complexity -> O(n^2)
        for(int i = 0; i < n-1; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        System.out.println("Sorted array: ");
        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
