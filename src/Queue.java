// doubly linked list implementation
public class Queue {
    private NodeDL front;
    private NodeDL back;
    private int size;

    public void enqueue(int data) {
        NodeDL newNode = new NodeDL(data);

        if(front == null) {
            front = newNode;
            back = newNode;
            size++;
        }
        else {
            newNode.prev = back;
            back.next = newNode;
            back = newNode;
            size++;
        }
    }

    public int dequeue() {
        if(front == null) {
            throw new Error("Empty Queue");
        }
        // Element to be dequeued
        int ele = front.data;
        front = front.next;
        size--;
        return ele;
    }

    public int peek() {
        if(front == null) {
            throw new Error("Empty Queue");
        }
        return front.data;
    }

    public boolean contains(int data) {
        if(front == null) {
            throw new Error("Empty Queue");
        }

        NodeDL tempNode = front;
        while(tempNode != null) {
            if(tempNode.data == data) 
                return true;
            tempNode = tempNode.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void print() {
        if(front == null) {
            throw new Error("Empty Queue");
        }

        NodeDL tempNode = front;
        while(tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
