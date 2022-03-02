public class PriorityQueueRunner {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(10, 1);
        pq.enqueue(14, 4);
        pq.enqueue(16, 4);
        pq.enqueue(12, 3);

        pq.print();
        System.out.println("Size of the queue " + pq.size());
        System.out.println("highest priority element: " + pq.peek());
        System.out.println("---");

        System.out.println("Element dequeued from the pq: " + pq.dequeue());
        System.out.println("Element dequeued from the pq: " + pq.dequeue());
        pq.print();
        System.out.println("Size of the queue " + pq.size());
        System.out.println("highest priority element: " + pq.peek());
        System.out.println("---");

        pq.enqueue(8, 2);
        pq.print();
        System.out.println("Size of the queue " + pq.size());
        System.out.println("highest priority element: " + pq.peek());
    }
}
