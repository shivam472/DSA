class item {
    int data;
    int priority;
}

// ordered or ascending
public class PriorityQueue {
    private int front, rear, size;
    private item[] queue = new item[10];

    PriorityQueue() {
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }
    
    private void shiftElements(item[] queue, int index) {
        for(int i = rear-1; i >= index; i--) {
            queue[i+1] = queue[i];
        }
    }

   public void enqueue(int d, int p) {
       // create a new element with data and priority
       item temp = new item();
       temp.data = d;
       temp.priority = p;

       // condition for the queue is full
       if(rear == queue.length-1) {
           throw new Error("Queue is full");
       }

       // condition for empty queue
       else if(front == -1 && rear == -1) {
           front = rear = 0;
           queue[front] = temp;
       }

       else {
           int i;
           for(i = front; i <= rear; i++) {
               if(temp.priority > queue[i].priority) {
                  shiftElements(queue, i);
                  break;
               }
           }
           queue[i] = temp;
       }
       size++;
       rear++;
   }

   public int dequeue() {
       int item = queue[front].data;
       front++;
       size--;
       return item;
   }

   public int peek() {
       return queue[front].data;
   }

   public int size() {
       return size;
   }

   public void print() {
       for(int i = front; i < rear; i++) {
           System.out.print(queue[i].data + " ");
       }
       System.out.println();
   }
}
