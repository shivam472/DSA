import java.util.ArrayList;

// Max Heap implementation
public class Heap {

    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public void heapify(ArrayList<Integer> a) {
        int n = a.size();
        int i = n-1;
        int parentIndex;

        while(i > 0) {
            parentIndex = (i-1)/2;
            if(a.get(i) > a.get(parentIndex)) {
                swap(a, i, parentIndex);
                i = parentIndex;
            }
            else{
                break;
            }
        }
    }

    public void insert(ArrayList<Integer> a, int element) {
        a.add(element);
        heapify(a);
        System.out.println(element + " added to the heap");
    }
    
    public void printHeap(ArrayList<Integer> a) {
        for(int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int size = a.size();

        Heap h = new Heap();
        h.insert(a, 50);
        h.insert(a, 30);
        h.insert(a, 40);
        h.insert(a, 20);
        h.insert(a, 10);
        h.insert(a, 5);
        h.insert(a, 0);

        h.printHeap(a);

        h.insert(a, 60);
        h.printHeap(a);
        h.insert(a, 45);
        h.printHeap(a);

    }
}
