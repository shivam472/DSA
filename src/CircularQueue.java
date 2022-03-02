// Array implementation
public class CircularQueue {
    private int[] queue;
    private int front, rear, size;

    CircularQueue(int length) {
        this.queue = new int[length];
        this.front = this.rear = -1;
    }

    public void enqueue(int data) {
        // condition if queue is full
        if(front == 0 && rear == queue.length-1) {
            throw new Error("Queue is full");
        }
        // condition for empty queue
        else if(front == -1) {
            front = 0;
            rear = 0;
            queue[rear] = data;
        }

        else if(rear == queue.length - 1 && front > 0) {
            rear = 0;
            queue[rear] = data;
        }
        else {
            rear = rear + 1;
            queue[rear] = data;
        }
        size++;
    }

    public int dequeue() {
        // condition for empty queue
        if(size == 0) {
            throw new Error("Queue is empty");
        }

        int temp = queue[front];
        size--;

        // condition for single element left in the queue
        if(front == rear) 
            front = rear = -1;
            
        else if(front == queue.length-1)
            front = 0;
        
        else
            front++;

        // element dequeued from the queue
        return temp;
    }

    public int peek() {
        if(size == 0) {
            throw new Error("Queue is empty");
        }
        return queue[front];
    }

    public int size() {
        return size;
    }

    public boolean contains(int data) {
        for(int i = 0; i < queue.length; i++) {
            if(queue[i] == data)
                return true;
        }

        return false;
    }

    public void print() {
        // condition for empty queue
        if(size == 0) {
            throw new Error("Queue is empty");
        }

        int i = front;
        if(front >= rear) {
            while(i < queue.length) {
                System.out.print(queue[i] + " ");
                i++;
            }
            i = 0;
        }
        while(i <= rear) {
            System.out.print(queue[i] + " ");
            i++;
        }
        System.out.println();
    }
    
}
