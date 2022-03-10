import java.util.ArrayList;

// Max Heap implementation
public class Heap {

    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public void insertionHeapify(ArrayList<Integer> a) {
        int n = a.size();
        int i = n-1;
        int parentIndex;

        // in max heap the key at root must be maximum among all the 
        // keys present in the binary heap and this property must be recursively
        // true for all nodes in the binary tree
        while(i > 0) {
            parentIndex = (i-1)/2;

            // if the key at the current node is greater than the parent node key
            // then swap the keys
            if(a.get(i) > a.get(parentIndex)) {
                swap(a, i, parentIndex);
                i = parentIndex;
            }

            // else the key is at it's correct place
            else{
                break;
            }
        }
    }

    // time complexity -> O(log n)
    public void insert(ArrayList<Integer> a, int element) {
        // add the new element to the end of the array
        a.add(element);

        // call heapify to maintain the heap property
        insertionHeapify(a);
        System.out.println(element + " added to the heap");
    }
    
    public void printHeap(ArrayList<Integer> a) {
        for(int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }


    public void deletionHeapify(ArrayList<Integer> a) {
        int n = a.size();

        int i = 0;
        int greaterChildIndex, leftChildIndex, rightChildIndex;
        while(i < n) {
            leftChildIndex = (2*i) + 1;
            rightChildIndex = (2*i) + 2;
            if(leftChildIndex >= n) {
                greaterChildIndex = rightChildIndex;
            }
            else if(rightChildIndex >= n) {
                greaterChildIndex = leftChildIndex;
            }
            else {
                // compare the left child and the right child and find the greater key
                greaterChildIndex = a.get(leftChildIndex) > a.get(rightChildIndex) ? leftChildIndex : rightChildIndex;
            }
            
            // compare the current key with the greater key
            // if the current key is smaller than the greater key 
            // then swap the current key and the greater key
            if(a.get(i) < a.get(greaterChildIndex)) {
                swap(a, i, greaterChildIndex);
                i = greaterChildIndex;
            }

            // else the key is at the right place
            else{
                break;
            }
            
        }
    }

    // time complexity -> O(log n)
    // we delete the root node from the heap
    public void delete(ArrayList<Integer> a) {
        // get the last element from the array
        int n = a.size();
        int lastElement = a.get(n-1);

        // to delete the root node we simply replace
        // the root node with the last node in the heap
        a.set(0, lastElement);

        // since we replace the root node with the last node
        // we have to delete the last node and decrease the size of the heap
        a.remove(n-1);

        // call the heapify method so the heap property remains satisfied
        deletionHeapify(a);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        Heap h = new Heap();
        h.insert(a, 50);
        h.insert(a, 30);
        h.insert(a, 40);
        h.insert(a, 10);
        h.insert(a, 5);
        h.insert(a, 20);
        h.insert(a, 25);

        h.printHeap(a);

        h.insert(a, 60);
        h.printHeap(a);
        h.insert(a, 45);
        h.printHeap(a);

        h.delete(a);
        h.printHeap(a);
    }
}
