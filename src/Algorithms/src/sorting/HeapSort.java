package Algorithms.src.sorting;

public class HeapSort {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void heapify(int[] a, int n, int i) {
        int largest = i;
        int lChild = (2 * i) + 1;
        int rChild = (2 * i) + 2;

        if(lChild < n && a[lChild] > a[largest]) {
            largest = lChild;
        }

        if(rChild < n && a[rChild] > a[largest]) {
            largest = rChild;
        }

        if(largest != i) {
            swap(a, i, largest);

            heapify(a, n, largest);
        }
    }

    // time complexity -> O(nlogn)
    public static void heapSort(int[] a) {
        int n = a.length;

        // build a max heap (rearrange array)
        for(int i = (n-1)/2; i >= 0; i--) {
            heapify(a, n, i);
        }

        // in a max heap the largest element is always at the root
        // one by one extract an element from the heap
        for(int i = n-1; i > 0; i--) {
            // move the current root to the end
            swap(a, 0, i);

            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 4, 6, 13, 10, 9, 8, 15, 17 };
        heapSort(arr);

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
