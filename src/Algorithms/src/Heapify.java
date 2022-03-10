package Algorithms.src;

// Java program to build a heap from a given array
public class Heapify {
    
    public static void heapify(int[] a, int n, int i) {
        int largest = i; // Initialize the root as largest
        int lChild = (2 * i) + 1;
        int rChild = (2 * i) + 2;

        // If left child is larger than root
        if(lChild < n && a[lChild] > a[largest]) {
            largest = lChild;
        }

        // If right child is larger than root
        if(rChild < n && a[rChild] > a[largest]) {
            largest = rChild;
        }

        // If largest is not root then swap
        if(largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(a, n, largest);
        }
    }

    // time complexity -> O(n)
    // Function to build a Max-Heap from the Array
    public static void buildHeap(int[] a, int n) {
        // Index of last non-leaf node
        int startIndex = (n-1)/2;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for(int i = startIndex; i >= 0; i--) {
            heapify(a, n, i);
        }
    }
    
    public static void printHeap(int[] a) {
        for(int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
 
        int n = arr.length;
 
        buildHeap(arr, n);
 
        printHeap(arr);
    }
}
