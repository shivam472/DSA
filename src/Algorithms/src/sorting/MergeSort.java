package Algorithms.src.sorting;

public class MergeSort {

    public static void merge(int[] a, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;

        // create a temporary array
        int[] temp = new int[a.length];
        int k = l;

        while(i <= mid && j <= r) {
            if(a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            }
            else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

         // Copy remaining elements of right subarray if any
         while(i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of left subarray if any
        while(j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }

        // copy the temporary elements to the original array
        for(k = l; k <= r; k++) {
            a[k] = temp[k];
        }
    }

    // time complexity -> O(nlogn)
    public static void mergeSort(int[] a, int l, int r) {
        if(l < r) {
            // Find the middle point to divide the array into two halves
            int mid = (l+r)/2;

            // Call mergeSort for first half
            mergeSort(a, l, mid);

            // Call mergeSort for second half
            mergeSort(a, mid+1, r);

            // Merge the two halves sorted in step 2 and 3
            merge(a,  l, mid, r);
        } 
    }
    public static void main(String[] args) {
        //int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int[] arr = {468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492,
            496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 
            39, 370, 413, 168, 300, 36, 395, 204, 312, 323};

        mergeSort(arr, 0, arr.length-1);

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
