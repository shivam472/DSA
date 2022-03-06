package Algorithms.src.sorting;

public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 8, 6, 10};

        int n = arr.length;

        // time complexity -> O(n^2)
        for(int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j+1] < arr[j]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swapped) break;
        }

        System.out.println("Sorted array: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
