public class CircularQueueRunner {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(20);
        q.enqueue(25);
        System.out.println("queue size: " + q.size());
        System.out.println("front element: " + q.peek());
        q.print();
        System.out.println("Element dequeued " + q.dequeue());
        System.out.println("front element: " + q.peek());
        System.out.println("queue size: " + q.size());
        q.enqueue(30);
        q.print();
        System.out.println("Element dequeued " + q.dequeue());
        System.out.println("Element dequeued " + q.dequeue());
        System.out.println("Element dequeued " + q.dequeue());
        System.out.println("Element dequeued " + q.dequeue());
        System.out.println("Element dequeued " + q.dequeue());
        System.out.println("queue size: " + q.size());
        q.print();
        

    }
}
